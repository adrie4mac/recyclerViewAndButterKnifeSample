package com.adriesavana.recyclerviewandbutterknifeexample.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.adriesavana.recyclerviewandbutterknifeexample.R;
import com.adriesavana.recyclerviewandbutterknifeexample.adapter.RecyAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Adrie on 10/5/15.
 */
public class MainActivity extends Activity
{
    @Bind(R.id.actMain_inputData)EditText inputData;
    @Bind(R.id.recyclerview)RecyclerView recyclerview;

    private List<String> models;
    private RecyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        ButterKnife.bind(this);

        initComponent();
    }

    private void initComponent()
    {
        models = new ArrayList<>();
        adapter = new RecyAdapter(this, models);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);
    }

    @OnClick(R.id.actMain_btnAdd)
    public void clickBtnAdd()
    {
        if (!inputData.getText().toString().equals(""))
        {
            models.add(inputData.getText().toString());
            adapter.notifyDataSetChanged();

            inputData.setText("");
        }
    }
}
