package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R
import java.util.*

/**
 * Created by chikara on 2/5/18.
 */

class SpecialStack : AppCompatActivity() {

    var stack: Stack<Int>? = Stack()
    var specialStack: Stack<Int>? = Stack()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)

//        pushOperation(10)
//        pushOperation(9)
//        pushOperation(5)
//        pushOperation(13)
//        pushOperation(0)

        pushElementBySpaceComplex(10)
        pushElementBySpaceComplex(9)
        pushElementBySpaceComplex(5)
        pushElementBySpaceComplex(13)
        pushElementBySpaceComplex(0)


        popElementBySpaceComplex()
        popElementBySpaceComplex()
        popElementBySpaceComplex()

        displayStack()
    }

    private fun pushOperation(value: Int) {
        stack!!.push(value)
        if (specialStack!!.isEmpty()) {
            specialStack!!.push(value)
        } else {
            if (specialStack!!.peek() > value) {
                specialStack!!.push(value)
            } else {
                specialStack!!.push(specialStack!!.peek())
            }
        }
    }

    private fun displayStack() {
        while (!stack!!.isEmpty()) {
            Log.e("stack_value", "" + stack!!.pop())
        }
        while (!specialStack!!.isEmpty()) {
            Log.e("stack_special", "" + specialStack!!.pop())
        }
    }

    private fun popOperation() {
        stack!!.pop()
        specialStack!!.pop()
    }

    private fun getMinValue() {
        specialStack!!.peek()
    }


    /*
    * By making stack space complex
    * */

    private fun pushElementBySpaceComplex(value: Int) {
        if (stack!!.isEmpty()) {
            stack!!.push(value)
            specialStack!!.push(value)
        } else {
            if (specialStack!!.peek() > value) {
                specialStack!!.push(value)
            }
            stack!!.push(value)
        }
    }

    private fun popElementBySpaceComplex() {
        if (stack!!.peek() == specialStack!!.peek()) {
            stack!!.pop()
            specialStack!!.pop()
        } else {
            stack!!.pop()
        }
    }
}