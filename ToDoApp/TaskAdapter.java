package com.example.todoappfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class TaskAdapter extends ArrayAdapter<String> {

    private Context context;
    private List<String> tasksList;

    public TaskAdapter(Context context, List<String> tasksList) {
        super(context, 0, tasksList);
        this.context = context;
        this.tasksList = tasksList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        String task = tasksList.get(position);
        TextView textView = view.findViewById(android.R.id.text1);
        textView.setText(task);

        return view;
    }
}

