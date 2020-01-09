package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R
import java.util.*

class PrecticeStack : AppCompatActivity() {
    var stack = Stack<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)

        stack.push(5)
        stack.push(3)
        stack.push(4)
        stack.push(1)
        stack.push(6)
        stack.push(2)

        shortStack()
    }

    private fun shortStack() {
        val tempStack = Stack<Int>()
        while (stack.size > 0) {
            val item = stack.pop()
            if (tempStack.isEmpty())
                tempStack.push(item)
            else {
                while (tempStack.peek() > item) {
                    stack.push(tempStack.peek())
                }
                tempStack.push(item)
            }
        }
    }

}