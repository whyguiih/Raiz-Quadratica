package com.example.raizquadratica;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textResult = findViewById(R.id.textResult);

        // Recebe os dados da MainActivity
        double a = getIntent().getDoubleExtra("a", 0);
        double b = getIntent().getDoubleExtra("b", 0);
        double c = getIntent().getDoubleExtra("c", 0);

        // Calcula o Discriminante (Delta)
        double delta = (b * b) - (4 * a * c);

        StringBuilder sb = new StringBuilder();
        sb.append("Equação: ").append(a).append("x² + ").append(b).append("x + ").append(c).append(" = 0\n");
        sb.append("Delta (Δ): ").append(delta).append("\n\n");

        // 1. Raízes e Corte no Eixo das Abscissas (X)
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            sb.append("Raízes Reais: Sim (Duas distintas)\n");
            sb.append("x1 = ").append(String.format("%.2f", x1)).append("\n");
            sb.append("x2 = ").append(String.format("%.2f", x2)).append("\n");
            sb.append("Corte no eixo X: A parábola corta o eixo X em dois pontos: (").append(String.format("%.2f", x1)).append(", 0) e (").append(String.format("%.2f", x2)).append(", 0)\n");
        } else if (delta == 0) {
            double x = -b / (2 * a);
            sb.append("Raízes Reais: Sim (Uma raiz real dupla)\n");
            sb.append("x = ").append(String.format("%.2f", x)).append("\n");
            sb.append("Corte no eixo X: A parábola tangencia o eixo X no ponto: (").append(String.format("%.2f", x)).append(", 0)\n");
        } else {
            sb.append("Raízes Reais: Não existem no conjunto dos Reais (Raízes Complexas)\n");
            sb.append("Corte no eixo X: A parábola NÃO intercepta o eixo das abscissas.\n");
        }
        sb.append("\n");

        // 2. Concavidade da Parábola
        sb.append("Concavidade: Voltada para ").append(a > 0 ? "CIMA (a > 0)" : "BAIXO (a < 0)").append("\n\n");

        // 3. Vértice da Parábola
        double xv = -b / (2 * a);
        double yv = -delta / (4 * a);
        sb.append("Vértice: V(").append(String.format("%.2f", xv)).append(", ").append(String.format("%.2f", yv)).append(")\n\n");

        // 4. Corte no Eixo das Ordenadas (Y)
        sb.append("Ponto de corte no eixo Y: (0, ").append(c).append(")\n");

        // 5. Como é o corte no eixo Y
        String comportamentoY = "passa pelo vértice (tangente paralela ao eixo X)";
        if (b > 0) {
            comportamentoY = "passa crescendo (ramo ascendente)";
        } else if (b < 0) {
            comportamentoY = "passa decrescendo (ramo descendente)";
        }
        sb.append("Como corta o eixo Y: A curva corta o eixo Y e ").append(comportamentoY).append(" no momento do corte.\n");

        textResult.setText(sb.toString());
    }
}