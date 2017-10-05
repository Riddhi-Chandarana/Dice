package com.example.riddhi.dice;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;
import java.util.Random;

import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {


    public int useroveallscore;
    public int userturn;
    public int computeroverallscore;
    public int computerturn;
    public int number;
    Random random = new Random();
    Button roll;
    Button hold;
     TextView user;
    TextView txt;
    ImageView imageView;
    TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(TextView)findViewById(R.id.printu);
        String st="It's user turn!!";
        user.setText(st);

        txt1 = (TextView) findViewById(R.id.computer);
        imageView = (ImageView) findViewById(R.id.imageView);
        txt = (TextView) findViewById(R.id.userscore);
        if (useroveallscore <= 100 ) {

            if(computeroverallscore>100){
                roll.setEnabled(false);
                hold.setEnabled(false);
            }

                roll = (Button) findViewById(R.id.roll);
                roll.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        number = random.nextInt(6) + 1;
                        if (number == 1) {
                            userturn = 0;

                        } else
                            userturn += number;
                   /* String string = " " + userturn;
                    txt.setText(string);*/
                        if (number == 2)
                            imageView.setImageResource(R.drawable.dice2);
                        else if (number == 1) {
                            roll.setEnabled(false);
                            computer();
                            imageView.setImageResource(R.drawable.dice1);
                        } else if (number == 3)
                            imageView.setImageResource(R.drawable.dice3);
                        else if (number == 4)
                            imageView.setImageResource(R.drawable.dice4);
                        else if (number == 5)
                            imageView.setImageResource(R.drawable.dice5);
                        else if (number == 6)
                            imageView.setImageResource(R.drawable.dice6);

                    }

                });

                 hold = (Button) findViewById(R.id.hold);
                hold.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        useroveallscore += userturn;
                        userturn = 0;
                        String string = " " + useroveallscore;
                        txt.setText(string);
                        computer();
                    }
                });

                Button reset = (Button) findViewById(R.id.reset);
                reset.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        useroveallscore = 0;
                        computeroverallscore = 0;
                        String st="It's user turn!!";
                        user.setText(st);
                        String string = "" + useroveallscore;
                        String string1 = "" + computeroverallscore;
                        txt.setText(string);
                        txt1.setText(string1);
                        roll.setEnabled(true);
                        hold.setEnabled(true);
                    }
                });
            }

        if(useroveallscore>100){
            roll.setEnabled(false);
            hold.setEnabled(false);
        Toast.makeText(MainActivity.this,"you win!!",Toast.LENGTH_LONG).show();}
    }

    void computer() {
        String st="It's computer turn!!";
        user.setText(st);
        txt1 = (TextView) findViewById(R.id.computer);
        imageView = (ImageView) findViewById(R.id.imageView);
        roll.setEnabled(false);
        hold.setEnabled(false);

        if (computeroverallscore <= 100) {

            number = random.nextInt(6) + 1;
            if (number == 1) {
                computerturn = 0;
                roll.setEnabled(true);
                hold.setEnabled(true);
            }
            else {
                    if (number == 2) {
                        imageView.setImageResource(R.drawable.dice2);
                        computerturn += number;

                    } else if (number == 1) {
                        roll.setEnabled(true);
                        hold.setEnabled(true);
                        imageView.setImageResource(R.drawable.dice1);
                    } else if (number == 3) {
                        computerturn += number;
                        imageView.setImageResource(R.drawable.dice3);
                    } else if (number == 4) {
                        computerturn += number;
                        imageView.setImageResource(R.drawable.dice4);
                    } else if (number == 5) {
                        computerturn += number;
                        imageView.setImageResource(R.drawable.dice5);
                    } else if (number == 6) {
                        computerturn += number;
                        imageView.setImageResource(R.drawable.dice6);
                    }
                }

        }


        if(computeroverallscore>100) {
            roll.setEnabled(false);
            hold.setEnabled(false);
           // Toast.makeText(MainActivity.this, "Computer wins!!", Toast.LENGTH_LONG).show();
        }
        else {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (computerturn < 10)
                        computer();
                    else{
                        String st="It's user turn!!";
                        user.setText(st);
                        computeroverallscore += computerturn;
                        if(computeroverallscore>100){
                        roll.setEnabled(false);
                        hold.setEnabled(false);
                            String string = " " + computeroverallscore;
                            txt1.setText(string);
                            st = "Game over";
                            user.setText(st);
                        Toast.makeText(MainActivity.this, "Computer wins!!", Toast.LENGTH_LONG).show();
                        }
                        else {
                            computerturn = 0;
                            String string = " " + computeroverallscore;
                            txt1.setText(string);
                            roll.setEnabled(true);
                            hold.setEnabled(true);
                        }
                    }

                }
            }, 1000);
        }

  }

}


     /*   Button hold = (Button) findViewById(R.id.hold);
        hold.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                turnuser = false;
                turncomputer = true;
            }
        });




        Button reset=(Button)findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               useroveallscore=0;
                computeroverallscore=0;
            }
        });
    }

        void userturn(int number)
        {

            while(turnuser==true){
               if (number == 1) {
                   userturn=0;
                   turnuser = false;
                   turncomputer = true;
                    }

                else{
                   userturn += number;
                   }
            }
            useroveallscore+=userturn;
        }
    }
*/