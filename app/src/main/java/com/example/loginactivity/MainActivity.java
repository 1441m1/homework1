package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final int[] changebtncolor = {0};
    int btncolor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        EditText text = findViewById(R.id.editTextTextEmailAddress);
        EditText text1 = findViewById(R.id.editTextTextEmailAddress3);



        final int [] countText ={0,0};

        btncolor = getResources().getColor(R.color.black);
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    countText[1] += count;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        text1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (count == 1) countText[0] += count;
                if (count == 0) countText[0] -= 1;

                if (countText[0] >5 && countText[1]>5){
                    button.setBackgroundColor(btncolor);
                    changebtncolor[0] = btncolor;
                }


                else{
                    button.setBackgroundColor(getResources().getColor(R.color.gray));
                    changebtncolor[0]=0;
                }



            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void enter(View view ) {
        if ( changebtncolor[0] == btncolor ){
            EditText editText = findViewById(R.id.editTextTextEmailAddress);
            Toast toast = Toast.makeText(this, editText.getText(), Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
        }




    }


}