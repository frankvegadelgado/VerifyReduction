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

}
