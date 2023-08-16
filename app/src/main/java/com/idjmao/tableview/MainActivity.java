package com.idjmao.tableview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.idjmao.library.TableView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableView tableView = (TableView) findViewById(R.id.table);
        tableView
                .setHeader("区域", "人数", "占比")
                .addRowContent("北京", "50", "50%")
                .addRowContent("上海", "30", "30%")
                .addRowContent("广东", "20", "20%")
                .addRowContent("深圳", "10", "10%")
                .refreshTable();
        tableView.setOnTableItemClickListener(new TableView.OnTableItemClickListener() {
            @Override
            public void itemClickListener(String content, int row, int column) {
                
            }
        });

    }
}
