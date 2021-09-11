package jain.pranjal.dailyhisab;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by hp on 6/24/2019.
 */

public class App  {

    public static void finishActivity(AppCompatActivity appCompatActivity)
    {
        appCompatActivity.finish();
    }

    public static void refreshActivity(AppCompatActivity appCompatActivity) {
        appCompatActivity.recreate();
    }


}

