package com.mycoloruniverse.health.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.mycoloruniverse.health.R;
import com.mycoloruniverse.health.Settings;
import com.mycoloruniverse.health.db.App;
import com.mycoloruniverse.health.db.AppDao;
import com.mycoloruniverse.health.model.AttributeList;
import com.mycoloruniverse.health.model.VisualEventBased;
import com.mycoloruniverse.health.model.VisualInterface;
import com.mycoloruniverse.health.presenter.VisualInterfaceList;

import java.util.ArrayList;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private final AttributeList attributes = AttributeList.getInstance();
    private final AppDao appDao = App.getInstance().getAppDatabase().getDaoDatabase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // LinearLayout ll_test = findViewById(R.id.ll_test);

        final VisualInterface visualInterface = VisualInterfaceList.getInstance().get("member");


        FragmentManager fragmentManager = getSupportFragmentManager(); //getFragmentManager(); //getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();

        for (int g=0; g<visualInterface.getGroups().size(); g++) {
            for (int i=0; i<visualInterface.getValues().get(visualInterface.getGroups().get(g)).size(); i++ ) {

                VisualEventBased visualElement= visualInterface.getValues().get(visualInterface.getGroups().get(g)).get(i);

                if (visualElement.getType() == Settings.GUID) {

                    if (visualElement.getVisualParameterList().containsKey("autogen")) {
                        if ((Boolean) visualElement.getVisualParameterList().get("autogen")) {
                            if (visualElement.getValue() == null) {
                                visualElement.setValue(UUID.randomUUID().toString());
                            }
                        }
                    }

                    if (visualElement.getVisualParameterList().containsKey("hidden")) {
                       continue;
                    }

                    // if (visualElement.getVisualParameterList().containsKey("enable")) {
                        // etPropertyValue.setEnabled((Boolean) visualElement.getVisualParameterList().get("enable"));
                    // }
                }


                String value = (visualElement.getValue() != null ? visualElement.getValue().toString() : visualElement.getDefault_value());

                PropertyItemFragment propertyItemFragment = PropertyItemFragment.newInstance(visualElement.getCaption(), value, visualElement.getType(), visualElement.getParameters());
                fragmentTransaction.add(R.id.ll_test, propertyItemFragment);
                // Log.d("APP", "www " + i);
            }
        }
        fragmentTransaction.commit();

    }
}