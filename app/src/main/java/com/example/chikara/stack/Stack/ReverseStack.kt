package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R
import java.util.*


/**
 * Created by chikara on 2/6/18.
 */

class ReverseStack : AppCompatActivity() {


    private var stackObj: Stack<Int>? = Stack()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)

        stackObj!!.push(1)
        stackObj!!.push(2)
        stackObj!!.push(3)
        stackObj!!.push(4)
        stackObj!!.push(5)

        reverse()

        Log.e("top element is :-", "" + stackObj!!.peek())

    }

    private fun reverse() {
        if (stackObj!!.size > 0) {
            /* Hold all items in Function Call Stack until we
               reach end of the stack */
            val x = stackObj!!.peek()
            stackObj!!.pop()
            reverse()
            /* Insert all the items held in Function Call Stack
               one by one from the bottom to top. Every item is
               inserted at the bottom */
            insertAtBottom(x)
        }
    }


    private fun insertAtBottom(x: Int) {

        if (stackObj!!.isEmpty())
            stackObj!!.push(x)
        else {
            /* All items are held in Function Call Stack until we
               reach end of the stack. When the stack becomes
               empty, the st.size() becomes 0, the
               above if part is executed and the item is inserted
               at the bottom */

            val a = stackObj!!.peek()
            stackObj!!.pop()
            insertAtBottom(x)

            //push allthe items held in Function Call Stack
            //once the item is inserted at the bottom
            stackObj!!.push(a)
        }
    }


}