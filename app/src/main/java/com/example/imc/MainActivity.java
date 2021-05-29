package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Double4;
import android.view.View;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_IMC = "com.example.imc.imc;";
    public static final String EXTRA_PESO = "com.example.imc.peso;";
    public static final String EXTRA_ALTURA = "com.example.imc.altura;";
    public static final String EXTRA_SERIO = "com.example.imc.serio;";

    private EditText editPeso;
    private EditText editAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editAltura = findViewById(R.id.editAltura);
        editPeso = findViewById(R.id.editPeso);
    }

    public void calculaIMC(View view) {
        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());
        double imc;

        imc = peso / (altura * altura);

        String serio;
        if (imc < 17) serio = "Muito abaixo do peso";
        else if (imc < 18.50) serio = "Abaixo do peso";
        else if (imc < 25) serio = "Peso Normal";
        else if (imc < 30) serio = "Acima do Peso";
        else if (imc < 35) serio = "Obesidade I";
        else if (imc < 40) serio = "Obesidade II (severa)";
        else serio = "Obesidade III (mórbida)";


        Intent intent = new Intent(this, secondActivity.class);
        intent.putExtra(EXTRA_ALTURA, altura);
        intent.putExtra(EXTRA_PESO, peso);
        intent.putExtra(EXTRA_IMC, imc);
        intent.putExtra(EXTRA_SERIO, serio);
        startActivity(intent);
    }
}