package com.example.chikara.stack.Tree.BinaryTree.BST

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.stack.R
import java.util.*

class InsertionBST : AppCompatActivity() {

    private var intArray: IntArray = IntArray(8)
    private var head: TreeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)

        insertElementInTree()
        insertInBST(1)
        insertInBST(0)
        insertInBST(6)
        withOutRecursiveLevelOrderTraversal(head!!)
    }

    class TreeClass(tempValue: Int) {
        var value: Int? = null
        var left: TreeClass? = null
        var right: TreeClass? = null

        init {
            this.value = tempValue
            this.left = null
            this.right = null
        }
    }


    private fun insertElementInTree() {
        head = TreeClass(5)

        head!!.left = TreeClass(3)
        head!!.right = TreeClass(8)

        head!!.left!!.left = TreeClass(2)
        head!!.left!!.right = TreeClass(4)

        head!!.right!!.left = TreeClass(7)
        head!!.right!!.right = TreeClass(9)
    }


    private fun insertInBST(mValue: Int) {
        var mTempHead = head

        while (mTempHead!!.left != null || mTempHead.right != null) {
            if (mTempHead.value!! > mValue) {
                mTempHead = mTempHead.left!!

            } else {
                mTempHead = mTempHead.right!!

            }
        }
        if (mTempHead.value!! > mValue) {
            mTempHead.left = TreeClass(mValue)

        } else {
            mTempHead.right = TreeClass(mValue)

        }
    }

    var mQueue: LinkedList<TreeClass> = LinkedList()
    private fun withOutRecursiveLevelOrderTraversal(mTempHead: TreeClass) {
        val mStringBuilder: StringBuilder = StringBuilder()

        mQueue.add(mTempHead)
        while (true) {
            var mSize = mQueue.size
            var mRoot = mQueue.poll()
            mStringBuilder.append(mRoot.value)

            while (mSize != 0) {
                mSize -= 1

                if (mRoot.left != null)
                    mQueue.add(mRoot.left!!)

                if (mRoot.right != null)
                    mQueue.add(mRoot.right!!)

                if (mSize != 0) {
                    mRoot = mQueue.poll()
                    mStringBuilder.append(mRoot.value)
                }
            }
            if (mQueue.isEmpty())
                break
            else
                mStringBuilder.append(",")


        }
        findViewById<TextView>(R.id.displayValue).text = mStringBuilder
    }
}