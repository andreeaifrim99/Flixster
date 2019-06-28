package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Config {
    String imageBaseUrl;
    //poster size
    String posterSize;
    String backdropSize;

    public Config(JSONObject object) throws JSONException {
        JSONObject images = object.getJSONObject("images");
        //get image base URL
        imageBaseUrl = images.getString("secure_base_url");
        //get postersize
        JSONArray posterSizeOptions = images.getJSONArray("poster_sizes");
        //get index at value 3
        posterSize = posterSizeOptions.optString(3, "w342");

        JSONArray backdropSizeOptions = images.getJSONArray("backdrop_sizes");
        backdropSize = backdropSizeOptions.optString(1, "w780");
    }

    //helper method
    public String getImageURL (String size, String path) {
        return String.format("%s%s%s", imageBaseUrl, size, path);
    }
    public String getImageBaseUrl() {
        return imageBaseUrl;
    }

    public String getPosterSize() {
        return posterSize;
    }

    public String getBackdropSize() {
        return backdropSize;
    }

}
