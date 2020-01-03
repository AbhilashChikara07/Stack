package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.stack.R

class ArrayStackImplementation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)

        val stackArray = StackArray()
        stackArray.push(1)
        stackArray.push(2)
        stackArray.push(3)
        stackArray.push(4)
        stackArray.push(5)
        stackArray.push(6)
        stackArray.push(7)
        stackArray.pop()
        stackArray.pop()

    }


    class StackArray {
        var MAX_LIMIT: Int = 5
        var intArray: IntArray? = null
        var TOP: Int = -1

        constructor() {
            intArray = IntArray(MAX_LIMIT)
//            TOP = -1
        }

        public fun push(item: Int) {
            if (TOP +1 != intArray!!.size) {
                TOP += 1
                intArray!![TOP] = item

            } else
                return
        }

        public fun pop(): Int {
            return if (TOP == -1)
                -1
            else {
                val value = intArray!![TOP]
                TOP -= 1
                value
            }
        }

        public fun isEmpty(): Boolean {
            return TOP != -1
        }

    }


}