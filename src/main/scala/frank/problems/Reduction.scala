package frank.problems

import frank.sat.{Clause, Formula}

/**
  * Created by frank on 8/7/2019.
  * The reduction of a problem into another one
  */
trait Reduction[U<:Instance, V<:Instance] {
  def reduction(input: U): V
}

object ReductionKnownNPComplete extends Reduction[MonotoneNaeSat, MinXor2Sat]{
  override def reduction(input: MonotoneNaeSat): MinXor2Sat = {

    val clauses: Seq[List[Clause]] = for {(clause, index) <- input.formula.clauses.zipWithIndex
                                     variable = input.formula.variables.max + 3*index} yield {
      List(Clause(variable + 1, variable + 2),
        Clause(variable + 1, variable + 3),
        Clause(variable + 2, variable + 3),
        Clause(variable + 1, clause.literals.zipWithIndex.find(_._2 == 0).get._1),
        Clause(variable + 2, clause.literals.zipWithIndex.find(_._2 == 1).get._1),
        Clause(variable + 3, clause.literals.zipWithIndex.find(_._2 == 2).get._1))

    }
    MinXor2Sat(input.formula.clauseCount, Formula(clauses.flatten: _*))
  }
}

object ReductionNewNPComplete extends Reduction[MinXor2Sat, KExactCover2]{
  override def reduction(input: MinXor2Sat): KExactCover2 = {

    val family: Seq[List[(Int, Int)]] = for {(clause, index) <- input.formula.clauses.zipWithIndex} yield {
      List((clause.literals.zipWithIndex.find(_._2 == 0).get._1, index + 1),
        (clause.literals.zipWithIndex.find(_._2 == 1).get._1, index + 1))
    }
    KExactCover2(input.formula.clauseCount, (1 to input.formula.clauseCount).toSet, family.flatten.groupBy(_._1).map(g => g._2.map(_._2).toSet).toList)
  }
}