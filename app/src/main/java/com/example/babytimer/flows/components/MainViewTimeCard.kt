package com.example.babytimer.flows.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.babytimer.ui.theme.BabyTimeTheme
import com.example.babytimer.ui.theme.BabyTimerResources
import com.example.babytimer.ui.theme.Gap

@Composable
fun MainViewTimeCard(timeStart: String, timeEnd: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(BabyTimerResources.background.cardColor)
            .padding(20.dp)

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Время начала",
                    color = BabyTimerResources.foreGround.base,
                    style = BabyTimerResources.typography.body.largeBold
                )
                Gap(size = 10)
                Text(
                    text = timeStart,
                    color = BabyTimerResources.foreGround.base,
                    style = BabyTimerResources.typography.header.mediumBold
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Время завершения",
                    color = BabyTimerResources.foreGround.base,
                    style = BabyTimerResources.typography.body.largeBold
                )
                Gap(size = 10)
                Text(
                    text = timeEnd,
                    color = BabyTimerResources.foreGround.base,
                    style = BabyTimerResources.typography.header.mediumBold
                )
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun MainViewTimeCardPreview() {
    BabyTimeTheme {
        MainViewTimeCard("15.00", "15.15")
    }
}