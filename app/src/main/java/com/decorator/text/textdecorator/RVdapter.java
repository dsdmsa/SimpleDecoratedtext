package com.decorator.text.textdecorator;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.decorator.text.textdecor.PrettyText;
import com.decorator.text.textdecor.TextDecor;

import org.w3c.dom.Text;

public class RAdapter extends RecyclerView.Adapter<RAdapter.MyViewHolder> {

    private Context context;

    public RAdapter(Context context) {
        this.context = context;
    }

    TextDecor decor1 = new TextDecor.Builder()
            .decorate(TextDecor.setBackground(Color.BLUE))
            .decorate(TextDecor.UNDERLINE)
            .decorate(TextDecor.addShadow(4,4,5,Color.BLACK))
            .decorate(TextDecor.setTextColor(Color.GREEN))
            .build();

    TextDecor decor2 = new TextDecor.Builder()
            .decorate(TextDecor.setRoundBackground(9,1,new LinearGradient(45,1,1,5,Color.CYAN,Color.BLUE, Shader.TileMode.CLAMP),Color.BLACK))
            .decorate(TextDecor.absoluteTextSize(35))
            .decorate(TextDecor.font(context, "fonts/Roboto-Thin.ttf"))
            .build();

    TextDecor line = new TextDecor.Builder()
            .decorate(TextDecor.setBackground(Color.WHITE))
            .decorate(TextDecor.setTextColor(Color.BLACK))
            .decorate(TextDecor.BOLD)
            .decorate(TextDecor.STRINKE)
            .build();



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(
                line.withText("\n------------------------------------------------------\n"),
                "Position " + position,
                "\n",
                decor2.withText(Integer.toString(position)),
                decor1.withText("\n decor 1\n"),
                decor2.withText(" decor 2 \n"),
                decor1.withText("\n decor 1\n"),
                decor2.withText(" decor 2 \n"),
                " last simpel text ",
                MainActivity.rbackg.withText("\n some string form main activity decor\n"),
//                MainActivity.rbackg.withText("\n"+ Integer.toString(position)+"\n"),
                "bet",
                line.withText("\n------------------------------------------------------\n")
        );
    }

    @Override
    public int getItemCount() {
        return 1000;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public PrettyText title;

        public MyViewHolder(View view) {
            super(view);
            title = (PrettyText) view.findViewById(R.id.pritty);

        }
    }
}

