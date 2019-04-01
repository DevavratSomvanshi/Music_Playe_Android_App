package com.example.newu.elabs_musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    TextView t1,t2;
    MediaPlayer mp;
    Button b1,b2,b3,b4;
    Handler handler=new Handler();
    SeekBar cb;
    int a,b,c;
    ListView ab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView) findViewById(R.id.textView);
        t2=(TextView) findViewById(R.id.textView2);
        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        b4=(Button) findViewById(R.id.button4);
        ab=(ListView) findViewById(R.id.listView);
        cb=(SeekBar) findViewById(R.id.seekBar);
        String MusicPlayer[]={"Shape_of_you","Dangal","Idiot_Bana","Chandaniya"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,MusicPlayer);
        ab.setAdapter(adapter);
        cb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar cb, int progress, boolean fromUser) {
                if (fromUser){
                    mp.seekTo(progress);
                }
                else {
                    runnable.run();
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar cb) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar cb) {

            }
        });
        ab.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                b=pos;
                if (pos == 0) {
                    cb.setMax(0);
                    if(a==1) {
                        stop();
                    }

                    a=1;

                    mp=MediaPlayer.create(getApplicationContext(),R.raw.abc1);
                    ttl();
                    cb.setMax(mp.getDuration());
                    mp.start();
                    b1.setText("Pause");
                }
                else  if (pos == 1) {
                    cb.setMax(0);
                    if(a==1) {
                        stop();
                    }
                    a=1;

                    mp=MediaPlayer.create(getApplicationContext(),R.raw.abc2);
                    ttl();
                    cb.setMax(mp.getDuration());
                    mp.start();
                    b1.setText("Pause");
                }
                else    if (pos == 2) {
                    cb.setMax(0);
                    if(a==1) {
                        stop();
                    }
                    a=1;
                    mp=MediaPlayer.create(getApplicationContext(),R.raw.abc3);
                    ttl();
                    cb.setMax(mp.getDuration());
                    mp.start();
                    b1.setText("Pause");
                }
                else    if (pos == 3) {
                    cb.setMax(0);
                    if(a==1) {
                        stop();
                    }
                    a=1;
                    mp=MediaPlayer.create(getApplicationContext(),R.raw.abc4);
                    ttl();
                    cb.setMax(mp.getDuration());
                    mp.start();
                    b1.setText("Pause");
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1,s2;
                s1=String.valueOf(b1.getText());
                s2="Pause";
                if(mp!=null) {
                    if (s1.equals(s2)) {
                        mp.pause();
                        b1.setText("Play");
                    }
                    else {
                        mp=MediaPlayer.create(getApplicationContext(),R.raw.abc1);
                        mp.start();
                        b1.setText("Pause");
                        cb.setMax(mp.getDuration());

                    }
                }
                else {
                    if (s1.equals("Play")) {
                        mp = MediaPlayer.create(getApplicationContext(), R.raw.abc1);
                        ttl();


                        cb.setMax(mp.getDuration());

                        b1.setText("Pause");
                        b=0;
                        mp.start();
                    } else
                        Toast.makeText(MainActivity.this, "No song is selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp!=null) {
                    mp.stop();
                    t1.setText("0:0");
                    t2.setText("0:0");
                    a = 0;
                    b1.setText("Play");
                    mp = null;
                    cb.setMax(0);
                    cb.setProgress(0);
                }
                else
                    Toast.makeText(MainActivity.this, "No song is playing", Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b==0){
                    t1.setText("0:0");
                    t2.setText("0:0");
                    if(mp!=null) {
                        stop();
                    }
                    mp=MediaPlayer.create(getApplicationContext(),R.raw.abc2);
                    ttl();
                    cb.setMax(mp.getDuration());
                    mp.start();
                    b1.setText("Pause");
                    b=1;
                }
                else     if(b==1){
                    t1.setText("0:0");
                    t2.setText("0:0");
                    if(mp!=null){
                        stop();
                    }
                    mp=MediaPlayer.create(getApplicationContext(),R.raw.abc3);
                    ttl();
                    cb.setMax(mp.getDuration());
                    mp.start();
                    b1.setText("Pause");
                    b=2;
                }
                else  if(b==2){
                    t1.setText("0:0");
                    t2.setText("0:0");
                    if(mp!=null) {
                        stop();
                    }
                    mp=MediaPlayer.create(getApplicationContext(),R.raw.abc4);
                    ttl();
                    cb.setMax(mp.getDuration());
                    mp.start();
                    b1.setText("Pause");
                    b=3;
                }
                else if(b==3){
                    t1.setText("0:0");
                    t2.setText("0:0");
                    if(mp!=null) {
                        stop();
                    }
                    mp=MediaPlayer.create(getApplicationContext(),R.raw.abc1);
                    mp.start();
                    ttl();
                    cb.setMax(mp.getDuration());
                    b1.setText("Pause");
                    b=0;
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {

                if(b==0){
                    t1.setText("0:0");
                    t2.setText("0:0");
                    if(mp!=null) {
                        stop();
                    }
                    mp=MediaPlayer.create(getApplicationContext(),R.raw.abc4);
                    ttl();
                    cb.setMax(mp.getDuration());
                    mp.start();
                    b1.setText("Pause");
                    b=3;
                }
                else     if(b==1){
                    t1.setText("0:0");
                    t2.setText("0:0");
                    if(mp!=null){
                        stop();
                    }
                    mp=MediaPlayer.create(getApplicationContext(),R.raw.abc1);
                    ttl();
                    cb.setMax(mp.getDuration());
                    mp.start();
                    b1.setText("Pause");
                    b=0;
                }
                else  if(b==2){
                    t1.setText("0:0");
                    t2.setText("0:0");
                    if(mp!=null) {
                        stop();
                    }
                    mp=MediaPlayer.create(getApplicationContext(),R.raw.abc2);
                    ttl();
                    cb.setMax(mp.getDuration());
                    mp.start();
                    b1.setText("Pause");
                    b=1;
                }
                else if(b==3){
                    t1.setText("0:0");
                    t2.setText("0:0");
                    if(mp!=null) {
                        stop();
                    }
                    mp=MediaPlayer.create(getApplicationContext(),R.raw.abc3);
                    mp.start();
                    ttl();
                    cb.setMax(mp.getDuration());
                    b1.setText("Pause");
                    b=2;
                }
            }
        });
    }
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int x, min, sec;
            if(mp!=null) {
                cb.setProgress(mp.getCurrentPosition());
                x = (mp.getCurrentPosition() / 1000);
                min = x / 60;
                sec = x % 60;
                t1.setText(String.valueOf(min + ":" + sec));

                handler.postDelayed(runnable, 1000);
            }
            else {
                handler.removeCallbacks(runnable);
            }
}
    };



    public void ttl(){
        int x,min,sec;
        x=(mp.getDuration()/1000);
        min=x/60;
        sec=x%60;
        t2.setText(String.valueOf(min +":"+sec));
    }
    public void stop(){
        mp.stop();
        mp = null;
        cb.setProgress(0);
    }


}