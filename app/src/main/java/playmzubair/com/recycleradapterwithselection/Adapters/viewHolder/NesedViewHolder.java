package playmzubair.com.recycleradapterwithselection.Adapters.viewHolder;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import playmzubair.com.recycleradapterwithselection.ItemNestedModel;
import playmzubair.com.recycleradapterwithselection.MainActivity;
import playmzubair.com.recycleradapterwithselection.R;
import playmzubair.com.recycleradapterwithselection.RxEvents.RXEventBusUtils;
import playmzubair.com.recycleradapterwithselection.RxEvents.RcItemClickEvent;
import playmzubair.com.recycleradapterwithselection.view.SmoothCheckBox;

/**
 * Created by adeeb on 9/21/2018.
 */

public class NesedViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.checkBox)SmoothCheckBox checkBox;
    @BindView(R.id.date) TextView textViewDate;
    @BindView(R.id.itemNested)
    RelativeLayout item;

    @OnClick(R.id.itemNested)
    public void onItemClick(View view){
        RXEventBusUtils.getInstance().postEvent(new RcItemClickEvent(position));
    }

    int position;
    public NesedViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        itemView.setOnClickListener((View v)->{
            RXEventBusUtils.getInstance().postEvent(new RcItemClickEvent(position));
        });
    }


    public void setData(ItemNestedModel itemNestedModel,int position){
        this.position=position;
        checkBox.setChecked(itemNestedModel.isSelected());
        checkBox.setClickable(false);
        textViewDate.setText(itemNestedModel.date);
    }
}
