package com.example.stepperwithrecyclerview


/**
 * Position status Item state
 */
enum class PositionState(mode: Int) {
    /**
     * Pending state for layout appearance.
     */
    PENDING(0),

    /**
     * In progress Stepper status for layout appearance.
     */
    IN_PROGRESS(1),

    /**
     * Done/Completed Stepper status for layout appearance.
     */
    DONE(2),

}


enum class StepperPosition(val position: Int) {
    STEP_ONE(1),
    STEP_TWO(2),
    STEP_THREE(3),
    STEP_FOUR(4),
    STEP_FIVE(5),
}

