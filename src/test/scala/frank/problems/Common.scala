package frank.problems

/**
  * Created by frank on 8/7/2019.
  */

import frank.sat.Formula
import org.scalatest.Matchers

trait Common extends Matchers {

  def reduceSat(reducer: Reduction[MonotoneNaeSat, MinXor2Sat], input: Formula) = {
    reducer.reduction(MonotoneNaeSat(input)) should matchPattern {
      case output:MinXor2Sat =>
    }
  }

  def composeReduceSat(reducer: Reduction[MonotoneNaeSat, MinXor2Sat], composer: Reduction[MinXor2Sat, KExactCover2], input: Formula) = {
    composer.reduction(reducer.reduction(MonotoneNaeSat(input))) should matchPattern {
      case output:KExactCover2 =>
    }
  }

  def reduceLogarithmic(reducer: Reduction[ExactSeparateCover2, ExactCover2], input: ExactSeparateCover2) = {
    reducer.reduction(input) should matchPattern {
      case output:ExactCover2 =>
    }
  }
}
