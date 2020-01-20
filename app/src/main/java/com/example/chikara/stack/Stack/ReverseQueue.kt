package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R
import java.util.*

class ReverseQueue : AppCompatActivity() {

    var queue: Queue<Int> = LinkedList()
    var stack: Stack<Int> = Stack()
    var deque : Deque<Int> = LinkedList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)

        deque.add(1)
        deque.add(2)
        deque.add(3)
        deque.add(4)
        deque.add(5)


//        reverseQueue()

        reverseSelectedCount()
    }

    private fun reverseQueue() {
        var element: Int? = null
        if (queue.isNotEmpty()) {
            element = queue.remove()
            reverseQueue()
        }

        if (null != element) {
            stack.add(element)
        }
    }

    private fun reverseSelectedCount() {
        val count = 2
        val tempStack: Stack<Int> = Stack()
        val tempQueue: Queue<Int> = LinkedList()

        while (queue.size != count)
            tempStack.push(queue.remove())

        while (tempStack.size != 0)
            tempQueue.add(tempStack.pop())

        while (queue.isNotEmpty())
            tempQueue.add(queue.remove())

        queue = tempQueue

        while (queue.isNotEmpty())
            Log.e("ELEMENT", "" + queue.remove())
    }

}