package com.central.launcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.central.launcher.AppListAdapter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = AppListAdapter(this)
        recyclerView.adapter = adapter
    }
}
