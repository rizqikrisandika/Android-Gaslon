package com.example.gaslon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class home extends AppCompatActivity {
    private ImageView btOrderhome,btStorehome,btLiveChat, imgProfil;
    private TextView textName;
    private String currentUserId;
    private FirebaseAuth mAuth;
    private DatabaseReference profileUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btOrderhome = findViewById(R.id.orderhome);
        btStorehome = findViewById(R.id.storehome);
        imgProfil = findViewById(R.id.imgProfil);
        textName = findViewById(R.id.profil_nama_home);
        mAuth = FirebaseAuth.getInstance();
        currentUserId = mAuth.getCurrentUser().getUid();
        profileUser = FirebaseDatabase.getInstance().getReference().child("user").child(currentUserId);

        profileUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String mName = dataSnapshot.child("prfName").getValue().toString();

                textName.setText(mName);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btStorehome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(home.this, Store.class);
                startActivity(i);
            }
        });
        btOrderhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(home.this, Order.class);
                startActivity(i);
            }
        });
        imgProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(home.this, profile.class);
                startActivity(i);
            }
        });
    }
}
