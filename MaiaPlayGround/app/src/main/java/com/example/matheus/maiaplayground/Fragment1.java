package com.example.matheus.maiaplayground;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
/**
 * Created by Matheus on 16/06/2016.
 */
public class Fragment1 extends android.support.v4.app.Fragment {


    private ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        ListView listView = (ListView)view.findViewById(R.id.listview);
        listView.setAdapter(new ListAdapter(getActivity()));
        listView.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = (String) parent.getAdapter().getItem(position);
                Toast.makeText(getActivity(), s + " Posição: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


}
