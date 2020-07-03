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
import android.widget.ImageView;

public class english_champ_league extends Activity {

    public void onBackPressed() {       //This tells android what to do on this activity when the back button is pressed
        Intent intent = new Intent(english_champ_league.this, league_menu.class);
        startActivity(intent);
        finish();
    }

    protected void onDestroy() {
        final Button btnBarnsley = (Button) findViewById(R.id.btnBarnsley);
        btnBarnsley.setVisibility(View.GONE);
        final Button btnShefwednesday = (Button) findViewById(R.id.btnShefwednesday);
        btnShefwednesday.setVisibility(View.GONE);
        final Button btnHull = (Button) findViewById(R.id.btnHull);
        btnHull.setVisibility(View.GONE);
        final Button btnCharlton = (Button) findViewById(R.id.btnCharlton);
        btnCharlton.setVisibility(View.GONE);
        final Button btnBlackburn = (Button) findViewById(R.id.btnBlackburn);
        btnBlackburn.setVisibility(View.GONE);
        final Button btnWigan = (Button) findViewById(R.id.btnWigan);
        btnWigan.setVisibility(View.GONE);
        final Button btnPreston = (Button) findViewById(R.id.btnPreston);
        btnPreston.setVisibility(View.GONE);
        final Button btnLuton = (Button) findViewById(R.id.btnLuton);
        btnLuton.setVisibility(View.GONE);
        final Button btnFullham = (Button) findViewById(R.id.btnFullham);
        btnFullham.setVisibility(View.GONE);
        final Button btnWestbrom = (Button) findViewById(R.id.btnWestbrom);
        btnWestbrom.setVisibility(View.GONE);
        final Button btnReading = (Button) findViewById(R.id.btnReading);
        btnReading.setVisibility(View.GONE);
        final Button btnHuddersfield = (Button) findViewById(R.id.btnHuddersfield);
        btnHuddersfield.setVisibility(View.GONE);
        final Button btnCardiff = (Button) findViewById(R.id.btnCardiff);
        btnCardiff.setVisibility(View.GONE);
        final Button btnBirmingham = (Button) findViewById(R.id.btnBirmingham);
        btnBirmingham.setVisibility(View.GONE);
        final Button btnNottsforest = (Button) findViewById(R.id.btnNottsforest);
        btnNottsforest.setVisibility(View.GONE);
        final Button btnLeeds = (Button) findViewById(R.id.btnLeeds);
        btnLeeds.setVisibility(View.GONE);
        final Button btnDerby = (Button) findViewById(R.id.btnDerby);
        btnDerby.setVisibility(View.GONE);
        final Button btnSwansea = (Button) findViewById(R.id.btnSwansea);
        btnSwansea.setVisibility(View.GONE);
        final Button btnQpr = (Button) findViewById(R.id.btnQpr);
        btnQpr.setVisibility(View.GONE);
        final Button btnMiddlesbrough = (Button) findViewById(R.id.btnMiddlesbrough);
        btnMiddlesbrough.setVisibility(View.GONE);
        final Button btnBristol = (Button) findViewById(R.id.btnBristol);
        btnBristol.setVisibility(View.GONE);
        final Button btnMillwall = (Button) findViewById(R.id.btnMillwall);
        btnMillwall.setVisibility(View.GONE);
        final Button btnStoke = (Button) findViewById(R.id.btnStoke);
        btnStoke.setVisibility(View.GONE);
        final Button btnBrentford = (Button) findViewById(R.id.btnBrentford);
        btnBrentford.setVisibility(View.GONE);

        final ImageView imgCorrectBarnsley = (ImageView) findViewById(R.id.imgCorrectBarnsley);
        imgCorrectBarnsley.setImageDrawable(null);
        final ImageView imgCorrectShefwednesday = (ImageView) findViewById(R.id.imgCorrectShefwednesday);
        imgCorrectShefwednesday.setImageDrawable(null);
        final ImageView imgCorrectHull = (ImageView) findViewById(R.id.imgCorrectHull);
        imgCorrectHull.setImageDrawable(null);
        final ImageView imgCorrectCharlton = (ImageView) findViewById(R.id.imgCorrectCharlton);
        imgCorrectCharlton.setImageDrawable(null);
        final ImageView imgCorrectBlackburn = (ImageView) findViewById(R.id.imgCorrectBlackburn);
        imgCorrectBlackburn.setImageDrawable(null);
        final ImageView imgCorrectPreston = (ImageView) findViewById(R.id.imgCorrectPreston);
        imgCorrectPreston.setImageDrawable(null);
        final ImageView imgCorrectLuton = (ImageView) findViewById(R.id.imgCorrectLuton);
        imgCorrectLuton.setImageDrawable(null);
        final ImageView imgCorrectFullham = (ImageView) findViewById(R.id.imgCorrectFullham);
        imgCorrectFullham.setImageDrawable(null);
        final ImageView imgCorrectWestbrom = (ImageView) findViewById(R.id.imgCorrectWestbrom);
        imgCorrectWestbrom.setImageDrawable(null);
        final ImageView imgCorrectReading = (ImageView) findViewById(R.id.imgCorrectReading);
        imgCorrectReading.setImageDrawable(null);
        final ImageView imgCorrectHuddersfield = (ImageView) findViewById(R.id.imgCorrectHuddersfield);
        imgCorrectHuddersfield.setImageDrawable(null);
        final ImageView imgCorrectCardiff = (ImageView) findViewById(R.id.imgCorrectCardiff);
        imgCorrectCardiff.setImageDrawable(null);
        final ImageView imgCorrectBirmingham = (ImageView) findViewById(R.id.imgCorrectBirmingham);
        imgCorrectBirmingham.setImageDrawable(null);
        final ImageView imgCorrectNottsforest = (ImageView) findViewById(R.id.imgCorrectNottsforest);
        imgCorrectNottsforest.setImageDrawable(null);
        final ImageView imgCorrectLeeds = (ImageView) findViewById(R.id.imgCorrectLeeds);
        imgCorrectLeeds.setImageDrawable(null);
        final ImageView imgCorrectDerby = (ImageView) findViewById(R.id.imgCorrectDerby);
        imgCorrectDerby.setImageDrawable(null);
        final ImageView imgCorrectSwansea = (ImageView) findViewById(R.id.imgCorrectSwansea);
        imgCorrectSwansea.setImageDrawable(null);
        final ImageView imgCorrectQpr = (ImageView) findViewById(R.id.imgCorrectQpr);
        imgCorrectQpr.setImageDrawable(null);
        final ImageView imgCorrectMiddlesbrough = (ImageView) findViewById(R.id.imgCorrectMiddlesbrough);
        imgCorrectMiddlesbrough.setImageDrawable(null);
        final ImageView imgCorrectBristol = (ImageView) findViewById(R.id.imgCorrectBristol);
        imgCorrectBristol.setImageDrawable(null);
        final ImageView imgCorrectMillwall = (ImageView) findViewById(R.id.imgCorrectMillwall);
        imgCorrectMillwall.setImageDrawable(null);
        final ImageView imgCorrectStoke = (ImageView) findViewById(R.id.imgCorrectStoke);
        imgCorrectStoke.setImageDrawable(null);
        final ImageView imgCorrectBrentford = (ImageView) findViewById(R.id.imgCorrectBrentford);
        imgCorrectBrentford.setImageDrawable(null);

        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);       //This removes the status bar from view
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_english_champ_league);

        SharedPreferences sharedPref = getSharedPreferences("RecordCorrect", Context.MODE_PRIVATE);     //This sets up a sharedpreferences file so the program can permanantly save if the user has got the answer correct

        Boolean barnsley_correct = sharedPref.getBoolean("barnsley_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_barnsley = (ImageView) findViewById(R.id.imgCorrectBarnsley);

        if (barnsley_correct == true) {      //This runs if the user has got the answer correct
            correct_image_barnsley.setVisibility(View.VISIBLE);
        }else{
            correct_image_barnsley.setVisibility(View.GONE);
        }


        Boolean shefwednesday_correct = sharedPref.getBoolean("shefwednesday_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_shefwednesday = (ImageView) findViewById(R.id.imgCorrectShefwednesday);

        if (shefwednesday_correct == true) {      //This runs if the user has got the answer correct
            correct_image_shefwednesday.setVisibility(View.VISIBLE);
        }else{
            correct_image_shefwednesday.setVisibility(View.GONE);
        }


        Boolean hull_correct = sharedPref.getBoolean("hull_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_hull = (ImageView) findViewById(R.id.imgCorrectHull);

        if (hull_correct == true) {      //This runs if the user has got the answer correct
            correct_image_hull.setVisibility(View.VISIBLE);
        }else{
            correct_image_hull.setVisibility(View.GONE);
        }


        Boolean charlton_correct = sharedPref.getBoolean("charlton_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_charlton = (ImageView) findViewById(R.id.imgCorrectCharlton);

        if (charlton_correct == true) {      //This runs if the user has got the answer correct
            correct_image_charlton.setVisibility(View.VISIBLE);
        }else{
            correct_image_charlton.setVisibility(View.GONE);
        }


        Boolean blackburn_correct = sharedPref.getBoolean("blackburn_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_blackburn = (ImageView) findViewById(R.id.imgCorrectBlackburn);

        if (blackburn_correct == true) {      //This runs if the user has got the answer correct
            correct_image_blackburn.setVisibility(View.VISIBLE);
        }else{
            correct_image_blackburn.setVisibility(View.GONE);
        }


        Boolean preston_correct = sharedPref.getBoolean("preston_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_preston = (ImageView) findViewById(R.id.imgCorrectPreston);

        if (preston_correct == true) {      //This runs if the user has got the answer correct
            correct_image_preston.setVisibility(View.VISIBLE);
        }else{
            correct_image_preston.setVisibility(View.GONE);
        }


        Boolean luton_correct = sharedPref.getBoolean("luton_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_luton = (ImageView) findViewById(R.id.imgCorrectLuton);

        if (luton_correct == true) {      //This runs if the user has got the answer correct
            correct_image_luton.setVisibility(View.VISIBLE);
        }else{
            correct_image_luton.setVisibility(View.GONE);
        }


        Boolean fullham_correct = sharedPref.getBoolean("fullham_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_fullham = (ImageView) findViewById(R.id.imgCorrectFullham);

        if (fullham_correct == true) {      //This runs if the user has got the answer correct
            correct_image_fullham.setVisibility(View.VISIBLE);
        }else{
            correct_image_fullham.setVisibility(View.GONE);
        }


        Boolean westbrom_correct = sharedPref.getBoolean("westbrom_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_westbrom = (ImageView) findViewById(R.id.imgCorrectWestbrom);

        if (westbrom_correct == true) {      //This runs if the user has got the answer correct
            correct_image_westbrom.setVisibility(View.VISIBLE);
        }else{
            correct_image_westbrom.setVisibility(View.GONE);
        }


        Boolean reading_correct = sharedPref.getBoolean("reading_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_reading = (ImageView) findViewById(R.id.imgCorrectReading);

        if (reading_correct == true) {      //This runs if the user has got the answer correct
            correct_image_reading.setVisibility(View.VISIBLE);
        }else{
            correct_image_reading.setVisibility(View.GONE);
        }


        Boolean huddersfield_correct = sharedPref.getBoolean("huddersfield_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_huddersfield = (ImageView) findViewById(R.id.imgCorrectHuddersfield);

        if (huddersfield_correct == true) {      //This runs if the user has got the answer correct
            correct_image_huddersfield.setVisibility(View.VISIBLE);
        }else{
            correct_image_huddersfield.setVisibility(View.GONE);
        }


        Boolean cardiff_correct = sharedPref.getBoolean("cardiff_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_cardiff = (ImageView) findViewById(R.id.imgCorrectCardiff);

        if (cardiff_correct == true) {      //This runs if the user has got the answer correct
            correct_image_cardiff.setVisibility(View.VISIBLE);
        }else{
            correct_image_cardiff.setVisibility(View.GONE);
        }


        Boolean birmingham_correct = sharedPref.getBoolean("birmingham_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_birmingham = (ImageView) findViewById(R.id.imgCorrectBirmingham);

        if (birmingham_correct == true) {      //This runs if the user has got the answer correct
            correct_image_birmingham.setVisibility(View.VISIBLE);
        }else{
            correct_image_birmingham.setVisibility(View.GONE);
        }


        Boolean nottsforest_correct = sharedPref.getBoolean("nottsforest_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_nottsforest = (ImageView) findViewById(R.id.imgCorrectNottsforest);

        if (nottsforest_correct == true) {      //This runs if the user has got the answer correct
            correct_image_nottsforest.setVisibility(View.VISIBLE);
        }else{
            correct_image_nottsforest.setVisibility(View.GONE);
        }


        Boolean leeds_correct = sharedPref.getBoolean("leeds_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_leeds = (ImageView) findViewById(R.id.imgCorrectLeeds);

        if (leeds_correct == true) {      //This runs if the user has got the answer correct
            correct_image_leeds.setVisibility(View.VISIBLE);
        }else{
            correct_image_leeds.setVisibility(View.GONE);
        }


        Boolean derby_correct = sharedPref.getBoolean("derby_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_derby = (ImageView) findViewById(R.id.imgCorrectDerby);

        if (derby_correct == true) {      //This runs if the user has got the answer correct
            correct_image_derby.setVisibility(View.VISIBLE);
        }else{
            correct_image_derby.setVisibility(View.GONE);
        }


        Boolean swansea_correct = sharedPref.getBoolean("swansea_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_swansea = (ImageView) findViewById(R.id.imgCorrectSwansea);

        if (swansea_correct == true) {      //This runs if the user has got the answer correct
            correct_image_swansea.setVisibility(View.VISIBLE);
        }else{
            correct_image_swansea.setVisibility(View.GONE);
        }


        Boolean qpr_correct = sharedPref.getBoolean("qpr_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_qpr = (ImageView) findViewById(R.id.imgCorrectQpr);

        if (qpr_correct == true) {      //This runs if the user has got the answer correct
            correct_image_qpr.setVisibility(View.VISIBLE);
        }else{
            correct_image_qpr.setVisibility(View.GONE);
        }


        Boolean middlesbrough_correct = sharedPref.getBoolean("middlesbrough_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_middlesbrough = (ImageView) findViewById(R.id.imgCorrectMiddlesbrough);

        if (middlesbrough_correct == true) {      //This runs if the user has got the answer correct
            correct_image_middlesbrough.setVisibility(View.VISIBLE);
        }else{
            correct_image_middlesbrough.setVisibility(View.GONE);
        }


        Boolean bristol_correct = sharedPref.getBoolean("bristol_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_bristol = (ImageView) findViewById(R.id.imgCorrectBristol);

        if (bristol_correct == true) {      //This runs if the user has got the answer correct
            correct_image_bristol.setVisibility(View.VISIBLE);
        }else{
            correct_image_bristol.setVisibility(View.GONE);
        }

        Boolean millwall_correct = sharedPref.getBoolean("millwall_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_millwall = (ImageView) findViewById(R.id.imgCorrectMillwall);

        if (millwall_correct == true) {      //This runs if the user has got the answer correct
            correct_image_millwall.setVisibility(View.VISIBLE);
        }else{
            correct_image_millwall.setVisibility(View.GONE);
        }

        Boolean stoke_correct = sharedPref.getBoolean("stoke_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_stoke = (ImageView) findViewById(R.id.imgCorrectStoke);

        if (stoke_correct == true) {      //This runs if the user has got the answer correct
            correct_image_stoke.setVisibility(View.VISIBLE);
        }else{
            correct_image_stoke.setVisibility(View.GONE);
        }

        Boolean brentford_correct = sharedPref.getBoolean("brentford_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_brentford = (ImageView) findViewById(R.id.imgCorrectBrentford);

        if (brentford_correct == true) {      //This runs if the user has got the answer correct
            correct_image_brentford.setVisibility(View.VISIBLE);
        }else{
            correct_image_brentford.setVisibility(View.GONE);
        }

        Boolean wigan_correct = sharedPref.getBoolean("wigan_correct", false);         //Gets the boolean that tells the program if the user has got the badge correct
        final ImageView correct_image_wigan = (ImageView) findViewById(R.id.imgCorrectWigan);

        if (wigan_correct == true) {      //This runs if the user has got the answer correct
            correct_image_wigan.setVisibility(View.VISIBLE);
        }else{
            correct_image_wigan.setVisibility(View.GONE);
        }



        final Button advanceToBarnsleyBadge = (Button) findViewById(R.id.btnBarnsley);
        advanceToBarnsleyBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                advanceToBarnsleyBadge.setEnabled(false);
                Intent intent = new Intent(english_champ_league.this, barnsley_badge.class);
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToShefwednesdayBadge = (Button) findViewById(R.id.btnShefwednesday);
        advanceToShefwednesdayBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, shefwednesday_badge.class);
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToHullBadge = (Button) findViewById(R.id.btnHull);
        advanceToHullBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, hull_badge.class);
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToCharltonBadge = (Button) findViewById(R.id.btnCharlton);
        advanceToCharltonBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, charlton_badge.class);
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToBlackburnBadge = (Button) findViewById(R.id.btnBlackburn);
        advanceToBlackburnBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, blackburn_badge.class);
                startActivity(intent);
                finish();;
            }
        });

        final Button advanceToPrestonBadge = (Button) findViewById(R.id.btnPreston);
        advanceToPrestonBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, preston_badge.class);
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToLutonBadge = (Button) findViewById(R.id.btnLuton);
        advanceToLutonBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, luton_badge.class);
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToFullhamBadge = (Button) findViewById(R.id.btnFullham);
        advanceToFullhamBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, fullham_badge.class);
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToWestbromBadge = (Button) findViewById(R.id.btnWestbrom);
        advanceToWestbromBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, westbrom_badge.class); //Old
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToReadingBadge = (Button) findViewById(R.id.btnReading);
        advanceToReadingBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, reading_badge.class);
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToHuddersfieldBadge = (Button) findViewById(R.id.btnHuddersfield);
        advanceToHuddersfieldBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, huddersfield_badge.class); //Old
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToCardiffBadge = (Button) findViewById(R.id.btnCardiff);
        advanceToCardiffBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, cardiff_badge.class);
                startActivity(intent);
                finish();
            }
        });

        final Button advanceToBirminghamBadge = (Button) findViewById(R.id.btnBirmingham);
        advanceToBirminghamBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, birmingham_badge.class);
                startActivity(intent);
                finish();
            }
        });

        Button advanceToNottsforestBadge = (Button) findViewById(R.id.btnNottsforest);
        advanceToNottsforestBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, nottsforest_badge.class);
                startActivity(intent);
                finish();
            }
        });

        Button advanceToLeedsBadge = (Button) findViewById(R.id.btnLeeds);
        advanceToLeedsBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, leeds_badge.class);
                startActivity(intent);
                finish();
            }
        });

        Button advanceToDerbyBadge = (Button) findViewById(R.id.btnDerby);
        advanceToDerbyBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, derby_badge.class);
                startActivity(intent);
                finish();
            }
        });

        Button advanceToSwanseaBadge = (Button) findViewById(R.id.btnSwansea);
        advanceToSwanseaBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, swansea_badge.class); //Old
                startActivity(intent);
                finish();
            }
        });

        Button advanceToQprBadge = (Button) findViewById(R.id.btnQpr);
        advanceToQprBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, qpr_badge.class);
                startActivity(intent);
                finish();
            }
        });

        Button advanceToMiddlesbroughBadge = (Button) findViewById(R.id.btnMiddlesbrough);
        advanceToMiddlesbroughBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, middlesbrough_badge.class);
                startActivity(intent);
                finish();
            }
        });

        Button advanceToBristolBadge = (Button) findViewById(R.id.btnBristol);
        advanceToBristolBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, bristol_badge.class);
                startActivity(intent);
                finish();
            }
        });

        Button advanceToMillwallBadge = (Button) findViewById(R.id.btnMillwall);
        advanceToMillwallBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, millwall_badge.class);
                startActivity(intent);
                finish();
            }
        });

        Button advanceToStokeBadge = (Button) findViewById(R.id.btnStoke);
        advanceToStokeBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, stoke_badge.class); //Old
                startActivity(intent);
                finish();
            }
        });

        Button advanceToBrentfordBadge = (Button) findViewById(R.id.btnBrentford);
        advanceToBrentfordBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, brentford_badge.class);
                startActivity(intent);
                finish();
            }
        });

        Button advanceToWiganBadge = (Button) findViewById(R.id.btnWigan);
        advanceToWiganBadge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(english_champ_league.this, wigan_badge.class);
                startActivity(intent);
                finish();
            }
        });

    }
}

