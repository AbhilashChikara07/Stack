package com.example.chikara.stack.Queue

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R
import java.util.*

/**
 * Created by chikara on 2/7/18.
 */


class ReverseQueue : AppCompatActivity() {

    var mQueue: Queue<Int>? = LinkedList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)
        mQueue!!.add(1)
        mQueue!!.add(2)
        mQueue!!.add(3)
        mQueue!!.add(4)
        mQueue!!.add(5)
        mQueue!!.add(6)
        reverseQueue()
    }


    private fun reverseQueue() {
        val mStack: Stack<Int>? = Stack()
        while (mQueue!!.size > 0) {
            mStack!!.push(mQueue!!.remove())
        }
        while (mStack!!.size > 0) {
            mQueue!!.add(mStack.pop())
        }
        Log.e("first element is :- ", "" + mQueue!!.elementAt(0))
    }
}