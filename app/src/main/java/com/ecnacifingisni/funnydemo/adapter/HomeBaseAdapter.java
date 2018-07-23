package com.ecnacifingisni.funnydemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ecnacifingisni.funnydemo.Base.HomeBaseMsg;
import com.ecnacifingisni.funnydemo.R;
import com.ecnacifingisni.funnydemo.bean.SliteLvItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * funnydemo
 *
 * @author sjw
 * @date 2018/7/23.
 */
public class HomeBaseAdapter extends BaseAdapter {
    private List<SliteLvItemBean> list;
    private Context context;

    public HomeBaseAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return list.size();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_slite_lv, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textView = convertView.findViewById(R.id.tv_name_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        try {
            SliteLvItemBean bean = list.get(position);
            viewHolder.textView.setText(bean.getName());
        } catch (Exception e) {
            viewHolder.textView.setText(" ");
        }
        return convertView;
    }

    public void setList(List<SliteLvItemBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    static class ViewHolder {
        TextView textView;
    }
}
