package com.example.languageradiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }


    private void init(){
        final RadioGroup radioGroup = findViewById(R.id.radioGroup);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radioGroup.getCheckedRadioButtonId();
                switch (selectedId){
                    case R.id.radioButtonRu:
                        switchLocale("ru");
                        break;
                    case R.id.radioButtonEn:
                        switchLocale("en");
                        break;
                }
            }
        });

    }


    private void switchLocale(String language){
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }
}
