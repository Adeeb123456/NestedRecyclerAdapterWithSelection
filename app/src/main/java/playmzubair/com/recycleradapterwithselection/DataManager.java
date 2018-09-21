package playmzubair.com.recycleradapterwithselection;

import java.util.ArrayList;

/**
 * Created by adeeb on 9/21/2018.
 */

public class DataManager {

    public ArrayList<itemModel> getItems(){
        ArrayList<itemModel> itemModels=new ArrayList<>();
        ArrayList<ItemNestedModel> itemNestedModels=new ArrayList<>();

        for(int i=0;i<10;i++){
            ItemNestedModel itemNestedModel;
            itemNestedModel=new ItemNestedModel("10/11/201 "+i,"67h");
            itemNestedModels.add(itemNestedModel);
        }

        for(int i=0;i<5;i++){
            itemModel model;
            model=new itemModel("nestedDate455",98,itemNestedModels);
            itemModels.add(model);
        }

        return itemModels;
    }

    public ArrayList<ItemNestedModel> getSubItems(){
        ArrayList<itemModel> itemModels=new ArrayList<>();
        ArrayList<ItemNestedModel> itemNestedModels=new ArrayList<>();

        for(int i=0;i<10;i++){
            ItemNestedModel itemNestedModel;
            itemNestedModel=new ItemNestedModel("10/11/201 "+i,"67h");
            itemNestedModels.add(itemNestedModel);
        }


        return itemNestedModels;
    }

}
