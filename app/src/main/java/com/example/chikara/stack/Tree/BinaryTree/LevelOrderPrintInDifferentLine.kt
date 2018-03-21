package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R
import java.util.*

/**
 * Created by chikara on 3/10/18.
 */

class LevelOrderPrintInDifferentLine : AppCompatActivity() {

    var head: TreeClass? = null
    var mQueue: Queue<TreeClass>? = LinkedList<TreeClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)
        insertElementInTree()
        printAllElement(head!!)
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
    }


    private fun printAllElement(tempHead: TreeClass) {
        val mStr: StringBuilder? = StringBuilder()
        mQueue!!.add(tempHead)
        mQueue!!.add(null)
        while (!mQueue!!.isEmpty()) {
            if (mQueue!!.element() == null) {
                mQueue!!.remove()
                mStr!!.append("\n")
            } else {
                val root = mQueue!!.remove()
                mStr!!.append(root.value)
                mQueue!!.add(root.left)
                mQueue!!.add(root.right)
                mQueue!!.add(null)
            }
        }
        Log.e("mStr",""+mStr)
    }
}