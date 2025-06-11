package com.example.calculatorapptest20250611;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private long calculation=0;
    private long firstOperand=0;
    private char calmode='?';
    private boolean newStart=true;
    private boolean newCal=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        TextView result=findViewById(R.id.result);
        Button button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculation*=10;
                calculation+=1;
                if(newStart){
                    calculation=1;
                    newStart=false;
                }
                result.setText(String.valueOf(calculation));
            }
        });
        Button button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculation*=10;
                calculation+=2;
                if(newStart){
                    calculation=2;
                    newStart=false;
                }
                result.setText(String.valueOf(calculation));
            }
        });
        Button button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculation*=10;
                calculation+=3;
                if(newStart){
                    calculation=3;
                    newStart=false;
                }
                result.setText(String.valueOf(calculation));
            }
        });
        Button buttonAdd=findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(newCal){
                    if(calmode=='+'){
                        calculation=firstOperand+calculation;
                        firstOperand=calculation;
                        newStart=true;
                        //}
                        result.setText(String.valueOf(calculation));
                        newCal=false;
                    }else{
                        calmode='+';
                        firstOperand=calculation;
                        newStart=true;
                    }


                }else{
                    calculation=firstOperand+calculation;
                    firstOperand=calculation;
                    newStart=true;
                    //}
                    result.setText(String.valueOf(calculation));
                }

            }
        });
        Button buttonMultiply=findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(newCal){
                    if(calmode=='*'){
                        calculation=firstOperand*calculation;
                        firstOperand=calculation;
                        newStart=true;
                        //}
                        result.setText(String.valueOf(calculation));
                        newCal=false;
                    }else{
                        calmode='*';
                        firstOperand=calculation;
                        newStart=true;
                    }


                }else{
                    calculation=firstOperand*calculation;
                    firstOperand=calculation;
                    newStart=true;
                    //}
                    result.setText(String.valueOf(calculation));
                }


            }
        });
        Button buttonEqual=findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(calmode=='+'){
                    calculation=firstOperand+calculation;
                    firstOperand=calculation;
                    newStart=true;
                    newCal=true;
                }else if(calmode=='*'){
                    calculation=firstOperand*calculation;
                    firstOperand=calculation;
                    newStart=true;
                    newCal=true;
                }
                calmode='=';
                result.setText(String.valueOf(calculation));
            }

        });

    }

}