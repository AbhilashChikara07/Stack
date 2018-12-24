package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R

class PrintPathFromRootToLeafNode : AppCompatActivity() {

    var head: TreeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)
        insertValueInTree()
        printAllNodePathFRomRootToEnd(head)
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

    private fun insertValueInTree() {
        head = TreeClass(1)
        head!!.left = TreeClass(2)
        head!!.right = TreeClass(3)

        head!!.left!!.left = TreeClass(4)
        head!!.left!!.right = TreeClass(5)

        head!!.right!!.left = TreeClass(6)
        head!!.right!!.right = TreeClass(7)
    }

    private var mList: ArrayList<Int> = ArrayList()
    private fun printAllNodePathFRomRootToEnd(mTempHead: TreeClass?) {
        if (mTempHead == null)
            return

        mList.add(mTempHead.value!!)
        if (mTempHead.left == null && mTempHead.right == null) {
            for (i in 0 until mList.size)
                Log.e("PATH IS", "" + mList[i])
            Log.e("------", "------")

        } else {
            printAllNodePathFRomRootToEnd(mTempHead.left)
            printAllNodePathFRomRootToEnd(mTempHead.right)

        }
        mList.removeAt(mList.size-1)

    }
}