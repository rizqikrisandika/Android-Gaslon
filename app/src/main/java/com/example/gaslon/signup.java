package com.example.gaslon;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class signup extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "SignUpActivity";
    private EditText mName,mEmail, mPassword,mPhone;
    private Button mSignupBtn;
    private FirebaseAuth fAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mName = findViewById(R.id.name);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mPhone = findViewById(R.id.phone);
        mSignupBtn = findViewById(R.id.signup);

        fAuth = FirebaseAuth.getInstance();

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mSignupBtn.setOnClickListener(this);
    }
    private void signUp() {
        Log.d(TAG, "signUp");
        if (!validateForm()) {
            return;
        }

        //showProgressDialog();
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();

        fAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUser:onComplete:" + task.isSuccessful());
                        //hideProgressDialog();

                        if (task.isSuccessful()) {
                            onAuthSuccess(Objects.requireNonNull(task.getResult().getUser()));
                        } else {
                            Toast.makeText(signup.this, "Sign Up Failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void onAuthSuccess(FirebaseUser user) {
        String name = usernameFromEmail(user.getEmail());
        String phone = phoneFromEmail(user.getEmail());
        // membuat User admin baru
        writeNewAdmin(user.getUid(), name, user.getEmail(), phone);

        // Go to MainActivity
        startActivity(new Intent(signup.this, login.class));
        finish();
    }

    private String usernameFromEmail(String email) {
        if (email.contains("@")) {
            return email.split("@")[0];
        } else {
            return email;
        }
    }

    private String phoneFromEmail(String email) {
        String phone = "979234567";
        if (email.contains("@")) {
            return phone;
        }else {
            return phone;
        }
    }

    private void writeNewAdmin(String userId, String prfName, String prfEmail, String prfPhone) {
        userDB admin = new userDB(prfName,prfEmail,prfPhone);

        mDatabase.child("user").child(userId).setValue(admin);
    }

    private boolean validateForm() {
        boolean result = true;
        if (TextUtils.isEmpty(mName.getText().toString())) {
            mName.setError("Required");
            result = false;
        } else {
            mEmail.setError(null);
        }

        if (TextUtils.isEmpty(mEmail.getText().toString())) {
            mEmail.setError("Required");
            result = false;
        } else {
            mEmail.setError(null);
        }

        if (TextUtils.isEmpty(mPassword.getText().toString())) {
            mPassword.setError("Required");
            result = false;
        } else {
            mPassword.setError(null);
        }

        if (TextUtils.isEmpty(mPhone.getText().toString())) {
            mPhone.setError("Required");
            result = false;
        } else {
            mPhone.setError(null);
        }

        return result;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btnsignup) {
            signUp();
        }
    }
}
