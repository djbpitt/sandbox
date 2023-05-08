/** Longest common subsequence of variable number of sequences
 * Subsequences do not need to be contiguous
 *
 * Example: (0, 1, 2, 3, 4, 5) and (0, 4, 2, 3, 1, 5) => (0, 2, 3, 5)
 *
 * Based on: https://rosettacode.org/wiki/Longest_common_subsequence#Scala
 * Modified to accept more than two inputs
 *
 * TODO: foldLeft() initializes with first value and then folds in all
 *  values, including (redundantly) first. This is the implementation
 *  at https://leetcode.com/problems/intersection-of-multiple-arrays/solutions/2099253/scala-fold-left/
 *  In addition to redundancy, requires defining listified separately, instead of single pipeline.
 *  Can we initialize with head and then fold in just tail?
 */
def lcsLazy[T](inputs: Vector[IndexedSeq[T]]): IndexedSeq[T] =
  val listified =
    inputs
      .map(subsets(_).to(LazyList))
  val intersections = listified
    .foldLeft(listified.head)(_.intersect(_))
    .headOption match {
    case Some(sub) => sub
    case None => IndexedSeq[T]()
  }
  intersections
def subsets[T](u: IndexedSeq[T]): Iterator[IndexedSeq[T]] = {
  u.indices.reverseIterator.flatMap { n => u.indices.combinations(n + 1).map(_.map(u)) }
}

@main def main(): Unit =
  val u = Vector(0, 1, 2, 3, 4, 5)
  val v = Vector(0, 4, 2, 3, 1, 5)
  val w = Vector(0, 1, 2, 3, 4, 5)
  val x = Vector(0, 1, 2, 3, 4, 5)
  val y = Vector(0, 4, 2, 3, 1, 5)
  val z = Vector(0, 1, 2, 3, 4, 5)
  val resultInt = lcsLazy(Vector(u, v, w, x, y, z))
  println(resultInt)
  val a = Vector("a", "b", "c", "d", "e", "f")
  val b = Vector("a", "e", "c", "d", "b", "f")
  val resultStr = lcsLazy(Vector(a, b))
  println(resultStr)
