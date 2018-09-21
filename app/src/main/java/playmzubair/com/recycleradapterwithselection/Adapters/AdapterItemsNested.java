package playmzubair.com.recycleradapterwithselection.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import playmzubair.com.recycleradapterwithselection.ItemNestedModel;
import playmzubair.com.recycleradapterwithselection.R;

/**
 * Created by adeeb on 9/21/2018.
 */

public class AdapterItemsNested extends RecyclerView.Adapter {

    ArrayList<ItemNestedModel> itemNestedModels;

    public AdapterItemsNested(ArrayList<ItemNestedModel> itemNestedModels) {
      this.itemNestedModels=itemNestedModels;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.nested_item,null);
        return new NesedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return itemNestedModels==null?0:itemNestedModels.size();
    }


    public class NesedViewHolder extends RecyclerView.ViewHolder{
RecyclerView recyclerView;

        public NesedViewHolder(View itemView) {
            super(itemView);
        }
    }
}
