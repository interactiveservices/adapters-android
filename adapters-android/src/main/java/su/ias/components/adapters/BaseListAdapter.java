package su.ias.components.adapters;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Base adapter for recyclerViews which contains a list of DataType
 *
 * @param <DataType> type of class in List
 * @param <VH>       ViewHolder's type
 */
public abstract class BaseListAdapter<DataType, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected final OnItemClickListener listener;
    private final List<DataType> list;

    public BaseListAdapter() {
        this.list = new ArrayList<>();
        this.listener = null;
    }

    public BaseListAdapter(@Nullable List<DataType> list) {
        this.list = (list == null ? new ArrayList<DataType>() : list);
        this.listener = null;
    }

    public BaseListAdapter(@Nullable List<DataType> list, @Nullable OnItemClickListener listener) {
        this.list = (list == null ? new ArrayList<DataType>() : list);
        this.listener = listener;
    }

    public void add(DataType dataType) {
        list.add(dataType);
        notifyItemInserted(list.size());
    }

    public void remove(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    public void remove(DataType item) {
        remove(list.indexOf(item));
    }

    public void addAll(List<DataType> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public DataType getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected LayoutInflater getLayoutInflater(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext());
    }

    /**
     * @return all items from adapter
     */
    public List<DataType> getItems() {
        return list;
    }

    /**
     * remove all data from adapter
     */
    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }
}
