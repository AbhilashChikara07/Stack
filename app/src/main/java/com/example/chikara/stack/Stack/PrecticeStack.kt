package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.example.chikara.stack.R
import java.lang.StringBuilder
import java.util.*

class PrecticeStack : AppCompatActivity() {

    var charArray = CharArray(9)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)

        charArray[0] = 'a'
        charArray[1] = 'a'
        charArray[2] = 'a'
        charArray[3] = 'a'
        charArray[4] = 'a'
        charArray[5] = 'b'
        charArray[6] = 'b'
        charArray[7] = 'a'
        charArray[8] = 'a'

        longestSubArray()
    }


    private fun longestSubArray() {
        var max: Int = 0
        var tempMax: Int = 0
        var charName: Char = 'd'

        for (i in charArray.indices) {
            if (i + 1 <= charArray.size-1) {
                if (charArray[i] == charArray[i + 1]) {
                    tempMax += 1
                } else {
                    if (max < tempMax) {
                        max = tempMax
                        charName = charArray[i]
                        max += 1
                    }
                    tempMax = 0
                }
            } else {
                max = tempMax
                charName = charArray[i]
                max += 1
            }
        }

        Log.e("MAX-LENGTH", "" + max)
        Log.e("CHAR-NAME", "" + charName)
    }

}