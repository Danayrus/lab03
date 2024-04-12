package com.g313.akindinova.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    Spinner sp_from;
    Spinner sp_to;
    EditText txt_from;
    TextView txt_to;

    float n_from, n_to = 0.0f;
    String s_from, s_to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_from = findViewById(R.id.txt_input);
        txt_to = findViewById(R.id.txt_result);
        sp_from = findViewById(R.id.from);
        sp_to = findViewById(R.id.to);

        ArrayAdapter <String> adapter = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);

        adapter.add("mm");
        adapter.add("cm");
        adapter.add("m");
        adapter.add("km");


        sp_to.setAdapter(adapter);
        sp_from.setAdapter(adapter);

    }
    public void convert(View v)
    {
        try
        {
            n_from = Float.parseFloat(txt_from.getText().toString());
            s_from = (String) sp_from.getSelectedItem();
            s_to = (String) sp_to.getSelectedItem();
        }
        catch (Exception ex)
        {
            txt_to.setText("Произошла ошибка");
            return;
        }
        float m = 0.0f;
        if(s_from.equals("mm")) m = n_from/1000.0f;
        if(s_from.equals("cm")) m = n_from/100.0f;
        if(s_from.equals("m")) m = n_from/1.0f;
        if(s_from.equals("km")) m = n_from*1000.0f;

        if(s_to.equals("mm")) n_to = m*1000.0f;
        if(s_to.equals("cm")) n_to = m*100.0f;
        if(s_to.equals("m")) n_to = m*1.0f;
        if(s_to.equals("km")) n_to = m/1000.0f;

        txt_to.setText(String.valueOf(n_to));
    }

}