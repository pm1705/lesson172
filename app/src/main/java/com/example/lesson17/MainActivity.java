package com.example.lesson17;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder first_color_adb, second_color_adb, toasty_bread_adb;
    String[] colors = {"red","green","blue"};
    int[] color;
    LinearLayout l1;
    String str1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l1 = (LinearLayout) findViewById(R.id.l1);
    }

    public void first_color(View view) {

        first_color_adb = new AlertDialog.Builder(this);
        first_color_adb.setTitle("Pick a color, any color");
        first_color_adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color = new int[]{200,200,200};
                color[which] = 255;
                l1.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });

        AlertDialog first_color_ad = first_color_adb.create();
        first_color_ad.show();
    }

    public void second_color(View view) {
        color = new int[]{200,200,200};

        second_color_adb = new AlertDialog.Builder(this);
        second_color_adb.setTitle("Pick a color, even two colors");
        second_color_adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                l1.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
                dialog.dismiss();
            }
        });
        second_color_adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });
        second_color_adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (!isChecked) color[which] = 200;
                else color[which] = 255;
            }
        });

        AlertDialog second_color_ad = second_color_adb.create();
        second_color_ad.show();
    }

    public void reset_color(View view) {
        l1.setBackgroundColor(Color.rgb(232,232,232));
    }

    public void toasty_bread(View view) {

        toasty_bread_adb = new AlertDialog.Builder(this);
        toasty_bread_adb.setTitle("enter a word, any word");
        EditText kelet = new EditText(this);
        kelet.setHint("word goes here");
        toasty_bread_adb.setView(kelet);
        toasty_bread_adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                str1 = kelet.getText().toString();
                dialog.dismiss();
                Toast.makeText(MainActivity.this, str1, Toast.LENGTH_SHORT).show();
            }
        });

        toasty_bread_adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog toast_bread_ad = toasty_bread_adb.create();
        toast_bread_ad.show();
    }
}