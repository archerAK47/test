package Test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Test1 extends JFrame{
	JPanel input1,input2,input3,input4;
	JPanel output,output1;
	JButton contain,cost,price;//分别为：存储容量，人工成本，存储器价格
	int y,b,num,money;
	double M,P,CostMoney;
	public Test1() {
		
		input1 = new JPanel();
		input1.add(new JLabel("年                  份："));
		JTextField text1 = new JTextField();
		text1.setPreferredSize(new Dimension(400,50));
		input1.add(text1);
		
		input2 = new JPanel(); 
		input2.add(new JLabel("字                  长："));
		JTextField text2 = new JTextField();
		text2.setPreferredSize(new Dimension(400,50));
		input2.add(text2);
		
		input3 = new JPanel();
		input3.add(new JLabel("日开发指令条数："));
		JTextField text3 = new JTextField();
		text3.setPreferredSize(new Dimension(400,50));
		input3.add(text3);
		
		input4 = new JPanel();
		input4.add(new JLabel("工                  资："));
		JTextField text4 = new JTextField();
		text4.setPreferredSize(new Dimension(400,50));
		input4.add(text4);
		
		contain = new JButton("计算存储容量");
		price = new JButton("计算存储器价格");
		cost = new JButton("计算机装满程序所需成本");
		
		output = new JPanel(new FlowLayout(FlowLayout.CENTER));
		output.add(contain);
		output.add(price);
		output.add(cost);
		
		output1 = new JPanel();
		JTextField text5 = new JTextField();
		text5.setPreferredSize(new Dimension(600,50));
		output1.add(text5);
		
		this.setTitle("小界面");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//为按钮添加事件
		//计算计算机存储容量
		contain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text1.getText().equals("")) {
					text5.setText("请输入年份！");
				}
				else {
					try {
						y = Integer.parseInt(text1.getText());
						M=4080*Math.exp(0.28*(y-1960));
						text5.setText(""+M+"字");
					}catch(NumberFormatException e1) {
						e1.printStackTrace();
						text5.setText("输入的内容含有非数字字符！");
					}
				}
			}
		});
		//计算存储器价格
		price.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text1.getText().equals("")||text2.getText().equals("")) {
					text5.setText("请输入年份或者计算机字长！");
				}
				else {
					try {
						y = Integer.parseInt(text1.getText());
						b = Integer.parseInt(text2.getText());
						M = 4080*Math.exp(0.28*(y-1960));
						P = 0.003*b*M*Math.pow(0.72,(y-1974));
						text5.setText(""+P+"美元");
					}catch(NumberFormatException e1) {
						e1.printStackTrace();
						text5.setText("输入的内容含有非数字字符！");
					}
				}
			}
		});
		//计算人工成本
		cost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(text1.getText().equals("")||text2.getText().equals("")||text3.getText().equals("")||text4.getText().equals("")) {
					text5.setText("请输入年份、计算机字长、日开发指令条数或者员工工资！");
				}
				else {
					try {
						y = Integer.parseInt(text1.getText());
						b = Integer.parseInt(text2.getText());
						num = Integer.parseInt(text3.getText());
						money = Integer.parseInt(text4.getText());
						M = 4080*Math.exp(0.28*(y-1960));
						P = 0.003*b*M*Math.pow(0.72,(y-1974));
						CostMoney = M/(30*num)*money+P;
						text5.setText(""+CostMoney+"美元");
					}catch(NumberFormatException e1) {
						e1.printStackTrace();
						text5.setText("输入的内容含有非数字字符！");
					}
				}
			}
		});
		
		
		Box box = Box.createVerticalBox();
		box.add(input1);
		box.add(input2);
		box.add(input3);
		box.add(input4);
		box.add(output);
		box.add(output1);
		
		this.setContentPane(box);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test1();
	}
}
