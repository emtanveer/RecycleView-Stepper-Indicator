package com.example.stepperwithrecyclerview.utils


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
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7)
}

