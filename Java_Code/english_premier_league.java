package dont_have_domain.football_logo_quiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class english_premier_league extends Activity {

    public void onBackPressed() {       //This tells android what to do on this activity when the back button is pressed
        Intent intent = new Intent(english_premier_league.this, league_menu.class);
        startActivity(intent);
        finish();
    }

    protected void onDestroy() {
        final Button btnArsenal = (Button) findViewById(R.id.btnArsenal);
        btnArsenal.setVisibility(View.GONE);
        final Button btnManunited = (Button) findViewById(R.id.btnManunited);
        btnManunited.setVisibility(View.GONE);
        final Button btnBurnley = (Button) findViewById(R.id.btnBurnley);
        btnBurnley.setVisibility(View.GONE);
        final Button btnAstonvilla = (Button) findViewById(R.id.btnAstonvilla);
        btnAstonvilla.setVisibility(View.GONE);
        final Button btnEverton = (Button) findViewById(R.id.btnEverton);
        btnEverton.setVisibility(View.GONE);
        final Button btnWatford = (Button) findViewById(R.id.btnWatford);
        btnWatford.setVisibility(View.GONE);
        final Button btnLiverpool = (Button) findViewById(R.id.btnLiverpool);
        btnLiverpool.setVisibility(View.GONE);
        final Button btnMancity = (Button) findViewById(R.id.btnMancity);
        btnMancity.setVisibility(View.GONE);
        final Button btnBrighton = (Button) findViewById(R.id.btnBrighton);
        btnBrighton.setVisibility(View.GONE);
        final Button btnSouthampton = (Button) findViewById(R.id.btnSouthampton);
        btnSouthampton.setVisibility(View.GONE);
        final Button btnCrystalpalace = (Button) findViewById(R.id.btnCrystalpalace);
        btnCrystalpalace.setVisibility(View.GONE);
        final Button btnSpurs = (Button) findViewById(R.id.btnSpurs);
        btnSpurs.setVisibility(View.GONE);
        final Button btnWestham = (Button) findViewById(R.id.btnWestham);
        btnWestham.setVisibility(View.GONE);
        final Button btnLeicester = (Button) findViewById(R.id.btnLeicester);
        btnLeicester.setVisibility(View.GONE);
        final Button btnBournemouth = (Button) findViewById(R.id.btnBournemouth);
        btnBournemouth.setVisibility(View.GONE);
        final Button btnNewcastle = (Button) findViewById(R.id.btnNewcastle);
        btnNewcastle.setVisibility(View.GONE);
        final Button btnChelsea = (Button) findViewById(R.id.btnChelsea);
        btnChelsea.setVisibility(View.GONE);
        final Button btnNorwich = (Button) findViewById(R.id.btnNorwich);
        btnNorwich.setVisibility(View.GONE);
        final Button btnShefunited = (Button) findViewById(R.id.btnShefunited);
        btnShefunited.setVisibility(View.GONE);
        final Button btnWolves = (Button) findViewById(R.id.btnWolves);
        btnWolves.setVisibility(View.GONE);

        final ImageView imgCorrectArsenal = (ImageView) findViewById(R.id.imgCorrectArsenal);
        imgCorrectArsenal.setImageDrawable(null);
        final ImageView imgCorrectManunited = (ImageView) findViewById(R.id.imgCorrectManunited);
        imgCorrectManunited.setImageDrawable(null);
        final ImageView imgCorrectBurnley = (ImageView) findViewById(R.id.imgCorrectBurnley);
        imgCorrectBurnley.setImageDrawable(null);
        final ImageView imgCorrectAstonvilla = (ImageView) findViewById(R.id.imgCorrectAstonvilla);
        imgCorrectAstonvilla.setImageDrawable(null);
        final ImageView imgCorrectEverton = (ImageView) findViewById(R.id.imgCorrectEverton);
        imgCorrectEverton.setImageDrawable(null);
        final ImageView imgCorrectWatford = (ImageView) findViewById(R.id.imgCorrectWatford);
        imgCorrectWatford.setImageDrawable(null);
        final ImageView imgCorrectLiverpool = (ImageView) findViewById(R.id.imgCorrectLiverpool);
        imgCorrectLiverpool.setImageDrawable(null);
        final ImageView imgCorrectMancity = (ImageView) findViewById(R.id.imgCorrectMancity);
        imgCorrectMancity.setImageDrawable(null);
        final ImageView imgCorrectBrighton = (ImageView) findViewById(R.id.imgCorrectBrighton);
        imgCorrectBrighton.setImageDrawable(null);
        final ImageView imgCorrectSouthampton = (ImageView) findViewById(R.id.imgCorrectSouthampton);
        imgCorrectSouthampton.setImageDrawable(null);
        final ImageView imgCorrectCrystalpalace = (ImageView) findViewById(R.id.imgCorrectCrystalpalace);
        imgCorrectCrystalpalace.setImageDrawable(null);
        final ImageView imgCorrectSpurs = (ImageView) findViewById(R.id.imgCorrectSpurs);
        imgCorrectSpurs.setImageDrawable(null);
        final ImageView imgCorrectWestham = (ImageView) findViewById(R.id.imgCorrectWestham);
        imgCorrectWestham.setImageDrawable(null);
        final ImageView imgCorrectLeicester = (ImageView) findViewById(R.id.imgCorrectLeicester);
        imgCorrectLeicester.setImageDrawable(null);
        final ImageView imgCorrectBournemouth = (ImageView) findViewById(R.id.imgCorrectBournemouth);
        imgCorrectBournemouth.setImageDrawable(null);
        final ImageView imgCorrectNewcastle = (ImageView) findViewById(R.id.imgCorrectNewcastle);
        imgCorrectNewcastle.setImageDrawable(null);
        final ImageView imgCorrectChelsea = (ImageView) findViewById(R.id.imgCorrectChelsea);
        imgCorrectChelsea.setImageDrawable(null);
        final ImageView imgCorrectNorwich = (ImageView) findViewById(R.id.imgCorrectNorwich);
        imgCorrectNorwich.setImageDrawable(null);
        final ImageView imgCorrectShefunited = (ImageView) findViewById(R.id.imgCorrectShefunited);
        imgCorrectShefunited.setImageDrawable(null);
        final ImageView imgCorrectWolves = (ImageView) findViewById(R.id.imgCorrectWolves);
        imgCorrectWolves.setImageDrawable(null);

        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);       //This removes the status bar from view
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_english_premier_league);

        SharedPreferences sharedPref = getSharedPreferences("RecordCorrect", Context.MODE_PRIVATE);     //This sets up a sharedpreferences file so the program can permanantly save if the user has got the answer correct

        Boolean arsenal_correct = sharedPref.getBoolean("arsenal_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_arsenal = (ImageView) findViewById(R.id.imgCorrectArsenal);

        if (arsenal_correct == true) {      //This runs if the user has got the answer correct
            correct_image_arsenal.setVisibility(View.VISIBLE);
        }else{
            correct_image_arsenal.setVisibility(View.GONE);
        }


        Boolean mancity_correct = sharedPref.getBoolean("mancity_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_mancity = (ImageView) findViewById(R.id.imgCorrectMancity);

        if (mancity_correct == true) {      //This runs if the user has got the answer correct
            correct_image_mancity.setVisibility(View.VISIBLE);
        }else{
            correct_image_mancity.setVisibility(View.GONE);
        }


        Boolean bournemouth_correct = sharedPref.getBoolean("bournemouth_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_bournemouth = (ImageView) findViewById(R.id.imgCorrectBournemouth);

        if (bournemouth_correct == true) {      //This runs if the user has got the answer correct
            correct_image_bournemouth.setVisibility(View.VISIBLE);
        }else{
            correct_image_bournemouth.setVisibility(View.GONE);
        }


        Boolean manunited_correct = sharedPref.getBoolean("manunited_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_manunited = (ImageView) findViewById(R.id.imgCorrectManunited);

        if (manunited_correct == true) {      //This runs if the user has got the answer correct
            correct_image_manunited.setVisibility(View.VISIBLE);
        }else{
            correct_image_manunited.setVisibility(View.GONE);
        }


        Boolean brighton_correct = sharedPref.getBoolean("brighton_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_brighton = (ImageView) findViewById(R.id.imgCorrectBrighton);

        if (brighton_correct == true) {      //This runs if the user has got the answer correct
            correct_image_brighton.setVisibility(View.VISIBLE);
        }else{
            correct_image_brighton.setVisibility(View.GONE);
        }


        Boolean newcastle_correct = sharedPref.getBoolean("newcastle_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_newcastle = (ImageView) findViewById(R.id.imgCorrectNewcastle);

        if (newcastle_correct == true) {      //This runs if the user has got the answer correct
            correct_image_newcastle.setVisibility(View.VISIBLE);
        }else{
            correct_image_newcastle.setVisibility(View.GONE);
        }


        Boolean burnley_correct = sharedPref.getBoolean("burnley_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_burnley = (ImageView) findViewById(R.id.imgCorrectBurnley);

        if (burnley_correct == true) {      //This runs if the user has got the answer correct
            correct_image_burnley.setVisibility(View.VISIBLE);
        }else{
            correct_image_burnley.setVisibility(View.GONE);
        }


        Boolean southampton_correct = sharedPref.getBoolean("southampton_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_southampton = (ImageView) findViewById(R.id.imgCorrectSouthampton);

        if (southampton_correct == true) {      //This runs if the user has got the answer correct
            correct_image_southampton.setVisibility(View.VISIBLE);
        }else{
            correct_image_southampton.setVisibility(View.GONE);
        }


        Boolean chelsea_correct = sharedPref.getBoolean("chelsea_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_chelsea = (ImageView) findViewById(R.id.imgCorrectChelsea);

        if (chelsea_correct == true) {      //This runs if the user has got the answer correct
            correct_image_chelsea.setVisibility(View.VISIBLE);
        }else{
            correct_image_chelsea.setVisibility(View.GONE);
        }


        Boolean astonvilla_correct = sharedPref.getBoolean("astonvilla_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_astonvilla = (ImageView) findViewById(R.id.imgCorrectAstonvilla);

        if (astonvilla_correct == true) {      //This runs if the user has got the answer correct
            correct_image_astonvilla.setVisibility(View.VISIBLE);
        }else{
            correct_image_astonvilla.setVisibility(View.GONE);
        }


        Boolean crystalpalace_correct = sharedPref.getBoolean("crystalpalace_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_crystalpalace = (ImageView) findViewById(R.id.imgCorrectCrystalpalace);

        if (crystalpalace_correct == true) {      //This runs if the user has got the answer correct
            correct_image_crystalpalace.setVisibility(View.VISIBLE);
        }else{
            correct_image_crystalpalace.setVisibility(View.GONE);
        }


        Boolean norwich_correct = sharedPref.getBoolean("norwich_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_norwich = (ImageView) findViewById(R.id.imgCorrectNorwich);

        if (norwich_correct == true) {      //This runs if the user has got the answer correct
            correct_image_norwich.setVisibility(View.VISIBLE);
        }else{
            correct_image_norwich.setVisibility(View.GONE);
        }


        Boolean everton_correct = sharedPref.getBoolean("everton_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_everton = (ImageView) findViewById(R.id.imgCorrectEverton);

        if (everton_correct == true) {      //This runs if the user has got the answer correct
            correct_image_everton.setVisibility(View.VISIBLE);
        }else{
            correct_image_everton.setVisibility(View.GONE);
        }


        Boolean spurs_correct = sharedPref.getBoolean("spurs_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_spurs = (ImageView) findViewById(R.id.imgCorrectSpurs);

        if (spurs_correct == true) {      //This runs if the user has got the answer correct
            correct_image_spurs.setVisibility(View.VISIBLE);
        }else{
            correct_image_spurs.setVisibility(View.GONE);
        }


        Boolean shefunited_correct = sharedPref.getBoolean("shefunited_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_shefunited = (ImageView) findViewById(R.id.imgCorrectShefunited);

        if (shefunited_correct == true) {      //This runs if the user has got the answer correct
            correct_image_shefunited.setVisibility(View.VISIBLE);
        }else{
            correct_image_shefunited.setVisibility(View.GONE);
        }


        Boolean watford_correct = sharedPref.getBoolean("watford_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_watford = (ImageView) findViewById(R.id.imgCorrectWatford);

        if (watford_correct == true) {      //This runs if the user has got the answer correct
            correct_image_watford.setVisibility(View.VISIBLE);
        }else{
            correct_image_watford.setVisibility(View.GONE);
        }


        Boolean westham_correct = sharedPref.getBoolean("westham_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_westham = (ImageView) findViewById(R.id.imgCorrectWestham);

        if (westham_correct == true) {      //This runs if the user has got the answer correct
            correct_image_westham.setVisibility(View.VISIBLE);
        }else{
            correct_image_westham.setVisibility(View.GONE);
        }


        Boolean wolves_correct = sharedPref.getBoolean("wolves_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_wolves = (ImageView) findViewById(R.id.imgCorrectWolves);

        if (wolves_correct == true) {      //This runs if the user has got the answer correct
            correct_image_wolves.setVisibility(View.VISIBLE);
        }else{
            correct_image_wolves.setVisibility(View.GONE);
        }


        Boolean liverpool_correct = sharedPref.getBoolean("liverpool_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_liverpool = (ImageView) findViewById(R.id.imgCorrectLiverpool);

        if (liverpool_correct == true) {      //This runs if the user has got the answer correct
            correct_image_liverpool.setVisibility(View.VISIBLE);
        }else{
            correct_image_liverpool.setVisibility(View.GONE);
        }


        Boolean leicester_correct = sharedPref.getBoolean("leicester_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_leicester = (ImageView) findViewById(R.id.imgCorrectLeicester);

        if (leicester_correct == true) {      //This runs if the user has got the answer correct
            correct_image_leicester.setVisibility(View.VISIBLE);
        }else{
            correct_image_leicester.setVisibility(View.GONE);
        }



        final Button advanceToArsenalBadge = (Button) findViewById(R.id.btnArsenal);
        advanceToArsenalBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                advanceToArsenalBadge.setEnabled(false);
                Intent intent = new Intent(english_premier_league.this, arsenal_badge.class);
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToBournemouthBadge = (Button) findViewById(R.id.btnBournemouth);
        advanceToBournemouthBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_premier_league.this, bournemouth_badge.class);
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToBrightonBadge = (Button) findViewById(R.id.btnBrighton);
        advanceToBrightonBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_premier_league.this, brighton_badge.class);
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToBurnleyBadge = (Button) findViewById(R.id.btnBurnley);
        advanceToBurnleyBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_premier_league.this, burnley_badge.class);
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToChelseaBadge = (Button) findViewById(R.id.btnChelsea);
        advanceToChelseaBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_premier_league.this, chelsea_badge.class);
                startActivity(intent);
                finish();;
            }
        });

        final Button advanceToCrystalpalaceBadge = (Button) findViewById(R.id.btnCrystalpalace);
        advanceToCrystalpalaceBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_premier_league.this, crystalpalace_badge.class);
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToEvertonBadge = (Button) findViewById(R.id.btnEverton);
        advanceToEvertonBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_premier_league.this, everton_badge.class);
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToShefunitedBadge = (Button) findViewById(R.id.btnShefunited);
        advanceToShefunitedBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_premier_league.this, shefunited_badge.class);
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToLeicesterBadge = (Button) findViewById(R.id.btnLeicester);
        advanceToLeicesterBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_premier_league.this, leicester_badge.class);
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToLiverpoolBadge = (Button) findViewById(R.id.btnLiverpool);
        advanceToLiverpoolBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_premier_league.this, liverpool_badge.class);
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToMancityBadge = (Button) findViewById(R.id.btnMancity);
        advanceToMancityBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_premier_league.this, mancity_badge.class);
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToManunitedBadge = (Button) findViewById(R.id.btnManunited);
        advanceToManunitedBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_premier_league.this, manunited_badge.class);
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToNewcastleBadge = (Button) findViewById(R.id.btnNewcastle);
        advanceToNewcastleBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_premier_league.this, newcastle_badge.class);
                startActivity(intent);
                finish();
            }
        });

        Button advanceToSouthamptonBadge = (Button) findViewById(R.id.btnSouthampton);
        advanceToSouthamptonBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_premier_league.this, southampton_badge.class);
                startActivity(intent);
                finish();
            }
        });

        Button advanceToSpursBadge = (Button) findViewById(R.id.btnSpurs);
        advanceToSpursBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_premier_league.this, spurs_badge.class);
                startActivity(intent);
                finish();
            }
        });

        Button advanceToAstonvillaBadge = (Button) findViewById(R.id.btnAstonvilla);
        advanceToAstonvillaBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_premier_league.this, astonvilla_badge.class);
                startActivity(intent);
                finish();
            }
        });

        Button advanceToNorwichBadge = (Button) findViewById(R.id.btnNorwich);
        advanceToNorwichBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_premier_league.this, norwich_badge.class);
                startActivity(intent);
                finish();
            }
        });

        Button advanceToWatfordBadge = (Button) findViewById(R.id.btnWatford);
        advanceToWatfordBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_premier_league.this, watford_badge.class);
                startActivity(intent);
                finish();
            }
        });

        Button advanceToWolvesBadge = (Button) findViewById(R.id.btnWolves);
        advanceToWolvesBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_premier_league.this, wolves_badge.class);
                startActivity(intent);
                finish();
            }
        });

        Button advanceToWesthamBadge = (Button) findViewById(R.id.btnWestham);
        advanceToWesthamBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_premier_league.this, westham_badge.class);
                startActivity(intent);
                finish();
            }
        });

    }
}

