package activitytest.example.com.simpleweather.ui;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by asus on 2017/1/18.
 * 描述：关于页面
 */

public class AboutActivity extends BaseActivity {

    private ListView mListView;
    private ArrayList<String> mList = new ArrayList<>();
    private ListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activitytest.example.com.simpleweather.R.layout.activity_about);

        initView();
    }

    private void initView() {
        mListView = (ListView) findViewById(activitytest.example.com.simpleweather.R.id.mListView);

        mList.add("作者:梁竞");
        mList.add("QQ:1184106223");
        mList.add("GitHub:https://github.com/liangjingdev");

        mAdapter = new activitytest.example.com.simpleweather.adapter.ListAdapter(this,mList);
        mListView.setAdapter(mAdapter);

    }
}