package playmzubair.com.recycleradapterwithselection;

import android.media.MediaPlayer;

import java.util.ArrayList;

/**
 * Created by adeeb on 9/21/2018.
 */

public class ItemNestedModel extends itemModel {
   public String date;
   String weight;


    boolean isSelected;


   public ItemNestedModel(String date,String weight){
       this.date=date;
       this.weight=weight;
   }


    public void setImgUrl(int imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }



    public int getImgUrl() {
        return imgUrl;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public boolean isSelected() {
        return isSelected;
    }
}
