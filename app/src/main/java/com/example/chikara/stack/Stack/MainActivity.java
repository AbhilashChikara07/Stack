package com.example.chikara.stack.Stack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.chikara.stack.R;
import com.example.chikara.stack.Tree.BinaryTree.HeightOfTree;
import com.example.chikara.stack.Tree.BinaryTree.LevelOrderTraversal;
import com.example.chikara.stack.Tree.BinaryTree.PreOrderTraversal;
import com.example.chikara.stack.Tree.BinaryTree.SpiralOrderTraversal;
import com.example.chikara.stack.Tree.BinaryTree.TwoTreeIdentical;

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
                        SpiralOrderTraversal.class);
                startActivity(intent);
            }
        });
    }
}
