public class ASTLte implements ASTNode {
    ASTNode lhs, rhs;
    ASTLte(ASTNode l, ASTNode r){
        lhs = l;
        rhs = r;
    }
    @Override
    public IValue eval(Enviroment e)throws Exception
    {
        IValue left = lhs.eval(e);
        if(left instanceof VInt LEFT){
            IValue right = rhs.eval(e);
            if(right instanceof VInt RIGHT){
                return new VBool(LEFT.value <= RIGHT.value);
            }

        }
        throw new ParseException("Can't use lesser operator if values are not ints");
    }

    @Override
    public void compile(CodeBlock c, Enviroment e) {

    }
}
