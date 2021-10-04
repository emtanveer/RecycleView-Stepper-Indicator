package com.example.stepperwithrecyclerview.interfaces

import com.example.stepperwithrecyclerview.viewholders.ViewHolder


interface UpdateStepperIndex {
    fun updateStepper(position: Int, holder :ViewHolder/*, content:String*/)
}