package Chapter1_3;

import java.util.Stack;

/**
 * Created by xie on 2017/4/9.
 * 补全缺少的左括号  1+2）*3-4）*5-6））） ==>  ((1+2)*((3-4)*(5-6)))
 */
public class Ex1_3_9 {
    public static void method(String str){
        char[] chars = str.toCharArray();
        String s = "";
        Stack<String> vals = new Stack<String>();  //存数值
        Stack<String> ops = new Stack<String>();   //存操作符
        for (int i = 0; i < chars.length; i++) {
            s+=chars[i];
            if (s.equals("(")) ;           //左括号不处理 操作符加入ops栈
            else if (s.equals("+") ||
                    s.equals("-") ||
                    s.equals("*") ||
                    s.equals("/")
                    ) ops.push(s);
            else if(s.equals(")")){         //遇到右括号，就将两个堆栈中的值拿出来拼接，组成新的值放入vals栈
                String op = ops.pop();
                String val = vals.pop();
                val = "("+vals.pop()+op+val+")";
                vals.push(val);
            }else vals.push(s);             //既不是括号也不是操作符，那就是数值了，直接加入vals栈，以备调用
            s="";
        }
        System.out.println(vals.pop());
    }

    public static void main(String[] args){
        String  s = "1+2)*3-4)*5-6)))";
        method(s);
    }
}
