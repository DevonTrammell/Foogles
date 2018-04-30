package fooglesinc.foogles;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Thomas on 4/22/2018.
 */

public class Racing extends AppCompatActivity {
    private int difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_tournament_race);
        Intent intent = getIntent();
        difficulty = intent.getIntExtra(MainActivity.DIFFICULTY,2);
        final ImageView mainFoog = (ImageView) findViewById(R.id.mainfoogle);
        mainFoog.setBackgroundResource(R.drawable.purple_walk1);
        final ImageView comp1 = (ImageView) findViewById(R.id.competitor1);
        comp1.setBackgroundResource(R.drawable.mvp_walk1);
        final ImageView comp2 = (ImageView) findViewById(R.id.competitor2);
        comp2.setBackgroundResource(R.drawable.sonic_walk1);
        // difficulty is now 0 or 1 or 2. 0 will mean you win, 1 will mean it was close, 2 means you lose.
    }
    public void startRace(View view){


        final ImageView mainFoog = (ImageView) findViewById(R.id.mainfoogle);
        final ImageView comp1 = (ImageView) findViewById(R.id.competitor1);
        final ImageView comp2 = (ImageView) findViewById(R.id.competitor2);
        Animation rotate = AnimationUtils.loadAnimation(this,R.anim.alpha);

        mainFoog.setBackgroundResource(R.drawable.purple_walk);

        final AnimationDrawable WeWalking = (AnimationDrawable) mainFoog.getBackground();

        WeWalking.stop();
        WeWalking.start();

        if (difficulty == 0)
        {
            // we set comnpetitor 1 and 2 to spin
            comp1.startAnimation(rotate);
            comp2.startAnimation(rotate);
        }
        else if (difficulty == 1)
        {
            // we set either competitor 1 or competitor 2 to spin,
            // if two is spinning then we won, else we lost
            comp1.startAnimation(rotate);
            comp2.setBackgroundResource(R.drawable.blue_walk);
            final AnimationDrawable comp2walk = (AnimationDrawable) comp2.getBackground();
            comp2walk.stop();
            comp2walk.start();
        }
        else if (difficulty == 2)
        {
            // both competitors are walking and we lost :(
            comp1.setBackgroundResource(R.drawable.mvp_walk);
            final AnimationDrawable comp1walk = (AnimationDrawable) comp1.getBackground();
            comp1walk.stop();
            comp1walk.start();
            comp2.setBackgroundResource(R.drawable.blue_walk);
            final AnimationDrawable comp2walk = (AnimationDrawable) comp2.getBackground();
            comp2walk.stop();
            comp2walk.start();
        }
        Button startButton = (Button) findViewById(R.id.start);
        //Button leftButton = (Button) findViewById(R.id.button21);
        //Button rightButton = (Button) findViewById(R.id.button22);

        ImageView startImage = (ImageView) findViewById(R.id.imageView10);

        //set left and right buttons visible while rendering the start image and button invisible
        //leftButton.setVisibility(View.VISIBLE);
        //rightButton.setVisibility(View.VISIBLE);

        startButton.setVisibility(View.INVISIBLE);


        //leftClick(null); // initially begin on the left side of the screen


        // call the progress bar and set up the main timer for the game


        final ProgressBar progressBar = (ProgressBar)findViewById(R.id.racetimer);

        //30 second countdown by 1 second intervals
        new CountDownTimer(10000, 1000)
        {
            //final TextView scoreDisplay = findViewById(R.id.textView5);

            public void onTick(long millisUntilFinished)
            {
                progressBar.incrementProgressBy(1); //progressBar's android:max in the XML is set to 30, this increments until max is hit
                //score++;
                //scoreDisplay.setText(Integer.toString(score));
            }

            public void onFinish() {
                WeWalking.stop();
                determineWinOrLose();
            }
        }.start();
    }
    public void determineWinOrLose()
    {
        if (difficulty < 2)
        {
            Intent intent = new Intent(this, Rewards.class);
            intent.putExtra(MainActivity.FOOGLE_NAME, "win");

            //pass score to next activity
            //to be saved in foogle stats

            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(this, Rewards.class);
            intent.putExtra(MainActivity.FOOGLE_NAME, "loss");

            //pass score to next activity
            //to be saved in foogle stats

            startActivity(intent);
        }
    }
}