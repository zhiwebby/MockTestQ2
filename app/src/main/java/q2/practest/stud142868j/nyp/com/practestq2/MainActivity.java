package q2.practest.stud142868j.nyp.com.practestq2;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spContact;
    String[] strArray;
    ArrayAdapter<CharSequence> adapter;
    Menu myMenu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spContact = (Spinner) spContact.findViewById(R.id.spContact);
        Resources myRes = this.getResources();
        strArray = myRes.getStringArray(R.array.contact);

        adapter = ArrayAdapter.createFromResource(this, R.array.contact, R.layout.support_simple_spinner_dropdown_item);
        spContact.setAdapter(adapter);
        spContact.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(getApplicationContext(), spContact.getItemAtPosition(position).toString() + " has been selected", Toast.LENGTH_LONG);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        this.myMenu = menu;
        addRegularMenuItems(menu);


        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void addRegularMenuItems(Menu menu)
    {
        int index = Menu.FIRST;
        menu.add(index, index, index, "Login");
        menu.add(index, index + 1, index + 1, "Register");
        menu.add(index, index+2, index+2, "Manage Pin");
        menu.add(index, index + 3, index + 3, "About");
        registerForContextMenu(menu);
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        menu.setHeaderTitle("Manage Pin");

        menu.add(200, 200, 200, "Change pin");
                menu.add(200, 300, 300, "Forgot pin");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
