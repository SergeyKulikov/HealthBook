package com.mycoloruniverse.health.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
import java.util.Locale;

/**
 * Это пишется в файл
 */


@Entity
public class EventFileAttribute extends Attribute {
    @NonNull
    private String file_guid;
    @NonNull
    private String member_guid;
    private long time; // Дата и время наступления события

    public EventFileAttribute(String guid, String file_guid, String member_guid) {
        super(guid);
        this.file_guid = file_guid;
        this.member_guid = member_guid;
        this.time = Calendar.getInstance(Locale.getDefault()).getTimeInMillis();
    }

    @NotNull
    public String getFile_guid() {
        return file_guid;
    }

    public void setFile_guid(@NotNull String file_guid) {
        this.file_guid = file_guid;
    }

    @NotNull
    public String getMember_guid() {
        return member_guid;
    }

    public void setMember_guid(@NotNull String member_guid) {
        this.member_guid = member_guid;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
