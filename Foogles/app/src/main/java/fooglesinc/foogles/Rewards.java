package fooglesinc.foogles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Random;

public class Rewards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_rewards);


        Intent intent = getIntent();
        /*
        String message = intent.getStringExtra(MainActivity.FOOGLE_NAME);
        if (message.equals("win"))
        {
            TextView textView = findViewById(R.id.textView3);
            String displayedMessage = message + " - hurts being this good!";
            textView.setText(displayedMessage);
        }
        else if (message.equals("loss"))
        {
            TextView textView = findViewById(R.id.textView3);
            String displayedMessage = message + " Whoops maybe you should try professional Foogle Fishing!";
            textView.setText(displayedMessage);
        }
        else
        {
            TextView textView = findViewById(R.id.textView3);
            String displayedMessage = message + "'s stat(s) have changed!";
            textView.setText(displayedMessage);

            TextView randomStats = findViewById(R.id.textView4);
            Random rand = new Random();
            String changes = "";
            String[] stats = new String[]{"Climb", "Swim", "Running", "Energy"};
            for (int index = 0; index < 4; index++) {
                int stat_change = rand.nextInt(5) - 2;
                if (stat_change >= 0) {
                    changes = changes + stats[index] + ": [+" + stat_change + "]!\n";
                } else {
                    changes = changes + stats[index] + ": [" + stat_change + "]!\n";
                }
            }
            randomStats.setText(changes);
        }
    */
    }

    public void backToMain(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
