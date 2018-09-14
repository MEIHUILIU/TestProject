package com.example.testrecyleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<TextBean> beans = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initAdapter();

    }

    private void initView(){
        recyclerView = findViewById(R.id.rv_recyleview);
    }

    private void initData(){
        for (int i = 0; i < 10; i++) {
            TextBean bean = new TextBean();
            bean.setText("test"+i);
            beans.add(bean);
        }
    }

    private void initAdapter(){
        RecyleViewAdapter adapter = new RecyleViewAdapter(MainActivity.this,beans);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }
}
