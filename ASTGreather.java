public class ASTGreather implements ASTNode{
    ASTNode lhs, rhs;
    ASTGreather(ASTNode l, ASTNode r){
        lhs = l;
        rhs = r;
    }

    @Override
    public IValue eval(Enviroment e)throws ParseException
    {
        IValue left = lhs.eval(e);
        left = left instanceof VCell ? ((VCell) left).value : left;
        if(left instanceof VInt LEFT){
            IValue right = rhs.eval(e);
            right = right instanceof VCell ? ((VCell) right).value : right;
            if(right instanceof VInt RIGHT){
                return new VBool(LEFT.value > RIGHT.value);
            }

        }
        throw new ParseException("Invalid use of > operator");
    }

    @Override
    public void compile(CodeBlock c, Enviroment e) {

    }
}
