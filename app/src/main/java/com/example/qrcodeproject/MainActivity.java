package com.example.qrcodeproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private Button cadastra1;
    private Button login;
    private EditText ratext1;
    private EditText senhatext1;

    private DatabaseReference reference= FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login= findViewById(R.id.button2);
        cadastra1= findViewById(R.id.button3);
        ratext1= findViewById(R.id.textView3);
        senhatext1= findViewById(R.id.textView4);
        DatabaseReference cadastros=reference.child("Cadastro");

        cadastra1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ir=new Intent(MainActivity.this,cadastro.class);
                startActivity(ir);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View view) {

                cadastros.child(ratext1.getText().toString()).child("senha").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if(snapshot.getValue()==null){

                        }else
                        if(senhatext1.getText().toString().equals(snapshot.getValue().toString())){
                            login();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                       String erro= error.getMessage();
                       Toast.makeText(MainActivity.this,""+erro,Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

    }
    public void login(){
        Intent ir=new Intent(MainActivity.this,qrcode.class);
        startActivity(ir);
    }
}