package com.mycoloruniverse.health.view;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.mycoloruniverse.health.R;
import com.mycoloruniverse.health.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberListAdapter extends RecyclerView.Adapter<MemberListAdapter.RatesViewHolder> {
    private final List<Member> list = new ArrayList<>();
    private int layoutId;

    public MemberListAdapter(int layoutId) {
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public MemberListAdapter.RatesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                        inflate(this.layoutId, parent, false);

        return new MemberListAdapter.RatesViewHolder(view);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(@NonNull MemberListAdapter.RatesViewHolder holder, int position) {
        Member member = list.get(position);

        holder.tvMemberName.setText(member.getName());
        holder.tvMemberBirthday.setText(member.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<Member> list) {
        if (list != null) {
            this.list.addAll(list);
            this.notifyDataSetChanged();
        }
    }

    public List<Member> getList() {
        return this.list;
    }


    class RatesViewHolder extends ViewHolder {
        private final TextView tvMemberName;
        private final TextView tvMemberBirthday;

        @SuppressLint("CheckResult")
        public RatesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMemberName = itemView.findViewById(R.id.tvMemberName);
            tvMemberBirthday = itemView.findViewById(R.id.tvMemberBirthday);
        }
    }
}
