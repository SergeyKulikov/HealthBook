package com.mycoloruniverse.health.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.mycoloruniverse.health.R;
import com.mycoloruniverse.health.Settings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PropertyItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PropertyItemFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "type";
    private static final String ARG_PARAM4 = "param4";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private @Settings.AttributeTypes int mParam3;
    private Serializable mParam4;

    public PropertyItemFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PropertyItemFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PropertyItemFragment newInstance(String param1, String param2, @Settings.AttributeTypes int type, Vector<Object> param4) {
        PropertyItemFragment fragment = new PropertyItemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, type);
        args.putSerializable(ARG_PARAM4, param4);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getInt(ARG_PARAM3);
            mParam4 = getArguments().getSerializable(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // View view = inflater.inflate(R.layout.fragment_property_item, container, false);

        View view;

        Vector<Object> vector = (Vector<Object>) mParam4;
        List<String> vectorValues = new ArrayList<>();
        for (Object obj : vector) {
            vectorValues.add(obj.toString());
        }

        TextView tvParam1;
        EditText tvParam2;
        Spinner spinner;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),  android.R.layout.simple_spinner_dropdown_item, vectorValues);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);


        switch(mParam3) {
            case Settings.Text: case Settings.MultilineText: case Settings.Memo:
                view = inflater.inflate(R.layout.fragment_property_item_text, container, false);
                tvParam1 = view.findViewById(R.id.tvPropertyName);
                tvParam2 = view.findViewById(R.id.etPropertyValue);

                tvParam1.setText(mParam1);
                tvParam2.setText(mParam2);
                break;
            case Settings.SingleSelect:
                view = inflater.inflate(R.layout.fragment_property_item_spinner, container, false);
                tvParam1 = view.findViewById(R.id.tvPropertyName);
                spinner = view.findViewById(R.id.etPropertyValue);

                spinner.setAdapter(adapter);
                break;
            default:
                //throw new IllegalStateException("Unexpected value: " + mParam3);
                view = inflater.inflate(R.layout.fragment_property_item_text, container, false);
                tvParam1 = view.findViewById(R.id.tvPropertyName);
                tvParam2 = view.findViewById(R.id.etPropertyValue);

                tvParam1.setText(mParam1);
                tvParam2.setText(mParam2);
        }


        // tvPeriod = view.findViewById(R.id.tvPeriod);
        //tvPeriodDescription = view.findViewById(R.id.tvPeriodDescription);

        // tvPeriod.setText(text);
        //tvPeriod.setText(description);



        return view;
    }
}