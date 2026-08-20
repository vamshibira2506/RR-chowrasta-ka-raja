package com.example.data

data class ContactPerson(
    val title: String,
    val phone: String,
    val formattedDisplay: String
)

data class MandapLocationInfo(
    val title: String = "RR Chowrasta Ka Raja Mandap",
    val mandaliName: String = "Chaitanya Youth Ganesh Mandali (CYGM)",
    val email: String = "chaitanyayouthganeshmandali@gmail.com",
    val phoneNumbers: List<String> = listOf(
        "+91 91002 73091",
        "+91 96405 55155",
        "+91 63092 94824"
    ),
    val rawPhones: List<String> = listOf(
        "+919100273091",
        "+919640555155",
        "+916309294824"
    ),
    val officialAddress: String = "3-2, Nyalakal Road, Seetharam Nagar Colony, Sitha Ram Nagar, Anand Nagar, Nizamabad, Telangana 503001",
    val street: String = "3-2, Nyalakal Road",
    val neighborhoods: List<String> = listOf(
        "Seetharam Nagar Colony",
        "Sitha Ram Nagar",
        "Anand Nagar"
    ),
    val city: String = "Nizamabad",
    val district: String = "Nizamabad District",
    val state: String = "Telangana",
    val pincode: String = "503001",
    val fullAddress: String = "3-2, Nyalakal Road, Seetharam Nagar Colony, Sitha Ram Nagar, Anand Nagar, Nizamabad, Telangana 503001",
    val googleMapsUrl: String = "https://share.google/DncfiGVZSsTk0bQ8c",
    val instagramUrl: String = "https://www.instagram.com/rr_chowrasta_ka_raja?igsi=b3UxdHhxejZodXo4",
    val instagramHandle: String = "@rr_chowrasta_ka_raja",
    val nearbyLandmarks: List<String> = listOf(
        "Nyalakal Road Junction (Main Gateway)",
        "Seetharam Nagar Colony & Anand Nagar Borders",
        "Nizamabad Railway Station (Approx 1.5 km)",
        "Gandhi Chowk Central Market (Approx 800 m)"
    ),
    val transportTips: List<String> = listOf(
        "Auto-rickshaws available directly to 'RR Chowrasta / Nyalakal Road Ganesh Mandap' from Nizamabad Railway Station and Bus Stand.",
        "Dedicated pedestrian darshan queues for elders, women with children, and general queue.",
        "Designated two-wheeler and four-wheeler parking zones coordinated by traffic police and CYGM youth volunteers."
    ),
    val contactDeskPlaceholder: String = "Chaitanya Youth Ganesh Mandali Official Seva Counter"
)

