package br.com.uniritter.app1_2023_1;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        ImageView Image = findViewById(R.id.myImageView);
        Glide.with(this)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/393.gif")
                .into(Image);


    }
}
