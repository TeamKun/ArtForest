package net.kunmc.lab.artforest.gm;

import net.md_5.bungee.api.ChatColor;

public enum GameMessage {

    GAMEEND("&6ゲーム終了!"),
    GAMEEND_TITLE("&6ゲーム終了!"),
    PLACEMENT("&a%rank%位 &b%player% &e%point%pts"),
    NOTFOUNT_DRAWER("&c書き手が見つかりませんでした。"),

    NEXTDRAWER("&6次の書き手は&e%player%&6です。"),

    GAMEEND_ANSWER1("&6お題は&e%answer%&6でした。"),
    GAMEEND_ANSWER2("&6正解者は&e%player%&6でした。"),
    GAMEEND_ANSWER3("&6正解者,書き手に&e%point%&6ポイント追加されます。"),
    GAMEENDTITLE_ANSWER1("&b正解は%answer%！"),
    GAMEENDTITLE_ANSWER2("&6正解者: &e%player%"),
    GAMEEND_WRONG("&6正解者はいませんでした。"),
    GAMEENDTITLE_WRONG1("&c時間切れ！"),
    GAMEENDTITLE_WRONG2("正解者はいませんでした"),

    REMAINNEXT("&8%s%秒後に次のゲームが開始します。"),

    FIRSTANSWER("&6お題は&e%answer%&6です。"),
    NEXTANSWER("&6次のお題は&e%answer%&6です。");

    String message;
    GameMessage(String s) {
        this.message = ChatColor.translateAlternateColorCodes('&', s);
    }
}
