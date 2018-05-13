package fooglesinc.foogles;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class foogle_hop extends AppCompatActivity {

    public static String message;
    public int score = 0;
    public boolean isJumping = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_foogle_hop);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.FOOGLE_NAME);

        TextView scoreDisplay = findViewById(R.id.textView5);
        scoreDisplay.setText(Integer.toString(score));

        ImageView flyingFoogle = (ImageView) findViewById(R.id.flyingFoogle);
        flyingFoogle.setVisibility(View.INVISIBLE);
    }
    //TODO
    /*
    * Pass to rewards screen
    * store in database
    * */

    public void rewardFoogle(View view)
    {
        Intent intent = new Intent(this, Rewards.class);
        intent.putExtra(MainActivity.FOOGLE_NAME, message);

        startActivity(intent);
    }





    public void makeJump(TimeInterpolator timeInterpolator)
    {
        ImageView foogle = (ImageView) findViewById(R.id.jumpingFoogle);

        float height = 750;
        float propertyStart = 0f;
        float propertyEnd = -(height - (float)foogle.getHeight()/2);

        isJumping = true;

        String propertyName = "translationY";

        ObjectAnimator jump = ObjectAnimator.ofFloat(foogle,propertyName, propertyStart, propertyEnd);

        jump.setDuration(700);
        jump.setRepeatCount(1);
        jump.setRepeatMode(ObjectAnimator.REVERSE);
        jump.setInterpolator(timeInterpolator);
        jump.start();
    }


    public void jumping(View view)
    {
        ImageButton jump = (ImageButton) findViewById(R.id.jumpButton);

        jump.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();


                makeJump(accelerateDecelerateInterpolator);


                new CountDownTimer(700, 700)
                {
                    public void onTick(long millisUntilFinished)
                    {
                        if(millisUntilFinished <= 700)
                        {
                            isJumping = true;

                            ImageView foogle = (ImageView) findViewById(R.id.jumpingFoogle);

                            foogle.setImageResource(R.drawable.mvp_walk3);
                        }
                    }

                    public void onFinish()
                    {
                        isJumping = false;
                    }
                }.start();
            }
        });
    }




    public void makeThrow(TimeInterpolator timeInterpolator)
    {
        ImageView thrownFoogle = (ImageView) findViewById(R.id.flyingFoogle);
        thrownFoogle.setVisibility(View.VISIBLE);

        float distance = 1600;
        float propertyStart = 0f;
        float propertyEnd = -(distance - (float)thrownFoogle.getWidth()/2);

        String propertyName = "translationX";

        ObjectAnimator toss = ObjectAnimator.ofFloat(thrownFoogle,propertyName, propertyStart, propertyEnd);

// was 2000
        toss.setDuration(2000);
        toss.start();
    }

    public void chooseDangerColor(View view)
    {
        ImageView thrownFoogle = (ImageView) findViewById(R.id.flyingFoogle);

        Random colorChoice = new Random();

        int min = 1, max = 5;
        int dangerColor = 0;

        dangerColor = colorChoice.nextInt((max - min) + 1) + min;


        switch(dangerColor)
        {
            case 1:
                thrownFoogle.setImageResource(R.drawable.green_walk3);
                break;
            case 2:
                thrownFoogle.setImageResource(R.drawable.mono_walk3);
                break;
            case 3:
                thrownFoogle.setImageResource(R.drawable.mvp_walk3);
                break;
            case 4:
                thrownFoogle.setImageResource(R.drawable.purple_walk3);
                break;
            case 5:
                thrownFoogle.setImageResource(R.drawable.sonic_walk3);
                break;
            default:
                thrownFoogle.setImageResource(R.drawable.green_walk3);
        }
    }



    public void tossFoogle(View view)
    {
        ImageView thrownFoogle = (ImageView) findViewById(R.id.flyingFoogle);

        final ImageView jumpFoogle = (ImageView) findViewById(R.id.jumpingFoogle);

        final boolean jumpCheck = isJumping;

        thrownFoogle.setVisibility(View.VISIBLE);

        chooseDangerColor(null);


        final AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();

        makeThrow(accelerateDecelerateInterpolator);

        new CountDownTimer(2000, 100)
        {
            public void onTick(long millisUntilFinished)
            {
                if(millisUntilFinished <= 1400 && isJumping == false)
                {
                    jumpFoogle.setImageResource(R.drawable.hurtmvp);
                }
            }
            public void onFinish()
            {
                jumpFoogle.setImageResource(R.drawable.mvp_walk2);
                tossFoogle(null);
            }
        }.start();
    }


//      EXAMPLE ANIMATION CODE FROM         http://android-er.blogspot.com/2015/10/interpolator-effect-on-objectanimator.html
//
//        Button btnAccelerateInterpolator = (Button)findViewById(R.id.bAccelerateInterpolator);
//
//        btnAccelerateInterpolator.setOnClickListener(new View.OnClickListener() {
//
//           @Override
//            public void onClick(View v) {
//                prepareObjectAnimator(accelerateInterpolator);
//            }
//        });




    public void startGame(View view){


        ImageButton startButton = (ImageButton) findViewById(R.id.playHopButton);

        startButton.setVisibility(View.INVISIBLE);

        ImageView startImage = (ImageView) findViewById(R.id.jumpingFoogle);
        ImageView thrownFoogle = (ImageView) findViewById(R.id.flyingFoogle);

//        upClick(null); //begin on the top of the screen

        final ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar3);

        new CountDownTimer(30000, 1000)
        {
            final TextView scoreDisplay = findViewById(R.id.textView5);

            public void onTick(long millisUntilFinished)
            {
                progressBar.incrementProgressBy(1); //max is set to 30 and increments until max is hit
                score++;
                scoreDisplay.setText(Integer.toString(score));
            }

            public void onFinish() {
                SharedPreferences sp = getSharedPreferences("MyPrefs",0);
                SharedPreferences.Editor editor = sp.edit();
                int n = sp.getInt("score",0);
                n += score;
                editor.putInt("score",n);
                editor.apply();
                rewardFoogle(null);
                score = 0;
            }
        }.start();

        jumping(null);
        tossFoogle(null);

    }



}
