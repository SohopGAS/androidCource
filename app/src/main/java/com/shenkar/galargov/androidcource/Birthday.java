package com.shenkar.galargov.androidcource;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


public class Birthday extends AppCompatActivity {
    EditText logInputText;
    TextView logOutputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_example);
        logOutputText = findViewById(R.id.textView);

        // Create the observer which updates the UI.
        final Observer<List<CaptainsLogEntity>> logObserver = new Observer<List<CaptainsLogEntity>>() {
        List<CaptainsLogEntity> logObserver2;

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            // Create a calendar object that will convert the date and time value in milliseconds to date.
            Calendar calendar = Calendar.getInstance();
            StringBuilder sb = new StringBuilder();

            @Override
            public void onChanged(@Nullable final List<CaptainsLogEntity> newLog) {
                // Update the UI, in this case, a TextView.

                sb.setLength(0);
                for (CaptainsLogEntity cle : newLog) {
                    calendar.setTimeInMillis(cle.time);
                    sb.append(formatter.format(calendar.getTime()));
                    sb.append(": ");
                    sb.append(cle.log);
                    sb.append('\n');
                }

                logOutputText.setText(sb);
            }
        };

        LiveData<List<CaptainsLogEntity>> captainsLogEntityLiveData = CaptainsLogDb.getInstance(this).readCaptainsLog();

        captainsLogEntityLiveData.observe(this, logObserver);
    }

    public void onAddClick(View v) {
        Intent intent = new Intent(getBaseContext(), InputBirthOfDate.class);
        startActivity(intent);
    }

}