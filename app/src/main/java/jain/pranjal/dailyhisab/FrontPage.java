package jain.pranjal.dailyhisab;

/**
 * Created by hp on 6/14/2019.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by hp on 3/14/2019.
 */

public class FrontPage extends AppCompatActivity {
    Button begin;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frontpage);
        begin = (Button) findViewById(R.id.bt);
        begin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(FrontPage.this,MainActivity.class);
                startActivity(i);
                finish();


            }
        });
    }
}
