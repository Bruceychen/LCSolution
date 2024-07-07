package scalaLang.easy.q268

import java.lang.reflect.Array

// q268 #easy #missing-number #Scala
class Solution1 {
  def missingNumber(nums: Array[Int]): Int = {
    val resultCheckArr = Array.fill(nums.length + 1)(-1)
    nums.foreach(num => resultCheckArr(num) = 0)
    resultCheckArr.indexOf(-1)
  }
}
