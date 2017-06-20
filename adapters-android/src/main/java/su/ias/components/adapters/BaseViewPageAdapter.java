package su.ias.components.adapters;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * PagerAdapter which can show Views
 */

public class BaseViewPageAdapter extends PagerAdapter {

    private final List<View> views;

    public BaseViewPageAdapter(List<View> views) {
        this.views = views;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v = views.get(position);
        container.addView(v);
        return v;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public void addItem(View view) {
        views.add(view);
        notifyDataSetChanged();
    }

    public void addItem(int index, View view) {
        views.add(index, view);
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        views.remove(position);
        notifyDataSetChanged();
    }
}