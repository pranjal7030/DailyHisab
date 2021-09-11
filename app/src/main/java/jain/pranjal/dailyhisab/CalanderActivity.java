package jain.pranjal.dailyhisab;

/**
 * Created by hp on 6/11/2019.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.TextView;

/**
 * Created by hp on 5/25/2019.
 */

public class CalanderActivity extends AppCompatActivity {

    private static final String TAG="CalanderActivity";

    CalendarView call;
    TextView t1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);
        call=(CalendarView) findViewById(R.id.calendarView);
        t1=(TextView)findViewById(R.id.textView);
        Intent w = getIntent();
        String a = w.getStringExtra("date");
        t1.setText(a);

        call.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                int d = dayOfMonth;
                int m = month;
                int y = year;
                String date = d + "/" + (m + 1) + "/" + y;
                Log.d(TAG, "onSelectedDayChange: mm/dd/yyyy: " + date);

                String b = t1.getText().toString();

                switch (b) {
                    case "insert":
                        Intent i = new Intent(CalanderActivity.this, Insert.class);
                        i.putExtra("date", date);
                        startActivity(i);
                        finish();
                        break;




                }

            }

        });
    }
}