package com.example.androidcalculator;

import static java.lang.Float.parseFloat;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textoNumeros;
    TextView textoResultado;

    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;

    Button btnSuma;
    Button btnResta;
    Button btnMultiplicar;
    Button btnDividir;
    Button btnCos;
    Button btnSin;
    Button btnTan;
    Button btnDeg;
    Button btnRad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoNumeros = (TextView) findViewById(R.id.textoNumeros);
        textoResultado = (TextView) findViewById(R.id.textoResultado);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        btnSuma = (Button) findViewById(R.id.btnSuma);
        btnResta = (Button) findViewById(R.id.btnResta);
        btnMultiplicar = (Button) findViewById(R.id.btnMultiplicar);
        btnDividir = (Button) findViewById(R.id.btnDividir);
        btnCos =  (Button) findViewById(R.id.btnCos);
        btnSin =  (Button) findViewById(R.id.btnSin);
        btnTan =  (Button) findViewById(R.id.btnTan);
        btnDeg =  (Button) findViewById(R.id.btnDeg);
        btnRad =  (Button) findViewById(R.id.btnRad);
    }
    public void onClickNumeros(View view){
        if (textoResultado.getText().length()!=0){
            textoNumeros.setText(null);
            textoResultado.setText(null);
        }

        if (view.getId()==(btnSuma.getId()))
            textoNumeros.setText(textoNumeros.getText()+" + ");

        if (view.getId()==(btnResta.getId()))
            textoNumeros.setText(textoNumeros.getText()+" - ");

        if (view.getId()==(btnMultiplicar.getId()))
            textoNumeros.setText(textoNumeros.getText()+" x ");

        if (view.getId()==(btnDividir.getId()))
            textoNumeros.setText(textoNumeros.getText()+" / ");

        if (view.getId()==(btnCos.getId()))
            textoNumeros.setText(textoNumeros.getText()+" cos ");

        if (view.getId()==(btnSin.getId()))
            textoNumeros.setText(textoNumeros.getText()+" sin ");

        if (view.getId()==(btnTan.getId()))
            textoNumeros.setText(textoNumeros.getText()+" tan ");

        if (view.getId()==(btnDeg.getId()))
            textoNumeros.setText(textoNumeros.getText()+" deg ");

        if (view.getId()==(btnRad.getId()))
            textoNumeros.setText(textoNumeros.getText()+" rad ");

        if (view.getId()==(btn0.getId()))
            textoNumeros.setText(textoNumeros.getText()+"0");

        if (view.getId()==(btn1.getId()))
            textoNumeros.setText(textoNumeros.getText()+"1");

        if (view.getId()==(btn2.getId()))
            textoNumeros.setText(textoNumeros.getText()+"2");

        if (view.getId()==(btn3.getId()))
            textoNumeros.setText(textoNumeros.getText()+"3");

        if (view.getId()==(btn4.getId()))
            textoNumeros.setText(textoNumeros.getText()+"4");

        if (view.getId()==(btn5.getId()))
            textoNumeros.setText(textoNumeros.getText()+"5");

        if (view.getId()==(btn6.getId()))
            textoNumeros.setText(textoNumeros.getText()+"6");

        if (view.getId()==(btn7.getId()))
            textoNumeros.setText(textoNumeros.getText()+"7");

        if (view.getId()==(btn8.getId()))
            textoNumeros.setText(textoNumeros.getText()+"8");

        if (view.getId()==(btn9.getId()))
            textoNumeros.setText(textoNumeros.getText()+"9");

    }

    public void onClickTrigonometric(View view){
        if (textoNumeros.getText().length()==0)
            onClickNumeros(view);
    }

    public void calcularTrigonometric(String[] values){
        double angle = parseFloat(values[2]);
        double result = 0.0;

        if (values[3].equals("deg"))
            angle = Math.toRadians(parseFloat(values[2]));

        switch (values[1]){
            case "cos":
                result = Math.cos(angle);
                break;

            case "sin":
                result = Math.sin(angle);
                break;

            case "tan":
                result = Math.tan(angle);
                break;
        }
        textoResultado.setText("= "+Double.toString(result));

    }


    public void onClickResultado(View view){
        String[] values = textoNumeros.getText().toString().split(" ");

        if (values[1].equals("sin")||values[1].equals("cos")||values[1].equals("tan")){
            calcularTrigonometric(values);
        }

        else {
            float result = parseFloat(values[0]);

            for (int i = 1; i < values.length; i++) {
                if (values[i].equals("+"))
                    result = result + parseFloat(values[i + 1]);

                if (values[i].equals("-"))
                    result = result - parseFloat(values[i + 1]);

                if (values[i].equals("x"))
                    result = result * parseFloat(values[i + 1]);

                if (values[i].equals("/")) {
                    if (parseFloat(values[i + 1]) == 0.0)
                        textoResultado.setText("ERROR DIVISION");
                    else
                        result = result / parseFloat(values[i + 1]);
                }
            }

            textoResultado.setText("= " + Float.toString(result));
        }

    }

    public void onClickOperacion(View view){
        if (textoNumeros.getText().length()==0);
        else {
            String[] values = textoNumeros.getText().toString().split(" ");
            int i = values.length - 1;

            if (values[i].equals("+") || values[i].equals("-") || values[i].equals("x") || values[i].equals("/"));
            else
                onClickNumeros(view);
        }
    }

    public void onClickClear(View view){
        textoNumeros.setText(null);
        textoResultado.setText(null);
    }

}