package fooglesinc.foogles;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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

        } else {
            lvl.setText("You're doing great, keep it up!");
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
