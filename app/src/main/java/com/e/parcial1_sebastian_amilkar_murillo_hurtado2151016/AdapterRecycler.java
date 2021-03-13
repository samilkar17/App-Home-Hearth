package com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyViewHolder> {
    public  Context context;
   public ArrayList sId,sNombre,sApellido,sCedula,sEstado;

   public AdapterRecycler(Context context,
                          ArrayList sId,
                          ArrayList sNombre,
                          ArrayList sApellido,
                          ArrayList sCedula,
                          ArrayList sEstado
                          ){

       this.context =context;
       this.sId = sId;
       this.sNombre = sNombre;
       this.sApellido = sApellido;
       this.sCedula = sCedula;
       this.sEstado = sEstado;



   }

    @NonNull
    @Override
    public AdapterRecycler.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.card_history,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecycler.MyViewHolder holder, int position) {
       holder.sTxtnombre.setText(String.valueOf(sNombre.get(position)));
        holder.sTxtapellido.setText(String.valueOf(sApellido.get(position)));
        holder.sTxtcedula.setText(String.valueOf(sCedula.get(position)));
        holder.sTxtestado.setText(String.valueOf(sEstado.get(position)));



    }

    @Override
    public int getItemCount() {
        return sId.size();
    }
    public class  MyViewHolder extends RecyclerView.ViewHolder{
       TextView sTxtnombre,sTxtapellido,sTxtcedula,sTxtestado;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sTxtnombre = itemView.findViewById(R.id.txtGNombrePaciente);
            sTxtapellido = itemView.findViewById(R.id.txtGApellidoPaciente);
            sTxtcedula = itemView.findViewById(R.id.txtGCedulaPaciente);
            sTxtestado = itemView.findViewById(R.id.txtGEstadoPaciente);
        }
    }
}
