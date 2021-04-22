package com.nvdevelopers.shoppingcart.activity

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.nvdevelopers.shoppingcart.R
import com.nvdevelopers.shoppingcart.fragments.Home
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.nvdevelopers.shoppingcart.fragments.AllCategory
import com.nvdevelopers.shoppingcart.fragments.Cart
import com.nvdevelopers.shoppingcart.fragments.MyAccount

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(Home())
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView?.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED)
        bottomNavigationView?.setOnNavigationItemSelectedListener(this)
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit()
            return true
        }
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        when (item.itemId) {
            R.id.bottom_navigation_menu_home -> fragment = Home()
            R.id.bottom_navigation_menu_all_category -> fragment = AllCategory()
            R.id.bottom_navigation_menu_cart -> fragment = Cart()
            R.id.bottom_navigation_menu_my_account -> fragment = MyAccount()
        }
        return loadFragment(fragment)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}