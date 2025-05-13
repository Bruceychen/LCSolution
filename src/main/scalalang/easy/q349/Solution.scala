package main.scalalang.easy.q349

// q349 #easy #Intersection of Two Arrays #scala
object Solution {
  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    nums1.toSet.intersect(nums2.toSet).toArray
  }
}