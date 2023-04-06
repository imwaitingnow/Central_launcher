package com.central.launcher

import android.content.Context
import android.widget.*
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AppView(context: Context, parent: ViewGroup) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.app_list_item, parent, false)
    ) {
    private val appNameView = itemView.findViewById<TextView>(R.id.app_name)
    private val appIconView = itemView.findViewById<ImageView>(R.id.app_icon)

    fun bind(appInfo: AppInfo) {
        appNameView.text = appInfo.appName
        appIconView.setImageDrawable(appInfo.appIcon)

        itemView.setOnClickListener {
            val intent = itemView.context.packageManager.getLaunchIntentForPackage(appInfo.packageName)
            if (intent != null) {
                itemView.context.startActivity(intent)
            }
        }
    }

    companion object {
        fun create(context: Context, parent: ViewGroup): AppView {
            return AppView(context, parent)
        }
    }
}
