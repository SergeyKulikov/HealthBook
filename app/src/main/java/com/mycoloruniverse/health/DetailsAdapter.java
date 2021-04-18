package com.mycoloruniverse.health;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.RatesViewHolder> {
    private final PropertyList propertyList = new PropertyList();

    private int layoutId;
    private String activeFolder;
    private final Map<String, Integer> activePosition = new HashMap<>();

    public DetailsAdapter(int layoutId) {
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public DetailsAdapter.RatesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                //inflate(R.layout.company_property_item_layout, parent, false);
                        inflate(this.layoutId, parent, false);

        return new DetailsAdapter.RatesViewHolder(view);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(@NonNull DetailsAdapter.RatesViewHolder holder, int position) {
        Property Property = propertyList.getValues().get(activeFolder).get(position);

        holder.tvPropertyName.setText(Property.getCaption());
        holder.etPropertyValue.setText(Property.getValue() == null ? Property.getDefault_value() : Property.getValue());
        // holder.btnPropertySelect.setText("...");
    }

    @Override
    public int getItemCount() {
        if (propertyList.getValues().containsKey(activeFolder)) {
            return propertyList.getValues().get(activeFolder).size();
        }
        return 0;
    }

    public void setPropertyMap(PropertyList propertyList) {
        if (propertyList != null) {
            this.propertyList.setProperty(propertyList);
            this.notifyDataSetChanged();
        }
    }

    public void setActiveFolder(String activeFolder) {
        this.activeFolder = activeFolder;
        notifyDataSetChanged();
    }

    public Map<String, Map<String, Property>> getPropertyListValues() {
        return this.propertyList.getValues();
    }

    public PropertyList getPropertyList() {
        return this.propertyList;
    }


    class RatesViewHolder extends ViewHolder {
        private final TextView tvPropertyName;
        private final EditText etPropertyValue;
        private final ImageButton btnPropertySelect;

        @SuppressLint("CheckResult")
        public RatesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPropertyName = itemView.findViewById(R.id.tvPropertyName);
            etPropertyValue = itemView.findViewById(R.id.etPropertyValue);
            btnPropertySelect = itemView.findViewById(R.id.btnPropertySelect);

            RxTextView.textChanges(etPropertyValue)
                    .subscribe(charSequence -> {
                        if (getAdapterPosition() != -1) {
                            propertyList.getValues().get(activeFolder).get(getAdapterPosition())
                                    .setValue(String.valueOf(charSequence));
                        }
                    });
        }
    }
}
