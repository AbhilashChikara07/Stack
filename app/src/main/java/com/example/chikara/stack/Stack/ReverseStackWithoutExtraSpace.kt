package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.stack.R

/**
 * Created by chikara on 2/7/18.
 */

class ReverseStackWithoutExtraSpace : AppCompatActivity() {

    var head: StackClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)
        makeStack(1)
        makeStack(2)
        makeStack(3)
        makeStack(4)
        makeStack(5)

        head = reverseStack()
    }


    inner class StackClass(tempValue: Int) {
        var next: StackClass? = null
        var value: Int? = null

        init {
            this.value = tempValue
            this.next = null
        }
    }


    private fun makeStack(value: Int) {
        if (head == null) {
            head = StackClass(value)
        } else {
            val tempHead = StackClass(value)
            tempHead.next = head
            head = tempHead
        }
    }

    private fun reverseStack(): StackClass {
        var tempHead = head
        var firstNode: StackClass? = null
        var lastNode: StackClass? = null

        while (tempHead != null) {
            lastNode = tempHead.next
            tempHead.next = firstNode
            firstNode = tempHead
            tempHead = lastNode
        }
        return firstNode!!
    }

}