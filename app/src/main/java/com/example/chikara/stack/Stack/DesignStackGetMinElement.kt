package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.stack.R
import java.util.*

class DesignStackGetMinElement : AppCompatActivity() {

    private var mStackObj: Stack<Int> = Stack()
    private var mMinElement: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)
    }


    private fun pushElement(value: Int) {
        if (mStackObj.isEmpty()) {
            mMinElement = value
            mStackObj.push(value)

        } else if (mMinElement > value) {
            mMinElement = value
            mStackObj.push(2 * mMinElement - value)
        }
    }

    private fun popElement() {

    }

    private fun getMinElement() {

    }

}