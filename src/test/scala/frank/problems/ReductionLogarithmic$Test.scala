package frank.problems

import org.scalatest.FlatSpec

/**
  * Created by frank on 8/7/2019.
  */
class ReductionLogarithmic$Test extends FlatSpec with Common {
  private val reducer = ReductionInLogarithmicSpace

  behavior of "ReductionLogarithmic$"

  it should "reduce in logarithmic space" in {

    reduceLogarithmic(reducer, ExactSeparateCover2(m = 1, universe = List(Set(1)), pairs = List((1, List(1)))))
    reduceLogarithmic(reducer, ExactSeparateCover2(m = 2, universe = List(Set(2, 3), Set(1), Set(4, 5)), pairs = List((1, List(1, 2)), (2, List(2, 3, 4)), (2, List(5)), (1, List(3)))))
    reduceLogarithmic(reducer, ExactSeparateCover2(m = 3, universe = List(Set(2, 3), Set(1), Set(4, 5)), pairs = List((1, List(1, 2)), (2, List(2, 3, 4)), (3, List(5)), (1, List(3, 4, 5)))))
    reduceLogarithmic(reducer, ExactSeparateCover2(m = 2, universe = List(Set(2, 3), Set(1), Set(4, 5)), pairs = List((1, List(1, 2)), (2, List(2, 3, 4)), (2, List(5)), (1, List(3)), (1, List(4, 5)))))


  }


}
