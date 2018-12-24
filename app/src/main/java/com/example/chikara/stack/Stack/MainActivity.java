package com.example.chikara.stack.Stack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.chikara.stack.R;
import com.example.chikara.stack.Tree.BinaryTree.BST.DeletionBST;
import com.example.chikara.stack.Tree.BinaryTree.BST.InsertionBST;
import com.example.chikara.stack.Tree.BinaryTree.ConvertToSumTree;
import com.example.chikara.stack.Tree.BinaryTree.PrintPathFromRootToLeafNode;
import com.example.chikara.stack.Tree.BinaryTree.TreeToMirrorImage;
import com.example.chikara.stack.Tree.BinaryTree.VerticalTraversal;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        VerticalTraversal.class);
                startActivity(intent);
            }
        });
    }
}
