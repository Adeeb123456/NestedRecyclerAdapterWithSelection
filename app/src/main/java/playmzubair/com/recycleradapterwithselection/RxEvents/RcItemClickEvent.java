package playmzubair.com.recycleradapterwithselection.RxEvents;

/**
 * Created by adeeb on 9/22/2018.
 */

public class RcItemClickEvent {
    int position;

    public RcItemClickEvent(int position) {
        this.position=position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
