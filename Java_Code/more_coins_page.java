package dont_have_domain.football_logo_quiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class more_coins_page extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);       //This removes the status bar from view
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_more_coins_page);

        Button btnMoreCoins = (Button) findViewById(R.id.btnMoreCoins);
        btnMoreCoins.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("RecordCorrect", Context.MODE_PRIVATE);     //This sets up a sharedpreferences file so the program can read from sharedpreferences

                int current_coins = sharedPref.getInt("coin_count", 0);         //This reads the number of coins from the coin_count variable and assigns it to coin_count_number

                current_coins++;

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("coin_count", current_coins);                //Sets the coin count
                editor.apply();
            }
        });
    }
}
