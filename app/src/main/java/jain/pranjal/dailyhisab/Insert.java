package jain.pranjal.dailyhisab;

/**
 * Created by hp on 6/11/2019.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Insert extends AppCompatActivity  {
    Button insrt;
    EditText hisab;
    TextView date;
    ImageView cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);

        insrt = (Button) findViewById(R.id.sbmt);
        date = (TextView) findViewById(R.id.textView5);
        hisab = (EditText) findViewById(R.id.pass1);
        cal=(ImageView)findViewById(R.id.imageView3);

        Intent w=getIntent();
        String date1=w.getStringExtra("date");
        date.setText(date1);





        cal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Insert.this,CalanderActivity.class);
                i.putExtra("date","insert");
                startActivity(i);
                finish();
            }
        });



        insrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a=date.getText().toString();
                String b = hisab.getText().toString();

                ConnectDatabase dba = new ConnectDatabase(Insert.this);

                long l = dba.insert(a,b);

                if(l == -1)
                {
                    Toast.makeText(Insert.this,"Your Hisab is Not Added!! please Try again",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Insert.this,"Your Hisab is Added Successfully !! Click View Button Again To Refresh",Toast.LENGTH_LONG).show();

                }
                Intent i=new Intent(Insert.this,MainActivity.class);
                startActivity(i);
                finish();


            }
        });


    }


}

