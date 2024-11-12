package com.example.lab04p01_atlas;

import android.content.Context;
import android.content.SharedPreferences;
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

public class MainActivity extends AppCompatActivity {


    int[] grafiki = new int[] {
            R.drawable.muchomor,
            R.drawable.borowik,
            R.drawable.maslak
    };
    String[] nazwy;
    String[] opisy;
    int pozycja = 0;
    ImageView imageView;
    TextView textView_tytul, textView_opis;
    Button button_next, button_back;

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

        nazwy = getResources().getStringArray(R.array.names);
        opisy = getResources().getStringArray(R.array.descriptions);
        imageView = findViewById(R.id.imageView01);
        textView_tytul = findViewById(R.id.textView02);
        textView_opis = findViewById(R.id.textView03);
        button_next = findViewById(R.id.button02);
        button_back = findViewById(R.id.button01);
        //aktualizuj();
        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if(id == R.id.button01) pozycja++;
                else if(id == R.id.button02) pozycja--;
                if(pozycja>grafiki.length-1) pozycja = 0;
                if(pozycja<0) pozycja = grafiki.length-1;
                aktualizuj();
            }
        };
        button_next.setOnClickListener(sluchacz);
        button_back.setOnClickListener(sluchacz);
    }

    private void aktualizuj() {
        imageView.setImageResource(grafiki[pozycja]);
        textView_tytul.setText(nazwy[pozycja]);
        textView_opis.setText(opisy[pozycja]);

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor edytor = sharedPref.edit();
        edytor.putInt("pozycja", pozycja);
        edytor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        pozycja = sharedPref.getInt("pozycja", 0);
        aktualizuj();
    }
}