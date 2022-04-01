package com.example.moneymanager.model

import androidx.annotation.DrawableRes

data class Activity(@DrawableRes val icon: Int, val name: String, val date: String, val balance: String)
