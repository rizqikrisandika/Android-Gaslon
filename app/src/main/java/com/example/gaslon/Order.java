package com.example.gaslon;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.gaslon.Model.OrderData;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Order extends AppCompatActivity {
    private Button orderorder;
    private DatabaseReference database;
    private TextView price;
    private ElegantNumberButton qtGas, qtGalon, qtIsiulang;
    private List<OrderData> cart = new ArrayList<>();
    private FirebaseAuth mAuth;
    private userDB user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        database = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        qtGas = findViewById(R.id.number_button_gas);
        qtGalon = findViewById(R.id.number_button_galon);
        qtIsiulang = findViewById(R.id.number_button_isiulang);
        orderorder = findViewById(R.id.orderorder);

        orderorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmpty(qtGas.getNumber()) && !isEmpty(qtGalon.getNumber()))
                    submitOrder(new OrderData(qtGas.getNumber(),
                            qtGalon.getNumber(),
                            qtIsiulang.getNumber(),
                            mAuth.getCurrentUser().getEmail()));
            }
        });

    }

    private boolean isEmpty(String s){
        return TextUtils.isEmpty(s);
    }

    private void submitOrder(OrderData orderData){
        database.child("Order").push().setValue(orderData).addOnSuccessListener(this, aVoid -> {
            qtGas.getNumber();
            qtGalon.getNumber();
            qtIsiulang.getNumber();
            mAuth.getCurrentUser().getEmail();
            Snackbar.make(findViewById(R.id.orderorder), "Pemesanan Berhasil", Snackbar.LENGTH_LONG).show();
        });
    }

    //public void totalPrice(){
        //int totalP = 0;
        //for (OrderData orderData:)
        //totalP+=((Integer.parseInt(qtGas.getNumber()))*27500)+((Integer.parseInt(qtGalon.getNumber()))*30500);

        //Locale locale = new Locale("en","US");
        //NumberFormat frmt = NumberFormat.getNumberInstance(locale);

        //price.setText(frmt.format(totalP));
    //}
}
