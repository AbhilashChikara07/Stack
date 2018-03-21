package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R
import android.R.attr.right
import android.R.attr.left
import android.R.attr.data



/**
 * Created by chikara on 3/13/18.
 */


class ConvertArrayToTree : AppCompatActivity() {

    private var intArray: IntArray = IntArray(8)
    private var head: TreeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)
        intArray[0] = 1
        intArray[1] = 2
        intArray[2] = 3
        intArray[3] = 4
        intArray[4] = 5
        intArray[5] = 6
        intArray[6] = 7
        intArray[7] = 8

        head = divideArrayForMakeNode(intArray)
//        head = cnvrt(intArray, 0)
        preOrderTraversal(head!!)
    }

    class TreeClass(tempValue: Int) {
        var value: Int? = null
        var leftNode: TreeClass? = null
        var rightNode: TreeClass? = null

        init {
            this.value = tempValue
            this.leftNode = null
            this.rightNode = null
        }
    }

    private fun divideArrayForMakeNode(tempArray: IntArray?): TreeClass? {

        if (tempArray?.size==1)
            return null

        val mid = tempArray!!.size / 2
        val leftArray = IntArray(mid)
        val rightArray = IntArray(tempArray.size - mid)
        var count: Int? = 0

        for (i in 0 until mid) {
            leftArray[i] = tempArray[i]
        }

        for (i in mid until tempArray.size) {
            rightArray[count!!] = tempArray[i]
            count++
        }

        val root = TreeClass(tempArray[mid])
        root.leftNode = divideArrayForMakeNode(leftArray)
        root.rightNode = divideArrayForMakeNode(rightArray)

        return root
    }

    fun cnvrt(ar: IntArray, pos: Int): TreeClass? {
        if (pos > ar.size - 1 || ar[pos] == -1)
            return null
        val tmp = TreeClass(ar[pos])
        tmp.value = ar[pos]
        tmp.leftNode = cnvrt(ar, 2 * pos + 1)
        tmp.rightNode = cnvrt(ar, 2 * pos + 2)
        return tmp
    }

    private fun preOrderTraversal(tempHead: TreeClass?) {
        if (tempHead == null)
            return
        Log.e("DATA", "" + tempHead.value)
        preOrderTraversal(tempHead.leftNode)
        preOrderTraversal(tempHead.rightNode)
    }

}