package com.idjmao.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1djmao on 2017/8/31.
 */

public class TableView extends RecyclerView {

    public Boolean tv_headersOnTop;

    public Boolean tv_scrollingEnabled;

    public int tv_header_borders_color;
    public int tv_header_background_color;

    public int tv_data_borders_color;
    public int tv_data_background_color;

    public int tv_radius;

    public int tv_padding;

    public String[] headers;

    public List<String[]> data;

    public int columnCount;

    public TableView(Context context) {
        super(context);
    }

    public TableView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TableView);

        tv_header_borders_color = a.getColor(R.styleable.TableView_tv_header_borders_color, getContext().getColor(R.color.md_grey_500));
        tv_header_background_color = a.getColor(R.styleable.TableView_tv_header_background_color, context.getColor( R.color.md_grey_300));

        tv_data_borders_color = a.getColor(R.styleable.TableView_tv_data_borders_color, context.getColor( R.color.md_grey_500));
        tv_data_background_color = a.getColor(R.styleable.TableView_tv_data_background_color, context.getColor(R.color.md_white_1000));

        tv_radius = a.getInteger(R.styleable.TableView_tv_radius, 0);

        tv_padding = a.getInteger(R.styleable.TableView_tv_padding, 0);

        tv_headersOnTop = a.getBoolean(R.styleable.TableView_tv_headersOnTop, true);

        tv_scrollingEnabled = a.getBoolean(R.styleable.TableView_tv_scrollingEnabled, true);

        if (!tv_scrollingEnabled) {
            setClickable(false);
            setFocusable(false);
            setNestedScrollingEnabled(false);
        }

//        tableViewAdapter = new TableViewAdapter(getContext(), this);
//
//        setAdapter(tableViewAdapter);

        a.recycle();

        data=new ArrayList<>();

    }

    public TableView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

//    public void setItems(List<List<Cell>> items) {
//
//        headers = new ArrayList<>();
//        data = new ArrayList<>();
//
//        tableViewAdapter.setItems(this);
//
//        if (tv_headersOnTop) {
//            columnCount = items.size();
//
//            count = 0;
//            for (List<Cell> column : items) {
//                count += column.size();
//
//                headers.add(column.get(0));
//                column.remove(0);
//
//                data.add(column);
//            }
//
//        } else {
//            columnCount = items.size();
//
//            count = items.get(0).size();
//
//            headers.addAll(items.get(0));
//            items.remove(0);
//
//            for (List<Cell> column : items) {
//                count += column.size();
//                data.add(column);
//            }
//
//        }
//
//        setLayoutManager(new CustomGridLayoutManager(getContext(), columnCount, tv_scrollingEnabled));
//
//        addItemDecoration(new TableViewDivider(this));
//    }

    /**
     * 设置表头
     * @param headers
     */
    public TableView setHeader(String... headers) {
        this.headers=headers;
        return this;
    }

    /**
     * 设置表格内容
     * @param content
     */
    public TableView setContent(List<String[]> content){
        data=content;
        return this;
    }

    /**
     * 为表格增加行
     */
    public TableView addRowContent(String... strings){

        data.add(strings);
        return this;
    }

    /**
     * 设置 adpter 刷新显示
     */
    public void refreshTable(){
        if (headers==null){
            tv_headersOnTop=false;
        }

        if (headers!=null){
            columnCount=headers.length;
        }else if (data.size()>0){
            columnCount=data.get(0).length;
        }else {
            columnCount=0;
        }
        TableViewAdapter adapter=new TableViewAdapter(this);
        setAdapter(adapter);
        setLayoutManager(new CustomGridLayoutManager(getContext(), columnCount, tv_scrollingEnabled));
        addItemDecoration(new TableViewDivider(this));
    }

    /**
     * 点击监听
     */
    public interface OnTableItemClickListener {
        public void itemClickListener(String content,int row, int column);
    }

    public OnTableItemClickListener mTableItemClickListener;

    public void setOnTableItemClickListener(OnTableItemClickListener tableItemClickListener) {
        mTableItemClickListener = tableItemClickListener;
    }
}