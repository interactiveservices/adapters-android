package su.ias.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import su.ias.components.adapters.BaseListAdapter;
import su.ias.components.adapters.OnItemClickListener;

public class ItemAdapter extends BaseListAdapter<Item, ItemAdapter.ViewHolder> {

    public ItemAdapter(List<Item> list, OnItemClickListener listener) {
        super(list, listener);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = getLayoutInflater(parent).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Item item = getItem(position);

        viewHolder.txtItemName.setText(item.getName());
        viewHolder.txtItemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(holder.getAdapterPosition());
                }
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_item_name)
        TextView txtItemName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}