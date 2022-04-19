package com.example.mycitynovisad.splashScreen

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.preference.PreferenceManager
import android.preference.PreferenceManager.*
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mycitynovisad.R
import com.example.mycitynovisad.activities.MainActivity
import java.io.IOException
import java.io.InputStream
import java.util.*

class SplashScreen : AppCompatActivity() {
    private var topAnim: Animation? = null
    private var bottomAnim: Animation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemUI()
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim)
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim)
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val splashTime = prefs.getString(getString(R.string.splashtime_key), "3000")
        val splash = prefs.getBoolean(getString(R.string.splash_key), true)
        if (splash) {
            setContentView(R.layout.splash_screen)
            val imageView = findViewById<ImageView>(R.id.imageSplash)
            val splashTxt = findViewById<TextView>(R.id.textView)
            val `is`: InputStream
            try {
                `is` = assets.open("novi_sad.jpg")
                val drawable = Drawable.createFromStream(`is`, null)
                imageView.setImageDrawable(drawable)
                imageView.animation = topAnim
                splashTxt.animation = bottomAnim
            } catch (e: IOException) {
                e.printStackTrace()
            }
            Timer().schedule(object : TimerTask() {
                override fun run() {
                    startActivity(Intent(this@SplashScreen, MainActivity::class.java))
                    finish()
                }
            }, splashTime!!.toInt().toLong())
        } else {
            startActivity(Intent(this@SplashScreen, MainActivity::class.java))
            finish()
        }
    }

    private fun hideSystemUI() {
        val decorView = window.decorView
        decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }
}