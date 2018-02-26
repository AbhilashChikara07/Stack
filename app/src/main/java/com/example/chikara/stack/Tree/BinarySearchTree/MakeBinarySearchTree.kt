package com.example.chikara.stack.Tree.BinarySearchTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.stack.R

/**
 * Created by chikara on 2/22/18.
 */

class MakeBinarySearchTree : AppCompatActivity() {

    var root: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stack_layout)
    }


    class NodeClass(tempValue: Int) {
        var leftNode: NodeClass? = null
        var rightNode: NodeClass? = null
        var value: Int? = null

        init {
            this.value = tempValue
            this.leftNode = null
            this.rightNode = null
        }
    }

//    private fun insertNodeInTree(tempRoot: NodeClass, value: Int) {
//        if (tempRoot == null) {
//            tempRoot = NodeClass(value)
//        } else {
//            if (value < root!!.value!!) {
//                root!!.leftNode = insertNodeInTree()
//            }
//        }
//    }

}