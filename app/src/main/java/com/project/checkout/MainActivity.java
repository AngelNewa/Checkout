package com.project.checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
TextView ChkIn, ChkOut, TvResult;
EditText etAdult, etChild, etRoom;
Spinner spinRoomType;
Button btnCalculate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinRoomType = findViewById(R.id.spinRoomType);
        ChkIn = findViewById(R.id.ChkIn);
        ChkOut = findViewById(R.id.ChkOut);
        spinRoomType = findViewById(R.id.spinRoomType);
        etAdult = findViewById(R.id.etAdult);
        etChild = findViewById(R.id.etChild);
        etRoom = findViewById(R.id.etRoom);

        String room [] = {"Deluxe", "Presidential", "Premium"};
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, room
        );

        spinRoomType.setAdapter(adapter);
        ChkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker();
            }
        });

        ChkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker();
            }
        });
    }

    private void loadDatePicker(){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this, this, year, month, day);
        datePickerDialog.show();

    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = "Check in Date: " + (month+1)  + "/" + dayOfMonth + "/" + year;
        ChkIn.setText(date);

        String date2 = "Check out Date: " + (month+1)  + "/" + dayOfMonth + "/" + year;
        ChkOut.setText(date2);

    }



}
