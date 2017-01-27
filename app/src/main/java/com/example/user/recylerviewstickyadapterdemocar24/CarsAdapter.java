package com.example.user.recylerviewstickyadapterdemocar24;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.recylerviewstickyadapterdemocar24.sticky.StickyHeaderAdapter;
import com.example.user.recylerviewstickyadapterdemocar24.sticky.StickyHeaderDecoration;

import java.util.ArrayList;

/**
 * Created by Mushareb Ali on 1/25/2017.
 * mushareba.ali@cars24.com
 */

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.ViewHolder> implements StickyHeaderAdapter<CarsAdapter.HeaderHolder> {
    ArrayList<String> arrayList;
    Context mContext;
    private LayoutInflater mInflater;
    public CarsAdapter(Context context, ArrayList<String> list) {
        this.arrayList=list;
        this.mContext=context;
        mInflater=LayoutInflater.from(context);
    }

    @Override
    public CarsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = mInflater.inflate(R.layout.item_test, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.item.setText(arrayList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
       TextView item;
        public ViewHolder(View itemView) {
            super(itemView);
            item=(TextView) itemView.findViewById(R.id.text);
        }
    }

/*
* Header View Adapter
* */

    @Override
    public long getHeaderId(int position) {
        if (position == 0) { // don't show header for first item
            return StickyHeaderDecoration.NO_HEADER_ID;
        }
        return (long) position / 7;
    }

    @Override
    public HeaderHolder onCreateHeaderViewHolder(ViewGroup parent) {
        final View view = mInflater.inflate(R.layout.header_layout, parent, false);
        return new HeaderHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(HeaderHolder viewholder, int position) {
        viewholder.textHeader.setText("Header " + getHeaderId(position));
    }
    class HeaderHolder extends RecyclerView.ViewHolder {
        public TextView textHeader;

        public HeaderHolder(View itemView) {
            super(itemView);

            textHeader = (TextView) itemView.findViewById(R.id.textHeader);
        }
    }
}
