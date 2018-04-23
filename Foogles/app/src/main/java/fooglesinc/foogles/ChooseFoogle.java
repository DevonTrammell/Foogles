package fooglesinc.foogles;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;

public class ChooseFoogle extends AppCompatActivity {

    public static Spinner selectFoogle;
    public static ArrayAdapter<String> adapter;
    public static String message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_foogle);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);


        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        ArrayList<String> list = dbHandler.getAllElements();



        TextView textView = findViewById(R.id.textView);
        String displayedMessage = "Please choose a Foogle to play "+message;
        textView.setText(displayedMessage);

        selectFoogle = (Spinner)findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectFoogle.setAdapter(adapter);
        selectFoogle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getBaseContext(),adapterView.getItemAtPosition(position)+" selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void goToGame(View view) {
        Intent intent;//' = new Intent(this,Rewards.class);//this will be FoogleHop.class then go to rewards.;
        if(message.equals("Foogle Climb"))
        {
            // these class files need to be made and implemented before we can do all this jazz.
            intent = new Intent(this,foogle_climb.class);//this will be FoogleHop.class then go to rewards.
            //intent = new Intent(this,Rewards.class);//this will be FoogleHop.class then go to rewards.
        }
        else if(message.equals("Foogle Fishing"))
        {
            intent = new Intent(this,foogle_fish.class);//this will be FoogleHop.class then go to rewards.
            //intent = new Intent(this,Rewards.class);//this will be FoogleHop.class then go to rewards.
        }
        else if(message.equals("Foogle Hop"))
        {
            intent = new Intent(this,foogle_hop.class);//this will be FoogleHop.class then go to rewards.
            //intent = new Intent(this,Rewards.class);//this will be FoogleHop.class then go to rewards.
        }
        else if(message.equals("Foogle Swim"))
        {
            intent = new Intent(this,foogle_swim.class);//this will be FoogleHop.class then go to rewards.
            //intent = new Intent(this,Rewards.class);//this will be FoogleHop.class then go to rewards.
        }
        else if(message.equals("Whack-a-Foogle"))
        {
            intent = new Intent(this,whack_a_foogle.class);//this will be FoogleHop.class then go to rewards.
            //intent = new Intent(this,Rewards.class);//this will be FoogleHop.class then go to rewards.
        }
        else if(message.equals("Edit is not a game"))
        {
            intent = new Intent(this,Edit.class);
        }
        else if(message.equals("Walk"))
        {
            intent = new Intent(this,Walk.class);//this will be FoogleHop.class then go to rewards.
        }
        else
        {
            intent = new Intent(this,Rewards.class);//this will be FoogleHop.class then go to rewards.
        }
        intent.putExtra(MainActivity.FOOGLE_NAME,selectFoogle.getSelectedItem().toString());
        startActivity(intent);
    }
}
