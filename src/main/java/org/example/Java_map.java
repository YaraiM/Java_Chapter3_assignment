package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Java_map {
    public static void main(String[] args) {
        // keyに英単語、valueに日本語を登録したMapインターフェースの変数translateToJpを定義しています。
        Map<String, String> translateToJp = new HashMap<>();
        translateToJp.put("apple", "リンゴ");
        translateToJp.put("banana", "バナナ");
        translateToJp.put("onion", "タマネギ");
        translateToJp.put("cabbage", "キャベツ");
        translateToJp.put("meat", "肉");
        translateToJp.put("fish", "魚");
        translateToJp.put("2BH", "「正直に言うと」");

        //Scannerクラスを使ってユーザーにキーを入力させ、入力結果に応じた出力を行います。
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]+$");

        while (true) {
            try {
                System.out.print("日本語訳したい英単語を半角英数字で入力してください。やめる場合は「#」を入力してください：");
                String inputKey = scanner.nextLine();

                if (inputKey.equals("#")) {
                    System.out.println("入力をキャンセルしました。");
                    break;
                } else if (inputKey.isEmpty()) {
                    throw new NullPointerException("何も入力されていません!半角英数字で入力してください!");
                } else if (!pattern.matcher(inputKey).find()) {
                    throw new IllegalArgumentException("半角英数字以外は入力できません!");
                } else if (!translateToJp.containsKey(inputKey)) {
                    System.out.println("申し訳ありません。" + inputKey + "がMapに登録されていないため、翻訳できませんでした。");
                    break;
                } else {
                    String outputValue = translateToJp.get(inputKey);
                    System.out.println(inputKey + "を日本語に翻訳すると" + outputValue + "です。");
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
