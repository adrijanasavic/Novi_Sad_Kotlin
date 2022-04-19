package com.example.mycitynovisad.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mycitynovisad.R
import com.example.mycitynovisad.activities.DetailActivity
import com.example.mycitynovisad.objects.Food

class FoodAdapter(
    private val mContext: Context?,
    private val mFoods: List<Food>,
    private val mCategory: Int
) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_item_food, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mFoods.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.food_image_card)
        val nameTextView: TextView = itemView.findViewById(R.id.food_name_card)
        val cardView: CardView = itemView.findViewById(R.id.cardview_food)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val attraction = mFoods[position]
        val drawable = ContextCompat.getDrawable(mContext!!, attraction.foodImageId)
        holder.imageView.background = drawable
        holder.nameTextView.text = attraction.foodName
        holder.cardView.setOnClickListener {
            val detailIntent = Intent(mContext, DetailActivity::class.java)
            detailIntent.putExtra(mContext.getString(R.string.category), mCategory)
            detailIntent.putExtra(
                mContext.getString(R.string.image_id),
                attraction.foodImageId
            )
            detailIntent.putExtra(
                mContext.getString(R.string.name),
                attraction.foodName
            )
            detailIntent.putExtra(
                mContext.getString(R.string.description),
                attraction.foodDescription
            )
            detailIntent.putExtra(
                mContext.getString(R.string.address),
                attraction.foodAddress
            )
            detailIntent.putExtra(
                mContext.getString(R.string.transport),
                attraction.foodTransportation
            )
            detailIntent.putExtra(
                mContext.getString(R.string.phone),
                attraction.foodPhone
            )
            detailIntent.putExtra(
                mContext.getString(R.string.web),
                attraction.foodWeb
            )
            detailIntent.putExtra(
                mContext.getString(R.string.hours),
                attraction.foodHours
            )
            detailIntent.putExtra(
                mContext.getString(R.string.fee),
                attraction.foodFee
            )
            mContext.startActivity(detailIntent)
        }
    }
}