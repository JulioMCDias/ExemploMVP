package com.jlmcdeveloper.exemplomvp.ui.listcar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jlmcdeveloper.exemplomvp.R;
import com.jlmcdeveloper.exemplomvp.data.db.model.Car;

import java.util.List;


public class CarAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Car> carList;
    private BtnListener listener;


    public CarAdapter(List<Car> list){
        carList = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Car car = carList.get(position);
        holder.textViewName.setText(car.getName());
        holder.textViewYear.setText(String.valueOf(car.getYear()));

        holder.btnRemoveCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Car c = carList.get(holder.getAdapterPosition());
                carList.remove(c);
                if(listener != null)
                    listener.handle(c);
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });
    }



    public void btnAddListener(BtnListener listener){
        if (listener == null) throw new IllegalArgumentException("listener cannot be null.");
        this.listener = listener;
    }


    @Override
    public int getItemCount() {
        return carList.size();
    }



    // ------- listener  --------
    public interface BtnListener {
        void handle (Car car);
    }
}
