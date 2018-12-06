package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.stack.R
import java.util.*

/***
 * Special order like bottom to top
 *ex- 1, 23, 4 7 5 6, 8 15 9 14 10 13 11 12, 16 31 17 30 18 29 19 28 20 27 21 26 22 25 23 24
 * */


class SpecialOrder : AppCompatActivity() {
    private var mHead: Tree? = null
    var mQueue = LinkedList<Tree>()
    var mArrayQueue = Stack<ArrayList<Int>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)

        createTree()
        getSpiralOrderTraversal(mHead!!)
        printInSpiralOrder()
    }

    class Tree(mTempValue: Int) {
        var mLeft: Tree? = null
        var mRight: Tree? = null
        var mData: Int = 0

        init {
            mLeft = null
            mRight = null
            this.mData = mTempValue
        }
    }

    private fun createTree() {
        mHead = Tree(1)
        mHead?.mLeft = Tree(2)
        mHead?.mRight = Tree(3)

        mHead?.mLeft!!.mLeft = Tree(4)
        mHead?.mLeft!!.mRight = Tree(5)

        mHead?.mRight!!.mLeft = Tree(6)
        mHead?.mRight!!.mRight = Tree(7)
    }

    /***
     * With-out-recursive
     * */
    private fun getSpiralOrderTraversal(mRoot: Tree) {
        mQueue.add(mRoot)

        while (true) {
            var mSize = mQueue.size
            val mIntArray = ArrayList<Int>()

            while (mSize != 0) {
                val mTempRoot = mQueue.poll()
                mIntArray.add(mTempRoot.mData)

                if (mTempRoot.mLeft != null)
                    mQueue.add(mTempRoot.mLeft!!)

                if (mTempRoot.mRight != null)
                    mQueue.add(mTempRoot.mRight!!)

                mSize -= 1
            }
            mArrayQueue.add(mIntArray)

            if (mQueue.isEmpty())
                break
        }
    }


    private fun printInSpiralOrder() {
        val mFinalString = StringBuffer()

        while (!mArrayQueue.isEmpty()) {
            val mArray = mArrayQueue.pop()

            if (mArray.size == 1) {
                mFinalString.append(mArray[0])

            } else {
                var j = mArray.size - 1
                for (i in 0 until mArray.size) {
                    if (j > i) {
                        mFinalString.append(mArray[i])
                        mFinalString.append(mArray[j])
                        j -= 1
                    }
                }
                mFinalString.append(",")
            }

        }
        findViewById<TextView>(R.id.displayValue).text = mFinalString
    }

}