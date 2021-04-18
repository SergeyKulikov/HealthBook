package com.mycoloruniverse.health;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.mycoloruniverse.health.Settings.*;

public class MemberListActivity extends AppCompatActivity {
    // private final AttributeList attributes = AttributeList.getInstance();
    private final AppDao appDao = App.getInstance().getAppDatabase().getDaoDatabase();
    private final MemberListAdapter memberListAdapter = new MemberListAdapter(
            R.layout.member_item_layout);
    private RecyclerView rvMemberList;
    private Disposable disposableLoadMembers;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MemberActivity.class);
                intent.putExtra(APP_ACTION, ID_ACTION_NEW_MEMBER);
                startActivity(intent);
            }
        });

        rvMemberList = findViewById(R.id.rvMemberList);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                RecyclerView.VERTICAL);

        rvMemberList.setLayoutManager(new LinearLayoutManager(this));
        rvMemberList.setAdapter(memberListAdapter);
        rvMemberList.setClickable(true);
        rvMemberList.setLongClickable(true);
        rvMemberList.setOnCreateContextMenuListener(this); // необходимо для контекстного меню для RecycledView
        rvMemberList.addItemDecoration(dividerItemDecoration);

        disposableLoadMembers = appDao.rx_loadMemberList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(memberListAdapter::setList);
    }

    @Override
    protected void onDestroy() {
        disposableLoadMembers.dispose();
        super.onDestroy();
    }
}