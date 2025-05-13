package main.exercism.squeakyClean;

public class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = false;

        for (int i = 0; i < identifier.length(); i++) {
            char c = identifier.charAt(i);

            // 1. Replace spaces with underscores
            if (c == ' ') {
                result.append('_');
                continue;
            }

            // 2. Convert kebab-case to camelCase
            if (c == '-') {
                capitalizeNext = true;
                continue;
            }

            // 3. Convert leetspeak to normal text
            c = convertLeetspeak(c);

            // 4. Omit characters that are not letters
            if (!Character.isLetter(c)) {
                continue;
            }

            // Apply camelCase conversion if needed
            if (capitalizeNext) {
                c = Character.toUpperCase(c);
                capitalizeNext = false;
            }

            result.append(c);
        }

        return result.toString();
    }

    // Helper method to convert leetspeak characters
    private static char convertLeetspeak(char c) {
        return switch (c) {
            case '0' -> 'o';
            case '1' -> 'l';
            case '3' -> 'e';
            case '4' -> 'a';
            case '5' -> 's';
            case '7' -> 't';
            default -> c;
        };
    }
}

