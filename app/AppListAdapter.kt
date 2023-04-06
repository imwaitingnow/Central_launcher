package com.central.launcher

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.central.launcher.AppListAdapter



class AppListAdapter(private val context: Context, private val appList: List<ApplicationInfo>) :
    RecyclerView.Adapter<AppListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.app_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val appInfo = appList[position]
        val appName = appInfo.loadLabel(context.packageManager).toString()
        holder.itemView.app_name.text = appName
        holder.itemView.setOnClickListener {
            val intent = context.packageManager.getLaunchIntentForPackage(appInfo.packageName)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = appList.size
}

    override fun getItemCount(): Int {
        return appsList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var appIcon: ImageView = itemView.findViewById(R.id.app_icon)
        var appName: TextView = itemView.findViewById(R.id.app_name)
        var packageName: TextView = itemView.findViewById(R.id.package_name)
    }
}
