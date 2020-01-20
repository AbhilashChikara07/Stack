package com.example.chikara.stack.Queue

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.stack.R

class PriorityQueue : AppCompatActivity() {

    var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)

        addElement(1, 1)
        addElement(2, 2)
        addElement(3, 3)
        addElement(4, 4)
        addElement(0, 0)
        addElement(3, 3)
        addElement(0, 0)

        head

    }

    class NodeClass {
        var priority: Int = 0
        var data: Int = 0
        var next: NodeClass? = null
    }

    private fun getNode(): NodeClass = NodeClass()

    private fun addElement(data: Int, priority: Int) {
        if (head == null) {
            head = getNode()
            head!!.data = data
            head!!.next = null
            head!!.priority = priority
        } else {
            val tempNode = getNode()
            tempNode.data = data
            tempNode.priority = priority
            if (head!!.priority <= priority) {
                tempNode.next = head
                head = tempNode
            } else {
                var node = head
                var previous = node
                while (null != node!!.next) {
                    previous = node
                    node = node.next

                    if (node == null || node.next == null) {
                        node!!.next = tempNode
                        break
                    }

                    if (priority >= node.priority) {
                        previous.next = tempNode
                        tempNode.next = node
                        break
                    }

                }
            }
        }
    }

}