public class ASTSub implements ASTNode{
    ASTNode lhs, rhs;

    public IValue eval(Enviroment e)throws ParseException
    {
        IValue left = lhs.eval(e);
        left = left instanceof VCell ? ((VCell) left).value : left;
        if(left instanceof VInt LEFT){
            IValue right = rhs.eval(e);
            right = right instanceof VCell ? ((VCell) right).value : right;
            if(right instanceof VInt RIGHT){
                return new VInt(LEFT.value - RIGHT.value);
            }

        }
        throw new ParseException("Can't use Minus operator if values are not integers");
    }

    public ASTSub(ASTNode l, ASTNode r)
    {
        lhs = l; rhs = r;
    }

    @Override
    public void compile(CodeBlock c, Enviroment e) {
        lhs.compile(c, e);
        rhs.compile(c, e);
        c.emit("isub");
    }
}
