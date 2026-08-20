package com.example.data

data class FestivalInfo(
    val organizationName: String = "Chaitanya Youth Ganesh Mandali",
    val shortName: String = "#CYGM",
    val title: String = "RR Chowrasta Ka Raja",
    val location: String = "Nizamabad, Telangana",
    val pincode: String = "503001",
    val motto: String = "Devotion, Unity & Social Welfare in the Heart of Nizamabad",
    val yearDescription: String = "Ganesh Chaturthi Annual Mahotsav",
    val aartiMorningTime: String = "08:00 AM",
    val aartiEveningTime: String = "07:30 PM",
    val aartiScheduleNote: String = "Morning 08:00 AM & Evening 07:30 PM",
    val darshanMorning: String = "06:00 AM – 12:30 PM (Aarti: 08:00 AM)",
    val darshanEvening: String = "04:30 PM – 12:00 AM Midnight (Aarti: 07:30 PM)",
    val darshanTimings: String = "Morning: 06:00 AM – 12:30 PM | Evening: 04:30 PM – 12:00 AM",
    val announcements: List<AnnouncementItem> = listOf(
        AnnouncementItem(
            id = "ann-1",
            badge = "DAILY AARTI",
            title = "Daily Aarti & Darshan Schedule",
            message = "Morning Darshan: 06:00 AM – 12:30 PM (Aarti: 08:00 AM) | Evening Darshan: 04:30 PM – 12:00 AM (Aarti: 07:30 PM) at RR Chowrasta Mandap."
        ),
        AnnouncementItem(
            id = "ann-2",
            badge = "SEVA",
            title = "Maha Annadanam & Laddu Prasadam",
            message = "Devotees can participate in Annadanam seva and register for the auspicious RR Chowrasta Ka Raja Laddu auction."
        ),
        AnnouncementItem(
            id = "ann-3",
            badge = "COMMUNITY",
            title = "Youth Blood Donation Camp",
            message = "Youth blood donation drive organized by 50+ CYGM youth members in association with Nizamabad Red Cross Society."
        )
    )
)

data class AnnouncementItem(
    val id: String,
    val badge: String,
    val title: String,
    val message: String
)

data class StatItem(
    val value: String,
    val label: String,
    val subtext: String
)

val CYGM_STATS = listOf(
    StatItem(value = "RR Chowrasta", label = "Iconic Location", subtext = "Beside Indian Oil Petrol Pump"),
    StatItem(value = "2 Times Daily", label = "Maha Aarti", subtext = "08:00 AM & 07:30 PM"),
    StatItem(value = "Upto 12:00 AM", label = "Night Darshan", subtext = "Open till Midnight"),
    StatItem(value = "50+ Youth", label = "Youth Members", subtext = "#CYGM Active Members")
)
