package com.mycoloruniverse.health;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final AttributeList attributes = AttributeList.getInstance();
    private final AppDao appDao = App.getInstance().getAppDatabase().getDaoDatabase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}