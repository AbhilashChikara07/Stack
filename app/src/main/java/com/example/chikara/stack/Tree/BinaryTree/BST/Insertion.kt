package com.example.chikara.stack.Tree.BinaryTree.BST

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.stack.R

class Insertion : AppCompatActivity() {

    private var intArray: IntArray = IntArray(8)
    private var head: TreeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)
        insertElementInTree()
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


    private fun insertElementInTree() {
        head = TreeClass(5)

        head!!.left = TreeClass(3)
        head!!.right = TreeClass(8)

        head!!.left!!.left = TreeClass(2)
        head!!.left!!.right = TreeClass(4)

        head!!.right!!.left = TreeClass(7)
        head!!.right!!.right = TreeClass(9)
    }





}