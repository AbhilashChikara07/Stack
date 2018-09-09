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
    private var tempHead: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)

        createList(4)
        createList(1)
        createList(9)
        createList(2)
        createList(8)

        val tempHead = divideList(head!!)

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

    class NodeClass(value: Int) {
        var value: Int? = null
        var next: NodeClass? = null

        init {
            this.value = value
            next = null
        }

    }

    private fun createList(value: Int) {
        if (head == null) {
            head = NodeClass(value)
            tempHead = head
        } else {
            val tempNode = NodeClass(value)
            tempHead?.next = tempNode
            this.tempHead = tempNode
        }
    }


    private fun divideList(mList: NodeClass?): NodeClass? {

        var mTempHead = mList

        if (mTempHead?.next == null || mTempHead == null)
            return mTempHead

        val mFirstList: NodeClass? = mTempHead
        var mSecondList: NodeClass? = mTempHead.next

        while (mSecondList?.next != null) {
            mTempHead = mTempHead!!.next
            mSecondList = mSecondList.next?.next
        }

        mSecondList = mTempHead!!.next
        mTempHead.next = null

        return mergeShort(divideList(mFirstList)!!, divideList(mSecondList)!!)
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