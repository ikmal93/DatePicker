package id.co.wmotion.datepicker;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Calendar date;
    int day, month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText chooseDate = (EditText) findViewById(R.id.chooseDate);
        date = Calendar.getInstance();

        day = date.get(Calendar.DAY_OF_MONTH);
        month = date.get(Calendar.MONTH);
        year = date.get(Calendar.YEAR);

        month = month + 1;
        Log.d("Ikmal", "HASIL : " + month);

        chooseDate.setText(day + "/" + month + "/" + year);

        chooseDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int years, int monthOfYear, int dayOfMonth) {
                        monthOfYear = monthOfYear + 1;
                        chooseDate.setText(dayOfMonth + "/" + monthOfYear + "/" + years);
                        Log.d("Ikmal", "HASIL : " + monthOfYear);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

    }
}
