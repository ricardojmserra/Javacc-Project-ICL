public class ASTPrintLN implements ASTNode{
    ASTNode t;
    ASTPrintLN(ASTNode t){
        this.t = t;
    }

    @Override
    public IValue eval(Enviroment e) throws ParseException {
        IValue value = t.eval(e);
        if(!(value instanceof VNull)) {
            System.out.println(value);
            return new VNull();
        }
        throw new ParseException("Invalid use of PrintLN Function");
    }

    @Override
    public void compile(CodeBlock c, Enviroment e) {

    }
}
