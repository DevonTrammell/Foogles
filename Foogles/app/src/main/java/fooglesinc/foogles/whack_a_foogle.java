package fooglesinc.foogles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class whack_a_foogle extends AppCompatActivity
{

    public static String message;

    public int whackScore = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_whack_a_foogle);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.FOOGLE_NAME);

        Button startButton = (Button) findViewById(R.id.whackStart);
        startButton.setVisibility(View.VISIBLE);

        ImageButton topLeft = (ImageButton) findViewById(R.id.topLeftHole);
        topLeft.setVisibility(View.VISIBLE);

        ImageButton topRight = (ImageButton) findViewById(R.id.topRightHole);
        topRight.setVisibility(View.VISIBLE);

        ImageButton center = (ImageButton) findViewById(R.id.centerHole);
        center.setVisibility(View.VISIBLE);

        ImageButton bottomLeft = (ImageButton) findViewById(R.id.bottomLeftHole);
        bottomLeft.setVisibility(View.VISIBLE);

        ImageButton bottomRight = (ImageButton) findViewById(R.id.bottomRightHole);
        bottomRight.setVisibility(View.VISIBLE);

        TextView scoreBox = (TextView) findViewById(R.id.ScoreBox);
        scoreBox.setText(Integer.toString(whackScore));
    }

    public void rewardFoogle(View view)
    {
        Intent intent = new Intent(this, Rewards.class);
        intent.putExtra(MainActivity.FOOGLE_NAME, message);

        //pass score to next activity
        //to be saved in foogle stats
        startActivity(intent);
    }

    public int chooseHole()
    {
        // generate random number to determine which hole to animate
        Random holeChoice = new Random();

        //numbers 1 - 5 will be mapped to each hole
        final int min = 1, max = 5;
        int dangerHole = 0;

        dangerHole = holeChoice.nextInt((max - min) + 1) + min;

        return dangerHole;
    }

    public void peekOut(View view)
    {
        final ImageButton topLeft = (ImageButton) findViewById(R.id.topLeftHole);
        final ImageButton topRight = (ImageButton) findViewById(R.id.topRightHole);
        final ImageButton center = (ImageButton) findViewById(R.id.centerHole);
        final ImageButton bottomLeft = (ImageButton) findViewById(R.id.bottomLeftHole);
        final ImageButton bottomRight = (ImageButton) findViewById(R.id.bottomRightHole);

        TextView scoreBox = (TextView) findViewById(R.id.ScoreBox);

        int UP_LEFT = 1, UP_RIGHT = 2, CENTER = 3, BOTTOM_LEFT = 4, BOTTOM_RIGHT = 5;
        int dangerHole = chooseHole();

        if(dangerHole == UP_LEFT)
        {
            topLeft.setImageResource(R.drawable.whack_pre);


            new CountDownTimer(3000, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    final TextView scoreBox = findViewById(R.id.ScoreBox);

                    if(millisUntilFinished <= 2000 && millisUntilFinished > 0)
                    {
                        topLeft.setImageResource(R.drawable.whack_up);

                        topLeft.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View view)
                            {
                                topLeft.setImageResource(R.drawable.whack_hit);
                                whackScore += 5;
                                scoreBox.setText(Integer.toString(whackScore));
                            }
                        });
                    }
                }

                public void onFinish()
                {
                    topLeft.setImageResource(R.drawable.empty_hole);
                    peekOut(null);
                }
            }.start();


        }
        else if(dangerHole == UP_RIGHT)
        {
            topRight.setImageResource(R.drawable.whack_pre);
            new CountDownTimer(3000, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    final TextView scoreBox = findViewById(R.id.ScoreBox);


                    if(millisUntilFinished <= 2000 && millisUntilFinished > 0)
                    {
                        topRight.setImageResource(R.drawable.whack_up);

                        topRight.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View view)
                            {
                                topRight.setImageResource(R.drawable.whack_hit);
                                whackScore += 5;
                                scoreBox.setText(Integer.toString(whackScore));
                            }
                        });

                    }
                }

                public void onFinish()
                {
                    topRight.setImageResource(R.drawable.empty_hole);
                    peekOut(null);
                }
            }.start();
        }
        else if(dangerHole == CENTER)
        {
            center.setImageResource(R.drawable.whack_pre);
            new CountDownTimer(3000, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    final TextView scoreBox = findViewById(R.id.ScoreBox);


                    if(millisUntilFinished <= 2000 && millisUntilFinished > 0)
                    {
                        center.setImageResource(R.drawable.whack_up);

                        center.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View view)
                            {
                                center.setImageResource(R.drawable.whack_hit);
                                whackScore += 5;
                                scoreBox.setText(Integer.toString(whackScore));
                            }
                        });
                    }
                }

                public void onFinish()
                {
                    center.setImageResource(R.drawable.empty_hole);
                    peekOut(null);
                }
            }.start();
        }
        else if(dangerHole == BOTTOM_LEFT)
        {
            bottomLeft.setImageResource(R.drawable.whack_pre);
            new CountDownTimer(3000, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    final TextView scoreBox = findViewById(R.id.ScoreBox);


                    if(millisUntilFinished <= 2000 && millisUntilFinished > 0)
                    {
                        bottomLeft.setImageResource(R.drawable.whack_up);

                        bottomLeft.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View view)
                            {
                                bottomLeft.setImageResource(R.drawable.whack_hit);
                                whackScore += 5;
                                scoreBox.setText(Integer.toString(whackScore));
                            }
                        });
                    }
                }

                public void onFinish()
                {
                    bottomLeft.setImageResource(R.drawable.empty_hole);
                    peekOut(null);
                }
            }.start();
        }
        else if(dangerHole == BOTTOM_RIGHT)
        {
            bottomRight.setImageResource(R.drawable.whack_pre);
            new CountDownTimer(3000, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    final TextView scoreBox = findViewById(R.id.ScoreBox);


                    if(millisUntilFinished <= 2000 && millisUntilFinished > 0)
                    {
                        bottomRight.setImageResource(R.drawable.whack_up);

                        bottomRight.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View view)
                            {
                                bottomRight.setImageResource(R.drawable.whack_hit);
                                whackScore += 5;
                                scoreBox.setText(Integer.toString(whackScore));
                            }
                        });
                    }

                }

                public void onFinish()
                {
                    bottomRight.setImageResource(R.drawable.empty_hole);
                    peekOut(null);
                }
            }.start();
        }
        else
        {
            topLeft.setImageResource(R.drawable.whack_pre);

            new CountDownTimer(3000, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    final TextView scoreBox = findViewById(R.id.ScoreBox);

                    if(millisUntilFinished <= 1000 && millisUntilFinished > 0)
                    {
                        topLeft.setImageResource(R.drawable.whack_up);

                        topLeft.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View view)
                            {
                                topLeft.setImageResource(R.drawable.whack_hit);
                                whackScore += 5;
                                scoreBox.setText(Integer.toString(whackScore));
                            }
                        });
                    }
                }


                public void onFinish()
                {
                    topLeft.setImageResource(R.drawable.empty_hole);
                    peekOut(null);
                }
            }.start();
        }



    }

    public void startGame(View view)
    {

        Button startButton = (Button) findViewById(R.id.whackStart);

        startButton.setVisibility(View.INVISIBLE);

        final ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar2);

        //30 second countdown by 1 second intervals
        new CountDownTimer(30000, 1000)
        {
            final TextView scoreDisplay = findViewById(R.id.ScoreBox);

            public void onTick(long millisUntilFinished)
            {
                progressBar.incrementProgressBy(1); //progressBar's android:max in the XML is set to 30, this increments until max is hit
                scoreDisplay.setText(Integer.toString(whackScore));
            }

            public void onFinish()
            {
                SharedPreferences sp = getSharedPreferences("MyPrefs",0);
                SharedPreferences.Editor editor = sp.edit();
                int n = sp.getInt("score",0);
                n += whackScore;
                editor.putInt("score",n);
                editor.apply();
                rewardFoogle(null);
                whackScore = 0;
            }
        }.start();

        peekOut(null);
    }

}
