package com.idjmao.library;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1djmao on 2017/8/31.
 */

public class TableViewAdapter extends RecyclerView.Adapter<TableViewAdapter.CallViewHolder>{
    
    TableView mTableView;
    List<String> mList;

    public TableViewAdapter(TableView mTableView) {
        this.mTableView = mTableView;
        mList=new ArrayList<>();
        if (mTableView.headers!=null){
            for (int i = 0; i < mTableView.columnCount; i++) {
                mList.add(mTableView.headers[i]);
            }
        }
        if (mTableView.data!=null){
            for (String[] strings:mTableView.data) {
                for (int i = 0; i < mTableView.columnCount; i++) {
                    mList.add(strings[i]);
                }
            }
        }


    }

    @Override
    public CallViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CallViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_cell, parent, false));
    }

    @Override
    public void onBindViewHolder(CallViewHolder holder, final int position) {

        holder.title.setText(mList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTableView.mTableItemClickListener!=null){
                    mTableView.mTableItemClickListener.itemClickListener(mList.get(position),position/mTableView.columnCount,position%mTableView.columnCount);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    /**
     * 点击监听
     */
    public interface OnItemClickListener{
        public void itemClickListener(int pos);
    }

    private OnItemClickListener mItemClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    class CallViewHolder extends RecyclerView.ViewHolder{
        TextView title;

        RelativeLayout container;
        public CallViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);

            container = (RelativeLayout) itemView.findViewById(R.id.container);
        }
    } 
}
