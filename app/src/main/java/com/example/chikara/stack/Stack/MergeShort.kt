package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R

/**
 * Created by chikara on 2/23/18.
 */

class MergeShort : AppCompatActivity() {

    private var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)
        createList(4)
        createList(1)
        createList(9)
        createList(2)
        createList(8)

        var tempHead = divideList(head!!)
        displayElement(tempHead!!)
    }

    private fun displayElement(tempHead: NodeClass) {
        val textValue = StringBuilder()
        var tempHead: NodeClass? = tempHead
        while (tempHead != null) {
            textValue.append(tempHead.value)
            tempHead = tempHead.next
        }
        Log.e("textValue", "" + textValue)
    }

    class NodeClass() {
        var value: Int? = null
        var next: NodeClass? = null

        constructor(tempValue: Int) : this() {
            this.value = tempValue
        }
    }

    private fun createList(value: Int) {
        if (head == null) {
            head = NodeClass(value)
            head!!.next = null
        } else {
            val tempNode = NodeClass(value)
            tempNode.next = head
            head = tempNode
        }
    }


    private fun divideList(tempHead: NodeClass?): NodeClass? {
        var tempHead = tempHead

        if (tempHead?.next == null)
            return tempHead
        val a = tempHead
        var b = tempHead.next
        while (b != null && b.next != null) {
            tempHead = tempHead!!.next
            b = b.next!!.next
        }
        b = tempHead!!.next
        tempHead.next = null
        return mergeShort(divideList(a)!!, divideList(b)!!)
    }


    private fun mergeShort(pHead: NodeClass?, qHead: NodeClass?): NodeClass? {
        var pHead = pHead
        var qHead = qHead
        var shortListHead: NodeClass? = null
        var shortList: NodeClass? = null

        if (pHead == null)
            return qHead!!
        if (qHead == null)
            return pHead

        if (pHead.value!! <= qHead.value!!) {
            shortListHead = pHead
            pHead = pHead.next
        } else {
            shortListHead = qHead
            qHead = qHead.next
        }
        shortList = shortListHead

        while (pHead != null && qHead != null) {
            if (pHead.value!! <= qHead.value!!) {
                shortList!!.next = pHead
                shortList = pHead
                pHead = pHead.next
            } else {
                shortList!!.next = qHead
                shortList = qHead
                qHead = qHead.next
            }
        }

        if (pHead == null) {
            shortList!!.next = qHead
        } else {
            shortList!!.next = pHead
        }

        return shortListHead
    }
}