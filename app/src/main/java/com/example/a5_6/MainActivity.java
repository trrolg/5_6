package com.example.a5_6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Button like;
    private Button unlike;
    private Button save;
    private TextView liki;
    private int num;
    private EditText email;
    private EditText pass;
    private EditText passc;
    private Button confirm;
    private char check;
    private TextView alert;
    private String semail;
    private String spass;
    private String spassc;
    private Button zobacz;
    private String lastl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        like = findViewById(R.id.like);
        unlike = findViewById(R.id.unlike);
        liki = findViewById(R.id.liki);

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num++;
                updatel();
            }
        });

        unlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num == 0){
                    updatel();
                } else {
                    num--;
                    updatel();
                }
            }
        });

        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        passc = findViewById(R.id.passc);
        confirm = findViewById(R.id.confirm);
        alert = findViewById(R.id.alert);
        zobacz = findViewById(R.id.zobacz);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                semail = email.getText().toString();
                spass = pass.getText().toString();
                spassc = passc.getText().toString();

                if (!semail.contains("@")){
                    Toast.makeText(MainActivity.this, "Nieprawidłowy adres e-mail", Toast.LENGTH_SHORT).show();
                } else if (!Objects.equals(spass, spassc)){
                    Toast.makeText(MainActivity.this, "hasło nie zgadza się", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Zarejestrowano: " + semail, Toast.LENGTH_SHORT).show();
                    lastl = semail;
                }
            }
        });

        zobacz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.setText(lastl);
            }
        });



    }
    private void updatel(){
        liki.setText(num + " polubień");
    }

}