package fooglesinc.foogles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class foogle_hop extends AppCompatActivity {

    public static String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foogle_hop);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.FOOGLE_NAME);
    }
    public void rewardFoogle(View view)
    {
        Intent intent = new Intent(this, Rewards.class);
        intent.putExtra(MainActivity.FOOGLE_NAME, message);
        startActivity(intent);
    }
}
