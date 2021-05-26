package com.example.buscustomerapplicationv2.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buscustomerapplicationv2.R;

import java.util.List;

public class MyArrayAdapter extends RecyclerView.Adapter<MyArrayAdapter.ViewHolder> {

    private static final String TAG = MyArrayAdapter.class.getSimpleName() ;
    private final Context context;

    List<String> list;
    public MyArrayAdapter(Context context,List<String> list) {
        this.context = context;
        this.list=list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.pass_element, parent, false);
        MyArrayAdapter.ViewHolder viewHolder = new MyArrayAdapter.ViewHolder(v);
        viewHolder.setIsRecyclable(true);
        Log.w(TAG," onCreateViewHolder : "+ viewType);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView passNameTV;
//        public final TextView routeApplicableTV;
//        public final TextView remainingTV;
        public final TextView expiryTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            passNameTV=itemView.findViewById(R.id.pass_name_element);
//            routeApplicableTV=itemView.findViewById(R.id.route_element);
//            remainingTV=itemView.findViewById(R.id.trips_element);
            expiryTV=itemView.findViewById(R.id.status_element);

        }
    }



}
