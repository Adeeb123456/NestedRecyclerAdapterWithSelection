package playmzubair.com.recycleradapterwithselection;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import playmzubair.com.recycleradapterwithselection.Adapters.AdapterItems;
import playmzubair.com.recycleradapterwithselection.RxEvents.RXEventBusUtils;
import playmzubair.com.recycleradapterwithselection.RxEvents.RcItemClickEvent;
import playmzubair.com.recycleradapterwithselection.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

ActivityMainBinding activityMainBinding;

    Disposable disposable;

public  Activity getMainActivityIns(){
    return MainActivity.this;
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);



       initRecyclerView();
activityMainBinding.clearall.setOnClickListener((View v)->{
adapterItems.unSelectAllItems();
});

        disposable = RXEventBusUtils.getInstance().getSubject().subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onReceiveEvent);


    }



    private void onReceiveEvent(Object event) {
        if (event instanceof RcItemClickEvent){

            adapterItems.setChecked(((RcItemClickEvent) event).getPosition());
            int count= adapterItems.getSelectedItems().size();

            setItemCount(count);





        }
    }

    AdapterItems adapterItems;
    public void initRecyclerView(){
        DataManager dataManager=new DataManager();
         adapterItems=new AdapterItems(MainActivity.this,dataManager.getItems());

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        activityMainBinding.rc1.setLayoutManager(linearLayoutManager);
        activityMainBinding.rc1.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));
        activityMainBinding.rc1.setAdapter(adapterItems);
    }


    public void setItemCount(int count){
       activityMainBinding.Count.setText(count+"");
    }

    public void clear(){
        activityMainBinding.Count.setText("");
    }




}
