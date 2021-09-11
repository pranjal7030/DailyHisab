package jain.pranjal.dailyhisab;

/**
 * Created by hp on 6/11/2019.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hp on 5/16/2019.
 */

public class ConnectDatabase extends SQLiteOpenHelper {

    private static String db_name = "DailyHisab_database_test1";
    private static String tbl_name ="DailyHisab_table_test1";

    private static String create_record = "create table " + tbl_name + "(dat text unique,his text);";
    private static String drop_record = "drop table if exist" + tbl_name;

    Context context;

    public ConnectDatabase(Context context) {
        super(context, db_name, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_record);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(drop_record);
        onCreate(db);

    }

    public long insert(String dat, String His)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("dat",dat);
        cv.put("his",His);
        long l=db.insert(tbl_name,null,cv);
        db.close();
        return l;
    }

    public String retrieve(String d)
    {
        String a=d;
        String data = "";
        SQLiteDatabase sqdb = this.getReadableDatabase();
        String[] col={"dat","his"};
        String Selection="dat=?";
        String[] args={a};
        Cursor c = sqdb.query(tbl_name,col,Selection,args,null,null,null,null);
        if(c == null)
        {
            data = "No Data";
        }
        else
        {
            while (c.moveToNext())
            {
                data +=c.getString(1)+"\n";
            }

        }
        sqdb.close();
        return data;
    }


    public Cursor retrievee()
    {
        SQLiteDatabase sqdb = this.getWritableDatabase();
        //String orderBy="ID desc";
       // Cursor c = sqdb.rawQuery("select * from "+tbl_name, null);
        Cursor data= sqdb.query(tbl_name,null,null,null,null,null,null,null);
         return data;
    }

    public String Uretrievee(String d)
    {
        String a=d;
        String data = "";
        SQLiteDatabase sqdb = this.getReadableDatabase();
        String[] col={"dat","his"};
        String Selection="dat=?";
        String[] args={a};
        Cursor c = sqdb.query(tbl_name,col,Selection,args,null,null,null,null);
        if(c == null)
        {
            data = "No Data";
        }
        else
        {
            while (c.moveToNext())
            {
                data += c.getString(1)+"\n";
            }

        }
        sqdb.close();
        return data;
    }


    public String retrieveall()
    {
        String data = "";
        SQLiteDatabase sqdb = this.getReadableDatabase();
        Cursor c = sqdb.rawQuery("select * from "+tbl_name, null);
        if(c == null)
        {
            data = "No Data";
        }
        else
        {
            while (c.moveToNext())
            {
                data += c.getString(0)+"\n"+"\n"+"\n"+c.getString(1)+"\n";
            }

        }
        sqdb.close();
        return data;
    }


    public boolean delete(String nm[])
    {
        SQLiteDatabase db=this.getWritableDatabase();

        long l =db.delete(tbl_name,"dat=?",nm);
        if(l == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean deleteAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        //db.delete(TABLE_NAME,null,null);

        //db.execSQL("TRUNCATE table" + TABLE_NAME);
        long d =db.delete(tbl_name,null,null);
        if(d == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }




    public long update_db(String a,String b)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues con=new ContentValues();
        con.put("dat",a);
        con.put("his",b);
        String nam[]={a};
        long l=db.update(tbl_name,con,"dat=?",nam);
        return l;
    }
}



