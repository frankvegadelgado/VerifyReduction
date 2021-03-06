package frank.problems

/**
  * Created by frank on 8/7/2019.
  */

import frank.sat.{Formula, Satisfiable}
import frank.sat.solvers.XORSolver
import org.scalatest.Matchers
import org.scalatest.Inside._

trait Common extends Matchers {

  def reduceSat(reducer: Reduction[NaeSat, MinXor2Sat, Any], input: Formula) = {
    reducer.reduction(NaeSat(input)) should matchPattern {
      case output:MinXor2Sat =>
    }
  }

  def verifySat(verifier: Reduction[MinXor2Sat, Xor2Sat, Array[Int]], reducer: Reduction[NaeSat, MinXor2Sat, Any], input: Formula, certificate: Array[Int]) = {
    val value = verifier.reduction(reducer.reduction(NaeSat(input)), Some(certificate))
    value should matchPattern {
      case output: Xor2Sat =>
    }
    inside(value) {
      case output: Xor2Sat => XORSolver.solve(output.formula) should matchPattern {
        case Satisfiable() =>
        case Satisfiable(literals@_*) if !literals.isEmpty =>
      }
    }
  }
}
