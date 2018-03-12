package fooglesinc.foogles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Edit extends AppCompatActivity {

    public static Spinner editFoogleColor;
    public static Spinner editFoogleCostume;
    public static Spinner editFoogleMisc;
    ArrayAdapter<CharSequence> adapter;


    public static final String EXTRA_MESSAGE = "com.example.foogles.MESSAGE";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        View decorView = getWindow().getDecorView();
//        decorView.setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        // Spinner element
      editFoogleColor = (Spinner) findViewById(R.id.spinner_Color);
        adapter = ArrayAdapter.createFromResource(this,R.array.Colors,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editFoogleColor.setAdapter(adapter);
        editFoogleColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //Toast.makeText(getBaseContext(),adapterView.getItemAtPosition(position)+" selected",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        editFoogleCostume = (Spinner) findViewById(R.id.spinner_costume);
        adapter = ArrayAdapter.createFromResource(this,R.array.Costumes,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editFoogleCostume.setAdapter(adapter);
        editFoogleCostume.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //Toast.makeText(getBaseContext(),adapterView.getItemAtPosition(position)+" selected",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        editFoogleMisc = (Spinner) findViewById(R.id.spinner_misc);
        adapter = ArrayAdapter.createFromResource(this,R.array.Misc,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editFoogleMisc.setAdapter(adapter);
        editFoogleMisc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //Toast.makeText(getBaseContext(),adapterView.getItemAtPosition(position)+" selected",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void saveFoogle(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        //String mode = "Save";
        //intent.putExtra(EXTRA_MESSAGE, mode);
        startActivity(intent);
    }
}

