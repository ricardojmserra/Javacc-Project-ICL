public class ASTPointer implements ASTNode {
    private ASTNode t;
    public ASTPointer(ASTNode t) {
        this.t = t;
    }

    @Override
    public IValue eval(Enviroment e) throws Exception {
        IValue result = t.eval(e);
        if(result instanceof VCell RESULT)
            return RESULT.value;
        throw new Exception("Invalid use of pointer ! ");
    }

    @Override
    public void compile(CodeBlock c, Enviroment e) {

    }
}
