package com.example.chikara.stack.Queue

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.stack.R
import java.util.*

/**
 * Created by chikara on 2/8/18.
 */

class ReverseFirstKGroupOfElement : AppCompatActivity() {

    var mQueue: Queue<Int>? = LinkedList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)
        mQueue!!.add(1)
        mQueue!!.add(2)
        mQueue!!.add(3)
        mQueue!!.add(4)
        mQueue!!.add(5)
    }

    private fun reverseKGroupOfElement(mGroupCount: Int) {
        val mStack: Stack<Int>? = Stack()
//        val mTempQueue
        var count: Int = 0
        while (count != mGroupCount) {
            count += 1
            mStack!!.push(mQueue!!.remove())
        }
    }

}