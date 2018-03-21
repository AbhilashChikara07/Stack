package com.example.chikara.stack.Tree.BinaryTree

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.stack.R

/**
 * Created by chikara on 3/9/18.
 */

class InOrderTraversal : AppCompatActivity() {

    private var head: TreeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tree_activity_layout)
    }

    class TreeClass(tempValue: Int) {
        var leftNode: TreeClass? = null
        var rightNode: TreeClass? = null
        var value: Int? = null

        init {
            this.value = tempValue
        }
    }

    private fun insertValue() {
        if(head==null){
            head = TreeClass(1)
        }
    }

}