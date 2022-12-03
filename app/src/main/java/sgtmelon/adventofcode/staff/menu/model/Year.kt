package sgtmelon.adventofcode.staff.menu.model

data class Year(val id: Int, val dayList: List<Day>) {

    val doneCount = dayList.count { it.solution == Solution.FULL }

}