package com.pocket.shoppee.adapters;

import com.pocket.shoppee.datamodel.DataManager;
import com.pocket.shoppee.fragments.FeaturedProductsFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FeaturedFragmentAdapter extends FragmentPagerAdapter {

	private int mCount = 0;

	public FeaturedFragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		return FeaturedProductsFragment.newInstance(DataManager.getSharedInstance().getFeaturedProductsArray().get(position));
	}

	@Override
	public int getCount() {
		return mCount;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return "";
	}

	public void setCount(int count) {
		mCount = count;
		notifyDataSetChanged();
	}
}
