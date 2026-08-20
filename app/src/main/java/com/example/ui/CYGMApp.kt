package com.example.ui

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.data.FestivalInfo
import com.example.ui.components.CYGMTab
import com.example.ui.components.CYGMTopHeader
import com.example.ui.components.MobileBottomNav
import com.example.ui.screens.AboutScreen
import com.example.ui.screens.EventsScreen
import com.example.ui.screens.GalleryScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LocationContactScreen
import com.example.ui.screens.TeamScreen
import com.example.ui.theme.CreamBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CYGMApp(
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableStateOf(CYGMTab.HOME) }
    var showAboutSheet by remember { mutableStateOf(false) }
    val festivalInfo = remember { FestivalInfo() }

    Scaffold(
        topBar = {
            CYGMTopHeader(
                onInfoClick = { showAboutSheet = true }
            )
        },
        bottomBar = {
            MobileBottomNav(
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )
        },
        containerColor = CreamBackground,
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(CreamBackground)
        ) {
            Crossfade(
                targetState = selectedTab,
                label = "tab_crossfade"
            ) { tab ->
                when (tab) {
                    CYGMTab.HOME -> HomeScreen(
                        festivalInfo = festivalInfo,
                        onNavigateTab = { selectedTab = it },
                        onViewAbout = { showAboutSheet = true }
                    )
                    CYGMTab.GALLERY -> GalleryScreen()
                    CYGMTab.EVENTS -> EventsScreen()
                    CYGMTab.TEAM -> TeamScreen()
                    CYGMTab.LOCATION -> LocationContactScreen(
                        festivalInfo = festivalInfo
                    )
                }
            }
        }
    }

    if (showAboutSheet) {
        val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
        ModalBottomSheet(
            onDismissRequest = { showAboutSheet = false },
            sheetState = sheetState,
            containerColor = CreamBackground
        ) {
            AboutScreen(festivalInfo = festivalInfo)
        }
    }
}
