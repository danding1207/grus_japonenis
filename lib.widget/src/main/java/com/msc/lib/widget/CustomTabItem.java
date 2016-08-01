package com.msc.lib.widget;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by msc on 2016/3/25.
 */
public class CustomTabItem extends FrameLayout {

    private ImageView imageView;
    private boolean selected;
    private TextView textView;

    public CustomTabItem(Context paramContext) {
        this(paramContext, null);
    }

    public CustomTabItem(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public CustomTabItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.custom_tab_item, this);
        this.imageView = ((ImageView) findViewById(R.id.imageView));
        this.textView = ((TextView) findViewById(R.id.textView));
    }

    public void animationWithOffset(float paramFloat) {
        ViewCompat.setScaleX(this.imageView, paramFloat);
        ViewCompat.setScaleY(this.imageView, paramFloat);
        ViewCompat.setScaleX(this.textView, 1.0F - paramFloat);
        ViewCompat.setScaleY(this.textView, 1.0F - paramFloat);
    }

    public void configItem(String paramString, int paramInt) {
        this.textView.setText(paramString);
        this.imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), paramInt));
    }

    public ImageView getImageView() {
        return this.imageView;
    }

    public TextView getTextView() {
        return this.textView;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean paramBoolean) {
        float f2, f1 = 0.0F;
        if (paramBoolean == this.selected)
            return;
        this.selected = paramBoolean;
        if (isSelected()) {
            f1 = 1.0F;
            f2 = 0.0F;
        } else {
            f1 = 0.0F;
            f2 = 1.0F;
        }
        ViewCompat.animate(this.imageView).cancel();
        ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1 = ViewCompat.animate(this.imageView);
        localViewPropertyAnimatorCompat1 = localViewPropertyAnimatorCompat1.scaleX(f1);
        ViewCompat.animate(this.textView).cancel();
        ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2 = ViewCompat.animate(this.textView);
        localViewPropertyAnimatorCompat2 = localViewPropertyAnimatorCompat2.scaleX(f2);
        localViewPropertyAnimatorCompat1.scaleY(f1).setDuration(200L).start();
        localViewPropertyAnimatorCompat2.scaleY(f2).setDuration(200L).start();
    }

}
