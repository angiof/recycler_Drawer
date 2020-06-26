package com.example.recycler_drawer.Frags

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.extencionfuntions.toastt
import com.example.recycler_drawer.Adapters.FlightAdapter
import com.example.recycler_drawer.Listainers.Recycler_FlightListainers
import com.example.recycler_drawer.Model.Flihgt
import com.example.recycler_drawer.R
import kotlinx.android.synthetic.main.fragment_deapertures.view.*
import kotlin.Lazy as Lazy1

class FragmentDeapertures : Fragment() {
    private val list: ArrayList<Flihgt> by lazy { getflihtgs() }
    private  lateinit var recyclerView:RecyclerView
    private lateinit var flightAdapter: FlightAdapter
    private val layoutManager by lazy { LinearLayoutManager(context) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val viewroot=   inflater.inflate(R.layout.fragment_deapertures, container, false)
        //
        recyclerView = viewroot.recylerview as RecyclerView
        setRecyclerview()

        //
        return viewroot
    }

    private fun setRecyclerview() {
        recyclerView.setHasFixedSize(true)
        recyclerView.itemAnimator=DefaultItemAnimator()
        recyclerView.layoutManager=layoutManager
        flightAdapter=(FlightAdapter(list, object : Recycler_FlightListainers {
            override fun onCLikc(flihgt: Flihgt, adapterPosition: Int) {
                super.onCLikc(flihgt, adapterPosition)
                activity?.toastt("andiamo a ${flihgt.city}")

            }

            override fun onDelate(flihgt: Flihgt, adapterPosition: Int) {

                list.remove(flihgt)
                flightAdapter.notifyItemRemoved(adapterPosition)
                flightAdapter.notifyDataSetChanged()
                activity?.toastt(" delated ${flihgt.city}")


            }
        }))

        recyclerView.adapter=flightAdapter

    }

    private fun getflihtgs(): ArrayList<Flihgt> {
        return object : ArrayList<Flihgt>() {
            init {
                add(Flihgt(0, "washintong_dc", R.drawable.wahington))
                add(Flihgt(1, "bostonmasashuced ", R.drawable.boston))
                add(Flihgt(2, "new york", R.drawable.newyork))
                add(Flihgt(3, "washintong_dc", R.drawable.wahington))
                add(Flihgt(4, "bostonmasashuced ", R.drawable.boston))
                add(Flihgt(5, "new york", R.drawable.newyork))
            }
        }
    }


}