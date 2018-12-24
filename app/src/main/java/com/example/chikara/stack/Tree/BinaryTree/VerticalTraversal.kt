package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class VerticalTraversal : AppCompatActivity() {

    /***
     * For Vertical Traversal of tree follow some steps.
     * 1- for left node increase level by 1
     * 2- for right node don't increase level copy save root level.
     * */

    var head: TreeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)

        insertValueInTree()
        verticalOrderTraversal(head!!)
        printAllMapNode()
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


    class HolderClass(mLevel: Int, mRoot: TreeClass) {
        var mLevel: Int? = 0
        var mRoot: TreeClass? = null

        init {
            this.mLevel = mLevel
            this.mRoot = mRoot
        }
    }

    var mQueue: HashMap<Int, ArrayList<Int>> = HashMap()
    var mHolderQueue: LinkedList<HolderClass> = LinkedList()

    private fun verticalOrderTraversal(mTempHead: TreeClass) {
        mHolderQueue.add(HolderClass(0, mTempHead))
        while (true) {
            var mSize = mHolderQueue.size

            while (mSize != 0) {
                mSize -= 1
                val mHolderObj = mHolderQueue.poll()
                val mTempRoot = mHolderObj.mRoot
                val mTempLevel = mHolderObj.mLevel
                var mArray: ArrayList<Int>? = null

                if (mQueue[mTempLevel] != null) {
                    mArray = mQueue[mTempLevel]!!

                } else {
                    mArray = ArrayList<Int>()

                }

                mArray.add(mTempRoot!!.value!!)
                mQueue[mTempLevel!!] = mArray

                if (mTempRoot.left != null) {
                    mHolderQueue.add(HolderClass(mHolderObj.mLevel!!.plus(1), mTempRoot.left!!))

                }

                if (mTempRoot.right != null) {
                    mHolderQueue.add(HolderClass(mTempLevel, mTempRoot.right!!))

                }
            }

            if (mHolderQueue.isEmpty())
                break
        }
    }

    private fun printAllMapNode() {
        val mIterator = mQueue.iterator()
        while (mIterator.hasNext()) {
            var mArray = mIterator.next()
            for (i in 0 until mArray.value.size)
                Log.e("VERTICAL-TRAVERSAL", "" + mArray.value[i])

            Log.e("-------", "---------")
        }

    }

}