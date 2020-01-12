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

public class orderdetail extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private DatabaseReference profileUser;
    private String currentUserId;
    private TextView qtGas,qtGalon,qtisi;
    private TextView hrgGas,hrgGalon,hrgIsi,total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderdetail);

        qtGalon = findViewById(R.id.jmlhGalon);
        qtGas = findViewById(R.id.jmlhGas);
        qtisi = findViewById(R.id.jmlhGalon2);
        hrgGas = findViewById(R.id.txtHargaDetailGas);
        hrgGalon = findViewById(R.id.txtHargaDetailGalon);
        hrgIsi = findViewById(R.id.txtHargaDetailIsi);
        total = findViewById(R.id.totalDetail);

        mAuth = FirebaseAuth.getInstance();
        profileUser = FirebaseDatabase.getInstance().getReference().child("Order");

        profileUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    String totalGas = dataSnapshot.child("quantityGas").getValue().toString();
                    String totalGalon = dataSnapshot.child("quantityGalon").getValue().toString();
                    String totalIsi = dataSnapshot.child("quantityIsiUlang").getValue().toString();

                    qtGas.setText(totalGas);
                    qtGalon.setText(totalGalon);
                    qtisi.setText(totalIsi);
                    hrgGas.setText((Integer.parseInt(totalGas))*27500);
                    hrgGalon.setText((Integer.parseInt(totalGalon))*30500);
                    hrgIsi.setText((Integer.parseInt(totalIsi))*30500);
                    total.setText(((Integer.parseInt(totalGas))*27500)+((Integer.parseInt(totalGalon))*30500)+((Integer.parseInt(totalIsi))*30500));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
