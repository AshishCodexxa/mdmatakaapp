package com.md.mataka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class days_game extends AppCompatActivity {

    ImageView back;
    ImageView single, halfsangam, fullsangam, jodi;
    ArrayList<String> number = new ArrayList<>();
    TextView heading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_game);





        String game = getIntent().getStringExtra("game");
        String market = getIntent().getStringExtra("market");
        number = getIntent().getStringArrayListExtra("list");




        single = findViewById(R.id.single);
        halfsangam = findViewById(R.id.halfsangam);
        fullsangam = findViewById(R.id.fullsangam);
        jodi = findViewById(R.id.jodi);
        heading = findViewById(R.id.headName);
        back = findViewById(R.id.backs);

        heading.setText(market);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(days_game.this, MainActivity.class));
            }
        });

        single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("GameName",game);
                Log.e("Name",market);
                Log.e("Numbers",number.toString());
                startActivity(new Intent(days_game.this, betting.class).putExtra("market", market).putExtra("list", number).putExtra("game", game).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        halfsangam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("GameName",game);
                Log.e("Name",market);
                Log.e("Numbers",number.toString());
               startActivity(new Intent(days_game.this, halfsangam.class).putExtra("market", market).putExtra("list", number).putExtra("game", game).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        fullsangam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("GameName",game);
                Log.e("Name",market);
                Log.e("Numbers",number.toString());
                startActivity(new Intent(days_game.this, fullsangam.class).putExtra("market", market).putExtra("list", number).putExtra("game", game).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

//        jodi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("GameName",game);
//                Log.e("Name",market);
//                Log.e("Numbers",number.toString());
//               startActivity(new Intent(days_game.this, crossing.class).putExtra("market", market).putExtra("list", number).putExtra("game", game).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//            }
//        });

    }
}