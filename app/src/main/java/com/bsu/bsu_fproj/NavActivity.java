package com.bsu.bsu_fproj;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.bsu.bsu_fproj.databinding.ActivityNavBinding;
import com.bsu.bsu_fproj.ui.home.HomeFragment;
import com.bsu.bsu_fproj.ui.menu_grades.GradesFragment;
import com.google.android.material.navigation.NavigationView;

public class NavActivity extends AppCompatActivity{
//    implements NavigationView.OnNavigationItemSelectedListener

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavBinding binding;
    MainActivity main = new MainActivity();
    private final String TAG = "NavActivity";

    // DATABASE
    public String sr_codeHolder;
    TextView Name;
    public String[] received_data = {"","","","",""};
    public String[] received_grade ={"","","","","","","",""};

    DatabaseOpenHelper_2 dbHelper = new DatabaseOpenHelper_2(this);

    //for profile pic
    int srcID;

    //for carousel



//    timer
    CountDownTimer ctimer = null;
//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item){
//        int id = item.getItemId();
//        if (id == R.id.nav_googleClass){
//            this.finish();
//        }
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
    // declaration for menu buttons


    // Logout the user using the three dots in navbar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.action_logout:{
                this.finish();
                return true;
            }
//            case R.id.nav_googleClass:{
//                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.classroom");
//                if (launchIntent != null){
//                    startActivity(launchIntent);
//                }else{
//                    Toast.makeText(NavActivity.this, "There is no package", Toast.LENGTH_LONG).show();
//                }
//                return true;
//            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

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

        /*Start Care Links*/
//        TextView text1 = (TextView) findViewById(R.id.textView2);
        /*text1.setMovementMethod(LinkMovementMethod.getInstance());*/

        /*End Care Links   */

        // OPENS GOOGLE CLASSROOM APP
        setSupportActionBar(binding.appBarNav.toolbar);
        binding.appBarNav.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //logout
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.classroom");
//                Intent launchIntent = getPackageManager().getLeanbackLaunchIntentForPackage("com.google.android.apps.classroom");
                if (launchIntent != null){
                    startActivity(launchIntent);
                }else{
                    Toast.makeText(NavActivity.this, "There is no package", Toast.LENGTH_LONG).show();
                }

            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
//        navigationView.setNavigationItemSelectedListener(this);


         /*Passing each menu ID as a set of Ids because each
         menu should be considered as top level destinations.*/
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,
                R.id.nav_news,
                R.id.nav_schedule,
                R.id.nav_links,
                R.id.nav_contacts)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_nav);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        Name = navigationView.findViewById(R.id.navName);
        Name = drawer.findViewById(R.id.navName);

        //for setting image in nav drawer

        // getting extras from intent before activity starts
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String value = extras.getString("name");
        }

        System.out.println("Success Getting data_Nav");

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        System.out.println("Executed Here_Nav");
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
                System.out.println(c.getString(7));

                received_data[0] = c.getString(2);
                received_data[1] = c.getString(1);
                received_data[2] = c.getString(4);
                received_data[3] = c.getString(5);
                received_data[4] = c.getString(7);

                Intent intent = getIntent();
                sr_codeHolder  = intent.getStringExtra("name");

                System.out.println(sr_codeHolder + "Success sending ");


            } while (c.moveToNext());

            db.close();

        } finally {

        }

        // Setting TextView in the nav profile as the data inside the database
        /*https://stackoverflow.com/questions/34973456/how-to-change-text-of-a-textview-in-navigation-drawer-header#comment117348821_38418531*/
        NavigationView stack_navigationView = (NavigationView) findViewById(R.id.nav_view);

        View headerView = stack_navigationView.getHeaderView(0);
        ImageView navStud_img = (ImageView) headerView.findViewById(R.id.navStud_img);
        TextView navUsername = (TextView) headerView.findViewById(R.id.navName);
        TextView navProgram = (TextView) headerView.findViewById(R.id.navProgram);
        TextView navYearLvl= (TextView) headerView.findViewById(R.id.navYearLvl);


        //parse name+sr_code
        String tempName = "profile_" + received_data[1] + "_" + sr_codeHolder; //Aguilar_1906341


        //get the int ID of the resource
        int id = getResources().getIdentifier(tempName.toLowerCase().trim(), "drawable", getPackageName());
        srcID = id;

        //plug it in setImageResource
        navStud_img.setImageResource(id);

        /*Displaying the data based from the specific name+sr_code */
        navUsername.setText(received_data[0] + " " + received_data[1]);
        navProgram.setText(received_data[2]);
        navProgram.setText(received_data[2]);
        navYearLvl.setText(received_data[3]);

        // saved the data in HomeFragment using instance (same as sending data in Homefragment)
        new HomeFragment().newInstance(received_data[4], //getting liability
                extras.getString("name") );//getting SR_CODE


        //Make arrays for
        //received_grades[]
        c = null;
        try {
            db = dbHelper.getReadableDatabase();
            c = db.rawQuery("select * from grades_tbl where sr_code="+ extras.getString("name"), new String[]{});
            c.moveToFirst();
            do {
                System.out.println(c.getString(2));
                System.out.println(c.getString(1));
                System.out.println(c.getString(4));
                System.out.println(c.getString(5));
                System.out.println(c.getString(7));

                received_grade[0] = c.getString(1);
                received_grade[1] = c.getString(2);
                received_grade[2] = c.getString(3);
                received_grade[3] = c.getString(4);
                received_grade[4] = c.getString(5);
                received_grade[5] = c.getString(6);
                received_grade[6] = c.getString(7);
                received_grade[7] = c.getString(8);

            } while (c.moveToNext());

            db.close();

        } finally {

        }

        // Sending Grade Data to Grades Fragment
        new GradesFragment().newInstance(received_grade);





        /*Display the pic in student id dialog*/
        /*ImageView n = (ImageView) findViewById(R.id.dialog_studentid_img);
        n.setImageResource(id);*/

//
//        System.out.println("Before clicking stud_ID");
//        ImageButton btn_studentid = (ImageButton) findViewById(R.id.student_id_btn);
//        btn_studentid.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentManager manager=getSupportFragmentManager();
//                dialog_studentID_class dialog = new dialog_studentID_class().newInstance(srcID);
//                System.out.println(" clicking stud_ID");
//                dialog.show(manager, "msgDial");
//
//            }
//        });






    }


    void startTimer(){
        ctimer = new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                NavActivity.this.finish();
                Toast t = Toast.makeText(NavActivity.this,"You've been logged out due to inactivity",Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                t.show();
            }
        };
        ctimer.start();
    }

    void cancelTimer(){
        if(ctimer!=null){
            ctimer.cancel();
        }
    }

//
//    private void setupID(){
//        ImageButton btn = (ImageButton) findViewById(R.id.student_id_btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentManager manager=getSupportFragmentManager();
//                dialog_studentID_class dialog = new dialog_studentID_class().newInstance(srcID);
//
//                dialog.show(manager, "msgDial");
//
//            }
//        });
//    }




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

    @Override
    protected void onResume() {
        super.onResume();
        cancelTimer();
    }

    // Returns the user
    // should cancel the timer method here
    @Override
    protected  void onDestroy(){
        Log.d(TAG, "onDestroy");
        super.onDestroy();
        cancelTimer();

    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop");
        //  Logout the user due to inactivity
        // Timer
        startTimer();

    }

//    public void openclass(View view){
//        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.classroom");
//        if (launchIntent != null){
//            startActivity(launchIntent);
//        }else{
//            Toast.makeText(NavActivity.this, "There is no package", Toast.LENGTH_LONG).show();
//        }
//    }

}