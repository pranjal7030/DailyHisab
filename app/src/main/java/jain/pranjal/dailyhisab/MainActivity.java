package jain.pranjal.dailyhisab;

import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    AlertDialog.Builder builder;
    TextView t1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_View:
                    FragmentTransaction ft=getFragmentManager().beginTransaction();
                    ft.replace(R.id.content ,new ViewHisab());
                    ft.commit();

                    return true;
                case R.id.navigation_add:
                    Intent i=new Intent(MainActivity.this,Insert.class);
                    startActivity(i);
                    finish();
                    break;
                case R.id.navigation_deleteAll:
                    builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Do You Want To Delete Your All Hisab")
                            .setCancelable(false)
                            .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                    ConnectDatabase dba=new ConnectDatabase(MainActivity.this);
                                    dba.deleteAll();
                                    Toast.makeText(getApplicationContext(), "All Hisab Is Deleted Successfully !!", Toast.LENGTH_SHORT).show();
                                    FragmentTransaction ft=getFragmentManager().beginTransaction();
                                    ft.replace(R.id.content ,new ViewHisab());
                                    ft.commit();

                                }

                            })

                            .setNegativeButton("no", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                    Toast.makeText(MainActivity.this, "Your Hisab Is Safe !!", Toast.LENGTH_SHORT).show();

                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();
                    break;

            }
            return false;
        }

    };

}
