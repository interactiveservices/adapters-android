package su.ias.components.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Base adapter for showing fragments
 */

public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private List<CharSequence> titles;

    public BaseFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public BaseFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        fragmentList = new ArrayList<>(fragments);
    }

    public void addItem(Fragment fragment) {
        if (fragmentList == null) {
            fragmentList = new ArrayList<>();
        }

        fragmentList.add(fragment);
    }

    public void addItem(Fragment fragment, CharSequence fragmentTitle) {
        if (fragmentList == null) {
            fragmentList = new ArrayList<>();
        }
        fragmentList.add(fragment);

        if (titles == null) {
            titles = new ArrayList<>();
        }
        titles.add(fragmentTitle);

    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (titles != null && titles.size() >= position) {
            return titles.get(position);
        }

        return super.getPageTitle(position);
    }
}
