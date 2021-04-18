package com.mycoloruniverse.health;

public interface Settings {
    String APP_TAG = Settings.class.getPackage().getName();

    String APP_ACTION = "app_action";
    String MEMBER_ID = "company_id";

    int ID_ACTION_NEW_MEMBER = 10;
    int ID_ACTION_EDIT_MEMBER = 11;

}
