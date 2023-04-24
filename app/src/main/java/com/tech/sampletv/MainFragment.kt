package com.tech.sampletv

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import com.tech.sampletv.model.HeaderItemModel
import com.tech.sampletv.prasenter.HeaderPresenter
import com.tech.sampletv.utils.MyHeaderList
import java.util.*


/*BrowesSupportFragment is provided by leanback lib
* BrowesSupportFragment containing HeadersFragment and RowsFragment
*
* */

class MainFragment : BrowseSupportFragment() {


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
        //set fastLane (or headers) background color
        brandColor=resources.getColor(R.color.fastlane_background,null)

        // set search icon color
        searchAffordanceColor=resources.getColor(R.color.search_opaque,null)

        setHeader()

    }
    private fun setHeader(){
        headersState=HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled=true

        // set fastLane (or headers) background color
        brandColor = ContextCompat.getColor(requireContext(), R.color.fastlane_background)

        // set search icon color
        searchAffordanceColor = ContextCompat.getColor(requireContext(), R.color.search_opaque)

        // Lines of code to be added
        val sHeaderPresenter: PresenterSelector = ClassPresenterSelector()
            .addClassPresenter(DividerRow::class.java, DividerPresenter())
            .addClassPresenter(SectionRow::class.java, RowHeaderPresenter())
            .addClassPresenter(Row::class.java, HeaderPresenter())

        setHeaderPresenterSelector(sHeaderPresenter)

        loadRows()
    }

    private fun loadRows() {
        //var i=0
        var myHeader = MyHeaderList.headerList
        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        for (i in myHeader.indices) {
            //add category with icon
            val listRowAdapter = ArrayObjectAdapter(HeaderPresenter())
            var header = HeaderItemModel(i, MyHeaderList.headerList[i], R.drawable.arrow)
            rowsAdapter.add(ListRow(header, listRowAdapter))
        }


        setAdapter(rowsAdapter);

    }

}