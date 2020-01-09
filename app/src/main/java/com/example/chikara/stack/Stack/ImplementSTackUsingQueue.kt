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
    var queue: Queue<Int> = LinkedList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)
        /*
        * This problem can be done by using two method.
        * 1- By making enqueue operation complex
        * 2- By making dequeue operation complex
        * */

        push(1)
        push(2)
        push(3)
        push(4)
        push(5)

        /**
         * REMOVE ELEMENT
         * */
        pop()
        pop()

    }

    private fun push(item: Int) {
        queue.add(item)
    }

    private fun pop() {
        if (queue.isEmpty())
            return
        else {
            val tempQueue: Queue<Int> = LinkedList()
            while (queue.size != 1) {
                tempQueue.add(queue.peek())
                queue.remove()
            }
            /***
             * Remove last element
             * */
            queue.remove()
            /**
             * end
             * */

            queue = tempQueue
        }
    }

}