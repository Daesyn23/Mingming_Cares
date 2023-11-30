package com.example.mingmingcares;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Health extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;
    TextView textView;
    Button buttonBack;

    private ImageButton bgCL1;
    private ImageButton bgCL2;
    private ImageButton bgCL3;
    private ImageButton bgCL4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        bgCL1 = findViewById(R.id.bgCL1);
        bgCL2 = findViewById(R.id.bgCL2);
        bgCL3 = findViewById(R.id.bgCL3);
        bgCL4 = findViewById(R.id.bgCL4);


        auth = FirebaseAuth.getInstance();
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();
        buttonBack = findViewById(R.id.backToHome);


        bgCL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the new activity
                Intent intent = new Intent(Health.this, Vaccination.class);
                startActivity(intent);
                finish();
            }
        });

        bgCL2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the new activity
                Intent intent = new Intent(Health.this, Operation.class);
                startActivity(intent);
                finish();
            }
        });

        bgCL3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the new activity
                Intent intent = new Intent(Health.this, Medicines.class);
                startActivity(intent);
                finish();
            }
        });

        bgCL4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the new activity
                Intent intent = new Intent(Health.this, Allergies.class);
                startActivity(intent);
                finish();
            }
        });




        if (user == null){
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }
        else {
            textView.setText(user.getEmail());

        }

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }


        });
    }
}