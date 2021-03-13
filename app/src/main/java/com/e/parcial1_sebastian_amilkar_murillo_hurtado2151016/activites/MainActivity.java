package com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.R;
import com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.activites.anemia.AnemiaActivity;
import com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.activites.glucemia.GlucemiaActivity;

public class MainActivity extends AppCompatActivity {
    private Button sButtonGlucemia,sButtonAnemia;
    private LottieAnimationView sAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sAnimation = findViewById(R.id.animation);
        sButtonGlucemia = findViewById(R.id.btnGlucemia);
        sButtonAnemia = findViewById(R.id.btnAnemia);

        sAnimation.playAnimation();

        sButtonGlucemia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToGlucemia();
            }
        });

        sButtonAnemia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAnemia();
            }
        });




    }

    private void goToAnemia() {

        Intent intent = new Intent(MainActivity.this, AnemiaActivity.class);
        startActivity(intent);
    }

    private void goToGlucemia() {

        Intent intent = new Intent(MainActivity.this, GlucemiaActivity.class);
        startActivity(intent);
    }
}