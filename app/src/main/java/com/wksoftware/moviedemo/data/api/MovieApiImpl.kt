package com.wksoftware.moviedemo.data.api

import android.content.Context
import android.provider.MediaStore.Video
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wksoftware.moviedemo.core.Utils
import com.wksoftware.moviedemo.domain.Movie
import com.wksoftware.moviedemo.usecases.abstractions.MovieApi


class MovieApiImpl(private val context: Context): MovieApi {
    override fun getMovies(): List<Movie> {
        val gson = Gson()
        return gson.fromJson(Utils.getJsonDataFromAsset(context = context, "films.json"),
            object : TypeToken<List<Movie?>?>() {}.type)
    }

    override fun mapperMovies() {
        TODO("Not yet implemented")
    }


}