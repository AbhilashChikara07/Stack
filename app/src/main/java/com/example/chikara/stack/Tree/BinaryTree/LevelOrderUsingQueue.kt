package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R
import java.util.*


/**
 * Created by chikara on 3/10/18.
 */

class LevelOrderUsingQueue : AppCompatActivity() {

    var head: TreeClass? = null
    var queue: Queue<TreeClass> = LinkedList<TreeClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)

        insertValueInTree()
        traversalFunction(head!!)
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
    }

    private fun traversalFunction(tempHead: TreeClass) {
        queue.add(tempHead)
        while (!queue.isEmpty()) {
            Log.e("tempHead", "" + queue.poll().value)
            if (tempHead.left != null)
                queue.add(tempHead.left)
            if (tempHead.right != null)
                queue.add(tempHead.right)
        }
    }
}