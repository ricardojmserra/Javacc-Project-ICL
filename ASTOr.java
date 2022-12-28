public class ASTOr implements ASTNode {
    ASTNode lhs, rhs;
    public ASTOr(ASTNode t1, ASTNode t2) {
        lhs = t1;
        rhs = t2;
    }

    @Override
    public IValue eval(Enviroment e)throws Exception
    {
        IValue left = lhs.eval(e);
        if(left instanceof VBool LEFT){
            IValue right = rhs.eval(e);
            if(right instanceof VBool RIGHT){
                return new VBool(LEFT.value || RIGHT.value);
            }

        }
        throw new ParseException("Invalid use of || operator");
    }

    @Override
    public void compile(CodeBlock c, Enviroment e) {

    }
}
