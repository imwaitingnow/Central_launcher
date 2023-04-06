package com.central.launcher

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView




class MainActivity : AppCompatActivity() {


    class AppListAdapter(private val context: Context, private val apps: List<AppInfo>) : RecyclerView.Adapter<AppListAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val appInfo = apps[position]
            holder.bind(appInfo)
        }

        override fun getItemCount(): Int {
            return apps.size
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            fun bind(appInfo: AppInfo) {
                // Bind the app information to the view here
            }

        }

    }
}
