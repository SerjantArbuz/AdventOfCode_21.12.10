package sgtmelon.adventofcode.year15.day3

import sgtmelon.adventofcode.staff.parent.textSolution.TextSolutionViewModelImpl
import sgtmelon.adventofcode.year15.day3.useCase.GetUniqueHousesUseCase
import sgtmelon.adventofcode.year15.day3.useCase.GetWithRobotHousesUseCase

class SantaDirectionViewModel(
    private val input: String,
    private val getUniqueHouses: GetUniqueHousesUseCase,
    private val getWithRobotHouses: GetWithRobotHousesUseCase
) : TextSolutionViewModelImpl() {

    override suspend fun calculatePuzzle() {
        firstValue.postValue(getUniqueHouses(input).size.toString())
        secondValue.postValue(getWithRobotHouses(input).size.toString())
    }
}