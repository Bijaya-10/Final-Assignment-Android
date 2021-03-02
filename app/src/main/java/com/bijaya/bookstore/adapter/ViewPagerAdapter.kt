package com.bijaya.bookstore.adapter

import android.icu.text.Transliterator
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter (
    private val lstfragments: ArrayList<Fragment>,
    fragmentManager : FragmentManager,
    lifecycle: Lifecycle,
        ): FragmentStateAdapter(fragmentManager, lifecycle){

    override fun getItemCount(): Int {
        return lstFragments.size

    }

    override fun createFragment(position: Int): Fragment {
        return lstfragments[position]
    }




        }