package frank.problems

import frank.sat.{Clause, Formula}

/**
  * Created by frank on 8/7/2019.
  * The reduction of a problem into another one
  */
trait Reduction[U<:Instance, V<:Instance] {
  def reduction(input: U): V
}

/**
  * Theorem 9 in paper https://www.preprints.org/manuscript/201908.0037/v1
  */
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

/**
  * Theorem 10 in paper https://www.preprints.org/manuscript/201908.0037/v1
  */
object ReductionNewNPComplete extends Reduction[MinXor2Sat, KExactCover2]{
  override def reduction(input: MinXor2Sat): KExactCover2 = {

    val family: Seq[List[(Int, Int)]] = for {(clause, index) <- input.formula.clauses.zipWithIndex} yield {
      List((clause.literals.zipWithIndex.find(_._2 == 0).get._1, index + 1),
        (clause.literals.zipWithIndex.find(_._2 == 1).get._1, index + 1))
    }
    KExactCover2(input.formula.clauseCount, (1 to input.formula.clauseCount).toSet, family.flatten.groupBy(_._1).map(g => g._2.map(_._2).toSet).toList)
  }
}

/**
  * Theorem 11 in paper https://www.preprints.org/manuscript/201908.0037/v1
  */
object ReductionInLogarithmicSpace extends Reduction[ExactSeparateCover2, ExactCover2]{
  override def reduction(input: ExactSeparateCover2): ExactCover2 = {
    // Output the “universe" set U
    val universe: List[Int] = input.universe.flatten
    // if (universe.size != universe.toSet.size) throw new IllegalArgumentException("The input is not a valid instance")
    // Output the family of sets Si
    val family: IndexedSeq[Set[Int]] = for (i <- 1 to input.m) yield {
      val pairI = input.pairs.zipWithIndex.find(z => z._2 == i - 1).get._1
      var list = pairI._2
      for(j <- input.m + 1 to input.pairs.size){
        val pairJ = input.pairs.zipWithIndex.find(z => z._2 == j - 1).get._1
        if (pairI._1 == pairJ._1)
          // if (list.last > pairJ._2.head) throw new IllegalArgumentException("The input is not a valid instance")
          list = list ++ pairJ._2
      }
      // if (list.size != list.toSet.size) throw new IllegalArgumentException("The input is not a valid instance")
      list.toSet
    }
    ExactCover2(universe.toSet, family.toList)
  }
}