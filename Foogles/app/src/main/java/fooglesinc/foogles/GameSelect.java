package fooglesinc.foogles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

/**
 * Created by joeyjennings on 3/9/18.
 */

public class GameSelect extends AppCompatActivity{

    public static final String EXTRA_MESSAGE = "com.example.foogles.MESSAGE";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        String mode = "Climb";
        intent.putExtra(EXTRA_MESSAGE, mode);
        startActivity(intent);
    }
    public void foogleFish(View view) {
        //Intent intent = new Intent(this, Fish.class);
        //startActivity(intent);
    }
    public void foogleHop(View view) {
        //Intent intent = new Intent(this, Hop.class);
        //startActivity(intent);
    }
    public void foogleSwim(View view) {
        //Intent intent = new Intent(this, Swim.class);
        //startActivity(intent);
    }
    public void foogleWhack(View view) {
        //Intent intent = new Intent(this, Whack.class);
        //startActivity(intent);
    }

}
