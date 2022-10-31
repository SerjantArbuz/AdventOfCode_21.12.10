package sgtmelon.adventofcode.year15.day3

import org.koin.androidx.viewmodel.ext.android.viewModel
import sgtmelon.adventofcode.R
import sgtmelon.adventofcode.staff.parent.ParentTextSolutionActivity

/**
 * 2015 Day 3. Final time: 45.
 *
 * https://adventofcode.com/2015/day/3
 */
class SantaDirectionActivity : ParentTextSolutionActivity() {

    override val titleId: Int = R.string.year2015day3_title
    override val subtitleId: Int = R.string.year2015day3_subtitle

    private val viewModel by viewModel<SantaDirectionViewModel>()

    override fun setupObservers() {
        super.setupObservers()

        viewModel.uniqueHouses.observe(this) { setFirstText(it.toString()) }
        viewModel.workWithRobot.observe(this) { setSecondText(it.toString()) }
    }
}