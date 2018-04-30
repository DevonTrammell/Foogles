package fooglesinc.foogles;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import static android.media.MediaPlayer.*;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.foogles.MESSAGE";
    public static final String FOOGLE_NAME = "com.example.foogles.NAME";
    public static final String WHERE_STATUS = "com.example.foogles.WHERE";
    public static final String WHEN_STATUS = "com.example.foogles.WHEN";
    public static final String PET_STATUS = "com.example.foogles.PET";
    public static final String DIFFICULTY = "com.example.foogles.DIFF";
    private ImageSwitcher simpleImageSwitcher;
    Button btnNext;
    EditText FoogleRanchName;

    int imageIds[] = {R.mipmap.ic_sticks, R.mipmap.ic_foogle_foreground, R.mipmap.ic_foogle_house, R.mipmap.ic_foogle_danger, R.mipmap.ic_sleep, R.mipmap.ic_abug};
    int count = imageIds.length;
    int currentIndex = 0;

    public MainActivity() throws FileNotFoundException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //MediaPlayer ring = create(MainActivity.this, R.raw.mariothemesong);
        //ring.start();
        //ring.setLooping(true);


//        btnNext = (Button) findViewById(R.id.button8);
//        simpleImageSwitcher = (ImageSwitcher) findViewById(R.id.simpleImageSwitcher);
//        simpleImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
//            @Override
//            public View makeView() {
//                ImageView imageView = new ImageView(getApplicationContext());
//                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
//                return imageView;
//            }
//        });
//        if (count >= 0)
//            simpleImageSwitcher.setImageResource(imageIds[0]);
//        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
//        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
//
//        simpleImageSwitcher.setInAnimation(in);
//        simpleImageSwitcher.setOutAnimation(out);
//
//        btnNext.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                currentIndex++;
//                if (currentIndex >= count)
//                    currentIndex = 0;
//                simpleImageSwitcher.setImageResource(imageIds[currentIndex]);
//            }
//        });
//
//        FoogleRanchName = (EditText) findViewById(R.id.EditName);
//        FoogleRanchName.requestFocusFromTouch();
//        FoogleRanchName.clearFocus();
//
//        /*View decorView = getWindow().getDecorView();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
//            decorView.setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//                            */
    }

    public void selectGame(View view) {
        Intent intent = new Intent(this, GameSelect.class);
        startActivity(intent);
    }

    public void walkAFoogle(View view) {
        //Intent intent = new Intent(this, Walk.class);
        //startActivity(intent);
        Intent intent = new Intent(this, ChooseFoogle.class);
        String mode = "Walk";
        intent.putExtra(EXTRA_MESSAGE, mode);
        startActivity(intent);
    }

    public void marketplace(View view) {
        Intent intent = new Intent(this, Market.class);
        startActivity(intent);
    }

    public void editFoogle(View view) {
        Intent intent = new Intent(this, ChooseFoogle.class);
        String mode = "Edit is not a game";
        intent.putExtra(EXTRA_MESSAGE, mode);
        startActivity(intent);
    }

    public void fooglympics(View view) {
        Intent intent = new Intent(this, Tournament.class);
        startActivity(intent);
    }

    public void trophyCase(View view) {
        Intent intent = new Intent(this, Trophy_Display.class);
        startActivity(intent);
    }

    public void createFoogle(View view) {
        Intent intent = new Intent(this, CreateFoogle.class);
        startActivity(intent);
    }




}

    

