package com.mb.bankapp.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class FinanceItem(
    val imageVector: ImageVector,
    val category: String,
    val color : Color
)