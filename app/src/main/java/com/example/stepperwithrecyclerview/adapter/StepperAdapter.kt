package com.example.stepperwithrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.stepperwithrecyclerview.*
import com.example.stepperwithrecyclerview.databinding.*
import com.example.stepperwithrecyclerview.interfaces.PositionHide
import com.example.stepperwithrecyclerview.utils.MyPublicHelperClass
import com.example.stepperwithrecyclerview.utils.PositionState
import com.example.stepperwithrecyclerview.utils.StepperPosition

class StepperAdapter(
    private val context: Context,
    /*private val journeyList: ArrayList<String>?,*/
    private val descriptionListForSteps : ArrayList<String>?,
    private val maxSteppers: Int,
    private val goToStep: Int,
    private val hideStepper: PositionHide
    /*,
                     private val updatePosition : PositionStatus*/
) :
    RecyclerView.Adapter<ViewHolder>() {

    //region Resources for status colors
    private var pendingTextColor: Int =
        ContextCompat.getColor(context, R.color.stepper_default_color)
    private var inProgressTextColor: Int =
        ContextCompat.getColor(context, R.color.stepper_in_progress_color)
    private var completedTextColor: Int =
        ContextCompat.getColor(context, R.color.stepper_completed_color)

    //endregion

    //region Resources for items Layout
    var bindingStepOne: ViewDataBinding? = null
    var bindingStepTwo: ViewDataBinding? = null
    var bindingStepThree: ViewDataBinding? = null
    var bindingStepFour: ViewDataBinding? = null
    var bindingStepFive: ViewDataBinding? = null
    var bindingStepSix: ViewDataBinding? = null
    var bindingStepSeven: ViewDataBinding? = null


    private val STEPPER_ONE = 0
    private val STEPPER_TWO = 1
    private val STEPPER_THREE = 2
    private val STEPPER_FOUR = 3
    private val STEPPER_FIVE = 4
    private val STEPPER_SIX = 5
    private val STEPPER_SEVEN = 6

    val myPublicHelperClass = MyPublicHelperClass(context)

    //endregion

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        when (viewType) {
            STEPPER_ONE -> {
                bindingStepOne =
                    DataBindingUtil.inflate(inflater, R.layout.stepper_item_one, parent, false)
                return ViewHolder(bindingStepOne as StepperItemOneBinding)
            }
            STEPPER_TWO -> {
                bindingStepTwo =
                    DataBindingUtil.inflate(inflater, R.layout.stepper_item_two, parent, false)
                return ViewHolder(bindingStepTwo as StepperItemTwoBinding)
            }
            STEPPER_THREE -> {
                bindingStepThree =
                    DataBindingUtil.inflate(inflater, R.layout.stepper_item_three, parent, false)
                return ViewHolder(bindingStepThree as StepperItemThreeBinding)
            }
            STEPPER_FOUR -> {
                bindingStepFour =
                    DataBindingUtil.inflate(inflater, R.layout.stepper_item_four, parent, false)
                return ViewHolder(bindingStepFour as StepperItemFourBinding)
            }
            STEPPER_FIVE -> {
                bindingStepFive =
                    DataBindingUtil.inflate(inflater, R.layout.stepper_item_five, parent, false)
                return ViewHolder(bindingStepFive as StepperItemFiveBinding)
            }
            STEPPER_SIX -> {
                bindingStepSix =
                    DataBindingUtil.inflate(inflater, R.layout.stepper_item_six, parent, false)
                return ViewHolder(bindingStepSix as StepperItemSixBinding)
            }
            STEPPER_SEVEN -> {
                bindingStepSeven =
                    DataBindingUtil.inflate(inflater, R.layout.stepper_item_seven, parent, false)
                return ViewHolder(bindingStepSeven as StepperItemSevenBinding)
            }
            else ->{
                 val emptyLayout : ViewDataBinding? = DataBindingUtil.inflate(inflater,
                     R.layout.empty_item, parent, false)
                return ViewHolder(emptyLayout as EmptyItemBinding)
            }
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val step = descriptionListForSteps?.get(position)

        if (maxSteppers > 7) {
            setNumberOfStepsInStepperLayout(7)
        }
        else{
            setNumberOfStepsInStepperLayout(maxSteppers)
        }

        selectAccordingToInput(goToStep)

    }

    override fun getItemCount(): Int {
        return if (maxSteppers > 7) {
            7
        } else {
            maxSteppers
        }
    }

    override fun getItemViewType(position: Int): Int {
        when (position) {
            0 -> {
                return STEPPER_ONE
            }
            1 -> {
                return STEPPER_TWO
            }
            2 -> {
                return STEPPER_THREE
            }
            3 -> {
                return STEPPER_FOUR
            }
            4 -> {
                return STEPPER_FIVE
            }
            5 -> {
                return STEPPER_SIX
            }
            6 -> {
                return STEPPER_SEVEN
            }
            else->{
                return -1
            }
        }
    }


    //region Helper method for Setup Layout configs

    /**
     * Handle Total Number of Steppers logic
     */
    private fun setNumberOfStepsInStepperLayout(numberOfStep: Int) {
        when (numberOfStep) {
            1 -> {
                (bindingStepOne as StepperItemOneBinding?)?.let { updateStepperLayout(it.mainStepperView) }
            }
            2 -> {
                (bindingStepOne as StepperItemOneBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepTwo as StepperItemTwoBinding?)?.let { updateStepperLayout(it.mainStepperView) }
            }
            3 -> {
                (bindingStepOne as StepperItemOneBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepTwo as StepperItemTwoBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepThree as StepperItemThreeBinding?)?.let { updateStepperLayout(it.mainStepperView) }
            }
            4 -> {
                (bindingStepOne as StepperItemOneBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepTwo as StepperItemTwoBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepThree as StepperItemThreeBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepFour as StepperItemFourBinding?)?.let { updateStepperLayout(it.mainStepperView) }
            }
            5 -> {
                (bindingStepOne as StepperItemOneBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepTwo as StepperItemTwoBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepThree as StepperItemThreeBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepFour as StepperItemFourBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepFive as StepperItemFiveBinding?)?.let { updateStepperLayout(it.mainStepperView) }
            }
            6 -> {
                (bindingStepOne as StepperItemOneBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepTwo as StepperItemTwoBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepThree as StepperItemThreeBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepFour as StepperItemFourBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepFive as StepperItemFiveBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepSix as StepperItemSixBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepSeven as StepperItemSevenBinding?)?.let { updateStepperLayout(it.mainStepperView) }
            }
            7 -> {
                (bindingStepOne as StepperItemOneBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepTwo as StepperItemTwoBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepThree as StepperItemThreeBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepFour as StepperItemFourBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepFive as StepperItemFiveBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepSix as StepperItemSixBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepSeven as StepperItemSevenBinding?)?.let { updateStepperLayout(it.mainStepperView) }
            }

        }
    }

    private fun updateStepperLayout(view: View) {
        view.visibility = View.VISIBLE
    }

    private fun hideStepper(view: View) {
        view.visibility = View.GONE
    }
    //endregion

    //region Helper method for Status Updates
    private fun updatePositionStatus(position: StepperPosition) {
        when (position) {
            StepperPosition.STEP_ONE -> {
                handleStepOne(statusState = PositionState.IN_PROGRESS)
                handleStepTwo(statusState = PositionState.PENDING)
                handleStepThree(statusState = PositionState.PENDING)
                handleStepFour(statusState = PositionState.PENDING)
                handleStepFive(statusState = PositionState.PENDING)
                handleStepSix(statusState = PositionState.PENDING)
                handleStepSeven(statusState = PositionState.PENDING)
            }
            StepperPosition.STEP_TWO -> {
                handleStepOne(statusState = PositionState.DONE)
                handleStepTwo(statusState = PositionState.IN_PROGRESS)
                handleStepThree(statusState = PositionState.PENDING)
                handleStepFour(statusState = PositionState.PENDING)
                handleStepFive(statusState = PositionState.PENDING)
                handleStepSix(statusState = PositionState.PENDING)
                handleStepSeven(statusState = PositionState.PENDING)
            }
            StepperPosition.STEP_THREE -> {
                handleStepOne(statusState = PositionState.DONE)
                handleStepTwo(statusState = PositionState.DONE)
                handleStepThree(statusState = PositionState.IN_PROGRESS)
                handleStepFour(statusState = PositionState.PENDING)
                handleStepFive(statusState = PositionState.PENDING)
                handleStepSix(statusState = PositionState.PENDING)
                handleStepSeven(statusState = PositionState.PENDING)
            }
            StepperPosition.STEP_FOUR -> {
                handleStepOne(statusState = PositionState.DONE)
                handleStepTwo(statusState = PositionState.DONE)
                handleStepThree(statusState = PositionState.DONE)
                handleStepFour(statusState = PositionState.IN_PROGRESS)
                handleStepFive(statusState = PositionState.PENDING)
                handleStepSix(statusState = PositionState.PENDING)
                handleStepSeven(statusState = PositionState.PENDING)
            }
            StepperPosition.STEP_FIVE -> {
                handleStepOne(statusState = PositionState.DONE)
                handleStepTwo(statusState = PositionState.DONE)
                handleStepThree(statusState = PositionState.DONE)
                handleStepFour(statusState = PositionState.DONE)
                handleStepFive(statusState = PositionState.IN_PROGRESS)
                handleStepSix(statusState = PositionState.PENDING)
                handleStepSeven(statusState = PositionState.PENDING)
            }
            StepperPosition.STEP_SIX -> {
                handleStepOne(statusState = PositionState.DONE)
                handleStepTwo(statusState = PositionState.DONE)
                handleStepThree(statusState = PositionState.DONE)
                handleStepFour(statusState = PositionState.DONE)
                handleStepFive(statusState = PositionState.DONE)
                handleStepSix(statusState = PositionState.IN_PROGRESS)
                handleStepSeven(statusState = PositionState.PENDING)
            }
            StepperPosition.STEP_SEVEN -> {
                handleStepOne(statusState = PositionState.DONE)
                handleStepTwo(statusState = PositionState.DONE)
                handleStepThree(statusState = PositionState.DONE)
                handleStepFour(statusState = PositionState.DONE)
                handleStepFive(statusState = PositionState.DONE)
                handleStepSix(statusState = PositionState.DONE)
                handleStepSeven(statusState = PositionState.IN_PROGRESS)
            }
        }
    }

    private fun handleStepOne(statusState: PositionState) {

        descriptionListForSteps?.let { descriptionContentList->
            bindingStepOne?.root?.findViewById<TextView>(R.id.tv_LabelStepDescription)?.text = descriptionContentList[0]
        } ?:run{
            bindingStepOne?.root?.findViewById<TextView>(R.id.tv_LabelStepDescription)?.text = ""
        }

        bindingStepOne?.root?.findViewById<TextView>(R.id.tv_LabelStepNumber)?.text = StepperPosition.STEP_ONE.position.toString()

        when (statusState) {
            PositionState.PENDING -> {

                myPublicHelperClass.updateStatusItemForPendingState(
                    statusView = bindingStepOne,
                    true, false, false, false, false,false,false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = pendingTextColor
                )
            }
            PositionState.IN_PROGRESS -> {

                myPublicHelperClass.updateStatusItemForInProgressState(
                    statusView = bindingStepOne,
                    true, false, false, false, false,false,false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = inProgressTextColor
                )
            }
            PositionState.DONE -> {

                myPublicHelperClass.updateStatusItemForDoneState(
                    statusView = bindingStepOne,
                    true, false, false, false, false,false,false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = completedTextColor
                )
            }
        }
    }

    private fun hideStepOne() {

        bindingStepOne?.root?.findViewById<ConstraintLayout>(R.id.mainStepperView)?.visibility = View.GONE

    }

    private fun handleStepTwo(statusState: PositionState) {

        descriptionListForSteps?.let { descriptionContentList->
            bindingStepTwo?.root?.findViewById<TextView>(R.id.tv_LabelStepDescription)?.text = descriptionContentList[1]
        } ?:run{
            bindingStepTwo?.root?.findViewById<TextView>(R.id.tv_LabelStepDescription)?.text = ""
        }

        bindingStepTwo?.root?.findViewById<TextView>(R.id.tv_LabelStepNumber)?.text = StepperPosition.STEP_TWO.position.toString()

        when (statusState) {
            PositionState.PENDING -> {

                myPublicHelperClass.updateStatusItemForPendingState(
                    statusView = bindingStepTwo,
                    false, true, false, false, false,false,false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = pendingTextColor
                )
            }
            PositionState.IN_PROGRESS -> {

                myPublicHelperClass.updateStatusItemForInProgressState(
                    statusView = bindingStepTwo,
                    false, true, false, false, false,false,false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = inProgressTextColor
                )
            }
            PositionState.DONE -> {

                myPublicHelperClass.updateStatusItemForDoneState(
                    statusView = bindingStepTwo,
                    false, true, false, false, false,false,false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = completedTextColor
                )
            }
        }
    }

    private fun handleStepThree(statusState: PositionState) {

        descriptionListForSteps?.let { descriptionContentList->
            bindingStepThree?.root?.findViewById<TextView>(R.id.tv_LabelStepDescription)?.text = descriptionContentList[2]
        } ?:run{
            bindingStepThree?.root?.findViewById<TextView>(R.id.tv_LabelStepDescription)?.text = ""
        }

        bindingStepThree?.root?.findViewById<TextView>(R.id.tv_LabelStepNumber)?.text = StepperPosition.STEP_THREE.position.toString()

        when (statusState) {
            PositionState.PENDING -> {

                myPublicHelperClass.updateStatusItemForPendingState(
                    statusView = bindingStepThree,
                    false, false, true, false, false,false,false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = pendingTextColor
                )
            }
            PositionState.IN_PROGRESS -> {

                myPublicHelperClass.updateStatusItemForInProgressState(
                    statusView = bindingStepThree,
                    false, false, true, false, false,false,false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = inProgressTextColor
                )
            }
            PositionState.DONE -> {

                myPublicHelperClass.updateStatusItemForDoneState(
                    statusView = bindingStepThree,
                    false, false, true, false, false,false,false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = completedTextColor
                )
            }
        }
    }

    private fun handleStepFour(statusState: PositionState) {

        descriptionListForSteps?.let { descriptionContentList->
            bindingStepFour?.root?.findViewById<TextView>(R.id.tv_LabelStepDescription)?.text = descriptionContentList[3]
        } ?:run{
            bindingStepFour?.root?.findViewById<TextView>(R.id.tv_LabelStepDescription)?.text = ""
        }

        bindingStepFour?.root?.findViewById<TextView>(R.id.tv_LabelStepNumber)?.text = StepperPosition.STEP_FOUR.position.toString()

        when (statusState) {
            PositionState.PENDING -> {

                myPublicHelperClass.updateStatusItemForPendingState(
                    statusView = bindingStepFour,
                    false, false, false, true, false,false,false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = pendingTextColor
                )
            }
            PositionState.IN_PROGRESS -> {

                myPublicHelperClass.updateStatusItemForInProgressState(
                    statusView = bindingStepFour,
                    false, false, false, true, false,false,false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = inProgressTextColor
                )
            }
            PositionState.DONE -> {

                myPublicHelperClass.updateStatusItemForDoneState(
                    statusView = bindingStepFour,
                    false, false, false, true, false,false,false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = completedTextColor
                )
            }
        }
    }

    private fun handleStepFive(statusState: PositionState) {

        descriptionListForSteps?.let { descriptionContentList->
            bindingStepFive?.root?.findViewById<TextView>(R.id.tv_LabelStepDescription)?.text = descriptionContentList[4]
        } ?:run{
            bindingStepFive?.root?.findViewById<TextView>(R.id.tv_LabelStepDescription)?.text = ""
        }

        bindingStepFive?.root?.findViewById<TextView>(R.id.tv_LabelStepNumber)?.text = StepperPosition.STEP_FIVE.position.toString()

        when (statusState) {
            PositionState.PENDING -> {

                myPublicHelperClass.updateStatusItemForPendingState(
                    statusView = bindingStepFive,
                    false, false, false, false, true,false,false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = pendingTextColor
                )
            }
            PositionState.IN_PROGRESS -> {

                myPublicHelperClass.updateStatusItemForInProgressState(
                    statusView = bindingStepFive,
                    false, false, false, false, true,false,false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = inProgressTextColor
                )
            }
            PositionState.DONE -> {

                myPublicHelperClass.updateStatusItemForDoneState(
                    statusView = bindingStepFive,
                    false, false, false, false, true,false,false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = completedTextColor
                )
            }
        }
    }

    private fun handleStepSix(statusState: PositionState) {

        descriptionListForSteps?.let { descriptionContentList->
            bindingStepSix?.root?.findViewById<TextView>(R.id.tv_LabelStepDescription)?.text = descriptionContentList[5]
        } ?:run{
            bindingStepSix?.root?.findViewById<TextView>(R.id.tv_LabelStepDescription)?.text = ""
        }

        bindingStepSix?.root?.findViewById<TextView>(R.id.tv_LabelStepNumber)?.text = StepperPosition.STEP_SIX.position.toString()

        when (statusState) {
            PositionState.PENDING -> {

                myPublicHelperClass.updateStatusItemForPendingState(
                    statusView = bindingStepSix,
                    false, false, false, false, false,true,false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = pendingTextColor
                )
            }
            PositionState.IN_PROGRESS -> {

                myPublicHelperClass.updateStatusItemForInProgressState(
                    statusView = bindingStepSix,
                    false, false, false, false, false,true,false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = inProgressTextColor
                )
            }
            PositionState.DONE -> {

                myPublicHelperClass.updateStatusItemForDoneState(
                    statusView = bindingStepSix,
                    false, false, false, false, false,true,false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = completedTextColor
                )
            }
        }
    }

    private fun handleStepSeven(statusState: PositionState) {

        descriptionListForSteps?.let { descriptionContentList->
            bindingStepSeven?.root?.findViewById<TextView>(R.id.tv_LabelStepDescription)?.text = descriptionContentList[6]
        } ?:run{
            bindingStepSeven?.root?.findViewById<TextView>(R.id.tv_LabelStepDescription)?.text = ""
        }

        bindingStepSeven?.root?.findViewById<TextView>(R.id.tv_LabelStepNumber)?.text = StepperPosition.STEP_SEVEN.position.toString()

        when (statusState) {
            PositionState.PENDING -> {

                myPublicHelperClass.updateStatusItemForPendingState(
                    statusView = bindingStepSeven,
                    false, false, false, false,false,false, true,
                    tintStartLine = true, tintEndLine = true,
                    textColor = pendingTextColor
                )
            }
            PositionState.IN_PROGRESS -> {

                myPublicHelperClass.updateStatusItemForInProgressState(
                    statusView = bindingStepSeven,
                    false, false, false, false,false,false, true,
                    tintStartLine = true, tintEndLine = true,
                    textColor = inProgressTextColor
                )
            }
            PositionState.DONE -> {

                myPublicHelperClass.updateStatusItemForDoneState(
                    statusView = bindingStepSeven,
                    false, false, false, false,false,false, true,
                    tintStartLine = true, tintEndLine = true,
                    textColor = completedTextColor
                )
            }
        }
    }


    //endregion

    //region Helper method for selection According to User specified Input from Main Activity
    fun selectAccordingToInput(goToStep: Int){
        when (goToStep) {
            1 -> {
                updatePositionStatus(StepperPosition.STEP_ONE)
                // updatePosition.updatePositionStatus(StepperPosition.STEP_ONE,position)
            }
            2 -> {
                updatePositionStatus(StepperPosition.STEP_TWO)
                // updatePosition.updatePositionStatus(StepperPosition.STEP_TWO,position)
            }
            3 -> {
                updatePositionStatus(StepperPosition.STEP_THREE)
                // updatePosition.updatePositionStatus(StepperPosition.STEP_THREE,position)
            }
            4 -> {
                updatePositionStatus(StepperPosition.STEP_FOUR)
                //updatePosition.updatePositionStatus(StepperPosition.STEP_FOUR,position)
            }
            5 -> {
                updatePositionStatus(StepperPosition.STEP_FIVE)
                // updatePosition.updatePositionStatus(StepperPosition.STEP_FIVE,position)
            }
            6 -> {
                updatePositionStatus(StepperPosition.STEP_SIX)
                // updatePosition.updatePositionStatus(StepperPosition.STEP_FIVE,position)
            }
            7 -> {
                updatePositionStatus(StepperPosition.STEP_SEVEN)
                // updatePosition.updatePositionStatus(StepperPosition.STEP_FIVE,position)
            }
        }
    }
    //endregion

    //region Helper method for deletion/hide According to User specified Input from Main Activity
    fun hideAccordingToInput(hideStepperPosition: Int){
        when (hideStepperPosition) {
            1 -> {
                (bindingStepOne as StepperItemOneBinding?)?.let {
                    hideStepper(it.mainStepperView)
                    hideStepper.hideStepper(0,it.tvLabelStepDescription.text.toString())
                }
            }
            2 -> {
                (bindingStepTwo as StepperItemTwoBinding?)?.let {
                    hideStepper(it.mainStepperView)
                    hideStepper.hideStepper(1,it.tvLabelStepDescription.text.toString())
                }
            }
            3 -> {
                (bindingStepThree as StepperItemThreeBinding?)?.let {
                    hideStepper(it.mainStepperView)
                    hideStepper.hideStepper(2,it.tvLabelStepDescription.text.toString())
                }
            }
            4 -> {
                (bindingStepFour as StepperItemFourBinding?)?.let {
                    hideStepper(it.mainStepperView)
                    hideStepper.hideStepper(3,it.tvLabelStepDescription.text.toString())
                }
            }
            5 -> {
                (bindingStepFive as StepperItemFiveBinding?)?.let {
                    hideStepper(it.mainStepperView)
                    hideStepper.hideStepper(4,it.tvLabelStepDescription.text.toString())
                }
            }
            6 -> {
                (bindingStepSix as StepperItemSixBinding?)?.let {
                    hideStepper(it.mainStepperView)
                    hideStepper.hideStepper(5,it.tvLabelStepDescription.text.toString())
                }
            }
            7 -> {
                (bindingStepSeven as StepperItemSevenBinding?)?.let {
                    hideStepper(it.mainStepperView)
                    hideStepper.hideStepper(6,it.tvLabelStepDescription.text.toString())
                }
            }
        }
    }
    //endregion
}