package com.mb.bankapp.data

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector

data class CardModel (
    val icon : Int,
    val type : String,
    val balance : String,
    val cardNumber : String,
    val color : Brush
)