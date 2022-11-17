package sgtmelon.adventofcode.year15.day1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import sgtmelon.adventofcode.utils.launchBack
import sgtmelon.adventofcode.year15.day1.useCase.GetFloorAndBasementUseCase

class SantaFloorViewModelImpl(
    private val input: String,
    private val getFloorAndBasement: GetFloorAndBasementUseCase
) : ViewModel(),
    SantaFloorViewModel {

    init {
        viewModelScope.launchBack {
            val (floor, basementPosition) = getFloorAndBasement(input)

            this.floor.postValue(floor)
            this.basementPosition.postValue(basementPosition)
        }
    }

    override val floor: MutableLiveData<Int> = MutableLiveData()

    override val basementPosition: MutableLiveData<Int> = MutableLiveData()
}