package jain.pranjal.dailyhisab;

/**
 * Created by hp on 6/13/2019.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hp on 6/5/2019.
 */

public class Edit extends AppCompatActivity {


    TextView date;
    Button save;
    EditText e1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);


        e1=(EditText)findViewById(R.id.editTextedit);
        date=(TextView)findViewById(R.id.textView11);
        save=(Button)findViewById(R.id.button10);

        Intent x=getIntent();
        String dateU=x.getStringExtra("date");
        date.setText(dateU);

        String d=date.getText().toString();
        String data ="";
        ConnectDatabase db = new ConnectDatabase(Edit.this);
        data = db.Uretrievee(d);
        e1.setText(data);

        Intent w=getIntent();
        String dat=w.getStringExtra("date");
        date.setText(dat);

        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String d=date.getText().toString();
                String e=e1.getText().toString();
                ConnectDatabase db = new ConnectDatabase(Edit.this);
                long l = db.update_db(d,e);

                if(l == -1)
                {
                    Toast.makeText(Edit.this,"Your Hisab is Not Edit!! please Try again",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Edit.this,"Your Hisab is Edit Successfully",Toast.LENGTH_LONG).show();
                }



            }
        });




    }
}
