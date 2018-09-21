package playmzubair.com.recycleradapterwithselection.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import playmzubair.com.recycleradapterwithselection.Adapters.viewHolder.NesedViewHolder;
import playmzubair.com.recycleradapterwithselection.ItemNestedModel;
import playmzubair.com.recycleradapterwithselection.MainActivity;
import playmzubair.com.recycleradapterwithselection.R;
import playmzubair.com.recycleradapterwithselection.RxEvents.RXEventBusUtils;
import playmzubair.com.recycleradapterwithselection.RxEvents.RcItemClickEvent;
import playmzubair.com.recycleradapterwithselection.itemModel;
import playmzubair.com.recycleradapterwithselection.view.SmoothCheckBox;

/**
 * Created by adeeb on 9/21/2018.
 */

public class AdapterItemsNested extends RecyclerView.Adapter {

    ArrayList<ItemNestedModel> itemNestedModels;
Activity context;
    public AdapterItemsNested(Activity context,ArrayList<ItemNestedModel> itemNestedModels) {
      this.itemNestedModels=itemNestedModels;
      this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.nested_item,null);
        return new NesedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {


            ((NesedViewHolder)holder).setData(itemNestedModels.get(position),position);




    }

    @Override
    public int getItemCount() {
        return itemNestedModels==null?0:itemNestedModels.size();
    }





    public void selectAllItems(){
        if(itemNestedModels!=null&&itemNestedModels.size()==0){
            return;
        }

        for(itemModel model:itemNestedModels){
            model.setSelected(true);
        }


    }

public ArrayList<ItemNestedModel> getSelectedItems(){
        ArrayList<ItemNestedModel> itemNestedModels=new ArrayList<>();
        for(ItemNestedModel itemNestedModel:getItems()){
            if(itemNestedModel.isSelected()){
                itemNestedModels.add(itemNestedModel);

            }
        }
        return itemNestedModels;
}
    public void unSelectAllItems(){
        if(itemNestedModels!=null&&itemNestedModels.size()==0){
            return;
        }

        for(ItemNestedModel model:itemNestedModels){
            model.setSelected(false);
        }
        notifyDataSetChanged();


    }



    public void setChecked(int i){
        getItems().get(i).setSelected(!getItems().get(i).isSelected());
        if(!isAnyItemSelected()){
            notifyDataSetChanged();
        }else {
            notifyItemChanged(i);
        }

    }


    boolean isAnyItemSelected() {
        for (ItemNestedModel obj : getItems()) {
            if (obj.isSelected())
                return true;
        }
        return false;
    }
    public ArrayList<ItemNestedModel> getItems(){
        return itemNestedModels;
    }
}
