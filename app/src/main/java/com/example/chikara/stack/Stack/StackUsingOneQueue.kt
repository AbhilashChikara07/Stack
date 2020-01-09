package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R
import java.util.*

/**
 * Created by chikara on 2/6/18.
 */

class StackUsingOneQueue : AppCompatActivity() {

    var queue: Queue<Int> = LinkedList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)
        pushElement(1)
        pushElement(2)
        pushElement(3)
        pushElement(4)
        pushElement(5)
        getTopElement()
    }

    private fun pushElement(value: Int) {
        if (queue.isEmpty()) {
            queue.add(value)
        } else {
            queue.add(value)
            for (i in 0 until queue.size) {
                queue.add(queue.remove())
            }
        }
    }


    private fun pop() {
        if (queue.isEmpty())
            return
        else {
            queue.peek()
            queue.remove()
        }
    }


    private fun getTopElement() {
        Log.e("top element is :- ", "" + queue.peek())
    }

}
