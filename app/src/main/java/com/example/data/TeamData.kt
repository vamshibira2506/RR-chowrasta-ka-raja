package com.example.data

data class TeamMember(
    val id: String,
    val roleTitle: String,
    val memberNamePlaceholder: String,
    val category: String,
    val wingDescription: String,
    val responsibilities: String,
    val contactStatus: String = "Official Mandali Desk"
)

enum class TeamCategory(val displayName: String) {
    ALL("All Members"),
    CORE_COMMITTEE("Core Committee"),
    YOUTH_WING("Youth Coordinators"),
    SEVA_WING("Seva & Management"),
    ADVISORY("Advisory Board")
}

val CYGM_TEAM_MEMBERS = listOf(
    TeamMember(
        id = "tm-1",
        roleTitle = "President",
        memberNamePlaceholder = "[President - Name will be updated upon official roster release]",
        category = "Core Committee",
        wingDescription = "Overall Mandali Leadership & Administration",
        responsibilities = "Executive oversight of RR Chowrasta Ka Raja Utsav, community relations, and administration.",
        contactStatus = "Mandali Office"
    ),
    TeamMember(
        id = "tm-2",
        roleTitle = "General Secretary",
        memberNamePlaceholder = "[General Secretary - Name to be updated]",
        category = "Core Committee",
        wingDescription = "Administration & Event Coordination",
        responsibilities = "Protocol management, district administration liaison, and schedule management.",
        contactStatus = "Mandali Desk"
    ),
    TeamMember(
        id = "tm-3",
        roleTitle = "Treasurer & Accounts In-Charge",
        memberNamePlaceholder = "[Treasurer - Name to be updated]",
        category = "Core Committee",
        wingDescription = "Financial Audit & Seva Receipts",
        responsibilities = "Managing transparent mandap accounts, donation receipts, and seva distribution records.",
        contactStatus = "Receipt Counter"
    ),
    TeamMember(
        id = "tm-4",
        roleTitle = "Youth Wing President",
        memberNamePlaceholder = "[Youth Wing President - Name to be updated]",
        category = "Youth Coordinators",
        wingDescription = "#CYGM Youth Force Leader",
        responsibilities = "Youth mobilization, stage setup, dhol-tasha squad coordination, and procession security.",
        contactStatus = "Youth Wing"
    ),
    TeamMember(
        id = "tm-5",
        roleTitle = "Cultural & Pooja Coordinator",
        memberNamePlaceholder = "[Pooja Coordinator - Name to be updated]",
        category = "Seva & Management",
        wingDescription = "Pooja Vidhi & Pandit Management",
        responsibilities = "Managing daily Vedic pooja supplies, flower garlands, and priest scheduling for daily aarti.",
        contactStatus = "Pooja Desk"
    ),
    TeamMember(
        id = "tm-6",
        roleTitle = "Annadanam & Prasadam In-Charge",
        memberNamePlaceholder = "[Annadanam In-Charge - Name to be updated]",
        category = "Seva & Management",
        wingDescription = "Maha Prasadam Distribution",
        responsibilities = "Clean kitchen management, daily devotee meals, and famous Laddu auction arrangements.",
        contactStatus = "Seva Counter"
    ),
    TeamMember(
        id = "tm-7",
        roleTitle = "Visarjan Shobhayatra Lead",
        memberNamePlaceholder = "[Visarjan Lead - Name to be updated]",
        category = "Youth Coordinators",
        wingDescription = "Nimajjanam Route & Logistics",
        responsibilities = "Procession vehicle setup, route crowd management through Nizamabad city to water reservoir.",
        contactStatus = "Field Operations"
    ),
    TeamMember(
        id = "tm-8",
        roleTitle = "Senior Advisory Patron",
        memberNamePlaceholder = "[Senior Patron / Advisor - Name to be updated]",
        category = "Advisory Board",
        wingDescription = "Community Guidance & Traditions",
        responsibilities = "Preserving the 3-decade sacred traditions of RR Chowrasta Ka Raja celebrations.",
        contactStatus = "Advisory Council"
    )
)
