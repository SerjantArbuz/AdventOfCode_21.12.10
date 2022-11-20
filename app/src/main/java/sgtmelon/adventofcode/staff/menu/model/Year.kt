package sgtmelon.adventofcode.staff.menu.model


data class Year(val id: Int, val dayList: List<Day>) {

    val isAvailable = dayList.any { it.solution != Solution.NONE }

}