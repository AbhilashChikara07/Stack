package com.example.chikara.stack.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R

/**
 * Created by chikara on 2/26/18.
 */

class ArrayMergeShort : AppCompatActivity() {

    private var intArray: IntArray? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)
        intArray = IntArray(5)
        intArray!![0] = 4
        intArray!![1] = 1
        intArray!![2] = 9
        intArray!![3] = 2
        intArray!![4] = 8

        val finalArray = divideArray(intArray!!)
        displayElement(finalArray!!)
    }

   private fun displayElement(finalArray: IntArray) {
        val string: StringBuilder? = StringBuilder()
        for (i in 0 until finalArray.size) {
            string!!.append(finalArray[i])
        }
        Log.e("final data", "" + string)
    }

    private fun divideArray(tempArray: IntArray): IntArray? {

        if (tempArray.size == 1)
            return tempArray

        val mid = tempArray.size / 2
        val a: IntArray = IntArray(mid)
        val b: IntArray = IntArray(tempArray.size - mid)
        var count: Int? = 0

        for (i in 0 until mid) {
            a[i] = tempArray[i]
        }
        for (i in mid until tempArray.size) {
            b[count!!] = tempArray[i]
            count++
        }
        return mergeArray(divideArray(a)!!, divideArray(b)!!)
    }

    private fun mergeArray(pArray: IntArray, qArray: IntArray): IntArray? {

        val arrayHead: IntArray? = IntArray((pArray.size + qArray.size))

        if (pArray.isEmpty())
            return qArray
        if (qArray.isEmpty())
            return pArray


        var i: Int? = 0
        var j: Int? = 0
        var k: Int? = 0

        while (i!! < pArray.size && j!! < qArray.size) {
            if (pArray[i] < qArray[j]) {
                arrayHead!![k!!] = pArray[i]
                i += 1
            } else {
                arrayHead!![k!!] = qArray[j]
                j += 1
            }
            k += 1
        }


        while (i < pArray.size) {
            arrayHead!![k!!] = pArray[i]
            k += 1
            i += 1
        }
        while (j!! < qArray.size) {
            arrayHead!![k!!] = qArray[j]
            k += 1
            j += 1
        }
        return arrayHead
    }

}