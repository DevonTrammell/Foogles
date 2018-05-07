package fooglesinc.foogles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Walk extends AppCompatActivity {

    public static String message;

    public static Spinner selectWhere;
    ArrayAdapter<CharSequence> adapterWhere;
    public static Spinner selectWhen;
    ArrayAdapter<CharSequence> adapterWhen;
    public static Spinner selectPet;
    ArrayAdapter<CharSequence> adapterPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_walk);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.FOOGLE_NAME);

        selectWhere = (Spinner)findViewById(R.id.spinner2);
        adapterWhere = ArrayAdapter.createFromResource(this,R.array.Walk_Locations,android.R.layout.simple_spinner_item);
        adapterWhere.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectWhere.setAdapter(adapterWhere);
        selectWhere.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //Toast.makeText(getBaseContext(),adapterView.getItemAtPosition(position)+" selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        selectWhen = (Spinner)findViewById(R.id.spinner3);
        adapterWhen = ArrayAdapter.createFromResource(this,R.array.Walk_Times,android.R.layout.simple_spinner_item);
        adapterWhen.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectWhen.setAdapter(adapterWhen);
        selectWhen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //Toast.makeText(getBaseContext(),adapterView.getItemAtPosition(position)+" selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        selectPet = (Spinner)findViewById(R.id.spinner4);
        adapterPet = ArrayAdapter.createFromResource(this,R.array.Pet_Options,android.R.layout.simple_spinner_item);
        adapterPet.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectPet.setAdapter(adapterPet);
        selectPet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //Toast.makeText(getBaseContext(),adapterView.getItemAtPosition(position)+" selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void walkAnimation(View view) {
        Intent intent = new Intent(this, walk_animation.class);
        intent.putExtra(MainActivity.FOOGLE_NAME, message);
        startActivity(intent);
    }
}
