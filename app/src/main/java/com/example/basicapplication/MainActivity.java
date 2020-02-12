package com.example.basicapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.provider.Settings;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.lzyzsd.randomcolor.RandomColor;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String txt_number;
    TextView tv_number;
    int randomNumber;
    int sum;
    boolean isVisible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button toast = findViewById(R.id.toast_button);
        Button increase = findViewById(R.id.increase_button);
        Button random = findViewById(R.id.random_button);
        Button decrease = findViewById(R.id.decrease_button);
        Button hideshow = findViewById(R.id.hideshow);
        Button colorRandom = findViewById(R.id.color_random_button);
        Button reset = findViewById(R.id.reset_button);
//        FloatingActionButton fab = findViewById(R.id.fab);
        tv_number =findViewById(R.id.textview_first);
        txt_number = tv_number.getText().toString();
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                reset();
            }
        });
        colorRandom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                RandomColor randomColor = new RandomColor();

                ConstraintLayout constraintLayout= findViewById(R.id.background);
                constraintLayout.setBackgroundColor(randomColor.randomColor());
            }
        });
        hideshow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                hideShow();
            }
        });
        random.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(isVisible){
                    Toast.makeText(MainActivity.this, "Data sedang di Hide", Toast.LENGTH_SHORT).show();
                }
                else
                setRandom();
            }
        });
        increase.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(isVisible){
                    Toast.makeText(MainActivity.this, "Data sedang di Hide", Toast.LENGTH_SHORT).show();
                }
                else
                setIncrease();
            }
        });
        decrease.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(isVisible){
                    Toast.makeText(MainActivity.this, "Data sedang di Hide", Toast.LENGTH_SHORT).show();
                }
                else
                setDecrease();
            }
        });
        toast.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(isVisible){
                    Toast.makeText(MainActivity.this, "Data sedang di Hide", Toast.LENGTH_SHORT).show();
                }
                else
                Toast.makeText(MainActivity.this, "number : "+txt_number, Toast.LENGTH_SHORT).show();
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    private void setRandom(){
        Random random ;
        random = new Random();
        randomNumber =  random.nextInt(100-1)+1;
        tv_number.setText(""+randomNumber);
        txt_number = String.valueOf(randomNumber);
    }
    private void setIncrease(){
        sum = Integer.parseInt(tv_number.getText().toString())+1;
        tv_number.setText(String.valueOf(sum));
        txt_number = String.valueOf(sum);
    }
    private void setDecrease(){
        sum = Integer.parseInt(tv_number.getText().toString())-1;
        tv_number.setText(String.valueOf(sum));
        txt_number = String.valueOf(sum);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent Intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(Intent);
        }

        return super.onOptionsItemSelected(item);
    }
    private void hideShow(){
        TextView textView = findViewById(R.id.textview_first);
        if(textView.getVisibility()== View.VISIBLE){
            textView.setVisibility(View.INVISIBLE);
            isVisible = true;
        }
        else{
            textView.setVisibility(View.VISIBLE);
            isVisible = false;
        }
    }
    private void reset(){
        tv_number.setVisibility(View.VISIBLE);
        tv_number.setText("0");
        ConstraintLayout constraintLayout = findViewById(R.id.background);
        constraintLayout.setBackgroundColor(Color.parseColor("#008577"));
        isVisible = false;
    }
}