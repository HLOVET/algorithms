package Chapter1_3;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by xie on 2017/4/4.
 * 实现简易四则运算(由括号实现运算优先级)
 */
public class ArithmeticByStack {
    public static void main(String[] args){
        System.out.println("请输入一串表示运算的字符串");
        Scanner sc = new Scanner(System.in);
        String mess = sc.next();

        //两个stack分别存放运算符和要操作的数
        //忽略左括号，遇到右括号则弹出弹出运算符栈顶以及数栈的栈顶
        char[] chars = mess.toCharArray();
        Stack<String> ops = new Stack<String>();     //存放操作符
        Stack<Double> vals = new Stack<Double>();    //存放数值
        String s = "";
        for (int i = 0; i < chars.length; i++) {
            s += chars[i];
            if (s.equals("(") );
            else if(s.equals("+")) ops.push(s);
            else if(s.equals("-")) ops.push(s);
            else if(s.equals("*")) ops.push(s);
            else if(s.equals("/")) ops.push(s);
            else if(s.equals(")")) { //遇到右括号，进行弹出操作
                 Double v = vals.pop();
                 String op = ops.pop();
                if(op.equals("+")) v = vals.pop()+v;//刚取出的数与还在栈顶的数进行运算（即括号里的运算）
                else if(op.equals("-")) v = vals.pop()-v;
                else if(op.equals("*")) v = vals.pop()*v;
                else if(op.equals("/")) v = vals.pop()/v;
                vals.push(v);//将局部运算的结果加入到数值堆栈中
            }
           else vals.push(Double.parseDouble(s));//既不是运算符，也不是括号，加入数值堆栈
            s = "";
        }
        System.out.println(vals.pop());        //最后的运算结果
    }
}