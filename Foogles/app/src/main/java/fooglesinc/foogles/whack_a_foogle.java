package fooglesinc.foogles;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class whack_a_foogle extends AppCompatActivity {

    AnimationDrawable whackAnimation;
    //    Button startButton;
    Button rewardsButton;
    public static String message;
    private int progressStatus = 0;
    private Handler handler = new Handler();
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whack_a_foogle);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.FOOGLE_NAME);

        final ImageView animateWhack1 = (ImageView) findViewById(R.id.whackAnim1);
        animateWhack1.setBackgroundResource(R.drawable.activity_unwhacked_animation);
        //animateWhack1.setImageResource(R.drawable.whackbuttonidle);
        final ImageView animateWhack2 = (ImageView) findViewById(R.id.whackAnim2);
        animateWhack2.setBackgroundResource(R.drawable.activity_unwhacked_animation);
        //animateWhack2.setImageResource(R.drawable.whackbuttonidle);
        final ImageView animateWhack3 = (ImageView) findViewById(R.id.whackAnim3);
        animateWhack3.setBackgroundResource(R.drawable.activity_unwhacked_animation);
        //animateWhack3.setImageResource(R.drawable.whackbuttonidle);
        final ImageView animateWhack4 = (ImageView) findViewById(R.id.whackAnim4);
        animateWhack4.setBackgroundResource(R.drawable.activity_unwhacked_animation);
        //animateWhack4.setImageResource(R.drawable.whackbuttonidle);
        final ImageView animateWhack5 = (ImageView) findViewById(R.id.whackAnim5);
        animateWhack5.setBackgroundResource(R.drawable.activity_unwhacked_animation);
        //animateWhack5.setImageResource(R.drawable.whackbuttonidle);

        pb = (ProgressBar) findViewById(R.id.progressBar2);

        rewardsButton = (Button) findViewById(R.id.button25);

//        startButton = (Button) findViewById(R.id.button25);

//        startButton.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View v) {
//              progressStatus = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus < 30) {
                    progressStatus++;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pb.setProgress(progressStatus);
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                    whackAnimation = (AnimationDrawable) animateWhack1.getBackground();
                    //whackAnimation.stop();
                    whackAnimation.start();

                    final Button whack1 = (Button) findViewById(R.id.button16);
                    whack1.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            animateWhack1.setImageResource(R.drawable.whackbuttontapped);
                        }
                    });

                    whackAnimation = (AnimationDrawable) animateWhack2.getBackground();
                    //whackAnimation.stop();
                    whackAnimation.start();

                    Button whack2 = (Button) findViewById(R.id.button18);
                    whack2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            animateWhack2.setImageResource(R.drawable.whackbuttontapped);
                        }
                    });

                    whackAnimation = (AnimationDrawable) animateWhack3.getBackground();
                    //whackAnimation.stop();
                    whackAnimation.start();

                    Button whack3 = (Button) findViewById(R.id.button17);
                    whack3.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            animateWhack3.setImageResource(R.drawable.whackbuttontapped);
                        }
                    });

                    whackAnimation = (AnimationDrawable) animateWhack4.getBackground();
                    //whackAnimation.stop();
                    whackAnimation.start();

                    Button whack4 = (Button) findViewById(R.id.button20);
                    whack4.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            animateWhack4.setImageResource(R.drawable.whackbuttontapped);
                        }
                    });

                    whackAnimation = (AnimationDrawable) animateWhack5.getBackground();
                    //whackAnimation.stop();
                    whackAnimation.start();

                    Button whack5 = (Button) findViewById(R.id.button19);
                    whack5.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            animateWhack5.setImageResource(R.drawable.whackbuttontapped);
                        }
                    });
                }
            }
        }).start();
        rewardsButton.setVisibility(View.INVISIBLE);
        rewardsButton.postDelayed(new Runnable() {
            public void run() {
                rewardsButton.setVisibility(View.VISIBLE);
            }
        }, 30000);
//                                           }
//                                       });

//        whackAnimation.setOnTouchListener(new View.OnTouchListener(){
//
//            public boolean onTouch(View v, MotionEvent event) {
//                switch(event.getAction())
//                {
//                    case MotionEvent.ACTION_DOWN :
//                        myImageButton.setImageResource(R.drawable.image_when_pressed);
//                        break;
//                    case MotionEvent.ACTION_UP :
//                        myImageButton.setImageResource(R.drawable.image_when_released);
//                        break;
//                }
//                return false;
//            }
//        });
    }

    public void rewardFoogle(View view)
    {
        Intent intent = new Intent(this, Rewards.class);
        intent.putExtra(MainActivity.FOOGLE_NAME, message);
        startActivity(intent);
    }

}