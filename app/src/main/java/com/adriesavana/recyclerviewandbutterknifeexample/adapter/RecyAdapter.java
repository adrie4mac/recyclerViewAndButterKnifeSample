package com.adriesavana.recyclerviewandbutterknifeexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adriesavana.recyclerviewandbutterknifeexample.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Adrie on 10/5/15.
 */
public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ViewHolder>
{
    private final Context ctx;
    private List<String> model;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position)
    {
        View view = LayoutInflater.from(ctx).inflate(R.layout.row_list, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position)
    {
        viewHolder.txtData.setText(model.get(position));
    }

    @Override
    public int getItemCount()
    {
        return model.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        @Bind(R.id.txtName)TextView txtData;

        public ViewHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public RecyAdapter(Context context, List<String> data)
    {
        this.ctx = context;
        this.model = data;
    }
}
