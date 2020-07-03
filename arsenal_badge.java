package dont_have_domain.football_logo_quiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class arsenal_badge extends Activity {
    public static final String PREFS_NAME = "MyPrefsFile";

    public static int answer[] = {1,18,19,5,14,1,12};       //This array contains the sequence of numbers that is required for the user to be correct
    public int word_array[] = {0,0,0,0,0,0,0};              //This array stores the users letter choices that need to be displayed
    public int letter_array[] = {0,0,0,0,0,0,0};            //This array stores the button numbers of the characters that the user selects
    public int character_option_array[] = {15,18,15,14,10,1,3,4,1,12,19,5};     //This array stores the number of the letter for each button
    public int character_option_visibility[] = {1,1,1,1,1,1,1,1,1,1,1,1};       //Stores 1 if the user option button is visible and 0 is he user button isnt visible
    public int character_ans_visibility[] = {1,1,1,1,1,1,1};                    //Stores 1 if the answer char can be remove and 0 if the answer char cant be removed
    public int dash_id_array[] = {};                       //This stores the id numbers of the dashes so that the program doesnt try to find a button that is a dash
    int letter = 0;                                         //This variable changes depending on the character letter
    int array_location = 0;                                 //This variable is used the pass the array location of the selected character through the program
    int btn_number = 1;                                     //This is used to store the number of the button that was pressed so the program knows what number to put in the letter_array
    public boolean valid = true;                            //This is used to only allow characters to be guessed when there is a space if the boolean if false then there isnt a space
    int num_chars = 12;                                     //This variables tells the program the amount characters the user can choose from
    public ArrayList<Integer>btn_answers = new ArrayList<Integer>(Arrays.asList(6,2,11,12,4,9,10));            //This variable array stores the ids of the buttons that are required to answer the badge
    public int single_buttons_removed = 0;                  //This variable stores the amount of times that the remove single button has been used
    public int remove_half_letters_count = 0;               //This variable stores the amount of times the remove half letters has been used
    public int random_letter_fill = 0;                      //This variable stores the amount of times that the random letter fill button has been used
    public Integer answer_fill_array[] = {};                //This array stores the shuffled button option numbers for the fill random letter button
    public Integer num_ID_adjust_array[] ={};               //This array stores the button ids that occur straight after a dash that have been create when generating the ids for the answer fill array
    public int button_operation = 0;                        //This is used to change the character answer buttons actions depending on the number
    public boolean coin_count_valid = false;                //This is used to tell the program if the the user has enough coins for the hit that was selected


    public void onBackPressed() {       //This tells android what to do on this activity when the back button is pressed
        clear();
    }

    @Override
    protected void onDestroy() {
        SharedPreferences sharedPref = getSharedPreferences("badgeCharInput", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        String arsenalTempWordString = "";

        for(int i = 0; i < word_array.length; i++){                                 //This converts the word_array into a string
            arsenalTempWordString = arsenalTempWordString.concat(Integer.toString(word_array[i]));

            if (i < ((word_array.length)-1)){                                       //This adds commas between the numbers in the string
                arsenalTempWordString = arsenalTempWordString.concat(",");
            }
        }
        editor.putString("arsenalCharInput", arsenalTempWordString);                //This saves the arsenalTempWordString into the sharedpreferences



        String arsenalTempChoiceString = "";
        for(int i = 0; i < letter_array.length; i++){                               //This converts the letter_array into a string
            arsenalTempChoiceString = arsenalTempChoiceString.concat(Integer.toString(letter_array[i]));

            if (i < ((letter_array.length)-1)){                                     //This adds commas between the numbers in the string
                arsenalTempChoiceString = arsenalTempChoiceString.concat(",");
            }
        }

        editor.putString("arsenalCharChoice", arsenalTempChoiceString);         //This saves the arsenalTempChoiceString



        String arsenalTempCharOptionVisString = "";

        for(int i = 0; i < character_option_visibility.length; i++){                               //This converts the letter_array into a string
            arsenalTempCharOptionVisString = arsenalTempCharOptionVisString.concat(Integer.toString(character_option_visibility[i]));

            if (i < ((character_option_visibility.length)-1)){                                     //This adds commas between the numbers in the string
                arsenalTempCharOptionVisString = arsenalTempCharOptionVisString.concat(",");
            }
        }

        editor.putString("arsenalCharOptionVis", arsenalTempCharOptionVisString);         //This saves the arsenalTempCharOptionVisString



        String arsenalTempCharAnsVisString = "";

        for(int i = 0; i < character_ans_visibility.length; i++){                               //This converts the letter_array into a string
            arsenalTempCharAnsVisString = arsenalTempCharAnsVisString.concat(Integer.toString(character_ans_visibility[i]));

            if (i < ((character_ans_visibility.length)-1)){                                     //This adds commas between the numbers in the string
                arsenalTempCharAnsVisString = arsenalTempCharAnsVisString.concat(",");
            }
        }

        editor.putString("arsenalAnsOptionVis", arsenalTempCharAnsVisString);         //This saves the arsenalTempCharAnsVisString



        String arsenalTempBtnAnswersString = "";
        for(int i = 0; i <btn_answers.size(); i++){                               //This converts the letter_array into a string
            arsenalTempBtnAnswersString = arsenalTempBtnAnswersString.concat(Integer.toString(character_option_visibility[i]));

            if (i < ((btn_answers.size())-1)){                                     //This adds commas between the numbers in the string
                arsenalTempBtnAnswersString = arsenalTempBtnAnswersString.concat(",");
            }
        }

        editor.putString("arsenalBtnAnswersStore", arsenalTempBtnAnswersString);         //This saves the arsenalTempBtnAnswersString



        editor.putString("arsenal_single_buttons_removed_store", Integer.toString(single_buttons_removed));         //Saves the number of times the single use button has been used in the long term storage
        editor.putString("arsenal_remove_half_letters_store", Integer.toString(remove_half_letters_count));         //Saves the number of times the remove half letters button has been used in the long term storage


        editor.apply();



        super.onDestroy();

        final ImageView badge_image = (ImageView) findViewById(R.id.appImgarsenal);
        badge_image.setImageDrawable(null);
        final ImageView correct_image = (ImageView) findViewById(R.id.imgCorrect);
        correct_image.setImageDrawable(null);
        final ScrollView scroll_layout = (ScrollView) findViewById(R.id.scrollLayoutArsenal);
        scroll_layout.setBackgroundResource(0);
        Button left_arrow = (Button) findViewById(R.id.btnArrowLeft);
        left_arrow.setVisibility(View.GONE);
        Button right_arrow = (Button) findViewById(R.id.btnArrowRight);
        right_arrow.setVisibility(View.GONE);
        Button remove_letter = (Button) findViewById(R.id.btnRemoveLetter);
        remove_letter.setVisibility(View.GONE);
        Button fill_random_letter = (Button) findViewById(R.id.btnFillRandomLetter);
        fill_random_letter.setVisibility(View.GONE);
        Button fill_selected_letter = (Button) findViewById(R.id.btnFillSelectedLetter);
        fill_selected_letter.setVisibility(View.GONE);
        Button remove_half_letters = (Button) findViewById(R.id.btnRemoveHalfLetters);
        remove_half_letters.setVisibility(View.GONE);
        Button solve_letters = (Button) findViewById(R.id.btnSolveLetters);
        solve_letters.setVisibility(View.GONE);

        word_array = null;
        letter_array = null;

        int n = 1;
        for (int a = 0; a < answer.length; a++) {           //This removes all the character buttons from the screen
            String btnRemove = "btn_correct" + n;
            int id = getResources().getIdentifier(btnRemove, "id", getPackageName());
            ImageView btnImage = (ImageView) findViewById(id);
            btnImage.setImageDrawable(null);
            n++;
        }

        n = 1;

        for (int a = 0; a < num_chars; a++) {           //This removes all the character buttons from the screen
            String btnRemove = "btn" + n;
            int id = getResources().getIdentifier(btnRemove, "id", getPackageName());
            Button button = (Button) findViewById(id);
            if (button != null) {
                button.setVisibility(View.GONE);
            }else{
                a--;
            }
            n++;
        }

        n = 1;

        for (int a = 0; a < answer.length; a++) {       //This removes all input boxes from the screen
            String btnRemove = "appImgBlankBox" + n;
            int id = getResources().getIdentifier(btnRemove, "id", getPackageName());
            Button button = (Button) findViewById(id);
            if (button != null){
                button.setVisibility(View.GONE);
            }else{
                a--;
            }
            n++;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);       //This removes the status bar from view
        requestWindowFeature(Window.FEATURE_NO_TITLE);                                                                      //This removes the title bar from view
        setContentView(R.layout.activity_arsenal_badge);

        check_correct();        //This checks to see if the user has got the badge correct

        SharedPreferences sharedPrefCharInput = getSharedPreferences("badgeCharInput", Context.MODE_PRIVATE);
        String temp_word_array = sharedPrefCharInput.getString("arsenalCharInput", "0,0,0,0,0,0,0");                         //This saves the saved character input into temp_word_array
        String[] temp_word_array_split = temp_word_array.split(",");                                            //This splits the string up

        for(int i = 0; i < word_array.length; i++){                                                                   //This puts the temp_word_array_split into the word_array
            word_array[i] = Integer.parseInt(temp_word_array_split[i]);
        }


        String temp_choice_array = sharedPrefCharInput.getString("arsenalCharChoice", "0,0,0,0,0,0,0");
        String[] temp_choice_array_split = temp_choice_array.split(",");


        for(int i = 0; i < letter_array.length; i++){
            letter_array[i] = Integer.parseInt(temp_choice_array_split[i]);
        }


        String temp_char_vis_array = sharedPrefCharInput.getString("arsenalCharOptionVis", "1,1,1,1,1,1,1,1,1,1,1,1");
        String[] temp_char_vis_array_split = temp_char_vis_array.split(",");


        for(int i = 0; i < character_option_visibility.length; i++){
            character_option_visibility[i] = Integer.parseInt(temp_char_vis_array_split[i]);
        }

        String temp_char_ans_vis_array = sharedPrefCharInput.getString("arsenalAnsOptionVis", "1,1,1,1,1,1,1");
        String[] temp_char_ans_vis_array_split = temp_char_ans_vis_array.split(",");


        for(int i = 0; i < character_ans_visibility.length; i++){
            character_ans_visibility[i] = Integer.parseInt(temp_char_ans_vis_array_split[i]);
        }

        int id_adjust = 0;

        for(int i = 0; i < character_ans_visibility.length; i++){               //This remove the imput boxes above the characters that have already been answered with hints
            if (character_ans_visibility[i] == 0){
                id_adjust = 0;

                for (int n = 0; n < dash_id_array.length; n++){             //Stops it from try to remove dashes
                    if ((i + 1) >= dash_id_array[n]){
                        id_adjust = (n+1);
                    }
                }

                String ResId = "appImgBlankBox" + ((i + 1) + id_adjust);
                int id = getResources().getIdentifier(ResId, "id", getPackageName());
                Button remove_single_btn = (Button) findViewById(id);
                remove_single_btn.setVisibility(View.GONE);
            }
        }

        String temp_char_btn_answers_array = sharedPrefCharInput.getString("arsenalTempBtnAnswersString", "6,2,11,12,4,9,10");
        String[] temp_char_btn_answers_array_split = temp_char_btn_answers_array.split(",");


        for(int i = 0; i < btn_answers.size(); i++){
            btn_answers.set(i, Integer.parseInt(temp_char_btn_answers_array_split[i]));
        }


        single_buttons_removed = Integer.parseInt(sharedPrefCharInput.getString("arsenal_single_buttons_removed_store", "0"));      //This saves the number of times the remove single character button has been used
        check_remove_single_letter_visibility();            //This runs the method that decides if the remove single character should appear

        remove_half_letters_count = Integer.parseInt(sharedPrefCharInput.getString("arsenal_remove_half_letters_store", "0"));      //This saves the number of times the remove remove half character button has been used

        if (remove_half_letters_count > 0){
            hide_remove_half_letters_btn();
        }


        SharedPreferences sharedPrefCorrect = getSharedPreferences("RecordCorrect", Context.MODE_PRIVATE);     //This sets up a sharedpreferences file so the program can permanantly save if the user has got the answer correct


        Boolean answered_correct = sharedPrefCorrect.getBoolean("arsenal_correct", false);         //This assigns the boolean value for the badge in the sharedpreferences to answered_correct


        for(int i = 0; i < letter_array.length; i++){                       //This removes the characters from the options that have already been chosen previously
            if(letter_array[i] != 0){
                String btnRemove = "btn" + letter_array[i];
                int id = getResources().getIdentifier(btnRemove, "id", getPackageName());
                Button button = (Button) findViewById(id);
                button.setVisibility(View.INVISIBLE);
            }
        }

        for(int i = 0; i < character_option_visibility.length; i++){                       //This removes all the option characters from view that have been removed from the options or used
            if(character_option_visibility[i] != 1){
                String btnRemove = "btn" + (i+1);
                int id = getResources().getIdentifier(btnRemove, "id", getPackageName());
                Button button = (Button) findViewById(id);
                button.setVisibility(View.INVISIBLE);
            }
        }


        read_array();
        update_coins();                 //Updates coin count





        if (answered_correct == true){      //This runs if the user has got the answer correct
            int n = 1;

            for (int a = 0; a < num_chars; a++) {           //This removes all the character buttons from the screen
                String btnRemove = "btn" + n;
                int id = getResources().getIdentifier(btnRemove, "id", getPackageName());
                Button button = (Button) findViewById(id);
                button.setVisibility(View.GONE);
                n++;
            }


            n = 1;

            for (int a = 0; a < answer.length; a++) {       //This removes all input boxes from the screen
                String btnRemove = "appImgBlankBox" + n;
                int id = getResources().getIdentifier(btnRemove, "id", getPackageName());
                Button button = (Button) findViewById(id);
                if (button != null){
                    button.setVisibility(View.GONE);
                }else{
                    a--;
                }
            }
        }else if (answered_correct != true){            //This section will run if the user hasnt got the badge correct yet
            final Button btn1 = (Button) findViewById(R.id.btn1);       //This detects if the character button has been pressed
            btn1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {               //This section will run if the button is pressed
                    check_array();
                    if (valid == true){
                        letter = 15;         //This decides the character that is displayed in the entry box
                        btn_number = 1;
                        write_array();      //This runs the method the adds the letter variable into the word_array
                        btn1.setVisibility(View.INVISIBLE);         //This makes the button invisible to the user
                        character_option_visibility[(btn_number-1)] = 0;        //This sets the loction in visibility array to zero
                    }
                }
            });

            final Button btn2 = (Button) findViewById(R.id.btn2);       //This detects if the character button has been pressed
            btn2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {               //This section will run if the button is pressed
                    check_array();
                    if (valid == true){
                        letter = 18;         //This decides the character that is displayed in the entry box
                        btn_number = 2;
                        write_array();      //This runs the method the adds the letter variable into the word_array
                        btn2.setVisibility(View.INVISIBLE);         //This makes the button invisible to the user
                        character_option_visibility[(btn_number-1)] = 0;        //This sets the loction in visibility array to zero
                    }
                }
            });

            final Button btn3 = (Button) findViewById(R.id.btn3);       //This detects if the character button has been pressed
            btn3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {               //This section will run if the button is pressed
                    check_array();
                    if (valid == true){
                        letter = 15;         //This decides the character that is displayed in the entry box
                        btn_number = 3;
                        write_array();      //This runs the method the adds the letter variable into the word_array
                        btn3.setVisibility(View.INVISIBLE);         //This makes the button invisible to the user
                        character_option_visibility[(btn_number-1)] = 0;        //This sets the loction in visibility array to zero
                    }
                }
            });

            final Button btn4 = (Button) findViewById(R.id.btn4);       //This detects if the character button has been pressed
            btn4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {               //This section will run if the button is pressed
                    check_array();
                    if (valid == true){
                        letter = 14;         //This decides the character that is displayed in the entry box
                        btn_number = 4;
                        write_array();      //This runs the method the adds the letter variable into the word_array
                        btn4.setVisibility(View.INVISIBLE);         //This makes the button invisible to the user
                        character_option_visibility[(btn_number-1)] = 0;        //This sets the loction in visibility array to zero
                    }
                }
            });

            final Button btn5 = (Button) findViewById(R.id.btn5);       //This detects if the character button has been pressed
            btn5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {               //This section will run if the button is pressed
                    check_array();
                    if (valid == true){
                        letter = 10;         //This decides the character that is displayed in the entry box
                        btn_number = 5;
                        write_array();      //This runs the method the adds the letter variable into the word_array
                        btn5.setVisibility(View.INVISIBLE);         //This makes the button invisible to the user
                        character_option_visibility[(btn_number-1)] = 0;        //This sets the loction in visibility array to zero
                    }
                }
            });

            final Button btn6 = (Button) findViewById(R.id.btn6);       //This detects if the character button has been pressed
            btn6.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {               //This section will run if the button is pressed
                    check_array();
                    if (valid == true){
                        letter = 1;         //This decides the character that is displayed in the entry box
                        btn_number = 6;
                        write_array();      //This runs the method the adds the letter variable into the word_array
                        btn6.setVisibility(View.INVISIBLE);         //This makes the button invisible to the user
                        character_option_visibility[(btn_number-1)] = 0;        //This sets the loction in visibility array to zero
                    }
                }
            });

            final Button btn7 = (Button) findViewById(R.id.btn7);       //This detects if the character button has been pressed
            btn7.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {               //This section will run if the button is pressed
                    check_array();
                    if (valid == true){
                        letter = 3;         //This decides the character that is displayed in the entry box
                        btn_number = 7;
                        write_array();      //This runs the method the adds the letter variable into the word_array
                        btn7.setVisibility(View.INVISIBLE);         //This makes the button invisible to the user
                        character_option_visibility[(btn_number-1)] = 0;        //This sets the loction in visibility array to zero
                    }
                }
            });

            final Button btn8 = (Button) findViewById(R.id.btn8);       //This detects if the character button has been pressed
            btn8.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {               //This section will run if the button is pressed
                    check_array();
                    if (valid == true){
                        letter = 4;         //This decides the character that is displayed in the entry box
                        btn_number = 8;
                        write_array();      //This runs the method the adds the letter variable into the word_array
                        btn8.setVisibility(View.INVISIBLE);         //This makes the button invisible to the user
                        character_option_visibility[(btn_number-1)] = 0;        //This sets the loction in visibility array to zero
                    }
                }
            });

            final Button btn9 = (Button) findViewById(R.id.btn9);       //This detects if the character button has been pressed
            btn9.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {               //This section will run if the button is pressed
                    check_array();
                    if (valid == true){
                        letter = 1;         //This decides the character that is displayed in the entry box
                        btn_number = 9;
                        write_array();      //This runs the method the adds the letter variable into the word_array
                        btn9.setVisibility(View.INVISIBLE);         //This makes the button invisible to the user
                        character_option_visibility[(btn_number-1)] = 0;        //This sets the loction in visibility array to zero
                    }
                }
            });

            final Button btn10 = (Button) findViewById(R.id.btn10);       //This detects if the character button has been pressed
            btn10.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {               //This section will run if the button is pressed
                    check_array();
                    if (valid == true){
                        letter = 12;         //This decides the character that is displayed in the entry box
                        btn_number = 10;
                        write_array();      //This runs the method the adds the letter variable into the word_array
                        btn10.setVisibility(View.INVISIBLE);         //This makes the button invisible to the user
                        character_option_visibility[(btn_number-1)] = 0;        //This sets the loction in visibility array to zero
                    }
                }
            });

            final Button btn11 = (Button) findViewById(R.id.btn11);       //This detects if the character button has been pressed
            btn11.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {               //This section will run if the button is pressed
                    check_array();
                    if (valid == true){
                        letter = 19;         //This decides the character that is displayed in the entry box
                        btn_number = 11;
                        write_array();      //This runs the method the adds the letter variable into the word_array
                        btn11.setVisibility(View.INVISIBLE);         //This makes the button invisible to the user
                        character_option_visibility[(btn_number-1)] = 0;        //This sets the loction in visibility array to zero
                    }
                }
            });

            final Button btn12 = (Button) findViewById(R.id.btn12);       //This detects if the character button has been pressed
            btn12.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {               //This section will run if the button is pressed
                    check_array();
                    if (valid == true){
                        letter = 5;         //This decides the character that is displayed in the entry box
                        btn_number = 12;
                        write_array();      //This runs the method the adds the letter variable into the word_array
                        btn12.setVisibility(View.INVISIBLE);         //This makes the button invisible to the user
                        character_option_visibility[(btn_number-1)] = 0;        //This sets the loction in visibility array to zero
                    }
                }
            });



            final Button btnImg1 = (Button) findViewById(R.id.appImgBlankBox1);     //This detects if the input box is pressed
            btnImg1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {            //This will run if the input box is pressed
                    if(button_operation == 0) {
                        array_location = 0;         //This variable tells the program the loction of the button number in the letter_array so it know what button should become visible
                        show_letter();          //This runs the method that makes the character re-appear in the users character options
                    }else if(button_operation == 1){
                        int btnNumID = 0;
                        int btnNumIDAdjust = 0;             //This variable is used to account for dashes when reading from arrays
                        select_fill_character(btnNumID, btnNumIDAdjust);
                    }
                }
            });
            final Button btnImg2 = (Button) findViewById(R.id.appImgBlankBox2);     //This detects if the input box is pressed
            btnImg2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {            //This will run if the input box is pressed
                    if(button_operation == 0) {
                        array_location = 1;         //This variable tells the program the loction of the button number in the letter_array so it know what button should become visible
                        show_letter();          //This runs the method that makes the character re-appear in the users character options
                    }else if(button_operation == 1){
                        int btnNumID = 1;
                        int btnNumIDAdjust = 0;             //This variable is used to account for dashes when reading from arrays
                        select_fill_character(btnNumID, btnNumIDAdjust);
                    }
                }
            });
            final Button btnImg3 = (Button) findViewById(R.id.appImgBlankBox3);     //This detects if the input box is pressed
            btnImg3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {            //This will run if the input box is pressed
                    if(button_operation == 0) {
                        array_location = 2;         //This variable tells the program the loction of the button number in the letter_array so it know what button should become visible
                        show_letter();          //This runs the method that makes the character re-appear in the users character options
                    }else if(button_operation == 1){
                        int btnNumID = 2;
                        int btnNumIDAdjust = 0;             //This variable is used to account for dashes when reading from arrays
                        select_fill_character(btnNumID, btnNumIDAdjust);
                    }
                }
            });
            final Button btnImg4 = (Button) findViewById(R.id.appImgBlankBox4);     //This detects if the input box is pressed
            btnImg4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {            //This will run if the input box is pressed
                    if(button_operation == 0) {
                        array_location = 3;         //This variable tells the program the loction of the button number in the letter_array so it know what button should become visible
                        show_letter();          //This runs the method that makes the character re-appear in the users character options
                    }else if(button_operation == 1){
                        int btnNumID = 3;
                        int btnNumIDAdjust = 0;             //This variable is used to account for dashes when reading from arrays
                        select_fill_character(btnNumID, btnNumIDAdjust);
                    }
                }
            });
            final Button btnImg5 = (Button) findViewById(R.id.appImgBlankBox5);     //This detects if the input box is pressed
            btnImg5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {            //This will run if the input box is pressed
                    if(button_operation == 0) {
                        array_location = 4;         //This variable tells the program the loction of the button number in the letter_array so it know what button should become visible
                        show_letter();          //This runs the method that makes the character re-appear in the users character options
                    }else if(button_operation == 1){
                        int btnNumID = 4;
                        int btnNumIDAdjust = 0;             //This variable is used to account for dashes when reading from arrays
                        select_fill_character(btnNumID, btnNumIDAdjust);
                    }
                }
            });
            final Button btnImg6 = (Button) findViewById(R.id.appImgBlankBox6);     //This detects if the input box is pressed
            btnImg6.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {            //This will run if the input box is pressed
                    if(button_operation == 0) {
                        array_location = 5;         //This variable tells the program the loction of the button number in the letter_array so it know what button should become visible
                        show_letter();          //This runs the method that makes the character re-appear in the users character options
                    }else if(button_operation == 1){
                        int btnNumID = 5;
                        int btnNumIDAdjust = 0;             //This variable is used to account for dashes when reading from arrays
                        select_fill_character(btnNumID, btnNumIDAdjust);
                    }
                }
            });
            final Button btnImg7 = (Button) findViewById(R.id.appImgBlankBox7);     //This detects if the input box is pressed
            btnImg7.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {            //This will run if the input box is pressed
                    if(button_operation == 0) {
                        array_location = 6;         //This variable tells the program the loction of the button number in the letter_array so it know what button should become visible
                        show_letter();          //This runs the method that makes the character re-appear in the users character options
                    }else if(button_operation == 1){
                        int btnNumID = 6;
                        int btnNumIDAdjust = 0;             //This variable is used to account for dashes when reading from arrays
                        select_fill_character(btnNumID, btnNumIDAdjust);
                    }
                }
            });
        }

        final Button btnArrowRight = (Button) findViewById(R.id.btnArrowRight);         //This detects if the right arrow is pressed
        btnArrowRight.setOnClickListener(new View.OnClickListener() {       //This will run if the right arrow is pressed
            public void onClick(View view) {
                btnArrowRight.setEnabled(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnArrowRight.setEnabled(true);
                        Intent intent = new Intent(arsenal_badge.this, mancity_badge.class);        //This changes the activity
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        finish();
                    }
                },18);          //Delays the change of the activity by 20millisconds to try to allow android to clean up the memory
            }
        });

        final Button btnArrowLeft = (Button) findViewById(R.id.btnArrowLeft);           //This detects if the left arrow is pressed
        btnArrowLeft.setOnClickListener(new View.OnClickListener() {        //This will run if the left arrow id pressed
            public void onClick(View view) {
                btnArrowLeft.setEnabled(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(arsenal_badge.this, english_premier_league.class);       //This changes the activity
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        finish();
                    }
                },18);          //Delays the change of the activity by 20millisconds to try to allow android to clean up the memory
            }
        });

        final Button remove_single_letter = (Button) findViewById(R.id.btnRemoveLetter);
        remove_single_letter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(arsenal_badge.this);         //This will display the dialog for the remove letter button
                View mView = getLayoutInflater().inflate(R.layout.remove_letter_dialog, null);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                Button dialogCancel = (Button) mView.findViewById(R.id.btnCancel);              //This will run if the cancel button is clicked in the dialog box
                dialogCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.hide();              //THis hides the dialog box
                    }
                });

                Button dialogUse = (Button) mView.findViewById(R.id.btnUse);                    //This will run if the use button is clicked in the dialog box
                dialogUse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.hide();              //This hides the dialog box

                        int coinCost = 2;

                        change_coins(coinCost);

                        if (coin_count_valid == true) {                                          //This will run if the user has enough coins
                            remove_single_letter();     //This runs the method that removes a random letter
                            read_array();               //This displays the users character input
                            update_coins();
                        }else if (coin_count_valid == false){
                            pay_coins(coinCost);            //This creates the alert box that should appear if the user doesnt have enoguh coins
                        }
                    }
                });
            }
        });

        final Button fill_random_letter = (Button) findViewById(R.id.btnFillRandomLetter);
        fill_random_letter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(arsenal_badge.this);         //This will display the dialog for the remove letter button
                View mView = getLayoutInflater().inflate(R.layout.fill_random_letter_dialog, null);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                Button dialogCancel = (Button) mView.findViewById(R.id.btnCancel);              //This will run if the cancel button is clicked in the dialog box
                dialogCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.hide();              //THis hides the dialog box
                    }
                });

                Button dialogUse = (Button) mView.findViewById(R.id.btnUse);                    //This will run if the use button is clicked in the dialog box
                dialogUse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.hide();              //This hides the dialog box

                        int coinCost = 4;

                        change_coins(coinCost);

                        if (coin_count_valid == true) {                                          //This will run if the user has enough coins
                            fill_random_letter();     //This runs the method that removes a random letter
                            read_array();               //This displays the users character input
                            update_coins();
                        }else if (coin_count_valid == false){
                            pay_coins(coinCost);            //This creates the alert box that should appear if the user doesnt have enoguh coins
                        }
                    }
                });
            }
        });

        final Button fill_selected_letter = (Button) findViewById(R.id.btnFillSelectedLetter);
        fill_selected_letter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(arsenal_badge.this);         //This will display the dialog for the remove letter button
                View mView = getLayoutInflater().inflate(R.layout.fill_selected_letter_dialog, null);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                Button dialogCancel = (Button) mView.findViewById(R.id.btnCancel);              //This will run if the cancel button is clicked in the dialog box
                dialogCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.hide();              //THis hides the dialog box
                    }
                });

                Button dialogUse = (Button) mView.findViewById(R.id.btnUse);                    //This will run if the user button is clicked in the dialog box
                dialogUse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.hide();              //This hides the dialog box

                        int coinCost = 6;

                        change_coins(coinCost);

                        if (coin_count_valid == true) {                                          //This will run if the user has enough coins
                            for(int i = 0; i < num_chars; i++){             //This will make all the user option characters invisible
                                if(character_option_visibility[i] == 1){
                                    String ResId = "btn" + (i+1);
                                    int id = getResources().getIdentifier(ResId, "id", getPackageName());
                                    Button select_hide_chars = (Button) findViewById(id);
                                    select_hide_chars.setVisibility(View.INVISIBLE);
                                }

                                String ResIdRemoveLetter = "btnRemoveLetter";                                       //This makes the remove letter button appear
                                int idRemoveLetter = getResources().getIdentifier(ResIdRemoveLetter, "id", getPackageName());
                                Button select_hide_remove_letter = (Button) findViewById(idRemoveLetter);
                                select_hide_remove_letter.setVisibility(View.INVISIBLE);

                                String ResIdFillRandomLetter = "btnFillRandomLetter";                                       //This makes the random letter button appear
                                int idFillRandomLetter = getResources().getIdentifier(ResIdFillRandomLetter, "id", getPackageName());
                                Button select_fill_random_letter = (Button) findViewById(idFillRandomLetter);
                                select_fill_random_letter.setVisibility(View.INVISIBLE);

                                String ResIdFillSelectedLetter= "btnFillSelectedLetter";                                       //This makes the selected letter button appear
                                int idFillSelectedLetter = getResources().getIdentifier(ResIdFillSelectedLetter, "id", getPackageName());
                                Button select_fill_selected_letter = (Button) findViewById(idFillSelectedLetter);
                                select_fill_selected_letter.setVisibility(View.INVISIBLE);

                                String ResIdRemoveHalfLetters= "btnRemoveHalfLetters";                                     //This makes the remove half letters button appear
                                int idRemoveHalfLetters = getResources().getIdentifier(ResIdRemoveHalfLetters, "id", getPackageName());
                                Button select_remove_half_letters = (Button) findViewById(idRemoveHalfLetters);
                                select_remove_half_letters.setVisibility(View.INVISIBLE);

                                String ResIdSolveLetters= "btnSolveLetters";                                            //This makes the solve letters button appear
                                int idSolveLetters = getResources().getIdentifier(ResIdSolveLetters, "id", getPackageName());
                                Button select_solve_letters = (Button) findViewById(idSolveLetters);
                                select_solve_letters.setVisibility(View.INVISIBLE);
                            }

                            button_operation = 1;
                            read_array();                   //This displays the users character input
                            update_coins();
                        }else if (coin_count_valid == false){
                            pay_coins(coinCost);            //This creates the alert box that should appear if the user doesnt have enough coins
                        }
                    }
                });
            }
        });

        final Button remove_half_letters = (Button) findViewById(R.id.btnRemoveHalfLetters);
        remove_half_letters.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(arsenal_badge.this);         //This will display the dialog for the remove letter button
                View mView = getLayoutInflater().inflate(R.layout.remove_half_letters_dialog, null);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                Button dialogCancel = (Button) mView.findViewById(R.id.btnCancel);              //This will run if the cancel button is clicked in the dialog box
                dialogCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.hide();              //THis hides the dialog box
                    }
                });

                Button dialogUse = (Button) mView.findViewById(R.id.btnUse);                    //This will run if the user button is clicked in the dialog box
                dialogUse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.hide();              //This hides the dialog box

                        int coinCost = 5;

                        change_coins(coinCost);

                        if (coin_count_valid == true) {                                          //This will run if the user has enough coins
                            double repeat_num = (((character_option_array.length)-(answer.length))-single_buttons_removed);          //Finds out home many incorrect letters are in the letter options
                            repeat_num = Math.ceil(repeat_num/2);                                           //Halfs the number of incorrect letters rounds up

                            for(int i = 0; i < repeat_num; i++){            //This loop removes half of the incorrect letters from the users options
                                remove_single_letter();
                            }

                            remove_half_letters_count = 1;                  //This records the number of times the remove half letters button has been pressed

                            final Button btnHalfLetters = (Button) findViewById(R.id.btnRemoveHalfLetters);
                            btnHalfLetters.setVisibility(View.GONE);                        //Removes the remove half button from the screen
                            read_array();
                            update_coins();
                        }else if (coin_count_valid == false){
                            pay_coins(coinCost);            //This creates the alert box that should appear if the user doesnt have enough coins
                        }
                    }
                });
            }
        });

        final Button solve_letters = (Button) findViewById(R.id.btnSolveLetters);
        solve_letters.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(arsenal_badge.this);         //This will display the dialog for the remove letter button
                View mView = getLayoutInflater().inflate(R.layout.solve_letters_dialog, null);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                Button dialogCancel = (Button) mView.findViewById(R.id.btnCancel);              //This will run if the cancel button is clicked in the dialog box
                dialogCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.hide();              //THis hides the dialog box
                    }
                });

                Button dialogUse = (Button) mView.findViewById(R.id.btnUse);                    //This will run if the user button is clicked in the dialog box
                dialogUse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.hide();              //This hides the dialog box

                        int coinCost = 10;

                        change_coins(coinCost);

                        if (coin_count_valid == true) {                                          //This will run if the user has enough coins
                            word_array = answer;            //Sets the users answer to the correct answer
                            check_correct();                //Runs the method that checks if the answer is correct
                            update_coins();
                        }else if (coin_count_valid == false){
                            pay_coins(coinCost);            //This creates the alert box that should appear if the user doesnt have enoguh coins
                        }
                    }
                });
            }
        });
    }

    public void button_buzz(){      //This adds the user character input into the word_array
        SharedPreferences sharedPref = getSharedPreferences("RecordCorrect", Context.MODE_PRIVATE);


        final Boolean sound_button_setting = sharedPref.getBoolean("sound_button_setting", false);         //This assigns the boolean value for the vibration settings to vibration_setting

        if (sound_button_setting == false) {
            final MediaPlayer click_sound = MediaPlayer.create(this, R.raw.click_sound);
            click_sound.start();
        }

        final Boolean button_vibration_setting = sharedPref.getBoolean("button_vibration_setting", false);         //This assigns the boolean value for the vibration settings to vibration_setting

        if (button_vibration_setting == false) {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(18);         //Vibrate for 200milliseconds
        }
    }

    public void clear(){       //This method changes the activity to the english_premier_league menu without an animation
        Intent intent = new Intent(arsenal_badge.this, english_premier_league.class);        //This changes the activity
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        overridePendingTransition(0,0);
        finish();
    }

    public void reappear_chars_select_letter(){
        for(int i = 0; i < num_chars; i++){
            if(character_option_visibility[i] == 1){
                String ResId = "btn" + (i+1);
                int id = getResources().getIdentifier(ResId, "id", getPackageName());
                Button select_hide_chars = (Button) findViewById(id);
                select_hide_chars.setVisibility(View.VISIBLE);
            }
        }

        String ResIdRemoveLetter = "btnRemoveLetter";                                       //This makes the remove letter button re-appear
        int idRemoveLetter = getResources().getIdentifier(ResIdRemoveLetter, "id", getPackageName());
        Button select_hide_remove_letter = (Button) findViewById(idRemoveLetter);
        select_hide_remove_letter.setVisibility(View.VISIBLE);

        String ResIdFillRandomLetter = "btnFillRandomLetter";                               //This makes the random letter button re-appear
        int idFillRandomLetter = getResources().getIdentifier(ResIdFillRandomLetter, "id", getPackageName());
        Button select_fill_random_letter = (Button) findViewById(idFillRandomLetter);
        select_fill_random_letter.setVisibility(View.VISIBLE);

        String ResIdFillSelectedLetter= "btnFillSelectedLetter";                            //This makes the selected letter button re-appear
        int idFillSelectedLetter = getResources().getIdentifier(ResIdFillSelectedLetter, "id", getPackageName());
        Button select_fill_selected_letter = (Button) findViewById(idFillSelectedLetter);
        select_fill_selected_letter.setVisibility(View.VISIBLE);

        String ResIdRemoveHalfLetters= "btnRemoveHalfLetters";                              //This makes the remove half letters button re-appear
        int idRemoveHalfLetters = getResources().getIdentifier(ResIdRemoveHalfLetters, "id", getPackageName());
        Button select_remove_half_letters = (Button) findViewById(idRemoveHalfLetters);
        select_remove_half_letters.setVisibility(View.VISIBLE);

        String ResIdSolveLetters= "btnSolveLetters";                                        //This makes the remove solve letters button re-appear
        int idSolveLetters = getResources().getIdentifier(ResIdSolveLetters, "id", getPackageName());
        Button select_solve_letters = (Button) findViewById(idSolveLetters);
        select_solve_letters.setVisibility(View.VISIBLE);
    }

    public void remove_single_letter(){       //This method removes a single letter that isnt needed for the answer
        Integer[] btn_answers_array = new Integer[btn_answers.size()];          //This saves the variable array btn_answers to a fixed size array btn_answer_array
        btn_answers_array = btn_answers.toArray(btn_answers_array);

        boolean count = false;          //This sets up the boolean variable that is used to keep the random number generator generating a number until it generates a valid number
        int btnNumID = 1;

        do{
            Random rnd = new Random();
            btnNumID = rnd.nextInt(num_chars) + 1;

            int x = 0;
            count = true;

            for (int i = 0; i < btn_answers_array.length; i++){         //Checks that the randomly generated id isnt required for the user to be able to answer the question
                if (count != false) {
                    if (btnNumID == btn_answers_array[x]) {
                        count = false;
                    }
                    x++;
                }
            }
        }while (count != true);

        if (character_option_visibility[(btnNumID - 1)] == 1) {         //This runs if the letter is in the character options
            String ResId = "btn" + btnNumID;
            int id = getResources().getIdentifier(ResId, "id", getPackageName());
            Button remove_single_btn = (Button) findViewById(id);
            remove_single_btn.setVisibility(View.GONE);         //Removes that character from the screen
            character_option_visibility[(btnNumID - 1)] = 0;          //Updates the array so the program knows that the letter that was removed is no longer visible
        }else if (character_option_visibility[(btnNumID - 1)] == 0){            //This runs if the letter is in the answer
            count = false;

            for (int i = 0; i < (letter_array.length); i++) {               //This will run for loop for the number of characters in the answer
                if (count == false) {
                    if (letter_array[i] == btnNumID) {                  //This searches the answer for the letter
                        word_array[i] = 0;                      //This removes the letter from the word array
                        letter_array[i] = 0;                    //This removes the letter from the letter array
                        count = true;
                    }
                }
            }
        }

        single_buttons_removed = single_buttons_removed + 1;
        btn_answers.add(btnNumID);                  //Adds the character to the btn_answers array so that the program doesnt try to remove the button again

        check_remove_single_letter_visibility();
    }

    public void hide_remove_half_letters_btn(){                                 //This method hides the remove half letters button
        Button btn_remove_half_letters = (Button) findViewById(R.id.btnRemoveHalfLetters);
        btn_remove_half_letters.setVisibility(View.GONE);
    }

    public void check_remove_single_letter_visibility(){
        if (single_buttons_removed > ((num_chars - (answer.length))-1)){                //Detects when all the incorrect letters have been removed
            Button btn_remove_single_letter = (Button) findViewById(R.id.btnRemoveLetter);
            btn_remove_single_letter.setVisibility(View.GONE);

            hide_remove_half_letters_btn();
        }
    }

    public void hide_fill_random_letter_btn(){                                  //This method hides the fill random letters button
        Button btn_fill_random_letter = (Button) findViewById(R.id.btnFillRandomLetter);
        btn_fill_random_letter.setVisibility(View.GONE);
    }

    public void fill_random_letter() {       //This method fills a random correct letter in the answer
        int x = 0;
        ArrayList<Integer> tempBtnNumIDAdjust = new ArrayList<Integer>();
        ArrayList<Integer> variable_answer_fill = new ArrayList<Integer>();

        if (random_letter_fill == 0) {              //This sets up the answer_fill_array with the button ids in a random order
            x = 0;

            for (int i = 0; i < answer.length; i++) {       //This adds a button number for the amount of buttons that there is in a random order
                Random rnd = new Random();
                int num = rnd.nextInt(10);

                boolean count = true;

                do {
                    count = false;

                    for (int n = 0; n < dash_id_array.length; n++) {            //Checks if x is in the dash array
                        if (dash_id_array[n] == (x+1)) {
                            count = true;
                        }
                    }

                    if (count == true){
                        x++;            //Adds 1 to x if it was in the dash array to stop x been entered as a blank button id
                        tempBtnNumIDAdjust.add(x);
                    }
                }while (count == true);



                if (num > 5) {          //If true it adds number to start of the array
                    variable_answer_fill.add(0, x);
                } else if (num < 6) {       //If True adds number to end of array
                    variable_answer_fill.add(x);
                }
                x++;
            }

            Integer[] z = new Integer[tempBtnNumIDAdjust.size()];          //This saves the variable array tempBtnNumIDAdjusr to a fixed size array num_ID_adjust_array
            z = tempBtnNumIDAdjust.toArray(z);
            num_ID_adjust_array = z;      //Seves the array to another array so that the scope of the variable is the whole method

            Integer[] n = new Integer[variable_answer_fill.size()];          //This saves the variable array variable_answer_fill to a fixed size array answer_fill_array
            n = variable_answer_fill.toArray(n);
            answer_fill_array = n;      //Seves the array to another array so that the scope of the variable is the whole method
        }

        boolean count = true;
        int array_pos_adjust = 0;

        int btnNumID = 0;
        int btnNumIDAdjust = 0;

        do {
            btnNumID = answer_fill_array[(random_letter_fill + array_pos_adjust)];       //Gets the button id from the array

            for (int i = 0; i < num_ID_adjust_array.length; i++) {            //This adjusts the btnNumIDAdjust variable to account for the number of dashes that have been before the character
                if (btnNumID >= num_ID_adjust_array[i]) {
                    btnNumIDAdjust++;
                }
            }


            String RemoveId = "appImgBlankBox" + (btnNumID + 1);
            int ID = getResources().getIdentifier(RemoveId, "id", getPackageName());
            Button btn_option_remove = (Button) findViewById(ID);


            if (btn_option_remove.getVisibility() != View.VISIBLE) {
                count = true;
                array_pos_adjust++;
            } else {
                count = false;
                btn_option_remove.setVisibility(View.GONE);
            }
        }while (count == true);

        btnNumIDAdjust = 0;

        for (int i = 0; i < num_ID_adjust_array.length; i++) {            //This adjusts the btnNumIDAdjust variable to account for the number of dashes that have been before the character
            if (btnNumID >= num_ID_adjust_array[i]) {
                btnNumIDAdjust++;
            }
        }

        manager_characters(btnNumID, btnNumIDAdjust);

        word_array[(btnNumID - btnNumIDAdjust)] = answer[(btnNumID - btnNumIDAdjust)];
        random_letter_fill = random_letter_fill+ 1;

        if (random_letter_fill > ((word_array.length) - 1)) {
            hide_fill_random_letter_btn();

            int n = 1;

            for (int a = 0; a < num_chars; a++) {           //This removes all the character buttons from the screen
                String btnRemove = "btn" + n;
                int id = getResources().getIdentifier(btnRemove, "id", getPackageName());
                Button button = (Button) findViewById(id);
                button.setVisibility(View.GONE);
                n++;
            }
        }
    }

    public void select_fill_character(int btnNumID, int btnNumIDAdjust){
        String RemoveId = "appImgBlankBox" + (btnNumID + 1);
        int ID = getResources().getIdentifier(RemoveId, "id", getPackageName());
        Button btn_option_remove = (Button) findViewById(ID);
        btn_option_remove.setVisibility(View.GONE);

        manager_characters(btnNumID, btnNumIDAdjust);

        word_array[(btnNumID - btnNumIDAdjust)] = answer[(btnNumID - btnNumIDAdjust)];

        reappear_chars_select_letter();
        button_operation = 0;
        check_correct();
    }

    public void manager_characters(int btnNumID, int btnNumIDAdjust){
        int x = 0;
        boolean fill_random_count = false;

        if (word_array[(btnNumID - btnNumIDAdjust)] != answer[(btnNumID - btnNumIDAdjust)]){          //Checks if the box that has been selected in the word array is the correct letter
            if(word_array[(btnNumID - btnNumIDAdjust)] != 0) {                 //Checks if the box in the word array isnt blank
                String CharId = "btn" + letter_array[btnNumID];                 //Makes the button that was remove from the answer re appear in the options
                int Charid = getResources().getIdentifier(CharId, "id", getPackageName());
                Button char_btn = (Button) findViewById(Charid);
                char_btn.setVisibility(View.VISIBLE);
                character_option_visibility[(letter_array[btnNumID]-1)] = 1;
            }

            for (int i = 0; i < num_chars; i++) {               //This checks to see if the correct letter is in the character options
                if (character_option_array[x] == answer[(btnNumID - btnNumIDAdjust)]) {          //Checks if the letter in the character option is the correct letter
                    if (character_option_visibility[x] == 1) {          //Checks if the character is visible to the user
                        if (fill_random_count != true) {
                            String ResId = "btn" + (x + 1);                 //Removes that letter that has been put in the answer from the options
                            int id = getResources().getIdentifier(ResId, "id", getPackageName());
                            Button option_char = (Button) findViewById(id);
                            option_char.setVisibility(View.INVISIBLE);
                            character_option_visibility[x] = 0;
                            fill_random_count = true;

                            character_ans_visibility[(btnNumID - btnNumIDAdjust)] = 0;
                        }
                    } else if (character_option_visibility[x] == 0) {
                        x++;
                    }
                } else if (character_option_array[x] != answer[(btnNumID - btnNumIDAdjust)]) {
                    x++;
                }
            }

            x = 0;

            if (fill_random_count != true) {            //This is run if the letter wasnt found in the user options
                for (int i = 0; i < word_array.length; i++) {
                    if (fill_random_count != true) {
                        if (word_array[x] == answer[(btnNumID - btnNumIDAdjust)]) {
                            word_array[x] = 0;              //Sets the location where the correct letter was so that the box is blank
                            letter_array[x] = 0;            //Removes the button id from the letter array

                            fill_random_count = true;
                        } else if (word_array[x] != answer[(btnNumID - btnNumIDAdjust)]) {
                            x++;
                        }
                    }
                }
                read_array();
            }
        }
    }


    public void show_letter(){
        word_array[array_location] = 0;         //This removes the character from the word_array

        if (letter_array[array_location] != 0) {        //This makes the input character that was pressed re-appear in the users options
            String btnImgId = "btn" + letter_array[array_location];
            int id = getResources().getIdentifier(btnImgId, "id", getPackageName());
            Button button = (Button) findViewById(id);
            button.setVisibility(View.VISIBLE);
            character_option_visibility[(letter_array[array_location]-1)] = 1;
            letter_array[array_location] = 0;
        }
        read_array();           //This runs the method that displays the word_array
    }
    public void check_array(){      //This method detects if there is a space in the user input characters
        valid =  false;
        for (int a = 0; a < answer.length; a++){
            if (word_array[a] == 0){
                valid = true;       //This been valid means there is a space in the input characters
            }
        }
    }

    public void clear_activity_memory(){
        final ImageView badge_image = (ImageView) findViewById(R.id.appImgarsenal);
        badge_image.setImageDrawable(null);
        final ImageView correctText = (ImageView) findViewById(R.id.imgCorrect);
        correctText.setImageDrawable(null);

        int n = 1;

        for (int a = 0; a < answer.length; a++) {           //This removes all the character buttons from the screen
            String btnRemove = "btn_correct" + n;
            int id = getResources().getIdentifier(btnRemove, "id", getPackageName());
            ImageView btnImage = (ImageView) findViewById(id);
            btnImage.setImageDrawable(null);
            n++;
        }

        n = 1;

        for (int a = 0; a < num_chars; a++) {           //This removes all the character buttons from the screen
            String btnRemove = "btn" + n;
            int id = getResources().getIdentifier(btnRemove, "id", getPackageName());
            Button button = (Button) findViewById(id);
            button.setVisibility(View.GONE);
            n++;
        }

        n = 1;

        for (int a = 0; a < answer.length; a++) {       //This removes all input boxes from the screen
            String btnRemove = "appImgBlankBox" + n;
            int id = getResources().getIdentifier(btnRemove, "id", getPackageName());
            Button button = (Button) findViewById(id);
            button.setVisibility(View.GONE);
            n++;
        }
    }

    public void correct_remove_buttons(){       //This method makes any characters that the user hasnt selected invisible when the user get the badge correct
        int n =1;
        for (int a = 0; a < num_chars; a++){        //This makes it run the code run for the amount of characters that the user can choose from
            boolean count = false;
            int x = 0;

            for (int z = 0; z < letter_array.length; z++){          //This detects if the user has already chosen the character
                if (letter_array[x] == n){      //This means the user has already selected the character so its already invisible
                    count = true;
                }else if (letter_array[x] != n){        //This means the user hasnt selected the character so its visible to the user currently
                    x++;
                }
            }

            if (count == false){        //This makes any characters that are visible to the user invisible
                String btnRemove = "btn" + n;
                int id = getResources().getIdentifier(btnRemove, "id", getPackageName());
                Button button = (Button) findViewById(id);
                button.setVisibility(View.INVISIBLE);
            }
            n++;
        }
    }

    public void pay_coins(int coinCost){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(arsenal_badge.this);         //This will display the dialog for the remove letter button
        View mView = getLayoutInflater().inflate(R.layout.not_enough_coins_dialog, null);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        Button btnCloseDialog = (Button) mView.findViewById(R.id.btnCloseDialog);              //This will run if the cancel button is clicked in the dialog box
        btnCloseDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.hide();              //THis hides the dialog box
            }
        });

        Button btnMoreCoins = (Button) mView.findViewById(R.id.btnMoreCoins);              //This will run if the cancel button is clicked in the dialog box
        btnMoreCoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.hide();              //THis hides the dialog box

                Intent intent = new Intent(arsenal_badge.this, more_coins_page.class);       //This changes the activity
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
            }
        });
    }

    public void change_coins(int coinCost){
        SharedPreferences sharedPref = getSharedPreferences("RecordCorrect", Context.MODE_PRIVATE);     //This sets up a sharedpreferences file so the program can read from sharedpreferences

        int current_coins = sharedPref.getInt("coin_count", 0);         //This reads the number of coins from the coin_count variable and assigns it to coin_count_number

        if (current_coins >= coinCost){
            current_coins = (current_coins - coinCost);

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("coin_count", current_coins);                //Sets the coin count
            editor.apply();

            coin_count_valid = true;
        } else{
            coin_count_valid = false;
        }
    }

    public void update_coins(){             //This method reads the number of coins from the sharedpreferences and displays it
        SharedPreferences sharedPref = getSharedPreferences("RecordCorrect", Context.MODE_PRIVATE);     //This sets up a sharedpreferences file so the program can read from sharedpreferences

        final int coin_count_number = sharedPref.getInt("coin_count", 0);         //This reads the number of coins from the coin_count variable and assigns it to coin_count_number

        final TextView coinCountNum = (TextView) findViewById(R.id.coinCountText);              //This changes the number of coins text to the number in the coin_count sharedpreferences
        coinCountNum.setText(Integer.toString(coin_count_number));
    }

    public void check_correct(){        //This method checks to see if the user has got the badge correct
        SharedPreferences sharedPref = getSharedPreferences("RecordCorrect", Context.MODE_PRIVATE);

        if(Arrays.equals(word_array, answer)){      //This section will run if the user inputs the correct answer
            SharedPreferences.Editor editor = sharedPref.edit();

            Boolean badge_correct = sharedPref.getBoolean("arsenal_correct", false);                         //This saves the saves arsenal_correct to the badge_correct boolean

            if (badge_correct == false) {
                int leagueBadgesCorrect = sharedPref.getInt("epl_correct_count", 0);         //This reads the number of correct league badges and saves it to the eplBadgesCorrect variable

                leagueBadgesCorrect++;
                editor.putInt("epl_correct_count", leagueBadgesCorrect);                //Sets the number of correct epl Badges

                final Boolean vibration_setting = sharedPref.getBoolean("vibration_setting", false);         //This assigns the boolean value for the vibration settings to vibration_setting

                if (vibration_setting == false) {
                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(500);         //Vibrate for half a second
                }

                final Boolean sound_correct_settings = sharedPref.getBoolean("sound_correct_settings", false);         //This assigns the boolean value for the sound correct setting to sound_correct_settings


                if (sound_correct_settings == false) {                final MediaPlayer correct_sound = MediaPlayer.create(this, R.raw.correct_sound);
                    correct_sound.start();
                }
            }

            editor.putBoolean("arsenal_correct", true);     //This saves the true in arsenal_correct
            editor.apply();

            int n = 1;

            for (int a = 0; a < answer.length; a++) {       //This removes the input buttons that display the characters as the user no longer needs them as they have got the badge correct
                String btnRemove = "appImgBlankBox" + n;
                int id = getResources().getIdentifier(btnRemove, "id", getPackageName());
                Button button = (Button) findViewById(id);
                if (button != null){
                    button.setVisibility(View.GONE);
                }else{
                    a--;
                }
                n++;
            }
            final View imgCorrect = (View) findViewById(R.id.imgCorrect);       //This makes the correct image visible
            imgCorrect.setVisibility(View.VISIBLE);
            correct_remove_buttons();

            final Button btnRemoveLetter = (Button) findViewById(R.id.btnRemoveLetter);
            btnRemoveLetter.setVisibility(View.GONE);
            final Button btnFillRandomLetter = (Button) findViewById(R.id.btnFillRandomLetter);
            btnFillRandomLetter.setVisibility(View.GONE);
            final Button btnFillSelectedLetter = (Button) findViewById(R.id.btnFillSelectedLetter);
            btnFillSelectedLetter.setVisibility(View.GONE);
            final Button btnHalfLetters = (Button) findViewById(R.id.btnRemoveHalfLetters);
            btnHalfLetters.setVisibility(View.GONE);
            final Button btnSolveLetters = (Button) findViewById(R.id.btnSolveLetters);
            btnSolveLetters.setVisibility(View.GONE);
        }else{      //This section will run if the user input isnt correct
            final View imgCorrect = (View) findViewById(R.id.imgCorrect);       //This makes the correct image invisible
            imgCorrect.setVisibility(View.INVISIBLE);
        }
    }

    public void write_array(){      //This adds the user character input into the word_array
        int n = 0;
        boolean count = false;

        for (int a = 0; a < answer.length; a++){        //This section finds the first empty loction in the word_array and then adds the character into it
            while (count == false) {
                if (word_array[n] == 0) {
                    word_array[n] = letter;
                    letter_array[n] = btn_number;
                    count = true;
                }
                if (n < answer.length){
                    n++;
                }
            }
        }
        read_array();       //This runs the method that displays the users character inputs
    }

    public void read_array() {      //This method interprits the numbers in the word_array to display the users character inputs
        button_buzz();          //Make button presses vibrate


        int num = 1;
        int x = 0;
        for (int a = 0; a < answer.length; a++) {
            String ResId = "appImgBlankBox"+ num++;
            int id = getResources().getIdentifier(ResId, "id", getPackageName());
            Button button = (Button) findViewById(id);

            if (button != null) {
                if (word_array[x] == 0) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_blank_choice);
                } else if (word_array[x] == 1) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_a_choice);
                } else if (word_array[x] == 2) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_b_choice);
                } else if (word_array[x] == 3) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_c_choice);
                } else if (word_array[x] == 4) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_d_choice);
                } else if (word_array[x] == 5) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_e_choice);
                } else if (word_array[x] == 6) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_f_choice);
                } else if (word_array[x] == 7) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_g_choice);
                } else if (word_array[x] == 8) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_h_choice);
                } else if (word_array[x] == 9) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_i_choice);
                } else if (word_array[x] == 10) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_j_choice);
                } else if (word_array[x] == 11) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_k_choice);
                } else if (word_array[x] == 12) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_l_choice);
                } else if (word_array[x] == 13) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_m_choice);
                } else if (word_array[x] == 14) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_n_choice);
                } else if (word_array[x] == 15) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_o_choice);
                } else if (word_array[x] == 16) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_p_choice);
                } else if (word_array[x] == 17) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_q_choice);
                } else if (word_array[x] == 18) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_r_choice);
                } else if (word_array[x] == 19) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_s_choice);
                } else if (word_array[x] == 20) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_t_choice);
                } else if (word_array[x] == 21) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_u_choice);
                } else if (word_array[x] == 22) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_v_choice);
                } else if (word_array[x] == 23) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_w_choice);
                } else if (word_array[x] == 24) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_x_choice);
                } else if (word_array[x] == 25) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_y_choice);
                } else if (word_array[x] == 26) {
                    button.setBackgroundResource(R.drawable.custom_button_normal_z_choice);
                }
            }else{
                x--;                    //Reduces x by 1 to make up for a dash
                a--;                    //Reduces a by 1 to make up for a dash
            }
            x++;
        }
        check_correct();
    }
}
