package fooglesinc.foogles;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.Random;

public class foogle_fish extends AppCompatActivity {

    public static String message;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_foogle_fish);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.FOOGLE_NAME);
    }

//    public void catchClick() {
//        final ImageButton catchFish = (ImageButton) findViewById(R.id.CatchButton);
//        catchFish.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void OnClick(View view)
//            {
//                showFish();
//            }
//        });
//        public void onClick(View view) {
//            showFish();
//        }
//    }

    public void rewardFoogle(View view)
    {
        Intent intent = new Intent(this, Rewards.class);
        intent.putExtra(MainActivity.FOOGLE_NAME, message);
        startActivity(intent);
    }

//    public void fishOnHook()
//    {
//        final ImageButton catchFish = (ImageButton) findViewById(R.id.CatchButton);
//        final ImageView fishAvailable = (ImageView) findViewById(R.id.ExclamationPoint);
//        fishAvailable.setVisibility(View.INVISIBLE);
//        fishAvailable.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                fishAvailable.setVisibility(View.VISIBLE);
//                catchFish.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view)
//                    {
//                        showFish();
//                    }
//                });
//            }
//        }, 3000);
//    }

    public void startFishing(View view)
    {
        //make Start button invisible during gameplay
        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setVisibility(View.INVISIBLE);
        //button to click when you want to catch the fish
        final ImageButton catchFish = (ImageButton) findViewById(R.id.CatchButton);
        //Exclamation Point image to alert user there is a fish on the hook - initially invisible then visible for 3 seconds and repeat
        final ImageView fishAvailable = (ImageView) findViewById(R.id.ExclamationPoint);
        fishAvailable.setVisibility(View.INVISIBLE);
        fishAvailable.postDelayed(new Runnable() {
            @Override
            public void run() {
                fishAvailable.setVisibility(View.VISIBLE);
                catchFish.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        //display to the user the fish they caught
                        showFish();
                    }
                });
            }
        }, 3000);
        startFishing(null);
    }

    public int randomizeFish() {
        //generate a random number to determine which fish is caught
        Random fishChoice = new Random();

        //use numbers 1-5 to represent each fish
        final int min = 1, max = 5;
        int caughtFish;

        caughtFish = fishChoice.nextInt((max - min) + 1) + min;

        return caughtFish;
    }

    public void showFish()
    {
        //Get the instance of the LayoutInflater using the context of this activity
        LayoutInflater inflater = (LayoutInflater) foogle_fish.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Inflate the view from a predefined XML layout (no need for root id, using entire layout)
        View layout = inflater.inflate(R.layout.popuplayout,null);
        int randomFish = randomizeFish();

        //caught fish is Sea Horse
        if(randomFish == 1) {
            String Text1 = getString(R.string.YouCaughtA);
            String Text2 = getString(R.string.SHorseText);
            ((TextView) layout.findViewById(R.id.SHorseText1)).setText(Text1);
            ((TextView) layout.findViewById(R.id.SHorseText2)).setText(Text2);
            // create a focusable PopupWindow with the given layout
            final PopupWindow pw = new PopupWindow(layout, 240, 285, true);
            //Button to close the pop-up window
            ((Button) layout.findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    pw.dismiss();
                }
            });
            pw.showAtLocation(layout, Gravity.CENTER, 0, 0);
        }
        //caught fish is Barred Knifejaw
        else if(randomFish == 2) {
            String Text1 = getString(R.string.YouCaughtA);
            String Text2 = getString(R.string.BarredText);
            ((TextView) layout.findViewById(R.id.BarredText1)).setText(Text1);
            ((TextView) layout.findViewById(R.id.BarredText2)).setText(Text2);
            // create a focusable PopupWindow with the given layout
            final PopupWindow pw = new PopupWindow(layout, 240, 285, true);
            //Button to close the pop-up window
            ((Button) layout.findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    pw.dismiss();
                }
            });
            pw.showAtLocation(layout, Gravity.CENTER, 0, 0);
        }
        //caught fish is Octopus
        else if(randomFish == 3) {
            String Text1 = getString(R.string.YouCaughtAn);
            String Text2 = getString(R.string.OctopusText);
            ((TextView) layout.findViewById(R.id.OctopusText1)).setText(Text1);
            ((TextView) layout.findViewById(R.id.OctopusText2)).setText(Text2);
            // create a focusable PopupWindow with the given layout
            final PopupWindow pw = new PopupWindow(layout, 240, 285, true);
            //Button to close the pop-up window
            ((Button) layout.findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    pw.dismiss();
                }
            });
            pw.showAtLocation(layout, Gravity.CENTER, 0, 0);
        }
        //caught fish is Angler Fish
        else if(randomFish == 4) {
            String Text1 = getString(R.string.YouCaughtAn);
            String Text2 = getString(R.string.AnglerText);
            ((TextView) layout.findViewById(R.id.AnglerText1)).setText(Text1);
            ((TextView) layout.findViewById(R.id.AnglerText2)).setText(Text2);
            // create a focusable PopupWindow with the given layout
            final PopupWindow pw = new PopupWindow(layout, 240, 285, true);
            //Button to close the pop-up window
            ((Button) layout.findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    pw.dismiss();
                }
            });
            pw.showAtLocation(layout, Gravity.CENTER, 0, 0);
        }
        //caught fish is Shark
        else if(randomFish == 5) {
            String Text1 = getString(R.string.YouCaughtA);
            String Text2 = getString(R.string.SharkText);
            ((TextView) layout.findViewById(R.id.SharkText1)).setText(Text1);
            ((TextView) layout.findViewById(R.id.SharkText2)).setText(Text2);
            // create a focusable PopupWindow with the given layout
            final PopupWindow pw = new PopupWindow(layout, 240, 285, true);
            //Button to close the pop-up window
            ((Button) layout.findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    pw.dismiss();
                }
            });
            pw.showAtLocation(layout, Gravity.CENTER, 0, 0);
        }

    }
}