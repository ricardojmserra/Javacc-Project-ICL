public class ASTNum implements ASTNode {

int val;

        public IValue eval(Enviroment e) throws ParseException {
            return new VInt(val);
        }

        public ASTNum(int n)
        {
	   val = n;
        }

    @Override
    public void compile(CodeBlock c, Enviroment e) {
        c.emit("ipush " + val);
    }
}

