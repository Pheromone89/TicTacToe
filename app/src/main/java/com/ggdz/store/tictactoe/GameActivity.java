package com.ggdz.store.tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity {

    TextView playerNameX, playerNameO, playerScoreX, playerScoreO, moveMessage;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, finishButton, resetButton;int colorOfX;

    int colorOfO;
    int colorOfXSecondary;
    int colorOfOSecondary;

    public int scoreX;
    public int scoreO;
    public int move;
    private int movePerGame;
    private boolean isXTurn;
    private boolean isGameEnd = false;
    private boolean isB1Clickable;
    private boolean isB2Clickable;
    private boolean isB3Clickable;
    private boolean isB4Clickable;
    private boolean isB5Clickable;
    private boolean isB6Clickable;
    private boolean isB7Clickable;
    private boolean isB8Clickable;
    private boolean isB9Clickable;

    private String nameX = "X";
    private String nameO = "O";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().hide();

        scoreX = 0;
        scoreO = 0;
        move = 0;
        movePerGame = 0;
        isXTurn = true;
        isB1Clickable = isB2Clickable = isB3Clickable = isB4Clickable = isB5Clickable = isB6Clickable = isB7Clickable = isB8Clickable = isB9Clickable = true;

        playerNameX = findViewById(R.id.player_name_X);
        playerNameO = findViewById(R.id.player_name_O);
        playerScoreX = findViewById(R.id.player_score_X);
        playerScoreO = findViewById(R.id.player_score_O);

        colorOfX = getResources().getColor(R.color.colorOfX);
        colorOfO = getResources().getColor(R.color.colorOfO);
        colorOfXSecondary = getResources().getColor(R.color.colorOfXSecondary);
        colorOfOSecondary = getResources().getColor(R.color.colorOfOSecondary);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);

        moveMessage = findViewById(R.id.move_message);

        finishButton = findViewById(R.id.finish_message_button);
        resetButton = findViewById(R.id.reset_message_button);

        resetBoard();
        displayName();
        displayScore();

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isGameEnd){
                    setNewBoard();
                } else{
                    resetBoard();
                    unlockBoard();
                    setNewBoard();
                    displayScore();
                }

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isB1Clickable) {
                    if (isXTurn) {
                        moveX((Button) v);
                    } else {
                        moveO((Button) v);
                    }
                    isB1Clickable = false;
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isB2Clickable) {
                    if (isXTurn) {
                        moveX((Button) v);
                    } else {
                        moveO((Button) v);
                    }
                    isB2Clickable = false;
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isB3Clickable) {
                    if (isXTurn) {
                        moveX((Button) v);
                    } else {
                        moveO((Button) v);
                    }
                    isB3Clickable = false;
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isB4Clickable) {
                    if (isXTurn) {
                        moveX((Button) v);
                    } else {
                        moveO((Button) v);
                    }
                    isB4Clickable = false;
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isB5Clickable) {
                    if (isXTurn) {
                        moveX((Button) v);
                    } else {
                        moveO((Button) v);
                    }
                    isB5Clickable = false;
                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isB6Clickable) {
                    if (isXTurn) {
                        moveX((Button) v);
                    } else {
                        moveO((Button) v);
                    }
                    isB6Clickable = false;
                }
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isB7Clickable) {
                    if (isXTurn) {
                        moveX((Button) v);
                    } else {
                        moveO((Button) v);
                    }
                    isB7Clickable = false;
                }
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isB8Clickable) {
                    if (isXTurn) {
                        moveX((Button) v);
                    } else {
                        moveO((Button) v);
                    }
                    isB8Clickable = false;
                }
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isB9Clickable) {
                    if (isXTurn) {
                        moveX((Button) v);
                    } else {
                        moveO((Button) v);
                    }
                    isB9Clickable = false;
                }
            }
        });
    }

    private void moveX(Button v){
        v.setText("X");
        v.setTextColor(colorOfX);
        incrementMove();
        isXTurn = false;
        setMoveMesage();
        checkWinningCondition("X");
    }
    private void moveO(Button v){
        v.setText("0");
        v.setTextColor(colorOfO);
        incrementMove();
        isXTurn = true;
        setMoveMesage();
        checkWinningCondition("O");
    }

    private void incrementMove(){
        move ++ ;
        movePerGame ++;
    }
    private void setMoveMesage(){
        if(isXTurn){
            moveMessage.setText(nameX+"'s turn to move");
            moveMessage.setTextColor(colorOfX);
        } else {
            moveMessage.setText(nameO+"'s turn to move");
            moveMessage.setTextColor(colorOfO);
        }
    }
    private void incrementScoreX(){
        scoreX ++ ;
    }
    private void incrementScoreO(){
        scoreO ++ ;
    }
    private void resetBoard(){
        b1.setText(" ");
        b2.setText("");
        b3.setText(" ");
        b4.setText("");
        b5.setText(" ");
        b6.setText(" ");
        b7.setText("");
        b8.setText(" ");
        b9.setText("");
    }
    private void resetMove(){
        move = 0;
    }
    private void displayScore(){
        playerScoreX.setText(Integer.toString(scoreX));
        playerScoreO.setText(Integer.toString(scoreO));
    }
    private void displayName(){
        playerNameX.setText("Player X");
        playerNameO.setText("Player O");
    }

    private void unlockBoard(){
        isB1Clickable= isB2Clickable = isB3Clickable = isB4Clickable = isB5Clickable = isB6Clickable = isB7Clickable = isB8Clickable = isB9Clickable = true;
    }
    private void lockBoard (){
        isB1Clickable= isB2Clickable = isB3Clickable = isB4Clickable = isB5Clickable = isB6Clickable = isB7Clickable = isB8Clickable = isB9Clickable = false;
    }
    private void setNewBoard(){
        resetBoard();
        unlockBoard();
        resetMove();
        isGameEnd = false;
        setMoveMesage();
    }
    private void checkWinningCondition(String winner){
        if(checkLine(b1, b2, b3) || checkLine(b4, b5, b6) || checkLine(b7, b8, b9) ||
            checkLine(b1, b4, b7) || checkLine(b2, b5, b8) || checkLine(b3, b6, b9) ||
            checkLine(b1, b5, b9) || checkLine(b3, b5, b7)){

            if (isXTurn){
                incrementScoreO();
                movePerGame = 0;
            } else {
                incrementScoreX();
                movePerGame = 0;
            }

            moveMessage.setTextColor(Color.rgb(48, 63, 159));
            moveMessage.setText(winner+" wins this round!");
            isGameEnd = true;
            lockBoard();
            displayScore();

            Toast.makeText(GameActivity.this, winner+" wins this round!!!",
                    Toast.LENGTH_LONG).show();

        } else if (movePerGame == 9){
            moveMessage.setText("No one win this round");
            isGameEnd = true;
            lockBoard();
            displayScore();
            movePerGame = 0;
        }
    }
    private boolean checkLine(Button b1, Button b2, Button b3){
        return b1.getText() == b2.getText() && b1.getText() == b3.getText();
    }
}