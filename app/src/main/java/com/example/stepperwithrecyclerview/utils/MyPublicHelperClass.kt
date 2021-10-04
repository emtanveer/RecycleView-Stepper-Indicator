package com.example.stepperwithrecyclerview.utils

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.ViewDataBinding
import com.example.stepperwithrecyclerview.R
import com.example.stepperwithrecyclerview.databinding.*
import java.util.*


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
        isStepperSix: Boolean,
        isStepperSeven: Boolean,
        tintStartLine: Boolean, tintEndLine: Boolean,
        textColor: Int
    ) {
        when {
            isStepperOne -> {
                val stepperOneStatusView = statusView as StepperStartingBinding
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
                val stepperTwoStatusView : StepperMiddleBinding? = statusView as StepperMiddleBinding?
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
                val stepperThreeStatusView :StepperMiddleBinding? = statusView as StepperMiddleBinding?
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
                val stepperFourStatusView : StepperMiddleBinding? = statusView as StepperMiddleBinding?
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
                val stepperFiveStatusView : StepperMiddleBinding? = statusView as StepperMiddleBinding?
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
            isStepperSix->{
                val stepperSixStatusView : StepperMiddleBinding? = statusView as StepperMiddleBinding?
                stepperSixStatusView?.numberParentContainer?.setBackgroundResource(
                    defaultBackgroundResourceID
                )

                if (tintStartLine) {
                    if (stepperSixStatusView != null) {
                        tintView(stepperSixStatusView.viewStartLine, defaultLine)
                    }
                }

                if (tintEndLine) {
                    if (stepperSixStatusView != null) {
                        tintView(
                            stepperSixStatusView.viewEndLine, defaultLine
                        )
                    }
                }

                stepperSixStatusView?.tvLabelStepDescription?.setTextColor(textColor)
            }
            isStepperSeven->{
                val stepperSevenStatusView : StepperEndingBinding? = statusView as StepperEndingBinding?
                stepperSevenStatusView?.numberParentContainer?.setBackgroundResource(
                    defaultBackgroundResourceID
                )

                if (tintStartLine) {
                    if (stepperSevenStatusView != null) {
                        tintView(stepperSevenStatusView.viewStartLine, defaultLine)
                    }
                }

                if (tintEndLine) {
                    if (stepperSevenStatusView != null) {
                        tintView(
                            stepperSevenStatusView.viewEndLine, defaultLine
                        )
                    }
                }

                stepperSevenStatusView?.tvLabelStepDescription?.setTextColor(textColor)
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
        isStepperSix: Boolean,
        isStepperSeven: Boolean,
        tintStartLine: Boolean, tintEndLine: Boolean,
        textColor: Int
    ) {
        when {
            isStepperOne -> {
                val stepperOneStatusView : StepperStartingBinding? = statusView as StepperStartingBinding?

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
                val stepperTwoStatusView : StepperMiddleBinding? = statusView as StepperMiddleBinding?

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
                val stepperThreeStatusView:StepperMiddleBinding? = statusView as StepperMiddleBinding?

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
                val stepperFourStatusView : StepperMiddleBinding? = statusView as StepperMiddleBinding?

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
                val stepperFiveStatusView : StepperMiddleBinding? = statusView as StepperMiddleBinding?

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
            isStepperSix->{
                val stepperSixStatusView : StepperMiddleBinding? = statusView as StepperMiddleBinding?

                stepperSixStatusView?.numberParentContainer?.setBackgroundResource(
                    inProgressBackgroundResourceID
                )

                if (tintStartLine) {
                    if (stepperSixStatusView != null) {
                        tintView(stepperSixStatusView.viewStartLine, inProgressLine)
                    }
                }

                if (tintEndLine) {
                    if (stepperSixStatusView != null) {
                        tintView(stepperSixStatusView.viewEndLine, inProgressLine)
                    }
                }

                stepperSixStatusView?.tvLabelStepDescription?.setTextColor(textColor)
            }
            isStepperSeven->{
                val stepperSevenStatusView : StepperEndingBinding? = statusView as StepperEndingBinding?

                stepperSevenStatusView?.numberParentContainer?.setBackgroundResource(
                    inProgressBackgroundResourceID
                )

                if (tintStartLine) {
                    if (stepperSevenStatusView != null) {
                        tintView(stepperSevenStatusView.viewStartLine, inProgressLine)
                    }
                }

                if (tintEndLine) {
                    if (stepperSevenStatusView != null) {
                        tintView(stepperSevenStatusView.viewEndLine, inProgressLine)
                    }
                }

                stepperSevenStatusView?.tvLabelStepDescription?.setTextColor(textColor)
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
        isStepperSix: Boolean,
        isStepperSeven: Boolean,
        tintStartLine: Boolean, tintEndLine: Boolean,
        textColor: Int
    ) {
        when {
            isStepperOne -> {
                val stepperOneStatusView : StepperStartingBinding? = statusView as StepperStartingBinding?
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
                val stepperTwoStatusView : StepperMiddleBinding? = statusView as StepperMiddleBinding?
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
                val stepperThreeStatusView : StepperMiddleBinding? = statusView as StepperMiddleBinding?
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
                val stepperFourStatusView : StepperMiddleBinding? = statusView as StepperMiddleBinding?
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
                val stepperFiveStatusView : StepperMiddleBinding?= statusView as StepperMiddleBinding?
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
            isStepperSix->{
                val stepperSixStatusView : StepperMiddleBinding?= statusView as StepperMiddleBinding?
                stepperSixStatusView?.numberParentContainer?.setBackgroundResource(
                    completedBackground
                )

                if (tintStartLine) {
                    if (stepperSixStatusView != null) {
                        tintView(stepperSixStatusView.viewStartLine, completedLine)
                    }
                }

                if (tintEndLine) {
                    if (stepperSixStatusView != null) {
                        tintView(stepperSixStatusView.viewEndLine, completedLine)
                    }
                }

                stepperSixStatusView?.tvLabelStepDescription?.setTextColor(textColor)
            }
            isStepperSeven->{
                val stepperSevenStatusView : StepperEndingBinding?= statusView as StepperEndingBinding?
                stepperSevenStatusView?.numberParentContainer?.setBackgroundResource(
                    completedBackground
                )

                if (tintStartLine) {
                    if (stepperSevenStatusView != null) {
                        tintView(stepperSevenStatusView.viewStartLine, completedLine)
                    }
                }

                if (tintEndLine) {
                    if (stepperSevenStatusView != null) {
                        tintView(stepperSevenStatusView.viewEndLine, completedLine)
                    }
                }

                stepperSevenStatusView?.tvLabelStepDescription?.setTextColor(textColor)
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


    //region Helper Method for setting locale/Language
    fun setLanguage(lang: String?) {
        val localeNew = Locale(lang)
        Locale.setDefault(localeNew)
        val res: Resources = context.resources
        val newConfig = Configuration(res.configuration)
        newConfig.locale = localeNew
        newConfig.setLayoutDirection(localeNew)
        res.updateConfiguration(newConfig, res.displayMetrics)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            newConfig.setLocale(localeNew)
            context.createConfigurationContext(newConfig)
        }
    }
    //endregion
}



