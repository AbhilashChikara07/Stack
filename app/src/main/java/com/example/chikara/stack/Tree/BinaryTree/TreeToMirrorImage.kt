package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.stack.R
import java.util.*

class TreeToMirrorImage : AppCompatActivity() {

    var head: TreeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)
        insertValueInTree()
        convertToMirrorImage()
        withOutRecursiveLevelOrderTraversal(head!!)
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

    var mQueue = LinkedList<TreeClass>()
    private fun convertToMirrorImage() {
        mQueue.add(head!!)
        while (true) {
            var mSize = mQueue.size
            while (mSize != 0) {
                mSize -= 1
                val mTempHead: TreeClass? = mQueue.poll()
                var mTempNode: TreeClass? = null

                if (mTempHead?.left != null && mTempHead.right != null) {
                    mTempNode = mTempHead.left
                    mTempHead.left = mTempHead.right
                    mTempHead.right = mTempNode

                    mQueue.add(mTempHead.left!!)
                    mQueue.add(mTempHead.right!!)

                } else if (mTempHead?.left != null && mTempHead.right == null) {
                    mTempNode = mTempHead.left
                    mTempHead.left = null
                    mTempHead.right = mTempNode
                    mQueue.add(mTempHead.right!!)

                } else if (mTempHead?.left == null && mTempHead?.right != null) {
                    mTempNode = mTempHead.right
                    mTempHead.right = null
                    mTempHead.left = mTempNode
                    mQueue.add(mTempHead.left!!)

                }
            }
            if (mQueue.isEmpty())
                break
        }
    }

    private var mQueueTemp: LinkedList<TreeClass> = LinkedList()
    private fun withOutRecursiveLevelOrderTraversal(mTempHead: TreeClass) {
        val mStringBuilder: StringBuilder? = StringBuilder()

        mQueueTemp.add(mTempHead)
        while (true) {
            var mSize = mQueueTemp.size

            while (mSize != 0) {
                mSize -= 1
                val mRoot = mQueueTemp.poll()
                mStringBuilder?.append(mRoot.value)

                if (mRoot.left != null)
                    mQueueTemp.add(mRoot.left!!)

                if (mRoot.right != null)
                    mQueueTemp.add(mRoot.right!!)

            }
            if (mQueueTemp.isEmpty())
                break
            else
                mStringBuilder?.append(",")
        }
        findViewById<TextView>(R.id.displayValue).text = mStringBuilder
    }

}