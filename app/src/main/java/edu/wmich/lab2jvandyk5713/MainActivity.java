package edu.wmich.lab2jvandyk5713;

/*
*************************************
* Programmer: John VanDyke
* Class ID: jvandyke5713
* Lab #2: Sell Sell Sell
* CIS 2610: Business Mobile Programming
* Fall 2015
* Due date: 10/23/15
* Date completed: 10/20/15
*************************************
*The MainActivity.java is the file that processes all of the decisions that are being made to tell the user
* how much they need to pay for the fruit.  If else statements were used to display a setText or a Toast notification
* depending on the quantity of fruit the user chose.  If the user wanted to purchase less than 3 or more than 24, a Toast
* is displayed telling them that they can't purchase that quantity, and the editText and setText are cleared to prevent confusion.
* getSupportActionBar is used to display the action bar at the top of the screen and to display the application logo
* that was changed in the mipmap folder.  To do accomplish this, I created a new image asset in the mipmap folder.
*************************************
*/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    //declaring costs of each fruit
    double costPerApple = 1.00;
    double costPerOrange = 1.00;
    double costPerGrapes = 3.00;
    double costPerWatermelon = 6.00;
    int numberOfFruit;
    double appleCost;
    double orangeCost;
    double grapesCost;
    double watermelonCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar is used to display the Action Bar at the top of the screen.
        //It is also used to display the logo of the application in the top of the screen.
        //The logo was changed by creating a enw image asset in the mipmap folder
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //instantiating variables to be used by if statements so decisions can be made with the user's input
        final TextView edtTextFruit = (TextView)findViewById(R.id.edtTextFruit);
        final RadioButton radButtonApple = (RadioButton)findViewById(R.id.radButtonApple);
        final RadioButton radButtonOrange = (RadioButton)findViewById(R.id.radButtonOrange);
        final RadioButton radButtonGrapes = (RadioButton)findViewById(R.id.radButtonGrape);
        final RadioButton radButtonWatermelon = (RadioButton)findViewById(R.id.radButtonWatermelon);
        final TextView txtViewFeedback = (TextView)findViewById(R.id.txtViewFeedback);
        Button btnGetFruit = (Button) findViewById(R.id.btnGetFruit);

        //this code is for the button, that ends up processing the user input
        btnGetFruit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               //passing the text from the editText to a string, so we can use the integer to process and calculate the cost
                numberOfFruit = Integer.parseInt(edtTextFruit.getText( ).toString( ));
                //Creating a format so the cost of the fruit is in a currency format
                DecimalFormat currency = new DecimalFormat("$###,###.##");

                //this if statement processes the decision if the user decides to purchase apples
                if (radButtonApple.isChecked()) {

                    //this nested if statement decides if the number of apples the user wants to buy is between 3 and 24
                    //then displays the cost if the user wants between 3 and 24.
                    if (numberOfFruit >=3 && numberOfFruit <=24)
                   {
                       //Math to calculate the cost of apples
                       appleCost = numberOfFruit * costPerApple;
                       //setText to display the cost of the apples the user would like to purchase
                       txtViewFeedback.setText("The cost of " + numberOfFruit + " apples is " + currency.format(appleCost));
                   }
                    else
                   {
                       //Toast to tell user they can only purchase 3-24 apples
                       Toast.makeText(MainActivity.this, "Please purchase between 3 and 24 apples", Toast.LENGTH_SHORT).show();
                       //this code erases whatever the user entered into the EditText if they choose 1-2, or 24+ apples
                       edtTextFruit.setText("");
                       //If the user attempted to purchase between 3 and 24 apples, but then decided they wanted less than 3
                       //or more than 24, this code will reset the text that was set in txtViewFeedback to nothing while
                       //the toast is being displayed
                       txtViewFeedback.setText("");
                   }
                }

                //this if statement decides what to do if the user selects oranges to purchase
                if (radButtonOrange.isChecked()) {

                    //this if statement decides if the user inputted a number between 3 and 24
                    //this if statement also processes the decision for quantities between 3 and 24.
                    if (numberOfFruit >=3 && numberOfFruit <=24)
                    {
                        //math to calculates the cost of oranges
                        orangeCost = numberOfFruit * costPerOrange;

                        //setText that displays the quantity and cost of the oranges
                        txtViewFeedback.setText("The cost of " + numberOfFruit + " oranges is " + currency.format(orangeCost));
                    }

                    //the else statement handles any user input that is less than 3 or greater than 24
                    else
                    {
                        //Toast displays a notification telling the user to purchase a quantity between 3 and 24
                        Toast.makeText(MainActivity.this, "Please purchase between 3 and 24 oranges", Toast.LENGTH_SHORT).show();
                        //this code resets the editText back to the hint
                        edtTextFruit.setText("");
                        //this code resets the TextView displaying cost to nothing after the Toast is displayed
                        txtViewFeedback.setText("");
                    }
                }
                //this if statement processes the decision if the user decides to purchase grapes
                if (radButtonGrapes.isChecked()) {
                    //this if statement checks to see if the user entered in between 3 and 24, then processes the decision
                    if (numberOfFruit >=3 && numberOfFruit <=24)
                    {
                        //math to calculate the cost of grapes
                        grapesCost = numberOfFruit * costPerGrapes;
                        //this is a setText that displays the quantity and cost of the grapes
                        txtViewFeedback.setText("The cost of " + numberOfFruit + " boxes of grapes is " + currency.format(grapesCost));
                    }

                    //the else statement handles any user input that is less than 3 or greater than 24
                    else
                    {
                        //Toast displays a notification telling the user to purchase a quantity between 3 and 24
                        Toast.makeText(MainActivity.this, "Please purchase between 3 and 24 boxes grapes", Toast.LENGTH_SHORT).show();
                        //this code resets the editText back to the hint
                        edtTextFruit.setText("");
                        //this code resets the TextView displaying cost to nothing after the Toast is displayed
                        txtViewFeedback.setText("");
                    }
                }
                //this if statement processes the decision if the user decides to purchase watermelon
                if (radButtonWatermelon.isChecked()) {
                    //this if statement checks to see if the user entered in between 3 and 24 in the editText
                    if (numberOfFruit >=3 && numberOfFruit <=24)
                    {
                        //math to calcuate the cost of the watermelons
                        watermelonCost = numberOfFruit * costPerWatermelon;
                        //this setText displays the quantity and cost of the watermelon
                        txtViewFeedback.setText("The cost for " + numberOfFruit + " watermelons is " + currency.format(watermelonCost));
                    }

                    //the else statement handles any user input that is less than 3 or greater than 24
                    else
                    {
                        //Toast displays a notification telling the user to purchase a quantity between 3 and 24
                        Toast.makeText(MainActivity.this, "Please purchase between 3 and 24 watermelons", Toast.LENGTH_SHORT).show();
                        //this code resets the editText back to the hint
                        edtTextFruit.setText("");
                        //this code resets the TextView displaying cost to nothing after the Toast is displayed
                        txtViewFeedback.setText("");
                    }
                }

            }
        });

}
}