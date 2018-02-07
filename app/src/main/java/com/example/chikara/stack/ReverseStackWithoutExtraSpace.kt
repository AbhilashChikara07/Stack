package com.example.chikara.stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by chikara on 2/7/18.
 */

class ReverseStackWithoutExtraSpace : AppCompatActivity() {

    var head: StackClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)
    }


    inner class StackClass(tempValue: Int) {
        var next: StackClass? = null
        var value: Int? = null

        init {
            this.value = tempValue
            this.next = null
        }
    }


    private fun makeStack(value: Int) {
        if (head == null) {
            head = StackClass(value)
        } else {
            val tempHead = StackClass(value)
            tempHead.next = head
            head = tempHead
        }
    }

}