package com.example.stepperwithrecyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.stepperwithrecyclerview.databinding.*

class ViewHolder : RecyclerView.ViewHolder {
    private var stepperItemOneBinding: StepperItemOneBinding? = null
    private var stepperItemTwoBinding: StepperItemTwoBinding? = null
    private var stepperItemThreeBinding: StepperItemThreeBinding? = null
    private var stepperItemFourBinding: StepperItemFourBinding? = null
    private var stepperItemFiveBinding: StepperItemFiveBinding? = null
    private var emptyItemBinding: EmptyItemBinding? = null

    constructor(bindingOne: StepperItemOneBinding) : super(bindingOne.root) {
        stepperItemOneBinding = bindingOne
    }

    constructor(bindingTwo: StepperItemTwoBinding) : super(bindingTwo.root) {
        stepperItemTwoBinding = bindingTwo
    }

    constructor(bindingThree: StepperItemThreeBinding) : super(bindingThree.root) {
        stepperItemThreeBinding = bindingThree
    }

    constructor(bindingFour: StepperItemFourBinding) : super(bindingFour.root) {
        stepperItemFourBinding = bindingFour
    }

    constructor(bindingFive: StepperItemFiveBinding) : super(bindingFive.root) {
        stepperItemFiveBinding = bindingFive
    }

    constructor(bindingEmptyLayout: EmptyItemBinding) : super(bindingEmptyLayout.root) {
        emptyItemBinding = bindingEmptyLayout
    }
}