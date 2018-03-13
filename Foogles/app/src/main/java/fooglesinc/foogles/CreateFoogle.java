package fooglesinc.foogles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CreateFoogle extends AppCompatActivity {


    public static String foogleName;

    public static Spinner selectColor;
    ArrayAdapter<CharSequence> adapterColor;
    public static Spinner selectFace;
    ArrayAdapter<CharSequence> adapterFace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_foogle);

        selectColor = (Spinner)findViewById(R.id.spinner2);
        adapterColor = ArrayAdapter.createFromResource(this,R.array.Colors,android.R.layout.simple_spinner_item);
        adapterColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectColor.setAdapter(adapterColor);
        selectColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //Toast.makeText(getBaseContext(),adapterView.getItemAtPosition(position)+" selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        selectFace = (Spinner)findViewById(R.id.spinner3);
        adapterFace = ArrayAdapter.createFromResource(this,R.array.Foogle_Faces,android.R.layout.simple_spinner_item);
        adapterFace.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectFace.setAdapter(adapterFace);
        selectFace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //Toast.makeText(getBaseContext(),adapterView.getItemAtPosition(position)+" selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void backToMain(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
