package com.polysoin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
    private TabFragment1 tabFragment1;

    public MyTabRecyclerViewAdapter1(List<DummyItem> items, List<DummyItem> itemsHistory, OnListFragmentInteractionListener listener, TabFragment1 tabFragment1) {
        mValues = items;
        mValuesHistory = itemsHistory;
        mListener = listener;
        this.tabFragment1 = tabFragment1;
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
        //System.out.println(holder.isTaken);
        if (!holder.isTaken) {
            holder.mTitleView.setText(mValues.get(position).title + mValues.get(position).id);
            holder.mDetailView.setText(mValues.get(position).details);

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mListener) {
                        // Notify the active callbacks interface (the activity, if the
                        // fragment is attached to one) that an item has been selected.
                        mListener.onListFragmentInteraction(holder.mItem);
                    }
                }
            });
        } else {
            holder.mItem.isTaken = true;
        }
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final View mView;
        public final TextView mTitleView;
        public final TextView mDetailView;
        public boolean isTaken = false;
        public DummyItem mItem;
        public CheckBox checkBox;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTitleView = view.findViewById(R.id.item_title);
            mDetailView = view.findViewById(R.id.detail);
            checkBox = view.findViewById(R.id.isTaken);

            //item click event listener
            view.setOnClickListener(this);

            //checkbox click event handling
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        buttonView.setChecked(true);
                        isTaken = true;
                        mValues.get(getPosition()).isTaken = true;
                        mValuesHistory.add(mValues.get(getPosition()));
                        removeAt(getPosition());
                        tabFragment1.getMyPagerAdapter().removeUpdate();
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

        @Override
        public void onClick(View v) {
        }
    }
}
