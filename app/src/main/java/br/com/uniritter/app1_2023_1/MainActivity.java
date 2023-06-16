package br.com.uniritter.app1_2023_1;


import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button entrar = findViewById(R.id.Btn_Entrar);
        Button cadastrar = findViewById(R.id.Btn_Cadastrar);


        //btn1_2.setOnClickListener(this);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastrarActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}