package com.example.data

import com.example.R

data class GalleryItem(
    val id: String,
    val title: String,
    val category: String,
    val tag: String,
    val caption: String,
    val placeholderLabel: String,
    val orientation: String = "Landscape",
    val imageResId: Int? = null,
    val year: String? = null
)

enum class GalleryCategory(val label: String) {
    ALL("All Photos"),
    CELEBRATION_2025("2025 Utsav"),
    MURTI_DARSHAN("Murti Darshan"),
    MAHA_AARTI("Maha Aarti"),
    SHOBHAYATRA("Visarjan Shobhayatra"),
    SEVA_ACTIVITIES("Social Seva & Youth")
}

val CYGM_GALLERY_ITEMS = listOf(
    GalleryItem(
        id = "gal-2025",
        title = "Chaitanya Youth 2025 Mahotsav",
        category = "2025 Utsav",
        tag = "2025 Utsav",
        caption = "The dedicated members, youth volunteers, and families of Chaitanya Youth Ganesh Mandali gathered together in front of the sacred golden Lord Ganesha idol during the 2025 Ganesh Utsav celebrations at RR Chowrasta.",
        placeholderLabel = "Chaitanya Youth 2025 Mahotsav Photo",
        imageResId = R.drawable.cygm_celebration_2025,
        year = "2025"
    ),
    GalleryItem(
        id = "gal-1",
        title = "RR Chowrasta Ka Raja Divya Darshan",
        category = "Murti Darshan",
        tag = "Sacred Darshan",
        caption = "The majestic eco-friendly clay idol of Lord Ganesha adorned with gold crown and velvet silken vastrams at RR Chowrasta.",
        placeholderLabel = "[Official Murti Darshan Photograph Placeholder]",
        imageResId = R.drawable.cygm_hero_banner,
        orientation = "Portrait"
    ),
    GalleryItem(
        id = "gal-2",
        title = "Evening 108 Deepa Harathi",
        category = "Maha Aarti",
        tag = "Daily Aarti",
        caption = "Devotees gathering in deep devotion during the evening Maha Harathi illuminated by traditional brass lamps.",
        placeholderLabel = "[Evening Maha Aarti Ceremony Photograph Placeholder]"
    ),
    GalleryItem(
        id = "gal-3",
        title = "CYGM Youth Dhol Tasha Pathak",
        category = "Visarjan Shobhayatra",
        tag = "Procession",
        caption = "Energetic dhol rhythms echoing across RR Chowrasta during the grand festive celebration.",
        placeholderLabel = "[Youth Dhol Tasha Squad Photograph Placeholder]"
    ),
    GalleryItem(
        id = "gal-4",
        title = "Maha Annadanam Seva Distribution",
        category = "Social Seva & Youth",
        tag = "Community Seva",
        caption = "Chaitanya Youth volunteers serving consecrated meals to thousands of visiting pilgrims and local residents.",
        placeholderLabel = "[Annadanam Prasadam Seva Photograph Placeholder]"
    ),
    GalleryItem(
        id = "gal-5",
        title = "Grand Floral Decoration & Mandap Stage",
        category = "Murti Darshan",
        tag = "Mandap Architecture",
        caption = "Elaborate traditional palace architecture created with marigold garlands and royal canopy designs.",
        placeholderLabel = "[Mandap Stage & Floral Decor Photograph Placeholder]"
    ),
    GalleryItem(
        id = "gal-6",
        title = "Grand Visarjan Shobhayatra Procession",
        category = "Visarjan Shobhayatra",
        tag = "Nimajjanam",
        caption = "Thousands of devotees accompanying the chariot through the heritage streets of Nizamabad.",
        placeholderLabel = "[Grand Nimajjanam Procession Photograph Placeholder]"
    ),
    GalleryItem(
        id = "gal-7",
        title = "Blood Donation & Medical Health Camp",
        category = "Social Seva & Youth",
        tag = "Youth Welfare",
        caption = "Annual health screening and blood donation drive organized for the citizens of Nizamabad.",
        placeholderLabel = "[Blood Donation Camp Photograph Placeholder]"
    ),
    GalleryItem(
        id = "gal-8",
        title = "Devotee Pushparchana & Morning Pooja",
        category = "Maha Aarti",
        tag = "Vedic Rituals",
        caption = "Priests offering 1008 Modaka archana and Vedic mantras during the auspicious morning prayers.",
        placeholderLabel = "[Morning Pushparchana Ceremony Photograph Placeholder]"
    )
)
