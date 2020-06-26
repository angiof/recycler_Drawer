package com.example.recycler_drawer.Adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.extencionfuntions.imageviewloaderbyurl
import com.example.extencionfuntions.infla
import com.example.recycler_drawer.Listainers.Recycler_FlightListainers
import com.example.recycler_drawer.Model.Flihgt
import com.example.recycler_drawer.R
import kotlinx.android.synthetic.main.recycler_flight.view.*

class FlightAdapter(



    private val flights: List<Flihgt>,  //lista
    private val listainer: Recycler_FlightListainers   //i nterfax dei click
) : RecyclerView.Adapter<FlightAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(flihgt: Flihgt, listainer: Recycler_FlightListainers) = with(itemView) {
            texviewcity.text=flihgt.city

            imageviewBg.setImageResource(flihgt.imageresource)
            //click events 
            setOnClickListener { listainer.onCLikc(flihgt,adapterPosition) }
            imageviewdelated.setOnClickListener { listainer.onDelate(flihgt,adapterPosition) }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.infla(R.layout.recycler_flight))

    override fun getItemCount(): Int = flights.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int)=holder.bind(flights[position], listainer)

}