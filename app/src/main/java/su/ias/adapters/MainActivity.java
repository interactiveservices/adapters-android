package su.ias.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import su.ias.components.adapters.OnItemClickListener;
import su.ias.pagers.fragment.FragmentPagerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rcViewList = (RecyclerView) findViewById(R.id.rc_item);
        rcViewList.setAdapter(new ItemAdapter(generateFakeItems(), new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                startActivity(new Intent(MainActivity.this, FragmentPagerActivity.class));
            }
        }));
        rcViewList.setLayoutManager(new LinearLayoutManager(this));
        rcViewList.addItemDecoration(new DividerItemDecoration(this,
                                                               DividerItemDecoration.VERTICAL));
    }

    private List<Item> generateFakeItems() {
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Item("item #" + (int) (Math.random() * 1000)));
        }
        return list;
    }
}
