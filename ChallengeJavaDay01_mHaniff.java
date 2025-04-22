package day01;

import java.util.Scanner;

public class ChallengeJavaDay01_mHaniff {
    public static void main(String[] args){
        //Challenge 1 Iteration
        //iteration01(5);
        //iteration02(5);
        //iteration03(5);
        //iteration04(5);
        //iteration05(5);
        //iteration06(5);
        //iteration07();
        //iteration09(5);
        //iteration10(5);

        //Challenge 2: String dan Math
        // Challenge Reverse
        //int hasilReverse = Reverse(4563);
        //System.out.print(hasilReverse);

        //Challenge IsPalindrome
        //System.out.print(isPalindrome(10));

        //Challenge Capitalize
        //System.out.println(Capitalize("Haniff sedang miNum"));

        //Challenge IsNoDuplicateChar
        //System.out.println(isNoDuplicateChar("dabced"));

        //Challenge isBrace
        //System.out.println(isBrace("()()"));

    }

    public static void iteration01(int n){
        int counter = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.printf("%4d ", counter);
                counter += 1;
            }
            System.out.println();
        }
    }

    public static void iteration02(int n){
        for(int i = 1; i <= n; i++){
            int counter = i;
            for(int j = 1; j <= i; j++){
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    public static void iteration03(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void iteration04(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i <= j){
                    System.out.print(j);
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void iteration05(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j){
                    System.out.print(" " + j + " ");
                }else if (i > j){
                    System.out.print(" 20 ");
                }else{
                    System.out.print(" 10 ");
                }
            }
            System.out.println();
        }
    }

    public static void iteration06(int n){
        for (int i = n; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                if (i == j){
                    System.out.print(" " + j + " ");
                }else if (i > j){
                    System.out.print(" 20 ");
                }else{
                    System.out.print(" 10 ");
                }
            }
            System.out.println();
        }
    }

    public static void iteration07(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input jumlah baris piramid : ");
        int n = input.nextInt();

        for(int i = n; i>= 1; i--){
            //bagian count desc
            for(int j = i; j >=1 ; j--){
                System.out.print(j + " ");
            }
            //bagian count asc
            for(int j = 2; j <=i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void iteration09(int n){
        for(int i = 0; i < n; i ++){
            if (i % 2 == 0){
                for (int j = n; j >= 1; j--){
                    System.out.print(j + " ");
                }
            }else {
                for (int j = 1; j <= n; j++){
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public static void iteration10(int n){
        for(int i = 0; i < n; i ++){
            if (i % 2 == 0){
                for (int j = 1; j <= n; j++){
                    if (j % 2 == 0){
                        System.out.print(j);
                    }else{
                        System.out.print(" - ");
                    }
                }
            }else {
                for (int j = 1; j <= n; j++){
                    if (j % 2 == 0){
                        System.out.print(" - ");
                    }else{
                        System.out.print(j);
                    }
                }
            }
            System.out.println();
        }
    }

    /* ========== Challenge 2 =========*/
    public static int Reverse(int n){
        //Scanner input = new Scanner(System.in);

        int reversed = 0;
        while (n != 0){//n akan terus dibagi 10 sampai hasilnya 0
            reversed = reversed * 10 + n % 10;//fungsi modulo untuk mebangambil bilangan satuan atau terakhir
            n = n / 10; //dibagi sepuluh untuk menghilangkan bilagan satuan yg sudah disimpan
        }               //perkalian sepuluh adalah untuk merubah bilangan satuan di awal menjadi puluhan-ratusan-ribuan
        return reversed;

        /*//Cara 2: pakai Array
        String numStr = Integer.toString(n);
        char [] arrayNum = numStr.toCharArray();

        //menggunakan String builder
        StringBuilder reversedStr = new StringBuilder();
        for (int i = arrayNum.length-1; i >= 0; i--){
            reversedStr.append(arrayNum[i]);
        }
        //menjadikan nilai reveres dalam array string menjadi int
        int reversedN = Integer.parseInt(reversedStr.toString());

        //boolean isNegatif = n < 0;
        return reversedN;*/
    }

    public static boolean isPalindrome(int n){
        return Reverse(n) == n;//memanggil metode reverse untuk membandingkan nilai reverse dan input awal
    }

    public static String Capitalize(String input){
        if(input == " " || input == "" || input == null){
            return "";
        }
        input = input.trim().toLowerCase();
        StringBuilder result = new StringBuilder();

        String[] perKata = input.split(" ");
        for(String kata : perKata){
            result.append(Character.toTitleCase(kata.charAt(0)));//menjadikan huruf pertama (index 0) kapital
            result.append(kata.substring(1));//menambahkan sisa huruf dalam satu kata
            result.append(" ");//memberikan spasi setelah satu kata
        }
        return result.toString();
    }

    public static boolean isNoDuplicateChar(String s){
        for(int i=0; i < s.length(); i++){
            for (int j = i+1; j < s.length() ; j++) {
                if(s.charAt(i) == s.charAt(j)) {//melakukan pengecekan apakah huruf saat ini sama dengan huruf setelahnya
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBrace(String s){
        int udahKetutup = 0;

        for (int i = 0; i < s.length() ; i++) {
            char brace = s.charAt(i);

            if (brace == '(') {
                udahKetutup += 1;// plus satu jika ada brace pembuka
            } else if (brace == ')') {
                udahKetutup -= 1;// minus satu jika ada brace penutup
            }
        }
        return udahKetutup==0; //jika brace pembuka dan penutup berbeda maka false
    }


}
