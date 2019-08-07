package frank.problems

import frank.sat.Formula

/**
  * Created by frank on 8/7/2019.
  * Instance of a problem
  */
sealed trait Instance

/**
  * A Boolean formula in 3CNF such that each clause has no negation
  * variables.
  * Question: Is there a truth assignment for the formula such that each clause has at least one true
  * literal and at least one false literal?
  * This problem is a known NP-complete language.
  */
case class MonotoneNaeSat(formula: Formula) extends Instance{
  assert(formula.isExactlyKSat(3), "Should be in 3CNF")
  assert(formula.isMonotoneSat, "Should be Monotone")
}

/**
  * A positive integer K and a Boolean formula that is an instance of
  * XOR 2SAT such that each clause has no negation variables.
  * Question: Is there a truth assignment in  such that at most K clauses are unsatisfiable?
  * This problem is in NP-complete.
  */
case class MinXor2Sat(K: Int, formula: Formula) extends Instance{
  assert(formula.isExactlyKSat(2), "Should be in 2CNF")
  assert(formula.isMonotoneSat, "Should be Monotone")
  assert(K > 0, "K should be a positive integer")
  assert(K <= formula.variableCount, "K should be at most all the clauses")

}

/**
  * A positive integer K, a “universe" set U of natural numbers and a family
  * of n sets Si is a subset of U with the property that every element in U appears at most twice in the list
  * S1, . . . , Sn.
  * Question: Is it the case there is a subfamily S1 , . . . , Sm with m <= n after removing K
  * different numbers in U from the whole list S1, . . . , Sn, such that Si intersect Sj = empty set
  * for 1 <= i != j <= m and S1 union . . . union Sm = U where U is equal to the set U without the removed K different numbers?
  * This problem is in NP-complete.
  */
case class KExactCover2(K: Int, U: Set[Int], family: List[Set[Int]]) extends Instance{
  assert(K > 0, "K should be a positive integer")
  assert(K <= U.size, "K should be at most all the elements in the universe")
  assert(family.forall(s => s.intersect(U) == s), "Si should be a subset of U")
  assert(family.flatten.toSet == U, "U should be the universe set")
  assert((family.map(_.toList).flatten.groupBy(identity).collect { case (x, List(_,_,_,_*)) => x }).size == 0, "Should every element in U appears at most twice in the list")

}


/**
  * A positive integer m, a family of sets U1, . . . ,Uk from a “universe" set
  * U1 union . . . union Uk = U and a collection of n pairs Ti = (x, Si) such that x is a positive integer
  * and Si is a subset of U is a set with the property that every element in U appears at most twice in the
  * list S1, . . . , Sn from the pairs T1, . . . , Tn. For every pair Tj = (x, Sj), the positive integer x
  * appears exactly once in a single pair Ti = (x, Si) for i <= m. We assume the elements in the
  * set Si of each pair Ti appear sorted in the input with ascending order. Moreover, a set Si
  * from a pair Ti could be equal to the empty set. Furthermore, if we have two pairs Ti = (x, Si) and
  * Tj = (y, Sj) such that x = y, i < j, Si != empty set and Sj != empty set, then the minimum element of Sj is
  * greater than the maximum element of Si.
  * Question: Is it the case there is a family of sets S1, . . . , Sn' with n' <= n, such that
  * Si intersect Sj = empty set for 1 <= i != j <= n' where Si is equal to the union of sets
  * Sj for all Tj = (y, Sj) when x = y for a single value x and S1 union . . . union Sn' = U?
  * This problem is in L.
  */
case class ExactSeparateCover2(m: Int, universe: List[Set[Int]], pairs: List[(Int, List[Int])]) extends Instance{
  assert(pairs.map(_._2).forall(s => s.toSet.intersect(universe.flatten.toSet) == s.toSet), "Si should be a subset of U for a pair pair Ti = (x, Si)")
  assert(pairs.map(_._2).flatten.toSet == universe.flatten.toSet, "U1 union . . . union Uk = U should be the universe set")
  assert((pairs.map(_._2).map(_.toList).flatten.groupBy(identity).collect { case (x, List(_,_,_,_*)) => x }).size == 0, "Should every element in U appears at most twice in the list S1, . . . , Sn from the pairs T1, . . . , Tn")
  assert(pairs.map(_._2).forall(s => s.sorted == s), "Should the elements in the set Si of each pair Ti appear sorted in the input with ascending order")
  assert(pairs.forall(p => pairs.take(m).exists(q => q._1 == p._1)), "Should every pair Tj = (x, Sj), the positive integer x appears exactly once in a single pair Ti = (x, Si) for i <= m")
  assert(pairs.groupBy(_._1).forall(g => g._2.flatMap(_._2).sorted == g._2.flatMap(_._2)), "Should we have two pairs Ti = (x, Si) and Tj = (y, Sj) such that x = y, i < j, Si != empty set and Sj != empty set, then the minimum element of Sj is greater than the maximum element of Si.")
}


/**
  * A “universe" set U and a family of n sets Si is a subset of U with the property that
  * every element in U appears at most twice in the list S1, . . . , Sn.
  * Question: Is it the case there is a subfamily S1, . . . , Sm with m <= n, such that
  * Si intersect Sj = empty set for 1 <= i != j <= m and S1 union . . . union Sm = U?
  * This problem is a known L language.
  */
case class ExactCover2(U: Set[Int], family: List[Set[Int]]) extends Instance{
  assert(family.forall(s => s.intersect(U) == s), "Si should be a subset of U")
  assert(family.flatten.toSet == U, "U should be the universe set")
  assert((family.map(_.toList).flatten.groupBy(identity).collect { case (x, List(_,_,_,_*)) => x }).size == 0, "Should every element in U appears at most twice in the list")

}

