package com.example.lab01p01;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editText01, editText02, editText03;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText01 = findViewById(R.id.editText01);
        editText02 = findViewById(R.id.editText02);
        editText03 = findViewById(R.id.editText03);
        textView = findViewById(R.id.textView);
    }

    public void kasuj(View view) {
    }

    public void licz(View view) {
//        double a = Double.parseDouble(editText01.getText().toString());
//        double b = Double.parseDouble(editText02.getText().toString());
//        double c = Double.parseDouble(editText03.getText().toString());
        double a=0,b=0,c=0;
        String s ="";
        try {
            a = Double.parseDouble(editText01.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Należy wypełnic pole \"a\"", Toast.LENGTH_LONG).show();
            return;
        }
        try {
            b = Double.parseDouble(editText02.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Należy wypełnic pole \"b\"", Toast.LENGTH_LONG).show();
            return;
        }
        try {
            c = Double.parseDouble(editText03.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Należy wypełnic pole \"c\"", Toast.LENGTH_LONG).show();
            return;
        }

        double delta = b * b - 4 * a * c;
        s+="Delta=";
        s+=String.valueOf(delta);
        if (delta < 0) {
            s+="\nBrak rozwiązań";
            textView.setText(s);
            return;
        }
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        x1= Math.round(x1*1000)/1000.0;
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
        x2= Math.round(x2*1000)/1000.0;
        s+="\nx1="+x1;
        s+="\nx2="+x2;
        textView.setText(s);
    }
}