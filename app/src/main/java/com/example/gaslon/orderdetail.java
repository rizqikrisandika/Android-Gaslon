package com.example.gaslon;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gaslon.Model.OrderData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.NumberFormat;
import java.util.Locale;

public class orderdetail extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private DatabaseReference idorder;
    private String currentUserId;
    private String kode, Toko = " ";
    private TextView qtGas,qtGalon,qtisi;
    private TextView hrgGas,hrgGalon,hrgIsi,total;
    OrderData orderData;

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

        Bundle kodeToko = getIntent().getExtras();
        kode = kodeToko.getString(Toko);

        idorder = FirebaseDatabase.getInstance().getReference().child("Order").child(kode);

        idorder.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    String totalGas = dataSnapshot.child("quantityGas").getValue().toString();
                    String totalGalon = dataSnapshot.child("quantityGalon").getValue().toString();
                    String totalIsi = dataSnapshot.child("quantityIsiUlang").getValue().toString();

                    qtGas.setText(totalGas);
                    qtGalon.setText(totalGalon);
                    qtisi.setText(totalIsi);

                    totalhasil(totalGas,totalGalon,totalIsi);
                //orderData = dataSnapshot.getValue(OrderData.class);


                //qtGas.setText(orderData.getQuantityGas());
                //qtGalon.setText(orderData.getQuantityGalon());
                //qtisi.setText(orderData.getQuantityIsiUlang());

                    //total.setText(((Integer.parseInt(orderData.getQuantityGas()))*27500)+((Integer.parseInt(orderData.getQuantityGalon()))*30500)+((Integer.parseInt(orderData.getQuantityIsiUlang()))*30500));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void totalhasil(String a, String b, String c){
        int totalall = 0;
        totalall = (((Integer.parseInt(a))*27500)+((Integer.parseInt(b))*30500)+((Integer.parseInt(c))*30500));

        Locale locale = new Locale("en","US");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

        total.setText(fmt.format(totalall));
    }
}
