package id.ac.poliban.mi.va.sherli.contactapp_e020320023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    // view
    private FloatingActionButton fab;
    private RecyclerView contactRv;

    // db
    private DbHelper dbHelper;

    // adapter
    private AdapterContact adapterContact;

    // sort category
    private String sortByNewest = Constants.C_ADDED_TIME + " DESC";
    private String sortByOldest = Constants.C_ADDED_TIME + " ASC";
    private String sortByNameAsc = Constants.C_NAME + " ASC";
    private String sortByNameDesc = Constants.C_NAME + " DESC";

    // set current sort order
    private String currentSort = sortByNewest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init db
        dbHelper = new DbHelper(this);

        //initialization
        fab = findViewById(R.id.fab);
        contactRv = findViewById(R.id.contactRv);

        contactRv.setHasFixedSize(true);

        // add listener
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // move to new activity to add contact
                Intent intent = new Intent(MainActivity.this,AddEditContact.class);
                intent.putExtra("isEditMode",false);
                startActivity(intent);
            }
        });

        loadData(currentSort);
    }

    private void loadData(String currentSort) {
        adapterContact = new AdapterContact(this,dbHelper.getAllData(currentSort));
        contactRv.setAdapter(adapterContact);

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData(currentSort); // refresh data
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_top_menu,menu);

        // get search item from menu
        MenuItem item = menu.findItem(R.id.searchContact);
        //  search area
        SearchView searchView = (SearchView) item.getActionView();
        // set max value for width

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchContact(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchContact(newText);
                return true;
            }
        });

        return true;

    }

    private void searchContact(String query) {
        adapterContact = new AdapterContact(this,dbHelper.getSearchContact(query));
        contactRv.setAdapter(adapterContact);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.deleteAllContact:
                dbHelper.deleteAllContact();
                onResume();
                break;
            case R.id.sortContact:
                sortDialog();
                break;
        }
        return true;
    }

    private void sortDialog() {

        // option for alert dialog
        String[] option = {"Newest","Oldest","Name Asc","Name Desc"};

        // alert dialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sort By");
        builder.setItems(option, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0){
                    loadData(sortByNewest);
                }else if (which == 1){
                    loadData(sortByOldest);
                }else if (which == 2){
                    loadData(sortByNameAsc);
                }else if (which == 3){
                    loadData(sortByNameDesc);
                }
            }
        });
        builder.create().show();

    }

    // add dependency
    // add colour code
    // design main activity
    // create new activity called AddEditContact
    // design AddEditContact activity

    // To day we show our SQLite Data in RecyclerView
    // For recyclerview item we need a item layout
    // add recyclerview in main activity
    // Create Model Class for data
    // create Adapter class to show data in recyclerview

    // get data from sql and show data in recyclerview by adapter

    // to get data we need sql command in db helper
    // run app

    // Create activity for detail of contact

    // today we implement edit or update data function with swap layout in recyclerview
    // first add dependency for swap layout
    // after sync project, design swap layout in row_contact_layout, item of recyclerview
    // now modify in contact adapter
    // now run app to see what we done
    // now work with edit option
    // now get data from AddEditActivity
    // now create sql command in DB helper class to update data
    // run app
    // now modify some code
    // our app run properly
    // next video we will See, Delete functionality.

    // Today We implement Delete Function
    // Delete All data or specific Data from database
    // First create Query in Db Helper class
    // now set function on delete button
    // for delete all data we add delete button on action bar
    // create option menu
    // now run app
    // next video we will add search functionality.

    // we will implement search function in app
    // first add search view in menu
    // create search query in dbHelper class
    // we done, now run app
    // we have some problem in sql query.

    // Today we will implement sort function
    // First add sort option in menu
    // we done for our function

}