import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;
class Interpreter {
	public static void main(String[] args) throws Exception{
		try{
			String inputFile = null;
			if ( args.length>0 ) inputFile = args[0];
			InputStream is = System.in;
			if( inputFile!=null ) is =new FileInputStream(inputFile);
			ANTLRInputStream input =new ANTLRInputStream(is);
			robotLexer lexer = new robotLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			robotParser parser = new robotParser(tokens);
			parser.setBuildParseTree(true);
			ParseTree tree = parser.prog();
			EvalVisitor eval =new EvalVisitor();
			eval.visit(tree);
		}catch(RuntimeException r)
		{

		}
	}
}
