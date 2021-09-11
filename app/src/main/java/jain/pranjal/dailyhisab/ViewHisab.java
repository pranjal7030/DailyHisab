package jain.pranjal.dailyhisab;

/**
 * Created by hp on 6/11/2019.
 */

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewHisab extends Fragment {




    ListView Details;
    ArrayList<SimpleRow> listDatas=new ArrayList<>();
    AlertDialog.Builder alt;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view, container, false);

        ConnectDatabase db=new ConnectDatabase(getActivity());
        Cursor data=db.retrievee();
        if(data.getCount() == 0)
        {
            Toast.makeText(getActivity(),"No Hisab Is Added !! Please Add Some Hisab First",Toast.LENGTH_LONG).show();
            /*int  image=R.drawable.imagess;
            String name="No Hisab Is Added !! Please Add Some Hisab First";
            listDatas.add(new SimpleRow(name,image));*/
        }
        else
        {
            while(data.moveToNext())
            {

                int  images=R.drawable.imagess;
                listDatas.add(new SimpleRow(data.getString(0),images));


            }
        }



        Details=(ListView) view.findViewById(R.id.list);
        CustomAdapter ca=new CustomAdapter(listDatas,getActivity());
        Details.setAdapter(ca);
        return view;


    }
}










