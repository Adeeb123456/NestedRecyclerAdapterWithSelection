package playmzubair.com.recycleradapterwithselection.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import playmzubair.com.recycleradapterwithselection.DataManager;
import playmzubair.com.recycleradapterwithselection.R;
import playmzubair.com.recycleradapterwithselection.itemModel;

/**
 * Created by adeeb on 9/21/2018.
 */

public class AdapterItems extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<itemModel> itemModels;
    AdapterItemsNested adapterItemsNested;
    LinearLayoutManager linearLayoutManager;
    Context context;
    public AdapterItems(Context context, ArrayList<itemModel> itemModels) {
        super();
        this.itemModels=itemModels;
        adapterItemsNested=new AdapterItemsNested(new DataManager().getSubItems());
        this.context=context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,null);
        return new SuperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((SuperViewHolder)holder).textView.setText(itemModels.get(position).date);
        linearLayoutManager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        ((SuperViewHolder)holder).recyclerView.setLayoutManager(linearLayoutManager);
        ((SuperViewHolder)holder).recyclerView.setHasFixedSize(true);
        ((SuperViewHolder)holder).recyclerView.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));
        ((SuperViewHolder)holder).recyclerView.setAdapter(adapterItemsNested);
    }

    @Override
    public int getItemCount() {
        return itemModels==null?0:itemModels.size();
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class SuperViewHolder extends RecyclerView.ViewHolder{
RecyclerView recyclerView;
public TextView textView;

        public SuperViewHolder(View itemView) {
            super(itemView);

            recyclerView=itemView.findViewById(R.id.rcs);
            textView=itemView.findViewById(R.id.date1);
        }
    }



    public void selectAllItems(){
        if(itemModels!=null&&itemModels.size()==0){
            return;
        }

        for(itemModel model:itemModels){
            model.setSelected(true);
        }


    }


    public void unSelectAllItems(){
        if(itemModels!=null&&itemModels.size()==0){
            return;
        }

        for(itemModel model:itemModels){
            model.setSelected(false);
        }


    }



    public void setChecked(int i){
       getItems().get(i).setSelected(!getItems().get(i).isSelected());
    }

    public ArrayList<itemModel> getItems(){
        return itemModels;
    }
}
