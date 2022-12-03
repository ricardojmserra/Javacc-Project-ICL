public class ASTBool implements ASTNode {
    boolean b;
    public ASTBool(boolean b) {
        this.b = b;
    }

    @Override
    public IValue eval(Enviroment e) throws ParseException{
        return new VBool(b);
    }

    @Override
    public void compile(CodeBlock c, Enviroment e) {

    }
}
