package com.jlmcdeveloper.exemplomvp.ui.listcar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jlmcdeveloper.exemplomvp.R;
import com.jlmcdeveloper.exemplomvp.data.db.model.Car;

import java.util.List;


public class CarAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Car> carList;


    public CarAdapter(List<Car> list){
        carList = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Car car = carList.get(position);
        holder.textViewName.setText(car.getName());
        holder.textViewYear.setText(String.valueOf(car.getYear()));
    }


    @Override
    public int getItemCount() {
        return carList.size();
    }
}
