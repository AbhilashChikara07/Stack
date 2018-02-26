package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R
import java.util.*

/**
 * Created by chikara on 2/7/18.
 */

class ReverseStackUsingRecursive : AppCompatActivity() {

    var stackObj: Stack<Int>? = Stack()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)
        stackObj!!.push(8)
        stackObj!!.push(4)
        stackObj!!.push(1)
        stackObj!!.push(6)
        stackObj!!.push(11)
        stackObj!!.push(16)
        stackObj!!.push(0)

        makeStackEmpty()
        stackObj!!.pop()
        stackObj!!.pop()
        stackObj!!.pop()
        Log.e("top element :- ", "" + stackObj!!.peek())
    }

    private fun makeStackEmpty() {
        if (stackObj!!.size > 0) {
            val x = stackObj!!.pop()
            makeStackEmpty()
            reverseStack(x)
        }
    }

    private fun reverseStack(value: Int) {
        if (stackObj!!.isEmpty()) {
            stackObj!!.push(value)
        } else {
            if (stackObj!!.peek() > value) {
                val x = stackObj!!.pop()
                reverseStack(value)
                stackObj!!.push(x)
            }else{
                stackObj!!.push(value)
            }
        }
    }

}