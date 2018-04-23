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

public class foogle_hop extends AppCompatActivity {

    public static String message;
    public int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foogle_hop);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.FOOGLE_NAME);

        Button upButton = (Button) findViewById(R.id.button21);
        Button downButton = (Button) findViewById(R.id.button22);

        upButton.setVisibility(View.INVISIBLE);
        downButton.setVisibility(View.INVISIBLE);

        ImageView highRock = (findViewById(R.id.imageView11));
        ImageView lowRock = (findViewById(R.id.imageView12));

        highRock.setVisibility(View.INVISIBLE);
        lowRock.setVisibility(View.INVISIBLE);

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

    public void throwHigh(View view)
    {
        ImageView highRock = (findViewById(R.id.imageView11));

        highRock.setVisibility(View.VISIBLE);

        ObjectAnimator throwingHigh = ObjectAnimator.ofFloat(highRock, "translationX", 0f, 900f);

        throwingHigh.setDuration(3000);

        throwingHigh.start();
    }

    public void throwLow(View view)
    {
        ImageView lowRock = (findViewById(R.id.imageView12));

        lowRock.setVisibility(View.VISIBLE);

        ObjectAnimator throwingLow = ObjectAnimator.ofFloat(lowRock, "translationX", 0f, 900f);

        throwingLow.setDuration(3000);

        throwingLow.start();
    }

    public void rockStorm(View view)
    {

        final ImageView upAnim = (ImageView) findViewById(R.id.walking_anim3);

        final ImageView downAnim = (ImageView) findViewById(R.id.walking_anim2);

        Random dangerZoneChoice = new Random();

        int up = 1, down = 2;
        int dangerZone = 0;

        dangerZone = dangerZoneChoice.nextInt((down - up) + 1) + up;

        if(dangerZone == up)
        {
            throwHigh(null);

            new CountDownTimer(2000, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    final TextView scoreDisplay = findViewById(R.id.textView5);

                    if(millisUntilFinished <= 1000
                            && upAnim.getVisibility() == View.VISIBLE
                            && downAnim.getVisibility() == View.INVISIBLE )
                    {
                        score -= 5;
                        scoreDisplay.setText(Integer.toString(score));
                    }
                }

                public void onFinish(){rockStorm(null);}
            }.start();
        }
        else if (dangerZone == down)
        {
            throwLow(null);

            new CountDownTimer(2000, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    final TextView scoreDisplay = findViewById(R.id.textView5);

                    if(millisUntilFinished <= 1000
                            && upAnim.getVisibility()  == View.INVISIBLE
                            && downAnim.getVisibility() == View.VISIBLE )
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
        Button upButton = (Button) findViewById(R.id.button21);
        Button downButton = (Button) findViewById(R.id.button22);

        ImageView startImage = (ImageView) findViewById(R.id.imageView10);

        upButton.setVisibility(View.VISIBLE);
        downButton.setVisibility(View.VISIBLE);
        startButton.setVisibility(View.INVISIBLE);
        startImage.setVisibility(View.INVISIBLE);

        upClick(null); //begin on the top of the screen

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

        rockStorm(null);
    }

    public void upClick(View view) {

        final ImageView upAnim = (ImageView) findViewById(R.id.walking_anim3);

        upAnim.setBackgroundResource(R.drawable.walk_anim);

        AnimationDrawable WeWalking = (AnimationDrawable) upAnim.getBackground();

        WeWalking.stop();
        WeWalking.start();

        final ImageView downAnim = (ImageView) findViewById(R.id.walking_anim2);

        downAnim.setBackgroundResource(R.drawable.walk_anim);

        AnimationDrawable NoWalking = (AnimationDrawable) upAnim.getBackground();

        NoWalking.stop();
        NoWalking.start();

        upAnim.setVisibility(View.VISIBLE);
        downAnim.setVisibility(View.INVISIBLE);
    }

    public void downClick(View view) {

        final ImageView downAnim = (ImageView) findViewById(R.id.walking_anim2);

        downAnim.setBackgroundResource(R.drawable.walk_anim);

        AnimationDrawable WeWalking = (AnimationDrawable) downAnim.getBackground();

        WeWalking.stop();
        WeWalking.start();

        final ImageView upAnim = (ImageView) findViewById(R.id.walking_anim3);

        upAnim.setBackgroundResource(R.drawable.walk_anim);

        AnimationDrawable NoWalking = (AnimationDrawable) upAnim.getBackground();

        NoWalking.stop();
        NoWalking.start();

        downAnim.setVisibility(View.VISIBLE);
        upAnim.setVisibility(View.INVISIBLE);
    }
}
