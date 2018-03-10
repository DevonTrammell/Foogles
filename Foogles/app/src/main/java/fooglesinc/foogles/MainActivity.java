package fooglesinc.foogles;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.foogles.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*View decorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
                            */
    }
    public void selectGame(View view) {
        Intent intent = new Intent(this, GameSelect.class);
        //EditText editText = (EditText) findViewByID(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void walkAFoogle(View view){
        //Intent intent = new Intent(this, Walk.class);
        //startActivity(intent);
    }
    public void marketplace(View view){
        //Intent intent = new Intent(this, Marketplace.class);
        //startActivity(intent);
    }
    public void editFoogle(View view){
        Intent intent = new Intent(this, Edit.class);
        startActivity(intent);
    }
    public void fooglympics(View view){
        Intent intent = new Intent(this,Tournament.class);
        startActivity(intent);
    }
}

