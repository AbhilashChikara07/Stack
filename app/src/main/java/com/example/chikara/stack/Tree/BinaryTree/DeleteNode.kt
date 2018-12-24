package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.stack.R
import java.util.*


/***
 * To delete a node in BT follow some steps:-
 * 1- Find last node of tree.
 * 2- Save last node of tree locally.
 * 3- Now delete last node.
 * 4- Now replace selected node value with last local node.
 * 5- Now final step traverse all node.
 * */
class DeleteNode : AppCompatActivity() {

    var head: TreeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)
        insertValueInTree()

        deleteSelectedNode(head!!, 2)
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


    private fun deleteSelectedNode(mTempHead: TreeClass?, mSelectedValue: Int?) {
        val mQueue = LinkedList<TreeClass?>()
        mQueue.add(mTempHead)
        var mLastNode: TreeClass? = null
        var mSelectedNode: TreeClass? = null

        while (true) {
            var mSize = mQueue.size

            while (mSize != 0) {
                mLastNode = mQueue.peek()
                mSize -= 1
                val mTempNode = mQueue.poll()

                if (mTempNode!!.value == mSelectedValue) {
                    mSelectedNode = mTempNode

                }
                if (mTempNode.left != null)
                    mQueue.add(mTempNode.left!!)

                if (mTempNode.right != null)
                    mQueue.add(mTempNode.right!!)
            }
            if (mQueue.isEmpty())
                break
        }

        deleteLastNode(mLastNode!!.value!!, mTempHead!!)
        mSelectedNode!!.value = mLastNode.value

        getTraversal(head!!)
    }

    private fun deleteLastNode(mSelectedValue: Int, mTempHead: TreeClass?) {
        val mQueue = LinkedList<TreeClass?>()
        mQueue.add(mTempHead)
        var mFlag: Boolean? = false

        while (true) {
            var mSize = mQueue.size

            while (mSize != 0) {
                mSize -= 1
                val mTempNode = mQueue.poll()

                if (mTempNode?.left?.value == mSelectedValue) {
                    mTempNode.left = null
                    mFlag = true

                } else
                    mQueue.add(mTempNode?.left)

                if (mTempNode?.right?.value == mSelectedValue) {
                    mTempNode.right = null
                    mFlag = true

                } else
                    mQueue.add(mTempNode?.right)

            }
            if (mQueue.isEmpty() || mFlag!!)
                break
        }
    }


    private fun getTraversal(mRoot: TreeClass) {
        val mQueue = LinkedList<TreeClass?>()
        mQueue.add(mRoot)
        val mStringBuilder: StringBuilder = StringBuilder()

        while (true) {
            var mSize = mQueue.size

            while (mSize != 0) {
                mSize -= 1
                val mTempRoot = mQueue.poll()
                mStringBuilder.append(mTempRoot!!.value)

                if (mTempRoot.left != null)
                    mQueue.add(mTempRoot.left!!)

                if (mTempRoot.right != null)
                    mQueue.add(mTempRoot.right!!)

            }

            if (mQueue.isEmpty())
                break
        }
        findViewById<TextView>(R.id.displayValue).text = mStringBuilder

    }
}