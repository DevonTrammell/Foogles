package fooglesinc.foogles;

import android.animation.ObjectAnimator;
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
import android.widget.ImageButton;
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

    public void makeCompetition(View view)
    {
        ImageView comp1 = (ImageView) findViewById(R.id.competitor1);
        comp1.setBackgroundResource(R.drawable.mvp_walk1);

        float height1 = 1600;
        float propertyStart1 = 0f;
        float propertyEnd1 = -(height1 - (float)comp1.getHeight()/2);


        ImageView comp2 = (ImageView) findViewById(R.id.competitor2);
        comp2.setBackgroundResource(R.drawable.sonic_walk1);

        float height2 = 1600;
        float propertyStart2 = 0f;
        float propertyEnd2 = -(height2 - (float)comp2.getHeight()/2);


        ImageView mainFoog = (ImageView) findViewById(R.id.mainfoogle);
        mainFoog.setBackgroundResource(R.drawable.purple_walk1);


        float heightMain = 1600;
        float propertyStartMain = 0f;
        float propertyEndMain = -(heightMain - (float)mainFoog.getHeight()/2);


        String propertyName = "translationY";

        ObjectAnimator run1 = ObjectAnimator.ofFloat(comp1,propertyName, propertyStart1, propertyEnd1);
        ObjectAnimator run2 = ObjectAnimator.ofFloat(comp2,propertyName, propertyStart2, propertyEnd2);
        ObjectAnimator runMain = ObjectAnimator.ofFloat(mainFoog,propertyName, propertyStartMain, propertyEndMain);

        if(difficulty > 5)
        {
            run1.setDuration(10000);
            run2.setDuration(9000);
            runMain.setDuration(4000);
        }
        else if(difficulty >= 3 && difficulty <= 5)
        {
            run1.setDuration(8000);
            run2.setDuration(7000);
            runMain.setDuration(7500);
        }
        else if(difficulty < 3)
        {
            run1.setDuration(3000);
            run2.setDuration(4000);
            runMain.setDuration(7000);
        }

        run1.start();
        run2.start();
        runMain.start();
    }



    public void startRace(View view)
    {

        ImageButton startButton = (ImageButton) findViewById(R.id.startButton);

        startButton.setVisibility(View.INVISIBLE);


        final ImageView mainFoog = (ImageView) findViewById(R.id.mainfoogle);
        final ImageView comp1 = (ImageView) findViewById(R.id.competitor1);
        final ImageView comp2 = (ImageView) findViewById(R.id.competitor2);
        //Animation rotate = AnimationUtils.loadAnimation(this,R.anim.alpha);

        makeCompetition(null);

        mainFoog.setBackgroundResource(R.drawable.purple_walk);
        final AnimationDrawable WeWalking = (AnimationDrawable) mainFoog.getBackground();

        WeWalking.stop();
        WeWalking.start();

        comp1.setBackgroundResource(R.drawable.mvp_walk);
        final AnimationDrawable comp1walk = (AnimationDrawable) comp1.getBackground();
        comp1walk.stop();
        comp1walk.start();

        comp2.setBackgroundResource(R.drawable.blue_walk);
        final AnimationDrawable comp2walk = (AnimationDrawable) comp2.getBackground();
        comp2walk.stop();
        comp2walk.start();


        final ProgressBar progressBar = (ProgressBar)findViewById(R.id.racetimer);

        //10 second countdown by 1 second intervals
        new CountDownTimer(10000, 1000)
        {
            //final TextView scoreDisplay = findViewById(R.id.textView5);

            public void onTick(long millisUntilFinished)
            {
                progressBar.incrementProgressBy(1); //progressBar's android:max in the XML is set to 30, this increments until max is hit
            }

            public void onFinish() {
                WeWalking.stop();
                comp1walk.stop();
                comp2walk.stop();

                determineWinOrLose();
            }
        }.start();
    }
    public void determineWinOrLose()
    {
        if (difficulty != 0)
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