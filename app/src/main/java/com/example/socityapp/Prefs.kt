package com.example.socityapp

import android.content.Context
import android.content.SharedPreferences
import com.example.societymanagementsystem.admin.DataModel
import com.example.societymanagementsystem.admin.DoctorModel
import com.example.societymanagementsystem.admin.GloceryModel
import com.example.societymanagementsystem.admin.PlumberModel
import com.example.socityapp.user.model.registermodel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Prefs (context: Context) {
    val PREFS_FILENAME = context.packageName + ".prefs"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0);
    private val gson = Gson()

    fun clear() {
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }

    fun remove(key:String) {
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }

    fun setStringValue(key: String, value: String?) {
        val editor = prefs.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getStringValue(key: String): String? {
        return prefs.getString(key, "")
    }

    fun setIntValue(key: String, value: Int) {
        val editor = prefs.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun getIntValue(key: String): Int {
        return prefs.getInt(key, 0)
    }

    fun setBooleanValue(key: String, value: Boolean) {
        val editor = prefs.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBooleanValue(key: String): Boolean {
        return prefs.getBoolean(key, false)
    }

    fun saveregister(user: List<registermodel>) {
        val editor = prefs.edit()
        val gson = Gson()
        val json = gson.toJson(user)
        editor.putString("register", json)
        editor.apply()
    }

    fun getregister(): List<registermodel> {
        val gson = Gson()
        val json = prefs.getString("register", "")
        if (json.isNullOrEmpty())
            return emptyList()
        else
            return gson.fromJson(json, object : TypeToken<List<registermodel>>() {}.type)
    }


    fun savegardener(user: List<DataModel>) {
        val editor = prefs.edit()
        val gson = Gson()
        val json = gson.toJson(user)
        editor.putString("gardener", json)
        editor.apply()
    }

    fun getgardener(): List<DataModel> {
        val gson = Gson()
        val json = prefs.getString("gardener", "")
        if (json.isNullOrEmpty())
            return emptyList()
        else
            return gson.fromJson(json, object : TypeToken<List<DataModel>>() {}.type)
    }



    fun saveplumber(user: List<PlumberModel>) {

        val editor = prefs.edit()
        val gson = Gson()
        val json = gson.toJson(user)
        editor.putString("plumber", json)
        editor.apply()
    }

    fun getplumber(): List<PlumberModel> {
        val gson = Gson()
        val json = prefs.getString("plumber", "")
        if (json.isNullOrEmpty())
            return emptyList()
        else
            return gson.fromJson(json, object : TypeToken<List<PlumberModel>>() {}.type)
    }




    fun savegrocery(user: List<GloceryModel>) {
        val editor = prefs.edit()
        val gson = Gson()
        val json = gson.toJson(user)
        editor.putString("glory", json)
        editor.apply()
    }

    fun getglocery(): List<GloceryModel> {
        val gson = Gson()
        val json = prefs.getString("glory", "")
        if (json.isNullOrEmpty())
            return emptyList()
        else
            return gson.fromJson(json, object : TypeToken<List<GloceryModel>>() {}.type)
    }



    fun savedoctor(user: List<DoctorModel>) {
        val editor = prefs.edit()
        val gson = Gson()
        val json = gson.toJson(user)
        editor.putString("doctor", json)
        editor.apply()
    }

    fun getdoctor(): List<DoctorModel>? {
        val gson = Gson()
        val json = prefs.getString("doctor", "")
        if (json.isNullOrEmpty())
            return emptyList()
        else
            return gson.fromJson(json, object : TypeToken<List<DoctorModel>>() {}.type)
    }




}