package com.ldroid.kwei.floatingmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.ldroid.kwei.floatingmenu.floatingmenu.FloatingActionButton;
import com.ldroid.kwei.floatingmenu.floatingmenu.FloatingActionMenu;
import com.ldroid.kwei.floatingmenu.floatingmenu.SubActionButton;

public class MainActivity extends AppCompatActivity {

    private FloatingActionMenu mCircleMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFloatingMenu() ;
    }


    private void initFloatingMenu(){
        ImageView centerActionButton = (ImageView) findViewById(R.id.iv_main_center_btn);

//        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
//                .setContentView(centerActionButton)
//                .build();


        final ImageView a = new ImageView(this); a.setBackgroundResource(R.mipmap.icon_upphoto);
        final ImageView b = new ImageView(this); b.setBackgroundResource(R.mipmap.icon_shangcheng);
        final ImageView c = new ImageView(this); c.setBackgroundResource(R.mipmap.icon_upmessage);
        FrameLayout.LayoutParams tvParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        a.setLayoutParams(tvParams);
        b.setLayoutParams(tvParams);
        c.setLayoutParams(tvParams);
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == a) {
                } else if (v == b) {
                } else if (v == c) {
                }
            }
        };
        a.setOnClickListener(clickListener);
        b.setOnClickListener(clickListener);
        c.setOnClickListener(clickListener);

        SubActionButton.Builder subBuilder = new SubActionButton.Builder(this);
        mCircleMenu = new FloatingActionMenu.Builder(this)
                .setStartAngle(-50)
                // 第一个菜单起始位置 0 表示一圈
                .setEndAngle(-130)
                .setRadius(getResources().getDimensionPixelSize(R.dimen.radius_medium))
                .addSubActionView(a).addSubActionView(b).addSubActionView(c)
                .attachTo(centerActionButton).build();

    }
}
