package fooglesinc.foogles;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class Edit extends AppCompatActivity {

    TextView idView;
    TextView productBox;
    TextView quantityBox;


    public static final String EXTRA_MESSAGE = "com.example.foogles.MESSAGE";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        idView = (TextView) findViewById(R.id.ID);
        productBox = (EditText) findViewById(R.id.Name);
        quantityBox = (EditText) findViewById(R.id.Energy);
    }


    public void saveFoogle(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        //String mode = "Save";
        //intent.putExtra(EXTRA_MESSAGE, mode);
        startActivity(intent);
    }

    public void lookupProduct (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        Foogle foogle =
                dbHandler.findFoogle(productBox.getText().toString());

        if (foogle != null) {
            idView.setText(String.valueOf(foogle.get_id()));

            quantityBox.setText(String.valueOf(foogle.getLevel()));
        } else {
            idView.setText("No Match Found");
        }
    }

    public void updateProduct(View view)
    {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        dbHandler.updateFoogle(productBox.getText());
    }

    public void removeProduct (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null,
                null, 1);

        boolean result = dbHandler.deleteFoogle(
                productBox.getText().toString());

        if (result)
        {
            idView.setText("Record Deleted");
            productBox.setText("");
            quantityBox.setText("");
        }
        else
            idView.setText("No Match Found");
    }




}

