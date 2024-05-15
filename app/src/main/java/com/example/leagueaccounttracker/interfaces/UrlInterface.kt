package com.example.leagueaccounttracker.interfaces

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.getString
import com.example.leagueaccounttracker.R

class UrlInterface{
    companion object{
        fun openURL(context : Context, region : String, displayName : String){
            val url = "${getString(context, R.string.url)}/${region}/${displayName}"
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(urlIntent)
        }
    }
}

