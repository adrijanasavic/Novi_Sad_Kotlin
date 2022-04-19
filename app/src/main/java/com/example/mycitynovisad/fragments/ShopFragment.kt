package com.example.mycitynovisad.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycitynovisad.R
import com.example.mycitynovisad.adapters.ShopAdapter
import com.example.mycitynovisad.objects.Attraction
import java.util.*

class ShopFragment : Fragment() {
    private var attractions: MutableList<Attraction>? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_item, container, false)
        requireActivity().title = getString(R.string.shop)
        val recyclerView: RecyclerView = rootView.findViewById(R.id.recyclerview)
        val numberOfColumns = 2
        val layoutManager = GridLayoutManager(activity, numberOfColumns)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager
        attractions = ArrayList()
        addAttractions()
        recyclerView.adapter = ShopAdapter(activity, attractions as ArrayList<Attraction>, SHOP)
        return rootView
    }

    private fun addAttractions() {
        attractions!!.add(
            Attraction(
                R.drawable.promenada,
                getString(R.string.promenada),
                getString(R.string.promenada_opis),
                getString(R.string.promenada_adresa),
                getString(R.string.promenada_transport),
                getString(R.string.promenada_rVreme)
            )
        )
        attractions!!.add(
            Attraction(
                R.drawable.merkator,
                getString(R.string.merkator),
                getString(R.string.merkator_opis),
                getString(R.string.merkator_adresa),
                getString(R.string.merkator_transport),
                getString(R.string.merkator_rVreme)
            )
        )
        attractions!!.add(
            Attraction(
                R.drawable.big,
                getString(R.string.big),
                getString(R.string.big_opis),
                getString(R.string.big_adresa),
                getString(R.string.big_transport),
                getString(R.string.big_rVreme)
            )
        )
        attractions!!.add(
            Attraction(
                R.drawable.bazar,
                getString(R.string.bazar),
                getString(R.string.bazar_opis),
                getString(R.string.bazar_adresa),
                getString(R.string.bazar_transport),
                getString(R.string.bazar_rVreme)
            )
        )
        attractions!!.add(
            Attraction(
                R.drawable.nork,
                getString(R.string.nork),
                getString(R.string.nork_opis),
                getString(R.string.nork_adresa),
                getString(R.string.nork_transport),
                getString(R.string.nork_rVreme)
            )
        )
        attractions!!.add(
            Attraction(
                R.drawable.elephant,
                getString(R.string.elephant),
                getString(R.string.elephant_opis),
                getString(R.string.elephant_adresa),
                getString(R.string.elephant_transport),
                getString(R.string.elephant_rVreme)
            )
        )
        attractions!!.add(
            Attraction(
                R.drawable.pariski_magazin,
                getString(R.string.pariski_magazin),
                getString(R.string.pariski_magazin_opis),
                getString(R.string.pariski_magazin_adresa),
                getString(R.string.pariski_magazin_transport),
                getString(R.string.pariski_magazin_rVreme)
            )
        )
    }

    companion object {
        private const val SHOP = 3
    }
}