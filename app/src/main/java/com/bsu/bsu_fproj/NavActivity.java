package com.bsu.bsu_fproj;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.bsu.bsu_fproj.databinding.ActivityNavBinding;
import com.bsu.bsu_fproj.ui.home.HomeFragment;
import com.google.android.material.navigation.NavigationView;

public class NavActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavBinding binding;
    MainActivity main = new MainActivity();
    private final String TAG = "NavActivity";

    // DATABASE
    public String sr_codeHolder;
    TextView Name;
    public String[] received_data = {"","","","",""};
    DatabaseOpenHelper_2 dbHelper = new DatabaseOpenHelper_2(this);

    //for profile pic
    int srcID;


//    timer
    CountDownTimer ctimer = null;
    // declaration for menu buttons


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
        TextView text1 = (TextView) findViewById(R.id.textView2);
        /*text1.setMovementMethod(LinkMovementMethod.getInstance());*/

        /*End Care Links   */


        setSupportActionBar(binding.appBarNav.toolbar);
        binding.appBarNav.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //logout
                Intent logout = new Intent (NavActivity.this, MainActivity.class);
                startActivity(logout);
                finish();
                Toast.makeText(NavActivity.this, "Successfully logged out.", Toast.LENGTH_SHORT).show();
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;


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



                //Make arrays
                //received_grades[]
                //received_subjects[]

                Intent intent = getIntent();
                sr_codeHolder  = intent.getStringExtra("name");

                System.out.println(sr_codeHolder + "Success sending ");


            } while (c.moveToNext());

            db.close();

        } finally {

        }

        // Setting TextView as the data inside the database
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
        new HomeFragment().newInstance(received_data[4]);




        /*Display the pic in student id dialog*/
        /*ImageView n = (ImageView) findViewById(R.id.dialog_studentid_img);
        n.setImageResource(id);*/
        /*Calling the Liabilities Method*/
//        setupSetMessage();
//        setupID();
//        System.out.println("Before clicking Liabities");
//        ImageButton btn_liabilities = (ImageButton) findViewById(R.id.liabilities_btn);
//        btn_liabilities.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentManager manager=getSupportFragmentManager();
//                dialog_liabilities_class dialog = new dialog_liabilities_class().newInstance(received_data[4]);
//                System.out.println("clicking Liabities");
//                dialog.show(manager, "msgDial");
//
//            }
//        });
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

    @Override
    protected  void onDestroy(){
        super.onDestroy();

    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop");
        //  Logout the user due to inactivity
        // Timer
        startTimer();

    }

}