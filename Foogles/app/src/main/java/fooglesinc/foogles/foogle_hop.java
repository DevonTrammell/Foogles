package fooglesinc.foogles;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class foogle_hop extends AppCompatActivity {

    public static String message;
    public int score = 0;

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



    public void makeThrow(TimeInterpolator timeInterpolator)
    {
        ImageView thrownFoogle = (ImageView) findViewById(R.id.flyingFoogle);
        thrownFoogle.setVisibility(View.VISIBLE);

        float distance = 1600;
        float propertyStart = 0f;
        float propertyEnd = -(distance - (float)thrownFoogle.getHeight()/2);

        String propertyName = "translationX";

        ObjectAnimator toss = ObjectAnimator.ofFloat(thrownFoogle,propertyName, propertyStart, propertyEnd);


        toss.setDuration(1800);
        //toss.setRepeatCount(1);
        //toss.setRepeatMode(ObjectAnimator.REVERSE);
        toss.setInterpolator(timeInterpolator);
        toss.start();
    }

    public void tossFoogle(View view)
    {
        ImageView thrownFoogle = (ImageView) findViewById(R.id.flyingFoogle);
        thrownFoogle.setVisibility(View.VISIBLE);

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

        //thrownFoogle.setVisibility(View.VISIBLE);

        new CountDownTimer(3000, 3000)
        {

            public void onTick(long millisUntilFinished)
            {
                final AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();

                makeThrow(accelerateDecelerateInterpolator);
            }

            public void onFinish()
            {
                tossFoogle(null);
            }
        }.start();
    }


    public void makeJump(TimeInterpolator timeInterpolator)
    {

        ImageView foogle = (ImageView) findViewById(R.id.jumpingFoogle);

        float height = 750;
        float propertyStart = 0f;
        float propertyEnd = -(height - (float)foogle.getHeight()/2);

        String propertyName = "translationY";

        ObjectAnimator jump = ObjectAnimator.ofFloat(foogle,propertyName, propertyStart, propertyEnd);

        // foogle.setImageResource(R.drawable.sonic_walk3);

        jump.setDuration(700);
        jump.setRepeatCount(1);
        jump.setRepeatMode(ObjectAnimator.REVERSE);
        jump.setInterpolator(timeInterpolator);
        jump.start();

        //  foogle.setImageResource(R.drawable.sonic_walk3);
    }


    public void jumping(View view)
    {

         ImageView foogle = (ImageView) findViewById(R.id.jumpingFoogle);


        Button jump = (Button) findViewById(R.id.jumpButton);



        jump.setOnClickListener(new View.OnClickListener()
        {
           @Override
            public void onClick(View view)
           {
               final AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
               makeJump(accelerateDecelerateInterpolator);
           }
        });




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


        // possible collision detection idea link
        // https://stackoverflow.com/questions/19448816/collision-detection-using-objectanimation-or-translateanimation

    }


    public void startGame(View view){


        Button startButton = (Button) findViewById(R.id.button25);

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
                rewardFoogle(null);
                score = 0;
            }
        }.start();

        jumping(null);
        tossFoogle(null);

    }



}
