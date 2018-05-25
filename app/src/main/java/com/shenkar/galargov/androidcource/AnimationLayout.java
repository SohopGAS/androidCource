package com.shenkar.galargov.androidcource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class AnimationLayout extends SurfaceView implements  Runnable{
    private Canvas mCanvas;
    private static ArrayList<Tangela> tangelas = new ArrayList<>();
    private SurfaceHolder surfaceHolder;
    private boolean canWePlay = false;
    private Thread mThread;
    public static int screenWidth, screenHeight;

    public AnimationLayout(Context context) {

        super(context);
        surfaceHolder = getHolder();


    }

    @Override
    public void run() {

        while(canWePlay) {

            if(!surfaceHolder.getSurface().isValid()){
                continue;
            }
            mCanvas = surfaceHolder.lockCanvas();
            screenHeight = mCanvas.getHeight();
            screenWidth = mCanvas.getWidth();

            //draw goes here:

            Paint bgPaint = new Paint();
            bgPaint.setColor(Color.GREEN);
            bgPaint.setStyle(Paint.Style.FILL);

            Rect r = new Rect(300, 300, screenWidth-300, screenHeight-300);
            mCanvas.drawRect(r, bgPaint);


            for(Tangela t : tangelas){
                t.draw(mCanvas, getHeight(), getWidth());
            }
//            RectF oval = new RectF();
//            mCanvas.drawArc(oval, 0F, 360F, true, ballPaint);




            surfaceHolder.unlockCanvasAndPost(mCanvas);
        }
    }

    public void pause() {
        canWePlay = false;
        tangelas.clear();
        while(true){
            try {
                mThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
        }

        mThread = null;
    }

    public void resume() {
        canWePlay = true;
        mThread = new Thread(this);
        mThread.start();
    }

    public static ArrayList<Tangela> getTangelas() {
        return tangelas;
    }
}
