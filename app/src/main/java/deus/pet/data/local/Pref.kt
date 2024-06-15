package deus.pet.data.local

import android.content.SharedPreferences
import javax.inject.Inject

class Pref @Inject constructor (private val pref: SharedPreferences) {

    fun onShowed(): Boolean {
        return pref.getBoolean(SHOWED_KEY, false)
    }

    fun onBoardingShow() {
        pref.edit().putBoolean(SHOWED_KEY, true).apply()
    }

    fun setName(name: String) {
        pref.edit().putString(NAME_KEY, name).apply()
    }

    fun getName(): String? {
        return pref.getString(NAME_KEY, "")
    }

    fun setPassword(password: String) {
        pref.edit().putString(PASSWORD, password).apply()
    }

    fun getPassword(): String? {
        return pref.getString(PASSWORD, "")
    }

    fun setPicture(image: String) {
        pref.edit().putString(USER_PICTURE_KEY, image).apply()
    }

    fun getPicture(): String? {
        return pref.getString(USER_PICTURE_KEY, "")
    }

    companion object {
        const val PREF_NAME = "pref.name"
        const val SHOWED_KEY = "showed.key"
        const val NAME_KEY = "name.key"
        const val PASSWORD = "password.key"
        const val USER_PICTURE_KEY = "user.picture"
    }
}