package com.bsu.bsu_fproj;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.bsu.bsu_fproj.databinding.ActivityNavBinding;

import org.w3c.dom.Text;

public class NavActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavBinding binding;
    MainActivity main = new MainActivity();
    private final String TAG = "NavActivity";

    /*Starts edit */

    private TextView textViewNavName;
    public String sr_codeHolder, first_NameHolder;
    TextView Name;
    TextView navName;

    /* End Edit*/

    public String[] received_data = {"","","",""};
//    public TextView navName = (TextView) findViewById(R.id.navName);
//    public TextView navProgram = (TextView) findViewById(R.id.navProgram);
//    public TextView navYearLvl = (TextView) findViewById(R.id.navYearLvl);

//     navName = (TextView) findViewById(R.id.navName);
//    public TextView navProgram = (TextView) findViewById(R.id.navProgram);
//    public TextView navYearLvl = (TextView) findViewById(R.id.navYearLvl);
    DatabaseOpenHelper_2 dbHelper = new DatabaseOpenHelper_2(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "On create");

        setContentView(R.layout.nav_header_nav);


        binding = ActivityNavBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
/*Start edit*/
        Name =(TextView)findViewById(R.id.navName);

//        System.out.println(Name);

/*End edit*/
        setSupportActionBar(binding.appBarNav.toolbar);
        binding.appBarNav.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,
                R.id.nav_news,
                R.id.nav_schedule,
                R.id.nav_links,
                R.id.nav_contacts,
                R.id.nav_logout)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_nav);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        System.out.println(navName);


        Name = navigationView.findViewById(R.id.navName);
        Name = drawer.findViewById(R.id.navName);


//        Name.setText(""+received_data[0] + " " + received_data[1]);



        System.out.println(Name);

        // getting extras from intent before activity starts
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String value = extras.getString("name");
        }

        System.out.println("Success Getting data");

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        System.out.println("Executed Here");
        Cursor c = null;
        try {
            db = dbHelper.getReadableDatabase();
            c = db.rawQuery("select * from student_tbl where sr_code="+ extras.getString("name"), new String[]{});
            c.moveToFirst();
            do {
                System.out.println(c.getString(2));
                System.out.println(c.getString(1));
                System.out.println(c.getString(4));
                System.out.println(c.getString(5));
//
//                System.out.println(sr_codeHolder);
//                System.out.println(sr_code);

                received_data[0] = c.getString(2);
                received_data[1] = c.getString(1);
                received_data[2] = c.getString(4);
                received_data[3] = c.getString(5);

/*start edit*/
                Intent intent = getIntent();
                sr_codeHolder  = intent.getStringExtra("name");
//                Intent intent = getIntent();

                System.out.println(sr_codeHolder + "Success sending ");
//
//                textViewNavName = findViewById(R.id.navName);
//
//                Account account = (Account) intent.getSerializableExtra("name");
//                textViewNavName.setText(getString(R.string.sign_in) + " " + account.getFirst_Name());

/*end edit*/

            } while (c.moveToNext());

            db.close();

        } finally {

        }
//        Name.setText(""+received_data[0] + " " + received_data[1]);



        // Setting TextView as the data inside the database
        /*https://stackoverflow.com/questions/34973456/how-to-change-text-of-a-textview-in-navigation-drawer-header#comment117348821_38418531*/
        NavigationView stack_navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = stack_navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.navName);
        TextView navProgram = (TextView) headerView.findViewById(R.id.navProgram);
        TextView navYearLvl= (TextView) headerView.findViewById(R.id.navYearLvl);
        navUsername.setText(received_data[0] + " " +received_data[1]);
        navProgram.setText(received_data[2]);
        navYearLvl.setText(received_data[3]);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_nav);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}