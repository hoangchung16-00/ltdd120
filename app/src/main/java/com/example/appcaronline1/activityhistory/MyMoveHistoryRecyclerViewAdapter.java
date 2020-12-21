package com.example.appcaronline1.activityhistory;

import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appcaronline1.R;
import com.example.appcaronline1.home.tabacitivity.activityhistory.Movement;
import com.example.appcaronline1.home.tabacitivity.activityhistory.OptionMoving;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MyMoveHistoryRecyclerViewAdapter extends RecyclerView.Adapter<MyMoveHistoryRecyclerViewAdapter.ViewHolder> {

    public static List<Move> movementList;


    public MyMoveHistoryRecyclerViewAdapter(List<Move> items) {
        movementList = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_move_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.move = movementList.get(position);
        holder.moveFrom.setText(movementList.get(position).moveFrom);
        holder.moveTo.setText(movementList.get(position).moveTo);
        holder.timeStart.setText(movementList.get(position).start);
        holder.timeEnd.setText(movementList.get(position).end);
        holder.option.setText(movementList.get(position).optionMoving.toString());
        holder.cash.setText(movementList.get(position).cash.toString());
    }

    @Override
    public int getItemCount() {
        return movementList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final TextView moveFrom;
        public final TextView moveTo;
        public final TextView timeStart;
        public final TextView timeEnd;
        public final TextView option;
        public final TextView cash;
        public Move move;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            moveFrom = (TextView) view.findViewById(R.id.tv_fragment_move_from);
            moveTo = (TextView) view.findViewById(R.id.tv_fragment_move_to);
            timeStart = (TextView) view.findViewById(R.id.tv_fragment_time_start);
            timeEnd = (TextView) view.findViewById(R.id.tv_fragment_time_end);
            option = (TextView) view.findViewById(R.id.option_id);
            cash = (TextView) view.findViewById(R.id.cash_id);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + moveFrom.getText() + "'";
        }
    }
}