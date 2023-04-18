package com.tech.sampletv

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.leanback.app.BrowseSupportFragment

 /*BrowesSupportFragment is provided by leanback lib
 * BrowesSupportFragment containing HeadersFragment and RowsFragment
 *
 * */

class MainFragment : BrowseSupportFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUiComponent()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    public fun setupUiComponent(){
        //badgeDrawable=resources.getDrawable(R.drawable.vedio_banner,null)
        // set Title
        title="This is my first TV App"
        headersState=HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled=true

        //set fastLane (or headers) background color
        brandColor=resources.getColor(R.color.fastlane_background,null)

        // set search icon color
        searchAffordanceColor=resources.getColor(R.color.search_opaque,null)

    }
}