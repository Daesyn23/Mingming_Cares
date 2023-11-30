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

public class Grooming extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;
    TextView textView;
    Button buttonBack;

    private ImageButton bgG1;
    private ImageButton bgG2;
    private ImageButton bgG3;
    private ImageButton bgG4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grooming);

        bgG1 = findViewById(R.id.bgG1);
        bgG2 = findViewById(R.id.bgG2);
        bgG3 = findViewById(R.id.bgG3);
        bgG4 = findViewById(R.id.bgG4);


        auth = FirebaseAuth.getInstance();
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();
        buttonBack = findViewById(R.id.backToHome);


        bgG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the new activity
                Intent intent = new Intent(Grooming.this, EarCleaning.class);
                startActivity(intent);
                finish();
            }
        });

        bgG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the new activity
                Intent intent = new Intent(Grooming.this, NailTrimming.class);
                startActivity(intent);
                finish();
            }
        });

        bgG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the new activity
                Intent intent = new Intent(Grooming.this, FurTrimming.class);
                startActivity(intent);
                finish();
            }
        });

        bgG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the new activity
                Intent intent = new Intent(Grooming.this, Bathing.class);
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