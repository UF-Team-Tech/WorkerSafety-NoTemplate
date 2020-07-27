package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    // Provide a direct reference to each of the views within a data item
// Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public Button messageButton;
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.workerid);
            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }
    private List<ListStuff> mContacts;
    // Pass in the contact array into the constructor
    public MyAdapter(List<ListStuff> contacts) {
        mContacts = contacts;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.row_layout, parent, false);
        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        // Get the data model based on position
        ListStuff worker = mContacts.get(position);
        // Set item views based on your views and data model
        TextView workerid = viewHolder.nameTextView;
        workerid.setBackgroundColor(Color.CYAN);
        workerid.setText(worker.getWorkerid());

        TextView firstname = viewHolder.nameTextView;
        firstname.setBackgroundColor(Color.BLUE);
        firstname.setText(worker.getWorkerid());

        TextView lastname = viewHolder.nameTextView;
        lastname.setBackgroundColor(Color.BLUE);
        lastname.setText(worker.getWorkerid());

        Button status = viewHolder.messageButton;
        status.setText(worker.getStatus());
        status.setTextColor(Color.BLACK);
        if(worker.getStatus().equals("Red")) {
            status.setBackgroundColor(0xFFDD0000);
            status.setTextColor(Color.WHITE);
        }
        else if(worker.getStatus().equals("Yellow"))
            status.setBackgroundColor(0xFFFFCC00);
        else if(worker.getStatus().equals("Green"))
            status.setBackgroundColor(0xFF34DF00);
        else
            status.setBackgroundColor(Color.GRAY);
        //status.setEnabled(worker.isOnline());
    }
    @Override
    public int getItemCount() {
        return mContacts.size();
    }
}