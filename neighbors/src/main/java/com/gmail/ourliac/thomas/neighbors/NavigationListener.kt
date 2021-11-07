package com.gmail.ourliac.thomas.neighbors

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

interface NavigationListener {
    fun showFragment(fragment: Fragment)
    fun updateTitle(@StringRes title: Int)
    fun getString(string: String)
}
