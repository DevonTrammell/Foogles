package fooglesinc.foogles;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Random;

public class foogle_swim extends AppCompatActivity {

    public static String message;
    public int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foogle_swim);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.FOOGLE_NAME);

        Button leftButton = (Button) findViewById(R.id.button21);
        Button rightButton = (Button) findViewById(R.id.button22);

        leftButton.setVisibility(View.INVISIBLE);
        rightButton.setVisibility(View.INVISIBLE);

        ImageView leftRock = (findViewById(R.id.imageView11));
        ImageView rightRock = (findViewById(R.id.imageView12));

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

        startActivity(intent);
    }

    public void fallLeft(View view)
    {
        ImageView leftRock = (findViewById(R.id.imageView11));

        leftRock.setVisibility(View.VISIBLE);

        ObjectAnimator fallingLeft = ObjectAnimator.ofFloat(leftRock, "translationY", 0f, 900f);

        fallingLeft.setDuration(3000);

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

    public void PKStarfall(View view)
    {

        final ImageView leftAnim = (ImageView) findViewById(R.id.walking_anim2);

        final ImageView rightAnim = (ImageView) findViewById(R.id.walking_anim3);

        Random sideChoice = new Random();

        int left = 1, right = 2;
        int dangerSide = 0;

        dangerSide = sideChoice.nextInt((right - left) + 1) + left;

        if(dangerSide == left)
        {
            fallLeft(null);

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

                public void onFinish(){PKStarfall(null);}
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

                public void onFinish(){PKStarfall(null);}
            }.start();
        }
    }

    public void startGame(View view){


        Button startButton = (Button) findViewById(R.id.button25);
        Button leftButton = (Button) findViewById(R.id.button21);
        Button rightButton = (Button) findViewById(R.id.button22);

        ImageView startImage = (ImageView) findViewById(R.id.imageView10);

        leftButton.setVisibility(View.VISIBLE);
        rightButton.setVisibility(View.VISIBLE);
        startButton.setVisibility(View.INVISIBLE);
        startImage.setVisibility(View.INVISIBLE);

        leftClick(null); //begin on the left side of the screen

        final ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar3);

        new CountDownTimer(30000, 1000)
        {
            final TextView scoreDisplay = findViewById(R.id.textView5);

            public void onTick(long millisUntilFinished)
            {
                progressBar.incrementProgressBy(1); //progressBar max is set to 30 and increments until max is hit
                score++;
                scoreDisplay.setText(Integer.toString(score));
            }

            public void onFinish() {
                rewardFoogle(null);
                score = 0;
            }
        }.start();

        PKStarfall(null);
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
