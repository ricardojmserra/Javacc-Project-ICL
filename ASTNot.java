public class ASTNot implements ASTNode {
    ASTNode t;
    public ASTNot(ASTNode t) {
        this.t = t;
    }

    @Override
    public IValue eval(Enviroment e) throws Exception{
        IValue value = t.eval(e);
        if(value instanceof VBool VALUE)
            return new VBool(!VALUE.value);
        throw new ParseException("Can only negate boolean values");
    }

    @Override
    public void compile(CodeBlock c, Enviroment e) {

    }
}
