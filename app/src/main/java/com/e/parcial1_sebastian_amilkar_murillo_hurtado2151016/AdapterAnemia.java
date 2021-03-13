package com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterAnemia extends RecyclerView.Adapter<AdapterAnemia.MyViewHolder> {

    public Context context;
    public ArrayList sId,sNombre,sApellido,sCorreo,sEdad,sTiempo,sHemoglobina;

    public AdapterAnemia(Context context,
                           ArrayList sId,
                           ArrayList sNombre,
                           ArrayList sApellido,
                           ArrayList sCorreo,
                           ArrayList sEdad,
                           ArrayList sTiempo,
                           ArrayList sHemoglobina){

        this.context =context;
        this.sId = sId;
        this.sNombre = sNombre;
        this.sApellido = sApellido;
        this.sCorreo = sCorreo;
        this.sEdad = sEdad;
        this.sTiempo = sTiempo;
        this.sHemoglobina = sHemoglobina;

    }

    @NonNull
    @Override
    public AdapterAnemia.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.anemia_history,parent,false);
        return new AdapterAnemia.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAnemia.MyViewHolder holder, int position) {
        holder.sTxtnombre.setText(String.valueOf(sNombre.get(position)));
        holder.sTxtapellido.setText(String.valueOf(sApellido.get(position)));
        holder.sTxtCorreo.setText(String.valueOf(sCorreo.get(position)));
        holder.sTxtEdad.setText(String.valueOf(sEdad.get(position)));
        holder.sTxtTiempo.setText(String.valueOf(sTiempo.get(position)));
        holder.sTxtHemoglobina.setText(String.valueOf(sHemoglobina.get(position)));




    }

    @Override
    public int getItemCount() {
        return sId.size();
    }
    public class  MyViewHolder extends RecyclerView.ViewHolder{
        TextView sTxtnombre,sTxtapellido,sTxtCorreo,sTxtHemoglobina,sTxtEdad,sTxtTiempo;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sTxtnombre = itemView.findViewById(R.id.txtGNombrePaciente);
            sTxtapellido = itemView.findViewById(R.id.txtGApellidoPaciente);
            sTxtCorreo = itemView.findViewById(R.id.txtCorreo);
            sTxtEdad = itemView.findViewById(R.id.txtAEdad);
            sTxtTiempo = itemView.findViewById(R.id.txtTiempo);
            sTxtHemoglobina = itemView.findViewById(R.id.txtAhemoglobina);


        }
    }

}
