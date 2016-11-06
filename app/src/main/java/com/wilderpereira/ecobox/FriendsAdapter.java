package com.wilderpereira.ecobox;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Wilder on 06/11/16.
 */

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder>{
    private List<Friend> mDataset;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, andØØ
    // you provide access to all the views for a data item in a view holder
    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        TextView friendName;
        TextView friendLevel;
        ImageView img;

        ViewHolder(View v) {
            super(v);
            friendName = (TextView) v.findViewById(R.id.tv_friend_name);
            friendLevel = (TextView) v.findViewById(R.id.tv_friend_level);
        }
    }

    public FriendsAdapter(List<Friend> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public FriendsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        // create a new view
        View v = LayoutInflater.from(context).inflate(R.layout.friend_item, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        final Friend friend = mDataset.get(position);

        holder.friendName.setText(friend.getName());
        holder.friendLevel.setText(""+friend.getLevel());



    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}