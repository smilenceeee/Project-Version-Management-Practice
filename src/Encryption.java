import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.*;

public class Encryption {
    public void encryptionInterface(){
//        加密功能界面
        System.out.println("==================================");
        System.out.println("        欢迎使用密码管理系统");
        System.out.println("==================================");
//        创建对象encryption，并调用encryption方法
        Encryption encryption=new Encryption();
        encryption.encryption();
    }
    public void encryption(){
//        提示用户输入要加密的数字密码
        System.out.print("请输入要加密的数字密码：");
        Scanner scanner=new Scanner(System.in);
        String password=scanner.next();
//        创建char类型数组array1，int类型数组array2，Character类型数组array3，Character类型数组array4
        char[] array1=password.toCharArray();
        int[] array2=new int[array1.length];
        Character[] array3=new Character[array1.length];
        Character[] array4=new Character[array1.length];
//        创建对象e，并调用isTrue,encryption1、2、3方法
        Encryption e = new Encryption();
        e.isTrue(array1);
        e.encryption1(array1,array2);
        e.encryption2(array1);
        e.encryption3(array1,array3,array4);
        System.out.print("加密后的结果是：");
//        输出加密后的结果
        for (int i = 0; i < array4.length; i++) {
            System.out.print(array4[i]);
        }
        System.out.println();
    }
    public void encryption1(char[] array1,int[] array2){
        //将每个字符的ASCII码加上它在字符串中的位置(1开始)和偏移值3
        for (int i = 0; i < array1.length; i++) {
            array2[i]=array1[i]+i+4;
            array1[i]=(char)array2[i];
        }
    }
    public void encryption2(char[] array1){
        //将字符串的第一位和最后一位调换顺序
        char n1=array1[0];
        char n2=array1[array1.length-1];
        array1[0]=n2;
        array1[array1.length-1]=n1;
    }
    public void encryption3(char[] array1,Character[] array3,Character[] array4){
        //将字符串反转
        for (int i = 0; i < array3.length; i++) {
            array3[i]=array1[i];
        }
        List<Character> list=new ArrayList<>();
        Collections.addAll(list,array3);
        Collections.reverse(list);
        list.toArray(array4);
    }
//    判断密码是否符合要求
    public void isTrue(char[] array){
        for (int i = 0; i < array.length; i++) {
            if (Character.isDigit(array[i])==false&&
                    Character.isLowerCase(array[i])==false&&
                    Character.isUpperCase(array[i])==false){
                System.out.println("密码不符合规定，只能包含数字及大小写字母。");
            } else if (array.length>16) {
                System.out.println("密码不符合规定，长度应不超过16。");
            }
        }
    }
}
