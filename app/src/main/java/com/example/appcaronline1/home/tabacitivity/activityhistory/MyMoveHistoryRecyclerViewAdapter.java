package com.example.appcaronline1.home.tabacitivity.activityhistory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appcaronline1.R;

import java.util.List;


public class MyMoveHistoryRecyclerViewAdapter extends RecyclerView.Adapter<MyMoveHistoryRecyclerViewAdapter.ViewHolder> {

    private final List<Move> moveList;

    public MyMoveHistoryRecyclerViewAdapter(List<Move> items) {
        moveList = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_move_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.move = moveList.get(position);
        holder.moveFrom.setText(moveList.get(position).moveFrom);
        holder.moveTo.setText(moveList.get(position).moveTo);
        holder.timeStart.setText(moveList.get(position).start);
        holder.timeEnd.setText(moveList.get(position).end);
    }

    @Override
    public int getItemCount() {
        return moveList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final TextView moveFrom;
        public final TextView moveTo;
        public final TextView timeStart;
        public final TextView timeEnd;
        public Move move;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            moveFrom = (TextView) view.findViewById(R.id.tv_fragment_move_from);
            moveTo = (TextView) view.findViewById(R.id.tv_fragment_move_to);
            timeStart = (TextView) view.findViewById(R.id.tv_fragment_time_start);
            timeEnd = (TextView) view.findViewById(R.id.tv_fragment_time_end);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + moveFrom.getText() + "'";
        }
    }
}