package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.example.chikara.stack.R
import java.util.*
import kotlin.collections.HashMap


class TreeBottomView : AppCompatActivity() {
    private var mHead: Tree? = null
    var mHolderQueue = LinkedList<Holder>()
    var mHashMap = HashMap<Int, Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)

        createTree()
        getTreeBottomView(mHead!!)
        printBottonView()
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

    class Holder(mTreeClassObj: Tree?, mLevel: Int?) {
        var mTreeClassObj: Tree? = null
        var mLevel: Int? = null

        init {
            this.mTreeClassObj = mTreeClassObj
            this.mLevel = mLevel
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
    private fun getTreeBottomView(mRoot: Tree) {
        val mHolderObj = Holder(mRoot, 0)
        mHolderQueue.add(mHolderObj)
        mHashMap[0] = mRoot.mData
        while (true) {
            var mSize = mHolderQueue.size

            while (mSize != 0) {
                val mTempHolderObj = mHolderQueue.poll()

                if (mTempHolderObj.mTreeClassObj!!.mLeft != null) {
                    var mTempLevel:Int = mTempHolderObj.mLevel!!
                    mTempLevel -=1
                    val mTempRoot = mTempHolderObj.mTreeClassObj!!.mLeft

                    mHolderQueue.add(Holder(mTempRoot, mTempLevel))
                    mHashMap[mTempLevel] = mTempRoot!!.mData

                }

                if (mTempHolderObj.mTreeClassObj!!.mRight != null) {
                    var mTempLevel:Int = mTempHolderObj.mLevel!!
                    mTempLevel +=1

                    val mTempRoot = mTempHolderObj.mTreeClassObj!!.mRight

                    mHolderQueue.add(Holder(mTempRoot, mTempLevel))
                    mHashMap[mTempLevel] = mTempRoot!!.mData

                }

                mSize -= 1
            }


            if (mHolderQueue.isEmpty())
                break
        }
    }

    private fun printBottonView() {
        val mFinalString = StringBuffer()
        mHashMap.forEach {
            mFinalString.append(it.value)
        }
        findViewById<TextView>(R.id.displayValue).text = mFinalString

    }

}