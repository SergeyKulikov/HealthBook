package com.mycoloruniverse.health;

import androidx.annotation.IntDef;

public interface Settings {
    String APP_TAG = Settings.class.getPackage().getName();

    String APP_ACTION = "app_action";
    String MEMBER_ID = "company_id";

    int ID_ACTION_NEW_MEMBER = 10;
    int ID_ACTION_EDIT_MEMBER = 11;


    @IntDef({None, GUID, Integer, Long, Double, Date, Time, DateTime,
            Text, MultilineText, SingleSelect, Memo, Decimal})
    @interface AttributeTypes { }

    int None = 0;
    int GUID = 1;
    int Integer = 2;
    int Long = 3;
    int Double = 4;
    int Date = 5;
    int Time = 6;
    int DateTime = 7;
    int Text = 8;
    int MultilineText = 9;
    int SingleSelect = 10;
    int Memo = 11;
    int Decimal = 12;
}
