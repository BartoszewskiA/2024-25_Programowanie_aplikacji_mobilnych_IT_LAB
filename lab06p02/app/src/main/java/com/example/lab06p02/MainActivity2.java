package com.example.lab06p02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    ImageView iv_01, iv_02, iv_03, iv_04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        iv_01 = findViewById(R.id.a2_im_01);
        iv_02 = findViewById(R.id.a2_im_02);
        iv_03 = findViewById(R.id.a2_im_03);
        iv_04 = findViewById(R.id.a2_im_04);
        iv_01.setImageResource(R.drawable.g01);
        iv_02.setImageResource(R.drawable.g02);
        iv_03.setImageResource(R.drawable.g03);
        iv_04.setImageResource(R.drawable.g04);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                int wybrany=0;
                if(id == R.id.a2_im_01)
                    wybrany = R.drawable.g01;
                else if (id == R.id.a2_im_02)
                    wybrany = R.drawable.g02;
                else if (id == R.id.a2_im_03)
                    wybrany = R.drawable.g03;
                else if (id == R.id.a2_im_04)
                    wybrany = R.drawable.g04;
                Intent intent = new Intent();
                intent.putExtra("wybrany", wybrany);
                setResult(RESULT_OK, intent);
                finish();
            }
        };
        iv_01.setOnClickListener(listener);
        iv_02.setOnClickListener(listener);
        iv_03.setOnClickListener(listener);
        iv_04.setOnClickListener(listener);

    }
}