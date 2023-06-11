package br.com.uniritter.app1_2023_1;

import static br.com.uniritter.app1_2023_1.R.id.BtnVoltar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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
        ImageButton Voltar = findViewById(BtnVoltar);
        TextView CriarConta = findViewById(R.id.Btn_CriarConta);

        CriarConta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(), CadastrarActivity.class));
            }
        });


        Entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidarLogin();
            }
        });

        Voltar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }

    private void ValidarLogin(){
        TextView Email = findViewById(R.id.Txt_Email);
        TextView Senha = findViewById(R.id.Txt_ConfirmarSenha);

        String EmailConvert = Email.getText().toString();
        String SenhaConvert = Senha.getText().toString();


        if(!EmailConvert.isEmpty() && !SenhaConvert.isEmpty()){
            LoginFirebase(EmailConvert, SenhaConvert);

        }else {
            Toast.makeText(this, "Informe o seu E-mail e Senha!", Toast.LENGTH_LONG).show();
        }

    }

    private void LoginFirebase(String email, String senha){
        Toast.makeText(this, "Entrou no metodo de login", Toast.LENGTH_LONG).show();
        Toast.makeText(this, "o email e senha é :" + email + senha, Toast.LENGTH_LONG).show();


        mAuth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Se o login for bem-sucedido, você pode prosseguir com o código desejado
                        startActivity(new Intent(this, ProcurarPokemonActivity.class));
                        finish();
                    } else {
                        // Caso contrário, você pode lidar com o erro ou exibir uma mensagem de falha de login
                        Toast.makeText(this, "Falha no login: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

}
