package playmzubair.com.recycleradapterwithselection;

import android.media.MediaPlayer;

import java.util.ArrayList;

/**
 * Created by adeeb on 9/21/2018.
 */

public class itemModel {
  public   String date;
    public int imgUrl;
    public  MediaPlayer mediaPlayer;

    boolean isSelected;
public ArrayList<ItemNestedModel> itemNestedModels;

    public itemModel(String date,int imgUrl,ArrayList<ItemNestedModel> itemNestedModels) {
        this.date=date;
        this.imgUrl=imgUrl;
        this.itemNestedModels=itemNestedModels;
    }

    public void initMediaPlayer(){
       mediaPlayer=new MediaPlayer();
       mediaPlayer.prepareAsync();
    }

    public itemModel() {
        super();
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
