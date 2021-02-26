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
package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R

data class Puppy(
    val id: String,
    val name: String,
    val breed: String,
    val age: String,
    val sex: String,
    val description: String? = null,
    @DrawableRes
    val imageId: Int,
    @DrawableRes
    val imageThumbId: Int
)

val puppiesList = listOf(
    Puppy(
        id = "",
        name = "Rex",
        breed = "German Sheperd",
        age = "6mo",
        sex = "Male",
        description = "Good one",
        imageId = R.drawable.p1,
        imageThumbId = R.drawable.p1
    ),
    Puppy(
        id = "",
        name = "Flash",
        breed = "Labrador",
        age = "6mo",
        sex = "Male",
        description = "Cute one",
        imageId = R.drawable.p2,
        imageThumbId = R.drawable.p2
    ),
    Puppy(
        id = "",
        name = "Boba",
        breed = "Chiwi",
        age = "6mo",
        sex = "Female",
        description = "Cute one",
        imageId = R.drawable.p3,
        imageThumbId = R.drawable.p3
    ),
    Puppy(
        id = "",
        name = "Ray",
        breed = "Labrador",
        age = "6mo",
        sex = "Male",
        description = "Cute one",
        imageId = R.drawable.p4,
        imageThumbId = R.drawable.p4
    ),
    Puppy(
        id = "",
        name = "Henry",
        breed = "Labrador",
        age = "6mo",
        sex = "Male",
        description = "Cute one",
        imageId = R.drawable.p5,
        imageThumbId = R.drawable.p5
    ),
    Puppy(
        id = "",
        name = "Frankie",
        breed = "Labrador",
        age = "6mo",
        sex = "Male",
        description = "Cute one",
        imageId = R.drawable.p6,
        imageThumbId = R.drawable.p6
    ),
    Puppy(
        id = "",
        name = "Ornella",
        breed = "Stuffy",
        age = "6mo",
        sex = "Female",
        description = "Cute one",
        imageId = R.drawable.p7,
        imageThumbId = R.drawable.p7
    ),
    Puppy(
        id = "",
        name = "Flash",
        breed = "Jadgterrier",
        age = "6mo",
        sex = "Male",
        description = "Cute one",
        imageId = R.drawable.p8,
        imageThumbId = R.drawable.p8
    ),
    Puppy(
        id = "",
        name = "Superman",
        breed = "Doberman",
        age = "6mo",
        sex = "Male",
        description = "Cute one",
        imageId = R.drawable.p9,
        imageThumbId = R.drawable.p9
    ),
    Puppy(
        id = "",
        name = "Superman",
        breed = "Doberman",
        age = "6mo",
        sex = "Male",
        description = "Cute one",
        imageId = R.drawable.p10,
        imageThumbId = R.drawable.p10
    )

)
