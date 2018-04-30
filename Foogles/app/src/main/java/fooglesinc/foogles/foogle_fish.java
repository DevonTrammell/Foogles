package fooglesinc.foogles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class foogle_fish extends AppCompatActivity {

    public static String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_foogle_fish);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.FOOGLE_NAME);
    }
    public void rewardFoogle(View view)
    {
        Intent intent = new Intent(this, Rewards.class);
        intent.putExtra(MainActivity.FOOGLE_NAME, message);
        startActivity(intent);
    }


    /*
    * Randomly determine when a fish is on the hook
    *       if it is, give a 1/2 to 3/4 second window to hit a ! button
    *               if hit, randomly determine fish
    *
    *                 (Alternatively, only do this if there is time for art for every fish)
    *                       generate a random number 1 - 3
    *                           make 1 happen more often 2 more often than three
    *                               each number might have a range of fish to randomly generate
    *
    *
    *
    *                if fish is caught, add pts, add to trophy case etc.
    *                if miss, animate/show disappointed foogle
    * */

    /*
    *
    * Start game -> Set timer
    * */
}
