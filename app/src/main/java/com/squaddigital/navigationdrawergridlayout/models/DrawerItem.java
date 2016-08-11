package com.squaddigital.navigationdrawergridlayout.models;

import android.graphics.Color;

/**
 * Created by darshanz on 7/6/15.
 */
public class DrawerItem {

    private int icon;
    private String title;
    private int layoutBgColor;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getLayoutBgColor() {
        return layoutBgColor;
    }

    public void setLayoutBgColor(int layoutBgColor) {
        this.layoutBgColor = layoutBgColor;
    }
}