import java.util.ArrayList;

public class Parser {

    private final ArrayList<Token> tokens;
    private int pos = 0;

    public Parser(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    private Token current() {
        return tokens.get(pos);
    }

    private Token eat(String type) {
        if (current().type.equals(type)) {
            return tokens.get(pos++);
        }
        throw new RuntimeException("Unexpected token: " + current().value);
    }

    public ASTNode parse() {
        ASTNode node = expression();
        eat("EOF");
        return node;
    }

    private ASTNode expression() {
        ASTNode node = term();

        while (current().type.equals("PLUS") ||
               current().type.equals("MINUS")) {

            String op = current().value;
            pos++;
            node = new BinaryNode(op, node, term());
        }

        return node;
    }

    private ASTNode term() {
        ASTNode node = factor();

        while (current().type.equals("STAR") ||
               current().type.equals("SLASH")) {

            String op = current().value;
            pos++;
            node = new BinaryNode(op, node, factor());
        }

        return node;
    }

    private ASTNode factor() {
        Token t = current();

        if (t.type.equals("MINUS")) {
            eat("MINUS");
            return new UnaryNode("-", factor());
        }

        if (t.type.equals("NUMBER")) {
            eat("NUMBER");
            return new NumberNode(Double.parseDouble(t.value));
        }

        if (t.type.equals("LPAREN")) {
            eat("LPAREN");
            ASTNode expr = expression();
            eat("RPAREN");
            return expr;
        }

        throw new RuntimeException("Unexpected token: " + t.value);
    }
}
