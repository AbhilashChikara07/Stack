package com.example.chikara.stack.Queue

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.util.*

class ReverseQueueByRecursion : AppCompatActivity() {
    var queue: Queue<Int> = LinkedList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        queue.add(1)
        queue.add(2)
        queue.add(3)
        queue.add(4)
    }

    private fun reverseQueue() {
        var element: Int? = null
        if (queue.isNotEmpty()) {
            element = queue.peek()
            queue.remove()
            reverseQueue()
        }

        if (element != null)
            queue.add(element)
    }

}