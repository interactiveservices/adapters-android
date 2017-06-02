package su.ias.components.adapters;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Base adapter for recyclerViews which contains a list of DateType
 *
 * @param <DateType> type of class in List
 * @param <VH>       ViewHolder's type
 */
public abstract class BaseListAdapter<DateType, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected final OnItemClickListener listener;
    private final List<DateType> list;

    public BaseListAdapter() {
        this.list = new ArrayList<>();
        this.listener = null;
    }

    public BaseListAdapter(@Nullable List<DateType> list) {
        this.list = (list == null ? new ArrayList<DateType>() : list);
        this.listener = null;
    }

    public BaseListAdapter(@Nullable List<DateType> list, @Nullable OnItemClickListener listener) {
        this.list = (list == null ? new ArrayList<DateType>() : list);
        this.listener = listener;
    }

    public void add(DateType dateType) {
        list.add(dateType);
        notifyItemInserted(list.size());
    }

    public void remove(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    public void remove(DateType item) {
        remove(list.indexOf(item));
    }

    public void addAll(List<DateType> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public DateType getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected LayoutInflater getLayoutInflater(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext());
    }

    public List<DateType> getItems() {
        return list;
    }
}
