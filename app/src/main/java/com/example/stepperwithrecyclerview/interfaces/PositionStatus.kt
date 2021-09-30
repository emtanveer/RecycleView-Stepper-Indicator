package com.example.stepperwithrecyclerview.interfaces

import com.example.stepperwithrecyclerview.utils.StepperPosition

interface PositionStatus {
    fun updatePositionStatus(position: StepperPosition, adapterPosition : Int, maxStepperToShow : Int)
}