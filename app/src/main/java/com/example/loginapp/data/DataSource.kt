package com.example.loginapp.data

import com.example.loginapp.R
import de.loginapp.myapplication.data.model.Posts

class DataSource {

    fun loadCanes(): List<Posts> {
        return listOf(
            Posts(R.string.gießkanne1, R.drawable.can1),
            Posts(R.string.gießkanne2, R.drawable.can2),
            Posts(R.string.gießkanne3, R.drawable.can3),
            Posts(R.string.gießkanne4, R.drawable.can4),
            Posts(R.string.gießkanne5, R.drawable.can5),
            Posts(R.string.gießkanne6, R.drawable.can6),
        )
    }
}