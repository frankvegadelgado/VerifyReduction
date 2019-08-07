package frank.problems

/**
  * Created by frank on 8/7/2019.
  */

import frank.sat.Formula
import org.scalatest.Matchers

trait Common extends Matchers {

  def reduceSat(reducer: Reduction[MonotoneNaeSat, MinXor2Sat, Any], input: Formula) = {
    reducer.reduction(MonotoneNaeSat(input)) should matchPattern {
      case output:MinXor2Sat =>
    }
  }

  def composeReduceSat(reducer: Reduction[MonotoneNaeSat, MinXor2Sat, Any], composer: Reduction[MinXor2Sat, KExactCover2, Any], input: Formula) = {
    composer.reduction(reducer.reduction(MonotoneNaeSat(input))) should matchPattern {
      case output:KExactCover2 =>
    }
  }

  def reduceLogarithmic(reducer: Reduction[ExactSeparateCover2, ExactCover2, Any], input: ExactSeparateCover2) = {
    reducer.reduction(input) should matchPattern {
      case output:ExactCover2 =>
    }
  }

  def verifySat(logarithmic: Reduction[ExactSeparateCover2, ExactCover2, Any], verifier: Reduction[KExactCover2, ExactSeparateCover2, Array[Int]], reducer: Reduction[MonotoneNaeSat, MinXor2Sat, Any], composer: Reduction[MinXor2Sat, KExactCover2, Any], input: Formula, certificate: Array[Int]) = {
    logarithmic.reduction(verifier.reduction(composer.reduction(reducer.reduction(MonotoneNaeSat(input))), Some(certificate))) should matchPattern {
      case output:ExactCover2 =>
    }
  }
}
