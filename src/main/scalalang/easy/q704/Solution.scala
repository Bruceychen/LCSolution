package main.scalalang.easy.q704

import java.lang.reflect.Array

object Solution {
  def binarySearch(array: Array[Int], target: Int): Int = {
    var left = 0;
    var right = array.length - 1;
    while (left <= right) {
      val mid = left + (right - left) / 2
      if (array[mid] == target) {
        return mid;
      }
      if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    -1
  }
}