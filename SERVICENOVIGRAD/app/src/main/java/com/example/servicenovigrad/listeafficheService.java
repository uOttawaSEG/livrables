package com.example.servicenovigrad;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class listeafficheService extends ArrayAdapter {
    private Activity context;
    private List<services> servicesList;
    public listeafficheService(Activity context,List<services> servicesList){
        super(context,R.layout.liste,servicesList);
        this.context = context;
        this.servicesList = servicesList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.liste, null, true);

        TextView n = (TextView) listViewItem.findViewById(R.id.textViewliste1);
        TextView m = (TextView) listViewItem.findViewById(R.id.textViewliste2);
        services service = servicesList.get(position);
        n.setText(service.getServiceName());
        m.setText(service.getDatecreation());
        return listViewItem;

    }
}
