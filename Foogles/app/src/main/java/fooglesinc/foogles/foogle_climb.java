package fooglesinc.foogles;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Random;

public class foogle_climb extends AppCompatActivity {

    public static String message;
    public int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_foogle_climb);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.FOOGLE_NAME);

        Button leftButton = (Button) findViewById(R.id.button21);
        Button rightButton = (Button) findViewById(R.id.button22);

        leftButton.setVisibility(View.INVISIBLE);
        rightButton.setVisibility(View.INVISIBLE);

        ImageView leftRock = (findViewById(R.id.imageView11));
        ImageView rightRock = (findViewById(R.id.imageView12));

        ImageView rope = (findViewById(R.id.ROPING));

        leftRock.setVisibility(View.INVISIBLE);
        rightRock.setVisibility(View.INVISIBLE);

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

        //pass score to next activity
        //to be saved in foogle stats

        startActivity(intent);
    }

   public void fallLeft(View view)
   {
       ImageView leftRock = (findViewById(R.id.imageView11));

       leftRock.setVisibility(View.VISIBLE);

       ObjectAnimator fallingLeft = ObjectAnimator.ofFloat(leftRock, "translationY", 0f, 900f);

       fallingLeft.setDuration(3000);

       // the linear interpolator was an attempt at repeating the animation
       // feel free to try and make that approach work.

       //    fallingLeft.setInterpolator(new LinearInterpolator());
       //    fallingLeft.setRepeatMode(ObjectAnimator.RESTART);

       fallingLeft.start();
   }

   public void fallRight(View view)
   {
       ImageView rightRock = (findViewById(R.id.imageView12));

       rightRock.setVisibility(View.VISIBLE);

       ObjectAnimator fallingRight = ObjectAnimator.ofFloat(rightRock, "translationY", 0f, 900f);

       fallingRight.setDuration(3000);

       fallingRight.start();
   }

    public void rockStorm(View view)
    {

        final ImageView leftAnim = (ImageView) findViewById(R.id.walking_anim2);

        final ImageView rightAnim = (ImageView) findViewById(R.id.walking_anim3);

        //generate a random number to determine which side will fall
        Random sideChoice = new Random();

        int left = 1, right = 2;
        int dangerSide = 0;

        dangerSide = sideChoice.nextInt((right - left) + 1) + left;

        if(dangerSide == left)
        {
            fallLeft(null);

            //these timers call the rock storm recursively and allow the
            //looping effect of each rock

            // we can fake object collision by taking the 4 second fall animation into account
            // and saying that if the player is on the corresponding side of the fall
            // when the object animation is almost out of time, it got hit

            new CountDownTimer(2000, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    final TextView scoreDisplay = findViewById(R.id.textView5);

                    if(millisUntilFinished <= 1000
                            && leftAnim.getVisibility() == View.VISIBLE
                            && rightAnim.getVisibility() == View.INVISIBLE )
                    {
                        score -= 5;
                        scoreDisplay.setText(Integer.toString(score));
                    }
                }

                public void onFinish(){rockStorm(null);}
            }.start();
        }
        else if (dangerSide == right)
        {
            fallRight(null);

            new CountDownTimer(2000, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    final TextView scoreDisplay = findViewById(R.id.textView5);

                    if(millisUntilFinished <= 1000
                            && leftAnim.getVisibility()  == View.INVISIBLE
                            && rightAnim.getVisibility() == View.VISIBLE )
                    {
                        score -= 5;
                        scoreDisplay.setText(Integer.toString(score));
                    }
                }

                public void onFinish(){rockStorm(null);}
            }.start();
        }
    }

    public void startGame(View view){


        Button startButton = (Button) findViewById(R.id.button25);
        Button leftButton = (Button) findViewById(R.id.button21);
        Button rightButton = (Button) findViewById(R.id.button22);

        ImageView startImage = (ImageView) findViewById(R.id.imageView10);

        //set left and right buttons visible while rendering the start image and button invisible
        leftButton.setVisibility(View.VISIBLE);
        rightButton.setVisibility(View.VISIBLE);
        startButton.setVisibility(View.INVISIBLE);
        startImage.setVisibility(View.INVISIBLE);

        TranslateAnimation roping = new TranslateAnimation(0,0,200,700);
        roping.setDuration(1500);
        roping.setRepeatCount(20);
        //roping.setFillAfter(true);

        ImageView rope = findViewById(R.id.outside);
        rope.startAnimation(roping);

        TranslateAnimation clouds = new TranslateAnimation(350,-300,0,0);
        clouds.setDuration(5000);
        clouds.setRepeatCount(6);

        ImageView cloud = findViewById(R.id.right);
        cloud.startAnimation(clouds);

        leftClick(null); // initially begin on the left side of the screen

        // call the progress bar and set up the main timer for the game
        final ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar3);

        //30 second countdown by 1 second intervals
        new CountDownTimer(30000, 1000)
        {
            final TextView scoreDisplay = findViewById(R.id.textView5);

            public void onTick(long millisUntilFinished)
            {
                progressBar.incrementProgressBy(1); //progressBar's android:max in the XML is set to 30, this increments until max is hit
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

            rockStorm(null);
    }

    public void leftClick(View view) {

        final ImageView leftAnim = (ImageView) findViewById(R.id.walking_anim2);

        leftAnim.setBackgroundResource(R.drawable.walk_anim);

        AnimationDrawable WeWalking = (AnimationDrawable) leftAnim.getBackground();

        WeWalking.stop();
        WeWalking.start();

        final ImageView rightAnim = (ImageView) findViewById(R.id.walking_anim3);

        rightAnim.setBackgroundResource(R.drawable.walk_anim);

        AnimationDrawable NoWalking = (AnimationDrawable) leftAnim.getBackground();

        NoWalking.stop();
        NoWalking.start();

        leftAnim.setVisibility(View.VISIBLE);
        rightAnim.setVisibility(View.INVISIBLE);
    }

    public void rightClick(View view) {

        final ImageView rightAnim = (ImageView) findViewById(R.id.walking_anim3);

        rightAnim.setBackgroundResource(R.drawable.walk_anim);

        AnimationDrawable WeWalking = (AnimationDrawable) rightAnim.getBackground();

        WeWalking.stop();
        WeWalking.start();

        final ImageView leftAnim = (ImageView) findViewById(R.id.walking_anim2);
        leftAnim.setBackgroundResource(R.drawable.walk_anim);

        AnimationDrawable NoWalking = (AnimationDrawable) leftAnim.getBackground();

        NoWalking.stop();
        NoWalking.start();

        rightAnim.setVisibility(View.VISIBLE);
        leftAnim.setVisibility(View.INVISIBLE);
    }
}
