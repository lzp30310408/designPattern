package com.zhaopengLiu.prototypePattern;

/**
 * data: 2020年05月07日
 * author: zhaopengLiu
 * description:
 */
public class CloneUtil {

    public static void main(String[] args) {
        CloneBean cloneBean = new CloneBean();
        CloneBean clonedBean = cloneBean.clone();
        System.out.println("cloneBean == clonedBean ? " + (cloneBean == clonedBean));
        System.out.println("cloneBean.getClass() == clonedBean.getClass() ? " + (cloneBean.getClass() == clonedBean.getClass()));
        System.out.println("cloneBean.equals(clonedBean) ? " + cloneBean.equals(clonedBean));
    }
}
