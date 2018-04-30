package fooglesinc.foogles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

/**
 * Created by joeyjennings on 3/9/18.
 */

public class GameSelect extends AppCompatActivity{

    public static final String EXTRA_MESSAGE = "com.example.foogles.MESSAGE";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_game_select);

//        View decorView = getWindow().getDecorView();
//        decorView.setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
    public void getFoogleforClimb(View view) {
        Intent intent = new Intent(this, ChooseFoogle.class);
        String mode = "Foogle Climb";
        intent.putExtra(EXTRA_MESSAGE, mode);
        startActivity(intent);
    }
    public void getFoogleforFish(View view) {
        Intent intent = new Intent(this, ChooseFoogle.class);
        String mode = "Foogle Fishing";
        intent.putExtra(EXTRA_MESSAGE, mode);
        startActivity(intent);
    }
    public void getFoogleforHop(View view) {
        Intent intent = new Intent(this, ChooseFoogle.class);
        String mode = "Foogle Hop";
        intent.putExtra(EXTRA_MESSAGE, mode);
        startActivity(intent);
    }
    public void getFoogleforSwim(View view) {
        Intent intent = new Intent(this, ChooseFoogle.class);
        String mode = "Foogle Swim";
        intent.putExtra(EXTRA_MESSAGE, mode);
        startActivity(intent);
    }
    public void getFoogleforWhack(View view) {
        Intent intent = new Intent(this, ChooseFoogle.class);
        String mode = "Whack-a-Foogle";
        intent.putExtra(EXTRA_MESSAGE, mode);
        startActivity(intent);
    }

}
