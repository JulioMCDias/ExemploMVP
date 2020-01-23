package com.jlmcdeveloper.exemplomvp.ui.listcar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jlmcdeveloper.exemplomvp.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView textViewName;
    TextView textViewYear;
    Button btnRemoveCar;

    ViewHolder(@NonNull View itemView) {
        super(itemView);

        textViewName = itemView.findViewById(R.id.cad_view_text_name);
        textViewYear = itemView.findViewById(R.id.cad_view_text_year);
        btnRemoveCar = itemView.findViewById(R.id.btn_remove_car);
    }

    public TextView getTextViewName() {
        return textViewName;
    }
}
