package com.example.moneymanager.model

import androidx.annotation.DrawableRes

data class Transaction(val name: String, @DrawableRes val logo: Int, val date: String, val budget: String)
