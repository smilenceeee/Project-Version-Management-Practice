import java.util.Scanner;

public class 密码管理系统 {
    public static void main(String[] args) {
//        创建Main类对象main，并调用mainInterface方法
        Main main = new Main();
        main.mainInterface();
        //让用户输入选项序号
        System.out.print("请输入选项序号：");
        Scanner scanner=new Scanner(System.in);
        int action=scanner.nextInt();
//        根据用户输入的选项序号通过switch-case语句进行判断从而跳转页面
        switch (action){
//            序号为1时跳转到加密功能
            case 1 :
//                创建Encryption类对象encryption，并调用encryptionInterface方法
                Encryption encryption=new Encryption();
                encryption.encryptionInterface();
                break;
//            序号为2时跳转到解密功能
            case 2 :
//                创建Decrypt类对象decrypt，并调用decryptInterface方法
                Decrypt decrypt=new Decrypt();
                decrypt.decryptInterface();
                break;
            case 3 :
//                创建Determine类对象determine，并调用determineInterface方法
                Determine determine=new Determine();
                determine.determineInterface();
                break;
            case 4 :
//                创建Generate类对象generate，并调用generateInterface方法
                Generate generate=new Generate();
                generate.generateInterface();
                break;
            case 5 :
//                创建Determine类对象determine，并调用determineInterface方法
                Exit exit=new Exit();
                exit.exitInterface();
                break;
        }
    }
}
