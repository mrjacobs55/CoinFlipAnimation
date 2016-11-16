package com.example.mjacobs.coinflipanimation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.graphics.*;


/**
 * Created by mjacobs on 11/14/16.
 */
public class CoinView extends SurfaceView{

    public static enum Result {HEADS , TAILS, EDGE}
    private SurfaceHolder mHolder;
    private Bitmap mHeadsBitmap, mTailsBitmap, mCurrentBitmap;

    public CoinView(Context context){
        super(context);
        this.init();
    }

    public CoinView(Context context, AttributeSet attrs){
        super(context , attrs);
        this.init();
    }

    public CoinView(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init() {
        mHolder = getHolder();
        mHeadsBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.heads);
        mTailsBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tails);
        mCurrentBitmap = mHeadsBitmap;
    }

    public Result flip() {
        double _random = Math.random();
        Result _result = (_random < .5) ? Result.HEADS : Result.TAILS;
        mCurrentBitmap = (_result == Result.HEADS) ? mHeadsBitmap : mTailsBitmap;
        Canvas _canvas = this.mHolder.lockCanvas();
        _canvas.drawARGB(255,200,200,255);
        _canvas.drawBitmap(mCurrentBitmap, _canvas.getWidth()/2 - mCurrentBitmap.getWidth()/2,
                _canvas.getHeight() /2 - mCurrentBitmap.getHeight()/2, null);
        return _result;
        //6:49
    }

}
