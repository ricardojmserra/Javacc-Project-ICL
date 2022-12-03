public class ASTPrint implements ASTNode{
    ASTNode t;
    ASTPrint(ASTNode t){
        this.t = t;
    }

    @Override
    public IValue eval(Enviroment e) throws ParseException {
        IValue value = t.eval(e);
        if(!(value instanceof VNull)) {
            System.out.print(value);
            return new VNull();
        }
        throw new ParseException("Invalid use of print function");
    }

    @Override
    public void compile(CodeBlock c, Enviroment e) {

    }
}
