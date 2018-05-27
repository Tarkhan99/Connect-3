package com.example.tarkhan.connect_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean endGame=true;

    int activePlayer=0;

    int [] gameState={2,2,2,2,2,2,2,2,2};

    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;

        int num = Integer.parseInt(counter.getTag().toString());

        if (gameState[num] == 2&&endGame) {

            gameState[num]=activePlayer;

            counter.setTranslationY(-1000f);

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.x);
                activePlayer = 1;

            } else {

                counter.setImageResource(R.drawable.o1);
                activePlayer = 0;

            }
            counter.animate().translationYBy(1000f).setDuration(500);

            for (int [] winningPosition:winningPositions){

                if (gameState[winningPosition[0]]==gameState[winningPosition[1]]&&
                        gameState[winningPosition[1]]==gameState[winningPosition[2]]&&
                        gameState[winningPosition[0]] != 2){

                    String winner="O";

                    if (gameState[winningPosition[0]]==0){
                        winner="X";
                    }

                    TextView textView=findViewById(R.id.winnerMessage);

                    textView.setText(winner+" has won!");

                    LinearLayout layout=findViewById(R.id.playAgainLayout);

                    layout.setVisibility(View.VISIBLE);

                    endGame=false;

                }else{

                    boolean gameOver=true;

                    for (int counterState:gameState){
                        if (counterState==2){
                            gameOver=false;
                        }
                    }

                    if (gameOver){

                        TextView textView=findViewById(R.id.winnerMessage);

                        textView.setText("It's draw");

                        LinearLayout layout=findViewById(R.id.playAgainLayout);

                        layout.setVisibility(View.VISIBLE);


                    }
                }


            }
        }

    }

        public void playAgain(View view){

        endGame=true;

        activePlayer=0;

        LinearLayout layout=findViewById(R.id.playAgainLayout);

        layout.setVisibility(View.INVISIBLE);


        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }


        ImageView imageView=findViewById(R.id.imageView);
        imageView.setImageResource(0);

        ImageView imageView1=findViewById(R.id.imageView1);
        imageView1.setImageResource(0);

        ImageView imageView2=findViewById(R.id.imageView2);
        imageView2.setImageResource(0);

        ImageView imageView3=findViewById(R.id.imageView3);
        imageView3.setImageResource(0);

        ImageView imageView4=findViewById(R.id.imageView4);
        imageView4.setImageResource(0);

        ImageView imageView5=findViewById(R.id.imageView5);
        imageView5.setImageResource(0);

        ImageView imageView6=findViewById(R.id.imageView6);
        imageView6.setImageResource(0);

        ImageView imageView7=findViewById(R.id.imageView7);
        imageView7.setImageResource(0);

        ImageView imageView8=findViewById(R.id.imageView8);
        imageView8.setImageResource(0);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
