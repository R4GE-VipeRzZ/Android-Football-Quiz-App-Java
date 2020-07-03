package dont_have_domain.football_logo_quiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class league_menu extends Activity {

    public void onBackPressed() {       //This tells android what to do on this activity when the back button is pressed
        Intent intent = new Intent(league_menu.this, main_menu.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);       //This removes the status bar from view
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_league_menu);

        SharedPreferences sharedPref = getSharedPreferences("RecordCorrect", Context.MODE_PRIVATE);     //This sets up a sharedpreferences file so the program can read from sharedpreferences

        int epl_badges_correct = sharedPref.getInt("epl_correct_count", 0);         //This reads the number of coins from the coin_count variable and assigns it to coin_count_number

        final TextView eplBadgesCorrect = (TextView) findViewById(R.id.eplProgressCount);              //This changes the number of coins text to the number in the coin_count sharedpreferences
        eplBadgesCorrect.setText((Integer.toString(epl_badges_correct)+"/20"));

        final ProgressBar eplProgressBar = (ProgressBar) findViewById(R.id.eplProgressBar);
        eplProgressBar.setProgress((int)(epl_badges_correct*5));



        int efl_champ_badges_correct = sharedPref.getInt("efl_champ_correct_count", 0);         //This reads the number of coins from the coin_count variable and assigns it to coin_count_number

        final TextView eflChampBadgesCorrect = (TextView) findViewById(R.id.eflChampProgressCount);              //This changes the number of coins text to the number in the coin_count sharedpreferences
        eflChampBadgesCorrect.setText((Integer.toString(efl_champ_badges_correct)+"/24"));

        final ProgressBar eflChampProgressBar = (ProgressBar) findViewById(R.id.eflChampProgressBar);

        if (efl_champ_badges_correct == 24){
            eflChampProgressBar.setProgress(100);
        }else{
            eflChampProgressBar.setProgress((int)(efl_champ_badges_correct*4.16));
        }


/*
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();

        FrameLayout.LayoutParams buttonSize = new FrameLayout.LayoutParams((int)(width - (width /20)),(int)(height / ((double)height / (double)width)));

        final Button btnEpl = (Button) findViewById(R.id.btnEpl);
        btnEpl.setLayoutParams(buttonSize);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT
        );

        int margin = ((width / 20) / 2);


        params.setMargins(margin, (int)(margin * 1.1), margin,0);
        btnEpl.setLayoutParams(params);
        */


        Button advanceToEnglishPrem = (Button) findViewById(R.id.btnEpl);
        advanceToEnglishPrem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(league_menu.this, english_premier_league.class);
                startActivity(intent);
            }
        });

        Button advanceToEnglishChamp = (Button) findViewById(R.id.btnEflChamp);
        advanceToEnglishChamp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(league_menu.this, english_champ_league.class);
                startActivity(intent);
            }
        });

    }
}
