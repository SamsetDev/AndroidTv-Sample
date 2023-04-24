package com.tech.sampletv.prasenter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.RowHeaderPresenter
import com.tech.sampletv.R
import com.tech.sampletv.model.HeaderItemModel

/*
  Copyright (C) SampleTv - All Rights Reserved Ⓒ
  Unauthorized copying of this file, via any medium is strictly prohibited
  Proprietary and confidential.
  See the License for the specific language governing permissions and limitations under the License.
 
  Created by Sanjay Singh on 25,April,2023 at 2:11 AM for SampleTv.
  New Delhi,India
 */
class HeaderPresenter : RowHeaderPresenter() {
    private var unSelecteditems = 0f

    override fun onCreateViewHolder(viewGroup: ViewGroup): ViewHolder {
        unSelecteditems = viewGroup.resources.getFraction(R.fraction.lb_browse_header_unselect_alpha, 1, 1)
        val inflater = viewGroup.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.header_row, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: Presenter.ViewHolder, o: Any) {
        val iconHeaderItem = (o as ListRow).headerItem as HeaderItemModel
        val rootView = viewHolder.view
        val iconView = rootView.findViewById<AppCompatImageView>(R.id.header_icon)
        val label = rootView.findViewById<AppCompatTextView>(R.id.header_label)
        label.text = iconHeaderItem.name
        iconView.setImageResource(iconHeaderItem.iconResId)
    }

    override fun onUnbindViewHolder(holder: Presenter.ViewHolder) {}

    companion object {
        private val TAG = HeaderPresenter::class.java.simpleName
    }
}