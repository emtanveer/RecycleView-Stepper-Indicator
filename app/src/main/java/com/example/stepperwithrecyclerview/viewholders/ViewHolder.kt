package com.example.stepperwithrecyclerview.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.stepperwithrecyclerview.databinding.*

class ViewHolder : RecyclerView.ViewHolder {
    private var stepperStartingBinding: StepperStartingBinding? = null
    private var stepperMiddleBinding: StepperMiddleBinding? = null
    private var stepperEndingBinding: StepperEndingBinding? = null
    private var emptyItemBinding: EmptyItemBinding? = null

    constructor(binding: StepperStartingBinding) : super(binding.root) {
        stepperStartingBinding = binding
    }

    constructor(binding: StepperMiddleBinding) : super(binding.root) {
        stepperMiddleBinding = binding
    }

    constructor(binding: StepperEndingBinding) : super(binding.root) {
        stepperEndingBinding = binding
    }

    constructor(bindingEmptyLayout: EmptyItemBinding) : super(bindingEmptyLayout.root) {
        emptyItemBinding = bindingEmptyLayout
    }
}