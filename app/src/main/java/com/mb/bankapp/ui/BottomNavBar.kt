package com.mb.bankapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mb.bankapp.data.BottomNavItems

val items = listOf<BottomNavItems>(
    BottomNavItems(
        "Home",
        Icons.Rounded.Home
    ),
    BottomNavItems(
        "Wallet",
        Icons.Rounded.Wallet
    ),
    BottomNavItems(
        "Notifications",
        Icons.Rounded.Notifications
    ),
    BottomNavItems(
        "Account",
        Icons.Rounded.AccountCircle
    )
)

@Composable
fun bottomNavBar(){

    NavigationBar {
        Row(modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface
            )) {
            items.forEachIndexed { index, bottomNavItem ->

                NavigationBarItem(selected = index == 0,
                    onClick = {  },
                    icon = {
                        Icon(
                            imageVector = bottomNavItem.icon,
                            contentDescription = bottomNavItem.title,
                            tint = MaterialTheme.colorScheme.onBackground

                        )
                    },
                    label = {
                        Text(text = bottomNavItem.title,color = MaterialTheme.colorScheme.onBackground)
                    }
                )
            }

        }
    }
}