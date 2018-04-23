package fooglesinc.foogles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static fooglesinc.foogles.MainActivity.DIFFICULTY;

public class Tournament extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament);
    }

    public void littleLeague(View view) {
        Intent intent = new Intent(this, Racing.class);
        int difficulty = 0; // this will tell us on the next page how hard the race should be.
        intent.putExtra(DIFFICULTY, difficulty);
        startActivity(intent);
    }
    public void bigLeague(View view) {
        Intent intent = new Intent(this, Racing.class);
        int difficulty = 1;
        intent.putExtra(DIFFICULTY, difficulty);
        startActivity(intent);
    }
    public void reallyBigLeague(View view) {
        Intent intent = new Intent(this, Racing.class);
        int difficulty = 2;
        intent.putExtra(DIFFICULTY, difficulty);
        startActivity(intent);
    }
}
