package com.luyunfeng.drawabletextview;

/**
 * Created by luyunfeng on 16/12/22.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.widget.TextView;

public class DrawableTextView extends TextView {

    private int imageSize;
    private int leftImageSize;
    private int rightImageSize;
    private int topImageSize;
    private int bottomImageSize;

    private Drawable leftImage;
    private Drawable topImage;
    private Drawable rightImage;
    private Drawable bottomImage;

    public DrawableTextView(Context context) {
        this(context, null);
    }

    public DrawableTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.DrawableTextView, 0, 0);
        leftImage = ta.getDrawable(R.styleable.DrawableTextView_leftImage);
        topImage = ta.getDrawable(R.styleable.DrawableTextView_topImage);
        rightImage = ta.getDrawable(R.styleable.DrawableTextView_rightImage);
        bottomImage = ta.getDrawable(R.styleable.DrawableTextView_bottomImage);
        leftImageSize = ta.getDimensionPixelSize(R.styleable.DrawableTextView_leftImageSize, 0);
        rightImageSize = ta.getDimensionPixelSize(R.styleable.DrawableTextView_rightImageSize, 0);
        topImageSize = ta.getDimensionPixelSize(R.styleable.DrawableTextView_topImageSize, 0);
        bottomImageSize = ta.getDimensionPixelSize(R.styleable.DrawableTextView_bottomImageSize, 0);
        imageSize = ta.getDimensionPixelSize(R.styleable.DrawableTextView_imageSize, 50);

        ta.recycle();

        refresh();
    }

    private void refresh() {
        setCompoundDrawablesWithIntrinsicBounds(leftImage, topImage, rightImage, bottomImage);
    }

    @Override
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        setBounds(left, leftImageSize);
        setBounds(top, topImageSize);
        setBounds(right, rightImageSize);
        setBounds(bottom, bottomImageSize);
        setCompoundDrawables(left, top, right, bottom);
    }

    public void setRightImageSize(@DimenRes int dimen) {
        rightImageSize = getSize(dimen);
        refresh();
    }

    public void setRightImage(@DrawableRes int drawableId) {
        rightImage = getDrawable(drawableId);
        refresh();
    }

    public void setRightImage(@DrawableRes int drawableId, @DimenRes int dimen) {
        rightImage = getDrawable(drawableId);
        rightImageSize = getSize(dimen);
        refresh();
    }

    public void setTopImageSize(@DimenRes int dimen) {
        topImageSize = getSize(dimen);
        refresh();
    }

    public void setTopImage(@DrawableRes int drawableId) {
        topImage = getDrawable(drawableId);
        refresh();
    }

    public void setTopImage(@DrawableRes int drawableId, @DimenRes int dimen) {
        topImage = getDrawable(drawableId);
        topImageSize = getSize(dimen);
        refresh();
    }

    public void setBottomImageSize(@DimenRes int dimen) {
        bottomImageSize = getSize(dimen);
        refresh();
    }

    public void setBottomImage(@DrawableRes int drawableId) {
        bottomImage = getDrawable(drawableId);
        refresh();
    }

    public void setBottomImage(@DrawableRes int drawableId, @DimenRes int dimen) {
        bottomImage = getDrawable(drawableId);
        bottomImageSize = getSize(dimen);
        refresh();
    }

    public void setLeftImageSize(@DimenRes int dimen) {
        leftImageSize = getSize(dimen);
        refresh();
    }

    public void setLeftImage(@DrawableRes int drawableId) {
        leftImage = getDrawable(drawableId);
        refresh();
    }

    public void setLeftImage(@DrawableRes int drawableId, @DimenRes int dimen) {
        leftImage = getDrawable(drawableId);
        leftImageSize = getSize(dimen);
        refresh();
    }

    private int getSize(@DimenRes int dimen) {
        return getResources().getDimensionPixelSize(dimen);
    }

    private Drawable getDrawable(@DrawableRes int drawableId) {
        return getResources().getDrawable(drawableId);
    }

    private void setBounds(Drawable drawable, int size) {
        if (drawable != null) {
            if (size == 0) size = imageSize;
            drawable.setBounds(0, 0, size, getConstrainHeight(drawable, size));
        }
    }

    private int getConstrainHeight(Drawable drawable, int imageWidth) {
        return (int) (drawable.getIntrinsicHeight() * 1f / drawable.getIntrinsicWidth() * imageWidth);
    }
}