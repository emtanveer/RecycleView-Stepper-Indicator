package com.example.stepperwithrecyclerview

interface PositionStatus {
    fun updatePositionStatus(position: StepperPosition,adapterPosition : Int,maxStepperToShow : Int)
}