package com.example.gaslon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class home extends AppCompatActivity {
    ImageView btOrderhome,btStorehome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btOrderhome = findViewById(R.id.orderhome);
        btStorehome = findViewById(R.id.storehome);

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
    }
}
