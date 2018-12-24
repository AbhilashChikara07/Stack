package com.example.chikara.stack.Tree.BinaryTree.BST

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.stack.R
import java.util.*

class DeletionBST : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)

        insertElementInTree()
        deleteNode(3)
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


    private var head: TreeClass? = null

    private fun insertElementInTree() {
        head = TreeClass(5)

        head!!.left = TreeClass(3)
        head!!.right = TreeClass(8)

        head!!.left!!.left = TreeClass(2)
        head!!.left!!.right = TreeClass(4)

        head!!.right!!.left = TreeClass(7)
        head!!.right!!.right = TreeClass(9)
    }

    //    mDeleteNodeValue ==2
    private fun deleteNode(mDeleteNodeValue: Int) {
        var mRoot = head

        while (mRoot!!.value != mDeleteNodeValue) {
            mRoot = if (mDeleteNodeValue > mRoot.value!!)
                mRoot.right!!
            else
                mRoot.left!!
        }

        if (mRoot.left == null && mRoot.right != null)
            mRoot.value = mRoot.right!!.value
        else if (mRoot.left != null && mRoot.right == null)
            mRoot.value = mRoot.left!!.value
        else if (mRoot.left != null && mRoot.right != null)
            mRoot.value = mRoot.left!!.value
        else
            mRoot.value = null

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