package sgtmelon.adventofcode.staff.parent.textSolution

/**
 * Parent class for solutions with 2 text fields and implemented [viewModel].
 */
abstract class TextSolutionActivity : SolutionActivity() {

    abstract val viewModel: TextSolutionViewModel

    override fun setupObservers() {
        super.setupObservers()

        viewModel.loading.observe(this) { changeProgress(it) }
        viewModel.firstValue.observe(this) { setFirstText(it.toString()) }
        viewModel.secondValue.observe(this) { setSecondText(it.toString()) }
    }
}