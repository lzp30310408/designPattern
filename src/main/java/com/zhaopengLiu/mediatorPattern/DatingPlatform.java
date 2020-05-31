package com.zhaopengLiu.mediatorPattern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * data: 2020年05月26日
 * author: zhaopengLiu
 * description: 房产中介平台（好玩）Swing
 */
public class DatingPlatform {

    public static void main(String[] args) {
        Medium md=new EstateMedium();    //房产中介
        Custom member1,member2;
        member1=new Seller("张三(卖方)");
        member2=new Buyer("李四(买方)");
        md.register(member1); //客户注册
        md.register(member2);
    }
}

/**
 * 中介公司
 */
abstract class Medium {

    public List<Custom> customs = new ArrayList<>();

    public abstract void register(Custom custom);

    public abstract void relay(String from, String ad);

}

/**
 * 房地产中介
 */
class EstateMedium extends Medium {

    @Override
    public void register(Custom custom) {
        if (!customs.contains(custom)) {
            customs.add(custom);
            custom.setMedium(this);
        }
    }

    @Override
    public void relay(String from, String ad) {
        for (Custom custom : customs) {
            String name = custom.getName();
            if (name == null || !name.equals(from)) {
                custom.receive(from, ad);
            }
        }
    }


}

/**
 * 抽象客户
 */
abstract class Custom extends JFrame implements ActionListener {

    private static final long serialVersionUID = -7219939540794786080L;

    public Medium medium;
    public String name;
    JTextField SentText;
    JTextArea ReceiveArea;

    public Custom(String name) {
        super(name);
        this.name = name;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void ClientWindow(int x, int y) {
        Container cp;
        JScrollPane sp;
        JPanel p1, p2;
        cp = this.getContentPane();
        SentText = new JTextField(18);
        ReceiveArea = new JTextArea(10, 18);
        ReceiveArea.setEditable(false);
        p1 = new JPanel();
        p1.setBorder(BorderFactory.createTitledBorder("接收内容："));
        p1.add(ReceiveArea);
        sp = new JScrollPane(p1);
        cp.add(sp, BorderLayout.NORTH);
        p2 = new JPanel();
        p2.setBorder(BorderFactory.createTitledBorder("发送内容："));
        p2.add(SentText);
        cp.add(p2, BorderLayout.SOUTH);
        SentText.addActionListener(this);
        this.setLocation(x, y);
        this.setSize(250, 330);
        this.setResizable(false); //窗口大小不可调整
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String tempInfo = SentText.getText().trim();
        SentText.setText("");
        this.send(tempInfo);
    }

    public abstract void send(String tempInfo);

    public abstract void receive(String from, String ad);
}

class Seller extends Custom {

    private static final long serialVersionUID = -1443076716629516027L;

    public Seller(String name) {
        super(name);
        ClientWindow(50, 100);
    }

    @Override
    public void send(String tempInfo) {
        ReceiveArea.append("我(卖方)说: " + tempInfo + "\n");
        //使滚动条滚动到最底端
        ReceiveArea.setCaretPosition(ReceiveArea.getText().length());
        medium.relay(name, tempInfo);
    }

    @Override
    public void receive(String from, String ad) {
        ReceiveArea.append(from + "说: " + ad + "\n");
        //使滚动条滚动到最底端
        ReceiveArea.setCaretPosition(ReceiveArea.getText().length());
    }
}

/**
 * 买方
 */
class Buyer extends Custom {
    private static final long serialVersionUID = -474879276076308825L;

    public Buyer(String name) {
        super(name);
        ClientWindow(350, 100);
    }

    public void send(String ad) {
        ReceiveArea.append("我(买方)说: " + ad + "\n");
        //使滚动条滚动到最底端
        ReceiveArea.setCaretPosition(ReceiveArea.getText().length());
        medium.relay(name, ad);
    }

    public void receive(String from, String ad) {
        ReceiveArea.append(from + "说: " + ad + "\n");
        //使滚动条滚动到最底端
        ReceiveArea.setCaretPosition(ReceiveArea.getText().length());
    }
}