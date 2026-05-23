package com.example.oryonremote;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnLeft, btnRight, btnBrake, btnAccelerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top,
                    systemBars.right, systemBars.bottom);
            return insets;
        });

        btnLeft       = findViewById(R.id.btnLeft);
        btnRight      = findViewById(R.id.btnRight);
        btnBrake      = findViewById(R.id.btnBrake);
        btnAccelerate = findViewById(R.id.btnAccelerate);

        // Left Button — turn left while held, stop on release
        btnLeft.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                sendCommand("LEFT");
            } else if (event.getAction() == MotionEvent.ACTION_UP
                    || event.getAction() == MotionEvent.ACTION_CANCEL) {
                sendCommand("STOP");
            }
            return true;
        });

        // Right Button — turn right while held, stop on release
        btnRight.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                sendCommand("RIGHT");
            } else if (event.getAction() == MotionEvent.ACTION_UP
                    || event.getAction() == MotionEvent.ACTION_CANCEL) {
                sendCommand("STOP");
            }
            return true;
        });

        // Brake Button — moves backward while held, stops on release
        btnBrake.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                sendCommand("BACKWARD");
            } else if (event.getAction() == MotionEvent.ACTION_UP
                    || event.getAction() == MotionEvent.ACTION_CANCEL) {
                sendCommand("STOP");
            }
            return true;
        });

        // Accelerate Button — moves forward while held, stops on release
        btnAccelerate.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                sendCommand("FORWARD");
            } else if (event.getAction() == MotionEvent.ACTION_UP
                    || event.getAction() == MotionEvent.ACTION_CANCEL) {
                sendCommand("STOP");
            }
            return true;
        });
    }

    // Replace this with your actual Bluetooth / WiFi send logic
    private void sendCommand(String command) {
        // TODO: send command to RC car
        System.out.println("Command sent: " + command);
    }
}