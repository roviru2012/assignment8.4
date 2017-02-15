package ravi.com.myassignment84;

import android.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends FragmentActivity implements CustomDialog.NewContactListener {


    FragmentManager fm = getFragmentManager();
    ListView listview;
    ArrayList<String> contacts;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listview = (ListView) findViewById(R.id.listView);
        List<String> list = Arrays.asList(getResources().getStringArray(R.array.listview));
        contacts = new ArrayList<>(list);

        adapter = new ArrayAdapter<>(this, R.layout.list_item, contacts);
        listview.setAdapter(adapter);

    }




    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }



    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


//noinspection SimplifiableIfStatement

        if (id == R.id.add) {
            CustomDialog cd = new CustomDialog();
            cd.show(fm, "Dialog");
            return true;
        }


        return super.onOptionsItemSelected(item);

    }



    @Override

    public void onFinishDialog(String text) {

        contacts.add(text);

        listview.setAdapter(adapter);
    }

}
