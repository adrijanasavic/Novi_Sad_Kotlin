package com.example.mycitynovisad.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycitynovisad.R
import com.example.mycitynovisad.adapters.FoodAdapter
import com.example.mycitynovisad.objects.Food
import java.util.*

class FoodFragment : Fragment() {
    private var foods: MutableList<Food>? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_item, container, false)
        requireActivity().title = getString(R.string.food)
        val recyclerView: RecyclerView = rootView.findViewById(R.id.recyclerview)
        val numberOfColumns = 2
        val layoutManager = GridLayoutManager(activity, numberOfColumns)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager
        foods = ArrayList()
        addFoods()
        recyclerView.adapter = FoodAdapter(activity, foods as ArrayList<Food>, FOOD)
        return rootView
    }

    private fun addFoods() {
        foods!!.add(
            Food(
                R.drawable.gondola,
                getString(R.string.gondola),
                getString(R.string.gondola_opis),
                getString(R.string.gondola_adresa),
                getString(R.string.gondola_transport),
                getString(R.string.gondola_phone),
                getString(R.string.gondola_web),
                getString(R.string.gondola_rVreeme),
                getString(R.string.gondola_cena)
            )
        )
        foods!!.add(
            Food(
                R.drawable.the_camelon,
                getString(R.string.the_camelon),
                getString(R.string.the_camelon_opis),
                getString(R.string.the_camelon_adresa),
                getString(R.string.the_camelon_transport),
                getString(R.string.the_camelon_phone),
                getString(R.string.the_camelon_web),
                getString(R.string.the_camelon_rVreeme),
                getString(R.string.the_camelon_cena)
            )
        )
        foods!!.add(
            Food(
                R.drawable.plava_frajla,
                getString(R.string.plava_frajla),
                getString(R.string.plava_frajla_opis),
                getString(R.string.plava_frajla_adresa),
                getString(R.string.plava_frajla_transport),
                getString(R.string.plava_frajla_phone),
                getString(R.string.plava_frajla_web),
                getString(R.string.plava_frajla_rVreeme),
                getString(R.string.plava_frajla_cena)
            )
        )
        foods!!.add(
            Food(
                R.drawable.sokace,
                getString(R.string.sokace),
                getString(R.string.sokace_opis),
                getString(R.string.sokace_adresa),
                getString(R.string.sokace_transport),
                getString(R.string.sokace_phone),
                getString(R.string.sokace_web),
                getString(R.string.sokace_rVreeme),
                getString(R.string.sokace_cena)
            )
        )
        foods!!.add(
            Food(
                R.drawable.giardino,
                getString(R.string.giardino),
                getString(R.string.giardino_opis),
                getString(R.string.giardino_adresa),
                getString(R.string.giardino_transport),
                getString(R.string.giardino_phone),
                getString(R.string.giardino_web),
                getString(R.string.giardino_rVreeme),
                getString(R.string.giardino_cena)
            )
        )
        foods!!.add(
            Food(
                R.drawable.fontana,
                getString(R.string.fontana),
                getString(R.string.fontana_opis),
                getString(R.string.fontana_adresa),
                getString(R.string.fontana_transport),
                getString(R.string.fontana_phone),
                getString(R.string.fontana_web),
                getString(R.string.fontana_rVreeme),
                getString(R.string.fontana_cena)
            )
        )
        foods!!.add(
            Food(
                R.drawable.petrus,
                getString(R.string.petrus),
                getString(R.string.petrus_opis),
                getString(R.string.petrus_adresa),
                getString(R.string.petrus_transport),
                getString(R.string.petrus_phone),
                getString(R.string.petrus_web),
                getString(R.string.petrus_rVreeme),
                getString(R.string.petrus_cena)
            )
        )
        foods!!.add(
            Food(
                R.drawable.ribarac,
                getString(R.string.ribarac),
                getString(R.string.ribarac_opis),
                getString(R.string.ribarac_adresa),
                getString(R.string.ribarac_transport),
                getString(R.string.ribarac_phone),
                getString(R.string.ribarac_web),
                getString(R.string.ribarac_rVreeme),
                getString(R.string.ribarac_cena)
            )
        )
        foods!!.add(
            Food(
                R.drawable.alaska_terasa,
                getString(R.string.alaska_terasa),
                getString(R.string.alaska_terasa_opis),
                getString(R.string.alaska_terasa_adresa),
                getString(R.string.alaska_terasa_transport),
                getString(R.string.alaska_terasa_phone),
                getString(R.string.alaska_terasa_web),
                getString(R.string.alaska_terasa_rVreeme),
                getString(R.string.alaska_terasa_cena)
            )
        )
        foods!!.add(
            Food(
                R.drawable.drevna,
                getString(R.string.drevna),
                getString(R.string.drevna_opis),
                getString(R.string.drevna_adresa),
                getString(R.string.drevna_transport),
                getString(R.string.drevna_phone),
                getString(R.string.drevna_web),
                getString(R.string.drevna_rVreeme),
                getString(R.string.drevna_cena)
            )
        )
    }

    companion object {
        private const val FOOD = 4
    }
}