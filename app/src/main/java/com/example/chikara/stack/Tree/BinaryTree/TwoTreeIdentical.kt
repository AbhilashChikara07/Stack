package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R
import java.util.*

/***
 * Two tree are Identical if Left part of first tree is
 * equal to right of second tree and so on.
 * */
class TwoTreeIdentical : AppCompatActivity() {

    private var mFirstTreeHead: Tree? = null
    private var mSecondTreeHead: Tree? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)

        createFirstTree()
        createSecondTree()

//        val mFlag = findTreeAreIdentical(mFirstTreeHead!!, mSecondTreeHead!!)
        val mFlag = withRecursive(mFirstTreeHead!!, mSecondTreeHead!!)
        Log.e("Identical-Result", "" + mFlag)
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

    private fun createFirstTree() {
        mFirstTreeHead = Tree(1)
        mFirstTreeHead?.mLeft = Tree(2)
        mFirstTreeHead?.mRight = Tree(3)

        mFirstTreeHead?.mLeft!!.mLeft = Tree(4)
        mFirstTreeHead?.mLeft!!.mRight = Tree(5)

        mFirstTreeHead?.mRight!!.mLeft = Tree(6)
        mFirstTreeHead?.mRight!!.mRight = Tree(7)
    }

    private fun createSecondTree() {
        mSecondTreeHead = Tree(1)
        mSecondTreeHead?.mLeft = Tree(2)
        mSecondTreeHead?.mRight = Tree(3)

        mSecondTreeHead?.mLeft!!.mLeft = Tree(4)
        mSecondTreeHead?.mLeft!!.mRight = Tree(5)

        mSecondTreeHead?.mRight!!.mLeft = Tree(6)
        mSecondTreeHead?.mRight!!.mRight = Tree(7)
    }


    private fun withRecursive(mFirstHead: Tree?, mSecondHead: Tree?): Boolean {
        if (mFirstHead == null && mSecondHead == null)
            return true
        else if (mFirstHead == null || mSecondHead == null)
            return false
        return (mFirstHead.mData == mSecondHead.mData
                &&
                withRecursive(mFirstHead.mLeft, mFirstHead.mLeft)
                &&
                withRecursive(mFirstHead.mRight, mFirstHead.mRight))
    }

    private var mFirstTreeQueue = LinkedList<Tree>()
    private var mSecondTreeQueue = LinkedList<Tree>()

    /***
     * Without recursive get two tree are identical
     * */
    private fun findTreeAreIdentical(mFirstHead: Tree?, mSecondHead: Tree?): Boolean {
        if (mFirstHead == null && mSecondHead != null)
            return false

        if (mFirstHead != null && mSecondHead == null)
            return false

        if (mFirstHead == null && mSecondHead == null)
            return true

        mFirstTreeQueue.add(mFirstHead!!)
        mSecondTreeQueue.add(mSecondHead!!)


        while (mFirstTreeQueue.size != 0 && mSecondTreeQueue.size != 0) {
            val mFirstRoot = mFirstTreeQueue.poll()
            val mSecondRoot = mSecondTreeQueue.poll()

            if (mFirstRoot.mData != mSecondRoot.mData)
                return false

            if (mFirstRoot.mLeft != null
                    && mSecondRoot.mLeft != null) {
                if (mFirstRoot.mData == mSecondRoot.mData) {
                    mFirstTreeQueue.add(mFirstRoot.mLeft!!)
                    mSecondTreeQueue.add(mSecondRoot.mLeft!!)
                } else return false
            } else if (mFirstRoot.mLeft != null
                    && mSecondRoot.mLeft == null) return false
            else if (mFirstRoot.mLeft == null
                    && mSecondRoot.mLeft != null)
                return false

            if (mFirstRoot.mRight != null
                    && mSecondRoot.mRight != null) {

                if (mFirstRoot.mData == mSecondRoot.mData) {
                    mFirstTreeQueue.add(mFirstRoot.mRight!!)
                    mSecondTreeQueue.add(mSecondRoot.mRight!!)
                } else return false
            } else if (mFirstRoot.mRight != null
                    && mSecondRoot.mRight == null)
                return false
            else if (mFirstRoot.mRight == null
                    && mSecondRoot.mRight != null)
                return false

        }
        return true
    }

}