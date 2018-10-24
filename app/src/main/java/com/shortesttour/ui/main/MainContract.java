package com.shortesttour.ui.main;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;

public class MainContract {
    public interface View extends Presenter{
        AppCompatActivity getActivity();
        void onFinishCalculatePath(int[] path);
        void onFinishDrawPath(List<PolylineOptions> polylineOptions);
    }

    public interface Presenter{

    }
}
