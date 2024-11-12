package com.example.lab03p01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] obrazki ={R.drawable.owoc01, R.drawable.owoc02, R.drawable.owoc03, R.drawable.owoc04};
    Random random = new Random();
    ImageView iv_01, iv_02, iv_03;
    TextView tv_kredyt, tv_seria;
    Button btn_graj, btn_nowa_gra;
    int kredyt = 50;
    int licznik =0;
    int poz_1=0, poz_2=0, poz_3=0;
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
        iv_01 = findViewById(R.id.iv_01);
        iv_02 = findViewById(R.id.iv_02);
        iv_03 = findViewById(R.id.iv_03);
        tv_kredyt = findViewById(R.id.tv_kredyt);
        tv_seria = findViewById(R.id.tv_seria);
        btn_graj = findViewById(R.id.btn_graj);
        btn_nowa_gra = findViewById(R.id.btn_nowa_gra);
        tv_kredyt.setText(kredyt+" $$");
        tv_seria.setText(String.valueOf(licznik));
        btn_graj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gra();
            }
        });

    }

    private void gra() {
        poz_1 = random.nextInt(obrazki.length);
        poz_2 = random.nextInt(obrazki.length);
        poz_3 = random.nextInt(obrazki.length);

        iv_01.setImageResource(obrazki[poz_1]);
        iv_02.setImageResource(obrazki[poz_2]);
        iv_03.setImageResource(obrazki[poz_3]);

    }
}