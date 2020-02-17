package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.example.chikara.stack.R
import org.w3c.dom.Node
import java.lang.StringBuilder
import java.util.*

class PrecticeStack : AppCompatActivity() {

    var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)
        createList(1)
        createList(3)
        createList(2)
        createList(4)

        divideNodeList(head!!)
    }

    private fun createList(item: Int) {
        val node = getNode(item)
        if (null == head)
            head = node
        else {
            node.next = head
            head = node
        }
    }

    private fun getNode(item: Int): NodeClass {
        val node = NodeClass()
        node.data = item
        node.next = null
        return node
    }

    private fun divideNodeList(nodeList: NodeClass) {
        val tempNode = nodeList
        var firstHalf = tempNode
        var secondHalf = firstHalf.next

        while (null != firstHalf.next && null != secondHalf!!.next) {
            firstHalf = firstHalf.next!!
            secondHalf = secondHalf.next!!.next
        }

        secondHalf = firstHalf.next
        firstHalf.next = null
        firstHalf = tempNode

    }

}

class NodeClass {
    var next: NodeClass? = null
    var data: Int? = null
}
