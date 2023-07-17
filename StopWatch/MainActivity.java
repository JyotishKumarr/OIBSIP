package com.example.stopwatch;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView stopwatchTextView;
    private ImageButton startButton, stopButton, resetButton;
    private Handler handler;
    private Runnable runnable;
    private long startTime, elapsedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stopwatchTextView = findViewById(R.id.stopwatchTextView);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);
        resetButton = findViewById(R.id.resetButton);

        handler = new Handler();
        stopButton.setVisibility(View.INVISIBLE);
        resetButton.setVisibility(View.INVISIBLE);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStopwatch();
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
                stopButton.setVisibility(View.VISIBLE);
                resetButton.setVisibility(View.VISIBLE);
                startButton.setVisibility(View.INVISIBLE);
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopStopwatch();
                stopButton.setEnabled(false);
                startButton.setEnabled(true);
                startButton.setVisibility(View.VISIBLE);
                stopButton.setVisibility(View.INVISIBLE);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetStopwatch();
                startButton.setEnabled(true);
                stopButton.setEnabled(false);
                startButton.setVisibility(View.VISIBLE);
                stopButton.setVisibility(View.INVISIBLE);
                resetButton.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void startStopwatch() {
        startTime = System.currentTimeMillis();
        runnable = new Runnable() {
            @Override
            public void run() {
                elapsedTime = System.currentTimeMillis() - startTime;
                int seconds = (int) (elapsedTime / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                int milliseconds = (int) (elapsedTime % 1000);
                stopwatchTextView.setText(String.format("%02d:%02d:%03d", minutes, seconds, milliseconds));
                handler.postDelayed(this, 10);
            }
        };
        handler.postDelayed(runnable, 10);
    }

    private void stopStopwatch() {
        handler.removeCallbacks(runnable);
    }

    private void resetStopwatch() {
        stopStopwatch();
        stopwatchTextView.setText("00:00:000");
    }
}
