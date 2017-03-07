package com.example.lyk.cmm4;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by lyk on 2017/1/2.
 */

public class Setting {
    public static int[] themes = {R.color.darcula, android.R.color.darker_gray, android.R.color.white};
    public static void setTheme(Context context, int color) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("cmm4", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (color != 0)
            editor.putInt("divider", 0);
        else
            editor.putInt("divider", 2);
        editor.putInt("color", color);
        editor.commit();
    }
    public static int getTheme(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("cmm4", Context.MODE_PRIVATE);
        return sharedPreferences.getInt("color",0);
    }
    public static int getDivider(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("cmm4", Context.MODE_PRIVATE);
        return sharedPreferences.getInt("divider",2);
    }
    public static void setScreenOriention(Context context, int orien) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("cmm4", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("orien", orien);
        editor.commit();
    }
    public static int getScreenOriention(Context context)
    {
       SharedPreferences sharedPreferences = context.getSharedPreferences("cmm4", Context.MODE_PRIVATE);
        return sharedPreferences.getInt("orien",0);
    }
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    public static void setTextSize(Context context,int size)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("cmm4", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("size", size);
        editor.commit();
    }
    public static int getTextSize(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("cmm4", Context.MODE_PRIVATE);
        return sharedPreferences.getInt("size",19);
    }

}
