package com.testeepistemic.leandro.testeleandro;



import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import android.widget.EditText;



import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    private EditText editLogin;
    private EditText editSenha;
    private CardView btn_login;
    private String msg;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    //atributo da classe.
    private AlertDialog alerta;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        inicializaVariaves();
        inicia();
        if (editLogin.getText().toString().equals("")){
            verificarUsuarioSalvo();
        }



    }
    private void inicia(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (validUser()) {
                    UsuarioSalvo();
                    Intent intent = new Intent(MainActivity.this,PrincipalActivity.class);
                    startActivity(intent);

                } else {
                    showError();
                }
            }
        });


    }

    private void inicializaVariaves() {


        editLogin = findViewById(R.id.activity_login_et_login);
        editSenha = findViewById(R.id.activity_login_et_password);
        btn_login = findViewById(R.id.activity_login_btn_login);


    }



    private void showError() {
        Toast.makeText(MainActivity.this, R.string.var_senha_vazia, Toast.LENGTH_SHORT).show();
    }

    private boolean validUser() {

        String user = editLogin.getText().toString().trim();
        String password = editSenha.getText().toString().trim();

        if (user.isEmpty()) {
            msg = getString(R.string.var_user_vazio);
            return false;
        }

        if (password.isEmpty()) {
            msg = getString(R.string.var_senha_vazia);
            return false;
        }
        if (isEmail(user)) {
            if(isValidPassword(password)){
                return true;
            }else{
                msg = getString(R.string.var_erro_senha);
                return false;
            }
        }

        else{
            msg = getString(R.string.var_msg_erro_user);
            return false;
        }


    }


    private boolean isEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();

    }


    private boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.find();
    }



    private void UsuarioSalvo() {

        sharedPreferences = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(getString(R.string.pref_text), editLogin.getText().toString());
        editor.apply();


        editLogin.setText("");

        }
        private void verificarUsuarioSalvo(){

            sharedPreferences = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
            String result = sharedPreferences.getString(getString(R.string.pref_text), "");
            editLogin.setText( result);
        }
        public void senha(View view){
           esqueceuSenha();
        }

        public void conta(View view){
            Toast.makeText(this, "Hiperlink para criar conta", Toast.LENGTH_SHORT).show();
        }

    private void esqueceuSenha() {

        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Esqueci minha senha");
        //define a mensagem
        builder.setMessage("Digite seu Email ? ");
        //define um botão como positivo

        final EditText input = new EditText(this);
        builder.setView(input);
        verificarUsuarioSalvo();

        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alerta.cancel();
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }

    public void termo(View view){
        Toast.makeText(this, "Termo de segurança", Toast.LENGTH_SHORT).show();
    }

}



