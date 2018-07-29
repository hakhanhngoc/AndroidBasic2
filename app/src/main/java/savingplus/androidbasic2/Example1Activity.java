package savingplus.androidbasic2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.provider.ContactsContract;
import android.net.Uri;
import android.app.Activity;
import android.content.CursorLoader;
import android.database.Cursor;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Example1Activity extends AppCompatActivity {
    private ListView lv;
    private String [] listContact_tmp ={"0984696469","968123568","1667710571","+84974361395"};

    private static final Uri CONTACTS_URI = ContactsContract.Contacts.CONTENT_URI;
    //private String [] listContact = new String[]{ContactsContract.Contacts.DISPLAY_NAME};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example1);
        Uri uri = Uri.parse("content://contacts/people");
        ArrayList<String> listContact=new ArrayList<String>();
        CursorLoader loader=new CursorLoader(this, uri, null,null,null,null);
        Cursor c1=loader.loadInBackground();
        c1.moveToFirst();
        while (c1.isAfterLast()==false){
            String s ="";
            String idColumnName=ContactsContract.Contacts._ID;
            int idIndex=c1.getColumnIndex(idColumnName);
            s=c1.getString(idIndex)+" - ";
            String nameColumnName=ContactsContract.Contacts.DISPLAY_NAME;
            int nameIndex=c1.getColumnIndex(nameColumnName);
            s+=c1.getString(nameIndex);

            c1.moveToNext();
            listContact.add(s);
        }
        c1.close();

        lv=(ListView)findViewById(R.id.lvPhoneNumber);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listContact_tmp);
        lv.setAdapter(arrayAdapter);
    }
/*    public void showAllContacts1()
    {
        Uri uri=Uri.parse("content://contacts/people");
        ArrayList<String> list=new ArrayList<String>();
        CursorLoader loader=new
                CursorLoader(this, uri, null, null, null, null);
        Cursor c1=loader.loadInBackground();
        c1.moveToFirst();
        while(c1.isAfterLast()==false){
            String s="";
            String idColumnName=ContactsContract.Contacts._ID;
            int idIndex=c1.getColumnIndex(idColumnName);
            s=c1.getString(idIndex)+" - ";
            String nameColumnName=ContactsContract.Contacts.DISPLAY_NAME;
            int nameIndex=c1.getColumnIndex(nameColumnName);
            s+=c1.getString(nameIndex);
            c1.moveToNext();
            list.add(s);
        }
        c1.close();
        ListView lv=(ListView) findViewById(R.id.listView1);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
    }*/

}

