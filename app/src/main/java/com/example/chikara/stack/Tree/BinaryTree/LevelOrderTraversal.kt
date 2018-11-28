package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R


/**
 * Created by chikara on 3/9/18.
 */

class LevelOrderTraversal : AppCompatActivity() {

    var head: TreeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)

        insertElementInTree()
        printLevelOrder()
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


    private fun printLevelOrder() {
        val h = getTreeHeight(head)
        var i: Int = 1
        while (i <= h) {
            printGivenLevel(head, i)
            i++
        }
    }


    /***
     * Height of the tree can explain like total no of edges in longest path.
     * */
    private fun getTreeHeight(node: TreeClass?): Int {
        if (node == null)
            return 0
        else {
            val lDepth = getTreeHeight(node.left)
            val rDepth = getTreeHeight(node.right)

            if (lDepth > rDepth)
                return lDepth + 1
            else
                return rDepth + 1
        }
    }


    private fun printGivenLevel(root: TreeClass?, level: Int) {
        if (root == null)
            return
        if (level == 1)
            Log.e("value", "" + root.value)
        else if (level > 1) {
            printGivenLevel(root.left, level - 1)
            printGivenLevel(root.right, level - 1)
        }
    }
}