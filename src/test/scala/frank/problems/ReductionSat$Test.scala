package frank.problems

import org.scalatest.FlatSpec
import frank.sat._
/**
  * Created by frank on 8/7/2019.
  */
class ReductionSat$Test extends FlatSpec with Common {
  private val reducer = ReductionKnownNPComplete

  behavior of "ReductionSat$"

  it should "reduce 3CNF formulas" in {
    reduceSat(reducer, Formula(Clause(1, 2, 3)))
    reduceSat(reducer, Formula(Clause(1, 2, 3), Clause(2, 5, 6)))
    reduceSat(reducer, Formula(Clause(1, 2, 3), Clause(2, 5, 6), Clause(1, 3, 4)))
    reduceSat(reducer, Formula(Clause(1, 2, 3), Clause(2, 5, 6), Clause(1, 3, 5)))


  }
}
