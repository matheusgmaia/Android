package com.example.matheus.maiaplayground;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Matheus on 16/06/2016.
 */
public class ListAdapter extends BaseAdapter {
    private Context context;
    private String[] elementos = new String[]{"SMILE", "FELIZ", "SMILE", "FELIZ", "SMILE", "FELIZ", "SMILE", "FELIZ", "SMILE", "FELIZ", "SMILE"};

    public ListAdapter(Context context){
        super();
        this.context = context;
    }

    @Override
    public int getCount() {
        return elementos.length;
    }

    @Override
    public Object getItem(int position) {
        return elementos[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String elemento = elementos[position];
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_listview, parent, false);
        TextView t = (TextView) view.findViewById(R.id.textView);
        t.setText(elemento);
        return view;

    }
}
