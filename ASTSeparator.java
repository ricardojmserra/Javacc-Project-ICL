public class ASTSeparator implements ASTNode {
    ASTNode l, r;
    public ASTSeparator(ASTNode t1, ASTNode t2) {
        l = t1;
        r = t2;
    }

    @Override   //Apenas serve para dizer a ordem em que avaliamos as coisas
    public IValue eval(Enviroment e) throws Exception {
        l.eval(e);
        r.eval(e);
        return new VNull();
    }

    @Override
    public void compile(CodeBlock c, Enviroment e) {

    }
}
