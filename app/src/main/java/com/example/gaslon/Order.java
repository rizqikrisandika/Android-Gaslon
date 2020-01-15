package com.example.gaslon;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.gaslon.Model.NamaToko;
import com.example.gaslon.Model.OrderData;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Order extends AppCompatActivity {
    private Button orderorder;
    private DatabaseReference database, toko;
    private TextView namaToko;
    private ElegantNumberButton qtGas, qtGalon, qtIsiulang;
    private FirebaseAuth mAuth;
    private userDB user;
    private String kode, Toko = " ",idToko;
    private NamaToko currentStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        database = FirebaseDatabase.getInstance().getReference();
        toko = FirebaseDatabase.getInstance().getReference().child("Toko");
        mAuth = FirebaseAuth.getInstance();

        qtGas = findViewById(R.id.number_button_gas);
        qtGalon = findViewById(R.id.number_button_galon);
        qtIsiulang = findViewById(R.id.number_button_isiulang);
        orderorder = findViewById(R.id.orderorder);
        namaToko = findViewById(R.id.toko);

        Bundle kodeToko = getIntent().getExtras();
        kode = kodeToko.getString(Toko);
        switch (kode){
            case "01":
                database.child("Toko").child("01").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            String myName = dataSnapshot.child("Name").getValue().toString();

                            namaToko.setText(myName);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case "02":
                database.child("Toko").child("02").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            String myName = dataSnapshot.child("Name").getValue().toString();

                            namaToko.setText(myName);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case "03":
                database.child("Toko").child("03").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            String myName = dataSnapshot.child("Name").getValue().toString();

                            namaToko.setText(myName);
                        };
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case "04":
                database.child("Toko").child("04").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            String myName = dataSnapshot.child("Name").getValue().toString();

                            namaToko.setText(myName);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case "05":
                database.child("Toko").child("05").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            String myName = dataSnapshot.child("Name").getValue().toString();

                            namaToko.setText(myName);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case "6":
                database.child("Toko").child("06").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            String myName = dataSnapshot.child("Name").getValue().toString();

                            namaToko.setText(myName);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
        }

        orderorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmpty(qtGas.getNumber()) && !isEmpty(qtGalon.getNumber()))
                    submitOrder(new OrderData(database.child("Toko").child(kode).getKey(),
                            qtGas.getNumber(),
                            qtGalon.getNumber(),
                            qtIsiulang.getNumber(),
                            mAuth.getCurrentUser().getEmail()));

                String code = kode, idtoko = " ";
                Intent i = new Intent(Order.this, Orderloc.class);
                i.putExtra(idtoko, code);
                startActivity(i);
            }
        });

    }

    private boolean isEmpty(String s){
        return TextUtils.isEmpty(s);
    }

    private void submitOrder(OrderData orderData){
        database.child("Order").child(kode).setValue(orderData).addOnSuccessListener(this, aVoid -> {
            database.child("Toko").child(kode).getKey();
            qtGas.getNumber();
            qtGalon.getNumber();
            qtIsiulang.getNumber();
            mAuth.getCurrentUser().getEmail();
            Snackbar.make(findViewById(R.id.orderorder), "Pemesanan Berhasil", Snackbar.LENGTH_LONG).show();
        });
    }
}
