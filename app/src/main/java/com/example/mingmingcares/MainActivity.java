package com.example.mingmingcares;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    Button button;
    TextView textView;
    FirebaseUser user;

    private ImageButton idLabTest;
    private ImageButton idBuyMedicine;
    private ImageButton idFindDoctor;
    private ImageButton idHealthArticles;
    private ImageButton idOrderDetails;
    private ImageButton idExit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idLabTest = findViewById(R.id.idLabTest);
        idBuyMedicine = findViewById(R.id.idBuyMedicine);
        idFindDoctor = findViewById(R.id.idFindDoctor);
        idHealthArticles = findViewById(R.id.idHealthArticles);
        idOrderDetails = findViewById(R.id.idOrderDetails);
        idExit = findViewById(R.id.idExit);
        auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.logout);
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();


        idLabTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the new activity
                Intent intent = new Intent(MainActivity.this, Health.class);
                startActivity(intent);
                finish();
            }
        });

        idBuyMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the new activity
                Intent intent = new Intent(MainActivity.this, Diet.class);
                startActivity(intent);
                finish();
            }
        });

        idHealthArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the new activity
                Intent intent = new Intent(MainActivity.this, Community.class);
                startActivity(intent);
                finish();
            }
        });

        idOrderDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the new activity
                Intent intent = new Intent(MainActivity.this, Schedule.class);
                startActivity(intent);
                finish();
            }
        });

        idExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the new activity
                Intent intent = new Intent(MainActivity.this, Veterinarian.class);
                startActivity(intent);
                finish();
            }
        });

        idFindDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Grooming.class);
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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }


        });
    }


}