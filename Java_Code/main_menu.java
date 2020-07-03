package dont_have_domain.football_logo_quiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class main_menu extends Activity {

    public void onBackPressed() {       //This tells android what to do on this activity when the back button is pressed
        finish();
        moveTaskToBack(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);       //This removes the status bar from view
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_menu);

        SharedPreferences sharedPref = getSharedPreferences("RecordCorrect", Context.MODE_PRIVATE);     //This sets up a sharedpreferences file so the program can permanantly save if the user has got the answer correct

        final Boolean returning_user = sharedPref.getBoolean("returning_user", false);         //This assigns the boolean value for the vibration settings to vibration_setting

        if (returning_user != true){
            SharedPreferences.Editor editor = sharedPref.edit();      //Run this to set vibration_setting to true
            editor.putBoolean("vibration_setting", false);
            editor.putBoolean("button_vibration_setting", false);
            editor.putBoolean("sound_correct_settings", true);
            editor.putBoolean("sound_button_setting", true);
            editor.putBoolean("arsenal_correct", false);
            editor.putBoolean("astonvilla_correct", false);
            editor.putBoolean("bournemouth_correct", false);
            editor.putBoolean("brighton_correct", false);
            editor.putBoolean("burnley_correct", false);
            editor.putBoolean("chelsea_correct", false);
            editor.putBoolean("crystalpalace_correct", false);
            editor.putBoolean("everton_correct", false);
            editor.putBoolean("leicester_correct", false);
            editor.putBoolean("liverpool_correct", false);
            editor.putBoolean("mancity_correct", false);
            editor.putBoolean("manunited_correct", false);
            editor.putBoolean("newcastle_correct", false);
            editor.putBoolean("norwich_correct", false);
            editor.putBoolean("southampton_correct", false);
            editor.putBoolean("shefunited_correct", false);
            editor.putBoolean("spurs_correct", false);
            editor.putBoolean("watford_correct", false);
            editor.putBoolean("westham_correct", false);
            editor.putBoolean("wolves_correct", false);



            editor.putBoolean("barnsely_correct", false);
            editor.putBoolean("shefwednesday_correct", false);
            editor.putBoolean("hull_correct", false);
            editor.putBoolean("charlton_correct", false);
            editor.putBoolean("blackburn_correct", false);
            editor.putBoolean("preston_correct", false);
            editor.putBoolean("luton_correct", false);
            editor.putBoolean("fullham_correct", false);
            editor.putBoolean("westbrom_correct", false);
            editor.putBoolean("reading_correct", false);
            editor.putBoolean("huddersfield_correct", false);
            editor.putBoolean("cardiff_correct", false);
            editor.putBoolean("birmingham_correct", false);
            editor.putBoolean("nottsforest_correct", false);
            editor.putBoolean("leeds_correct", false);
            editor.putBoolean("derby_correct", false);
            editor.putBoolean("swansea_correct", false);
            editor.putBoolean("qpr_correct", false);
            editor.putBoolean("middlesbrough_correct", false);
            editor.putBoolean("bristol_correct", false);
            editor.putBoolean("millwall_correct", false);
            editor.putBoolean("stoke_correct", false);
            editor.putBoolean("brentford_correct", false);
            editor.putBoolean("wigan_correct", false);

            editor.putInt("coin_count", 500);                //Sets the coin count for when the program is run for the first time

            editor.putInt("epl_correct_count", 0);          //This sets the number of correct epl badges to 0
            editor.putInt("efl_champ_correct_count", 0);

            editor.putBoolean("returning_user", true);
            editor.apply();
        }

        Button advanceToLeagueMenu = (Button) findViewById(R.id.btnPlay);
        advanceToLeagueMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main_menu.this, league_menu.class);
                startActivity(intent);
            }
        });

        Button advanceToSettingsMenu = (Button) findViewById(R.id.btnSettings);
        advanceToSettingsMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main_menu.this, settings_menu.class);
                startActivity(intent);
            }
        });

        Button exitProgram = (Button) findViewById(R.id.btnExit);
        exitProgram.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
                moveTaskToBack(true);
            }
        });
    }
}



