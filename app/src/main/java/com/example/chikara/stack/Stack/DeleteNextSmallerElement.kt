package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.stack.R
import java.util.*

class DeleteNextSmallerElement : AppCompatActivity() {

    var intArray = arrayOf(1, 5, 2, 6, 4, 7)
    var stack = Stack<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)
        deleteNextElement()
    }


    private fun deleteNextElement() {
        var position: Int = 0
        while (intArray.isNotEmpty()) {
            if (position + 1 <= intArray.size) {
                if (intArray[position] < intArray[position + 1]) {
                    stack.push(intArray[position])
                    position += 1
                } else {
                    stack.push(intArray[position])
                    position += 2
                }
            }
        }

        val buffer = StringBuffer()
        while (!stack.isEmpty()) {
            buffer.append(stack.pop())
        }

        findViewById<TextView>(R.id.displayValue).text = buffer.toString()
    }

}