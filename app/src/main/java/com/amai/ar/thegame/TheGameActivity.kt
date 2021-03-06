package com.amai.ar.thegame

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class TheGameActivity : AppCompatActivity() {

    private var textView_answer: TextView? = null
    private var textView_guess: TextView? = null
    private var buttonA: Button? = null
    private var buttonB: Button? = null
    private var buttonC: Button? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView_answer = findViewById(R.id.textView_answer) as TextView

        textView_guess = findViewById(R.id.textView_guess) as TextView


        buttonA = findViewById(R.id.buttonA) as Button
        buttonB = findViewById(R.id.buttonB) as Button
        buttonC = findViewById(R.id.buttonC) as Button

        guessPattern()


    }


    fun generateRandomPattern(len: Int): String {
        val chars = ("ABC")
        val rnd = Random()
        val sb = StringBuilder(len)
        for (i in 0 until len)
            sb.append(chars[rnd.nextInt(chars.length)])

        return "The correct answer is "+sb.toString()
    }

    fun guessPattern(): String {

        val notif: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notif.cancel(1) // clear previous notification
        val notification = Notification()
        notification.icon = R.drawable.ic_launcher_background

        val sb = StringBuilder()
        val str4 =sb.toString()

        buttonA!!.setOnClickListener {
            if (sb.length<3){
                sb.append("A")
                textView_guess?.text = sb
            }
            notification.ledARGB = Color.RED
        }

        buttonB!!.setOnClickListener {
            if (sb.length<3) {
                sb.append("B")

                textView_guess?.text = sb
            }
            notification.ledARGB = Color.GREEN
        }

        buttonC!!.setOnClickListener {
            if (sb.length<3) {
                sb.append("C")

                textView_guess?.text = sb
            }
            notification.ledARGB = Color.YELLOW
        }

        notification.ledARGB = Color.DKGRAY

        textView_guess?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 3) {
                    val a = generateRandomPattern(3)
                    Log.d("Apple ", a)
                    textView_answer?.text = a

                    if (a == textView_guess?.text.toString()) {
                        createDialog(a)
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        notification.ledOnMS = 1000
        notification.flags = notification.flags or Notification.FLAG_SHOW_LIGHTS
        notif.notify(1, notification)
        try {
            java.lang.Thread.sleep(1000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        return str4

    }

    fun createDialog(A: String){

        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("The Correct Answer is " + A)
        // set message of alert dialog
        dialogBuilder.setMessage("Restart Game")
                // if the dialog is cancelable
                .setCancelable(false)
                // positive button text and action
                .setPositiveButton("Proceed", DialogInterface.OnClickListener { dialog, id ->
                    textView_answer?.setText("")
                    textView_guess?.setText("")
                    guessPattern()
                })
                // negative button text and action
                .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                    dialog.cancel()
                })

        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("AlertDialogExample")
        // show alert dialog
        alert.show()
    }


}