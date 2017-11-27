package com.example.shmily.minionsdelta;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.os.EnvironmentCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public final static int ALBUM_REQUEST_CODE=1;
    public final static int CROP_REQUEST=2;
    public final static int CAMERA_REQUEST_CODE=3;
    public  static String SAVED_IMAGE_DIR_PATH=Environment.getExternalStorageDirectory().getPath()+"/AppName/camera/";
    String cameraPath;
    public Button quit;
    private Context mContext;
    private AlertDialog alert=null;
    private AlertDialog.Builder builder = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext=MainActivity.this;
        quit=(Button ) findViewById(R.id.nav_quit);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_camera:{

                String state = Environment.getExternalStorageState();
                if (state.equals(Environment.MEDIA_MOUNTED)) {
                    cameraPath = SAVED_IMAGE_DIR_PATH + System.currentTimeMillis() + ".png";
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    String out_file_path = SAVED_IMAGE_DIR_PATH;
                    File dir = new File(out_file_path);
                    if (!dir.exists()) {
                        dir.mkdir();

                    }
                    Uri uri = Uri.fromFile(new File(cameraPath));
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

                    startActivityForResult(intent, CAMERA_REQUEST_CODE);
                    break;

                }
            }
            case R.id.nav_gallery:{
                Intent intent= new Intent(Intent.ACTION_PICK,null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,ALBUM_REQUEST_CODE);
                break;

            }
            case R.id.nav_manage:{
                break;


            }
            case R.id.nav_slideshow:{
                Intent intent=new Intent();
                intent .setClass(MainActivity.this,ListActivity.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.nav_setting:{
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,manageActivity.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.nav_share:{
                break;
            }
            case R.id.nav_send:{
                break;
            }
            case R.id.nav_quit:{
                alert = null;
                builder = new AlertDialog.Builder(mContext);
                alert = builder
                        .setMessage("是否退出？")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                return ;
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent=new Intent();
                                intent.setAction(Intent.ACTION_MAIN);
                                intent.addCategory(Intent.CATEGORY_HOME);
                                startActivity(intent);
                                finish();
                            }
                        }).create();             //创建AlertDialog对象
                alert.show();                    //显示对话框




                break;
            }
            case R.id.nav_message:{
                Uri uri=Uri.parse("tel:10086");
                Intent it=new Intent(Intent.ACTION_DIAL,uri);
                startActivity(it);
            }
            default:
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
