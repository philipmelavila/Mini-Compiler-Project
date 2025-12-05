public class TreePrinter {

    public void print(ASTNode node, int indent) {
        String spacing = "";
        for (int i = 0; i < indent; i++) {
            spacing += "    ";
        }
        if (node instanceof NumberNode) {
            System.out.println(spacing + ((NumberNode) node).value);
        }
        else if (node instanceof UnaryNode) {
            UnaryNode u = (UnaryNode) node;
            System.out.println(spacing + u.op);
            print(u.value, indent + 1);
        }
        else if (node instanceof BinaryNode) {
            BinaryNode b = (BinaryNode) node;
            System.out.println(spacing + b.op);
            print(b.left, indent + 1);
            print(b.right, indent + 1);
        }
    }
}
