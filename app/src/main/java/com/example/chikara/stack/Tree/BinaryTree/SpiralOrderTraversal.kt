package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.example.chikara.stack.R
import java.util.*
import kotlin.collections.ArrayList

/***
 *In Spiral-order-traversal first we print all node
 * from left-to-right then right-to-left.
 * */
class SpiralOrderTraversal : AppCompatActivity() {

    private var mHead: Tree? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)

        createTree()
        getSpiralOrderTraversal(mHead!!)
        printAllInSpiralOrder(mArrayQueue)
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


    var mQueue = LinkedList<Tree>()
    var mArrayQueue = LinkedList<ArrayList<Int>>()

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


    private fun printAllInSpiralOrder(mQueue: LinkedList<ArrayList<Int>>) {
        val mFinalString: StringBuilder = StringBuilder()

        while (!mQueue.isEmpty()) {
            val mQueueSize = mQueue.size
            val mIntArray = mQueue.poll()

            if (mQueueSize % 2 == 0) {
                for (i in 0 until mIntArray.size)
                    mFinalString.append(mIntArray[i].toString())

            } else {
                mIntArray.reverse()
                for (i in 0 until mIntArray.size)
                    mFinalString.append(mIntArray[i].toString())

            }

            mFinalString.append(",")
        }
        Log.e("final string is :- ", "" + mFinalString)
        findViewById<TextView>(R.id.displayValue).text = mFinalString
    }

}
