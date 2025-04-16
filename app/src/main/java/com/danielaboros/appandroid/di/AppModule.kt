package com.danielaboros.appandroid.di

import com.danielaboros.appandroid.network.MuseumRepository
import com.danielaboros.appandroid.network.MuseumRepositoryImpl
import com.danielaboros.appandroid.screens.home.HomeViewModel
import com.danielaboros.appandroid.screens.search.SearchViewModel
import com.danielaboros.appandroid.screens.details.DetailsViewModel
import com.danielaboros.appandroid.screens.favorites.FavoriteViewModel
import com.danielaboros.appandroid.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::SearchViewModel)
    viewModelOf(::DetailsViewModel)
    viewModelOf(::FavoriteViewModel)
    singleOf(::MuseumRepositoryImpl) bind MuseumRepository::class

    single { AppDatabase.getDatabase(androidContext()) }
    single { get<AppDatabase>().favoriteDao() }
}