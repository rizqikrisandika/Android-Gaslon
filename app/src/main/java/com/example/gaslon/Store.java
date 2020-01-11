package com.example.gaslon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Store extends AppCompatActivity {
    private CardView btTokoA,btTokoB,btTokoC,btTokoD,btTokoE,btTokoF;
    private String kodeToko = " ";
    private DatabaseReference database;
    private TextView nmTokoA,nmTokoB,nmTokoC,nmTokoD,nmTokoE,nmTokoF;
    private TextView addTokoA,addTokoB,addTokoC,addTokoD,addTokoE,addTokoF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        database = FirebaseDatabase.getInstance().getReference().child("Toko");

        detailToko();

        nmTokoA = findViewById(R.id.NametokoA);
        nmTokoB = findViewById(R.id.NametokoB);
        nmTokoC = findViewById(R.id.NametokoC);
        nmTokoD = findViewById(R.id.NametokoD);
        nmTokoE = findViewById(R.id.NametokoE);
        nmTokoF = findViewById(R.id.NametokoF);

        addTokoA = findViewById(R.id.AddtokoA);
        addTokoB = findViewById(R.id.AddtokoB);
        addTokoC = findViewById(R.id.AddtokoC);
        addTokoD = findViewById(R.id.AddtokoD);
        addTokoE = findViewById(R.id.AddtokoE);
        addTokoF = findViewById(R.id.AddtokoF);

        btTokoA = findViewById(R.id.tokoA);
        btTokoB = findViewById(R.id.tokoB);
        btTokoC = findViewById(R.id.tokoC);
        btTokoD = findViewById(R.id.tokoD);
        btTokoE = findViewById(R.id.tokoE);
        btTokoF = findViewById(R.id.tokoF);

        btTokoA.setOnClickListener(new Click());
        btTokoB.setOnClickListener(new Click());
        btTokoC.setOnClickListener(new Click());
        btTokoD.setOnClickListener(new Click());
        btTokoE.setOnClickListener(new Click());
        btTokoF.setOnClickListener(new Click());

    }
    public class Click implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tokoA:
                    try {
                        String kode = "1";
                        Intent i = new Intent(Store.this, Order.class);
                        i.putExtra(kodeToko, kode);
                        startActivity(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.tokoB:
                    try {
                        String kode = "2";
                        Intent i = new Intent(Store.this, Order.class);
                        i.putExtra(kodeToko, kode);
                        startActivity(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.tokoC:
                    try {
                        String kode = "3";
                        Intent i = new Intent(Store.this, Order.class);
                        i.putExtra(kodeToko, kode);
                        startActivity(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.tokoD:
                    try {
                        String kode = "4";
                        Intent i = new Intent(Store.this, Order.class);
                        i.putExtra(kodeToko, kode);
                        startActivity(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.tokoE:
                    try {
                        String kode = "5";
                        Intent i = new Intent(Store.this, Order.class);
                        i.putExtra(kodeToko, kode);
                        startActivity(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.tokoF:
                    try {
                        String kode = "6";
                        Intent i = new Intent(Store.this, Order.class);
                        i.putExtra(kodeToko, kode);
                        startActivity(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    public void detailToko(){
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String namatoko1 = dataSnapshot.child("01").child("Name").getValue().toString();
                String addtoko1 = dataSnapshot.child("01").child("Address").getValue().toString();
                String namatoko2 = dataSnapshot.child("02").child("Name").getValue().toString();
                String addtoko2 = dataSnapshot.child("02").child("Address").getValue().toString();
                String namatoko3 = dataSnapshot.child("03").child("Name").getValue().toString();
                String addtoko3 = dataSnapshot.child("03").child("Address").getValue().toString();
                String namatoko4 = dataSnapshot.child("04").child("Name").getValue().toString();
                String addtoko4 = dataSnapshot.child("04").child("Address").getValue().toString();
                String namatoko5 = dataSnapshot.child("05").child("Name").getValue().toString();
                String addtoko5 = dataSnapshot.child("05").child("Address").getValue().toString();
                String namatoko6 = dataSnapshot.child("06").child("Name").getValue().toString();
                String addtoko6 = dataSnapshot.child("06").child("Address").getValue().toString();

                nmTokoA.setText(namatoko1);
                addTokoA.setText(addtoko1);
                nmTokoB.setText(namatoko2);
                addTokoB.setText(addtoko2);
                nmTokoC.setText(namatoko3);
                addTokoC.setText(addtoko3);
                nmTokoD.setText(namatoko4);
                addTokoD.setText(addtoko4);
                nmTokoE.setText(namatoko5);
                addTokoE.setText(addtoko5);
                nmTokoF.setText(namatoko6);
                addTokoF.setText(addtoko6);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
