package com.wksoftware.moviedemo.domain

import com.google.gson.annotations.SerializedName
import java.time.Instant

data class Movie (

    @SerializedName("title"          ) var title          : String?           = null,
    @SerializedName("year"           ) var year           : Int?           = null,
    @SerializedName("rated"          ) var rated          : String?           = null,
    @SerializedName("released"       ) var released       : String?           = null,
    @SerializedName("runtimeMinutes" ) var runtimeMinutes : String?           = null,
    @SerializedName("genre"          ) var genre          : String?           = null,
    @SerializedName("director"       ) var director       : String?           = null,
    @SerializedName("writer"         ) var writer         : String?           = null,
    @SerializedName("actors"         ) var actors         : String?           = null,
    @SerializedName("plot"           ) var plot           : String?           = null,
    @SerializedName("language"       ) var language       : String?           = null,
    @SerializedName("country"        ) var country        : String?           = null,
    @SerializedName("awards"         ) var awards         : String?           = null,
    @SerializedName("poster"         ) var poster         : String?           = null,
    @SerializedName("metascore"      ) var metascore      : String?           = null,
    @SerializedName("imdbRating"     ) var imdbRating     : String?           = null,
    @SerializedName("imdbVotes"      ) var imdbVotes      : String?           = null,
    @SerializedName("imdbID"         ) var imdbID         : String?           = null,
    @SerializedName("filmType"       ) var filmType       : String?           = null,
    @SerializedName("response"       ) var response       : String?           = null,
    @SerializedName("images"         ) var images         : ArrayList<String> = arrayListOf()

)