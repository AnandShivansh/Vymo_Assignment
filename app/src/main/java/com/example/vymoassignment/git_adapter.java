package com.example.vymoassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class git_adapter extends ArrayAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<git_class> list;
    git_adapter(Context context, int resource, List<git_class> objects) {
        super(context, resource, objects);
        this.context = context;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(inflater == null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null)
        {
            view = inflater.inflate(R.layout.list_item,null);
        }
        TextView title,number,status,created;
        title=view.findViewById(R.id.tiitleid);
        number=view.findViewById(R.id.numberid);
        status=view.findViewById(R.id.statusid);
        created=view.findViewById(R.id.createdid);

        git_class gitclass = list.get(position);
        if(title!=null)
        {
            title.setText(gitclass.getTitle());
        }
        if(number!=null)
        {
            number.setText(gitclass.getNumber());
        }
        if(status!=null)
        {
            status.setText(gitclass.getStatus());
        }
        if(created!=null)
        {
            created.setText(gitclass.getCreated());
        }
        return view;
    }
}
