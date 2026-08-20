package com.example.ui.screens

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Celebration
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.VolunteerActivism
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.CYGM_EVENTS
import com.example.data.CYGM_STATS
import com.example.data.FestivalInfo
import com.example.data.MandapLocationInfo
import com.example.ui.components.CYGMTab
import com.example.ui.components.EventCard
import com.example.ui.components.PlaceholderCardImage
import com.example.ui.components.PrimaryButton
import com.example.ui.components.SecondaryButton
import com.example.ui.components.SectionHeader
import com.example.ui.theme.CreamBackground
import com.example.ui.theme.CreamCardBorder
import com.example.ui.theme.CreamSurface
import com.example.ui.theme.CreamSurfaceVariant
import com.example.ui.theme.DeepRed
import com.example.ui.theme.DeepRedContainer
import com.example.ui.theme.DeepRedDark
import com.example.ui.theme.GoldBorder
import com.example.ui.theme.RoyalGold
import com.example.ui.theme.RoyalGoldLight
import com.example.ui.theme.SaffronContainer
import com.example.ui.theme.SaffronOrange
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
    festivalInfo: FestivalInfo,
    locationInfo: MandapLocationInfo = MandapLocationInfo(),
    onNavigateTab: (CYGMTab) -> Unit,
    onViewAbout: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val openUrl: (String) -> Unit = { url ->
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Could not open link", Toast.LENGTH_SHORT).show()
        }
    }
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(CreamBackground)
            .testTag("home_screen_container"),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Center-constrained box for tablet / desktop responsiveness
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 640.dp)
            ) {
                HeroSection(
                    festivalInfo = festivalInfo,
                    onViewEvents = { onNavigateTab(CYGMTab.EVENTS) },
                    onViewLocation = { onNavigateTab(CYGMTab.LOCATION) },
                    openUrl = openUrl
                )
            }
        }

        // Daily Aarti & Darshan Schedule Card
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 640.dp)
            ) {
                AartiScheduleCard(
                    festivalInfo = festivalInfo,
                    onViewAllEvents = { onNavigateTab(CYGMTab.EVENTS) }
                )
            }
        }

        // Quick Navigation Grid
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 640.dp)
            ) {
                QuickActionsGrid(
                    onNavigateTab = onNavigateTab,
                    onViewAbout = onViewAbout
                )
            }
        }

        // Official Announcements Banner
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 640.dp)
            ) {
                AnnouncementsSection(festivalInfo = festivalInfo)
            }
        }

        // Festival Highlights Preview (or Notice if empty)
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 640.dp)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    SectionHeader(
                        kicker = "Mahotsav Schedule",
                        title = "Utsav Calendar",
                        subtitle = "Official program at RR Chowrasta Ka Raja Mandap"
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    if (CYGM_EVENTS.isNotEmpty()) {
                        CYGM_EVENTS.filter { it.isPrimaryHighlight }.take(2).forEach { event ->
                            EventCard(event = event, modifier = Modifier.padding(vertical = 4.dp))
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    } else {
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = CreamSurface),
                            border = BorderStroke(1.dp, GoldBorder.copy(alpha = 0.6f)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(14.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(40.dp)
                                        .background(SaffronOrange.copy(alpha = 0.12f), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.CalendarMonth,
                                        contentDescription = null,
                                        tint = DeepRed,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = "Official Schedule Updating Soon",
                                        style = MaterialTheme.typography.titleSmall.copy(
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 13.sp
                                        ),
                                        color = DeepRed
                                    )
                                    Text(
                                        text = "Festival itinerary will be updated soon with full pooja timings.",
                                        style = MaterialTheme.typography.bodySmall.copy(fontSize = 11.sp),
                                        color = TextSecondary
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                    SecondaryButton(
                        text = "View Schedule & Aarti Details",
                        onClick = { onNavigateTab(CYGMTab.EVENTS) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }

        // Official Photography Placeholder Section
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 640.dp)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    SectionHeader(
                        kicker = "Visual Archives",
                        title = "Darshan & Seva Gallery",
                        subtitle = "Official high-resolution photography archives"
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    PlaceholderCardImage(
                        placeholderLabel = "Chaitanya Youth 2025 Mahotsav",
                        imageResId = R.drawable.cygm_celebration_2025,
                        categoryBadge = "2025 Utsav",
                        aspectRatio = 16f / 10f,
                        onClick = { onNavigateTab(CYGMTab.GALLERY) }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    PrimaryButton(
                        text = "Browse Full Photo Gallery",
                        onClick = { onNavigateTab(CYGMTab.GALLERY) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }

        // Official Instagram & Google Maps Quick Connect Card
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 640.dp)
            ) {
                Card(
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = CreamSurface),
                    border = BorderStroke(1.2.dp, RoyalGold),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(CircleShape)
                                    .background(DeepRed.copy(alpha = 0.1f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = null,
                                    tint = DeepRed,
                                    modifier = Modifier.size(20.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(10.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "RR Chowrasta Mandap & Seva Desk",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp
                                    ),
                                    color = DeepRed
                                )
                                Text(
                                    text = locationInfo.officialAddress,
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        fontSize = 11.sp,
                                        lineHeight = 15.sp
                                    ),
                                    color = TextSecondary
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Key Landmark & Neighborhoods
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = SaffronOrange.copy(alpha = 0.12f),
                            border = BorderStroke(0.7.dp, SaffronOrange.copy(alpha = 0.35f)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "📍 Landmark: Beside Indian Oil Petrol Pump",
                                    style = MaterialTheme.typography.labelSmall.copy(
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold
                                    ),
                                    color = DeepRed
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "Boundaries: Seetharam Nagar Colony • Anand Nagar",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.SemiBold
                            ),
                            color = TextSecondary
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Button(
                                onClick = { openUrl(locationInfo.googleMapsUrl) },
                                colors = ButtonDefaults.buttonColors(containerColor = DeepRed),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Map,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "Google Maps",
                                    style = MaterialTheme.typography.labelMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 12.sp
                                    ),
                                    color = Color.White
                                )
                            }

                            OutlinedButton(
                                onClick = { openUrl(locationInfo.instagramUrl) },
                                shape = RoundedCornerShape(8.dp),
                                border = BorderStroke(1.dp, SaffronOrange),
                                colors = ButtonDefaults.outlinedButtonColors(contentColor = SaffronOrange),
                                modifier = Modifier.weight(1f)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.CameraAlt,
                                    contentDescription = null,
                                    tint = SaffronOrange,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "Instagram",
                                    style = MaterialTheme.typography.labelMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 12.sp
                                    ),
                                    color = SaffronOrange
                                )
                            }
                        }
                    }
                }
            }
        }

        // Mandali Stats & Pillars
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 640.dp)
            ) {
                MandaliStatsSection()
            }
        }

        // Bottom devotion footer note
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 640.dp)
                    .padding(vertical = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "॥ श्री गणेशाय नमः ॥",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        ),
                        color = DeepRed
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Chaitanya Youth Ganesh Mandali • RR Chowrasta • Nizamabad",
                        style = MaterialTheme.typography.bodySmall.copy(fontSize = 11.sp),
                        color = TextMuted,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
private fun HeroSection(
    festivalInfo: FestivalInfo,
    onViewEvents: () -> Unit,
    onViewLocation: () -> Unit,
    openUrl: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CreamSurface),
        border = BorderStroke(1.5.dp, RoyalGold),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        modifier = modifier
            .fillMaxWidth()
            .testTag("home_hero_card")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header row with Sacred Invocations and Top-Right Instagram Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Sacred Invocations
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = RoyalGold.copy(alpha = 0.12f),
                    border = BorderStroke(0.8.dp, RoyalGold)
                ) {
                    Text(
                        text = "॥ ॐ गं गणपतये नमः ॥",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            letterSpacing = 0.5.sp
                        ),
                        color = DeepRed,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 4.dp)
                    )
                }

                // Official Instagram Pill Badge & Icon at Top-Right
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = Color.Transparent,
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .clickable { openUrl("https://www.instagram.com/rr_chowrasta_ka_raja?igsi=b3UxdHhxejZodXo4") }
                        .testTag("hero_instagram_badge")
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .background(
                                Brush.horizontalGradient(
                                    colors = listOf(
                                        Color(0xFF833AB4),
                                        Color(0xFFE1306C),
                                        Color(0xFFFD1D1D),
                                        Color(0xFFFCAF45)
                                    )
                                ),
                                RoundedCornerShape(20.dp)
                            )
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.CameraAlt,
                            contentDescription = "Instagram",
                            tint = Color.White,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Instagram",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 11.sp
                            ),
                            color = Color.White
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Main King Title
            Text(
                text = "RR CHOWRASTA KA RAJA",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Black,
                    fontSize = 22.sp,
                    letterSpacing = 0.5.sp
                ),
                color = DeepRed,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(2.dp))

            // Mandali Org Name
            Text(
                text = festivalInfo.organizationName,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                ),
                color = SaffronOrange,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(2.dp))

            // Location Tagline
            Text(
                text = "Nizamabad • Telangana • #CYGM",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                ),
                color = TextSecondary
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Hero Image Card featuring official CYGM Emblem & Murti Artwork
            PlaceholderCardImage(
                placeholderLabel = "RR Chowrasta Ka Raja • Official CYGM Darshan",
                imageResId = R.drawable.cygm_hero_banner,
                categoryBadge = "#CYGM Nizamabad",
                aspectRatio = 16f / 9f
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = festivalInfo.motto,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    lineHeight = 18.sp
                ),
                color = TextPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Call to action buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                PrimaryButton(
                    text = "Aarti Schedule",
                    onClick = onViewEvents,
                    modifier = Modifier.weight(1f),
                    testTag = "hero_schedule_button"
                )
                SecondaryButton(
                    text = "Mandap Map",
                    onClick = onViewLocation,
                    modifier = Modifier.weight(1f),
                    testTag = "hero_map_button"
                )
            }
        }
    }
}

@Composable
private fun AartiScheduleCard(
    festivalInfo: FestivalInfo,
    onViewAllEvents: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = CreamSurface),
        border = BorderStroke(1.dp, GoldBorder),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
            .fillMaxWidth()
            .testTag("aarti_schedule_card")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(DeepRed.copy(alpha = 0.1f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccessTime,
                            contentDescription = null,
                            tint = DeepRed,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Daily Darshan Schedule",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        ),
                        color = DeepRed
                    )
                }

                Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = DeepRed.copy(alpha = 0.12f)
                ) {
                    Text(
                        text = "DAILY TIMINGS",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 10.sp
                        ),
                        color = DeepRed,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Morning Darshan & Aarti Slot
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = CreamSurfaceVariant,
                border = BorderStroke(1.dp, GoldBorder.copy(alpha = 0.7f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Morning Darshan & Aarti",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 11.sp
                            ),
                            color = TextPrimary
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Darshan: ",
                                style = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp),
                                color = TextSecondary
                            )
                            Text(
                                text = "06:00 AM – 12:30 PM",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp
                                ),
                                color = DeepRed
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Maha Aarti: ",
                                style = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp),
                                color = TextSecondary
                            )
                            Text(
                                text = "08:00 AM Sharp",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp
                                ),
                                color = SaffronOrange
                            )
                        }
                    }

                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = SaffronOrange.copy(alpha = 0.15f),
                        border = BorderStroke(0.8.dp, SaffronOrange)
                    ) {
                        Text(
                            text = "Aarti: 8:00 AM",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 11.sp
                            ),
                            color = DeepRed,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Evening Darshan & Aarti Slot (upto 12:00 AM)
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = CreamSurfaceVariant,
                border = BorderStroke(1.dp, GoldBorder.copy(alpha = 0.7f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Evening Darshan & Aarti (Till Midnight)",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 11.sp
                            ),
                            color = TextPrimary
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Darshan: ",
                                style = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp),
                                color = TextSecondary
                            )
                            Text(
                                text = "04:30 PM – 12:00 AM",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp
                                ),
                                color = DeepRed
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Maha Aarti: ",
                                style = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp),
                                color = TextSecondary
                            )
                            Text(
                                text = "07:30 PM Sharp",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp
                                ),
                                color = SaffronOrange
                            )
                        }
                    }

                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = DeepRed,
                        border = BorderStroke(0.8.dp, DeepRed)
                    ) {
                        Text(
                            text = "Aarti: 7:30 PM",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 11.sp
                            ),
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Mandap Location: RR Chowrasta (Beside Indian Oil Petrol Pump)",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium
                ),
                color = TextSecondary,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun QuickActionsGrid(
    onNavigateTab: (CYGMTab) -> Unit,
    onViewAbout: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        SectionHeader(
            kicker = "Quick Access",
            title = "Mandali Services",
            subtitle = "Explore darshan, committee, events, and seva"
        )

        Spacer(modifier = Modifier.height(6.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            QuickActionItem(
                title = "Gallery",
                subtitle = "Photos & Videos",
                icon = Icons.Default.PhotoLibrary,
                color = DeepRed,
                onClick = { onNavigateTab(CYGMTab.GALLERY) },
                modifier = Modifier.weight(1f),
                testTag = "quick_action_gallery"
            )
            QuickActionItem(
                title = "Utsav Events",
                subtitle = "Aarti Schedule",
                icon = Icons.Default.CalendarMonth,
                color = SaffronOrange,
                onClick = { onNavigateTab(CYGMTab.EVENTS) },
                modifier = Modifier.weight(1f),
                testTag = "quick_action_events"
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            QuickActionItem(
                title = "Youth Team",
                subtitle = "CYGM Organizers",
                icon = Icons.Default.Groups,
                color = SaffronOrange,
                onClick = { onNavigateTab(CYGMTab.TEAM) },
                modifier = Modifier.weight(1f),
                testTag = "quick_action_team"
            )
            QuickActionItem(
                title = "Mandap Map",
                subtitle = "RR Chowrasta",
                icon = Icons.Default.Place,
                color = DeepRed,
                onClick = { onNavigateTab(CYGMTab.LOCATION) },
                modifier = Modifier.weight(1f),
                testTag = "quick_action_location"
            )
        }
    }
}

@Composable
private fun QuickActionItem(
    title: String,
    subtitle: String,
    icon: ImageVector,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    testTag: String
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = CreamSurface,
        border = BorderStroke(1.dp, GoldBorder.copy(alpha = 0.5f)),
        shadowElevation = 1.5.dp,
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable { onClick() }
            .testTag(testTag)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(color.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = color,
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp
                    ),
                    color = TextPrimary
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 10.sp
                    ),
                    color = TextMuted
                )
            }
        }
    }
}

@Composable
private fun AnnouncementsSection(
    festivalInfo: FestivalInfo,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        SectionHeader(
            kicker = "Notice Board",
            title = "Mandali Announcements",
            subtitle = "Official updates for pilgrims and youth volunteers"
        )

        Spacer(modifier = Modifier.height(4.dp))

        festivalInfo.announcements.forEach { ann ->
            Card(
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(containerColor = CreamSurface),
                border = BorderStroke(1.dp, GoldBorder.copy(alpha = 0.4f)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Icon(
                        imageVector = Icons.Default.NotificationsActive,
                        contentDescription = null,
                        tint = DeepRed,
                        modifier = Modifier
                            .size(20.dp)
                            .padding(top = 2.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = DeepRed.copy(alpha = 0.1f)
                            ) {
                                Text(
                                    text = ann.badge,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = DeepRed,
                                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.5.dp)
                                )
                            }
                            Text(
                                text = ann.title,
                                style = MaterialTheme.typography.titleSmall.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                ),
                                color = TextPrimary
                            )
                        }
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = ann.message,
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontSize = 11.sp,
                                lineHeight = 15.sp
                            ),
                            color = TextSecondary
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun MandaliStatsSection(modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = CreamSurfaceVariant),
        border = BorderStroke(1.dp, GoldBorder.copy(alpha = 0.6f)),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "CYGM Mandali Legacy",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                ),
                color = DeepRed
            )
            Text(
                text = "Uniting Nizamabad youth in service of Lord Ganesha",
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 11.sp),
                color = TextSecondary
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CYGM_STATS.take(2).forEach { stat ->
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = CreamSurface,
                        border = BorderStroke(0.6.dp, GoldBorder.copy(alpha = 0.5f)),
                        modifier = Modifier.weight(1f)
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(
                                text = stat.value,
                                fontWeight = FontWeight.Black,
                                fontSize = 13.sp,
                                color = DeepRed
                            )
                            Text(
                                text = stat.label,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 10.sp,
                                color = TextPrimary
                            )
                            Text(
                                text = stat.subtext,
                                fontSize = 9.sp,
                                color = TextMuted
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CYGM_STATS.drop(2).take(2).forEach { stat ->
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = CreamSurface,
                        border = BorderStroke(0.6.dp, GoldBorder.copy(alpha = 0.5f)),
                        modifier = Modifier.weight(1f)
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(
                                text = stat.value,
                                fontWeight = FontWeight.Black,
                                fontSize = 13.sp,
                                color = SaffronOrange
                            )
                            Text(
                                text = stat.label,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 10.sp,
                                color = TextPrimary
                            )
                            Text(
                                text = stat.subtext,
                                fontSize = 9.sp,
                                color = TextMuted
                            )
                        }
                    }
                }
            }
        }
    }
}
