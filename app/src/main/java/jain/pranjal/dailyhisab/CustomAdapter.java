package jain.pranjal.dailyhisab;

/**
 * Created by hp on 6/23/2019.
 */

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hp on 3/29/2019.
 */

public class CustomAdapter extends BaseAdapter implements View.OnClickListener{

    ArrayList<SimpleRow> listDatas;
    Context c;
    ViewHisab v=new ViewHisab();
    MainActivity mainActivity=new MainActivity();
    App app=new App();
    LayoutInflater layoutInflater;
    AlertDialog.Builder alt;

    public CustomAdapter(ArrayList<SimpleRow> listDtas, Context context) {
        this.listDatas = listDtas;
        this.layoutInflater = LayoutInflater.from(context);
        this.c = context;
    }


    @Override
    public int getCount() {
        return listDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return listDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.single_row, parent, false);

       TextView title = (TextView) convertView.findViewById(R.id.textView3);
        title.setText(listDatas.get(position).getTitles());

       ImageView image = (ImageView) convertView.findViewById(R.id.imageView);
        image.setImageResource(listDatas.get(position).getImage());

        image.setOnClickListener(this);
        SimpleRow simpleRow = (SimpleRow) getItem(position);
        image.setTag(simpleRow);
        alt = new AlertDialog.Builder(c);
        return convertView;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.imageView:
                SimpleRow simpleRow = (SimpleRow) v.getTag();
                // Toast.makeText(c,simpleRow.getTitles(),Toast.LENGTH_LONG).show();
                ConnectDatabase db = new ConnectDatabase(c);
                final String a = simpleRow.getTitles();
                Toast.makeText(c, a, Toast.LENGTH_LONG).show();
                alt.setMessage("do you want to close the application")
                        .setCancelable(true)
                        .setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Intent j = new Intent(c, Edit.class);
                                j.putExtra("date", a);
                                c.startActivity(j);


                            }

                        })

                        .setNegativeButton("Delete", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                                ConnectDatabase dba = new ConnectDatabase(c);
                                String nam[] = {a};

                                boolean b = dba.delete(nam);

                                if (b == true) {
                                    Toast.makeText(c, "Hisab Deleted successfully !!", Toast.LENGTH_LONG).show();




                                } else {
                                    Toast.makeText(c, "Hisab not Deleted !! Something is Wrong.", Toast.LENGTH_LONG).show();


                                }


                            }

                        });


                String data = "";
                data = db.retrieve(a);
                AlertDialog alert = alt.create();
                alt.setMessage("Data");
                alt.setMessage(data);
                alt.show();
                break;


        }



    }



}




