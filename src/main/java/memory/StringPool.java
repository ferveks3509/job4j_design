package memory;

public class StringPool {
    public static void main(String[] args) {
        String str1 = new String("Hello");
        String str2 = new String("Hello");
        System.out.println(str1 == str2); // вернет False т.к обьекты созданы в куче и не попали в пулл строк

        String str3 = "He";
        String str4 = "He";
        System.out.println(str3 == str4);//вернет true т.к str создан в пуле и возвращаеться ссылка в str4

        String str5 = new String("NewStr");
        String str6 = new String("NewStr");
        String str7 = "NewStr";
        String str8 = "NewStr";
        System.out.println(str5 == str6);//false т.к созданы в куче и это два разных объекта
        System.out.println(str7 == str8);//true т.к str7 создан в пуле и str8 получает ссылку на сущ. строку.
        System.out.println(str5 == str6);//false т.к str5 создан в куче, а str6 в пуле
        System.out.println(str6 == str8);//false

        String s1 = "Hello world";
        String s2 = "Hello";
        String s3 = s2 + " world";
        System.out.println(s1 == s3);//false т.к интернирование происходит на стадии компиляции s3 будет создан в куче.
    }
}
