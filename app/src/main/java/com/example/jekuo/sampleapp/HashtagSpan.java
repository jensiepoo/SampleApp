package com.example.jekuo.sampleapp;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.URLSpan;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;

public class HashtagSpan extends URLSpan {

    private final int color;
    private Typeface typeface;

    public HashtagSpan(String url, @ColorRes int color) {
        super(url);
        this.color = color;
    }

    @Override
    public void updateDrawState(@NonNull TextPaint paint) {
        if (typeface == null) {
            typeface = Typeface.create(paint.getTypeface(), Typeface.BOLD);
        }
        paint.setColor(color);
        paint.setTypeface(typeface);
        paint.setUnderlineText(false);
    }
}
