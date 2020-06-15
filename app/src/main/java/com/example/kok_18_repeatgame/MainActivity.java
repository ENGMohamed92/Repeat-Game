package com.example.kok_18_repeatgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button nGame, btn_01, btn_02, btn_03, btn_04, btn_05, btn_06, btn_07, btn_08, btn_09, btn_10, btn_11, btn_12;
    List<Integer> buttons;
    int curLevel, curGuess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = new ArrayList<>();
        buttons.add(1);
        buttons.add(2);
        buttons.add(3);
        buttons.add(4);
        buttons.add(5);
        buttons.add(6);
        buttons.add(7);
        buttons.add(8);
        buttons.add(9);
        buttons.add(10);
        buttons.add(11);
        buttons.add(12);

        nGame = findViewById(R.id.BTN_NewGame);

        btn_01 = findViewById(R.id.BTN_01);
        btn_02 = findViewById(R.id.BTN_02);
        btn_03 = findViewById(R.id.BTN_03);
        btn_04 = findViewById(R.id.BTN_04);
        btn_05 = findViewById(R.id.BTN_05);
        btn_06 = findViewById(R.id.BTN_06);
        btn_07 = findViewById(R.id.BTN_07);
        btn_08 = findViewById(R.id.BTN_08);
        btn_09 = findViewById(R.id.BTN_09);
        btn_10 = findViewById(R.id.BTN_10);
        btn_11 = findViewById(R.id.BTN_11);
        btn_12 = findViewById(R.id.BTN_12);

        btn_01.setTag(1);
        btn_02.setTag(2);
        btn_03.setTag(3);
        btn_04.setTag(4);
        btn_05.setTag(5);
        btn_06.setTag(6);
        btn_07.setTag(7);
        btn_08.setTag(8);
        btn_09.setTag(9);
        btn_10.setTag(10);
        btn_11.setTag(11);
        btn_12.setTag(12);

        disableButtons();

        nGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nGame.setVisibility(View.INVISIBLE);
                curGuess = 0;
                curLevel = 1;
                generateButtons(curLevel);
            }
        });

        btn_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
                ((Button) v).setText("O");
            }
        });

        btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
                ((Button) v).setText("O");
            }
        });

        btn_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
                ((Button) v).setText("O");
            }
        });

        btn_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
                ((Button) v).setText("O");
            }
        });

        btn_05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
                ((Button) v).setText("O");
            }
        });

        btn_06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
                ((Button) v).setText("O");
            }
        });

        btn_07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
                ((Button) v).setText("O");
            }
        });

        btn_08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
                ((Button) v).setText("O");
            }
        });

        btn_09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
                ((Button) v).setText("O");
            }
        });

        btn_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
                ((Button) v).setText("O");
            }
        });

        btn_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
                ((Button) v).setText("O");
            }
        });

        btn_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
                ((Button) v).setText("O");
            }
        });

    } // END On Create

    private void buttonLogic(View v) {
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < curLevel; i++) {
            tempList.add(buttons.get(i));
        }

        if (tempList.contains(v.getTag())) {
            curGuess++;
            checkWin();
        } else {
            lostGame();
        }

    }

    private void checkWin() {
        if (curGuess == curLevel) {
            disableButtons();
            if (curLevel == 12) {
                Toast.makeText(this, "You Win Game", Toast.LENGTH_SHORT).show();
                nGame.setVisibility(View.VISIBLE);
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        curGuess = 0;
                        curLevel++;
                        generateButtons(curLevel);
                    }
                }, 1000);
            }
        }
    }

    private void lostGame() {
        Toast.makeText(this, "You Loast The Game", Toast.LENGTH_SHORT).show();
        disableButtons();
        nGame.setVisibility(View.VISIBLE);
    }

    private void generateButtons(int num) {
        btn_01.setText("");
        btn_02.setText("");
        btn_03.setText("");
        btn_04.setText("");
        btn_05.setText("");
        btn_06.setText("");
        btn_07.setText("");
        btn_08.setText("");
        btn_09.setText("");
        btn_10.setText("");
        btn_11.setText("");
        btn_12.setText("");

        Collections.shuffle(buttons);

        for (int i = 0; i < num; i++) {
            showButtons(buttons.get(i));
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btn_01.setText("");
                btn_02.setText("");
                btn_03.setText("");
                btn_04.setText("");
                btn_05.setText("");
                btn_06.setText("");
                btn_07.setText("");
                btn_08.setText("");
                btn_09.setText("");
                btn_10.setText("");
                btn_11.setText("");
                btn_12.setText("");
                enableButtons();
            }
        }, 1000);

    }

    private void showButtons(int num) {
        switch (num) {
            case 1:
                btn_01.setText("O");
                break;
            case 2:
                btn_02.setText("O");
                break;
            case 3:
                btn_03.setText("O");
                break;
            case 4:
                btn_04.setText("O");
                break;
            case 5:
                btn_05.setText("O");
                break;
            case 6:
                btn_06.setText("O");
                break;
            case 7:
                btn_07.setText("O");
                break;
            case 8:
                btn_08.setText("O");
                break;
            case 9:
                btn_09.setText("O");
                break;
            case 10:
                btn_10.setText("O");
                break;
            case 11:
                btn_11.setText("O");
                break;
            case 12:
                btn_12.setText("O");
                break;
        }
    }

    private void enableButtons() {
        btn_01.setEnabled(true);
        btn_02.setEnabled(true);
        btn_03.setEnabled(true);
        btn_04.setEnabled(true);
        btn_05.setEnabled(true);
        btn_06.setEnabled(true);
        btn_07.setEnabled(true);
        btn_08.setEnabled(true);
        btn_09.setEnabled(true);
        btn_10.setEnabled(true);
        btn_11.setEnabled(true);
        btn_12.setEnabled(true);
    }

    private void disableButtons() {
        btn_01.setEnabled(false);
        btn_02.setEnabled(false);
        btn_03.setEnabled(false);
        btn_04.setEnabled(false);
        btn_05.setEnabled(false);
        btn_06.setEnabled(false);
        btn_07.setEnabled(false);
        btn_08.setEnabled(false);
        btn_09.setEnabled(false);
        btn_10.setEnabled(false);
        btn_11.setEnabled(false);
        btn_12.setEnabled(false);
    }

} // END Activity