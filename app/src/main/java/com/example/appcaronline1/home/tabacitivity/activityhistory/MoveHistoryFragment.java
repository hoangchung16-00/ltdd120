package com.example.appcaronline1.home.tabacitivity.activityhistory;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcaronline1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class MoveHistoryFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MoveHistoryFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_history_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            List<Move> moveList = createList();
            recyclerView.setAdapter(new MyMoveHistoryRecyclerViewAdapter(moveList));
        }
        return view;
    }
    public List<Move> createList(){
        List<Move> list = new ArrayList<Move>();
        Move move1 = new Move("Hải Châu","Sơn Trà","23/2/2020 14:25","23/2/2020 14:40");
        Move move2 = new Move("Hải Châu","Sơn Trà","23/2/2020 14:25","23/2/2020 14:40");
        list.add(move1);
        list.add(move2);
        return list;
    }
}