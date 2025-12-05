import java.util.ArrayList;

public class Lexer {
    private final String input;
    private int pos = 0;

    public Lexer(String input) {
        this.input = input.replaceAll(" ", "");
    }

    private char current() {
        if (pos < input.length()) {
            return input.charAt(pos);
        }
        return '\0';
    }

    public ArrayList<Token> tokenize() {
        ArrayList<Token> tokens = new ArrayList<>();

        while (pos < input.length()) {
            char c = current();

            if (Character.isDigit(c)) {
                tokens.add(readNumber());
            } else if (c == '+') { tokens.add(new Token("PLUS", "+")); pos++;
            } else if (c == '-') { tokens.add(new Token("MINUS", "-")); pos++;
            } else if (c == '*') { tokens.add(new Token("STAR", "*")); pos++;
            } else if (c == '/') { tokens.add(new Token("SLASH", "/")); pos++;
            } else if (c == '(') { tokens.add(new Token("LPAREN", "(")); pos++;
            } else if (c == ')') { tokens.add(new Token("RPAREN", ")")); pos++;
            } else {
                throw new RuntimeException("Invalid character: " + c);
            }
        }

        tokens.add(new Token("EOF", ""));
        return tokens;
    }

    private Token readNumber() {
        int start = pos;
        while (pos < input.length() && Character.isDigit(current())) {
            pos++;
        }
        String value = input.substring(start, pos);
        return new Token("NUMBER", value);
    }
}
