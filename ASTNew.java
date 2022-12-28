public class ASTNew implements ASTNode {
    private ASTNode t;
    public ASTNew(ASTNode t) {
        this.t = t;
    }

    @Override
    public IValue eval(Enviroment e) throws Exception {
        IValue result = t.eval(e);
        if(result instanceof VNull)
            throw new Exception("Wrong usage of new operator");
        return new VCell(result);
    }

    @Override
    public void compile(CodeBlock c, Enviroment e) {

    }
}
