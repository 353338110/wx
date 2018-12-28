package com.csh.ada.pojo;

import java.util.List;

public class AiTalkBean {



    private String info;
    /**
     * answer : 您好，办理企业所得税税种增加，可直接在税宝上取号在窗口办理。
     所需材料如下：
     一、营业执照原件；
     二、变更税务登记表（该项属于免填单）；
     * attr : [{"plusurl":"/Urlcode/ea8fc0abdb16473c8b28819ca82a8094","plustitle":"验旧","plustype":"imgmsg"}]
     * ustatus : 0
     * answer_link : ["<button id='id1544687253941-0' class='audiobutton' onclick='audiosend(\"增加企业所得税税种\")'> 增加企业所得税税种 <\/button>","<button id='id1544687253941-1' class='audiobutton' onclick='audiosend(\"修改企业所得税\")'> 修改企业所得税 <\/button>","<button id='id1544687253941-2' class='audiobutton' onclick='audiosend(\"申报企业所得税\")'> 申报企业所得税 <\/button>"]
     */

    private String answer;
    private String ustatus;
    private List<AttrBean> attr;
    private List<String> answer_link;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUstatus() {
        return ustatus;
    }

    public void setUstatus(String ustatus) {
        this.ustatus = ustatus;
    }

    public List<AttrBean> getAttr() {
        return attr;
    }

    public void setAttr(List<AttrBean> attr) {
        this.attr = attr;
    }

    public List<String> getAnswer_link() {
        return answer_link;
    }

    public void setAnswer_link(List<String> answer_link) {
        this.answer_link = answer_link;
    }


    public static class AttrBean {
        /**
         * plusurl : /Urlcode/ea8fc0abdb16473c8b28819ca82a8094
         * plustitle : 验旧
         * plustype : imgmsg
         */

        private String plusurl;
        private String plustitle;
        private String plustype;

        public String getPlusurl() {
            return plusurl;
        }

        public void setPlusurl(String plusurl) {
            this.plusurl = plusurl;
        }

        public String getPlustitle() {
            return plustitle;
        }

        public void setPlustitle(String plustitle) {
            this.plustitle = plustitle;
        }

        public String getPlustype() {
            return plustype;
        }

        public void setPlustype(String plustype) {
            this.plustype = plustype;
        }
    }
}
