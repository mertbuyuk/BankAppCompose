package com.mb.bankapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoGraph
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mb.bankapp.data.FinanceItem
import com.mb.bankapp.ui.theme.BlueStart
import com.mb.bankapp.ui.theme.OrangeStart
import com.mb.bankapp.ui.theme.PurpleStart

val financeItems = listOf<FinanceItem>(
    FinanceItem(
        Icons.Rounded.StarHalf,
        "Business",
        OrangeStart
    ),FinanceItem(
        Icons.Rounded.Wallet,
        "Wallet",
        BlueStart
    ),FinanceItem(
        Icons.Rounded.AutoGraph,
        "Analysis",
        PurpleStart
    ),
    FinanceItem(
        Icons.Rounded.Wallet,
        "Wallet",
        BlueStart
    ),
    FinanceItem(
        Icons.Rounded.Wallet,
        "Wallet",
        BlueStart
    )

    )
@Preview
@Composable
fun financeCompose(){
    Column() {
        Text(text = "Finance"
            , fontSize = 24.sp
            , color = MaterialTheme.colorScheme.onBackground
            , fontWeight = FontWeight.Bold
            , modifier = Modifier.padding(16.dp))

        LazyRow{
            items(financeItems.size){ index ->
                financeItemCompose(index)
            }
        }

    }
}

@Composable
fun financeItemCompose(index: Int) {

    val item = financeItems[index]
    val lastPadding = 0.dp

    if (index == financeItems.size-1){
        val lastPadding = 16.dp
    }

    Box(modifier = Modifier
        .padding(start = 16.dp,end = lastPadding)
        .clip(RoundedCornerShape(24.dp))
        .background(MaterialTheme.colorScheme.secondaryContainer)){
        Column(modifier = Modifier
            .padding(14.dp)
            .size(100.dp),
            verticalArrangement = Arrangement.SpaceBetween) {

            Box(modifier =
            Modifier.clip(RoundedCornerShape(16.dp))
                .background(item.color)
                .padding(8.dp)){

                Icon(
                    imageVector = item.imageVector,
                    contentDescription = item.category,
                    tint = Color.White,
                )
            }

            Text(text = item.category,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                modifier = Modifier.padding(bottom = 16.dp))
        }
    }
}
