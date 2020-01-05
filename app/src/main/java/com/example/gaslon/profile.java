package com.example.gaslon;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {
    private TextView mName, mEmail,mPhone,profilNama,profilHp;
    private FirebaseAuth mAuth;
    private FirebaseDatabase getDB;
    private DatabaseReference profileUser;
    private String currentUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profilNama = findViewById(R.id.profil_nama);
        profilHp = findViewById(R.id.profil_hp);
        mName = findViewById(R.id.nama);
        mEmail = findViewById(R.id.profileEmail);
        mPhone = findViewById(R.id.no_hp);
        mAuth = FirebaseAuth.getInstance();
        currentUserId = mAuth.getCurrentUser().getUid();
        profileUser = FirebaseDatabase.getInstance().getReference().child("user").child(currentUserId);

        profileUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    String myName = dataSnapshot.child("prfName").getValue().toString();
                    String myEmail = dataSnapshot.child("prfEmail").getValue().toString();
                    String myPhone = dataSnapshot.child("prfPhone").getValue().toString();

                    mName.setText(myName);
                    mEmail.setText(myEmail);
                    mPhone.setText(myPhone);
                    profilNama.setText(myName);
                    profilHp.setText(myPhone);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
