package com.bedrock.congrats.view.row

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bedrock.congrats.R
import com.bedrock.congrats.ui.theme.ComponentsPOCTheme
import com.bedrock.congrats.ui.theme.Green

@ExperimentalMaterial3Api
@Composable
fun HeaderRow(
    backgroundColor: Color,
    title: String,
    label: String,
    @DrawableRes icon: Int,
    @DrawableRes badge: Int,
    onCloseClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .background(color = backgroundColor)
            .padding(all = 32.dp)
            .height(100.dp)
            .fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        ) {
            IconButton(
                onClick = onCloseClick,
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.congrats_ic_header_close),
                    contentDescription = null, // decorative element
                    tint = Color.White
                )
            }
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,) {
            Column {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
            }

            Column(modifier = Modifier.wrapContentWidth(), horizontalAlignment = Alignment.End) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null, // decorative element
                    tint = Color.White
                )
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
fun HeaderRowPreview() {
    // TODO: Provide this theme through another common module
    ComponentsPOCTheme {
        HeaderRow(
            backgroundColor = Green,
            title = "Congrats pantalla verde, Congrats pantalla verde, Congrats pantalla verde, " ,
            label = "",
            icon = R.drawable.congrats_ic_product,
            badge = R.drawable.congrats_ic_badge_check
        )
    }
}
