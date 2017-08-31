# TableView
一个用于 Android 的简单表格控件。参考了 [android-tableView](https://github.com/simongiesen/android-tableView) 和 [TableView](https://github.com/KungFuBrother/TableView) 这两个库，使用了其中属性和样式设置类，重写了数据添加方式，添加了点击监听事件。

![](https://github.com/1djmao/TableView/blob/master/tableview.png?raw=true)

# 使用
## 引用
### Repository

工程中 build.gradle 文件添加 :

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

### Dependency
module 中 build.gradle 文件中添加（最新版本号查看 releases）:

```
dependencies {
	compile 'com.github.1djmao:TableView:LAST_RELEASE'
}
```
## 布局文件
```xml
    <com.chargemap_beta.android.tableView.library.TableView
        android:id="@+id/tableview"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:tv_data_background_color="@color/md_white_1000" <!-- Background color for data cells -->
        app:tv_data_borders_color="@color/md_grey_500" <!--  Borders color for data cells -->
        app:tv_header_background_color="@color/md_grey_300" <!--  Background color for header cells -->
        app:tv_header_borders_color="@color/md_grey_500" <!--  Borders color for header cells -->
        app:tv_scrollingEnabled="false" <!-- Scrolling ? -->
        app:tv_padding="8" /> <!--  padding -->
```
## 添加数据及点击监听
```
TableView tableView= (TableView) findViewById(R.id.table);
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
                Log.i("hhhhh", "itemClickListener: "+content);
            }
        });
```

