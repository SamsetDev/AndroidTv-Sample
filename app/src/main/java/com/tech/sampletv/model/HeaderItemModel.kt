package com.tech.sampletv.model

import androidx.leanback.widget.HeaderItem
import com.tech.sampletv.model.HeaderItemModel

/*
  Copyright (C) SampleTv - All Rights Reserved Ⓒ
  Unauthorized copying of this file, via any medium is strictly prohibited
  Proprietary and confidential.
  See the License for the specific language governing permissions and limitations under the License.
 
  Created by Sanjay Singh on 25,April,2023 at 2:08 AM for SampleTv.
  New Delhi,India
 */
class HeaderItemModel : HeaderItem {

     // Hold an icon resource id
    var iconResId = ICON_NONE

    // Title + Icon
    // No icon, label only
    @JvmOverloads
    constructor(id: Int, name: String, iconResId: Int = ICON_NONE) : super(id.toLong(), name) {
        this.iconResId = iconResId
    }

    // Title label
    constructor(name: String) : super(name) {}

    companion object {
        private val TAG = HeaderItemModel::class.java.simpleName
        const val ICON_NONE = -1
    }
}