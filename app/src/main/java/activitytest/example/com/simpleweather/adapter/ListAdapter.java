package activitytest.example.com.simpleweather.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import activitytest.example.com.simpleweather.R;

/**
 * Created by asus on 2017/1/18.
 * 描述：列表适配器
 */

public class ListAdapter extends BaseAdapter{
    private Context mContext;
    private LayoutInflater inflater;
    private ArrayList<String> mList;

    public ListAdapter(Context mContext, ArrayList<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item, null);
            viewHolder.tv_item = (TextView) convertView.findViewById(R.id.tv_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_item.setText(mList.get(position));
        return convertView;
    }

    class ViewHolder {
        private TextView tv_item;
    }
}
