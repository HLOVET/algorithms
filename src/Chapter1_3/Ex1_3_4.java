package Chapter1_3;

import java.util.Stack;

/**
 * Created by xie on 2017/4/9.
 * 检查括号是否匹配   如{【】} =true      {[ )} =false
 */
public class Ex1_3_4 {
    public static boolean check(String str){
        int n = str.length();
        Stack s = new Stack();
        char c;
        for(int i = 0;i<n;i++){
            c =  str.charAt(i);  //取出对应位置的字符 左半部分则入栈  右半部分则进行判断(栈空或者不匹配直接false)
            if(c=='{' || c=='[' || c=='('){
                s.push(c);
            }else if((c=='}' &&(s.isEmpty() || s.pop()!="{")) ||
                    (c==']' && (s.isEmpty() || s.pop()!="[")) ||
                    (c==')' && (s.isEmpty() || s.pop()!="("))
                    ){
                return false;
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args){
        String s = "{[>}";
        System.out.println(check(s));
    }
}
