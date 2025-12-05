public class UnaryNode extends ASTNode {
    public String op;
    public ASTNode value;

    public UnaryNode(String op, ASTNode value) {
        this.op = op;
        this.value = value;
    }
}
