package sgtmelon.adventofcode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sgtmelon.adventofcode.model.LineType
import sgtmelon.adventofcode.useCase.GetIncompletePointsUseCase
import sgtmelon.adventofcode.useCase.GetLineTypeUseCase
import sgtmelon.adventofcode.useCase.GetMiddleValueUseCase
import sgtmelon.adventofcode.useCase.SplitTextUseCase

class SolutionViewModelImpl(
    private val input: String,
    private val splitText: SplitTextUseCase,
    private val getLineType: GetLineTypeUseCase,
    private val getIncompletePoints: GetIncompletePointsUseCase,
    private val getMiddleValue: GetMiddleValueUseCase
) : ViewModel(),
    SolutionViewModel {

    init {
        viewModelScope.launch(Dispatchers.IO) { calculatePoints() }
    }

    override val corruptedPoints: MutableLiveData<Int> = MutableLiveData()

    override val incompletePoints: MutableLiveData<Long> = MutableLiveData()

    private fun calculatePoints() {
        val lineList = splitText(input)

        var corruptedPoints = 0
        val incompleteList = mutableListOf<Long>()

        for (line in lineList) {
            when (val lineType = getLineType(line)) {
                is LineType.Corrupted -> corruptedPoints += lineType.bracket.corruptedPoint
                is LineType.Incomplete -> incompleteList.add(getIncompletePoints(lineType))
            }
        }

        this.corruptedPoints.postValue(corruptedPoints)
        this.incompletePoints.postValue(getMiddleValue(incompleteList))
    }
}