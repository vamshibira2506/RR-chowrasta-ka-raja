package com.example.data

data class EventItem(
    val id: String,
    val title: String,
    val dayLabel: String,
    val timeLabel: String,
    val location: String = "RR Chowrasta Mandap, Nizamabad",
    val category: String,
    val summary: String,
    val isPrimaryHighlight: Boolean = false,
    val guidance: String
)

enum class EventFilter(val label: String) {
    ALL("All Events"),
    DAILY_AARTI("Daily Aarti"),
    SPECIAL_PUJA("Special Poojas"),
    SEVA_CULTURAL("Seva & Cultural"),
    VISARJAN("Grand Visarjan")
}

val CYGM_EVENTS: List<EventItem> = emptyList()
