package com.zhaopengLiu.prototypePattern;

/**
 * data: 2020年05月07日
 * author: zhaopengLiu
 * description: 可以进行克隆的对象
 */
public class CloneBean implements Cloneable{

    public String name = "可克隆对象";

    public CloneBean() {
        System.out.println("对象创建成功");
    }


    public CloneBean clone(){
        try {
            return (CloneBean) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 重写equals方法判断两个对象是否相等
     * @param object 判断的对象
     * @return 是否相等
     */
    @Override
    public boolean equals(Object object) {
        if(this == object) {
            return true;
        }
        if(object instanceof CloneBean) {
            return name.equals(((CloneBean)object).name);
        }
        return false;
    }
}
