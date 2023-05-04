package org.me.leo_s.particleletterns.components.builders.maths;

import org.bukkit.Color;
import org.me.leo_s.particleletterns.components.exceptions.TextFormattedInvalid;

public class ColorValue {
    public static int[] fromStringBukkit(String color) throws TextFormattedInvalid {
        return switch (color) {
            case "RED" -> new int[]{255, 0, 0};
            case "GREEN" -> new int[]{0, 255, 0};
            case "BLUE" -> new int[]{0, 0, 255};
            case "YELLOW" -> new int[]{255, 255, 0};
            case "PURPLE" -> new int[]{255, 0, 255};
            case "CYAN" -> new int[]{0, 255, 255};
            case "WHITE" -> new int[]{255, 255, 255};
            case "BLACK" -> new int[]{0, 0, 0};
            case "ORANGE" -> new int[]{255, 128, 0};
            case "PINK" -> new int[]{255, 0, 128};
            case "LIME" -> new int[]{128, 255, 0};
            case "LIGHT_BLUE" -> new int[]{0, 255, 128};
            case "MAGENTA" -> new int[]{128, 0, 255};
            case "LIGHT_GRAY" -> new int[]{128, 128, 128};
            case "GRAY" -> new int[]{64, 64, 64};
            case "BROWN" -> new int[]{128, 64, 0};
            default -> throw new TextFormattedInvalid("§7The color must be §cRED, GREEN, BLUE, YELLOW, PURPLE, CYAN, WHITE, BLACK, ORANGE, PINK, LIME, LIGHT_BLUE, MAGENTA, LIGHT_GRAY, GRAY or BROWN§7.");
        };
    }

    public static Color fromStringBukkitColor(String color) throws TextFormattedInvalid {
        return switch (color) {
            case "RED" -> Color.RED;
            case "GREEN" -> Color.GREEN;
            case "BLUE" -> Color.BLUE;
            case "YELLOW" -> Color.YELLOW;
            case "PURPLE" -> Color.PURPLE;
            case "CYAN" -> Color.AQUA;
            case "WHITE" -> Color.WHITE;
            case "BLACK" -> Color.BLACK;
            case "ORANGE" -> Color.fromRGB(255, 128, 0);
            case "PINK" -> Color.fromRGB(255, 0, 128);
            case "LIME" -> Color.fromRGB(128, 255, 0);
            case "LIGHT_BLUE" -> Color.fromRGB(0, 255, 128);
            case "MAGENTA" -> Color.fromRGB(128, 0, 255);
            case "LIGHT_GRAY" -> Color.fromRGB(128, 128, 128);
            case "GRAY" -> Color.fromRGB(64, 64, 64);
            case "BROWN" -> Color.fromRGB(128, 64, 0);
            default -> throw new TextFormattedInvalid("§7The color must be §cRED, GREEN, BLUE, YELLOW, PURPLE, CYAN, WHITE, BLACK, ORANGE, PINK, LIME, LIGHT_BLUE, MAGENTA, LIGHT_GRAY, GRAY or BROWN§7.");
        };
    }

    public static Color fromRGBBukkitColor(int[] colorRGB) {
        return Color.fromRGB(colorRGB[0], colorRGB[1], colorRGB[2]);
    }

    public static Color fromChar(char letterChar) {
        return switch (letterChar) {
            case '1' -> Color.fromRGB(0, 0, 170);
            case '2' -> Color.fromRGB(0, 170, 0);
            case '3' -> Color.fromRGB(0, 170, 170);
            case '4' -> Color.fromRGB(170, 0, 0);
            case '5' -> Color.fromRGB(170, 0, 170);
            case '6' -> Color.fromRGB(255, 170, 0);
            case '7' -> Color.fromRGB(170, 170, 170);
            case '8' -> Color.fromRGB(85, 85, 85);
            case '9' -> Color.fromRGB(85, 85, 255);
            case 'A' -> Color.fromRGB(85, 255, 85);
            case 'B' -> Color.fromRGB(85, 255, 255);
            case 'C' -> Color.fromRGB(255, 85, 85);
            case 'D' -> Color.fromRGB(255, 85, 255);
            case 'E' -> Color.fromRGB(255, 255, 85);
            case 'F' -> Color.WHITE;
            default -> Color.BLACK;
        };
    }
    public static String colorToChar(Color color) {
        return switch (color.asRGB()) {
            case 170 -> "1";
            case 43520 -> "2";
            case 43690 -> "3";
            case 11141120 -> "4";
            case 11141290 -> "5";
            case 16755200 -> "6";
            case 11184810 -> "7";
            case 5592405 -> "8";
            case 5592575 -> "9";
            case 5635925 -> "A";
            case 5636095 -> "B";
            case 16733525 -> "C";
            case 16733795 -> "D";
            case 16777045 -> "E";
            case 16777215 -> "F";
            default -> "0";
        };
    }
}
