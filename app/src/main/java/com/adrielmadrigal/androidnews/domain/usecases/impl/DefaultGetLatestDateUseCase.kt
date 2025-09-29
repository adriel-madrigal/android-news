package com.adrielmadrigal.androidnews.domain.usecases.impl

import android.os.Build
import androidx.annotation.RequiresApi
import com.adrielmadrigal.androidnews.domain.usecases.GetLatestDateUseCase
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class DefaultGetLatestDateUseCase @Inject constructor(

): GetLatestDateUseCase {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun invoke(): String {
        val currentDateTime = LocalDateTime.now()
        val customDateFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return currentDateTime.format(customDateFormater)
    }
}