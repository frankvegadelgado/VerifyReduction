# VerifyReduction
**Proof content links**
 
https://www.preprints.org/manuscript/201908.0037 

https://hal.archives-ouvertes.fr/hal-02199310

https://www.academia.edu/39973754/Logarithmic_Space_Verifiers_on_NP-complete

# Open Problem 

- P versus NP is considered as one of the most important open problems in computer science. This consists in knowing the answer of the following question: Is P equal to NP? A precise statement of the P versus NP problem was introduced independently by Stephen Cook and Leonid Levin. Since that date, all efforts to find a proof for this problem have failed. We show some results that prove this outstanding problem with the unexpected solution of P = NP.

# Overview

- In previous years there has been great interest in the verification or checking of computations. Interactive proofs introduced by Goldwasser, Micali and Rackoff and Babi can be viewed as a model of the verification process. Dwork and Stockmeyer and Condon have studied interactive proofs where the verifier is a space bounded computation instead of the original model where the verifer is a time bounded computation. In addition, Blum and Kannan has studied another model where the goal is to check a computation based solely on the final answer. More about probabilistic logarithmic space verifiers have been shown on a technique of Lipton. In this project, we show some results about the logarithmic space verifiers applied to the class NP which solve one of the most important open problems in computer science, that is P versus NP.

# Our Proof

We can define an NP problem as

L2 = {w: M(w, c) = y where y is in L1} (y is the output in the halting state)

when L1 is a language in P, M is a deterministic Turing machine that runs in polynomial time in the length of w and c (the certificate) is polynomially bounded by w. This is easy to prove since the polynomial time composition reduction can be done in polynomial time. Therefore, the previous definition complies with the existence of a polynomial time verifier M’ such that the NP problem L2 is defined as

L2 = {w: M'(w, c) = “yes”} (“yes” is the acceptance state)

where the computation of M'(w, c) is equal to N(M(w, c)) when N is the Turing machine which accepts L1 in polynomial time. On the other hand, the verifier for a language in NL (nondeterministic logarithmic space class) has as premise that the certificate c is placed in a special tape that is read only and read at once (that means we cannot read to the left).

In this project was proved that we can define an NP-complete problem as

L2 = {w: M(w, c) = y where y is in L1} (y is the output in the halting state)

when L1 is a language in L (deterministic logarithmic space class), M is a deterministic Turing machine that runs in logarithmic space in the length of w and c (the certificate) is polynomially bounded by w such that c is placed in the special tape in M that is read only and read at once.

We can simulate the computation M(w, c) = y by a nondeterministic logarithmic space Turing machine N, such that N(w) = y since we can read the certificate string c within the read-once tape by a work tape in a nondeterministic logarithmic space generation of symbols contained in c. Certainly, we can simulate the reading of one symbol from the string c into the read-once tape just nondeterministically generating the same symbol in the work tapes using a logarithmic space. 

Hartmanis and Mahaney have investigated the classes 1L and 1NL of languages recognizable by deterministic one-way logarithmic space Turing machine and nondeterministic one-way logarithmic space Turing machine, respectively. If we suppose that L is a proper subset of 1NL, then we can accept the elements of the language L1 in L by a nondeterministic one-way logarithmic space Turing machine M'. In this way, there is a nondeterministic logarithmic space Turing machine M''(w) = M'(N(w)) which will halt in the acceptance state when w is in L2. Consequently, M'' is a nondeterministic logarithmic space Turing machine which decides the language L2. The reason is because we can simulate the output string of N(w) within a read-once tape and thus, we can compute in a nondeterministic logarithmic space the logarithmic space composition using the same techniques of the logarithmic space composition reduction, but without any reset of the computation. Certainly, we do not need to reset the computation of N(w) for the reading at once of a symbol in the output string of N(w) by the nondeterministic one-way logarithmic space Turing machine M'. Therefore, L2 is in NL and thus, L2 is in P due to NL is a subset of P. If any single NP-complete problem can be solved in polynomial time, then P = NP. Since L2 is in P and L2 is in NP-complete, then we obtain the complexity class P is equal to NP under the assumption that L is a proper subset of 1NL.

Hartmanis and Mahaney have also shown with their result that if 1NL is a subset of L, then L=NL, because they proved there is a complete problem for both 1NL and NL at the same time. If this way, if L is not equal to NL, then L is a proper subset of 1NL by contraposition. Since we already obtained that P = NP under the assumption that L is a proper subset of 1NL, therefore if L is not equal to NL, then P = NP. 

The class LNL contains those languages that are decided by a nondeterministic logarithmic space Turing machine N such that for every element x = yz of these languages, there are a prefix and suffix substrings y and z where N moves strictly deterministically on y and strictly nondeterministically on z when strictly deterministically means there is no a possible nondeterministic step and strictly nondeterministically means there is at least one nondeterministic step on the computation.

Sauerhoff has shown the class BNL of languages recognizable by nondeterministic logarithmic space Turing machine, that only use nondeterministic moves before reading their input ("nondeterminism at the beginning").

We have that NL is a subset of LNL, because the prefix y of an instance x = yz could be the empty string. Certainly, all the languages in the class NL could be decided by nondeterministic logarithmic space Turing machines such that they always do a single nondeterministic step after the original acceptance state choosing nondeterministically the same acceptance state within two equals choices from the original and modified deterministic or nondeterministic logarithmic space Turing machines which decide these languages (this is assuming the prefix string y is the empty string in the elements x = yz). Moreover, we have that LNL is a subset of NL, because the languages in LNL are decided by nondeterministic logarithmic space Turing machines. Since NL is a subset of LNL and LNL is a subset of NL, then the complexity class LNL is equal to NL. However, we can state that BNL is not equal to LNL, because there is no possible way over the Definition of LNL for an element x = yz when the prefix y is the empty string in some languages in BNL, such that we could move strictly nondeterministically on y (that would be a "nondeterminism at the beginning") and move strictly deterministically on the nonempty string z. Hence, we obtain that BNL is not equal to NL by transitivity. Nevertheless, Sauerhoff has also shown that L is a subset of BNL and BNL is a subset of NL. Consequently, we prove the complexity class L is not equal to NL. Since we show that L is not equal to NL, then we prove the complexity class P is equal to NP.

# Programming Techniques

- In this Project, we use the Assertion on the properties of the instances of each problem and the Unit Test for checking the correctness of every reduction. We need to install JDK 8 in order to test the Scala Project. In addition, we need to install SBT to run the unit test (we could run the unit test with the **sbt test** command).

# Code

- Scala code by Frank Vega

# License
- MIT.
