
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        String expr = input.nextLine();
        input.close();

        try {
            System.out.println("Input: " + expr);

            Lexer lexer = new Lexer(expr);
            ArrayList<Token> tokens = lexer.tokenize();
            System.out.println("Tokens: " + tokens);

            Parser parser = new Parser(tokens);
            ASTNode tree = parser.parse();

            System.out.println("\nParse Tree:");
            new TreePrinter().print(tree, 0);

            double result = new Evaluator().eval(tree);
            System.out.println("\nEvaluation Result: " + result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
