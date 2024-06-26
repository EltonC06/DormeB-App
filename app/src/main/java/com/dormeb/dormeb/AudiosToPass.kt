package com.dormeb.dormeb

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AudiosToPass(val audios: MutableList<String>) : Parcelable
