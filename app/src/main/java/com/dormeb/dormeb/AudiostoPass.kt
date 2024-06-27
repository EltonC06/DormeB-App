package com.dormeb.dormeb

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AudiostoPass(val audios: MutableList<String>) : Parcelable
