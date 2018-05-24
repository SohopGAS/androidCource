package com.shenkar.galargov.androidcource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InputBirthOfDate extends AppCompatActivity {
    EditText name, birth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        name = findViewById(R.id.NameInput);
        birth = findViewById(R.id.DateOfBirthInput);
    }

    public void onWriteClicked(View view) {
        String text = name.getText().toString();
        String text2 = birth.getText().toString();
        if (!text.isEmpty()) {
            CaptainsLogEntity logEntity = new CaptainsLogEntity();
            logEntity.setLog(text);
//            logEntity.setTime(Long.(text2));
            logEntity.setTime(20021998);
            CaptainsLogDb.getInstance(this).writeToCaptainsLog(logEntity);
            name.clearComposingText();
            birth.clearComposingText();
        }
    }
}


