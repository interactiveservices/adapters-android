package su.ias.pagers.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import su.ias.adapters.R;
import su.ias.components.adapters.BaseFragmentPagerAdapter;
import su.ias.components.views.LockedViewPager;

public class FragmentPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_pager);

        LockedViewPager viewPager = (LockedViewPager) findViewById(R.id.viewpager_fragment);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(ItemFragment.newInstance("test fragment #1, swipe to show next fragment"));
        fragmentList.add(ItemFragment.newInstance("test fragment #2"));
        fragmentList.add(ItemFragment.newInstance(
                "test fragment #3, swipe to show previous fragment"));
        viewPager.setAdapter(new BaseFragmentPagerAdapter(getSupportFragmentManager(),
                                                          fragmentList));
    }
}
