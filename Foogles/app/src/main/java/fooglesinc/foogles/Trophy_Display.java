package fooglesinc.foogles;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class Trophy_Display extends AppCompatActivity {

    private ImageView walking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_trophy__display);
        TextView textView = findViewById(R.id.textView);
        String displayedMessage = "Yup, this is where I'd put a trophy case ........ ";
        textView.setText(displayedMessage);
        textView = findViewById(R.id.textView7);
        displayedMessage = "IF I HAD ONE!";
        textView.setText(displayedMessage);

        // setting up a basic animation
        walking = (ImageView) findViewById(R.id.walking_anim);
        walking.setBackgroundResource(R.drawable.blue_walk);
        AnimationDrawable WeWalking = (AnimationDrawable) walking.getBackground();

        WeWalking.stop();
        WeWalking.start();

    }
}
