package com.lhy;

import org.apache.zookeeper.*;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;

import java.util.concurrent.CountDownLatch;

/**
 * Zookeeper base学习笔记
 * @since 2015-6-13
 */
public class ZookeeperBase {

    /** zookeeper地址 ，连接集群中的一个或多个都行，多个用,隔开*/
    static final String CONNECT_ADDR = "192.168.85.3:2181";

    /** session超时时间 */
    static final int SESSION_OUTTIME = 2000;//ms

    /**
     *
     * 信号量，阻塞程序执行，用于等待zookeeper连接成功，发送成功信号
     *
     **/
    static final CountDownLatch connectedSemaphore = new CountDownLatch(1);


    public static void main(String[] args) throws Exception{

        //构造器参数：1：zookeeper连接地址，2：超时时间，3：Watcher：观察者，
        ZooKeeper zk = new ZooKeeper(CONNECT_ADDR, SESSION_OUTTIME, new Watcher(){
            @Override
            public void process(WatchedEvent event) {
                //获取事件的状态
                KeeperState keeperState = event.getState();
                EventType eventType = event.getType();
                //SyncConnected表示 连接成功状态
                if(KeeperState.SyncConnected == keeperState){
                    //刚连接成功什么事件也没有,所以是none
                    if(EventType.None == eventType){
                        //如果建立连接成功，则发送信号量，让后续阻塞程序向下执行
                        connectedSemaphore.countDown();
                        System.out.println("zk 建立连接");
                    }
                }
            }
        });

        //主线程 进行阻塞，等待Zookeeper对象 初始化
        connectedSemaphore.await();

        System.out.println("连接zookeeper成功");
        //创建父节点
           // zk.create("/lhy", "niubei".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        //创建子节点
        zk.create("/lhy/children", "children data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        //获取节点洗信息
        byte[] data = zk.getData("/lhy", false, null);
        System.out.println(new String(data));
        System.out.println(zk.getChildren("/lhy", false));

        //修改节点的值
//        zk.setData("/testRoot", "modify data root".getBytes(), -1);
//        byte[] data = zk.getData("/testRoot", false, null);
//        System.out.println(new String(data));

        //判断节点是否存在
//        System.out.println(zk.exists("/testRoot/children", false));
        //删除节点
//        zk.delete("/testRoot/children", -1);
//        System.out.println(zk.exists("/testRoot/children", false));

        zk.close();


    }

}