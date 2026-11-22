package com.katza.danielkashi;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.jetbrains.annotations.TestOnly;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    Button btnIsrael, btnSendMessage, btnFollow;
    Switch sdaniel;
    TextView tvUserName;

    private ImageView picture,picture2;
    private SeekBar geekbar;

    private TextInputLayout tilGuess;
    private TextInputEditText etGuess;
    private Button btnGuess;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        int number=(int)(Math.random()*100);



        picture = findViewById(R.id.israeli);

        picture2 = findViewById(R.id.palpatine);

        geekbar = findViewById(R.id.seekBar);

        // 1. תיקון הבאג ההתחלתי: סנכרון שקיפות התמונה עם מצב ההתחלה של ה-SeekBar
        float initialAlpha = geekbar.getProgress() / 100f;
        picture.setAlpha(initialAlpha);
        picture2.setAlpha(1.0f - initialAlpha);

        // 2. האזנה לשינויים ב-SeekBar ועדכון השקיפות
        geekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float alpha = i / 100f;
                picture.setAlpha(alpha);
                picture2.setAlpha(1.0f - alpha);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnIsrael = findViewById(R.id.btnIsraeli);
        btnIsrael.setOnClickListener(this);

        sdaniel = findViewById(R.id.sdaniel);
        sdaniel.setOnCheckedChangeListener(this);

        btnSendMessage = findViewById(R.id.btnSendMessage);
        btnSendMessage.setOnClickListener(this);

        btnFollow = findViewById(R.id.btnFollow);
        btnFollow.setOnClickListener(this);

        tvUserName = findViewById(R.id.tvUserName);
    }

    @Override
    public void onClick(View view) {
        int ViewId = view.getId();
        if (ViewId == R.id.btnSendMessage)
            Toast.makeText(this, R.string.opening_chat, Toast.LENGTH_SHORT).show();

        if (ViewId == R.id.btnFollow) {
            Toast.makeText(this, R.string.started_following, Toast.LENGTH_SHORT).show();
            btnFollow.setText(R.string.following);
        }

        if (ViewId == R.id.btnIsraeli)
            Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
    if (b)
        btnIsrael.setVisibility(VISIBLE);
    else {
        btnIsrael.setVisibility(INVISIBLE);
    }
    }
}
