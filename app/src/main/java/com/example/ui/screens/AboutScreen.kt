package com.example.ui.screens

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Diversity1
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Handshake
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.OpenInNew
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.FestivalInfo
import com.example.data.MandapLocationInfo
import com.example.ui.components.PlaceholderCardImage
import com.example.ui.components.SectionHeader
import com.example.ui.theme.CreamBackground
import com.example.ui.theme.CreamSurface
import com.example.ui.theme.CreamSurfaceVariant
import com.example.ui.theme.DeepRed
import com.example.ui.theme.GoldBorder
import com.example.ui.theme.RoyalGold
import com.example.ui.theme.SaffronOrange
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

@Composable
fun AboutScreen(
    festivalInfo: FestivalInfo,
    locationInfo: MandapLocationInfo = MandapLocationInfo(),
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
            .testTag("about_screen_container"),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 640.dp)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    SectionHeader(
                        kicker = "Sacred Heritage",
                        title = "About CYGM",
                        subtitle = "Chaitanya Youth Ganesh Mandali • RR Chowrasta Ka Raja"
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    PlaceholderCardImage(
                        placeholderLabel = "RR Chowrasta Ka Raja • Nizamabad Heritage",
                        imageResId = R.drawable.cygm_hero_banner,
                        categoryBadge = "Nizamabad Heritage",
                        aspectRatio = 16f / 9f
                    )
                }
            }
        }

        // The Legacy of RR Chowrasta Ka Raja
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 640.dp)
            ) {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = CreamSurface),
                    border = BorderStroke(1.dp, GoldBorder.copy(alpha = 0.6f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(CircleShape)
                                    .background(DeepRed.copy(alpha = 0.1f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = null,
                                    tint = DeepRed,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = "The Legacy of RR Chowrasta Ka Raja",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                ),
                                color = DeepRed
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "In the bustling heart of Nizamabad at the iconic RR Chowrasta (Rajiv Gandhi Statue Junction), Chaitanya Youth Ganesh Mandali (#CYGM) has stood as a beacon of devotion, cultural unity, and social service for decades.",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 13.sp,
                                lineHeight = 19.sp
                            ),
                            color = TextPrimary
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Every year during Sri Ganesha Chaturthi, RR Chowrasta Ka Raja is installed with Vedic sanctity. Devotees from across Nizamabad district, neighbouring towns, and all walks of life gather here for daily darshan, morning and evening Maha Harathis, and to partake in the consecrated Maha Prasadam.",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 13.sp,
                                lineHeight = 19.sp
                            ),
                            color = TextSecondary
                        )
                    }
                }
            }
        }

        // Starting of Chaitanya Youth (2013 Origin)
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 640.dp)
            ) {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = CreamSurface),
                    border = BorderStroke(1.2.dp, RoyalGold),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        PlaceholderCardImage(
                            placeholderLabel = "Starting of Chaitanya Youth (2013)",
                            imageResId = R.drawable.cygm_foundation_2013,
                            categoryBadge = "Est. 2013 • Founding Year",
                            aspectRatio = 16f / 11f,
                            cornerRadius = 0.dp
                        )

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
                                Text(
                                    text = "Starting of Chaitanya Youth (2013)",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp
                                    ),
                                    color = DeepRed
                                )
                                Surface(
                                    shape = RoundedCornerShape(4.dp),
                                    color = DeepRed.copy(alpha = 0.1f)
                                ) {
                                    Text(
                                        text = "Historic 2013",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = DeepRed,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "The journey of Chaitanya Youth Ganesh Mandali began in 2013 with a united vision among the local youth and community elders of RR Chowrasta. From humble beginnings with deep devotion to Lord Ganesha, the mandap grew year after year into the revered cultural and social landmark it is today.",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontSize = 13.sp,
                                    lineHeight = 19.sp
                                ),
                                color = TextPrimary
                            )
                        }
                    }
                }
            }
        }

        // Chaitanya Youth 2025 Mahotsav Group
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 640.dp)
            ) {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = CreamSurface),
                    border = BorderStroke(1.2.dp, RoyalGold),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        PlaceholderCardImage(
                            placeholderLabel = "Chaitanya Youth 2025 Mahotsav",
                            imageResId = R.drawable.cygm_celebration_2025,
                            categoryBadge = "2025 Utsav • Present Day",
                            aspectRatio = 16f / 11f,
                            cornerRadius = 0.dp
                        )

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
                                Text(
                                    text = "Chaitanya Youth 2025 Mahotsav",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp
                                    ),
                                    color = DeepRed
                                )
                                Surface(
                                    shape = RoundedCornerShape(4.dp),
                                    color = DeepRed.copy(alpha = 0.1f)
                                ) {
                                    Text(
                                        text = "2025 Utsav",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = DeepRed,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "Carrying the proud 12-year tradition forward into 2025, the CYGM team and local devotees gathered in full spirit around Lord Ganesha's darshan at the decorated RR Chowrasta mandap.",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontSize = 13.sp,
                                    lineHeight = 19.sp
                                ),
                                color = TextPrimary
                            )
                        }
                    }
                }
            }
        }

        // Social Welfare & Youth Empowerment Pillars
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 640.dp)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    SectionHeader(
                        kicker = "Seva & Social Action",
                        title = "Community Initiatives",
                        subtitle = "Values championed by Chaitanya Youth volunteers year-round"
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    AboutPillarItem(
                        title = "Maha Annadanam (Free Meals)",
                        description = "Providing thousands of satvik meals and sacred prasad to devotees and needy citizens during the festival days.",
                        icon = Icons.Default.VolunteerActivism
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    AboutPillarItem(
                        title = "Annual Youth Blood Donation Camp",
                        description = "Organizing voluntary blood donation drives in collaboration with local government hospitals and blood banks.",
                        icon = Icons.Default.Favorite
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    AboutPillarItem(
                        title = "100% Eco-Friendly Initiatives",
                        description = "Committed to natural clay murtis, organic floral decor, non-toxic water immersion practices, and clean-up drives post-visarjan.",
                        icon = Icons.Default.Eco
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    AboutPillarItem(
                        title = "Youth Leadership & Community Harmony",
                        description = "Channeling the energy of over 500 youth volunteers toward civic safety, discipline, crowd management, and cultural pride.",
                        icon = Icons.Default.Diversity1
                    )
                }
            }
        }

        // Devotional Traditions
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 640.dp)
            ) {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = CreamSurfaceVariant),
                    border = BorderStroke(1.dp, GoldBorder.copy(alpha = 0.5f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Tradition of Seva & Transparency",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            ),
                            color = DeepRed
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "CYGM operates on the sacred principles of selfless service (Nishkama Seva) and transparency. All donations and Laddu auction proceeds are documented and audited, directly funding social causes and temple preparations.",
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontSize = 12.sp,
                                lineHeight = 17.sp
                            ),
                            color = TextSecondary
                        )
                    }
                }
            }
        }

        // Official Social & Mandap Navigation Links
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 640.dp)
            ) {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = CreamSurface),
                    border = BorderStroke(1.2.dp, RoyalGold),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Connect & Visit RR Chowrasta",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            ),
                            color = DeepRed
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Follow official darshan updates on Instagram and navigate directly to the mandap using Google Maps.",
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontSize = 12.sp,
                                lineHeight = 16.sp
                            ),
                            color = TextPrimary
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "Official Seva Contacts:",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 11.sp
                            ),
                            color = DeepRed
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "📞 +91 91002 73091 | +91 96405 55155 | 6309294824",
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold
                            ),
                            color = TextPrimary
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "✉️ ${locationInfo.email}",
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Medium
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
                                    text = "Mandap Map",
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
                                    text = "@rr_chowrasta",
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
    }
}

@Composable
private fun AboutPillarItem(
    title: String,
    description: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = CreamSurface),
        border = BorderStroke(1.dp, GoldBorder.copy(alpha = 0.4f)),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(SaffronOrange.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = SaffronOrange,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    ),
                    color = TextPrimary
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 12.sp,
                        lineHeight = 16.sp
                    ),
                    color = TextSecondary
                )
            }
        }
    }
}
