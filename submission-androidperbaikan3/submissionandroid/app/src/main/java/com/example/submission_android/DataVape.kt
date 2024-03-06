package com.example.submission_android

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataVape(
    val name: String,
    val description: String,
    val lengkap: String,
    val photo: Int
):Parcelable
