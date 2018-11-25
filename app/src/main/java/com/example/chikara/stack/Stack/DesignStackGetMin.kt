package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R
import java.util.*

class DesignStackGetMin : AppCompatActivity() {

    private var stackObj: Stack<Int>? = Stack()
    private var mMinElement: Int? = 0
    private var mTempArray = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)

        pushStackElement(8)
        pushStackElement(4)
        pushStackElement(1)
        pushStackElement(6)

        popElement()
        popElement()

        getMinElement()

        popElement()
        popElement()

        getMinElement()

    }

    private fun pushStackElement(element: Int) {

        if (stackObj!!.isEmpty()) {
            mMinElement = element
        } else {
            if (mMinElement!! > element)
                mMinElement = element
        }
        stackObj!!.add(element)

    }

    private fun popElement() {
        if (stackObj!!.isNotEmpty()) {
            val x = stackObj!!.pop()
            if (mMinElement == x) {
                mTempArray.clear()

                if (stackObj!!.isNotEmpty()) {
                    mMinElement = stackObj!!.peek()

                    getMinElement()
                }
            }
            Log.e("REMOVE-ELEMENT IS", "" + x)
        }
    }


    private fun getMinElement() {
        while (stackObj!!.isNotEmpty()) {
            val x = stackObj!!.pop()
            if (mMinElement!! > x)
                mMinElement = x

            mTempArray.add(x)
        }

        putAllElementToStack()

        Log.e("MIN-ELEMENT IS", "" + mMinElement)
    }

    private fun putAllElementToStack() {
        for (i in 0 until mTempArray.size) {
            stackObj!!.push(mTempArray[i])
        }
    }

}