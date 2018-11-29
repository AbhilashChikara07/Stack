package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.stack.R
import java.util.*

/**
 * Created by chikara on 3/20/18.
 */

class HeightOfTree : AppCompatActivity() {

    private var head: TreeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)
        insertElementInTree()

//        val height = getHeightByRecursive(head)
        val height = withOutRecursive(head!!)
        findViewById<TextView>(R.id.displayValue).text = "" + height

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


    /***
     * By using recursive we can get Height of tree
     * */
    private fun getHeightByRecursive(root: TreeClass?): Int {
        if (root == null)
            return 0

        val left = getHeightByRecursive(root.left)
        val right = getHeightByRecursive(root.right)

        if (right > left)
            return right + 1
        else
            return left + 1
    }

    /***
     *Without recursive get tree height.
     * */
    private fun withOutRecursive(mRoot: TreeClass): Int {
        val mQueue = LinkedList<TreeClass>()
        var mHeight: Int = 0

        mQueue.add(mRoot)

        while (true) {
            if (!mQueue.isEmpty()) {
                var mSize = mQueue.size
                while (mSize != 0) {
                    val mRoot = mQueue.poll()

                    if (mRoot.left != null)
                        mQueue.add(mRoot.left!!)

                    if (mRoot.right != null)
                        mQueue.add(mRoot.right!!)

                    mSize -= 1
                }
                mHeight += 1
            } else break
        }

        return mHeight
    }

//    /*
//    * By Level order traversal we also can get height of tree
//    * */
//
//    fun getHeightByLevelOrderTraversal(root: TreeClass): Int {
//
//        var mQueue: Queue<TreeClass>? = LinkedList<TreeClass>()
//        return 0
//    }

}