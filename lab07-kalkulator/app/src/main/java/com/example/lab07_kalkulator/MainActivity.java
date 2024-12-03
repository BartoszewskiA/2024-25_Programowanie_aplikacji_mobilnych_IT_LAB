package com.example.lab07_kalkulator;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab07_kalkulator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private boolean trybPisania = true;

    private ActivityMainBinding binding;

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
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sluchaczCyfr();
    }



    private void sluchaczCyfr()
    {
        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if (id == R.id.p0)
                    dodajCyfre("0");
                else if(id == R.id.p1)
                    dodajCyfre("1");
                else if(id == R.id.p2)
                    dodajCyfre("2");
                else if(id == R.id.p3)
                    dodajCyfre("3");
                else if(id == R.id.p4)
                    dodajCyfre("4");
                else if(id == R.id.p5)
                    dodajCyfre("5");
                else if(id == R.id.p6)
                    dodajCyfre("6");
                else if(id == R.id.p7)
                    dodajCyfre("7");
                else if(id == R.id.p8)
                    dodajCyfre("8");
                else if(id == R.id.p9)
                    dodajCyfre("9");
            }
        };
        binding.p0.setOnClickListener(sluchacz);
        binding.p1.setOnClickListener(sluchacz);
        binding.p2.setOnClickListener(sluchacz);
        binding.p3.setOnClickListener(sluchacz);
        binding.p4.setOnClickListener(sluchacz);
        binding.p5.setOnClickListener(sluchacz);
        binding.p6.setOnClickListener(sluchacz);
        binding.p7.setOnClickListener(sluchacz);
        binding.p8.setOnClickListener(sluchacz);
        binding.p9.setOnClickListener(sluchacz);
    }
    private void dodajCyfre(String cyfra) {
        if (trybPisania) {
            if(binding.wyswietlacz.getText().toString().equals("0"))
                binding.wyswietlacz.setText(cyfra);
            else
                binding.wyswietlacz.append(cyfra);
        } else {
            binding.wyswietlacz.setText(cyfra);
            trybPisania = true;
        }
    }

    private void sluchaczDzialan() {

        binding.wstecz.setOnClickListener((e) -> {cofnji();});
        binding.kasuj.setOnClickListener((e) -> {kasuj();});

    }


    private void cofnji()
    {
        String s = binding.wyswietlacz.getText().toString();
        if(s.length() > 1)
            binding.wyswietlacz.setText(s.substring(0, s.length() - 1));
        else
            binding.wyswietlacz.setText("0");
    }

    private void kasuj()
    {
        binding.wyswietlacz.setText("0");
        trybPisania = true;
    }
}