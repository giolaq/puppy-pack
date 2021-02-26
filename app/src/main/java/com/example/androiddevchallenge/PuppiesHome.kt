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

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.puppiesList
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PuppiesHome(
    puppies: List<Puppy>,
    navigateToPuppyDetails: (Puppy) -> Unit,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            PuppiesAppBar()
        },
        content = {
            PuppiesList(puppies, navigateToPuppyDetails)
        }
    )
}

@Composable
private fun PuppiesAppBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name)) },
        elevation = 0.dp
    )
}

@Preview
@Composable
private fun PuppiesHomePreview() {
    MyTheme() {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "home") {
            composable("home") {
                PuppiesHome(
                    puppies = puppiesList,
                    navigateToPuppyDetails = { puppy ->
                        navController.navigate("puppy/${puppy.name}")
                    }
                )
            }
            composable("puppy/{name}") { backStackEntry ->
                val puppyName = backStackEntry.arguments?.getString("name")
                val puppy = puppiesList.find { it.name == puppyName }
                    ?: throw IllegalStateException("puppy $puppyName not found")
                PuppyDetails(
                    puppy = puppy,
                    navigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}
