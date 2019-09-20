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

  def verifySat(verifier: Reduction[MinXor2Sat, MonotoneXor2Sat, Array[Int]], reducer: Reduction[MonotoneNaeSat, MinXor2Sat, Any], input: Formula, certificate: Array[Int]) = {
    verifier.reduction(reducer.reduction(MonotoneNaeSat(input)), Some(certificate)) should matchPattern {
      case output:MonotoneXor2Sat =>
    }
  }
}
