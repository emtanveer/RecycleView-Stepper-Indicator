package com.example.stepperwithrecyclerview.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.RecyclerView
import com.example.stepperwithrecyclerview.R
import com.example.stepperwithrecyclerview.adapter.StepperAdapter
import com.example.stepperwithrecyclerview.databinding.ActivityMainBinding
import com.example.stepperwithrecyclerview.interfaces.PositionHide
import com.example.stepperwithrecyclerview.interfaces.UpdateStepperIndex
import com.example.stepperwithrecyclerview.utils.MyPublicHelperClass
import com.example.stepperwithrecyclerview.viewholders.ViewHolder


class MainActivity : AppCompatActivity(), PositionHide/*, UpdateStepperIndex*/ {

    companion object{
        const val maxSteppers = 7
        const val goToStep = 7
    }

    private lateinit var stepperAdapter: StepperAdapter
    private lateinit var dataBinding: ActivityMainBinding
    private var descriptionListForSteps: ArrayList<String> = ArrayList()
    private var languageArabic: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.lifecycleOwner = this

        initViews()
    }

    //region Helper Methods for Views Init
    private fun initViews() {

        callSetStepperRecyclerView()

        //region button click listeners
        dataBinding.btnStepOne.setOnClickListener {
            stepperAdapter.selectAccordingToInput(1)
            dataBinding.stepIndicatorRecyclerView.smoothScrollToPosition(0)
        }
        dataBinding.btnStepTwo.setOnClickListener {
            stepperAdapter.selectAccordingToInput(2)
            dataBinding.stepIndicatorRecyclerView.smoothScrollToPosition(1)
        }
        dataBinding.btnStepThree.setOnClickListener {
            stepperAdapter.selectAccordingToInput(3)
            dataBinding.stepIndicatorRecyclerView.smoothScrollToPosition(2)
        }
        dataBinding.btnStepFour.setOnClickListener {
            stepperAdapter.selectAccordingToInput(4)
            dataBinding.stepIndicatorRecyclerView.smoothScrollToPosition(3)
        }
        dataBinding.btnStepFive.setOnClickListener {
            stepperAdapter.selectAccordingToInput(5)
            dataBinding.stepIndicatorRecyclerView.smoothScrollToPosition(4)
        }
        dataBinding.btnStepSix.setOnClickListener {
            stepperAdapter.selectAccordingToInput(6)
            dataBinding.stepIndicatorRecyclerView.smoothScrollToPosition(5)
        }
        dataBinding.btnStepSeven.setOnClickListener {
            stepperAdapter.selectAccordingToInput(7)
            dataBinding.stepIndicatorRecyclerView.smoothScrollToPosition(6)
        }

        dataBinding.btnArabicLanguage.setOnClickListener {
            dataBinding.mainLayout.layoutDirection = View.LAYOUT_DIRECTION_RTL
            MyPublicHelperClass(this).setLanguage("ar")
            languageArabic = true

            val intent = intent
            finish()
            startActivity(intent)

            callSetStepperRecyclerView()

        }

        dataBinding.btnEnglishLanguage.setOnClickListener {
            dataBinding.mainLayout.layoutDirection = View.LAYOUT_DIRECTION_LTR
            MyPublicHelperClass(this).setLanguage("en")
            languageArabic = false

            val intent = intent
            finish()
            startActivity(intent)

            callSetStepperRecyclerView()

        }

        dataBinding.btnRemoveStepper.setOnClickListener {
            val userInputValueToHide = dataBinding.etRemoveStepper.text.toString()
            if (!TextUtils.isEmpty(userInputValueToHide)) {
                stepperAdapter.hideAccordingToInput(userInputValueToHide.toInt())
            }

        }

        //endregion
    }
    //endregion

    //region RecyclerView Setup
    private fun callSetStepperRecyclerView() {

        populateContentForEachStepperList()

        stepperAdapter = StepperAdapter(this, descriptionListForSteps, maxSteppers, goToStep, this/*, this*/)

        val manager=
            GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false)


        dataBinding.stepIndicatorRecyclerView.apply {
            layoutManager = manager

            adapter = stepperAdapter

            smoothScrollToPosition(maxSteppers)

            val params = RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            layoutParams = params
        }
    }
    //endregion

    //region Helper method for populating Stepper data in List
    private fun populateContentForEachStepperList() {
        descriptionListForSteps.clear()

        val contentList = mutableListOf(
            null,
            resources.getString(R.string.stepper_two_desc),
            resources.getString(R.string.stepper_three_desc),
            resources.getString(R.string.stepper_four_desc),
            resources.getString(R.string.stepper_five_desc),
            resources.getString(R.string.stepper_six_desc),
            resources.getString(R.string.stepper_seven_desc)
        )

        descriptionListForSteps.addAll(contentList as Collection<String>)

    }
    //endregion

    //region Helper method for deleting Stepper
    @SuppressLint("SetTextI18n")
    override fun hideStepper(position: Int, content: String) {
        stepperAdapter.deleteItem(position)
        Log.e("removeStepper: ", "pos : $position - $content")
    }
    //endregion

}