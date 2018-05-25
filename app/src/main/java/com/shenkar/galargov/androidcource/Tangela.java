package com.shenkar.galargov.androidcource;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

public class Tangela {

    private int height = 0;
    private int width = 0;
    private int x = 0;
    private int y = 0;
    private int xDirection = 1;
    private int yDirection = 1;
    private int speed = 3;
    private int factor = 1;
    public static ArrayList<Paint> paints = new ArrayList<Paint>();

    public Tangela(int height, int weight, int x, int y, int xDirection, int yDirection) {
        this.height = height;
        this.width = weight;
        this.x = x;
        this.y = y;
        this.xDirection = xDirection;
        this.yDirection = yDirection;

    }

    public void move(int maxH, int maxW){
        //todo: check if we hit boundaries/tangela
        if (y >= maxH || y < 0)
            yDirection *= -1;
        if(x >= maxW || x < 0)
            xDirection *= -1;

        x += xDirection * speed * factor;
        y += yDirection * speed * factor;

    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getxDirection() {
        return xDirection;
    }

    public void setxDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    public int getyDirection() {
        return yDirection;
    }

    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    }

    public void draw(Canvas canvas, int maxH, int maxW) {
        Paint ballPaint = Tangela.randPaints();
        move(maxH, maxW);
        canvas.drawCircle(x, y, 30, ballPaint);

    }

    private static Paint randPaints() {
        return paints.get((int)(Math.random() * 1 + (paints.size()-1)));
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }
}
