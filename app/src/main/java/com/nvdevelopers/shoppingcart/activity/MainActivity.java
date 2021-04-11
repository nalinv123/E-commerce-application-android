package com.nvdevelopers.shoppingcart.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.nvdevelopers.shoppingcart.R;
import com.nvdevelopers.shoppingcart.fragments.AllCategory;
import com.nvdevelopers.shoppingcart.fragments.Cart;
import com.nvdevelopers.shoppingcart.fragments.Home;
import com.nvdevelopers.shoppingcart.fragments.MyAccount;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        loadFragment(new Home());

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.bottom_navigation_menu_home:
                fragment = new Home();
                break;
            case R.id.bottom_navigation_menu_all_category:
                fragment = new AllCategory();
                break;
            case R.id.bottom_navigation_menu_cart:
                fragment = new Cart();
                break;
            case  R.id.bottom_navigation_menu_my_account:
                fragment = new MyAccount();
                break;
        }

        return loadFragment(fragment);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
