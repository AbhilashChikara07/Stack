package com.example.chikara.stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * Created by chikara on 2/5/18.
 */

class StackGetMiddleElement : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)
        val stackObj = createStackClassObj()

        stackObj.pushElement(1)
        stackObj.pushElement(2)
        stackObj.pushElement(3)
        stackObj.pushElement(4)
        stackObj.pushElement(5)

        stackObj.displayMidNode()

        stackObj.popElement()
        stackObj.popElement()

        stackObj.displayMidNode()
    }

    inner class NodeClass(tempValue: Int) {
        var prev: NodeClass? = null
        var next: NodeClass? = null
        var value: Int? = 0

        init {
            this.value = tempValue
            this.next = null
            this.prev = null
        }
    }

    private fun createStackClassObj(): stackClass {
        return stackClass()
    }

    inner class stackClass {
        var head: NodeClass? = null
        var mid: NodeClass? = null
        var count: Int? = 0


        fun pushElement(value: Int) {
            if (count == 0) {
                head = NodeClass(value)
                head!!.prev = null
                head!!.next = null
                mid = head
                count = count!! + 1
            } else {
                count = count!! + 1
                val tempNode = NodeClass(value)
                tempNode.next = head
                head!!.prev = tempNode
                head = tempNode
                if (count!! % 2 != 0) {
                    mid = mid!!.prev
                }
            }
        }

        fun popElement() {
            head = head!!.next
            head!!.prev = null
            count = count!! - 1
            if (count!! % 2 == 0) {
                mid = mid!!.next
            }
        }

        fun displayMidNode() {
            Log.e("mid node is :- ", "" + mid!!.value)
        }

    }

}