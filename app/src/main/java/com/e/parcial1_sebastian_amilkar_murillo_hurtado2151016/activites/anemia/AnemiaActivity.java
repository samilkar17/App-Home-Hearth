package com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.activites.anemia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.R;
import com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.ViewPagerAdapter;
import com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.activites.glucemia.PacientesGlucemiaFragment;
import com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.activites.glucemia.RegistroGlucemiaFragment;
import com.google.android.material.tabs.TabLayout;

public class AnemiaActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anemia);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viepager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        setUpViewPager();
    }
    private void setUpViewPager() {

        viewPagerAdapter.addFragment(new RegistroAnemiaFragment(),"Registro");
        viewPagerAdapter.addFragment(new PacienteAnemiaFragment(),"Pacientes");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}