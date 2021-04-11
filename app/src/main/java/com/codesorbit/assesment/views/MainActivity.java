package com.codesorbit.assesment.views;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.codesorbit.assesment.R;
import com.codesorbit.assesment.databinding.ActivityMainBinding;
import com.codesorbit.assesment.interfaces.OnMyFragmentListner;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements OnMyFragmentListner {
    ActivityMainBinding viewBinding;
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        changeStatusBarColor();
        setSupportActionBar(viewBinding.toolbar.appToolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        drawerToggle = setupDrawerToggle();
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        viewBinding.mainDrawerLayout.addDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        NavController navController = Navigation.findNavController(this, R.id.activity_main_nav_host_fragment);
        BottomNavigationView bottomNavigationView = findViewById(R.id.botom_navigation);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        botomIcons(bottomNavigationView);
        viewBinding.mainNavigationView.setNavigationItemSelectedListener(item -> {
            selectDrawerItem(item);
            return true;
        });
    }

    private void selectDrawerItem(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_service:
                Toast.makeText(this, "Service", Toast.LENGTH_SHORT).show();
                break;
        }
        item.setChecked(true);
        // setTitle(item.getTitle());
        viewBinding.mainDrawerLayout.closeDrawers();
    }


    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(getResources().getColor(R.color.bg_color));
        }
    }

    private void botomIcons(BottomNavigationView bottomNavigationView) {
        Menu menuItem = bottomNavigationView.getMenu();
        MenuItem menuItem1 = menuItem.findItem(R.id.homeFragment);
        MenuItem menuItem2 = menuItem.findItem(R.id.postFragment);
        MenuItem menuItem3 = menuItem.findItem(R.id.servicesFragment);
        Glide.with(this).asBitmap().load("https://image.flaticon.com/icons/png/512/69/69524.png").apply(RequestOptions.circleCropTransform().placeholder(R.drawable.ic_launcher_background))
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        menuItem1.setIcon(new BitmapDrawable(getResources(), resource));
                    }
                });
        Glide.with(this).asBitmap().load("https://image.flaticon.com/icons/png/512/69/69524.png").apply(RequestOptions.circleCropTransform().placeholder(R.drawable.ic_launcher_background))
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        menuItem2.setIcon(new BitmapDrawable(getResources(), resource));
                    }
                });
        Glide.with(this).asBitmap().load("https://image.flaticon.com/icons/png/512/69/69524.png").apply(RequestOptions.circleCropTransform().placeholder(R.drawable.ic_launcher_background))
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        menuItem3.setIcon(new BitmapDrawable(getResources(), resource));
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, viewBinding.mainDrawerLayout, viewBinding.toolbar.appToolbar, R.string.drawer_open, R.string.drawer_close);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void OnFragmentListner(String title) {
        if (title != null) {
            viewBinding.toolbar.appToolbar.setTitle(title);
        }
    }
}