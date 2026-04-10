package com.example.raizquadratica;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editA = findViewById(R.id.editA);
        EditText editB = findViewById(R.id.editB);
        EditText editC = findViewById(R.id.editC);
        Button btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(v -> {
            String strA = editA.getText().toString();
            String strB = editB.getText().toString();
            String strC = editC.getText().toString();

            if (strA.isEmpty() || strB.isEmpty() || strC.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os coeficientes.", Toast.LENGTH_SHORT).show();
                return;
            }

            double a = Double.parseDouble(strA);
            if (a == 0) {
                Toast.makeText(this, "O coeficiente 'a' não pode ser zero em uma equação quadrática.", Toast.LENGTH_SHORT).show();
                return;
            }

            double b = Double.parseDouble(strB);
            double c = Double.parseDouble(strC);

            // Abre a segunda Activity enviando os dados
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("a", a);
            intent.putExtra("b", b);
            intent.putExtra("c", c);
            startActivity(intent);
        });
    }
}