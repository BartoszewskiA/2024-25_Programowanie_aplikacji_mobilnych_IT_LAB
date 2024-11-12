package com.example.lab02p01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    Button bt_dodaj, bt_odejmij;
    TextView tv_licznik;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bt_dodaj = findViewById(R.id.bt_dodaj);
        bt_odejmij = findViewById(R.id.bt_odejmij);
        tv_licznik = findViewById(R.id.tv_licznik);

        dodaj_sluchacze();
    }

    private void dodaj_sluchacze() {
        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if(id == R.id.bt_dodaj)
                    i++;
                else
                    i--;
                tv_licznik.setText(String.valueOf(i));
            }
        };
        bt_dodaj.setOnClickListener(sluchacz);
        bt_odejmij.setOnClickListener(sluchacz);
        tv_licznik.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                i=0;
                tv_licznik.setText(String.valueOf(i));
                return false;
            }
        });
    }

}