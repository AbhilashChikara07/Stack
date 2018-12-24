package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.stack.R
import java.util.*

class ConvertToSumTree : AppCompatActivity() {

    var head: TreeClass? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)


        insertValueInTree()
        convertToSumTree(head!!)
//        val mValue = sumOfTree(head!!)
//        findViewById<TextView>(R.id.displayValue).text = "" + mValue

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

    var mOldVal: Int? = 0
    private fun convertToSumTree(mTempHead: TreeClass?): Int {
        if (mTempHead == null)
            return 0

        if (mTempHead.left == null && mTempHead.right == null)
            return 0

        convertToSumTree(mTempHead.left)
        convertToSumTree(mTempHead.right)

//        mOldVal = mOldVal!! + mTempHead.value!!
        mTempHead.value = mTempHead.left!!.value!! + mTempHead.right!!.value!!
        mOldVal = mOldVal!! + mTempHead.value!!

        return (mTempHead.value!! + mOldVal!!)
    }

    var mQueue: LinkedList<TreeClass> = LinkedList()
    private fun withOutRecursiveLevelOrderTraversal(mTempHead: TreeClass) {
        var mStringBuilder: StringBuilder = StringBuilder()

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

    var mOldVlaue: Int = 0
    private fun sumOfTree(mTempHead: TreeClass?): Int {
        if (mTempHead == null)
            return 0

        sumOfTree(mTempHead.left)
        sumOfTree(mTempHead.right)
        mOldVlaue = mOldVlaue + mTempHead.value!!

        return mOldVlaue
    }

}