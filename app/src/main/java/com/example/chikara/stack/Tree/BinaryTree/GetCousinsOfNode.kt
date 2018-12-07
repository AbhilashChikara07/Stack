package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.example.chikara.stack.R
import java.util.*

class GetCousinsOfNode : AppCompatActivity() {

    private var head: TreeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)

        insertElementInTree()
        val intArray = getCousinsOfNode(head!!.left!!.left!!)

        if (intArray.isEmpty()) {
            Log.e("NO NODE FOUND", "NO NODE FOUND")

        } else {
            val mStringBuilder = StringBuilder()
            mStringBuilder.append(intArray[0])
            mStringBuilder.append("------")
            mStringBuilder.append(intArray[1])
            Log.e("mStringBuilder", "" + mStringBuilder)
            findViewById<TextView>(R.id.displayValue).text = mStringBuilder

        }
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

    private fun getCousinsOfNode(mCousinsNode: TreeClass): IntArray {
        val mNodeLevel = getLevelOfNode(mCousinsNode)
        val mCousinsNodeArray = IntArray(2)

        if (mNodeLevel == 0) {
            return mCousinsNodeArray

        } else if (mNodeLevel == 1) {
            return mCousinsNodeArray

        } else {
            val mQueue: LinkedList<TreeClass> = LinkedList()
            mQueue.add(head!!)

            var mTempLevel: Int = 0

            while (true) {
                var mSize: Int = mQueue.size

                while (mSize != 0) {
                    mSize -= 1
                    val mTempRoot = mQueue.poll()

                    if (mTempLevel + 2 == mNodeLevel) {
                        if (mTempRoot.left != mCousinsNode && mTempRoot.right != mCousinsNode) {
                            mCousinsNodeArray[0] = mTempRoot.left!!.value!!
                            mCousinsNodeArray[1] = mTempRoot.right!!.value!!
                            return mCousinsNodeArray
                        }
                    } else {
                        if (mTempRoot.left != null)
                            mQueue.add(mTempRoot.left!!)

                        if (mTempRoot.right != null)
                            mQueue.add(mTempRoot.right!!)
                    }
                }
                mTempLevel += 1
            }
        }
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