package com.polysoin;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.polysoin.dummy.DrugDummyContent;
import com.polysoin.dummy.DrugHistoryDummyContent;
import com.polysoin.dummy.DummyItem;

import java.util.Date;

/**
 * A fragment representing a list of Items.
 */
public class TabFragment1 extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private MyTabRecyclerViewAdapter1 myTabRecyclerViewAdapter1;
    private MyPagerAdapter myPagerAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TabFragment1() {
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
        View view = inflater.inflate(R.layout.fragment_tab_list1, container, false);
        myTabRecyclerViewAdapter1 = new MyTabRecyclerViewAdapter1(DrugDummyContent.ITEMS, DrugHistoryDummyContent.ITEMSHISTORY, mListener, this);

        // Set the adapter
        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        if (mColumnCount <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }
        recyclerView.setAdapter(myTabRecyclerViewAdapter1);

        //button add
        FloatingActionButton fab = view.findViewById(R.id.qr_code_btn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrugDummyContent.addItem(DrugDummyContent.createDummyItem(DrugDummyContent.ITEMS.size() + DrugHistoryDummyContent.ITEMSHISTORY.size(), "medoc", "un cachet", new Date()));
                myPagerAdapter.addUpdate();
            }
        });
        return view;
    }

    public void update() {
        myTabRecyclerViewAdapter1.notifyDataSetChanged();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(DummyItem item);
    }

    public void setMyPagerAdapter(MyPagerAdapter myPagerAdapter) {
        this.myPagerAdapter = myPagerAdapter;
    }

    public MyPagerAdapter getMyPagerAdapter() {
        return myPagerAdapter;
    }
}
