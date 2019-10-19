package com.polysoin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.polysoin.TabFragment1.OnListFragmentInteractionListener;
import com.polysoin.dummy.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class MyTabRecyclerViewAdapter1 extends RecyclerView.Adapter<MyTabRecyclerViewAdapter1.ViewHolder> {

    private final List<DummyItem> mValues;
    private final List<DummyItem> mValuesHistory;
    private final OnListFragmentInteractionListener mListener;

    public MyTabRecyclerViewAdapter1(List<DummyItem> items, List<DummyItem> itemsHistory, OnListFragmentInteractionListener listener) {
        mValues = items;
        mValuesHistory = itemsHistory;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_tab1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTitleView.setText(mValues.get(position).title);
        holder.mDetailView.setText(mValues.get(position).details);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTitleView;
        public final TextView mDetailView;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTitleView = view.findViewById(R.id.item_title);
            mDetailView = view.findViewById(R.id.detail);
            final Button button = view.findViewById(R.id.isTaken);

            //Button click event handling
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!mItem.isTaken) {
                        mItem.isTaken = true;
                        mValuesHistory.add(mItem);
                        removeAt(mValues.indexOf(mItem));
                        mListener.onListFragmentInteraction(button, mItem.id);
                    }
                }
            });
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mDetailView.getText() + "'";
        }

        public void removeAt(int position) {
            mValues.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, mValues.size());
        }
    }
}
