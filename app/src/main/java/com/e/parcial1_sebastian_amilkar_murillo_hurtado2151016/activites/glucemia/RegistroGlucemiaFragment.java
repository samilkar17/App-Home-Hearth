package com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.activites.glucemia;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.Database.Database;
import com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.R;
import com.google.android.material.textfield.TextInputEditText;


public class RegistroGlucemiaFragment extends Fragment {
    TextInputEditText sTxtNombre,sTxtApellido,sTxtCedula,sTxtEps,sTxtGlucemia;
    Spinner spinner;
    String [] sintomas ={"No","Cuadro Neurovegetativo","Trastornos de Conciencia","Signos de Deshidratacion","Sepsis","PACN"};
    Button sButtonRegistrar;


    public RegistroGlucemiaFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro_glucemia, container, false);
        sTxtNombre = view.findViewById(R.id.txtRNombreGlucemia);
        sTxtApellido = view.findViewById(R.id.txtRApellidoGlucemia);
        sTxtCedula = view.findViewById(R.id.txtRCedulaGlucemia);
        sTxtEps = view.findViewById(R.id.txtREpsGlucemia);
        sTxtGlucemia = view.findViewById(R.id.txtRNivelGlucemia);


        spinner = view.findViewById(R.id.SpinnerSintomas);
        sButtonRegistrar = view.findViewById(R.id.btnRegistroGlucemia);
        spinner.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,sintomas));




        sButtonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarDatos();
                
            }
        });
        // Inflate the layout for this fragment
        container.addView(view);
        return view;
    }

    private void guardarDatos() {
        final Database myDB = new Database(getContext());
        myDB.añadirPaciente(sTxtNombre.getText().toString().trim(),
                sTxtApellido.getText().toString().trim(),
                Integer.valueOf(sTxtCedula.getText().toString().trim()),
                sTxtEps.getText().toString().trim(),
                Double.valueOf(sTxtGlucemia.getText().toString().trim()),
                spinner.getSelectedItem().toString().trim()

        );
        String glucemia = sTxtGlucemia.getText().toString();
        double nivelGlucemia = Double.parseDouble(glucemia);

        if ((nivelGlucemia >= 7.0) && (nivelGlucemia < 13.8)) {

            Toast toast = Toast.makeText(getContext(),
                    "HIPERGLISEMIA AISLADA"+"\n"+"Indicar glucemia en ayunas y TCP en pacientes sin diagnostico" + "\n" +
                    "-si deshidratacion, rehidratacion oral o EV segun las demandas" + "\n" +
                    "-Reevaluar conducta terapéutica en diabeticos y cumplimiento de los pilares" + "\n" +
                    "-Reevaluar dosis de hipoglucemiantes", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();


        } else if (nivelGlucemia >= 13.8) {

            Toast toast = Toast.makeText(getContext(),
                    "CETOACIDOSIS DIABÉTICA"+"\n"+"Coordinar traslado y comenzar tratamiento" + "\n" +
                    "-Hidratacion con solucion salina 40 ml/Kg en las primeras 4h. 1-2 La primera hora." + "\n" +
                    "-Administrar potasio al restituirse la diuresis o signos de hipopotasemia (depresión del ST,Onda U <= 1mv, ondas U <= T) " + "\n" +
                    "-Evitar insulinasimple 0,1 U/Kg EV despues de hidratar", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();


        } else if (nivelGlucemia > 33) {

            Toast toast = Toast.makeText(getContext(),
                    "ESTADO HIPEROSMOLAR HIPERGLUCÉMICO NO CETÓSICO"+"\n"+"Coordinar traslado y comenzar tratamiento." + "\n" +
                            "-Hidratacion con solucion salina 10-15 ml/Kg/h hasta conseguir establidad hemodinámica." + "\n" +
                            "-Administrar potasio al restituirse la diuresis o signos de hipopotasemia (depresión del ST, onda U <= 1mv, ondas U <= T " + "\n"
                    , Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();


        }


    }




}