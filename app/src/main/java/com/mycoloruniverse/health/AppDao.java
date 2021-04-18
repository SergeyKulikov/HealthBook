package com.mycoloruniverse.health;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;

@Dao
public interface AppDao {
    /** Исключительно для создания продукта при первом запуске в MainActivity */

    @Query("SELECT * FROM Member ORDER BY name")
    Flowable<List<Member>> rx_loadMemberList();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Maybe<Long> rx_saveMember(Member member);

    @Query("SELECT * FROM Member WHERE guid = :guid")
    Maybe<Member> rx_loadMemberByGUID(String guid);
}