package fooglesinc.foogles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import static fooglesinc.foogles.MainActivity.DIFFICULTY;
import static fooglesinc.foogles.MainActivity.LEVEL;
import static fooglesinc.foogles.MainActivity.MYPREFS;

public class Tournament extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_tournament);
    }

    public void littleLeague(View view) {
        Intent intent = new Intent(this, Racing.class);
        SharedPreferences sp = getSharedPreferences(MYPREFS,0);
        int difficulty = sp.getInt(LEVEL,0); // this will tell us on the next page how hard the race should be.
        intent.putExtra(DIFFICULTY, difficulty);
        startActivity(intent);
    }
    public void bigLeague(View view) {
        Intent intent = new Intent(this, Racing.class);
        SharedPreferences sp = getSharedPreferences(MYPREFS,0);
        int difficulty = sp.getInt(LEVEL,1);
        intent.putExtra(DIFFICULTY, difficulty);
        startActivity(intent);
    }
    public void reallyBigLeague(View view) {
        Intent intent = new Intent(this, Racing.class);
        SharedPreferences sp = getSharedPreferences(MYPREFS,0);
        int difficulty = sp.getInt(LEVEL,2);
        intent.putExtra(DIFFICULTY, difficulty);
        startActivity(intent);
    }
}
