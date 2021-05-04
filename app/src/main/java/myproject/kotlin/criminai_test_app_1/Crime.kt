package myproject.kotlin.criminai_test_app_1

import java.util.*

data class Crime(val id: UUID = UUID.randomUUID(), var title: String = "",
                 var date: Date = Date(), var isSolved: Boolean = false)