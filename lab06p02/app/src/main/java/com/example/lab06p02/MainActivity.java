package com.example.lab06p02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

   ActivityResultLauncher<Intent> luncher;
    ImageView iv_obraz;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        luncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        if(o.getResultCode()==RESULT_OK)
                        {
//                            Intent intent = o.getData();
//                            int wybrany = intent.getIntExtra("wybrany", 0);
                            int wybrany = o.getData().getIntExtra("wybrany", R.drawable.g01);
//                            Bundle dane = o.getData().getExtras();
//                            int wybrany = dane.getInt("wybrany");
                            iv_obraz.setImageResource(wybrany);

                        }
                    }
                }
        );
        iv_obraz = findViewById(R.id.a1_iv_obraz);
        iv_obraz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(MainActivity.this, MainActivity2.class);
              luncher.launch(intent);
            }
        });
    }
}