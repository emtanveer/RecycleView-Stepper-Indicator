package com.example.stepperwithrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stepperwithrecyclerview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity()/*,PositionStatus*/ {

    private lateinit var stepperAdapter: StepperAdapter
    private var journeyList: ArrayList<String> = ArrayList()

    private lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.lifecycleOwner = this

        populateList()

        stepperAdapter = StepperAdapter(this, journeyList,5,2/*,this*/)

        val manager: RecyclerView.LayoutManager = GridLayoutManager(this, 5)

        dataBinding.stepIndicatorRecyclerView.apply {
            layoutManager = manager
            adapter = stepperAdapter
        }

        dataBinding.btnStepOne.setOnClickListener {
            stepperAdapter.selectAccordingToInput(1)
        }
        dataBinding.btnStepTwo.setOnClickListener {
            stepperAdapter.selectAccordingToInput(2)
        }
        dataBinding.btnStepThree.setOnClickListener {
            stepperAdapter.selectAccordingToInput(3)
        }
        dataBinding.btnStepFour.setOnClickListener {
            stepperAdapter.selectAccordingToInput(4)
        }
        dataBinding.btnStepFive.setOnClickListener {
            stepperAdapter.selectAccordingToInput(5)
        }

    }

    private fun populateList(){
        val list = listOf("POLICYe","PROFESSIONe", "CUSTOMIZEe","HISTORYe", "PERSONALe")
        journeyList.addAll(list)
    }
/*
    override fun updatePositionStatus(
        position: StepperPosition,
        adapterPosition: Int,
        maxStepperToShow: Int
    ) {
        val stepperOne = stepIndicatorRecyclerView?.findViewHolderForAdapterPosition(0)?.itemView
        val stepperTwo = stepIndicatorRecyclerView?.findViewHolderForAdapterPosition(1)?.itemView
        val stepperThree = stepIndicatorRecyclerView?.findViewHolderForAdapterPosition(2)?.itemView
        val stepperFour = stepIndicatorRecyclerView?.findViewHolderForAdapterPosition(3)?.itemView
        val stepperFive = stepIndicatorRecyclerView?.findViewHolderForAdapterPosition(4)?.itemView


        when (maxStepperToShow) {
            1 -> {
                stepperOne?.findViewById<ConstraintLayout>(R.id.mainStepperView)?.visibility =
                    View.VISIBLE
                stepperOne?.visibility = View.VISIBLE
                stepperOne?.isVisible = true
            }
            2 -> {
                stepperOne?.findViewById<ConstraintLayout>(R.id.mainStepperView)?.visibility =
                    View.VISIBLE
                stepperTwo?.findViewById<ConstraintLayout>(R.id.mainStepperView)?.visibility =
                    View.VISIBLE
            }
            3 -> {
                stepperOne?.findViewById<ConstraintLayout>(R.id.mainStepperView)?.visibility =
                    View.VISIBLE
                stepperTwo?.findViewById<ConstraintLayout>(R.id.mainStepperView)?.visibility =
                    View.VISIBLE
                stepperThree?.findViewById<ConstraintLayout>(R.id.mainStepperView)?.visibility =
                    View.VISIBLE
            }
            4 -> {
                stepperOne?.findViewById<ConstraintLayout>(R.id.mainStepperView)?.visibility =
                    View.VISIBLE

                stepperTwo?.findViewById<ConstraintLayout>(R.id.mainStepperView)?.visibility =
                    View.VISIBLE
                stepperThree?.findViewById<ConstraintLayout>(R.id.mainStepperView)?.visibility =
                    View.VISIBLE
                stepperFour?.findViewById<ConstraintLayout>(R.id.mainStepperView)?.visibility =
                    View.VISIBLE
            }
            5 -> {
                stepperOne?.findViewById<ConstraintLayout>(R.id.mainStepperView)?.visibility =
                    View.VISIBLE
                stepperTwo?.findViewById<ConstraintLayout>(R.id.mainStepperView)?.visibility =
                    View.VISIBLE
                stepperThree?.findViewById<ConstraintLayout>(R.id.mainStepperView)?.visibility =
                    View.VISIBLE
                stepperFour?.findViewById<ConstraintLayout>(R.id.mainStepperView)?.visibility =
                    View.VISIBLE
                stepperFive?.findViewById<ConstraintLayout>(R.id.mainStepperView)?.visibility =
                    View.VISIBLE
            }
        }
    }*/

}