package com.csh.ada.pojo;

public class InitBean {

    /**
     * uid : f18eb921dd9e41299746f933dfdd1e67
     * filter_str : 你,但,。,为,被,八,靠,X,多,不,打,吗,呗,啊,吧,呃,哼,啦,嗬,呐,呢,噢,哦,呸,哇,喂,喔,呀,哑,呦,哎,嘛,麽,哟,咯,着,得,的,了,啊哟,哎哟,哎唷,哎呦,哎呀,唉呀,唉哟,哈哈,嘻嘻,haha,hehe,哼哼,么,嗯
     * outtime_str : 您好，还有什么可以帮助您吗？
     * out_time : 5
     * ustatus : 0
     * welcome : 您好，税宝很高兴为您服务，有什么可以帮您?
     */

    private String uid;
    private String filter_str;
    private String outtime_str;
    private String out_time;
    private int ustatus;
    private String welcome;
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFilter_str() {
        return filter_str;
    }

    public void setFilter_str(String filter_str) {
        this.filter_str = filter_str;
    }

    public String getOuttime_str() {
        return outtime_str;
    }

    public void setOuttime_str(String outtime_str) {
        this.outtime_str = outtime_str;
    }

    public String getOut_time() {
        return out_time;
    }

    public void setOut_time(String out_time) {
        this.out_time = out_time;
    }

    public int getUstatus() {
        return ustatus;
    }

    public void setUstatus(int ustatus) {
        this.ustatus = ustatus;
    }

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }
}
