# VerifyReduction
**Proof content links**
 
https://www.preprints.org/manuscript/201908.0037 

https://hal.archives-ouvertes.fr/hal-02199310

https://www.academia.edu/39973754/Logarithmic_Space_Verifiers_on_NP-complete

# Open Problem 

P versus NP is considered as one of the most important open problems in computer science. This consists in knowing the answer of the following question: Is P equal to NP? A precise statement of the P versus NP problem was introduced independently by Stephen Cook and Leonid Levin. Since that date, all efforts to find a proof for this problem have failed.

# Overview

In previous years there has been great interest in the verification or checking of computations. Interactive proofs introduced by Goldwasser, Micali and Rackoff and Babi can be viewed as a model of the verification process. Dwork and Stockmeyer and Condon have studied interactive proofs where the verifier is a space bounded computation instead of the original model where the verifer is a time bounded computation. In addition, Blum and Kannan has studied another model where the goal is to check a computation based solely on the final answer. Besides, a probabilistic logarithmic space verifiers have been shown for NP such that these are based on a technique of Lipton. In this project, we show some results about the logarithmic space verifiers applied to the class NP which solve one of the most important open problems in computer science, that is P versus NP.

# Our Proof

We can define an NP problem as

L2 = {w: M(w, c) = y where y is in L1} (y is the output in the halting state)

when L1 is a language in P, M is a deterministic Turing machine that runs in polynomial time in the length of w and c (the certificate) is polynomially bounded by w. This is easy to prove since the polynomial time composition reduction can be done in polynomial time. Therefore, the previous definition complies with the existence of a polynomial time verifier M’ such that the NP problem L2 is defined as

L2 = {w: M'(w, c) = “yes”} (“yes” is the acceptance state)

where the computation of M'(w, c) is equal to N(M(w, c)) when N is the Turing machine which accepts L1 in polynomial time. On the other hand, the verifier for a language in NL (nondeterministic logarithmic space class) has as premise that the certificate c is placed in a special tape that is read only and read at once (that means we cannot read to the left).

In this project was proved that we can define a NP-complete problem as

L2 = {w: M(w, c) = y where y is in L1} (y is the output in the halting state)

when L1 is a language in L (deterministic logarithmic space class), M is a deterministic Turing machine that runs in logarithmic space in the length of w and c (the certificate) is polynomially bounded by w such that c is placed in the special tape in M that is read only and read at once.

Since  the logarithmic space composition reduction can be done in logarithmic space, then this might be an evidence of the NP-complete L2 is in NL and thus in P since NL is contained in P. We can obtain the existence of a logarithmic space verifier M’ such that the NP-complete problem L2 is defined as

L2 = {w: M'(w, c) = “yes”} (“yes” is the acceptance state)

where the computation of M'(w, c) is equal to N(M(w, c)) when N is the Turing machine which accepts L1 in logarithmic space. The existence of N is possible because N could be a deterministic one-way logarithmic space Turing machine.

Certainly, the languages accepted by a deterministic one-way logarithmic space Turing machine coincide with the class L. A deterministic one-way logarithmic space Turing machine is not allowed to move the input head to the left. We already know every function f that is space constructible by a deterministic two-way Turing machine, is space constructible by a strongly f space-bounded deterministic one-way Turing machine as well. In this way, a space constructible strongly f logarithmic space-bounded is a logarithmic space computable function as well (The space constructible strongly mode means that the space is bounded by the condition that, given a function f, the Turing machine uses at most f(i) cells of the work tapes in any configuration with input head at position i, occurring in any accepting computation).

Since N is a deterministic one-way logarithmic space Turing machine, we do not have to reset the computation of M(w, c) into the whole computation of M'(w, c) = N(M(w, c)). If any single NP-complete problem can be solved in polynomial time, then P = NP. Since L2 is in P and L2 is in NP-complete, then we obtain the complexity class P is equal to NP.

# Programming Techniques

In this Project, we use the Assertion on the properties of the instances of each problem and the Unit Test for checking the correctness of every reduction. We need to install JDK 8 in order to test the Scala Project. In addition, we need to install SBT to run the unit test (we could run the unit test with the **sbt test** command).

# Runtime

This takes polynomial time because NL is a subset of P.

# Code

- Scala code by Frank Vega

# License
- MIT.
