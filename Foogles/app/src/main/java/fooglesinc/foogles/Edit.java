package fooglesinc.foogles;

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

    @Override
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
//    Spinner spinner = (Spinner) findViewById(R.id.spinner_Color);
//
//    // Spinner click listener
//        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
//
//    // Spinner Drop down elements
//    List<String> categories = new ArrayList<String>();
//        categories.add("Yellow");
//        categories.add("Blue");
//        categories.add("Red");
//        categories.add("Orange");
//        categories.add("Green");
//        categories.add("Purple");
//
//    // Creating adapter for spinner
//    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
//
//    // Drop down layout style - list view with radio button
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//    // attaching data adapter to spinner
//        spinner.setAdapter(dataAdapter);
//
//}
//
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        // On selecting a spinner item
//        String item = parent.getItemAtPosition(position).toString();
//
//        // Showing selected spinner item
//        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
//    }
//    public void onNothingSelected(AdapterView<?> arg0) {
//
//    }
    }
}
