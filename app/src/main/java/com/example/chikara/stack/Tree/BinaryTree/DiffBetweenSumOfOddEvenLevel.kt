package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R
import java.util.*

/**
 * Created by chikara on 3/11/18.
 */

class DiffBetweenSumOfOddEvenLevel : AppCompatActivity() {

    var head: TreeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)
        insertElementInTree()
        val mQueue = getAllLevelElement(head!!)
        getEvenOddDiff(mQueue)
    }

    class TreeClass(tempValue: Int) {
        var value: Int? = null
        var left: TreeClass? = null
        var right: TreeClass? = null

        init {
            this.value = tempValue
            left = null
            right = null
        }
    }

    private fun insertElementInTree() {
        head = TreeClass(1)
        head!!.left = TreeClass(2)
        head!!.right = TreeClass(3)
        head!!.left!!.left = TreeClass(4)
        head!!.left!!.right = TreeClass(5)
        head!!.right!!.left = TreeClass(6)
        head!!.right!!.right = TreeClass(7)
    }

    private fun getAllLevelElement(tempHead: TreeClass): Queue<TreeClass> {
        val mTempQueue: Queue<TreeClass>? = LinkedList<TreeClass>()
        val mQueue: Queue<TreeClass>? = LinkedList<TreeClass>()

        mTempQueue!!.add(tempHead)
        mTempQueue.add(null)

        while (!mTempQueue.isEmpty()) {
            if (mTempQueue.element() == null) {
                mQueue!!.add(mTempQueue.remove())
                if (mTempQueue.size > 0) {
                    mTempQueue.add(null)
                }
            } else {
                val root = mTempQueue.remove()
                mQueue!!.add(root)
                if (root.left != null) {
                    mTempQueue.add(root.left)
                }
                if (root.right != null) {
                    mTempQueue.add(root.right)
                }
            }
        }
        return mQueue!!
    }

    private fun getEvenOddDiff(tempQueue: Queue<TreeClass>): Int {
        var oddSum: Int? = 0
        var evenSum: Int? = 0
        while (!tempQueue.isEmpty()) {
            while (tempQueue.element() != null) {
                val root = tempQueue.remove()
                if (root != null)
                    oddSum = oddSum!! + root.value!!
            }
            tempQueue.remove()
            if (tempQueue.size > 0) {
                while (tempQueue.element() != null) {
                    val root = tempQueue.remove()
                    if (root != null)
                        evenSum = evenSum!! + root.value!!
                }
                tempQueue.remove()
            } else {
                break
            }
        }
        Log.e("oddSum", "" + oddSum)
        Log.e("evenSum", "" + evenSum)
        return (oddSum!! - evenSum!!)
    }

}

