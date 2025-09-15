package com.example.mypersonlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {

    Context context;
    ArrayList<Person> list;
    LayoutInflater inflater;

    public ItemAdapter(Context context, ArrayList<Person> list) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PersonHolder holder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.customlayout, null);
            holder = new PersonHolder();
            holder.imageView = convertView.findViewById(R.id.imageView1);
            holder.textView = convertView.findViewById(R.id.textView1);
            convertView.setTag(holder);
        } else holder = (PersonHolder) convertView.getTag();

        holder.imageView.setImageResource(list.get(position).getImage() );
        holder.textView.setText(list.get(position).getName());

        return convertView;
    }

    static class PersonHolder {
        ImageView imageView;
        TextView textView;
    }
}
