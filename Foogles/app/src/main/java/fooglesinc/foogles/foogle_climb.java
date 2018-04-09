package fooglesinc.foogles;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class foogle_climb extends AppCompatActivity {

    public static String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foogle_climb);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.FOOGLE_NAME);

        Button leftButton = (Button) findViewById(R.id.button21);
        Button rightButton = (Button) findViewById(R.id.button22);
        leftButton.setVisibility(View.INVISIBLE);
        rightButton.setVisibility(View.INVISIBLE);

    }
    //TODO
    /*
    * Falling foogle crap animation
    *
    * check to see if foogle gets hit
    *   Have 3 images, High, Medium, and Low positions that change visibility and show the object falling,
    *   once shitRain goes to low then do the following
    *
    *   if leftAnim is visible && shitstormLow = leftside then decrement score (hit animation for future sprint)
    *
    *   if rightAnim is visible && shitstormLow = rightside then decrement score (hit animation for future sprint)
    *
    * increment/decrement score
    *
    * calculate rewards
    *
    * store in database
    * */



    public void rewardFoogle(View view)
    {
        Intent intent = new Intent(this, Rewards.class);
        intent.putExtra(MainActivity.FOOGLE_NAME, message);
        startActivity(intent);
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

        leftClick(null);

        final ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar3);

        //30 second countdown by 1 second intervals
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                progressBar.incrementProgressBy(1); //progressBar's android:max in the XML is set to 30, this increments until max is hit
            }

            public void onFinish() {
                rewardFoogle(null);
            }
        }.start();
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
