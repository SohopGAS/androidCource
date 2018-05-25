package com.shenkar.galargov.androidcource;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import java.util.ArrayList;

public class Animation extends AppCompatActivity {

    private AnimationLayout mLayout;
    private static int lastDir=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_animation);

        mLayout = new AnimationLayout(this);
        addPaints(Tangela.paints);
        setContentView(mLayout);
    }

    private void addPaints(ArrayList<Paint> paints) {
        paints.add(new Paint());
        paints.get(paints.size()-1).setColor(Color.BLACK);
        paints.get(paints.size()-1).setStyle(Paint.Style.STROKE);
        paints.add(new Paint());
        paints.get(paints.size()-1).setColor(Color.RED);
        paints.get(paints.size()-1).setStyle(Paint.Style.STROKE);
        paints.add(new Paint());
        paints.get(paints.size()-1).setColor(Color.BLUE);
        paints.get(paints.size()-1).setStyle(Paint.Style.STROKE);

        paints.add(new Paint());
        paints.get(paints.size()-1).setColor(Color.GRAY);
        paints.get(paints.size()-1).setStyle(Paint.Style.STROKE);

        paints.add(new Paint());
        paints.get(paints.size()-1).setColor(Color.YELLOW);
        paints.get(paints.size()-1).setStyle(Paint.Style.STROKE);

        paints.add(new Paint());
        paints.get(paints.size()-1).setColor(Color.rgb(100,59,70));
        paints.get(paints.size()-1).setStyle(Paint.Style.STROKE);







        //add more colors as u wish.... how many as u want:

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //ignore double actions (UP & DOWN)
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                //logic goes here

                mLayout.getTangelas().add(new Tangela(
                        50, 50,
                        rand(0, AnimationLayout.screenWidth),
                        rand(0, AnimationLayout.screenHeight),
                        lastDir,
                        lastDir));

                lastDir *= 1;
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mLayout.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLayout.resume();
    }

    private int rand(int min, int max) {
        return (int)(Math.random() * max + min);
    }
}
