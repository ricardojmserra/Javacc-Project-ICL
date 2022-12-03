public class ASTNequal implements ASTNode {
    ASTNode lhs, rhs;
    public ASTNequal(ASTNode t1, ASTNode t2) {
        lhs = t1;
        rhs = t2;
    }

    public IValue eval(Enviroment e)throws ParseException
    {
        IValue left = lhs.eval(e);
        left = left instanceof VCell ? ((VCell) left).value : left;
        if(!(left instanceof VNull)){
            IValue right = rhs.eval(e);
            right = right instanceof VCell ? ((VCell) right).value : right;
            if(!(right instanceof VNull) && right.getClass() == left.getClass())
                return new VBool(!left.equals(right));
        }
        throw new ParseException("Can't use equal operator if values are not the same type");
    }

    @Override
    public void compile(CodeBlock c, Enviroment e) {

    }
}
