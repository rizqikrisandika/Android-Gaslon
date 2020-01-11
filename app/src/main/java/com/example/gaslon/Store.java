package com.example.gaslon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Store extends AppCompatActivity {
    CardView btTokoA,btTokoB,btTokoC,btTokoD,btTokoE,btTokoF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        btTokoA = findViewById(R.id.tokoA);
        btTokoB = findViewById(R.id.tokoB);
        btTokoC = findViewById(R.id.tokoC);
        btTokoD = findViewById(R.id.tokoD);
        btTokoE = findViewById(R.id.tokoE);
        btTokoF = findViewById(R.id.tokoF);
        btTokoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Store.this, Order.class);
                startActivity(i);
            }
        });
    }
}
