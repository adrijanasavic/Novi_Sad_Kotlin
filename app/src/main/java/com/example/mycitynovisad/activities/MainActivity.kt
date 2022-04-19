package com.example.mycitynovisad.activities

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView
import android.os.Bundle
import com.example.mycitynovisad.R
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import android.annotation.SuppressLint
import android.widget.Toast
import android.content.Intent
import com.example.mycitynovisad.dialog.AboutDialog
import android.content.DialogInterface
import android.app.Activity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.example.mycitynovisad.fragments.*
import java.util.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        if (savedInstanceState == null) {
            onNavigationItemSelected(navigationView.menu.getItem(0).setChecked(true))
        }

        val actionBar = supportActionBar!!
        actionBar.title = resources.getString(R.string.app_name)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    @SuppressLint("NonConstantResourceId")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.change_lang -> {
                showChangeLang()
                Toast.makeText(this, "Change language ", Toast.LENGTH_SHORT).show()
            }
            R.id.share -> {
                val sharingIntent = Intent(Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"
                val shareBody = "https://adrijana-savic-portfolio.netlify.app/"
                val shareSubject = "https://www.youtube.com/watch?v=98-epIpyFzY"
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject)
                startActivity(Intent.createChooser(sharingIntent, "Share using"))
            }
            R.id.about -> {
                Toast.makeText(this, "Novi Sad ", Toast.LENGTH_SHORT).show()
                val dialog = AboutDialog(this@MainActivity)
                dialog.show()
            }
            else -> {}
        }
        return super.onOptionsItemSelected(item)
    }

    fun showChangeLang() {
        val listItem = arrayOf("Serbian", "English")
        val mBuilder = AlertDialog.Builder(this@MainActivity)
        mBuilder.setTitle("Choose Languages...")
        mBuilder.setSingleChoiceItems(listItem, -1) { dialogInterface: DialogInterface, i: Int ->
            if (i == 0) {
                setLocate(this@MainActivity, "sr")
                recreate()
            }
            if (i == 1) {
                setLocate(this@MainActivity, "en")
                recreate()
            }
            dialogInterface.dismiss()
        }
        val mDialog = mBuilder.create()
        mDialog.show()
    }

    fun setLocate(activity: Activity, langCode: String?) {
        val locale = Locale(langCode)
        Locale.setDefault(locale)
        val resources = activity.resources
        val config = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        val fragmentManager = supportFragmentManager
        if (id == R.id.nav_info) {
            fragmentManager.beginTransaction()
                .replace(R.id.content_frame, InformationFragment())
                .commit()
        } else if (id == R.id.nav_sights) {
            fragmentManager.beginTransaction()
                .replace(R.id.content_frame, SightsFragment())
                .commit()
        } else if (id == R.id.nav_nature_culture) {
            fragmentManager.beginTransaction()
                .replace(R.id.content_frame, NatureCultureFragment())
                .commit()
        } else if (id == R.id.nav_shop) {
            fragmentManager.beginTransaction()
                .replace(R.id.content_frame, ShopFragment())
                .commit()
        } else if (id == R.id.nav_food) {
            fragmentManager.beginTransaction()
                .replace(R.id.content_frame, FoodFragment())
                .commit()
        }
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
