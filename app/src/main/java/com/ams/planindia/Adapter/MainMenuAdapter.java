package com.ams.planindia.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ams.planindia.Model.MenuActivityPojo;
import com.ams.planindia.R;

import java.util.ArrayList;
import java.util.List;

import static android.icu.text.DisplayContext.LENGTH_SHORT;


public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.ViewHolder>    {


    private  static final  String TAG = "RecyclerVierwAdapter";
    private ArrayList<MenuActivityPojo>  menuNamesArrayList;
    private  Context mContext;



    public MainMenuAdapter(ArrayList<MenuActivityPojo> menuNamesArrayList, Context mContext) {
        this.menuNamesArrayList = menuNamesArrayList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_menu_layout,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        Log.d(TAG,"onBindViewHolder: Called.");

        final MenuActivityPojo menuList = menuNamesArrayList.get(viewHolder.getAdapterPosition());
        viewHolder.menu_name.setText( menuList.getMenuName());

        viewHolder.menuLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
String s = menuList.getMenuName();
                Toast.makeText(mContext,s,Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return menuNamesArrayList.size();
    }


    public  class ViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout menuLayout;
        TextView menu_name;

        // Constructor
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            menu_name = itemView.findViewById(R.id.menuName);
            menuLayout = itemView.findViewById(R.id.parent_layout);
        }

    }

}
