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

public class NavActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavBinding binding;
    MainActivity main = new MainActivity();
    private final String TAG = "NavActivity";

    /*Starts edit */
    private TextView textViewNavName;

    public String sr_codeHolder, first_NameHolder;

    /* End Edit*/

    public String[] received_data = {"","","","","","","",""};

    DatabaseOpenHelper_2 dbHelper = new DatabaseOpenHelper_2(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "On create");

        binding = ActivityNavBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_nav);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);



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
                System.out.println(c.getString(1));
                System.out.println(c.getString(2));
                System.out.println(c.getString(4));
                System.out.println(c.getString(5));


/*start edit*/

//                sr_codeHolder  = intent.getStringExtra(MainActivity.UserEmail);;

//                Intent intent = getIntent();
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