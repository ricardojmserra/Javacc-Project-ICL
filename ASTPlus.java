public class ASTPlus implements ASTNode {
    ASTNode lhs, rhs;
    public IValue eval(Enviroment e)throws ParseException   //Este typechecking devia de ser feito no "typechecking" também
    {
        IValue left = lhs.eval(e);
        left = left instanceof VCell ? ((VCell) left).value : left;
        IValue right = rhs.eval(e);
        right = right instanceof VCell ? ((VCell) right).value : right;
        if(left instanceof VInt LEFT && right instanceof VInt RIGHT)
            return new VInt(LEFT.value + RIGHT.value);          //soma de valores
        else if(left instanceof VString LEFT && !(right instanceof VNull))
            return new VString(LEFT.value + right.toString());  //concat
        else if(right instanceof VString RIGHT && !(left instanceof VNull))
            return new VString(RIGHT.value + left.toString());  //concat

        throw new ParseException("Invalid use of + operator");
    }

    @Override
    public void compile(CodeBlock c, Enviroment e) {
        lhs.compile(c, e);
        rhs.compile(c, e);
        c.emit("iadd");
    }

    public ASTPlus(ASTNode l, ASTNode r)
        {
		lhs = l; rhs = r;
        }
}

