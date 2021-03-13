package com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.activites.anemia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.Database.DatabaseAnemia;
import com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.R;
import com.google.android.material.textfield.TextInputEditText;


public class RegistroAnemiaFragment extends Fragment {


   private TextInputEditText sTxtNombre,sTxtApellido,sTxtHemoglobina,sTxtEdad,sTxtACorreo;
   private Button sButtonRegistrar;
   private Spinner spinner;
   private String [] edad ={"Meses","Años"};
    private RadioButton sRadioM, sRadioF;
    private String select;
    private String genero = "";


    public RegistroAnemiaFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registro_anemia, container, false);


        sTxtNombre = view.findViewById(R.id.txtRNombreAnemia);
        sTxtApellido = view.findViewById(R.id.txtRApellidoAnemia);
        sTxtHemoglobina = view.findViewById(R.id.txtRNivelAnemia);
        sTxtEdad = view.findViewById(R.id.txtREdadAnemia);
        sTxtACorreo = view.findViewById(R.id.txtACorreo);
        spinner = view.findViewById(R.id.SpinnerEdad);
        sRadioM = view.findViewById(R.id.radioMasculino);
        sRadioF = view.findViewById(R.id.radioFemenino);

        sButtonRegistrar = view.findViewById(R.id.btnRegistroAnemia);
        spinner.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,edad));


        sButtonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarPaciente();
            }
        });

        return view;
    }

    private void registrarPaciente() {
        final DatabaseAnemia myDB = new DatabaseAnemia(getContext());
        myDB.añadirPaciente(sTxtNombre.getText().toString().trim(),
                sTxtApellido.getText().toString().trim(),
                sTxtACorreo.getText().toString().trim(),
                Double.valueOf(sTxtHemoglobina.getText().toString().trim()),
                Integer.valueOf(sTxtEdad.getText().toString().trim()),
                spinner.getSelectedItem().toString().trim());

        String Hemoglobina = sTxtHemoglobina.getText().toString();
        String Edad = sTxtEdad.getText().toString();
        double hemoglobina = Double.parseDouble(Hemoglobina);
        int edad = Integer.parseInt(Edad);
        if(sRadioM.isChecked()==true){
            genero = "Masculino";
            select =spinner.getSelectedItem().toString();
            if((select.equals("Años"))&& (edad>15)){
                if((hemoglobina>=14.0)&&(hemoglobina<=18.0)){
                    Toast.makeText(getContext(), "El paciente NO tiene anemia", Toast.LENGTH_SHORT).show();
                }else
                Toast.makeText(getContext(), "El paciente SI tiene anemia", Toast.LENGTH_SHORT).show();

            }
        }else
        if(sRadioF.isChecked()==true){
            genero = "Femenino";
            select =spinner.getSelectedItem().toString();
            if((select.equals("Años"))&& (edad>15)){
                if((hemoglobina>=12.0)&&(hemoglobina<=16.0)){
                    Toast.makeText(getContext(), "El paciente NO tiene anemia", Toast.LENGTH_SHORT).show();
                }else
                Toast.makeText(getContext(), "El paciente SI tiene anemia", Toast.LENGTH_SHORT).show();

            }
        }else
        if((edad==0)||(edad==1)){
            select =spinner.getSelectedItem().toString();
            if(select.equals("Meses")){
                if((hemoglobina>=13.0)&&(hemoglobina<=26.0)){
                    Toast.makeText(getContext(), "El paciente NO tiene anemia", Toast.LENGTH_SHORT).show();

                }else
                Toast.makeText(getContext(), "El paciente SI tiene anemia", Toast.LENGTH_SHORT).show();

            }
        }else
        if((edad>1)&&(edad<=6)){
            select =spinner.getSelectedItem().toString();
            if(select.equals("Meses")){
                if((hemoglobina>=10.0)&&(hemoglobina<=18.0)){
                    Toast.makeText(getContext(), "El paciente NO tiene anemia", Toast.LENGTH_SHORT).show();

                }else
                Toast.makeText(getContext(), "El paciente SI tiene anemia", Toast.LENGTH_SHORT).show();

            }
        }else
        if((edad>6)&&(edad<=12)){
            select =spinner.getSelectedItem().toString();
            if(select.equals("Meses")){
                if((hemoglobina>=11.0)&&(hemoglobina<=15.0)){
                    Toast.makeText(getContext(), "El paciente NO tiene anemia", Toast.LENGTH_SHORT).show();

                }else
                Toast.makeText(getContext(), "El paciente SI tiene anemia", Toast.LENGTH_SHORT).show();

            }
        }else
        if((edad>1)&&(edad<=5)){
            select =spinner.getSelectedItem().toString();
            if(select.equals("Años")){
                if((hemoglobina>=11.5)&&(hemoglobina<=15.0)){
                    Toast.makeText(getContext(), "El paciente NO tiene anemia", Toast.LENGTH_SHORT).show();

                }else
                Toast.makeText(getContext(), "El paciente SI tiene anemia", Toast.LENGTH_SHORT).show();

            }
        }else
        if((edad>5)&&(edad<=10)){
            select =spinner.getSelectedItem().toString();
            if(select.equals("Años")){
                if((hemoglobina>=12.6)&&(hemoglobina<=15.5)){
                    Toast.makeText(getContext(), "El paciente NO tiene anemia", Toast.LENGTH_SHORT).show();

                }else
                Toast.makeText(getContext(), "El paciente SI tiene anemia", Toast.LENGTH_SHORT).show();

            }
        }
    }
}