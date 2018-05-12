package fooglesinc.foogles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class Edit extends AppCompatActivity {


    ArrayAdapter<CharSequence> adapter;
    private ImageSwitcher simpleImageSwitcher;
    Button btnNext;
    EditText nameBox;

    int level = 1;

    int imageIds[] = {R.drawable.mono_walk, R.drawable.blue_walk, R.drawable.green_walk, R.drawable.mvp_walk, R.drawable.purple_walk, R.drawable.sonic_walk1};
    int count = imageIds.length;
    int currentIndex = 0;


    public static final String EXTRA_MESSAGE = "com.example.foogles.MESSAGE";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_edit);


        //nameBox = findViewById(R.id.Name);
        //String name = nameBox.getText().toString();



        btnNext = (Button) findViewById(R.id.button12);
        simpleImageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        simpleImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
                return imageView;
            }
        });
        if (count >= 0)
            simpleImageSwitcher.setImageResource(imageIds[0]);
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        simpleImageSwitcher.setInAnimation(in);
        simpleImageSwitcher.setOutAnimation(out);

        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentIndex++;
                if (currentIndex >= count)
                    currentIndex = 0;
                simpleImageSwitcher.setImageResource(imageIds[currentIndex]);
            }
        });


//        View decorView = getWindow().getDecorView();
//        decorView.setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        // Spinner element

    }




    public void saveFoogle(View view) {
//        Intent intent = new Intent(this, MainActivity.class);
//        String mode = "Save";
//        intent.putExtra(EXTRA_MESSAGE, mode);
//        startActivity(intent);

        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        nameBox = (EditText) findViewById(R.id.Name);
        dbHandler.deleteFoogle(nameBox.getText().toString());
        Foogle foogle = new Foogle(nameBox.getText().toString(), level);
        dbHandler.addFoogle(foogle);

    }
}

