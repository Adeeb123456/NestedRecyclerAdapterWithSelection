package playmzubair.com.recycleradapterwithselection.RxEvents;

import io.reactivex.subjects.PublishSubject;

public class RXEventBusUtils {

    private static RXEventBusUtils sRXEventBusUtils;
    private PublishSubject<Object> mPublishSubject;

    public static RXEventBusUtils getInstance() {
        if (sRXEventBusUtils == null) {
            sRXEventBusUtils = new RXEventBusUtils();
        }
        return sRXEventBusUtils;
    }

    public PublishSubject getSubject() {
        if (null == mPublishSubject) {
            mPublishSubject = PublishSubject.create();
        }
        return mPublishSubject;
    }

    public void postEvent(Object event) {
        getSubject().onNext(event);
    }
}
