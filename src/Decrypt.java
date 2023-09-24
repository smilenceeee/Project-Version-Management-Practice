import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Decrypt {
    public void decryptInterface(){
//        解密功能界面
        System.out.println("==================================");
        System.out.println("        欢迎使用密码管理系统");
        System.out.println("==================================");
//        创建对象decrypt，并调用decrypt方法
        Decrypt decrypt=new Decrypt();
        decrypt.decrypt();
    }
    public void decrypt(){
//        提示用户输入需要解密的字符串
        System.out.print("请输入需要解密的字符串：");
        Scanner scanner=new Scanner(System.in);
        String password=scanner.next();
//        创建char类型数组array1，int类型数组array2，Character类型数组array3，Character类型数组array4
        char[] array1=password.toCharArray();
        int[] array2=new int[array1.length];
        Character[] array3=new Character[array1.length];
        Character[] array4=new Character[array1.length];
//        创建对象d，并调用isTrue,decrypt1、2、3方法
        Decrypt d=new Decrypt();
        d.isTrue(array1);
        d.decrypt1(array1,array3,array4);
        d.decrypt2(array4);
        d.decrypt3(array4,array2);
        System.out.print("解密后的结果是：");
//        输出解密后的结果
        for (int i = 0; i < array4.length; i++) {
            System.out.print(array4[i]);
        }
        System.out.println();
    }
    public void decrypt1(char[] array1,Character[] array3,Character[] array4){
        //将字符串反转
        for (int i = 0; i < array3.length; i++) {
            array3[i]=array1[i];
        }
        List<Character> list=new ArrayList<>();
        Collections.addAll(list,array3);
        Collections.reverse(list);
        list.toArray(array4);
    }
    public void decrypt2(Character[] array4){
        //将字符串的第一位和最后一位调换顺序
        char n1=array4[0];
        char n2=array4[array4.length-1];
        array4[0]=n2;
        array4[array4.length-1]=n1;
    }
    public void decrypt3(Character[] array4,int[] array2){
        //将每个字符的ASCII码减去它在字符串中的位置(1开始)和偏移值3
        for (int i = 0; i < array4.length; i++) {
            array2[i]=array4[i]-i-4;
            array4[i]=(char)array2[i];
        }
    }
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
