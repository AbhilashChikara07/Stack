package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.stack.R
import java.util.*

/**
 * Created by chikara on 2/6/18.
 */

class MergerOfTwoStack : AppCompatActivity() {
    var stack_1: NodeClass? = null
    var stack_2: NodeClass? = null

//    var anshika: Stack<Objects>  =  Stack()
    var andhika_2:Stack<Int> = Stack()

    /**
     * This is possible by using double link list.
     * We can also do this by using stack too. But time complexity will we high.
     * */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)
        andhika_2.push(2)
        andhika_2.push(2)
        andhika_2.push(2)
        andhika_2.push(2)
    }

    class NodeClass {
        var next: NodeClass? = null
        var data: Int = 0
    }


    private fun pushIntostackOne(item: Int) {
        val tempNode = NodeClass()
        tempNode.data = item
        tempNode.next = null
        if (stack_1 == null)
            stack_1 = tempNode
        else {
            stack_1!!.next = tempNode
            stack_1 = tempNode
        }
    }


    private fun pushIntoStackTwo(item: Int) {
        val tempNode = NodeClass()
        tempNode.data = item
        tempNode.next = null
        if (stack_2 == null)
            stack_2 = tempNode
        else {
            stack_2!!.next = tempNode
            stack_2 = tempNode
        }
    }


    private fun mergeTwoStack() {
        if (stack_2 != null && stack_1 != null) {
            var tempNode = stack_1
            while (tempNode!!.next != null)
                tempNode = tempNode.next
            tempNode.next = stack_2
        } else {
            return
        }
    }

}