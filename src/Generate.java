import sun.security.util.Length;

import java.util.*;

public class Generate {
//    定义三个字符串属性，分别赋值可能出现的数字、小写字母及大写字母
    private String number="0123456789";
    private String lowerCase="abcdefghijklmnopqrstuvwxyz";
    private String upperCase="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public void generateInterface(){
//        判断功能界面
        System.out.println("==================================");
        System.out.println("        欢迎使用密码管理系统");
        System.out.println("==================================");
//        创建对象determine，并调用determine方法
        Generate generate=new Generate();
        generate.generate();
    }
    public void generate(){
        Scanner scanner=new Scanner(System.in);
//        提示用户输入密码长度
        System.out.print("请输入需生成的密码的长度：");
        int length=scanner.nextInt();
//        创建对象g并调用isTrue,generate1方法
        Generate g=new Generate();
        g.isTrue(length);
        g.generate1(length);
    }
//    获取随机数字
    public char randomNumber(){
        Random random=new Random();
        return number.charAt(random.nextInt(number.toCharArray().length));
    }
//    获取随机小写字母
    public char randomLowerCase(){
        Random random=new Random();
        return lowerCase.charAt(random.nextInt(lowerCase.toCharArray().length));
    }
//    获取随机大写字母
    public char randomUpperCase(){
        Random random=new Random();
        return upperCase.charAt(random.nextInt(upperCase.toCharArray().length));
    }
//    获取随机字符
    public char randomChar(int j){
        switch (j){
            case 0:
                return randomNumber();
            case 1:
                return randomLowerCase();
            default:
                return randomUpperCase();
        }
    }
    public void generate1(int length){
        Random random=new Random();
//        先获取随机一个数字、小写字母、大写字母
        List<Character> list=new ArrayList<>(length);
        list.add(randomNumber());
        list.add(randomLowerCase());
        list.add(randomUpperCase());
//        再随机获取任何字符
        for (int i = 3; i < length; i++) {
            int j=random.nextInt(3);
            list.add(randomChar(j));
        }
        System.out.print("生成完毕：");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
    public void isTrue(int length){
        if (length>16) {
            System.out.println("密码不符合规定，长度应不超过16。");
        }
    }
}
