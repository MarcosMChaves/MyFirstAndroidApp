package com.example.myfirstandroidapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editTextText;
    EditText editTextNumber;
    EditText editTextPassword;
    CheckBox checkMark;
    RadioGroup radioGroup;
    RadioButton radioLeft;
    RadioButton radioRight;
    SwitchCompat switchKey;
    ToggleButton toggleOnOff;
    Button btnClear;

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

        editTextText = findViewById(R.id.editTextText);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextPassword = findViewById(R.id.editTextPassword);

        checkMark = findViewById(R.id.checkMark);
        radioGroup = findViewById(R.id.radioGroup);
        radioLeft = findViewById(R.id.radioLeft);
        radioRight = findViewById(R.id.radioRight);
        switchKey = findViewById(R.id.switchKey);
        toggleOnOff = findViewById(R.id.toggleOnOff);

        btnClear = findViewById(R.id.btnClear);

        btnClear.setOnClickListener(v -> {
            editTextText.setText("");
            editTextNumber.setText("");
            editTextPassword.setText("");

            checkMark.setChecked(false);
            checkMark.setText(R.string.checkUnchecked);

            radioLeft.setChecked(true);

            switchKey.setChecked(false);
            switchKey.setText(R.string.switchLeft);

            toggleOnOff.setChecked(false);
        });

        checkMark.setOnClickListener(v -> {
            if(checkMark.isChecked()){
                checkMark.setText(R.string.checkChecked);
            } else{
                checkMark.setText(R.string.checkUnchecked);
            }
        });

        switchKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchKey.isChecked()){
                    switchKey.setText(R.string.switchRight);
                } else{
                    switchKey.setText(R.string.switchLeft);
                }
            }
        });

    }
}