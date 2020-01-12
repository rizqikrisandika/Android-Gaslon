package com.example.gaslon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Store extends AppCompatActivity {
    CardView btTokoA,btTokoB,btTokoC,btTokoD,btTokoE,btTokoF;
    String kodeToko = " ";
    DatabaseReference database;
    TextView nmTokoA,nmTokoB,nmTokoC,nmTokoD,nmTokoE,nmTokoF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        database = FirebaseDatabase.getInstance().getReference().child("Toko");

        nmTokoA = findViewById(R.id.NametokoA);
        nmTokoB = findViewById(R.id.NametokoB);
        nmTokoC = findViewById(R.id.NametokoC);
        nmTokoD = findViewById(R.id.NametokoD);
        nmTokoE = findViewById(R.id.NametokoE);
        nmTokoF = findViewById(R.id.NametokoF);

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
}
