package fooglesinc.foogles;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.logging.Level;

public class Rewards extends AppCompatActivity {
    TextView lvl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_rewards);


        ImageView icon = findViewById(R.id.imageView15);
        ImageView fishy = findViewById(R.id.fishView);
        Intent intent = getIntent();
        lvl = findViewById(R.id.LevelView);
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        int n = sp.getInt("level", 0);
        int x = sp.getInt("score", 0);
        int y = sp.getInt("pScore", 0);
        if (x >= y + 10) {
            n++;
            lvl.setText("Level up! You are now level " + n);
            editor.putInt("level", n);
            editor.putInt("score", 0);
            editor.putInt("pScore", 0);
            editor.apply();
            icon.setBackgroundResource(R.drawable.pet);
        }
        else {// now check if we did a tournament.
            int tourney = intent.getIntExtra(MainActivity.TOURNEY, -1);
            if (tourney != -1) {
                //we either won a tourey, or we lost

                if (tourney == 0) {
                    icon.setBackgroundResource(R.drawable.grandpa_foogs);
                    lvl.setText("Never Give Up! Never Surrender!!! Try harder though.");
                } else if (tourney == 5) {
                    icon.setBackgroundResource(R.drawable.medal_bronze);
                    lvl.setText("Congrats! The game just started though, go for the silver!");
                } else if (tourney == 10) {
                    icon.setBackgroundResource(R.drawable.medal_silver);
                    lvl.setText("You did it! Now go for gold!");
                } else if (tourney == 15) {
                    icon.setBackgroundResource(R.drawable.medal_gold);
                    lvl.setText("Welp, you beat the game! Now just wait for Foogles 2.0!");
                } else {
                    icon.setBackgroundResource(R.drawable.pet);
                    lvl.setText("YOU WON A TOURNAMENT! HOLY COW! CALL GRANDPA! " + tourney);
                }
            }
            int fish = intent.getIntExtra(MainActivity.FISH, -1);
            if (fish != -1) {
                switch (fish) {
                    case 1:
                        fishy.setBackgroundResource(R.drawable.fish_seahorse);
                        break;
                    case 2:
                        fishy.setBackgroundResource(R.drawable.fish_barred);
                        break;
                    case 3:
                        fishy.setBackgroundResource(R.drawable.fish_octo);
                        break;
                    case 4:
                        fishy.setBackgroundResource(R.drawable.fish_football);
                        break;
                    case 5:
                        fishy.setBackgroundResource(R.drawable.fish_shark);
                        break;
                    default:
                        icon.setBackgroundResource(R.drawable.pet);
                        break;
                }
                lvl.setText("WOAH! Nice Catch! Got a real Fish master over here!");
            }
            if (fish == -1 && tourney == -1) {
                icon.setBackgroundResource(R.drawable.grandpa_foogs);
                lvl.setText("Don't give up kiddo! keep it up!" + n);
            }
        }



//        String message = intent.getStringExtra(MainActivity.FOOGLE_NAME);
//        if (message.equals("win")) {
//            //TextView textView = findViewById(R.id.LevelView);
//            String displayedMessage = "Congratulations You've Won!";
//            lvl.setText(displayedMessage);
//        }

//        } else if (message.equals("loss")) {
//            //TextView textView = findViewById(R.id.textView3);
//            String displayedMessage = message + " Whoops maybe you should try professional Foogle Fishing!";
//            lvl.setText(displayedMessage);
//        }

    }
//        else
//        {
//            TextView textView = findViewById(R.id.textView3);
//            String displayedMessage = message + "'s stat(s) have changed!";
//            textView.setText(displayedMessage);
//
//            TextView randomStats = findViewById(R.id.textView4);
//            Random rand = new Random();
//            String changes = "";
//            String[] stats = new String[]{"Climb", "Swim", "Running", "Energy"};
//            for (int index = 0; index < 4; index++) {
//                int stat_change = rand.nextInt(5) - 2;
//                if (stat_change >= 0) {
//                    changes = changes + stats[index] + ": [+" + stat_change + "]!\n";
//                } else {
//                    changes = changes + stats[index] + ": [" + stat_change + "]!\n";
//                }
//            }
//            randomStats.setText(changes);
//        }
//
//    }

    public void backToMain(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
