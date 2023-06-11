package br.com.uniritter.app1_2023_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


public class CadastrarActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar);

        mAuth = FirebaseAuth.getInstance();

        //Email
        TextView Email = findViewById(R.id.Txt_Email);
        TextView ConfirmarEmail = findViewById(R.id.Txt_ConfirmEmail);

        //Senha
        TextView Senha = findViewById(R.id.Txt_Senha);
        TextView ConfirmarSenha = findViewById(R.id.Txt_ConfirmarSenha);

        Button Entrar = findViewById(R.id.Btn_Entrar);
        ImageButton BtnVoltar = findViewById(R.id.BtnVoltar);

        BtnVoltar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });



        Entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidarDados();

            }
        });

    }

    private void ValidarDados(){

        //Email
        TextView Email = findViewById(R.id.Txt_Email);
        TextView ConfirmarEmail = findViewById(R.id.Txt_ConfirmEmail);

        //Senha
        TextView Senha = findViewById(R.id.Txt_Senha);
        TextView ConfirmarSenha = findViewById(R.id.Txt_ConfirmarSenha);


        String EmailConvert = Email.getText().toString();
        String SenhaConvert = Senha.getText().toString();


        if(Email.getText().toString().equals(ConfirmarEmail.getText().toString())){
           if(Senha.getText().toString().equals(ConfirmarSenha.getText().toString())){
               CriarContaFirebase(EmailConvert, SenhaConvert);
           } else {
               Toast.makeText(this, "As Senhas não correspondem", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Os E-mails não correspondem", Toast.LENGTH_LONG).show();
        }
    }

    private void CriarContaFirebase(String email, String senha){
        mAuth.createUserWithEmailAndPassword(
                email, senha
        ).addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                startActivity(new Intent(this, ProcurarPokemonActivity.class));
            }else{
                Toast.makeText(this, "Criação de conta falhou, aguarde e tente novamente! ", Toast.LENGTH_LONG).show();
            }
        });
    }
}
