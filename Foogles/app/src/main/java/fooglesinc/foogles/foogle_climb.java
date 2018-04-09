package fooglesinc.foogles;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class foogle_climb extends AppCompatActivity {

    public static String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foogle_climb);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.FOOGLE_NAME);

    }



    public void rewardFoogle(View view)
    {
        Intent intent = new Intent(this, Rewards.class);
        intent.putExtra(MainActivity.FOOGLE_NAME, message);
        startActivity(intent);
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
