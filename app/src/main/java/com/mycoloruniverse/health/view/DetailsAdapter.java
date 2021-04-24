package com.mycoloruniverse.health.view;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.mycoloruniverse.health.R;
import com.mycoloruniverse.health.Settings;
import com.mycoloruniverse.health.model.VisualEventBased;
import com.mycoloruniverse.health.model.VisualInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.RatesViewHolder> {
    private final VisualInterface propertyMap = new VisualInterface();
    // todo: Лучше их разделить

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
        Map<String, ArrayList<VisualEventBased>> values = propertyMap.getValues();

        ArrayList<VisualEventBased> visualElementList = values.get(activeFolder);


        VisualEventBased visualElement = visualElementList.get(position);


        if (visualElement.getType() == Settings.GUID) {

            if (visualElement.getVisualParameterList().containsKey("autogen")) {
                if ((Boolean) visualElement.getVisualParameterList().get("autogen")) {
                    if (visualElement.getValue() == null) {
                        visualElement.setValue(UUID.randomUUID().toString());
                    }
                }
            }

            if (visualElement.getVisualParameterList().containsKey("hidden")) {
                holder.cl_property.setVisibility((Boolean) visualElement.getVisualParameterList().get("hidden") ? View.GONE : View.VISIBLE);
            }

            if (visualElement.getVisualParameterList().containsKey("enable")) {
                holder.etPropertyValue.setEnabled((Boolean) visualElement.getVisualParameterList().get("enable"));
            }
        }
        holder.tvPropertyName.setText(visualElement.getCaption());
        holder.etPropertyValue.setText(visualElement.getValue() == null ? visualElement.getDefault_value() : visualElement.getValue().toString());

        // holder.btnPropertySelect.setText("...");
    }

    @Override
    public int getItemCount() {
        if (propertyMap.getValues().containsKey(activeFolder)) {
            return propertyMap.getValues().get(activeFolder).size();
        }
        return 0;
    }

    public void setPropertyMap(VisualInterface visualInterface) {
        if (visualInterface != null) {
            this.propertyMap.setProperty(visualInterface);
            this.notifyDataSetChanged();
        }
    }

    public void setActiveFolder(String activeFolder) {
        this.activeFolder = activeFolder;
        notifyDataSetChanged();
    }

    public Map<String, ArrayList<VisualEventBased>> getPropertyListValues() {
        return this.propertyMap.getValues();
    }

    public VisualInterface getPropertyMap() {
        return this.propertyMap;
    }


    class RatesViewHolder extends ViewHolder {
        private final TextView tvPropertyName;
        private final EditText etPropertyValue;
        private final ImageView btnPropertySelect;
        private final ConstraintLayout cl_property;

        @SuppressLint("CheckResult")
        public RatesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPropertyName = itemView.findViewById(R.id.tvPropertyName);
            etPropertyValue = itemView.findViewById(R.id.etPropertyValue);
            btnPropertySelect = itemView.findViewById(R.id.btnPropertySelect);
            cl_property = itemView.findViewById(R.id.cl_property);

            RxTextView.textChanges(etPropertyValue)
                    .subscribe(charSequence -> {
                        if (getAdapterPosition() != -1) {
                            propertyMap.getValues().get(activeFolder).get(getAdapterPosition())
                                    .setValue(String.valueOf(charSequence));
                        }
                    });
        }
    }
}
