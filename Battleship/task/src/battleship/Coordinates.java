package battleship;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coordinates {
    private String from;
    private String to;
    private int width = 10;
    private int height = 10;

    public Coordinates(String cords) {
        String[] tmp = cords.split(" ");
        this.from = tmp[0];
        this.to = tmp[1];
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getFromX() {
        return from.substring(1);
    }

    public int getFromXn() {
        return Integer.parseInt(getFromX());
    }
    public String getFromY() {
        return String.valueOf(from.charAt(0));
    }

    public int getFromYn() {
        return letterToIndex(getFromY());
    }

    public String getToX() {
        return to.substring(1);
    }

    public int getToXn() {
        return Integer.parseInt(getToX());
    }

    public String getToY() {
        return String.valueOf(to.charAt(0));
    }


    public int getToYn() {
        return letterToIndex(getToY());
    }

    public void setFrom(String value) {
        from = value;
    }

    public void setTo(String value) {
        to = value;
    }

    public static boolean isValidCords(String cords) {
        Pattern pat = Pattern.compile("[a-jA-J]([1-9]|10) [a-jA-J]([1-9]|10)");
        Matcher matcher = pat.matcher(cords);
        return matcher.find();
    }

    public static String indexToLetter(int idx) {
        switch (idx) {
            case 0:
                return "a";
            case 1:
                return "b";
            case 2:
                return "c";
            case 3:
                return "d";
            case 4:
                return "e";
            case 5:
                return "f";
            case 6:
                return "g";
            case 7:
                return "h";
            case 8:
                return "i";
            case 9:
                return "j";
        }
        return "";
    }

    public static int letterToIndex(String letter) {
        switch (letter.toLowerCase()) {
            case "a":
                return 0;
            case "b":
                return 1;
            case "c":
                return 2;
            case "d":
                return 3;
            case "e":
                return 4;
            case "f":
                return 5;
            case "g":
                return 6;
            case "h":
                return 7;
            case "i":
                return 8;
            case "j":
                return 9;
        }
        return -1;
    }
    public boolean isOnTopEdge(int num){
        return num == 0;
    }

    public boolean isOnBottomEdge(int num){
        return num == height;
    }

    public boolean isOnLeftEdge(int num){
        return num == 0;
    }

    public boolean isOnRightEdge(int num){
        return num == width;
    }
}
