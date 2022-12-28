public class ASTAnd implements ASTNode {
    ASTNode l,r;
    public ASTAnd(ASTNode t1, ASTNode t2) {
        l=t1;
        r=t2;
    }

    @Override
    public IValue eval(Enviroment e) throws Exception {
        IValue left = l.eval(e);
        if(left instanceof VBool){
            VBool LEFT = (VBool) left;
            IValue right = r.eval(e);
            if(right instanceof VBool){
                VBool RIGHT = (VBool) right;
                return new VBool(LEFT.value && RIGHT.value);
            }
        }
        throw new ParseException("Invalid values for && operator");
    }

    @Override
    public void compile(CodeBlock c, Enviroment e) {

    }
}
