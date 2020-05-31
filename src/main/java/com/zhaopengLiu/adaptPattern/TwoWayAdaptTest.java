package com.zhaopengLiu.adaptPattern;

/**
 * data: 2020年05月17日
 * author: zhaopengLiu
 * description: 双向适配器
 */
public class TwoWayAdaptTest {

    public static void main(String[] args) {
        TwoWayTarget twoWayTarget = new TargetRealize();
        TwoWayAdaptor twoWayAdaptor1 = new TwoWayAdaptor(twoWayTarget);
        twoWayAdaptor1.specialRequest();
        // =====================
        TwoWayAdapter twoWayAdapter = new TwoWayAdapterRealize();
        TwoWayAdaptor twoWayAdaptor2 = new TwoWayAdaptor(twoWayAdapter);
        twoWayAdaptor2.request();
    }
}

/**
 * 目标接口
 */
interface TwoWayTarget {
    void request();
}

/**
 * 适配者接口
 */
interface TwoWayAdapter{

    void specialRequest();

}

/**
 * 目标类实现
 */
class TargetRealize implements TwoWayTarget {

    @Override
    public void request() {
        System.out.println("目标实现类的请求方法");
    }
}

/**
 * 适配者类实现
 */
class TwoWayAdapterRealize implements TwoWayAdapter {

    @Override
    public void specialRequest() {
        System.out.println("适配者类的请求方法");
    }
}

/**
 * 双向适配器
 */
class TwoWayAdaptor {

    private TwoWayTarget twoWayTarget;
    private TwoWayAdapter twoWayAdapter;

    public TwoWayAdaptor(TwoWayTarget twoWayTarget) {
        this.twoWayTarget = twoWayTarget;
    }

    public TwoWayAdaptor(TwoWayAdapter twoWayAdapter) {
        this.twoWayAdapter = twoWayAdapter;
    }

    public void request() {
        twoWayAdapter.specialRequest();
    }

    public void specialRequest() {
        twoWayTarget.request();
    }


}