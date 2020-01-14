package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R
import java.util.*

class ShortStackUsingRecursion : AppCompatActivity() {

    val shortStack: Stack<Int> = Stack()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)

        val stack = Stack<Int>()
        stack.push(4)
        stack.push(3)
        stack.push(7)
        stack.push(2)
        stack.push(9)

        shortStackUsingRecursion(stack)
        displayValue()
    }

    private fun shortStackUsingRecursion(stack: Stack<Int>) {
        var element: Int? = null
        if (stack.size > 0){
            element = stack.pop()
            shortStackUsingRecursion(stack)
        }
        if (element != null)
            shortStack(element)
    }

    private fun shortStack(item: Int) {
        if (shortStack.isEmpty() || shortStack.peek() < item) {
            shortStack.push(item)
            return
        }

        val element = shortStack.pop()
        shortStack(item)
        shortStack.push(element)
    }

    private fun displayValue() {
        while (shortStack.size>0){
            Log.e("VALUES",""+shortStack.pop())
        }
    }

}