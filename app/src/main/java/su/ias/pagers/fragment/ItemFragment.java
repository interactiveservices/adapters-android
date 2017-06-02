package su.ias.pagers.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import su.ias.adapters.R;

public class ItemFragment extends Fragment {

    private static final String ARG_TITLE = "title";

    private String title;

    public static ItemFragment newInstance(String title) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            TextView txtTitle = (TextView) view.findViewById(R.id.txt_label);
            txtTitle.setText(getArguments().getString(ARG_TITLE));
        }
    }
}
