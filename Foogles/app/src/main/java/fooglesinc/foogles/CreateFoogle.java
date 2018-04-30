package fooglesinc.foogles;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;



public class CreateFoogle extends AppCompatActivity {

    TextView idView;
    TextView productBox;
    TextView quantityBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_create_foogle);

        idView = (TextView) findViewById(R.id.FoogleID);
        productBox = (EditText) findViewById(R.id.EditName);
        quantityBox =
                (EditText) findViewById(R.id.FoogleEnergy);

    }

    public void newProduct (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        int quantity =
                Integer.parseInt(quantityBox.getText().toString());

        Foogle foogle =
                new Foogle(productBox.getText().toString(), quantity);

        dbHandler.addFoogle(foogle);
        productBox.setText("");
        quantityBox.setText("");
    }

    public void lookupProduct (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        Foogle foogle =
                dbHandler.findFoogle(productBox.getText().toString());

        if (foogle != null) {
            idView.setText(String.valueOf(foogle.get_id()));

            quantityBox.setText(String.valueOf(foogle.getEnergy()));
        } else {
            idView.setText("No Match Found");
        }
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

    public void backToMain(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
