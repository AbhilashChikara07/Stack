package com.example.chikara.stack.Queue

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.util.*
import kotlin.collections.HashSet

class LRUCashing : AppCompatActivity() {

    var deque: Deque<Int> = LinkedList()
    var map: HashSet<Int> = HashSet()
    var totalSize: Int = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addItem(1)
        addItem(2)
        addItem(3)
        addItem(1)
    }

    private fun addItem(item: Int) {
        if (!map.contains(item)) {
            if (deque.size == totalSize) {
                val lastElement = deque.removeLast()
                map.remove(lastElement)
            }
            map.add(item)
            deque.add(item)
            totalSize += 1
        } else {
            var i: Int = 0

            val itr: Iterator<Int> = deque.iterator()
            while (itr.hasNext()) {
                if (item == itr.next()) {
                    deque.remove(i)
                    break
                }
                i += 1
            }

            map.add(item)
            deque.add(item)
            totalSize += 1
        }
    }

}