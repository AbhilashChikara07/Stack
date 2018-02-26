package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.stack.R
import java.util.*

/**
 * Created by chikara on 2/22/18.
 */

class Demo : AppCompatActivity() {

    var stackObj: Stack<Int>? = Stack()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)
        pushElement(3)
        pushElement(1)
        pushElement(5)
        pushElement(0)
        pushElement(9)
        pushElement(6)
        getAllElement()
    }


    private fun pushElement(value: Int) {
        stackObj!!.push(value)
    }

    private fun getAllElement() {
        if (!stackObj!!.empty()) {
            val x = stackObj!!.pop()
            getAllElement()
            reverseElement(x)
        }
    }


    private fun reverseElement(x: Int) {
        if (stackObj!!.isEmpty()) {
            stackObj!!.push(x)
        } else {

        }
    }

}
