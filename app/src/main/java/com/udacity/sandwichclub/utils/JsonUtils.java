package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = null;
        try {
            JSONObject sandwichData = new JSONObject(json);
            JSONObject sandwichJSONObject = sandwichData.getJSONObject("name");
            String mainName = sandwichJSONObject.getString("mainName");
            JSONArray otherNamesJSONArray = sandwichJSONObject.getJSONArray("alsoKnownAs");
            String origin = sandwichData.getString("placeOfOrigin");
            String description = sandwichData.getString("description");
            String imageURLString = sandwichData.getString("image");
            JSONArray ingredientsJSONArray = sandwichData.getJSONArray("ingredients");

            ArrayList<String> otherNames = new ArrayList<String>();
            for (int i = 0; i < otherNamesJSONArray.length(); i++) {
                otherNames.add(otherNamesJSONArray.getString(i));
            }

            ArrayList<String> ingredients = new ArrayList<String>();
            for (int i = 0; i < ingredientsJSONArray.length(); i++) {
                ingredients.add(ingredientsJSONArray.getString(i));
            }

            sandwich = new Sandwich(mainName, otherNames, origin, description,
                    imageURLString, ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }
}
