package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.stack.R


/**
 * Created by chikara on 3/8/18.
 */

class ConvertTreeToDoubleList : AppCompatActivity() {

    var head: TreeClass? = null
    var prev: TreeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)
        insertElement()
        binaryTree2DoubleLinkedList(head)
        displayElement(head!!)
    }

    private fun displayElement(tempHead: TreeClass) {
        var node = tempHead
        val string = StringBuilder()
        while (node != null) {
            string.append(node.value)
            node = node.right!!
        }
        Log.e("string", "" + string)
    }

    class TreeClass(tempValue: Int) {
        var value: Int? = null
        var left: TreeClass? = null
        var right: TreeClass? = null

        init {
            this.value = tempValue
            right = null
            left = null
        }
    }

    private fun insertElement() {
        head = TreeClass(5)
        head!!.left = TreeClass(3)
        head!!.right = TreeClass(6)
        head!!.left!!.right = TreeClass(4)
        head!!.left!!.left = TreeClass(1)
        head!!.right!!.right = TreeClass(8)
        head!!.left!!.left!!.right = TreeClass(2)
        head!!.left!!.left!!.left = TreeClass(0)
        head!!.right!!.right!!.left = TreeClass(7)
        head!!.right!!.right!!.right = TreeClass(9)
    }

    private fun binaryTree2DoubleLinkedList(root: TreeClass?) {
        if (root == null)
            return

        binaryTree2DoubleLinkedList(root.left)

        if (prev == null)
            head = root
        else {
            root.left = prev
            prev!!.right = root
        }
        prev = root

        binaryTree2DoubleLinkedList(root.right)
    }

    private fun convertToDll(root: TreeClass?): TreeClass? {
        if (prev == null) {
            head = root
        } else {
            root!!.left = prev
            prev!!.right = root
        }
        prev = root
        convertToDll(root!!.left)
        convertToDll(root.right)
        return head
    }

}