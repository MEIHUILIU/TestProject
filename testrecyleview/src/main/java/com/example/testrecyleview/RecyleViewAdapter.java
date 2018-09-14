package com.example.testrecyleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyleViewAdapter extends RecyclerView.Adapter<RecyleViewAdapter.RecyleViewHolder>{
    Context mContext;
    List<TextBean> beans = new ArrayList<>();

    public RecyleViewAdapter(Context mContext,List<TextBean> beans){
        this.mContext = mContext;
        this.beans.clear();
        this.beans.addAll(beans);
    }


    @NonNull
    @Override
    public RecyleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.item_text,null,true);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        itemView.setLayoutParams(lp);

        return new RecyleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyleViewHolder recyleViewHolder, int i) {
        recyleViewHolder.text.setText(beans.get(i).getText());
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    class RecyleViewHolder extends RecyclerView.ViewHolder{
        private TextView text;

        public RecyleViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.tv_text);
        }
    }
}
