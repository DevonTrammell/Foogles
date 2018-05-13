package fooglesinc.foogles;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.Random;

public class foogle_fish extends AppCompatActivity {

    public static String message;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_foogle_fish);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.FOOGLE_NAME);
    }

//    public void catchClick() {
//        final ImageButton catchFish = (ImageButton) findViewById(R.id.CatchButton);
//        catchFish.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void OnClick(View view)
//            {
//                showFish();
//            }
//        });
//        public void onClick(View view) {
//            showFish();
//        }
//    }

    public void rewardFoogle(View view)
    {
        Intent intent = new Intent(this, Rewards.class);
        intent.putExtra(MainActivity.FOOGLE_NAME, message);
        startActivity(intent);
    }


    public void startFishing(View view)
    {
        //make Start button invisible during gameplay
        ImageButton startButton = (ImageButton) findViewById(R.id.startButton);
        startButton.setVisibility(View.INVISIBLE);

        //button to click when you want to catch the fish
        //final ImageButton catchFish = (ImageButton) findViewById(R.id.CatchButton);

        //Exclamation Point image to alert user there is a fish on the hook - initially invisible then visible for 3 seconds and repeat

        final ImageView fishAvailable = (ImageView) findViewById(R.id.ExclamationPoint);
        fishAvailable.setVisibility(View.INVISIBLE);

        final ImageButton catchButton = (ImageButton) findViewById(R.id.CatchButton);

        waitForBite(null);

            //startFishing(null);
    }

    public void waitForBite(View view)
    {
        final ImageView fishAvailable = (ImageView) findViewById(R.id.ExclamationPoint);
        fishAvailable.setVisibility(View.INVISIBLE);

        final ImageButton catchButton = (ImageButton) findViewById(R.id.CatchButton);


        new CountDownTimer(10000, 500)
        {
            public void onTick(long millisUntilFinished)
            {
                if (millisUntilFinished <= 5000)
                {
                    fishAvailable.setVisibility(View.VISIBLE);

                    if (millisUntilFinished <= 4500)
                    {
                        catchButton.setVisibility(View.VISIBLE);

                        catchButton.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View view)
                            {
                                showFish(null);

                                cancel();
                            }
                        });
                    }
                }
            }

            public void onFinish()
            {

                waitForBite(null);

                fishAvailable.setVisibility(View.INVISIBLE);

                catchButton.setVisibility(View.INVISIBLE);


            }
        }.start();
    }

    public int randomizeFish() {
        //generate a random number to determine which fish is caught
        Random fishChoice = new Random();

        //use numbers 1-5 to represent each fish
        final int min = 1, max = 5;
        int caughtFish;

        caughtFish = fishChoice.nextInt((max - min) + 1) + min;

        return caughtFish;
    }

    public void showFish(View view)
    {
        int randomFish = randomizeFish();

        long gloatTime = 5000;

        long increment = 1000;

        final ImageView caughtFish = (ImageView) findViewById(R.id.caughtReward);

        final ImageView fishAvailable = (ImageView) findViewById(R.id.ExclamationPoint);

        final ImageButton catchButton = (ImageButton) findViewById(R.id.CatchButton);

        fishAvailable.setVisibility(View.INVISIBLE);

        catchButton.setVisibility(View.INVISIBLE);

        //caught fish is Sea Horse
        if(randomFish == 1)
        {

            new CountDownTimer(gloatTime, increment)
            {
                public void onTick(long millisUntilFinished)
                {
                    caughtFish.setImageResource(R.drawable.caughtseahorse);

                }

                public void onFinish()
                {
                    rewardFoogle(null);
                }
            }.start();

        }

        //caught fish is Barred Knifejaw
        else if(randomFish == 2)
        {


            new CountDownTimer(gloatTime, increment)
            {
                public void onTick(long millisUntilFinished)
                {
                    caughtFish.setImageResource(R.drawable.caughtbarred);

                }

                public void onFinish()
                {
                    rewardFoogle(null);
                }
            }.start();

        }

        //caught fish is Octopus
        else if(randomFish == 3)
        {

            new CountDownTimer(gloatTime, increment)
            {
                public void onTick(long millisUntilFinished)
                {
                    caughtFish.setImageResource(R.drawable.caughtseptapus);

                }

                public void onFinish()
                {
                    rewardFoogle(null);
                }
            }.start();

        }
        //caught fish is Angler Fish
        else if(randomFish == 4)
        {


            new CountDownTimer(gloatTime, increment)
            {
                public void onTick(long millisUntilFinished)
                {
                    caughtFish.setImageResource(R.drawable.caughtmetal);

                }

                public void onFinish()
                {
                    rewardFoogle(null);
                }
            }.start();
        }
        //caught fish is Shark
        else if(randomFish == 5)
        {

            new CountDownTimer(gloatTime, increment)
            {
                public void onTick(long millisUntilFinished)
                {
                    caughtFish.setImageResource(R.drawable.caughtshark);

                }

                public void onFinish()
                {
                    rewardFoogle(null);
                }
            }.start();
        }
    }
}