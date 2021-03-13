package com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.activites.glucemia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.R;
import com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class GlucemiaActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glucemia);


        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viepager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        setUpViewPager();
    }

    private void setUpViewPager() {

        viewPagerAdapter.addFragment(new RegistroGlucemiaFragment(),"Registro");
        viewPagerAdapter.addFragment(new PacientesGlucemiaFragment(),"Pacientes");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}