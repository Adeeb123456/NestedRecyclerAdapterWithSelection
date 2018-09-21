package playmzubair.com.recycleradapterwithselection;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import playmzubair.com.recycleradapterwithselection.Adapters.AdapterItems;
import playmzubair.com.recycleradapterwithselection.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);



       initRecyclerView();


    }

    public void initRecyclerView(){
        DataManager dataManager=new DataManager();
        AdapterItems adapterItems=new AdapterItems(getApplicationContext(),dataManager.getItems());

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        activityMainBinding.rc1.setLayoutManager(linearLayoutManager);
        activityMainBinding.rc1.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));
        activityMainBinding.rc1.setAdapter(adapterItems);
    }
}
