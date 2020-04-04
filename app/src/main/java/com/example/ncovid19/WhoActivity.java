package com.example.ncovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class WhoActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 1200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who);
        TextView textView = (TextView)findViewById(R.id.link1);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView2 = (TextView)findViewById(R.id.link2);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView3 = (TextView)findViewById(R.id.link3);
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView4 = (TextView)findViewById(R.id.link4);
        textView4.setMovementMethod(LinkMovementMethod.getInstance());

        CircleMenu circleMenu = findViewById(R.id.circlemenu);
        final String[] menus = {
                "Twitter",
                "Who"
        };
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.ic_add,R.drawable.ic_clear)
                .addSubMenu(Color.parseColor("#00ACEE"),R.drawable.twitter_icon)
                .addSubMenu(Color.parseColor("#C0C0C0"),R.drawable.who_icon)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        if(index==0) {
                            Toast.makeText(WhoActivity.this, "WHO Official " + menus[index] + " Handle", Toast.LENGTH_SHORT).show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/who?lang=en"));
                                    startActivity(browserIntent);
                                }
                            },SPLASH_TIME_OUT);
                        }
                        else if(index==1){
                            Toast.makeText(WhoActivity.this, "WHO Official Website", Toast.LENGTH_SHORT).show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.who.int/"));
                                    startActivity(browserIntent);
                                }
                            },SPLASH_TIME_OUT);
                        }
                    }
                });
    }
}
