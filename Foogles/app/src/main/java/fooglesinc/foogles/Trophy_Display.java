package fooglesinc.foogles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Trophy_Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trophy__display);
        TextView textView = findViewById(R.id.textView);
        String displayedMessage = "Yup, this is where I'd put a trophy case ........ ";
        textView.setText(displayedMessage);
        textView = findViewById(R.id.textView7);
        displayedMessage = "IF I HAD ONE!";
        textView.setText(displayedMessage);

    }
}
