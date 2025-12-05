public class BinaryNode extends ASTNode {
    public String op;
    public ASTNode left;
    public ASTNode right;

    public BinaryNode(String op, ASTNode left, ASTNode right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }
}
