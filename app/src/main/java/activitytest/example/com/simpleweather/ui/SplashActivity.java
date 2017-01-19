package activitytest.example.com.simpleweather.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import activitytest.example.com.simpleweather.MainActivity;
import activitytest.example.com.simpleweather.R;

/**
 * Created by asus on 2017/1/18.
 * 描述：首页动画
 */

public class SplashActivity extends AppCompatActivity {

    private TextView tv_splash;
      //组合动画
    private AnimationSet set;
      //时间
    private int animTime = 2000;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1001:
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));  //跳转到MainActivity
                    finish();
                    break;
            }
        }
    };
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    //初始化View
    private void initView() {
        tv_splash = (TextView) findViewById(R.id.tv_splash);

        //是否共用一个动画补间
        set = new AnimationSet(true);
        set.setDuration(animTime);
        //动画执行完之后保持状态
        set.setFillAfter(true);

        //缩放
        ScaleAnimation scale = new ScaleAnimation(0, 1, 0, 1);
        scale.setDuration(animTime);
        set.addAnimation(scale);

        //平移
        TranslateAnimation translate = new TranslateAnimation(0, 0, 0, -200);
        translate.setDuration(animTime);
        set.addAnimation(translate);

        //执行动画
        tv_splash.startAnimation(set);

        //动画监听
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                  //动画启动时调用
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                handler.sendEmptyMessageDelayed(1001, 500);
                //动画结束时调用
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //动画重复时调用
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

}