package com.example.chikara.stack.Queue

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.util.*

class ShortQueueWithRecursive : AppCompatActivity() {

    var queue: Queue<Int> = LinkedList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        queue.add(1)
        queue.add(5)
        queue.add(2)
        queue.add(4)

        shortByRecursive()
         queue
    }

    private fun shortByRecursive() {
        var element: Int? = null
        if (queue.isNotEmpty()) {
            element = queue.remove()
            shortByRecursive()
        }

        if (null != element)
            short(element)
    }

    private fun short(item: Int) {
        if(queue.isEmpty()|| queue.peek()<item){
            queue.add(item)
            return
        }

        val element = queue.remove()
        short(item)
        queue.add(element)

    }

}