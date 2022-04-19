package com.example.mycitynovisad.activities

import android.content.DialogInterface
import com.example.mycitynovisad.objects.Food
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.example.mycitynovisad.R
import android.widget.TextView
import androidx.cardview.widget.CardView
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import android.content.Intent
import com.example.mycitynovisad.activities.DetailActivity
import com.example.mycitynovisad.objects.Attraction
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mycitynovisad.adapters.FoodAdapter
import com.example.mycitynovisad.fragments.FoodFragment
import com.example.mycitynovisad.adapters.ShopAdapter
import com.example.mycitynovisad.fragments.ShopFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycitynovisad.adapters.RecyclerAdapter
import com.example.mycitynovisad.fragments.SightsFragment
import android.text.Spannable
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import com.example.mycitynovisad.fragments.NatureCultureFragment
import androidx.appcompat.app.AppCompatActivity
import android.text.style.UnderlineSpan
import android.view.animation.Animation
import android.content.SharedPreferences
import android.net.Uri
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import com.example.mycitynovisad.activities.MainActivity
import java.util.*

class DetailActivity : AppCompatActivity() {
    private var description: String? = null
    private val address: String? = null
    private var category = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val detailIntent = intent
        category = detailIntent.getIntExtra(getString(R.string.category), DEFAULT_NUMBER)
        val imageId = detailIntent.getIntExtra(getString(R.string.image_id), NO_IMAGE_PROVIDED)
        val name = detailIntent.getStringExtra(getString(R.string.name))
        description = detailIntent.getStringExtra(getString(R.string.description))
        val address = detailIntent.getStringExtra(getString(R.string.address))
        val transport = detailIntent.getStringExtra(getString(R.string.transport))
        val phone = detailIntent.getStringExtra(getString(R.string.phone))
        val web = detailIntent.getStringExtra(getString(R.string.web))
        val hours = detailIntent.getStringExtra(getString(R.string.hours))
        val fee = detailIntent.getStringExtra(getString(R.string.fee))
        title = name
        val imageView = findViewById<ImageView>(R.id.detail_image_view)
        imageView.setImageResource(imageId)
        setDescriptionTextView()
        val addressTextView = findViewById<TextView>(R.id.detail_address)
        addressTextView.setOnClickListener { view: View? ->
            val geoIntent = Intent(
                Intent.ACTION_VIEW, Uri.parse(
                    "geo:0,0?q="
                            + addressTextView.text.toString()
                )
            )
            startActivity(geoIntent)
        }
        setDetails(R.id.detail_address, address, R.drawable.ic_location)
        setDetails(R.id.detail_transport, transport, R.drawable.ic_subway)
        setDetails(R.id.detail_phone, phone, R.drawable.ic_call)
        setDetails(R.id.detail_web, web, R.drawable.ic_public)
        setDetails(R.id.detail_hours, hours, R.drawable.ic_time)
        setDetails(R.id.detail_fee, fee, R.drawable.ic_money)
        Objects.requireNonNull(supportActionBar)?.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    private fun setDetails(textViewId: Int, string: String?, icResourceId: Int) {
        val textView = findViewById<TextView>(textViewId)
        if (string == null) {
            textView.visibility = View.GONE
        } else {
            textView.text = string
            textView.setCompoundDrawablesWithIntrinsicBounds(
                icResourceId, DEFAULT_NUMBER,
                DEFAULT_NUMBER, DEFAULT_NUMBER
            )
            if (string == address) {
                val spanStr = SpannableString(address)
                spanStr.setSpan(UnderlineSpan(), DEFAULT_NUMBER, spanStr.length, DEFAULT_NUMBER)
                textView.text = spanStr
            }
        }
    }

    private fun setDescriptionTextView() {
        val descriptionTextView = findViewById<TextView>(R.id.detail_long_description)
        descriptionTextView.text = description
        when (category) {
            SIGHTS -> {
                descriptionTextView.setBackgroundResource(R.color.color_description_sights)
                descriptionTextView.setTextColor(resources.getColor(R.color.color_description_sights_text))
            }
            NATURE_AND_CULTURE -> {
                descriptionTextView.setBackgroundResource(R.color.color_description_nature)
                descriptionTextView.setTextColor(resources.getColor(R.color.color_description_nature_text))
            }
            SHOP -> {
                descriptionTextView.setBackgroundResource(R.color.color_description_shop)
                descriptionTextView.setTextColor(resources.getColor(R.color.color_description_shop_text))
            }
            FOOD -> {
                descriptionTextView.setBackgroundResource(R.color.color_description_food)
                descriptionTextView.setTextColor(resources.getColor(R.color.color_description_food_text))
            }
            else -> {}
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val SIGHTS = 1
        private const val NATURE_AND_CULTURE = 2
        private const val SHOP = 3
        private const val FOOD = 4
        private const val DEFAULT_NUMBER = 0
        private const val NO_IMAGE_PROVIDED = -1
    }
}