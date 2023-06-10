package com.example.qrcodeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class cadastro extends AppCompatActivity {
    private Button cadastra;
    private TextView ratext;
    private TextView senhatext;

    private DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        cadastra= findViewById(R.id.button);
        ratext= findViewById(R.id.editTextTextRA);
        senhatext= findViewById(R.id.editTextTextpassword);
        DatabaseReference cadastros=reference.child("Cadastro");
        cadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastros.child(ratext.getText().toString()).child("senha").setValue(senhatext.getText().toString());
                Intent ir=new Intent(cadastro.this,MainActivity.class);
                startActivity(ir);
            }
        });

    }
}