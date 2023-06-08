package com.example.appamst5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtUsuario,edtClave;
    private Button btnLogin, btnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtClave = (EditText) findViewById(R.id.edtClave);

        btnLogin = (Button) findViewById(R.id.btnlogin);
        btnRegistrarse = (Button) findViewById(R.id.btnRegistro);
        Intent intencion = new Intent (getApplicationContext(),MenuSlideActivity.class);
        starActivity(intencion);
    }

    public void registrarse(View view){
        Intent intent = new Intent(this, formulario_registro.class);
        startActivity(intent);
    }

    public void Login(View view){
        if(edtUsuario.getText().length() == 0 || edtClave.getText().length() == 0){
            Toast toast = Toast.makeText(getApplicationContext(),"Ingrese usuario y contrasena", Toast.LENGTH_SHORT);
            toast.show();
        } else if (edtUsuario.getText().length() == 0) {
            Toast toast = Toast.makeText(getApplicationContext(),"Ingrese usuario", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if (edtClave.getText().length() == 0) {
            Toast toast = Toast.makeText(getApplicationContext(),"Ingrese contrasena", Toast.LENGTH_SHORT);
            toast.show();
        }else {
            Intent intent = new Intent(this, PrincipalPage.class);
            startActivity(intent);
        }
    }

    public void onClick(View v){
        if (v.getId() == R.id.btnlogin){
            Log.d("mensaje","ingreso");
        }else if (v.getId() == R.id.btnRegistro);
    }
}