package com.example.ncovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

public class HomeActivity extends AppCompatActivity {
FlipperLayout flipper;
ImageButton myImageButton1, myImageButton2, myImageButton3;
    private static int SPLASH_TIME_OUT = 1200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        flipper = (FlipperLayout)findViewById(R.id.flipper); //For the slider
        setLayout();
        myImageButton1 = (ImageButton)findViewById(R.id.imageButton2); //For WHO image button
        myImageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(HomeActivity.this, WhoActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        myImageButton2 = (ImageButton)findViewById(R.id.imageButton3); //For MOHFW image button
        myImageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mohfw.gov.in/"));
                startActivity(browserIntent);
            }
        });


        myImageButton3 = (ImageButton)findViewById(R.id.imageButton4); //For Covid Visualizer image button
        myImageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(HomeActivity.this, Covid_VisualActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        CircleMenu circleMenu = findViewById(R.id.circlemenu1);
        final String[] menus = {
                "Whatsapp",
                "Who",
                "Funds"

        };
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.ic_add,R.drawable.ic_clear)
                .addSubMenu(Color.parseColor("#4FCE5D"),R.drawable.whatsapp_icon)
                .addSubMenu(Color.parseColor("#000000"),R.drawable.ic_localphone)
                .addSubMenu(Color.parseColor("#FFD700"),R.drawable.funds_icon)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        if(index==0) {
                            Toast.makeText(HomeActivity.this, "MYGOV Corona Helpdesk", Toast.LENGTH_SHORT).show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=919013151515&text=Namaste&source=&data="));
                                    startActivity(browserIntent);
                                }
                            },SPLASH_TIME_OUT);
                        }
                        else if(index==1){
                            Toast.makeText(HomeActivity.this, "Helpline Numbers", Toast.LENGTH_SHORT).show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mohfw.gov.in/pdf/coronvavirushelplinenumber.pdf"));
                                    startActivity(browserIntent);
                                }
                            },SPLASH_TIME_OUT);
                        }
                        else if(index==2){
                            Toast.makeText(HomeActivity.this, "Donation for PM Cares fund and state relief funds", Toast.LENGTH_SHORT).show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent intentLoadNewActivity1 = new Intent(HomeActivity.this, FundsActivity.class);
                                    startActivity(intentLoadNewActivity1);
                                }
                            },SPLASH_TIME_OUT);
                        }

                    }
                });
    }
    private void setLayout(){
        String url[]=new String[]{
                "https://conferences.computer.org/ccem/2017/images/bng_png.png",
                "https://www.cdc.gov/coronavirus/2019-ncov/images/2019-coronavirus.png",
                "https://www.crs.org/sites/default/files/prevention_tips_infographic_resized.jpg",
                "https://www.cdc.gov/coronavirus/2019-ncov/images/social/covid19-prevention-fb.png"
        };
        for (int i=0;i<4;i++){
            FlipperView view = new FlipperView(getBaseContext());
            view.setImageScaleType(ImageView.ScaleType.FIT_XY);
            view.setImageUrl(url[i]);
            flipper.addFlipperView(view);
            view.setOnFlipperClickListener(new FlipperView.OnFlipperClickListener() {
                @Override
                public void onFlipperClick(FlipperView flipperView) {
                    Toast.makeText(HomeActivity.this, ""+(flipper.getCurrentPagePosition()+1), Toast.LENGTH_SHORT).show();

                }
            });

        }
    }
}
