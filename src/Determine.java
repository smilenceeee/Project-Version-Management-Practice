import sun.security.util.Password;

import java.util.Scanner;

public class Determine {
    public void determineInterface(){
//        判断功能界面
        System.out.println("==================================");
        System.out.println("        欢迎使用密码管理系统");
        System.out.println("==================================");
//        创建对象determine，并调用determine方法
        Determine determine=new Determine();
        determine.determine();
    }
    public void determine(){
        Scanner scanner=new Scanner(System.in);
//        提示用户输入密码
        System.out.print("请输入要判断强度的密码：");
        String password=scanner.next();
//        将用户输入的字符串密码转换为字符数组
        char[] array=password.toCharArray();
//        定义int类型变量length接收密码长度
        int length=array.length;
//        定义int类型数组j用于接收字符类型结果
        int[] j=new int[3];
//        创建对象d并调用isTrue,determine1、2方法
        Determine d=new Determine();
        d.isTrue(array);
        d.determine1(array,j);
        d.determine2(length,j);
    }
    public void determine1(char[] array,int[] j){
//        进行判断包含的字符类型，若包含数字则j[0]=1,若包含小写字母则j[1]=1,若包含大写字母则j[2]=1
        for (int i = 0; i < array.length; i++) {
            if(Character.isDigit(array[i])==true){
                j[0]=1;
            } else if(Character.isLowerCase(array[i])==true){
                j[1]=1;
            } else if(Character.isUpperCase(array[i])==true){
                j[2]=1;
            }
        }
    }
    public void determine2(int length,int[] j){
//        按照题目要求进行判断密码强度
        System.out.print("密码强度为：");
        if (length<8||
                j[0]==1&&j[1]==0&&j[2]==0||
                j[0]==0&&j[1]==1&&j[2]==0||
                j[0]==0&&j[1]==0&&j[2]==1){
            System.out.println("低强度");
        } else if (length>=8&&j[0]==1&&j[1]==1&&j[2]==0) {
            System.out.println("中强度");
        } else if (length>=8&&j[0]==1&&j[1]==0&&j[2]==1) {
            System.out.println("中强度");
        } else if (length>=8&&j[0]==1&&j[1]==1&&j[2]==1){
            System.out.println("高强度");
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
