package br.com.uniritter.app1_2023_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mAuth = FirebaseAuth.getInstance();

        TextView Email = findViewById(R.id.Txt_Email);
        TextView Senha = findViewById(R.id.Txt_ConfirmarSenha);
        Button Entrar = findViewById(R.id.Btn_Entrar);


        Entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidarLogin();
            }
        });

    }

    private void ValidarLogin(){
        TextView Email = findViewById(R.id.Txt_Email);
        TextView Senha = findViewById(R.id.Txt_ConfirmarSenha);

        Email.getText().toString().trim();
        Senha.getText().toString().trim();

        String EmailConvert = Email.getText().toString();
        String SenhaConvert = Senha.getText().toString();


        if(!Email.getText().toString().isEmpty() || !Senha.getText().toString().isEmpty()){
            LoginFirebase(EmailConvert, SenhaConvert);

        }else {
            Toast.makeText(this, "Informe o seu E-mail e Senha!", Toast.LENGTH_LONG).show();
        }

    }

    private void LoginFirebase(String email, String senha){
        mAuth.signInWithEmailAndPassword(
                email, senha
        ).addOnCompleteListener(task -> {
            if(task.isSuccessful()){

                startActivity(new Intent(this, ProcurarPokemonActivity.class));
                finish();
            }
        });
    }

}
