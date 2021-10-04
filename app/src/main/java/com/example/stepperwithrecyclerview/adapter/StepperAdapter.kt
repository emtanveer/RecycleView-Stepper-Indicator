package com.example.stepperwithrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.stepperwithrecyclerview.*
import com.example.stepperwithrecyclerview.activity.MainActivity
import com.example.stepperwithrecyclerview.databinding.*
import com.example.stepperwithrecyclerview.interfaces.PositionHide
import com.example.stepperwithrecyclerview.interfaces.UpdateStepperIndex
import com.example.stepperwithrecyclerview.utils.MyPublicHelperClass
import com.example.stepperwithrecyclerview.utils.PositionState
import com.example.stepperwithrecyclerview.utils.StepperPosition
import com.example.stepperwithrecyclerview.viewholders.ViewHolder

class StepperAdapter(
    val context: Context,
    val descriptionListForSteps: ArrayList<String>?,
    private val maxSteppers: Int,
    private val goToStep: Int,
    private val hideStepper: PositionHide,
    /*  private val updateStepperIndex: UpdateStepperIndex,*/
) : RecyclerView.Adapter<ViewHolder>() {


    //region Resources for status colors
    private var pendingTextColor: Int =
        ContextCompat.getColor(context, R.color.stepper_default_color)
    private var inProgressTextColor: Int =
        ContextCompat.getColor(context, R.color.stepper_in_progress_color)
    private var completedTextColor: Int =
        ContextCompat.getColor(context, R.color.stepper_completed_color)

    //endregion

    //region Resources for items Layout
    private var bindingStepOne: ViewDataBinding? = null
    private var bindingStepTwo: ViewDataBinding? = null
    private var bindingStepThree: ViewDataBinding? = null
    private var bindingStepFour: ViewDataBinding? = null
    private var bindingStepFive: ViewDataBinding? = null
    private var bindingStepSix: ViewDataBinding? = null
    private var bindingStepSeven: ViewDataBinding? = null

    companion object {
        const val STEPPER_ONE = 0
        const val STEPPER_TWO = 1
        const val STEPPER_THREE = 2
        const val STEPPER_FOUR = 3
        const val STEPPER_FIVE = 4
        const val STEPPER_SIX = 5
        const val STEPPER_SEVEN = 6
    }

    private val myPublicHelperClass = MyPublicHelperClass(context)

    //endregion

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        when (viewType) {
            STEPPER_ONE -> {
                bindingStepOne =
                    DataBindingUtil.inflate(inflater, R.layout.stepper_starting, parent, false)
                return ViewHolder(bindingStepOne as StepperStartingBinding)
            }
            STEPPER_TWO -> {
                bindingStepTwo =
                    DataBindingUtil.inflate(inflater, R.layout.stepper_middle, parent, false)
                return ViewHolder(bindingStepTwo as StepperMiddleBinding)
            }
            STEPPER_THREE -> {
                bindingStepThree =
                    DataBindingUtil.inflate(inflater, R.layout.stepper_middle, parent, false)
                return ViewHolder(bindingStepThree as StepperMiddleBinding)
            }
            STEPPER_FOUR -> {
                bindingStepFour =
                    DataBindingUtil.inflate(inflater, R.layout.stepper_middle, parent, false)
                return ViewHolder(bindingStepFour as StepperMiddleBinding)
            }
            STEPPER_FIVE -> {
                bindingStepFive =
                    DataBindingUtil.inflate(inflater, R.layout.stepper_middle, parent, false)
                return ViewHolder(bindingStepFive as StepperMiddleBinding)
            }
            STEPPER_SIX -> {
                bindingStepSix =
                    DataBindingUtil.inflate(inflater, R.layout.stepper_middle, parent, false)
                return ViewHolder(bindingStepSix as StepperMiddleBinding)
            }
            STEPPER_SEVEN -> {
                bindingStepSeven =
                    DataBindingUtil.inflate(inflater, R.layout.stepper_ending, parent, false)
                return ViewHolder(bindingStepSeven as StepperEndingBinding)
            }

            else -> {
                val emptyLayout: ViewDataBinding? = DataBindingUtil.inflate(
                    inflater,
                    R.layout.empty_item, parent, false
                )
                return ViewHolder(emptyLayout as EmptyItemBinding)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //Constraint to make it 7 stepper max its limit number for steppers in layout.
        if (maxSteppers > 7) {
            setNumberOfStepsInStepperLayout(7)
        } else {
            setNumberOfStepsInStepperLayout(maxSteppers)
        }

        selectAccordingToInput(goToStep)

        for (i in 0 until descriptionListForSteps!!.size) {
            when (holder.itemViewType) {
                i -> {
                    //Setting Number On Steppers
                    holder.itemView.findViewById<TextView>(R.id.tv_LabelStepNumber)?.text = (position + 1).toString()

                    //Setting Descriptions On Steppers
                    descriptionListForSteps.let { descriptionContentList ->
                        holder.itemView.findViewById<TextView>(R.id.tv_LabelStepDescription)?.text =
                            descriptionContentList[position]
                    }
                }
            }
        }
    }

    override fun getItemCount() = descriptionListForSteps!!.size

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
            else -> {
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
                (bindingStepOne as StepperStartingBinding?)?.let { updateStepperLayout(it.mainStepperView) }
            }
            2 -> {
                (bindingStepOne as StepperStartingBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepTwo as StepperMiddleBinding?)?.let { updateStepperLayout(it.mainStepperView) }
            }
            3 -> {
                (bindingStepOne as StepperStartingBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepTwo as StepperMiddleBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepThree as StepperMiddleBinding?)?.let { updateStepperLayout(it.mainStepperView) }
            }
            4 -> {
                (bindingStepOne as StepperStartingBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepTwo as StepperMiddleBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepThree as StepperMiddleBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepFour as StepperMiddleBinding?)?.let { updateStepperLayout(it.mainStepperView) }
            }
            5 -> {
                (bindingStepOne as StepperStartingBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepTwo as StepperMiddleBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepThree as StepperMiddleBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepFour as StepperMiddleBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepFive as StepperMiddleBinding?)?.let { updateStepperLayout(it.mainStepperView) }
            }
            6 -> {
                (bindingStepOne as StepperStartingBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepTwo as StepperMiddleBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepThree as StepperMiddleBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepFour as StepperMiddleBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepFive as StepperMiddleBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepSix as StepperMiddleBinding?)?.let { updateStepperLayout(it.mainStepperView) }
            }
            7 -> {
                (bindingStepOne as StepperStartingBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepTwo as StepperMiddleBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepThree as StepperMiddleBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepFour as StepperMiddleBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepFive as StepperMiddleBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepSix as StepperMiddleBinding?)?.let { updateStepperLayout(it.mainStepperView) }
                (bindingStepSeven as StepperEndingBinding?)?.let { updateStepperLayout(it.mainStepperView) }
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
            StepperPosition.ONE -> {
                handleStepOne(statusState = PositionState.IN_PROGRESS)
                handleStepTwo(statusState = PositionState.PENDING)
                handleStepThree(statusState = PositionState.PENDING)
                handleStepFour(statusState = PositionState.PENDING)
                handleStepFive(statusState = PositionState.PENDING)
                handleStepSix(statusState = PositionState.PENDING)
                handleStepSeven(statusState = PositionState.PENDING)
            }
            StepperPosition.TWO -> {
                handleStepOne(statusState = PositionState.DONE)
                handleStepTwo(statusState = PositionState.IN_PROGRESS)
                handleStepThree(statusState = PositionState.PENDING)
                handleStepFour(statusState = PositionState.PENDING)
                handleStepFive(statusState = PositionState.PENDING)
                handleStepSix(statusState = PositionState.PENDING)
                handleStepSeven(statusState = PositionState.PENDING)
            }
            StepperPosition.THREE -> {
                handleStepOne(statusState = PositionState.DONE)
                handleStepTwo(statusState = PositionState.DONE)
                handleStepThree(statusState = PositionState.IN_PROGRESS)
                handleStepFour(statusState = PositionState.PENDING)
                handleStepFive(statusState = PositionState.PENDING)
                handleStepSix(statusState = PositionState.PENDING)
                handleStepSeven(statusState = PositionState.PENDING)
            }
            StepperPosition.FOUR -> {
                handleStepOne(statusState = PositionState.DONE)
                handleStepTwo(statusState = PositionState.DONE)
                handleStepThree(statusState = PositionState.DONE)
                handleStepFour(statusState = PositionState.IN_PROGRESS)
                handleStepFive(statusState = PositionState.PENDING)
                handleStepSix(statusState = PositionState.PENDING)
                handleStepSeven(statusState = PositionState.PENDING)
            }
            StepperPosition.FIVE -> {
                handleStepOne(statusState = PositionState.DONE)
                handleStepTwo(statusState = PositionState.DONE)
                handleStepThree(statusState = PositionState.DONE)
                handleStepFour(statusState = PositionState.DONE)
                handleStepFive(statusState = PositionState.IN_PROGRESS)
                handleStepSix(statusState = PositionState.PENDING)
                handleStepSeven(statusState = PositionState.PENDING)
            }
            StepperPosition.SIX -> {
                handleStepOne(statusState = PositionState.DONE)
                handleStepTwo(statusState = PositionState.DONE)
                handleStepThree(statusState = PositionState.DONE)
                handleStepFour(statusState = PositionState.DONE)
                handleStepFive(statusState = PositionState.DONE)
                handleStepSix(statusState = PositionState.IN_PROGRESS)
                handleStepSeven(statusState = PositionState.PENDING)
            }
            StepperPosition.SEVEN -> {
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

        when (statusState) {
            PositionState.PENDING -> {

                myPublicHelperClass.updateStatusItemForPendingState(
                    statusView = bindingStepOne,
                    isStepperOne = true,
                    isStepperTwo = false,
                    isStepperThree = false,
                    isStepperFour = false,
                    isStepperFive = false,
                    isStepperSix = false,
                    isStepperSeven = false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = pendingTextColor
                )
            }
            PositionState.IN_PROGRESS -> {

                myPublicHelperClass.updateStatusItemForInProgressState(
                    statusView = bindingStepOne,
                    isStepperOne = true,
                    isStepperTwo = false,
                    isStepperThree = false,
                    isStepperFour = false,
                    isStepperFive = false,
                    isStepperSix = false,
                    isStepperSeven = false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = inProgressTextColor
                )
            }
            PositionState.DONE -> {

                myPublicHelperClass.updateStatusItemForDoneState(
                    statusView = bindingStepOne,
                    isStepperOne = true,
                    isStepperTwo = false,
                    isStepperThree = false,
                    isStepperFour = false,
                    isStepperFive = false,
                    isStepperSix = false,
                    isStepperSeven = false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = completedTextColor
                )
            }
        }
    }

    private fun handleStepTwo(statusState: PositionState) {

        when (statusState) {
            PositionState.PENDING -> {

                myPublicHelperClass.updateStatusItemForPendingState(
                    statusView = bindingStepTwo,
                    isStepperOne = false,
                    isStepperTwo = true,
                    isStepperThree = false,
                    isStepperFour = false,
                    isStepperFive = false,
                    isStepperSix = false,
                    isStepperSeven = false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = pendingTextColor
                )
            }
            PositionState.IN_PROGRESS -> {

                myPublicHelperClass.updateStatusItemForInProgressState(
                    statusView = bindingStepTwo,
                    isStepperOne = false,
                    isStepperTwo = true,
                    isStepperThree = false,
                    isStepperFour = false,
                    isStepperFive = false,
                    isStepperSix = false,
                    isStepperSeven = false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = inProgressTextColor
                )
            }
            PositionState.DONE -> {

                myPublicHelperClass.updateStatusItemForDoneState(
                    statusView = bindingStepTwo,
                    isStepperOne = false,
                    isStepperTwo = true,
                    isStepperThree = false,
                    isStepperFour = false,
                    isStepperFive = false,
                    isStepperSix = false,
                    isStepperSeven = false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = completedTextColor
                )
            }
        }
    }

    private fun handleStepThree(statusState: PositionState) {

        when (statusState) {
            PositionState.PENDING -> {

                myPublicHelperClass.updateStatusItemForPendingState(
                    statusView = bindingStepThree,
                    isStepperOne = false,
                    isStepperTwo = false,
                    isStepperThree = true,
                    isStepperFour = false,
                    isStepperFive = false,
                    isStepperSix = false,
                    isStepperSeven = false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = pendingTextColor
                )
            }
            PositionState.IN_PROGRESS -> {

                myPublicHelperClass.updateStatusItemForInProgressState(
                    statusView = bindingStepThree,
                    isStepperOne = false,
                    isStepperTwo = false,
                    isStepperThree = true,
                    isStepperFour = false,
                    isStepperFive = false,
                    isStepperSix = false,
                    isStepperSeven = false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = inProgressTextColor
                )
            }
            PositionState.DONE -> {

                myPublicHelperClass.updateStatusItemForDoneState(
                    statusView = bindingStepThree,
                    isStepperOne = false,
                    isStepperTwo = false,
                    isStepperThree = true,
                    isStepperFour = false,
                    isStepperFive = false,
                    isStepperSix = false,
                    isStepperSeven = false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = completedTextColor
                )
            }
        }
    }

    private fun handleStepFour(statusState: PositionState) {

        when (statusState) {
            PositionState.PENDING -> {

                myPublicHelperClass.updateStatusItemForPendingState(
                    statusView = bindingStepFour,
                    isStepperOne = false,
                    isStepperTwo = false,
                    isStepperThree = false,
                    isStepperFour = true,
                    isStepperFive = false,
                    isStepperSix = false,
                    isStepperSeven = false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = pendingTextColor
                )
            }
            PositionState.IN_PROGRESS -> {

                myPublicHelperClass.updateStatusItemForInProgressState(
                    statusView = bindingStepFour,
                    isStepperOne = false,
                    isStepperTwo = false,
                    isStepperThree = false,
                    isStepperFour = true,
                    isStepperFive = false,
                    isStepperSix = false,
                    isStepperSeven = false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = inProgressTextColor
                )
            }
            PositionState.DONE -> {

                myPublicHelperClass.updateStatusItemForDoneState(
                    statusView = bindingStepFour,
                    isStepperOne = false,
                    isStepperTwo = false,
                    isStepperThree = false,
                    isStepperFour = true,
                    isStepperFive = false,
                    isStepperSix = false,
                    isStepperSeven = false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = completedTextColor
                )
            }
        }
    }

    private fun handleStepFive(statusState: PositionState) {

        when (statusState) {
            PositionState.PENDING -> {

                myPublicHelperClass.updateStatusItemForPendingState(
                    statusView = bindingStepFive,
                    isStepperOne = false,
                    isStepperTwo = false,
                    isStepperThree = false,
                    isStepperFour = false,
                    isStepperFive = true,
                    isStepperSix = false,
                    isStepperSeven = false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = pendingTextColor
                )
            }
            PositionState.IN_PROGRESS -> {

                myPublicHelperClass.updateStatusItemForInProgressState(
                    statusView = bindingStepFive,
                    isStepperOne = false,
                    isStepperTwo = false,
                    isStepperThree = false,
                    isStepperFour = false,
                    isStepperFive = true,
                    isStepperSix = false,
                    isStepperSeven = false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = inProgressTextColor
                )
            }
            PositionState.DONE -> {

                myPublicHelperClass.updateStatusItemForDoneState(
                    statusView = bindingStepFive,
                    isStepperOne = false,
                    isStepperTwo = false,
                    isStepperThree = false,
                    isStepperFour = false,
                    isStepperFive = true,
                    isStepperSix = false,
                    isStepperSeven = false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = completedTextColor
                )
            }
        }
    }

    private fun handleStepSix(statusState: PositionState) {

        when (statusState) {
            PositionState.PENDING -> {

                myPublicHelperClass.updateStatusItemForPendingState(
                    statusView = bindingStepSix,
                    isStepperOne = false,
                    isStepperTwo = false,
                    isStepperThree = false,
                    isStepperFour = false,
                    isStepperFive = false,
                    isStepperSix = true,
                    isStepperSeven = false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = pendingTextColor
                )
            }
            PositionState.IN_PROGRESS -> {

                myPublicHelperClass.updateStatusItemForInProgressState(
                    statusView = bindingStepSix,
                    isStepperOne = false,
                    isStepperTwo = false,
                    isStepperThree = false,
                    isStepperFour = false,
                    isStepperFive = false,
                    isStepperSix = true,
                    isStepperSeven = false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = inProgressTextColor
                )
            }
            PositionState.DONE -> {

                myPublicHelperClass.updateStatusItemForDoneState(
                    statusView = bindingStepSix,
                    isStepperOne = false,
                    isStepperTwo = false,
                    isStepperThree = false,
                    isStepperFour = false,
                    isStepperFive = false,
                    isStepperSix = true,
                    isStepperSeven = false,
                    tintStartLine = true, tintEndLine = true,
                    textColor = completedTextColor
                )
            }
        }
    }

    private fun handleStepSeven(statusState: PositionState) {

        when (statusState) {
            PositionState.PENDING -> {

                myPublicHelperClass.updateStatusItemForPendingState(
                    statusView = bindingStepSeven,
                    isStepperOne = false,
                    isStepperTwo = false,
                    isStepperThree = false,
                    isStepperFour = false,
                    isStepperFive = false,
                    isStepperSix = false,
                    isStepperSeven = true,
                    tintStartLine = true, tintEndLine = true,
                    textColor = pendingTextColor
                )
            }
            PositionState.IN_PROGRESS -> {

                myPublicHelperClass.updateStatusItemForInProgressState(
                    statusView = bindingStepSeven,
                    isStepperOne = false,
                    isStepperTwo = false,
                    isStepperThree = false,
                    isStepperFour = false,
                    isStepperFive = false,
                    isStepperSix = false,
                    isStepperSeven = true,
                    tintStartLine = true, tintEndLine = true,
                    textColor = inProgressTextColor
                )
            }
            PositionState.DONE -> {

                myPublicHelperClass.updateStatusItemForDoneState(
                    statusView = bindingStepSeven,
                    isStepperOne = false,
                    isStepperTwo = false,
                    isStepperThree = false,
                    isStepperFour = false,
                    isStepperFive = false,
                    isStepperSix = false,
                    isStepperSeven = true,
                    tintStartLine = true, tintEndLine = true,
                    textColor = completedTextColor
                )
            }
        }
    }
    //endregion

    //region Helper method for selection According to User specified Input from Main Activity
    fun selectAccordingToInput(goToStep: Int) {
        when (goToStep) {
            1 -> {
                updatePositionStatus(StepperPosition.ONE)
            }
            2 -> {
                updatePositionStatus(StepperPosition.TWO)
            }
            3 -> {
                updatePositionStatus(StepperPosition.THREE)
            }
            4 -> {
                updatePositionStatus(StepperPosition.FOUR)
            }
            5 -> {
                updatePositionStatus(StepperPosition.FIVE)
            }
            6 -> {
                updatePositionStatus(StepperPosition.SIX)
            }
            7 -> {
                updatePositionStatus(StepperPosition.SEVEN)
            }
        }
    }
    //endregion

    //region Helper method for deletion/hide According to User specified Input from Main Activity
    fun hideAccordingToInput(hideStepperPosition: Int) {
        when (hideStepperPosition) {
            1 -> {
                (bindingStepOne as StepperStartingBinding?)?.let {
                   // hideStepper(it.mainStepperView)
                    hideStepper.hideStepper(0, it.tvLabelStepDescription.text.toString())
                }
            }
            2 -> {
                (bindingStepTwo as StepperMiddleBinding?)?.let {
                   // hideStepper(it.mainStepperView)
                    hideStepper.hideStepper(1, it.tvLabelStepDescription.text.toString())
                }
            }
            3 -> {
                (bindingStepThree as StepperMiddleBinding?)?.let {
                   // hideStepper(it.mainStepperView)
                    hideStepper.hideStepper(2, it.tvLabelStepDescription.text.toString())
                }

            }
            4 -> {
                (bindingStepFour as StepperMiddleBinding?)?.let {
                   // hideStepper(it.mainStepperView)
                    hideStepper.hideStepper(3, it.tvLabelStepDescription.text.toString())
                }
            }
            5 -> {
                (bindingStepFive as StepperMiddleBinding?)?.let {
                   // hideStepper(it.mainStepperView)
                    hideStepper.hideStepper(4, it.tvLabelStepDescription.text.toString())
                }
            }
            6 -> {
                (bindingStepSix as StepperMiddleBinding?)?.let {
                   // hideStepper(it.mainStepperView)
                    hideStepper.hideStepper(5, it.tvLabelStepDescription.text.toString())
                }
            }
            7 -> {
                (bindingStepSeven as StepperEndingBinding?)?.let {
                   // hideStepper(it.mainStepperView)
                    hideStepper.hideStepper(6, it.tvLabelStepDescription.text.toString())
                }
            }
        }
    }

    fun deleteItem(position: Int) {
            if (descriptionListForSteps?.size == 1){
                val index = position-1
                if(index != -1){
                    descriptionListForSteps.removeAt(index)
                    notifyItemRemoved(index)
                    notifyItemRangeChanged(index, itemCount)
                }
                else{
                    descriptionListForSteps.removeAt(0)
                    notifyItemRemoved(0)
                    notifyItemRangeChanged(0, itemCount)
                }

            }
            else if (descriptionListForSteps?.size!! > 0) {
                if(position > descriptionListForSteps.size-1) {

                }
                else{
                    descriptionListForSteps.removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, itemCount)
                }
            }

    }
    //endregion


}