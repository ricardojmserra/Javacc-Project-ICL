public class ASTNeg implements ASTNode{
    ASTNode val;

    public ASTNeg(ASTNode val){ this.val = val;}
    @Override
    public IValue eval(Enviroment e) throws ParseException{
        IValue value = val.eval(e);
        value = value instanceof VCell ? ((VCell) value).value : value;
        if(value instanceof VInt VALUE)
            return new VInt(-VALUE.value);
        throw new ParseException("Can only negate integers");
    }

    @Override
    public void compile(CodeBlock c, Enviroment e) {
        val.compile(c, e);
        c.emit("ineg");
    }
}
