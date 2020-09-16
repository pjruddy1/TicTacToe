package com.zybooks.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView [] imageViews = new ImageView[9];
    private ImageView playerImageView;
    private Button mStartButton;
    private Game mGame;
    public ImageView empView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerImageView = findViewById(R.id.playerImageView);

        for (int i = 0; i < 9; i++) {
                String imageViewID = "imageView" + i;
                int resID = getResources().getIdentifier(imageViewID, "id", getPackageName());
                imageViews[i] = findViewById(resID);
                imageViews[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       // if (!((ImageView) v).getResources().equals("")) {
                       //     return;
                       // }

                        if (mGame.player1Turn) {
                            ((ImageView) v).setImageResource(R.drawable.x);
                            ((ImageView) v).setTag(mGame.moveType);
                        } else {
                            ((ImageView) v).setImageResource(R.drawable.o);
                            ((ImageView) v).setTag(mGame.moveType);
                        }
                        mGame.moveCount++;

                        if (mGame.checkForWin(imageViews)) {
                            if (mGame.player1Turn) {
                                player1Wins();
                            } else {
                                player2Wins();
                            }
                        } else if (mGame.moveCount == 9) {
                            draw();
                        } else {
                            mGame.player1Turn = !mGame.player1Turn;
                            if (!mGame.player1Turn) {
                                playerImageView.setImageResource(R.drawable.o);
                            }
                            else {
                                playerImageView.setImageResource(R.drawable.x);
                            }
                        }

                    }
                });

        }

        mStartButton = findViewById(R.id.startButton);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewGame();
            }
        });
    }

    private void draw() {
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
        NewGame();
    }

    private void player1Wins() {
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
        NewGame();
    }

    private void player2Wins() {
        Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_SHORT).show();
        NewGame();
    }

    private void NewGame() {
        mGame = new Game();
        for (int i = 0; i < 9; i++) {
            imageViews[i].setImageResource(R.drawable.empty);
        }

    }

}