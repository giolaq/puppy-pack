/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.material.icons.filled.Pets
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.puppiesList
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PuppiesList(
    puppies: List<Puppy>,
    navigateToPuppyDetails: (Puppy) -> Unit
) {
    LazyColumn {
        items(puppies) { puppy ->
            PuppyRow(
                puppy = puppy,
                modifier = Modifier
                    .clickable { navigateToPuppyDetails(puppy) }
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun PuppyRow(
    puppy: Puppy,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier.padding(16.dp),
        elevation = 12.dp,
        content = {
            Row(
                modifier = modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(puppy.imageThumbId),
                    contentDescription = "Picture of ${puppy.name}",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(120.dp)
                )

                Spacer(Modifier.width(16.dp))

                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = puppy.name,
                        style = MaterialTheme.typography.subtitle1
                    )

                    Spacer(Modifier.height(12.dp))

                    when (val sex = puppy.sex) {
                        "Male" -> IconText(
                            icon = Icons.Filled.Male,
                            text = sex
                        )
                        "Female" -> IconText(
                            icon = Icons.Filled.Female,
                            text = sex
                        )
                    }

                    Spacer(Modifier.height(12.dp))

                    IconText(
                        icon = Icons.Filled.Pets,
                        text = puppy.breed
                    )

                    Spacer(Modifier.height(12.dp))

                    IconText(
                        icon = Icons.Filled.CalendarToday,
                        text = puppy.age
                    )
                }
            }
        }
    )
}

@Composable
private fun IconText(
    icon: ImageVector,
    text: String,
    color: Color = Color.Unspecified
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = color.takeOrElse { LocalContentColor.current.copy(alpha = LocalContentAlpha.current) },
            modifier = Modifier.size(18.dp)
        )
        Spacer(Modifier.width(4.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.caption,
            color = color
        )
    }
}

@Preview
@Composable
private fun PuppyRowPreview() {
    MyTheme() {
        Surface(
            color = MaterialTheme.colors.surface
        ) {
            PuppyRow(puppy = puppiesList.first())
        }
    }
}
