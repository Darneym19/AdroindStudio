package com.mobie.application;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String TAG = "ActividadTres";
    private EditText ladouno,ladodos;
    private TextView resultado;
    private Button calcular, ButtonGoogle, Bttelefono;
    private String numeroTelefono = "3106537162";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"--OnCreate--");
        ladouno = (EditText)findViewById(R.id.l1);
        ladodos = (EditText)findViewById(R.id.l2);
        resultado = (TextView)findViewById(R.id.resultado);
        calcular = (Button)findViewById(R.id.Calcular);
        ButtonGoogle = (Button)findViewById(R.id.Google);
        Bttelefono = (Button)findViewById(R.id.telefono);

        ButtonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irGoogle(view);
            }
        });
        Bttelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telefono(view);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"Entre A OnStart");
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float Ladouno = Float.parseFloat(ladouno.getText().toString());
                float Ladodos = Float.parseFloat(ladodos.getText().toString());
                float result = Ladouno*Ladodos;
                resultado.setText(String.valueOf(result));
                nextView(view);
            }
        });
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"Entre A OnRestart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"Entre A OnResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"Entre A OnPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"Entre A OnStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"Entre A OnDestroy");
    }
    public void nextView(View view){
        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("dato1", ladouno.getText().toString());
        i.putExtra("dato2", ladodos.getText().toString());
        i.putExtra("dato3", resultado.getText().toString());
        startActivity(i);
    }
    public void irGoogle(View View){
        Intent irGoogle = new Intent(Intent.ACTION_VIEW); // Abre una nueva pantalla
        irGoogle.setData(Uri.parse("https://www.google.com"));
        startActivity(irGoogle);
    }
    public void telefono(View view){
        Intent telefono = new Intent(Intent.ACTION_DIAL); // Abre la app de telefono
        telefono.setData(Uri.parse("tel: " + numeroTelefono));
        if (telefono.resolveActivity(getPackageManager()) !=null){
            startActivity(telefono);
        }
    }
}
