package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R
import java.util.*

/**
 * Created by chikara on 2/5/18.
 */

class ImplementSTackUsingQueue : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)
        /*
        * This problem can be done by using two method.
        * 1- By making enqueue operation complex
        * 2- By making dequeue operation complex
        * */

        val queueObj: Queue? = Queue()
        insertValueIntoQueue(queueObj!!.stack_1, 1)
        insertValueIntoQueue(queueObj.stack_1, 2)
        insertValueIntoQueue(queueObj.stack_1, 3)
        insertValueIntoQueue(queueObj.stack_1, 4)
        insertValueIntoQueue(queueObj.stack_1, 5)

        deleteFromQueue(queueObj.stack_1!!, queueObj.stack_2!!)
    }


    inner class Queue {
        var stack_1: Stack<Int>? = Stack()
        var stack_2: Stack<Int>? = Stack()
    }

    private fun insertValueIntoQueue(stack_1: Stack<Int>?, i: Int) {
        stack_1!!.push(i)
    }

    private fun deleteFromQueue(stack_1: Stack<Int>, stack_2: Stack<Int>) {
        if (stack_1.empty() && stack_2.empty()) {
            Log.e("stack status", "stacks are empty")
        } else {
            while (!stack_1.empty()) {
                stack_2.push(stack_1.pop())
            }
            Log.e("DEQUEUE VALUE IS :- ", "" + stack_2.pop())
        }
    }

}