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
import com.example.mycitynovisad.objects.Attraction

class RecyclerAdapter(
    private val mContext: Context?,
    private val mAttractions: List<Attraction>,
    private val mCategory: Int
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mAttractions.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.attraction_image_card)
        val nameTextView: TextView = itemView.findViewById(R.id.attraction_name_card)
        val descriptionShortTextView: TextView = itemView.findViewById(R.id.attraction_short_card)
        val cardView: CardView = itemView.findViewById(R.id.cardview)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val attraction = mAttractions[position]
        val drawable = ContextCompat.getDrawable(mContext!!, attraction.attractionImageId)
        holder.imageView.background = drawable
        holder.nameTextView.text = attraction.attractionName
        holder.descriptionShortTextView.text = attraction.attractionShortDs
        holder.cardView.setOnClickListener {
            val detailIntent = Intent(mContext, DetailActivity::class.java)
            detailIntent.putExtra(mContext.getString(R.string.category), mCategory)
            detailIntent.putExtra(
                mContext.getString(R.string.image_id),
                attraction.attractionImageId
            )
            detailIntent.putExtra(
                mContext.getString(R.string.name),
                attraction.attractionName
            )
            detailIntent.putExtra(
                mContext.getString(R.string.description),
                attraction.attractionDescription
            )
            detailIntent.putExtra(
                mContext.getString(R.string.address),
                attraction.attractionAddress
            )
            detailIntent.putExtra(
                mContext.getString(R.string.transport),
                attraction.attractionTransportation
            )
            detailIntent.putExtra(
                mContext.getString(R.string.phone),
                attraction.attractionPhone
            )
            detailIntent.putExtra(
                mContext.getString(R.string.web),
                attraction.attractionWeb
            )
            detailIntent.putExtra(
                mContext.getString(R.string.hours),
                attraction.attractionHours
            )
            detailIntent.putExtra(
                mContext.getString(R.string.fee),
                attraction.attractionFee
            )
            mContext.startActivity(detailIntent)
        }
    }
}