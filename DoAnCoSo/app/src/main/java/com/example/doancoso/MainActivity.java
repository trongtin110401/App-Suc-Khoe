package com.example.doancoso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.FragmentTransitionSupport;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.example.doancoso.fragment.BaiTapFragment;
import com.example.doancoso.fragment.HomnayFragment;
import com.example.doancoso.fragment.MucTieuFragment;
import com.example.doancoso.fragment.NangcapFrament;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private static final int FragmentHomnay = 0;
    private static final int FragmentBaiTap= 1;
    private static final int FragmentMucTieu = 2;
    private static final int FragmentNangCap = 3;
    private int currentFragment =FragmentHomnay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.nav_toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        replaceFragment(new HomnayFragment());
        navigationView.getMenu().findItem(R.id.nav_homnay).setChecked(true);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_homnay) {
            if(currentFragment != FragmentHomnay){
                replaceFragment(new HomnayFragment());
                currentFragment = FragmentHomnay;
            }
        } else if (id == R.id.nav_baitap) {
            if(currentFragment != FragmentBaiTap){
                replaceFragment(new BaiTapFragment());
                currentFragment = FragmentBaiTap;
            }
        } else if (id == R.id.nav_muctieu) {
            if(currentFragment != FragmentMucTieu){
                replaceFragment(new MucTieuFragment());
                currentFragment = FragmentMucTieu;
            }
        } else if (id == R.id.nav_nangcap) {
            if(currentFragment != FragmentNangCap){
                replaceFragment(new NangcapFrament());
                currentFragment = FragmentNangCap;
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else super.onBackPressed();
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame,fragment);
        transaction.commit();
    }
}