package sgtmelon.adventofcode.useCase

import sgtmelon.adventofcode.model.LineType

class GetIncompletePointsUseCase {

    operator fun invoke(line: LineType.Incomplete): Long {
        var result = 0L

        /**
         * Reversed because we need start to take bracket points from the end of incomplete
         * sequence.
         */
        for (bracket in line.list.asReversed()) {
            result = result * 5 + bracket.closePair.incompletePoints
        }

        return result
    }
}