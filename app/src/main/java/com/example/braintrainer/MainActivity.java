package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button goButton;int n1,n2;String randomPos;
    Button option1,option2,option3,option4,playAgain;
    TextView timer,problem,score,review;
    int correct,total;
    boolean gameOver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goButton=findViewById(R.id.goButton);
        timer=findViewById(R.id.timer);
        problem=findViewById(R.id.problem);
        score=findViewById(R.id.score);
        review=findViewById(R.id.review);
        playAgain=findViewById(R.id.button5);
        option1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        option3=findViewById(R.id.option3);
        option4=findViewById(R.id.option4);
        correct=total=0;
        n1=n2=0;gameOver=false;

    }
    public void onClickGo(View view){
        goButton.setVisibility(View.GONE);
        timer.setVisibility(View.VISIBLE);
        problem.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);
        option1.setAlpha(1);
        option2.setAlpha(1);
        option3.setAlpha(1);
        option4.setAlpha(1);
        play();
    }
    public void play(){
        correct=0;total=0;
        score.setText(correct+"/"+total);
        if(review.getVisibility()==View.VISIBLE)
            review.setVisibility(View.INVISIBLE);


        if(playAgain.getVisibility()==View.VISIBLE)
            playAgain.setVisibility(View.INVISIBLE);

        Random randomNumber=new Random();
        n1=randomNumber.nextInt(100)+1;
        n2=randomNumber.nextInt(100)+1;
        problem.setText(n1+" + "+n2);
        randomPos=Integer.toString(randomNumber.nextInt(4)+1);
        if(option1.getTag().toString().equalsIgnoreCase(randomPos))
        {
            option1.setText((n1+n2)+"");option2.setText(randomNumber.nextInt(200)+2+"");option3.setText(randomNumber.nextInt(200)+2+"");option4.setText(randomNumber.nextInt(200)+2+"");
        }
        else if(option2.getTag().toString().equalsIgnoreCase(randomPos)){
            option2.setText((n1+n2)+"");option1.setText(randomNumber.nextInt(200)+2+"");option3.setText(randomNumber.nextInt(200)+2+"");option4.setText(randomNumber.nextInt(200)+2+"");
        }
        else if(option3.getTag().toString().equalsIgnoreCase(randomPos)){
            option3.setText((n1+n2)+"");option1.setText(randomNumber.nextInt(200)+2+"");option2.setText(randomNumber.nextInt(200)+2+"");option4.setText(randomNumber.nextInt(200)+2+"");
        }
        else{
            option4.setText((n1+n2)+"");option1.setText(randomNumber.nextInt(200)+2+"");option2.setText(randomNumber.nextInt(200)+2+"");option3.setText(randomNumber.nextInt(200)+2+"");
        }

        new CountDownTimer(30000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                String s;
                s =Integer.toString((int)millisUntilFinished/1000);
                s+="s";
                timer.setText(s);
            }

            @Override
            public void onFinish() {
                review.setText("Game Over.\nScore: "+(total==0?"0%":(float)correct*100/total+"%"));
                review.setVisibility(View.VISIBLE);
                playAgain.setVisibility(View.VISIBLE);
                gameOver=true;
            }
        }.start();
    }
    public void onclickAnyButton(View view){
        if(gameOver==true)
        {
            Toast.makeText(this,"Time up!!!",Toast.LENGTH_SHORT).show();
            return;
        }
        if(view.getTag().toString().equalsIgnoreCase(randomPos)){
            correct++;

            review.setText("Correct Answer");
        }
        else{
            review.setText("Wrong Answer");
        }
        review.setVisibility(View.VISIBLE);
        total++;
        score.setText(correct+"/"+total);
        if(review.getVisibility()==View.VISIBLE)
            review.setVisibility(View.INVISIBLE);


        if(playAgain.getVisibility()==View.VISIBLE)
            playAgain.setVisibility(View.INVISIBLE);

        Random randomNumber=new Random();
        n1=randomNumber.nextInt(100)+1;
        n2=randomNumber.nextInt(100)+1;
        problem.setText(n1+" + "+n2);
        randomPos=Integer.toString(randomNumber.nextInt(4)+1);
        if(option1.getTag().toString().equalsIgnoreCase(randomPos))
        {
            option1.setText((n1+n2)+"");option2.setText(randomNumber.nextInt(200)+2+"");option3.setText(randomNumber.nextInt(200)+2+"");option4.setText(randomNumber.nextInt(200)+2+"");
        }
        else if(option2.getTag().toString().equalsIgnoreCase(randomPos)){
            option2.setText((n1+n2)+"");option1.setText(randomNumber.nextInt(200)+2+"");option3.setText(randomNumber.nextInt(200)+2+"");option4.setText(randomNumber.nextInt(200)+2+"");
        }
        else if(option3.getTag().toString().equalsIgnoreCase(randomPos)){
            option3.setText((n1+n2)+"");option1.setText(randomNumber.nextInt(200)+2+"");option2.setText(randomNumber.nextInt(200)+2+"");option4.setText(randomNumber.nextInt(200)+2+"");
        }
        else{
            option4.setText((n1+n2)+"");option1.setText(randomNumber.nextInt(200)+2+"");option2.setText(randomNumber.nextInt(200)+2+"");option3.setText(randomNumber.nextInt(200)+2+"");
        }
    }
    public void onClickPlayAgain(View view){
        gameOver=false;
        play();

    }

}