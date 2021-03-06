package com.msc.grus_japonenis.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

import com.msc.grus_japonenis.lib.injection.ApplicationComponent;
import com.msc.lib.utils.ScreenManager;

import autogo.internal.AutoAssigner;
import autogo.internal.AutoAssistantManager;
import me.majiajie.swipeback.SwipeBackActivity;


public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        BaseActivity.colorChange(this, Color.parseColor("#44000000"));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        setupActivityComponent(BaseApplication.get().getComponent());
//        Auto.assign(this);
        ScreenManager.getScreenManager().pushActivity(this);
    }

    public abstract int setContentViewIds();

    protected abstract void setupActivityComponent(ApplicationComponent appComponent);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ScreenManager.getScreenManager().popActivity(this);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //主界面左上角的icon点击反应
                this.finishAfterTransition();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (getCurrentFocus() != null
                    && getCurrentFocus().getWindowToken() != null) {
                return ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(getCurrentFocus()
                                        .getWindowToken(),
                                InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
        return super.onTouchEvent(event);
    }

//    @Override
//    public void startActivity(Intent intent) {
//        super.startActivity(intent);
//        overridePendingTransition(R.anim.fade, R.anim.hold);
//    }
//
//    @Override
//    public void finish() {
//        super.finish();
//        overridePendingTransition(R.anim.fade, R.anim.hold);
//    }

    /**
     */
    public static void colorChange(Activity activity, int RGBValues) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.setStatusBarColor(RGBValues);
            window.setNavigationBarColor(RGBValues);
        }
    }

}
