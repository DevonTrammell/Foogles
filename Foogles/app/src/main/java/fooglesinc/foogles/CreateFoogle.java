package fooglesinc.foogles;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;



public class CreateFoogle extends AppCompatActivity {


    TextView productBox;
    TextView quantityBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_foogle);


        productBox = (EditText) findViewById(R.id.EditName);


    }

    public void newProduct (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        int level = 1;
        Foogle foogle =
                new Foogle(productBox.getText().toString(), level);

        dbHandler.addFoogle(foogle);
        productBox.setText("");
        quantityBox.setText("");
    }




    public void backToMain(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
