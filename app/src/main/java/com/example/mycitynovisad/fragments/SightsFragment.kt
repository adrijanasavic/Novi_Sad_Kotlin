package com.example.mycitynovisad.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycitynovisad.R
import com.example.mycitynovisad.adapters.RecyclerAdapter
import com.example.mycitynovisad.objects.Attraction
import java.util.*

class SightsFragment : Fragment() {
    private var attractions: MutableList<Attraction>? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_item, container, false)
        requireActivity().title = getString(R.string.sights)
        val recyclerView: RecyclerView = rootView.findViewById(R.id.recyclerview)
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager
        attractions = ArrayList()
        addAttractions()
        recyclerView.adapter = RecyclerAdapter(activity,
            attractions as ArrayList<Attraction>, SIGHTS)
        return rootView
    }

    private fun addAttractions() {
        attractions!!.add(
            Attraction(
                R.drawable.exit,
                getString(R.string.exit),
                getString(R.string.exit_opis),
                getString(R.string.exit_opis_detalji),
                getString(R.string.exit_adresa),
                getString(R.string.exit_transport),
                getString(R.string.exit_telefon),
                getString(R.string.exit_web),
                getString(R.string.exit_rVreme),
                getString(R.string.exit_cena)
            )
        )
        attractions!!.add(
            Attraction(
                R.drawable.petrovaradin,
                getString(R.string.petrovaradin),
                getString(R.string.petrovaradin_opis),
                getString(R.string.petrovaradin_opis_detalji),
                getString(R.string.petrovaradin_adresa),
                getString(R.string.petrovaradin_transport),
                getString(R.string.petrovaradin_telefon),
                getString(R.string.petrovaradin_web),
                getString(R.string.petrovaradin_rVreme),
                getString(R.string.petrovaradin_cena)
            )
        )
        attractions!!.add(
            Attraction(
                R.drawable.strand,
                getString(R.string.strand),
                getString(R.string.strand_opis),
                getString(R.string.strand_opis_detalji),
                getString(R.string.strand_adresa),
                getString(R.string.strand_transport),
                getString(R.string.strand_telefon),
                getString(R.string.strand_web),
                getString(R.string.strand_rVreme),
                getString(R.string.strand_cena)
            )
        )
        attractions!!.add(
            Attraction(
                R.drawable.katakombe,
                getString(R.string.katakombe),
                getString(R.string.katakombe_opis),
                getString(R.string.katakombe_opis_detalji),
                getString(R.string.katakombe_adresa),
                getString(R.string.katakombe_transport),
                getString(R.string.katakombe_telefon),
                getString(R.string.katakombe_web),
                getString(R.string.katakombe_rVreme),
                getString(R.string.katakombe_cena)
            )
        )
        attractions!!.add(
            Attraction(
                R.drawable.dunavska,
                getString(R.string.dunavska),
                getString(R.string.dunavska_opis),
                getString(R.string.dunavska_opis_detalji),
                getString(R.string.dunavska_adresa),
                getString(R.string.dunavska_transport),
                getString(R.string.dunavska_telefon),
                getString(R.string.dunavska_web),
                getString(R.string.dunavska_rVreme),
                getString(R.string.dunavska_cena)
            )
        )
        attractions!!.add(
            Attraction(
                R.drawable.dunavski_park,
                getString(R.string.dunavski_park),
                getString(R.string.dunavski_park_opis),
                getString(R.string.dunavski_park_opis_detalji),
                getString(R.string.dunavski_park_adresa),
                getString(R.string.dunavski_park_transport),
                getString(R.string.dunavski_park_telefon),
                getString(R.string.dunavski_park_web),
                getString(R.string.dunavski_park_rVreme),
                getString(R.string.dunavski_park_cena)
            )
        )
        attractions!!.add(
            Attraction(
                R.drawable.ledinacko_jezero,
                getString(R.string.ledinacko_jezero),
                getString(R.string.ledinacko_jezero_opis),
                getString(R.string.ledinacko_jezero_opis_detalji),
                getString(R.string.ledinacko_jezero_adresa),
                getString(R.string.ledinacko_jezero_transport),
                getString(R.string.ledinacko_jezero_telefon),
                getString(R.string.ledinacko_jezero_web),
                getString(R.string.ledinacko_jezero_rVreme),
                getString(R.string.ledinacko_jezero_cena)
            )
        )
        attractions!!.add(
            Attraction(
                R.drawable.varadinski_most,
                getString(R.string.varadinski_most),
                getString(R.string.varadinski_most_opis),
                getString(R.string.varadinski_most_opis_detalji),
                getString(R.string.varadinski_most_adresa),
                getString(R.string.varadinski_most_transport),
                getString(R.string.varadinski_most_telefon),
                getString(R.string.varadinski_most_web),
                getString(R.string.varadinski_most_rVreme),
                getString(R.string.varadinski_most_cena)
            )
        )
        attractions!!.add(
            Attraction(
                R.drawable.zezeljev_most,
                getString(R.string.zezeljev_most),
                getString(R.string.zezeljev_most_opis),
                getString(R.string.zezeljev_most_opis_detalji),
                getString(R.string.zezeljev_most_adresa),
                getString(R.string.zezeljev_most_transport),
                getString(R.string.zezeljev_most_telefon),
                getString(R.string.zezeljev_most_web),
                getString(R.string.zezeljev_most_rVreme),
                getString(R.string.zezeljev_most_cena)
            )
        )
        attractions!!.add(
            Attraction(
                R.drawable.most_slobode,
                getString(R.string.most_slobode),
                getString(R.string.most_slobode_opis),
                getString(R.string.most_slobode_opis_detalji),
                getString(R.string.most_slobode_adresa),
                getString(R.string.most_slobode_transport),
                getString(R.string.most_slobode_telefon),
                getString(R.string.most_slobode_web),
                getString(R.string.most_slobode_rVreme),
                getString(R.string.most_slobode_cena)
            )
        )
        attractions!!.add(
            Attraction(
                R.drawable.spens,
                getString(R.string.spens),
                getString(R.string.spens_opis),
                getString(R.string.spens_opis_detalji),
                getString(R.string.spens_adresa),
                getString(R.string.spens_transport),
                getString(R.string.spens_telefon),
                getString(R.string.spens_web),
                getString(R.string.spens_rVreme),
                getString(R.string.spens_cena)
            )
        )
    }

    companion object {
        private const val SIGHTS = 1
    }
}