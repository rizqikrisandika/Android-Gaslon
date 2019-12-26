package com.example.gaslon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private EditText etEmail,etPassword;
    private Button btLogin,btregisterlog;
    private FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.emaillog);
        etPassword = findViewById(R.id.passwordlog);
        btLogin = findViewById(R.id.loginlog);
        btregisterlog = findViewById(R.id.registerlog);

        Auth = FirebaseAuth.getInstance();

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    etEmail.setError("Email harus diisi");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    etPassword.setError("Password harus diisi");
                    return;
                }

                if(password.length() < 6) {
                    etPassword.setError("Password harud lebih dari 6 karakter");
                    return;
                }

                Auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(login.this, "login berhasil", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),home.class));
                        }else {
                            Toast.makeText(login.this, "Login gagal, periksa kembali" , Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        btregisterlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this,signup.class);
                startActivity(i);
            }
        });
    }
}
