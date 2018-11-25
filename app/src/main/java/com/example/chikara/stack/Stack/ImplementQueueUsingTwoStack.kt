package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.stack.R
import java.util.*

class ImplementQueueUsingTwoStack : AppCompatActivity() {

    var mStack_1: Stack<Int> = Stack()
    var mStack_2: Stack<Int> = Stack()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)
        insertValueInQueue(1)
        insertValueInQueue(2)
        insertValueInQueue(3)
        insertValueInQueue(4)
        insertValueInQueue(5)


        deleteElementFromQueue()

        insertValueInQueue(6)

    }

    private fun insertValueInQueue(value: Int) {

        /*
        * FirstPush All element from second Queue to First Queue.
        * */
        while (mStack_2.size != 0)
            mStack_1.push(mStack_2.pop())

        mStack_1.push(value)
    }


    private fun deleteElementFromQueue() {
        /*
        * First insert all stack-1 element to stack-2
        * */
        while (mStack_1.size != 0)
            mStack_2.push(mStack_1.pop())

        mStack_2.pop()
    }

}