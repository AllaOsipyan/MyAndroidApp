package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener{
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void chooseBook(View view){

        TextView info = (TextView)findViewById(R.id.commonInfo);
        info.setText("Вы выбрали категорию \"Книги\"");
    }

    public void chooseFilm(View view){

        TextView info= (TextView)findViewById(R.id.commonInfo);
        info.setText("Вы выбрали категорию \"Фильмы\"");
    }

    public void chooseMusic(View view){

        TextView info= (TextView)findViewById(R.id.commonInfo);
        info.setText("Вы выбрали категорию \"Музыка\"");
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        Toast.makeText(this, Integer.toString(newVal), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.derred:
                Toast.makeText(this, "Отложенные", Toast.LENGTH_SHORT).show();
                break;
            case R.id.favourites:
                Toast.makeText(this, "Избранные", Toast.LENGTH_SHORT).show();
                break;
            case R.id.user_age:
                MyDialog newFragment = new MyDialog();
                newFragment.setValueChangeListener(this);
                newFragment.show(getSupportFragmentManager(), "time picker");

                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
