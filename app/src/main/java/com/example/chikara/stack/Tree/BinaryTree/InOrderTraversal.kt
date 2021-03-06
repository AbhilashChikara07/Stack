package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R
import java.util.*

/**
 * Created by chikara on 3/9/18.
 */

class InOrderTraversal : AppCompatActivity() {

    private var mHead: Tree? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)
        createTree()
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
     * Get inorder traversal by recursive.
     * */
    private fun inOrderTraversal(mRoot: PreOrderTraversal.Tree?) {
        if (mRoot == null)
            return
        inOrderTraversal(mRoot?.mLeft)
        Log.e("print-element", "" + mRoot?.mData)
        inOrderTraversal(mRoot?.mRight)
    }

    var mStack = Stack<Tree>()

    /***
     * Get inorder traversal without recursive.
     * */
    private fun withOutRecursive(mRoot: Tree?) {
        var mRoot = this.mHead

        while (true) {

            while (mRoot != null) {
                mStack.push(mRoot)
                mRoot = mRoot.mLeft
            }

            if (!mStack.empty()) {
                mRoot = mStack.pop()
                Log.e("in-order-traversal", "" + mRoot.mData)
                mRoot = mRoot.mRight

            } else
                break
        }
    }

}