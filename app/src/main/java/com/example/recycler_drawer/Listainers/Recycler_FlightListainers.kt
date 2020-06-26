package com.example.recycler_drawer.Listainers

import com.example.recycler_drawer.Model.Flihgt

interface Recycler_FlightListainers {

    fun onCLikc(flihgt: Flihgt, adapterPosition: Int) {}
    fun onDelate(flihgt: Flihgt, adapterPosition: Int) {}

}