package com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.activites.anemia;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.AdapterAnemia;
import com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.Database.DatabaseAnemia;
import com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.R;

import java.util.ArrayList;


public class PacienteAnemiaFragment extends Fragment {
    RecyclerView sArecyclerView;
    DatabaseAnemia myDb;
    AdapterAnemia sAdapterAnemia;
    ArrayList<String> sId,sNombre,sApellido,sHemoglobina,sEdad,sTiempo,sCorreo;

    public PacienteAnemiaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_paciente_anemia, container, false);
        // Inflate the layout for this fragment

        sArecyclerView = view.findViewById(R.id.Arecycleview);
        sArecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        myDb = new DatabaseAnemia(getContext());
        sId = new ArrayList<>();
        sNombre = new ArrayList<>();
        sApellido = new ArrayList<>();
        sCorreo = new  ArrayList<>();
        sEdad = new ArrayList<>();
        sTiempo = new ArrayList<>();
        sHemoglobina = new  ArrayList<>();


        mostrarDatos();
        sAdapterAnemia = new AdapterAnemia(getContext(),sId,sNombre,sApellido,sCorreo,sEdad,sTiempo,sHemoglobina);
        sArecyclerView.setAdapter(sAdapterAnemia);
        container.addView(view);
        return  view;
    }

    private void mostrarDatos() {
        Cursor cursor = myDb.leerTodo();
        if(cursor.getCount() ==0){
            Toast.makeText(getContext(), "No hay Datos", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                sId.add(cursor.getString(0));
                sNombre.add(cursor.getString(1));
                sApellido.add(cursor.getString(2));
                sCorreo.add(cursor.getString(3));
                sEdad.add(cursor.getString(5));
                sTiempo.add(cursor.getString(6));
                sHemoglobina.add(cursor.getString(4));


            }
        }
    }
}