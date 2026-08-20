package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.CYGM_GALLERY_ITEMS
import com.example.data.GalleryCategory
import com.example.data.GalleryItem
import com.example.ui.components.GalleryCard
import com.example.ui.components.PlaceholderCardImage
import com.example.ui.components.PrimaryButton
import com.example.ui.components.SectionHeader
import com.example.ui.theme.CreamBackground
import com.example.ui.theme.CreamSurface
import com.example.ui.theme.CreamSurfaceVariant
import com.example.ui.theme.DeepRed
import com.example.ui.theme.GoldBorder
import com.example.ui.theme.RoyalGold
import com.example.ui.theme.SaffronOrange
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GalleryScreen(
    modifier: Modifier = Modifier
) {
    var selectedCategory by remember { mutableStateOf(GalleryCategory.ALL) }
    var selectedItemForDetail by remember { mutableStateOf<GalleryItem?>(null) }

    val filteredItems = remember(selectedCategory) {
        when (selectedCategory) {
            GalleryCategory.ALL -> CYGM_GALLERY_ITEMS
            GalleryCategory.CELEBRATION_2025 -> CYGM_GALLERY_ITEMS.filter { it.category == "2025 Utsav" }
            GalleryCategory.FOUNDATION -> CYGM_GALLERY_ITEMS.filter { it.category == "Starting 2013" }
            GalleryCategory.MURTI_DARSHAN -> CYGM_GALLERY_ITEMS.filter { it.category == "Murti Darshan" }
            GalleryCategory.MAHA_AARTI -> CYGM_GALLERY_ITEMS.filter { it.category == "Maha Aarti" }
            GalleryCategory.SHOBHAYATRA -> CYGM_GALLERY_ITEMS.filter { it.category == "Visarjan Shobhayatra" }
            GalleryCategory.SEVA_ACTIVITIES -> CYGM_GALLERY_ITEMS.filter { it.category == "Social Seva & Youth" }
        }
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(CreamBackground)
            .testTag("gallery_screen_container"),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
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
                        kicker = "Visual Archives",
                        title = "CYGM Photo Gallery",
                        subtitle = "Cherished moments, sacred darshan, and youth seva",
                        badgeText = "${CYGM_GALLERY_ITEMS.size} Photos"
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Filter chips row
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(GalleryCategory.values()) { cat ->
                            val isSelected = cat == selectedCategory
                            FilterChip(
                                selected = isSelected,
                                onClick = { selectedCategory = cat },
                                label = {
                                    Text(
                                        text = cat.label,
                                        fontSize = 12.sp,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                                    )
                                },
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = DeepRed,
                                    selectedLabelColor = Color.White,
                                    containerColor = CreamSurface,
                                    labelColor = TextPrimary
                                ),
                                border = FilterChipDefaults.filterChipBorder(
                                    borderColor = GoldBorder,
                                    selectedBorderColor = DeepRed,
                                    enabled = true,
                                    selected = isSelected
                                )
                            )
                        }
                    }
                }
            }
        }

        // Gallery items
        items(filteredItems, key = { it.id }) { item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 640.dp)
            ) {
                GalleryCard(
                    item = item,
                    onClick = { selectedItemForDetail = item }
                )
            }
        }
    }

    // Modal dialog when tapping an item
    selectedItemForDetail?.let { item ->
        BasicAlertDialog(
            onDismissRequest = { selectedItemForDetail = null },
            modifier = Modifier.widthIn(max = 500.dp)
        ) {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = CreamSurface),
                border = BorderStroke(1.5.dp, RoyalGold),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    PlaceholderCardImage(
                        placeholderLabel = item.placeholderLabel,
                        imageResId = item.imageResId,
                        categoryBadge = item.tag,
                        aspectRatio = 16f / 10f,
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
                                text = item.title,
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                ),
                                color = DeepRed,
                                modifier = Modifier.weight(1f)
                            )
                            IconButton(
                                onClick = { selectedItemForDetail = null },
                                modifier = Modifier.size(32.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Close Dialog",
                                    tint = TextSecondary
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = item.caption,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 13.sp,
                                lineHeight = 18.sp
                            ),
                            color = TextPrimary
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = CreamSurfaceVariant,
                            border = BorderStroke(0.8.dp, GoldBorder.copy(alpha = 0.5f)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Info,
                                    contentDescription = null,
                                    tint = SaffronOrange,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Category: ${item.category} • #CYGM Archives",
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Medium
                                    ),
                                    color = TextSecondary
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        PrimaryButton(
                            text = "Close Preview",
                            onClick = { selectedItemForDetail = null },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}
