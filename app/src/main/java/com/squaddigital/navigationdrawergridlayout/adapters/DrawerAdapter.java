package com.squaddigital.navigationdrawergridlayout.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squaddigital.navigationdrawergridlayout.models.DrawerItem;
import com.squaddigital.navigationdrawergridlayout.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by darshanz on 7/6/15.
 */
public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.DrawerViewHolder> {

    public final static int TYPE_HEADER = 0;
    public final static int TYPE_HEADER_TITLE=8;
    public final static int TYPE_MENU = 1;


    private ArrayList<DrawerItem> drawerMenuList;

    private OnItemSelecteListener mListener;

    public DrawerAdapter(ArrayList<DrawerItem> drawerMenuList) {
        this.drawerMenuList = drawerMenuList;
    }

    @Override
    public DrawerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType == TYPE_HEADER){

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_drawer_header, parent, false);

        }else if(viewType==TYPE_HEADER_TITLE){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_divider, parent, false);

        }else {

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_menu_item, parent, false);
        }

        return new DrawerViewHolder(view, viewType);
    }


    @Override
    public void onBindViewHolder(DrawerViewHolder holder, int position) {
        if(position == 0 ) {
            holder.headerText.setText("Header Text");
        }else if(position==5){
            holder.textViewTitle.setText("Settings");
        }
        else if(position==8){
        holder.textViewTitle.setText("Settings");
        }
        else{
            holder.title.setText(drawerMenuList.get(position - 1).getTitle());
            holder.icon.setImageResource(drawerMenuList.get(position - 1).getIcon());
//            holder.linearLayout.setBackgroundColor(drawerMenuList.get(position-1).getLayoutBgColor());

        }

    }

    @Override
    public int getItemCount() {

        return drawerMenuList.size()+1 ;

    }



    @Override
    public int getItemViewType(int position) {

        if(position == 0){
            return  TYPE_HEADER;
        }else if(position==5){
            return TYPE_HEADER_TITLE;

        }else if(position==8){
            return TYPE_HEADER_TITLE;

        }
        else{
            return TYPE_MENU;
        }

    }

    class DrawerViewHolder extends RecyclerView.ViewHolder{

        TextView headerText;
        TextView subtitle;
        CircleImageView  circleImageView;

        TextView title;
        LinearLayout linearLayout;
        ImageView icon;

        TextView textViewTitle;
        View viewDivider;

        public DrawerViewHolder(View itemView, int viewType) {
            super(itemView);


            if(viewType == 0){
                headerText = (TextView)itemView.findViewById(R.id.headerText);
                subtitle=(TextView)itemView.findViewById(R.id.subTitle);
                circleImageView=(CircleImageView) itemView.findViewById(R.id.imgProfilePicture);

            }else if (viewType==5){
                textViewTitle= (TextView)itemView.findViewById(R.id.textViewTitleName);
                viewDivider = itemView.findViewById(R.id.viewDivider);
            }else if (viewType==8){
                textViewTitle= (TextView)itemView.findViewById(R.id.textViewTitleName);
                viewDivider = itemView.findViewById(R.id.viewDivider);
            }
            else {
                title = (TextView) itemView.findViewById(R.id.title);
                icon = (ImageView) itemView.findViewById(R.id.icon);
                linearLayout=(LinearLayout) itemView.findViewById(R.id.linearlayoutItem);
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemSelected(view, getAdapterPosition());

                }
            });
        }

    }




    public void setOnItemClickLister(OnItemSelecteListener mListener) {
        this.mListener = mListener;
    }

   public interface OnItemSelecteListener{
        public void onItemSelected(View v, int position);
    }

}