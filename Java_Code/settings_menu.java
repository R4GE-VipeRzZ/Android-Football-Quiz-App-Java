package dont_have_domain.football_logo_quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class settings_menu extends AppCompatActivity {
    public String density = "";


    public void onBackPressed() {       //This tells android what to do on this activity when the back button is pressed
        clear();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Button correct_vibration = (Button) findViewById(R.id.btnVibrations);
        correct_vibration.setVisibility(View.GONE);
        Button correct_vibration_buttons = (Button) findViewById(R.id.btnVibrationButtons);
        correct_vibration_buttons.setVisibility(View.GONE);
        Button correct_sound_button = (Button) findViewById(R.id.btnCorrectSound);
        correct_sound_button.setVisibility(View.GONE);
        Button button_sound_button = (Button) findViewById(R.id.btnButtonSound);
        button_sound_button.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);       //This removes the status bar from view
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_settings_menu);

        if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_NORMAL){     //This detects the type of device that's using the app
            density = "NORMAL";
        }else if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE){
            density = "XLARGE";
        }else if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE){
            density = "LARGE";
        }else if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_SMALL){
            density = "SMALL";
        }


        SharedPreferences sharedPref = getSharedPreferences("RecordCorrect", Context.MODE_PRIVATE);     //This sets up a sharedpreferences file so the program can permanantly save if the user has got the answer correct

//        SharedPreferences.Editor editor = sharedPref.edit();      //Run this to set vibration_setting to true
//        editor.putBoolean("vibration_setting", true);
//        editor.apply();

        final Boolean vibration_setting = sharedPref.getBoolean("vibration_setting", false);         //This assigns the boolean value for the vibration settings to vibration_setting
        final Boolean button_vibration_setting = sharedPref.getBoolean("button_vibration_setting", false);         //This assigns the boolean value for the button vibration settings to button_vibration_setting
        final Boolean sound_correct_settings = sharedPref.getBoolean("sound_correct_settings", false);         //This assigns the boolean value for the correct sounds setting to sound_correct_settings
        final Boolean sound_button_setting = sharedPref.getBoolean("sound_button_setting", false);         //This assigns the boolean value for the button sound setting to sound_button_setting




        final Button btn_vibration = (Button) findViewById(R.id.btnVibrations);
        final Button btn_vibration_buttons = (Button) findViewById(R.id.btnVibrationButtons);
        final Button btn_correct_sound = (Button) findViewById(R.id.btnCorrectSound);
        final Button btn_button_sound = (Button) findViewById(R.id.btnButtonSound);

        if (density == "NORMAL") {
            if (vibration_setting == true) {
                btn_vibration.setBackgroundResource(R.drawable.custom_button_normal_vibration_off);
            } else if (vibration_setting == false) {
                btn_vibration.setBackgroundResource(R.drawable.custom_button_normal_vibration_on);
            }

            if (button_vibration_setting == true) {
                btn_vibration_buttons.setBackgroundResource(R.drawable.custom_button_normal_button_vibration_off);
            } else if (button_vibration_setting == false) {
                btn_vibration_buttons.setBackgroundResource(R.drawable.custom_button_normal_button_vibration_on);
            }

            if (sound_correct_settings == true) {
                btn_correct_sound.setBackgroundResource(R.drawable.custom_button_normal_correct_sound_off);
            } else if (sound_correct_settings == false) {
                btn_correct_sound.setBackgroundResource(R.drawable.custom_button_normal_correct_sound_on);
            }

            if (sound_button_setting == true) {
                btn_button_sound.setBackgroundResource(R.drawable.custom_button_normal_button_sound_off);
            } else if (sound_button_setting == false) {
                btn_button_sound.setBackgroundResource(R.drawable.custom_button_normal_button_sound_on);
            }
        }else if (density == "XLARGE"){
            if (vibration_setting == true) {
                btn_vibration.setBackgroundResource(R.drawable.custom_button_xlarge_vibration_off);
            } else if (vibration_setting == false) {
                btn_vibration.setBackgroundResource(R.drawable.custom_button_xlarge_vibration_on);
            }

            if (button_vibration_setting == true) {
                btn_vibration_buttons.setBackgroundResource(R.drawable.custom_button_xlarge_button_vibration_off);
            } else if (button_vibration_setting == false) {
                btn_vibration_buttons.setBackgroundResource(R.drawable.custom_button_xlarge_button_vibration_on);
            }

            if (sound_correct_settings == true) {
                btn_correct_sound.setBackgroundResource(R.drawable.custom_button_xlarge_correct_sound_off);
            } else if (sound_correct_settings == false) {
                btn_correct_sound.setBackgroundResource(R.drawable.custom_button_xlarge_correct_sound_on);
            }

            if (sound_button_setting == true) {
                btn_button_sound.setBackgroundResource(R.drawable.custom_button_xlarge_button_sound_off);
            } else if (sound_button_setting == false) {
                btn_button_sound.setBackgroundResource(R.drawable.custom_button_xlarge_button_sound_on);
            }
        }else if (density == "LARGE"){
            if (vibration_setting == true) {
                btn_vibration.setBackgroundResource(R.drawable.custom_button_large_vibration_off);
            } else if (vibration_setting == false) {
                btn_vibration.setBackgroundResource(R.drawable.custom_button_large_vibration_on);
            }

            if (button_vibration_setting == true) {
                btn_vibration_buttons.setBackgroundResource(R.drawable.custom_button_large_button_vibration_off);
            } else if (button_vibration_setting == false) {
                btn_vibration_buttons.setBackgroundResource(R.drawable.custom_button_large_button_vibration_on);
            }

            if (sound_correct_settings == true) {
                btn_correct_sound.setBackgroundResource(R.drawable.custom_button_large_correct_sound_off);
            } else if (sound_correct_settings == false) {
                btn_correct_sound.setBackgroundResource(R.drawable.custom_button_large_correct_sound_on);
            }

            if (sound_button_setting == true) {
                btn_button_sound.setBackgroundResource(R.drawable.custom_button_large_button_sound_off);
            } else if (sound_button_setting == false) {
                btn_button_sound.setBackgroundResource(R.drawable.custom_button_large_button_sound_on);
            }
        }else if (density == "SMALL"){
            if (vibration_setting == true) {
                btn_vibration.setBackgroundResource(R.drawable.custom_button_small_vibration_off);
            } else if (vibration_setting == false) {
                btn_vibration.setBackgroundResource(R.drawable.custom_button_small_vibration_on);
            }

            if (button_vibration_setting == true) {
                btn_vibration_buttons.setBackgroundResource(R.drawable.custom_button_small_button_vibration_off);
            } else if (button_vibration_setting == false) {
                btn_vibration_buttons.setBackgroundResource(R.drawable.custom_button_small_button_vibration_on);
            }

            if (sound_correct_settings == true) {
                btn_correct_sound.setBackgroundResource(R.drawable.custom_button_small_correct_sound_off);
            } else if (sound_correct_settings == false) {
                btn_correct_sound.setBackgroundResource(R.drawable.custom_button_small_correct_sound_on);
            }

            if (sound_button_setting == true) {
                btn_button_sound.setBackgroundResource(R.drawable.custom_button_small_button_sound_off);
            } else if (sound_button_setting == false) {
                btn_button_sound.setBackgroundResource(R.drawable.custom_button_small_button_sound_on);
            }
        }

        Button change_vibration = (Button) findViewById(R.id.btnVibrations);
        change_vibration.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("RecordCorrect", Context.MODE_PRIVATE);     //This sets up a sharedpreferences file so the program can permanantly save if the user has got the answer correct

                if (vibration_setting == false){
                    SharedPreferences.Editor editor = sharedPref.edit();      //Run this to set vibration_setting to true
                    editor.putBoolean("vibration_setting", true);
                    editor.apply();
                }else if (vibration_setting == true){
                    SharedPreferences.Editor editor = sharedPref.edit();      //Run this to set vibration_setting to true
                    editor.putBoolean("vibration_setting", false);
                    editor.apply();
                }

                if (density == "NORMAL") {
                    if (vibration_setting == true) {
                        btn_vibration.setBackgroundResource(R.drawable.custom_button_normal_vibration_off);
                    } else if (vibration_setting == false) {
                        btn_vibration.setBackgroundResource(R.drawable.custom_button_normal_vibration_on);
                    }
                }else if (density == "XLARGE"){
                    if (vibration_setting == true) {
                        btn_vibration.setBackgroundResource(R.drawable.custom_button_xlarge_vibration_off);
                    } else if (vibration_setting == false) {
                        btn_vibration.setBackgroundResource(R.drawable.custom_button_xlarge_vibration_on);
                    }
                }else if (density == "LARGE"){
                    if (vibration_setting == true) {
                        btn_vibration.setBackgroundResource(R.drawable.custom_button_large_vibration_off);
                    } else if (vibration_setting == false) {
                        btn_vibration.setBackgroundResource(R.drawable.custom_button_large_vibration_on);
                    }
                }else if (density == "SMALL"){
                    if (vibration_setting == true) {
                        btn_vibration.setBackgroundResource(R.drawable.custom_button_small_vibration_off);
                    } else if (vibration_setting == false) {
                        btn_vibration.setBackgroundResource(R.drawable.custom_button_small_vibration_on);
                    }
                }

                Intent intent = getIntent();
                finish();
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        });



        Button change_vibration_buttons = (Button) findViewById(R.id.btnVibrationButtons);
        change_vibration_buttons.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("RecordCorrect", Context.MODE_PRIVATE);     //This sets up a sharedpreferences file so the program can permanantly save if the user has got the answer correct

                if (button_vibration_setting == false){
                    SharedPreferences.Editor editor = sharedPref.edit();      //Run this to set vibration_setting to true
                    editor.putBoolean("button_vibration_setting", true);
                    editor.apply();
                }else if (button_vibration_setting == true){
                    SharedPreferences.Editor editor = sharedPref.edit();      //Run this to set vibration_setting to true
                    editor.putBoolean("button_vibration_setting", false);
                    editor.apply();
                }

                if (density == "NORMAL") {
                    if (button_vibration_setting == true) {
                        btn_vibration_buttons.setBackgroundResource(R.drawable.custom_button_normal_button_vibration_off);
                    } else if (button_vibration_setting == false) {
                        btn_vibration_buttons.setBackgroundResource(R.drawable.custom_button_normal_button_vibration_on);
                    }
                }else if (density == "XLARGE"){
                    if (vibration_setting == true) {
                        btn_vibration_buttons.setBackgroundResource(R.drawable.custom_button_xlarge_button_vibration_off);
                    } else if (vibration_setting == false) {
                        btn_vibration_buttons.setBackgroundResource(R.drawable.custom_button_xlarge_button_vibration_on);
                    }
                }else if (density == "LARGE"){
                    if (vibration_setting == true) {
                        btn_vibration_buttons.setBackgroundResource(R.drawable.custom_button_large_button_vibration_off);
                    } else if (vibration_setting == false) {
                        btn_vibration_buttons.setBackgroundResource(R.drawable.custom_button_large_button_vibration_on);
                    }
                }else if (density == "SMALL"){
                    if (vibration_setting == true) {
                        btn_vibration_buttons.setBackgroundResource(R.drawable.custom_button_small_button_vibration_off);
                    } else if (vibration_setting == false) {
                        btn_vibration_buttons.setBackgroundResource(R.drawable.custom_button_small_button_vibration_on);
                    }
                }

                Intent intent = getIntent();
                finish();
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        });



        Button correct_sound = (Button) findViewById(R.id.btnCorrectSound);
        correct_sound.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("RecordCorrect", Context.MODE_PRIVATE);     //This sets up a sharedpreferences file so the program can permanantly save if the user has got the answer correct

                if (sound_correct_settings == false){
                    SharedPreferences.Editor editor = sharedPref.edit();      //Run this to set vibration_setting to true
                    editor.putBoolean("sound_correct_settings", true);
                    editor.apply();
                }else if (sound_correct_settings == true){
                    SharedPreferences.Editor editor = sharedPref.edit();      //Run this to set vibration_setting to true
                    editor.putBoolean("sound_correct_settings", false);
                    editor.apply();
                }

                if (density == "NORMAL") {
                    if (sound_correct_settings == true) {
                        btn_correct_sound.setBackgroundResource(R.drawable.custom_button_normal_correct_sound_off);
                    } else if (sound_correct_settings == false) {
                        btn_correct_sound.setBackgroundResource(R.drawable.custom_button_normal_correct_sound_on);
                    }
                }else if (density == "XLARGE"){
                    if (sound_correct_settings == true) {
                        btn_correct_sound.setBackgroundResource(R.drawable.custom_button_xlarge_correct_sound_off);
                    } else if (sound_correct_settings == false) {
                        btn_correct_sound.setBackgroundResource(R.drawable.custom_button_xlarge_correct_sound_on);
                    }
                }else if (density == "LARGE"){
                    if (sound_correct_settings == true) {
                        btn_correct_sound.setBackgroundResource(R.drawable.custom_button_large_correct_sound_off);
                    } else if (sound_correct_settings == false) {
                        btn_correct_sound.setBackgroundResource(R.drawable.custom_button_large_correct_sound_on);
                    }
                }else if (density == "SMALL"){
                    if (sound_correct_settings == true) {
                        btn_correct_sound.setBackgroundResource(R.drawable.custom_button_small_correct_sound_off);
                    } else if (sound_correct_settings == false) {
                        btn_correct_sound.setBackgroundResource(R.drawable.custom_button_small_correct_sound_on);
                    }
                }

                Intent intent = getIntent();
                finish();
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        });



        Button button_sound = (Button) findViewById(R.id.btnButtonSound);
        button_sound.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("RecordCorrect", Context.MODE_PRIVATE);     //This sets up a sharedpreferences file so the program can permanantly save if the user has got the answer correct

                if (sound_button_setting == false){
                    SharedPreferences.Editor editor = sharedPref.edit();      //Run this to set vibration_setting to true
                    editor.putBoolean("sound_button_setting", true);
                    editor.apply();
                }else if (sound_button_setting == true){
                    SharedPreferences.Editor editor = sharedPref.edit();      //Run this to set vibration_setting to true
                    editor.putBoolean("sound_button_setting", false);
                    editor.apply();
                }

                if (density == "NORMAL") {
                    if (sound_button_setting == true) {
                        btn_button_sound.setBackgroundResource(R.drawable.custom_button_normal_button_sound_off);
                    } else if (sound_button_setting == false) {
                        btn_button_sound.setBackgroundResource(R.drawable.custom_button_normal_button_sound_on);
                    }
                }else if (density == "XLARGE"){
                    if (sound_button_setting == true) {
                        btn_button_sound.setBackgroundResource(R.drawable.custom_button_xlarge_button_sound_off);
                    } else if (sound_button_setting == false) {
                        btn_button_sound.setBackgroundResource(R.drawable.custom_button_xlarge_button_sound_on);
                    }
                }else if (density == "LARGE"){
                    if (sound_button_setting == true) {
                        btn_button_sound.setBackgroundResource(R.drawable.custom_button_large_button_sound_off);
                    } else if (sound_button_setting == false) {
                        btn_button_sound.setBackgroundResource(R.drawable.custom_button_large_button_sound_on);
                    }
                }else if (density == "SMALL"){
                    if (sound_button_setting == true) {
                        btn_button_sound.setBackgroundResource(R.drawable.custom_button_small_button_sound_off);
                    } else if (sound_button_setting == false) {
                        btn_button_sound.setBackgroundResource(R.drawable.custom_button_small_button_sound_on);
                    }
                }

                Intent intent = getIntent();
                finish();
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        });
    }

    public void clear(){       //This method changes the activity to the english_premier_league menu without an animation
        Intent intent = new Intent(settings_menu.this, main_menu.class);        //This changes the activity
        finish();
    }
}
