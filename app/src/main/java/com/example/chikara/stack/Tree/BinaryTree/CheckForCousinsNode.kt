package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R
import java.util.*

class CheckForCousinsNode : AppCompatActivity() {

    var head: TreeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)

        insertElementInTree()
        val mFlag = checkForCousinsNode(head!!.left!!.left!!, head!!.right!!.right!!)
        Log.e("mFlag", "" + mFlag)
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


    private fun checkForCousinsNode(mNodeA: TreeClass, mNodeB: TreeClass): Boolean {
        if (getLevelOfNode(mNodeA) == getLevelOfNode(mNodeB)) {
            if (checkRootForNode(mNodeA) != checkRootForNode(mNodeB))
                return true
        } else {
            return false
        }

        return false
    }

    private fun checkRootForNode(mNode: TreeClass): TreeClass? {
        val mTempHead: TreeClass = head!!
        val mQueue: LinkedList<TreeClass> = LinkedList()

        if (mNode == head) {
            return mNode

        } else {
            mQueue.add(mTempHead)
            while (true) {
                var mSize = mQueue.size
                while (mSize != 0) {
                    mSize -= 1
                    val mTempRoot = mQueue.poll()

                    if (mTempRoot.left != null) {
                        if (mTempRoot.left!!.value == mNode.value)
                            return mTempRoot
                        else
                            mQueue.add(mTempRoot.left!!)
                    }

                    if (mTempRoot.right != null) {
                        if (mTempRoot.right!!.value == mNode.value)
                            return mTempRoot
                        else
                            mQueue.add(mTempRoot.right!!)
                    }

                }
            }

        }
        return null
    }


    private fun getLevelOfNode(mNode: TreeClass): Int {
        val mQueue: LinkedList<TreeClass> = LinkedList()
        var mLevel: Int = 0
        mQueue.add(head!!)
        while (true) {
            var mSize: Int = mQueue.size
            while (mSize != 0) {
                mSize -= 1
                val mRoot = mQueue.poll()

                if (mRoot == mNode) {
                    return mLevel + 1

                } else {
                    if (mRoot.left != null)
                        mQueue.add(mRoot.left!!)

                    if (mRoot.right != null)
                        mQueue.add(mRoot.right!!)

                }
            }
            mLevel += 1
        }
    }

}