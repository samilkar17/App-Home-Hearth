package com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.activites.glucemia;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.AdapterRecycler;
import com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.Database.Database;
import com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.R;

import java.util.ArrayList;


public class PacientesGlucemiaFragment extends Fragment {


    RecyclerView sRecyclerView;
    Database myDB;
    ArrayList<String> sId,sNombre,sApellido,sCedula,sEstado;
    AdapterRecycler adapterRecycler;
    public PacientesGlucemiaFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pacientes_glucemia, container, false);
        // Inflate the layout for this fragment
        sRecyclerView= view.findViewById(R.id.recycleview);
        sRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        myDB = new Database(getContext());
        sId = new ArrayList<>();
        sNombre = new ArrayList<>();
        sApellido = new ArrayList<>();
        sCedula = new ArrayList<>();
        sEstado = new ArrayList<>();
        
        mostrarDatos();
        adapterRecycler = new AdapterRecycler(getContext(),sId,sNombre,sApellido,sCedula,sEstado);
        sRecyclerView.setAdapter(adapterRecycler);


        container.addView(view);
        return view;
    }

    private void mostrarDatos() {
        Cursor cursor = myDB.leerTodo();
        if (cursor.getCount() ==0){
            Toast.makeText(getContext(), "No hay datos", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                sId.add(cursor.getString(0));
                sNombre.add(cursor.getString(1));
                sApellido.add(cursor.getString(2));
                sCedula.add(cursor.getString(3));
                sEstado.add(cursor.getString(6));

            }
        }
    }
}