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


    public void makeJump(TimeInterpolator timeInterpolator)
    {

        ImageView foogle = (ImageView) findViewById(R.id.imageView10);
        float height = 600;
        float propertyStart = 0f;

        float propertyEnd = -(height - (float)foogle.getHeight()/2);
        String propertyName = "translationY";
        ObjectAnimator jump = ObjectAnimator.ofFloat(foogle,propertyName, propertyStart, propertyEnd);

        jump.setDuration(750);
        jump.setRepeatCount(1);
        jump.setRepeatMode(ObjectAnimator.REVERSE);
        jump.setInterpolator(timeInterpolator);
        jump.start();

    }

    public void jumping(View view)
    {

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


//      EXAMPLE CODE FROM         http://android-er.blogspot.com/2015/10/interpolator-effect-on-objectanimator.html
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

        ImageView startImage = (ImageView) findViewById(R.id.imageView10);

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
    //    rockStorm(null);
    }



}
