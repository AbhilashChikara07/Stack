package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.stack.R
import java.lang.NullPointerException

class ImplementStackByLinkedList : AppCompatActivity() {
    var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)

        push(1)
        push(2)
        push(3)
        push(4)
        push(5)
        traverseStack()
        pop()
        pop()
        traverseStack()

    }

    class NodeClass {
        var next: NodeClass? = null
        var data: Int = 0
    }

    private fun push(item: Int) {
        val tempNode = NodeClass()
        tempNode.data = item
        tempNode.next = null

        if (head == null)
            head = tempNode
        else {
            tempNode.next = head
            head = tempNode
        }
    }

    private fun pop(): Any {
        if (head != null) {
            return if (head!!.next == null) {
                val value = head!!.data
                head = null
                value
            } else {
                val value = head!!.data
                head = head!!.next
                return value
            }
        }
        return NullPointerException()
    }


    private fun traverseStack() {
        var tempNode = head
        val buffer = StringBuffer()

        while (tempNode != null) {
            buffer.append(tempNode.data)
            tempNode = tempNode.next
        }

        findViewById<TextView>(R.id.displayValue).text = buffer
    }

}