package com.mycoloruniverse.health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;

import java.util.UUID;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MemberActivity extends AppCompatActivity implements Settings {
    private RecyclerView rvDetails;
    private final AppDao appDao = App.getInstance().getAppDatabase().getDaoDatabase();
    private final DetailsAdapter memberPropertyAdapter = new DetailsAdapter(
            R.layout.property_item_layout);
    private Member currentMember;
    private String [] groups = { "Основные сведения" };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        createDefaultPropertyList(); // Создали фиксированные поля для данного типа документа

        rvDetails = findViewById(R.id.rvDetails);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                RecyclerView.VERTICAL);

        rvDetails.setLayoutManager(new LinearLayoutManager(this));
        rvDetails.setAdapter(memberPropertyAdapter);
        rvDetails.setClickable(true);
        rvDetails.setLongClickable(true);
        rvDetails.setOnCreateContextMenuListener(this); // необходимо для контекстного меню для RecycledView
        rvDetails.addItemDecoration(dividerItemDecoration);


        Intent intent = getIntent();
        if (intent.hasExtra(APP_ACTION)) {
            switch (intent.getIntExtra(APP_ACTION, 0)) {
                case ID_ACTION_NEW_MEMBER:
                    currentMember = new Member(
                            UUID.randomUUID().toString(), ""
                    );
                    memberPropertyAdapter.setActiveFolder(groups[0]);
                    // memberPropertyAdapter.setPropertyMap(currentMember.getPropertyMap());
                    break;
                case ID_ACTION_EDIT_MEMBER:
                    appDao.rx_loadMemberByGUID(intent.getStringExtra(MEMBER_ID))
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(member -> {
                                currentMember = member;

                                memberPropertyAdapter.setActiveFolder(groups[0]);
                                // memberPropertyAdapter.setPropertyMap(currentMember.getPropertyMap());
                            });
                    break;
                default:
                    Log.d(APP_TAG, "Unknown app action ID");
            }
        }
    }

    private void createDefaultPropertyList() {

        memberPropertyAdapter.getPropertyList().addItem(
                groups[0], new Property("guid", "GUID", AttributeType.GUID)
        );
        memberPropertyAdapter.getPropertyList().addItem(
                groups[0], new Property("last_name", "Фамилия", AttributeType.Text)
        );
        memberPropertyAdapter.getPropertyList().addItem(
                groups[0], new Property("first_name", "Имя", AttributeType.Text)
        );
        memberPropertyAdapter.getPropertyList().addItem(
                groups[0], new Property("middle_name", "Отчество", AttributeType.Text)
        );
        memberPropertyAdapter.getPropertyList().addItem(
                groups[0], new Property("medicine_number", "Отчество", AttributeType.Text)
        );
        memberPropertyAdapter.getPropertyList().addItem(
                groups[0], new Property("berth_day", "Дата рождения", AttributeType.Date)
        );
        memberPropertyAdapter.getPropertyList().addItem(
                groups[0], new Property("gender", "Пол", AttributeType.SingleSelect)
                .addParameter("Муж").addParameter("Жен")
        );
    }

}