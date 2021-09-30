package com.example.stepperwithrecyclerview

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.ViewDataBinding
import com.example.stepperwithrecyclerview.databinding.*


class MyPublicHelperClass(private val context: Context) {

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

    //region Generic methods for view appearance and styles

    fun updateStatusItemForPendingState(
        statusView: ViewDataBinding?,
        isStepperOne: Boolean,
        isStepperTwo: Boolean,
        isStepperThree: Boolean,
        isStepperFour: Boolean,
        isStepperFive: Boolean,
        tintStartLine: Boolean, tintEndLine: Boolean,
        textColor: Int
    ) {
        when {
            isStepperOne -> {
                val stepperOneStatusView = statusView as StepperItemOneBinding
                stepperOneStatusView.numberParentContainer.setBackgroundResource(
                    defaultBackgroundResourceID
                )

                if (tintStartLine) {
                    tintView(stepperOneStatusView.viewStartLine, defaultLine)
                }

                if (tintEndLine) {
                    tintView(stepperOneStatusView.viewEndLine, defaultLine)
                }

                stepperOneStatusView.tvLabelStepDescription.setTextColor(textColor)
            }
            isStepperTwo -> {
                val stepperTwoStatusView : StepperItemTwoBinding? = statusView as StepperItemTwoBinding?
                stepperTwoStatusView?.numberParentContainer?.setBackgroundResource(
                    defaultBackgroundResourceID
                )

                if (tintStartLine) {
                    if (stepperTwoStatusView != null) {
                        tintView(stepperTwoStatusView.viewStartLine, defaultLine)
                    }
                }

                if (tintEndLine) {
                    if (stepperTwoStatusView != null) {
                        tintView(stepperTwoStatusView.viewEndLine, defaultLine)
                    }
                }

                stepperTwoStatusView?.tvLabelStepDescription?.setTextColor(textColor)
            }
            isStepperThree -> {
                val stepperThreeStatusView :StepperItemThreeBinding? = statusView as StepperItemThreeBinding?
                stepperThreeStatusView?.numberParentContainer?.setBackgroundResource(
                    defaultBackgroundResourceID
                )

                if (tintStartLine) {
                    if (stepperThreeStatusView != null) {
                        tintView(stepperThreeStatusView.viewStartLine, defaultLine)
                    }
                }

                if (tintEndLine) {
                    if (stepperThreeStatusView != null) {
                        tintView(stepperThreeStatusView.viewEndLine, defaultLine)
                    }
                }

                stepperThreeStatusView?.tvLabelStepDescription?.setTextColor(textColor)
            }
            isStepperFour -> {
                val stepperFourStatusView : StepperItemFourBinding? = statusView as StepperItemFourBinding?
                stepperFourStatusView?.numberParentContainer?.setBackgroundResource(
                    defaultBackgroundResourceID
                )

                if (tintStartLine) {
                    if (stepperFourStatusView != null) {
                        tintView(stepperFourStatusView.viewStartLine, defaultLine)
                    }
                }

                if (tintEndLine) {
                    if (stepperFourStatusView != null) {
                        tintView(stepperFourStatusView.viewEndLine, defaultLine)
                    }
                }

                stepperFourStatusView?.tvLabelStepDescription?.setTextColor(textColor)
            }
            isStepperFive -> {
                val stepperFiveStatusView : StepperItemFiveBinding? = statusView as StepperItemFiveBinding?
                stepperFiveStatusView?.numberParentContainer?.setBackgroundResource(
                    defaultBackgroundResourceID
                )

                if (tintStartLine) {
                    if (stepperFiveStatusView != null) {
                        tintView(stepperFiveStatusView.viewStartLine, defaultLine)
                    }
                }

                if (tintEndLine) {
                    if (stepperFiveStatusView != null) {
                        tintView(
                            stepperFiveStatusView.viewEndLine, defaultLine
                        )
                    }
                }

                stepperFiveStatusView?.tvLabelStepDescription?.setTextColor(textColor)
            }
            else -> {

            }
        }
    }

    fun updateStatusItemForInProgressState(
        statusView: ViewDataBinding?,
        isStepperOne: Boolean,
        isStepperTwo: Boolean,
        isStepperThree: Boolean,
        isStepperFour: Boolean,
        isStepperFive: Boolean,
        tintStartLine: Boolean, tintEndLine: Boolean,
        textColor: Int
    ) {
        when {
            isStepperOne -> {
                val stepperOneStatusView : StepperItemOneBinding? = statusView as StepperItemOneBinding?

                stepperOneStatusView?.numberParentContainer?.setBackgroundResource(
                    inProgressBackgroundResourceID
                )

                if (tintStartLine) {
                    if (stepperOneStatusView != null) {
                        tintView(stepperOneStatusView.viewStartLine, inProgressLine)
                    }
                }

                if (tintEndLine) {
                    if (stepperOneStatusView != null) {
                        tintView(stepperOneStatusView.viewEndLine, inProgressLine)
                    }
                }

                stepperOneStatusView?.tvLabelStepDescription?.setTextColor(textColor)
            }
            isStepperTwo -> {
                val stepperTwoStatusView : StepperItemTwoBinding? = statusView as StepperItemTwoBinding?

                stepperTwoStatusView?.numberParentContainer?.setBackgroundResource(
                    inProgressBackgroundResourceID
                )

                if (tintStartLine) {
                    if (stepperTwoStatusView != null) {
                        tintView(stepperTwoStatusView.viewStartLine, inProgressLine)
                    }
                }

                if (tintEndLine) {
                    if (stepperTwoStatusView != null) {
                        tintView(stepperTwoStatusView.viewEndLine, inProgressLine)
                    }
                }

                stepperTwoStatusView?.tvLabelStepDescription?.setTextColor(textColor)
            }
            isStepperThree -> {
                val stepperThreeStatusView:StepperItemThreeBinding? = statusView as StepperItemThreeBinding?

                stepperThreeStatusView?.numberParentContainer?.setBackgroundResource(
                    inProgressBackgroundResourceID
                )

                if (tintStartLine) {
                    if (stepperThreeStatusView != null) {
                        tintView(stepperThreeStatusView.viewStartLine, inProgressLine)
                    }
                }

                if (tintEndLine) {
                    if (stepperThreeStatusView != null) {
                        tintView(stepperThreeStatusView.viewEndLine, inProgressLine)
                    }
                }

                stepperThreeStatusView?.tvLabelStepDescription?.setTextColor(textColor)
            }
            isStepperFour -> {
                val stepperFourStatusView : StepperItemFourBinding? = statusView as StepperItemFourBinding?

                stepperFourStatusView?.numberParentContainer?.setBackgroundResource(
                    inProgressBackgroundResourceID
                )

                if (tintStartLine) {
                    if (stepperFourStatusView != null) {
                        tintView(stepperFourStatusView.viewStartLine, inProgressLine)
                    }
                }

                if (tintEndLine) {
                    if (stepperFourStatusView != null) {
                        tintView(stepperFourStatusView.viewEndLine, inProgressLine)
                    }
                }

                stepperFourStatusView?.tvLabelStepDescription?.setTextColor(textColor)
            }
            isStepperFive -> {
                val stepperFiveStatusView : StepperItemFiveBinding? = statusView as StepperItemFiveBinding?

                stepperFiveStatusView?.numberParentContainer?.setBackgroundResource(
                    inProgressBackgroundResourceID
                )

                if (tintStartLine) {
                    if (stepperFiveStatusView != null) {
                        tintView(stepperFiveStatusView.viewStartLine, inProgressLine)
                    }
                }

                if (tintEndLine) {
                    if (stepperFiveStatusView != null) {
                        tintView(stepperFiveStatusView.viewEndLine, inProgressLine)
                    }
                }

                stepperFiveStatusView?.tvLabelStepDescription?.setTextColor(textColor)
            }
            else -> {

            }
        }

    }

    fun updateStatusItemForDoneState(
        statusView: ViewDataBinding?,
        isStepperOne: Boolean,
        isStepperTwo: Boolean,
        isStepperThree: Boolean,
        isStepperFour: Boolean,
        isStepperFive: Boolean,
        tintStartLine: Boolean, tintEndLine: Boolean,
        textColor: Int
    ) {
        when {
            isStepperOne -> {
                val stepperOneStatusView : StepperItemOneBinding? = statusView as StepperItemOneBinding?
                stepperOneStatusView?.numberParentContainer?.setBackgroundResource(completedBackground)

                if (tintStartLine) {
                    if (stepperOneStatusView != null) {
                        tintView(stepperOneStatusView.viewStartLine, completedLine)
                    }
                }

                if (tintEndLine) {
                    if (stepperOneStatusView != null) {
                        tintView(stepperOneStatusView.viewEndLine, completedLine)
                    }
                }

                stepperOneStatusView?.tvLabelStepDescription?.setTextColor(textColor)
            }
            isStepperTwo -> {
                val stepperTwoStatusView : StepperItemTwoBinding? = statusView as StepperItemTwoBinding?
                stepperTwoStatusView?.numberParentContainer?.setBackgroundResource(completedBackground)

                if (tintStartLine) {
                    if (stepperTwoStatusView != null) {
                        tintView(stepperTwoStatusView.viewStartLine, completedLine)
                    }
                }

                if (tintEndLine) {
                    if (stepperTwoStatusView != null) {
                        tintView(stepperTwoStatusView.viewEndLine, completedLine)
                    }
                }

                stepperTwoStatusView?.tvLabelStepDescription?.setTextColor(textColor)
            }
            isStepperThree -> {
                val stepperThreeStatusView : StepperItemThreeBinding? = statusView as StepperItemThreeBinding?
                stepperThreeStatusView?.numberParentContainer?.setBackgroundResource(
                    completedBackground
                )

                if (tintStartLine) {
                    if (stepperThreeStatusView != null) {
                        tintView(stepperThreeStatusView.viewStartLine, completedLine)
                    }
                }

                if (tintEndLine) {
                    if (stepperThreeStatusView != null) {
                        tintView(stepperThreeStatusView.viewEndLine, completedLine)
                    }
                }

                stepperThreeStatusView?.tvLabelStepDescription?.setTextColor(textColor)
            }
            isStepperFour -> {
                val stepperFourStatusView : StepperItemFourBinding? = statusView as StepperItemFourBinding?
                stepperFourStatusView?.numberParentContainer?.setBackgroundResource(
                    completedBackground
                )

                if (tintStartLine) {
                    if (stepperFourStatusView != null) {
                        tintView(stepperFourStatusView.viewStartLine, completedLine)
                    }
                }

                if (tintEndLine) {
                    if (stepperFourStatusView != null) {
                        tintView(stepperFourStatusView.viewEndLine, completedLine)
                    }
                }

                stepperFourStatusView?.tvLabelStepDescription?.setTextColor(textColor)
            }
            isStepperFive -> {
                val stepperFiveStatusView : StepperItemFiveBinding?= statusView as StepperItemFiveBinding?
                stepperFiveStatusView?.numberParentContainer?.setBackgroundResource(
                    completedBackground
                )

                if (tintStartLine) {
                    if (stepperFiveStatusView != null) {
                        tintView(stepperFiveStatusView.viewStartLine, completedLine)
                    }
                }

                if (tintEndLine) {
                    if (stepperFiveStatusView != null) {
                        tintView(stepperFiveStatusView.viewEndLine, completedLine)
                    }
                }

                stepperFiveStatusView?.tvLabelStepDescription?.setTextColor(textColor)
            }
            else -> {

            }
        }

    }

    private fun tintView(view: View, tintColor: Int) {
        view.setBackgroundColor(tintColor)
    }

    /**
     * Handle Line separator between Position Status display logic
     */
    private fun updateDisplayLineSeparator(view: View, display: Boolean) {
        view.isVisible = display
    }

    //endregion
}



