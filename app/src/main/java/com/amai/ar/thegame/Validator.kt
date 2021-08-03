package com.amai.ar.thegame

import android.graphics.Color

object Validator {


    fun validatelogiccorrect(
            guessString : String,
            correctString : String) : Boolean
    {
        return true
    }

    fun validatelogicincorrect( guessString : String,
                                correctString : String) : Boolean
    {
        return false
    }

    fun validateled_color(color : Int) : String
    {
        var message : String? = null
        if (color == Color.RED)
        {
            message = "The button pressed was wrong for this position, and does not appear in a different position"
        }
        else if (color == Color.YELLOW)
        {
            message = "The button pressed was wrong for this position, but it DOES appear in a different position."
        }
        else if (color == Color.GREEN){
            message = "The button pressed was correct for this position."
        }
        else if (color == Color.DKGRAY){
            message = "There is no button pressed for this position yet."
        }

        return message!!
    }
}