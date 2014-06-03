package org.zukkey40.example.scalafx.binding.number

import scalafx.Includes._
import scalafx.beans.property.IntegerProperty

/**
 * Created with IntelliJ IDEA.
 * User: 
 * Date: 2014/06/03
 *
 * Int型のプロパティとバインドのサンプルになります。
 *
 */
object NumberPropertyMain {
  def main(args: Array[String]) {
    val value: IntegerProperty = IntegerProperty(0)
    val plusTwoValue: IntegerProperty = IntegerProperty(0)

    //値を変更された場合に発生するイベントを設定する
    value.onChange{
      (_, oldValue, newValue) => println("value is changed: " + oldValue + " -> " + newValue)
    }

    //値を変更する
    value.set(3)
    value.set(7)

    //plusTwoValueの設定：value + 2 になるようにバインドする
    plusTwoValue <== value + 2

    //plusTwoValueの設定：値を変更された場合に発生するイベントを設定する
    plusTwoValue.onChange{
      (_, oldValue, newValue) => println("[+2] plusTwoValue is changed: " + oldValue + " -> " + newValue)
    }

    println()
    println("--- plusTwoValue is defined ---")
    println()

    //値を変更する
    value.set(10)
    value.set(20)

    //バインドされたプロパティを変更することはできない。
    //plusTwoValue.set(30)
  }
}
