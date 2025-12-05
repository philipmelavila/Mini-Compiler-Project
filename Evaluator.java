public class Evaluator {

    public double eval(ASTNode node) {

        if (node instanceof NumberNode) {
            return ((NumberNode) node).value;
        }

        if (node instanceof UnaryNode) {
            UnaryNode u = (UnaryNode) node;
            if (u.op.equals("-")) {
                return (-1 * eval(u.value));
            }
            throw new RuntimeException("Unknown unary operator: " + u.op);
        }

        if (node instanceof BinaryNode) {
            BinaryNode b = (BinaryNode) node;

            double left = eval(b.left);
            double right = eval(b.right);

            if (b.op.equals("+")) return left + right;
            if (b.op.equals("-")) return left - right;
            if (b.op.equals("*")) return left * right;
            if (b.op.equals("/")) return left / right;

            throw new RuntimeException("Unknown operator: " + b.op);
        }

        throw new RuntimeException("Invalid AST node");
    }
}
