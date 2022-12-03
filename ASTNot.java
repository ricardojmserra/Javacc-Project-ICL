public class ASTNot implements ASTNode {
    ASTNode t;
    public ASTNot(ASTNode t) {
        this.t = t;
    }

    @Override
    public IValue eval(Enviroment e) throws ParseException{
        IValue value = t.eval(e);
        value = value instanceof VCell ? ((VCell) value).value : value;
        if(value instanceof VBool VALUE)
            return new VBool(!VALUE.value);
        throw new ParseException("Can only negate boolean values");
    }

    @Override
    public void compile(CodeBlock c, Enviroment e) {

    }
}
