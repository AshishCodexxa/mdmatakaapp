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
    ImageView single, halfsangam, fullsangam, jodi, singlepatti, doublepatti, tripepatti;
    ArrayList<String> number = new ArrayList<>();
    ArrayList<String> number2 = new ArrayList<>();
    ArrayList<String> number3 = new ArrayList<>();
    ArrayList<String> number4 = new ArrayList<>();
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
        singlepatti = findViewById(R.id.singlepatti);
        doublepatti = findViewById(R.id.doublepatti);
        tripepatti = findViewById(R.id.tripepatti);

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

        jodi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("GameName",game);
                Log.e("Name",market);
                Log.e("Numbers",number.toString());
                ArrayList<String> number1 = new ArrayList<>();

                for (int i = 0; i < 100; i++) {
                    String temp = String.format("%02d", i);
                    number1.add(temp);
                }
               startActivity(new Intent(days_game.this, betting.class).putExtra("market", market).putExtra("list", number1).putExtra("game", game).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        singlepatti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("GameName",game);
                Log.e("Name",market);
                Log.e("Numbers",number.toString());
                singlepatti();
               startActivity(new Intent(days_game.this, betting.class).putExtra("market", market).putExtra("list", number2).putExtra("game", game).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        doublepatti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("GameName",game);
                Log.e("Name",market);
                Log.e("Numbers",number.toString());
                doublepatti();
               startActivity(new Intent(days_game.this, betting.class).putExtra("market", market).putExtra("list", number3).putExtra("game", game).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        tripepatti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("GameName",game);
                Log.e("Name",market);
                Log.e("Numbers",number.toString());
                triplepatti();
               startActivity(new Intent(days_game.this, betting.class).putExtra("market", market).putExtra("list", number4).putExtra("game", game).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

    }


    public void singlepatti() {
        number2.add("128");
        number2.add("137");
        number2.add("146");
        number2.add("236");
        number2.add("245");
        number2.add("290");
        number2.add("380");
        number2.add("470");
        number2.add("489");
        number2.add("560");
        number2.add("678");
        number2.add("579");
        number2.add("129");
        number2.add("138");
        number2.add("147");
        number2.add("156");
        number2.add("237");
        number2.add("246");
        number2.add("345");
        number2.add("390");
        number2.add("480");
        number2.add("570");
        number2.add("679");
        number2.add("120");
        number2.add("139");
        number2.add("148");
        number2.add("157");
        number2.add("238");
        number2.add("247");
        number2.add("256");
        number2.add("346");
        number2.add("490");
        number2.add("580");
        number2.add("670");
        number2.add("689");
        number2.add("130");
        number2.add("149");
        number2.add("158");
        number2.add("167");
        number2.add("239");
        number2.add("248");
        number2.add("257");
        number2.add("347");
        number2.add("356");
        number2.add("590");
        number2.add("680");
        number2.add("789");
        number2.add("140");
        number2.add("159");
        number2.add("168");
        number2.add("230");
        number2.add("249");
        number2.add("258");
        number2.add("267");
        number2.add("348");
        number2.add("357");
        number2.add("456");
        number2.add("690");
        number2.add("780");
        number2.add("123");
        number2.add("150");
        number2.add("169");
        number2.add("178");
        number2.add("240");
        number2.add("259");
        number2.add("268");
        number2.add("349");
        number2.add("358");
        number2.add("457");
        number2.add("367");
        number2.add("790");
        number2.add("124");
        number2.add("160");
        number2.add("179");
        number2.add("250");
        number2.add("269");
        number2.add("278");
        number2.add("340");
        number2.add("359");
        number2.add("368");
        number2.add("458");
        number2.add("467");
        number2.add("890");
        number2.add("125");
        number2.add("134");
        number2.add("170");
        number2.add("189");
        number2.add("260");
        number2.add("279");
        number2.add("350");
        number2.add("369");
        number2.add("378");
        number2.add("459");
        number2.add("567");
        number2.add("468");
        number2.add("126");
        number2.add("135");
        number2.add("180");
        number2.add("234");
        number2.add("270");
        number2.add("289");
        number2.add("360");
        number2.add("379");
        number2.add("450");
        number2.add("469");
        number2.add("478");
        number2.add("568");
        number2.add("127");
        number2.add("136");
        number2.add("145");
        number2.add("190");
        number2.add("235");
        number2.add("280");
        number2.add("370");
        number2.add("479");
        number2.add("460");
        number2.add("569");
        number2.add("389");
        number2.add("578");
        number2.add("589");
    }

    public void doublepatti() {
        number3.add("100");
        number3.add("119");
        number3.add("155");
        number3.add("227");
        number3.add("335");
        number3.add("344");
        number3.add("399");
        number3.add("588");
        number3.add("669");
        number3.add("200");
        number3.add("110");
        number3.add("228");
        number3.add("255");
        number3.add("336");
        number3.add("499");
        number3.add("660");
        number3.add("688");
        number3.add("778");
        number3.add("300");
        number3.add("166");
        number3.add("229");
        number3.add("337");
        number3.add("355");
        number3.add("445");
        number3.add("599");
        number3.add("779");
        number3.add("788");
        number3.add("400");
        number3.add("112");
        number3.add("220");
        number3.add("266");
        number3.add("338");
        number3.add("446");
        number3.add("455");
        number3.add("699");
        number3.add("770");
        number3.add("500");
        number3.add("113");
        number3.add("122");
        number3.add("177");
        number3.add("339");
        number3.add("366");
        number3.add("447");
        number3.add("799");
        number3.add("889");
        number3.add("600");
        number3.add("114");
        number3.add("277");
        number3.add("330");
        number3.add("448");
        number3.add("466");
        number3.add("556");
        number3.add("880");
        number3.add("899");
        number3.add("700");
        number3.add("115");
        number3.add("133");
        number3.add("188");
        number3.add("223");
        number3.add("377");
        number3.add("449");
        number3.add("557");
        number3.add("566");
        number3.add("800");
        number3.add("116");
        number3.add("224");
        number3.add("233");
        number3.add("288");
        number3.add("440");
        number3.add("477");
        number3.add("558");
        number3.add("990");
        number3.add("900");
        number3.add("117");
        number3.add("144");
        number3.add("199");
        number3.add("225");
        number3.add("388");
        number3.add("559");
        number3.add("577");
        number3.add("667");
        number3.add("550");
        number3.add("668");
        number3.add("244");
        number3.add("299");
        number3.add("226");
        number3.add("488");
        number3.add("677");
        number3.add("118");
        number3.add("334");
    }

    public void triplepatti() {
        number4.add("000");
        number4.add("111");
        number4.add("222");
        number4.add("333");
        number4.add("444");
        number4.add("555");
        number4.add("666");
        number4.add("777");
        number4.add("888");
        number4.add("999");
    }

}