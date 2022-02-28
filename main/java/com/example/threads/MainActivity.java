package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

            public void onCreate(Bundle savedInstanceState) {

                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);



                final TextView txt1 = (TextView) findViewById(R.id.txt1);

                Button b= (Button)findViewById(R.id.btn);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Thread t= new Thread(new Runnable() {
                            @Override
                            public void run() {
                                txt1.setTextColor(Color.RED);
                            }
                        });
                        t.start();
                    }
                });

                Button b1= (Button)findViewById(R.id.btn2);
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Thread t= new Thread(new Runnable() {
                            @Override
                            public void run() {
                                txt1.setTextColor(Color.BLUE);
                            }
                        });
                        t.start();
                    }
                });
                Button b2= (Button)findViewById(R.id.btn3);
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                            Thread t= new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    final Animation anime =AnimationUtils.loadAnimation(getApplicationContext(),
                                            R.anim.anime);
                                   for(int i=0;i<10;i++){ txt1.startAnimation(anime);}
                                    //first child thread
                                    Thread t1= new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            txt1.setTextColor(Color.BLUE);
                                        }
                                    });
                                    t1.start();

                                    //second child thread
                                    Thread t2= new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            txt1.setTextColor(Color.RED);
                                        }
                                    });
                                    t2.start();
                                    //third child thread


                                    Thread t3= new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            txt1.setTextColor(Color.GREEN);
                                        }
                                    });
                                    t3.start();


                                }
                            });
                            t.start();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        }

                });


            }

        }
