package com.example.stepperwithrecyclerview.activity

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stepperwithrecyclerview.R
import com.example.stepperwithrecyclerview.adapter.StepperAdapter
import com.example.stepperwithrecyclerview.databinding.ActivityMainBinding
import android.view.View

import android.widget.LinearLayout
import android.os.Build
import android.text.TextUtils
import androidx.core.view.ViewCompat
import java.util.*
import kotlin.collections.ArrayList
import android.content.Intent
import android.util.Log
import android.view.ViewGroup
import com.example.stepperwithrecyclerview.interfaces.PositionHide


class MainActivity : AppCompatActivity(), PositionHide {

    private lateinit var stepperAdapter: StepperAdapter
    private var journeyList: ArrayList<String> = ArrayList()
    private var descriptionListForSteps: ArrayList<String> = ArrayList()

    private lateinit var dataBinding: ActivityMainBinding
    private var languageArabic: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.lifecycleOwner = this


        callSetStepperRecyclerView()

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
            setLanguage(this, "ar")
            languageArabic = true

            val intent = intent
            finish()
            startActivity(intent)

            callSetStepperRecyclerView()

        }

        dataBinding.btnEnglishLanguage.setOnClickListener {
            dataBinding.mainLayout.layoutDirection = View.LAYOUT_DIRECTION_LTR
            setLanguage(this, "en")
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

    }

    fun callSetStepperRecyclerView() {
        populateContentForEachStepperList()

        val maxSteppers = 7
        val goToStep = 7

        stepperAdapter = StepperAdapter(this, descriptionListForSteps, maxSteppers, goToStep,this)

        val manager: RecyclerView.LayoutManager =
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

    fun setLanguage(mContext: Context, lang: String?) {
        val localeNew = Locale(lang)
        Locale.setDefault(localeNew)
        val res: Resources = mContext.resources
        val newConfig = Configuration(res.configuration)
        newConfig.locale = localeNew
        newConfig.setLayoutDirection(localeNew)
        res.updateConfiguration(newConfig, res.displayMetrics)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            newConfig.setLocale(localeNew)
            mContext.createConfigurationContext(newConfig)
        }
    }


//    private fun populateContentForEachStepperList(){
//        val list = listOf("POLICYe","PROFESSIONe", "CUSTOMIZEe","HISTORYe", "PERSONALe")
//        journeyList.addAll(list)
//    }

    private fun populateContentForEachStepperList() {
        val contentList = listOf(
            resources.getString(R.string.stepper_one_desc),
            resources.getString(R.string.stepper_two_desc),
            resources.getString(R.string.stepper_three_desc),
            resources.getString(R.string.stepper_four_desc),
            resources.getString(R.string.stepper_five_desc),
            resources.getString(R.string.stepper_six_desc),
            resources.getString(R.string.stepper_seven_desc)
        )

        descriptionListForSteps.addAll(contentList)
    }


    override fun hideStepper(position: Int, content: String) {
//        when(position){
//            0->{
//
//            }
//            1->{
//
//            }
//            2->{
//
//            }
//            3->{
//
//            }
//            4->{
//
//            }
//            5->{
//
//            }
//            6->{
//
//            }
//        }
        Log.e("sad",content)
        val item = dataBinding.stepIndicatorRecyclerView.findViewHolderForAdapterPosition(position)


        val params = item?.itemView?.layoutParams
        params?.height = 0
        params?.width = 0

        item?.itemView?.layoutParams = params
        dataBinding.stepIndicatorRecyclerView.refreshDrawableState()
    }
}