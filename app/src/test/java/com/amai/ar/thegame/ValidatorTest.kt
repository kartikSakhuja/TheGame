package com.amai.ar.thegame

import android.graphics.Color
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4 :: class)
class ValidatorTest {

  @Test
  fun validatelogiccorrect() {
    val result = Validator.validatelogiccorrect("ABC", "ABC")

    System.out.println(result)
  }

  @Test
  fun validatelogicincorrect(){
    val result = Validator.validatelogicincorrect("ABC", "BAC")

    System.out.println(result)
  }

  @Test

  fun validateled_color(){
    val result = Validator.validateled_color(Color.YELLOW)

    System.out.print(result);
  }

}