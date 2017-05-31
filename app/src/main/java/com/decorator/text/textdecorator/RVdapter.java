package com.decorator.text.textdecorator;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.decorator.text.textdecor.PrettyText;

public class RVdapter extends RecyclerView.Adapter<RVdapter.MyViewHolder> {

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(
                App.getBold().withText("Name at : "),
                "Position " + position,
                App.getRoundCorrner2().withText(" OK ")
        );
    }

    @Override
    public int getItemCount() {
        return 1000;
    }


    /**
     * MyViewHolder, holder for views
     */
    static class MyViewHolder extends RecyclerView.ViewHolder {

        private PrettyText title;

        MyViewHolder(View view) {
            super(view);
            title = (PrettyText) view.findViewById(R.id.pritty);

        }
    }
}

