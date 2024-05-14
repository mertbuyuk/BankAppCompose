package com.mb.bankapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mb.bankapp.R
import com.mb.bankapp.data.CardModel
import com.mb.bankapp.ui.theme.BlueEnd
import com.mb.bankapp.ui.theme.BlueStart
import com.mb.bankapp.ui.theme.GreenEnd
import com.mb.bankapp.ui.theme.GreenStart
import com.mb.bankapp.ui.theme.OrangeEnd
import com.mb.bankapp.ui.theme.OrangeStart
import com.mb.bankapp.ui.theme.PurpleEnd
import com.mb.bankapp.ui.theme.PurpleStart


val cards = listOf<CardModel>(
    CardModel(
        icon = R.drawable.ic_mastercard,
        cardNumber =  "2652 9856 4512 3267",
        type = "Student",
        balance = "80.40",
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    CardModel(
        icon = R.drawable.ic_visa,
        cardNumber =  "2652 9856 4512 3267",
        type = "Premium",
        balance = "80.40",
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    CardModel(
        icon = R.drawable.ic_mastercard,
        cardNumber =  "2652 9856 4512 3267",
        type = "Premium",
        balance = "80.40",
        color = getGradient(BlueStart, BlueEnd)
    ),
    CardModel(
        icon = R.drawable.ic_visa,
        cardNumber =  "2652 9856 4512 3267",
        type = "Student",
        balance = "80.40",
        color = getGradient(GreenStart, GreenEnd)
    ),

    )

fun getGradient(start : Color, end : Color) : Brush{

    return Brush.horizontalGradient(colors = listOf(start,end))
}

@Preview
@Composable
fun cardCompose(){

    LazyRow{
        items(cards.size){index->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(index: Int)
{
    val card = cards[index]
    var lastItempadding = 0.dp
    if (index == cards.size-1){
        lastItempadding = 16.dp
    }

    Box(modifier = Modifier.padding(start = 16.dp, end = lastItempadding)){
        Column(modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
            .background(card.color)
            .width(240.dp)
            .height(160.dp)
            .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween) {

            val image = painterResource(id = card.icon)
            Image(modifier = Modifier.width(60.dp),painter = image, contentDescription = card.type)

            Spacer(modifier = Modifier.height(12.dp))

            Text(text = card.type
                , color = Color.White
                , fontWeight = FontWeight.Bold
                , fontSize = 18.sp)

            Text(text = "$ ${card.balance}"
                , color = Color.White
                , fontWeight = FontWeight.Bold
                , fontSize = 16.sp)

            Text(text = card.cardNumber
                , color = Color.White
                , fontWeight = FontWeight.Bold
                , fontSize = 14.sp)
        }
    }

}
