package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.example.chikara.stack.R
import java.lang.StringBuilder
import java.util.*

class PrecticeStack : AppCompatActivity() {

    var unshortStack = Stack<Int>()
    var shortStack = Stack<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)

        unshortStack.push(5)
        unshortStack.push(3)
        unshortStack.push(4)
        unshortStack.push(1)
        unshortStack.push(6)
        unshortStack.push(2)

        shortStackWithRecursion()
        traverseStack()
    }


    private fun shortStackWithRecursion() {
        var item: Int? = null
        if (unshortStack.size > 0) {
            item = unshortStack.pop()
            shortStackWithRecursion()
        }
        if (item != null)
            shortStack(item)
    }

    private fun shortStack(item: Int) {
        if (shortStack.size == 0 || item < shortStack.peek()){
            shortStack.push(item)
            return
        }

        val lastElement = shortStack.pop()
        shortStack(item)
        shortStack.push(lastElement)

    }

    private fun traverseStack() {
        var stringBuffer: StringBuilder = StringBuilder()
        while (shortStack.size > 0) {
            val item = shortStack.pop()
            Log.e("stack", "" + item)
        }
    }

}