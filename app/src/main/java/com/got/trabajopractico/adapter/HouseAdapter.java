package com.got.trabajopractico.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.got.trabajopractico.R;
import com.got.trabajopractico.model.House;

import java.util.List;

public class HouseAdapter extends RecyclerView.Adapter<HouseAdapter.HouseViewHolder> {

    private List<House> listHouse;
    private OnItemClickListener onItemClickListener;

    public HouseAdapter(List<House> listHouse,OnItemClickListener onItemClickListener) {

        this.listHouse = listHouse;
        this.onItemClickListener = onItemClickListener;
    }

    //Retorna una instancia de HouseViewHolder
    @NonNull
    @Override
    public HouseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemHouse = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_home_list,parent,false);
        return new HouseViewHolder(itemHouse);
    }

    @Override
    public void onBindViewHolder(@NonNull HouseViewHolder holder, int position) {
        holder.txtNameHouse.setText(listHouse.get(position).getName());
        holder.txtRegion.setText(listHouse.get(position).getRegion());
    }

    @Override
    public int getItemCount() {
        return listHouse.size();
    }

    public class HouseViewHolder extends RecyclerView.ViewHolder {

        TextView txtNameHouse, txtRegion;

        public HouseViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameHouse = itemView.findViewById(R.id.txtNameHouse);
            txtRegion = itemView.findViewById(R.id.txtRegion);
        }
    }


    public interface OnItemClickListener{

        void onItemClickListener(House house);
    }
}
