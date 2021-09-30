package com.example.stepperwithrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.stepperwithrecyclerview.databinding.*


class StepperAdapter(
    private val context: Context,
    private val journeyList: ArrayList<String>?,
    private val maxSteppers: Int,
    private val goToStep: Int
    /*,
                     private val updatePosition : PositionStatus*/
) :
    RecyclerView.Adapter<ViewHolder>() {

    //region Resources for stepper point parent container background
    private var defaultBackgroundResourceID = R.drawable.stepper_circle_default
    private var inProgressBackgroundResourceID = R.drawable.stepper_circle_in_progress_colored
    private var completedBackground = R.drawable.stepper_circle_completed_colored

    //endregion

    //region Resources for status colors
    private var inProgressBackgroundCircleColor: Int =
        ContextCompat.getColor(context, R.color.stepper_in_progress_color)
    private var defaultBackgroundCircleColor: Int =
        ContextCompat.getColor(context, R.color.stepper_default_color)
    private var completedBackgroundCircleColor: Int =
        ContextCompat.getColor(context, R.color.stepper_completed_color)

    private var pendingTextColor: Int =
        ContextCompat.getColor(context, R.color.stepper_default_color)
    private var inProgressTextColor: Int =
        ContextCompat.getColor(context, R.color.stepper_in_progress_color)
    private var completedTextColor: Int =
        ContextCompat.getColor(context, R.color.stepper_completed_color)

    //endregion

    //region Resources for Status Line colors

    private var inProgressLine: Int =
        ContextCompat.getColor(context, R.color.stepper_in_progress_color)
    private var defaultLine: Int = ContextCompat.getColor(context, R.color.stepper_default_color)
    private var completedLine: Int =
        ContextCompat.getColor(context, R.color.stepper_completed_color)

    //endregion

    //region Resources for items Layout
    var bindingStepOne: ViewDataBinding? = null
    var bindingStepTwo: ViewDataBinding? = null
    var bindingStepThree: ViewDataBinding? = null
    var bindingStepFour: ViewDataBinding? = null
    var bindingStepFive: ViewDataBinding? = null


    private val STEPPER_ONE = 0
    private val STEPPER_TWO = 1
    private val STEPPER_THREE = 2
    private val STEPPER_FOUR = 3
    private val STEPPER_FIVE = 4

    val myPublicHelperClass = MyPublicHelperClass(context)

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
            else ->{
                 val emptyLayout : ViewDataBinding? = DataBindingUtil.inflate(inflater, R.layout.empty_item, parent, false)
                return ViewHolder(emptyLayout as EmptyItemBinding)
            }
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val step = journeyList?.get(position)

        if (maxSteppers > 5) {
            setNumberOfStepsInStepperLayout(5)
        }
        else{
            setNumberOfStepsInStepperLayout(maxSteppers)
        }

        selectAccordingToInput(goToStep)

    }

    override fun getItemCount(): Int {
        return if (maxSteppers > 5) {
            5
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

        }
    }

    private fun updateStepperLayout(view: View) {
        view.visibility = View.VISIBLE
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
            }
            StepperPosition.STEP_TWO -> {
                handleStepOne(statusState = PositionState.DONE)
                handleStepTwo(statusState = PositionState.IN_PROGRESS)
                handleStepThree(statusState = PositionState.PENDING)
                handleStepFour(statusState = PositionState.PENDING)
                handleStepFive(statusState = PositionState.PENDING)
            }
            StepperPosition.STEP_THREE -> {
                handleStepOne(statusState = PositionState.DONE)
                handleStepTwo(statusState = PositionState.DONE)
                handleStepThree(statusState = PositionState.IN_PROGRESS)
                handleStepFour(statusState = PositionState.PENDING)
                handleStepFive(statusState = PositionState.PENDING)
            }
            StepperPosition.STEP_FOUR -> {
                handleStepOne(statusState = PositionState.DONE)
                handleStepTwo(statusState = PositionState.DONE)
                handleStepThree(statusState = PositionState.DONE)
                handleStepFour(statusState = PositionState.IN_PROGRESS)
                handleStepFive(statusState = PositionState.PENDING)
            }
            StepperPosition.STEP_FIVE -> {
                handleStepOne(statusState = PositionState.DONE)
                handleStepTwo(statusState = PositionState.DONE)
                handleStepThree(statusState = PositionState.DONE)
                handleStepFour(statusState = PositionState.DONE)
                handleStepFive(statusState = PositionState.IN_PROGRESS)
            }
        }
    }

    private fun handleStepOne(statusState: PositionState) {

        bindingStepOne?.root?.findViewById<TextView>(R.id.tv_LabelStepDescription)
            ?.setText(R.string.stepper_one_desc)


        when (statusState) {
            PositionState.PENDING -> {

                myPublicHelperClass.updateStatusItemForPendingState(
                    statusView = bindingStepOne,
                    true, false, false, false, false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = pendingTextColor
                )
            }
            PositionState.IN_PROGRESS -> {

                myPublicHelperClass.updateStatusItemForInProgressState(
                    statusView = bindingStepOne,
                    true, false, false, false, false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = inProgressTextColor
                )
            }
            PositionState.DONE -> {

                myPublicHelperClass.updateStatusItemForDoneState(
                    statusView = bindingStepOne,
                    true, false, false, false, false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = completedTextColor
                )
            }
        }
    }

    private fun handleStepTwo(statusState: PositionState) {
        bindingStepTwo?.root?.findViewById<TextView>(R.id.tv_LabelStepDescription)
            ?.setText(R.string.stepper_two_desc)

        when (statusState) {
            PositionState.PENDING -> {

                myPublicHelperClass.updateStatusItemForPendingState(
                    statusView = bindingStepTwo,
                    false, true, false, false, false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = pendingTextColor
                )
            }
            PositionState.IN_PROGRESS -> {

                myPublicHelperClass.updateStatusItemForInProgressState(
                    statusView = bindingStepTwo,
                    false, true, false, false, false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = inProgressTextColor
                )
            }
            PositionState.DONE -> {

                myPublicHelperClass.updateStatusItemForDoneState(
                    statusView = bindingStepTwo,
                    false, true, false, false, false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = completedTextColor
                )
            }
        }
    }

    private fun handleStepThree(statusState: PositionState) {
        bindingStepThree?.root?.findViewById<TextView>(R.id.tv_LabelStepDescription)
            ?.setText(R.string.stepper_three_desc)

        when (statusState) {
            PositionState.PENDING -> {

                myPublicHelperClass.updateStatusItemForPendingState(
                    statusView = bindingStepThree,
                    false, false, true, false, false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = pendingTextColor
                )
            }
            PositionState.IN_PROGRESS -> {

                myPublicHelperClass.updateStatusItemForInProgressState(
                    statusView = bindingStepThree,
                    false, false, true, false, false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = inProgressTextColor
                )
            }
            PositionState.DONE -> {

                myPublicHelperClass.updateStatusItemForDoneState(
                    statusView = bindingStepThree,
                    false, false, true, false, false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = completedTextColor
                )
            }
        }
    }

    private fun handleStepFour(statusState: PositionState) {
        bindingStepFour?.root?.findViewById<TextView>(R.id.tv_LabelStepDescription)
            ?.setText(R.string.stepper_four_desc)

        when (statusState) {
            PositionState.PENDING -> {

                myPublicHelperClass.updateStatusItemForPendingState(
                    statusView = bindingStepFour,
                    false, false, false, true, false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = pendingTextColor
                )
            }
            PositionState.IN_PROGRESS -> {

                myPublicHelperClass.updateStatusItemForInProgressState(
                    statusView = bindingStepFour,
                    false, false, false, true, false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = inProgressTextColor
                )
            }
            PositionState.DONE -> {

                myPublicHelperClass.updateStatusItemForDoneState(
                    statusView = bindingStepFour,
                    false, false, false, true, false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = completedTextColor
                )
            }
        }
    }

    private fun handleStepFive(statusState: PositionState) {
        bindingStepFive?.root?.findViewById<TextView>(R.id.tv_LabelStepDescription)?.setText(R.string.stepper_five_desc)

        when (statusState) {
            PositionState.PENDING -> {

                myPublicHelperClass.updateStatusItemForPendingState(
                    statusView = bindingStepFive,
                    false, false, false, false, true,
                    tintStartLine = true, tintEndLine = true,
                    textColor = pendingTextColor
                )
            }
            PositionState.IN_PROGRESS -> {

                myPublicHelperClass.updateStatusItemForInProgressState(
                    statusView = bindingStepFive,
                    false, false, false, false, true,
                    tintStartLine = true, tintEndLine = true,
                    textColor = inProgressTextColor
                )
            }
            PositionState.DONE -> {

                myPublicHelperClass.updateStatusItemForDoneState(
                    statusView = bindingStepFive,
                    false, false, false, false, true,
                    tintStartLine = true, tintEndLine = true,
                    textColor = completedTextColor
                )
            }
        }
    }



    //endregion

    //region Helper method for selectionAccording to User specified Input from Main Activity
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
        }
    }
    //endregion
}