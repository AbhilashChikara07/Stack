package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.chikara.stack.R

class ImplementTwoStackINAnArray : AppCompatActivity() {

    private var array = IntArray(10)
    private var secondArray = IntArray(10)
    private var stackOneTop: Int = 0
    private var stackTwoTop: Int = array.size


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)

    }

    private fun pushStackOne(element: Int) {
        if (stackOneTop < stackTwoTop - 1) {
            array[stackOneTop] = element
            stackOneTop++

        } else {

        }
    }

    private fun pushStackTwo(element: Int) {
        if (stackOneTop < stackTwoTop) {
            array[stackTwoTop] = element
            stackTwoTop--

        } else {

        }
    }

    private fun popFromStackOne() {
        if (stackOneTop > 0) {
            val temp = array[stackOneTop]
            stackOneTop--
            Toast.makeText(this,
                    "ELEMENT IS :- $temp",
                    Toast.LENGTH_SHORT).show()
        }
    }

    private fun popFromSecondStack() {
        if (stackTwoTop > 0) {
            val temp = array[stackTwoTop]
            stackTwoTop++
            Toast.makeText(this,
                    "ELEMENT IS :- $temp",
                    Toast.LENGTH_SHORT).show()
        }
    }

}