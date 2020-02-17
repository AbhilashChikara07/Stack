package com.example.chikara.stack.Queue

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.util.*
import kotlin.collections.HashMap

class LRUCashingByLinkedList : AppCompatActivity() {

    var head: NodeClass? = null
    var map: HashMap<Int, NodeClass?> = HashMap()
    var size: Int = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        insertItem(1)
        insertItem(2)
        insertItem(3)
        insertItem(1)

    }


    private fun insertItem(item: Int) {
        if (!map.containsKey(item)) {

            if (size == getListSize()) {
                val deleteNode = deleteLastElement()
                map.remove(deleteNode.data)
            }
            map[item] = getNode(item)

        } else {
            if (null == head) {
                val node = getNode(item)
                map[item] = node

            } else {
                val node = deleteSelectedNode(item)
                map.remove(node.data)

                map[item] = getNode(item)
            }

        }
    }

    private fun getNode(data: Int): NodeClass {
        val node = NodeClass()
        node.data = data
        node.next = null
        if (head == null)
            head = node
        else {
            node.next = head
            head = node
        }
        return node
    }

    private fun getListSize(): Int {
        return if (null == head)
            0
        else {
            var node = head
            var count: Int = 0
            while (node!!.next != null) {
                node = node.next
                count += 1
            }
            count
        }
    }

    private fun deleteSelectedNode(data: Int): NodeClass {
        var lastNode = head
        var tempNode = head

        while (data != tempNode!!.data) {
            lastNode = tempNode
            tempNode = tempNode.next
        }
        lastNode!!.next = tempNode.next
        return tempNode
    }

    private fun deleteLastElement(): NodeClass {
        var tempNode = head
        var lastNode = head

        while (null != tempNode!!.next) {
            lastNode = tempNode
            tempNode = tempNode.next
        }
        lastNode!!.next = null

        return lastNode
    }

}


class NodeClass() {
    var data: Int? = null
    var next: NodeClass? = null
}
