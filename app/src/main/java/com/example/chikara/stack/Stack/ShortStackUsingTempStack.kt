package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R
import java.util.*

/**
 * Created by chikara on 2/7/18.
 */

class ShortStackUsingTempStack : AppCompatActivity() {

    private var stackObj: Stack<Int>? = Stack()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)
        stackObj!!.push(2)
        stackObj!!.push(4)
        stackObj!!.push(1)
        stackObj!!.push(0)

        val mStack = shortStack()
        mStack.pop()
        mStack.pop()
        mStack.pop()

        Log.e("top element :- ", "" + mStack.peek())
    }

    private fun shortStack(): Stack<Int> {
        val tempStack: Stack<Int>? = Stack()
        while (stackObj!!.size > 0) {
            val value = stackObj!!.pop()
            if (tempStack!!.isEmpty()) {
                tempStack.push(value)
            } else {
                while (tempStack.peek() > value) {
                    stackObj!!.push(tempStack.pop())
                }
                tempStack.push(value)
            }
        }
        return tempStack!!
    }

}