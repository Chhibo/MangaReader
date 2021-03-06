package com.example.mangareader;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class SplashScreen extends Fragment {
    private static SplashScreen splash_screen;
    private FragmentListener fl;

    public SplashScreen(){
        //require empty public constructor
    }

    public static SplashScreen createSplashScreen(MainActivity mainActivity){
        if(splash_screen==null){
            splash_screen = new SplashScreen();
            splash_screen.fl = mainActivity;
        }
        return splash_screen;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.splash_screen,container,false);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            fl.showPage(FragmentListener.MANGAKING);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        return view;
    }
}
