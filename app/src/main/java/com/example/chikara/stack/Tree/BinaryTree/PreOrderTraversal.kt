package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R
import java.util.*

class PreOrderTraversal : AppCompatActivity() {

    private var mHead: Tree? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)

        createTree()
        withOutRecursiveTraversal(mHead)
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

    /***
     * With recursive.
     * */
    private fun preOrderTraversal(mRoot: Tree?) {
        Log.e("pre-order-traversal", "" + mRoot?.mData)
        preOrderTraversal(mRoot?.mLeft)
        preOrderTraversal(mRoot?.mRight)

    }


    var mStack = Stack<Tree>()
    /***
     * With-out recursive.
     * */
    private fun withOutRecursiveTraversal(mRoot: Tree?) {
        var mRoot: Tree? = mRoot

        while (true) {
            while (mRoot != null) {
                Log.e("pre-order-traversal", "" + mRoot.mData)
                mStack.push(mRoot)
                mRoot = mRoot.mLeft
            }
            if (!mStack.isEmpty()) {
                mRoot = mStack.pop()
                mRoot = mRoot.mRight

            } else
                break
        }
    }

}