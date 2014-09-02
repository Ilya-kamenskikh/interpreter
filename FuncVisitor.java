import java.util.*;
import org.antlr.v4.runtime.tree.*;

public class FuncVisitor extends robotBaseVisitor<Integer>{
	Map<String, String> variableTable = new HashMap<String, String>();
	Map<String, String> constTable=new HashMap<String, String>();
	Map<String, String[][]> umatrixTable=new HashMap<String, String[][]>();
	Map<String, String[][]> smatrixTable=new HashMap<String, String[][]>();
	Map<String, boolean[][][]> cellTable=new HashMap<String, boolean[][][]>();
	List<String> args=new ArrayList<String>();
	String Result=new String();

	/** CONST UNSIGNED IDENT '<-' expression  */
	@Override
	public Integer visitConstAssignUnsigned(robotParser.ConstAssignUnsignedContext ctx)
	{
		String s=ctx.IDENT().getText();
		Result=s;
		int value = visit(ctx.expression());
		if ((!variableTable.containsKey(s))&&(!constTable.containsKey(s))&&(!umatrixTable.containsKey(s))&&(!smatrixTable.containsKey(s)))
		{
			constTable.put(s,String.valueOf(value)+'u');
			return value;
		}
		else
			throw new RuntimeException("Error_1");
	}
	/**CONST SIGNED IDENT '<-' expression*/
	@Override
	public Integer visitConstAssignSigned(robotParser.ConstAssignSignedContext ctx)
	{
		String s=ctx.IDENT().getText();
		Result=s;
		int value = visit(ctx.expression());
		if ((!variableTable.containsKey(s))&&(!constTable.containsKey(s))&&(!umatrixTable.containsKey(s))&&(!smatrixTable.containsKey(s)))
		{
			constTable.put(s,String.valueOf(value));
			return value;
		}
		else
			throw new RuntimeException("Error_2");
	}
	/**UNSIGNED IDENT*/
	@Override
	public Integer visitAssignUnsignedId(robotParser.AssignUnsignedIdContext ctx)
	{
		String s=ctx.IDENT().getText();
		Result=s;
		if ((!variableTable.containsKey(s))&&(!constTable.containsKey(s))&&(!umatrixTable.containsKey(s))&&(!smatrixTable.containsKey(s)))
			variableTable.put(s,String.valueOf(0)+'u');
		else
			throw new RuntimeException("Error_3");
		return 0;
	}
	/**UNSIGNED IDENT'<-' expression*/
	@Override
	public Integer visitAssignUnsigned(robotParser.AssignUnsignedContext ctx)
	{
		String s=ctx.IDENT().getText();
		Result=s;
		int value = visit(ctx.expression());
		if ((!variableTable.containsKey(s))&&(!constTable.containsKey(s))&&(!umatrixTable.containsKey(s))&&(!smatrixTable.containsKey(s))&&(value>=0))
		{
			variableTable.put(s,String.valueOf(value)+'u');
			return value;
		}
		else
			throw new RuntimeException("Error_4");
	}
	/**SIGNED IDENT*/
	@Override
	public Integer visitAssignSignedId(robotParser.AssignSignedIdContext ctx)
	{
		String s=ctx.IDENT().getText();
		Result=s;
		if ((!variableTable.containsKey(s))&&(!constTable.containsKey(s))&&(!umatrixTable.containsKey(s))&&(!smatrixTable.containsKey(s)))
			variableTable.put(s,String.valueOf(0));
		else
			throw new RuntimeException("Error_5");
		return 0;
	}
	/**SIGNED IDENT'<-' expression	*/
	@Override
	public Integer visitAssignSigned(robotParser.AssignSignedContext ctx)
	{
		String s=ctx.IDENT().getText();
		Result=s;
		int value = visit(ctx.expression());
		if ((!variableTable.containsKey(s))&&(!constTable.containsKey(s))&&(!umatrixTable.containsKey(s))&&(!smatrixTable.containsKey(s)))
		{
			variableTable.put(s,String.valueOf(value));
			return value;
		}
		else
			throw new RuntimeException("Error_6");
	}
	/**MATRIX UNSIGNED IDENT '('expression','expression')'*/
	@Override
	public Integer visitDeclMatUnsigned(robotParser.DeclMatUnsignedContext ctx)
	{
		int left=visit(ctx.expression(0));
		int right=visit(ctx.expression(1));
		String k=ctx.IDENT().getText();
		Result=k;
		if ((!variableTable.containsKey(k))&&(!constTable.containsKey(k))&&(!umatrixTable.containsKey(k))&&(!smatrixTable.containsKey(k)))
			umatrixTable.put(k,new String[left][right]);
		else 
			throw new RuntimeException("Error_7");
		return 0;
	}
	/**MATRIX SIGNED IDENT	'('expression','expression')'*/
	@Override
	public Integer visitDeclMatSigned(robotParser.DeclMatSignedContext ctx)
	{
		int left=visit(ctx.expression(0));
		int right=visit(ctx.expression(1));
		String k=ctx.IDENT().getText();
		Result=k;
		if ((!variableTable.containsKey(k))&&(!constTable.containsKey(k))&&(!umatrixTable.containsKey(k))&&(!smatrixTable.containsKey(k)))
			smatrixTable.put(k,new String[left][right]);
		else
			throw new RuntimeException("Error_8");
		return 0;
	}
	/**IDENT '<-' expression*/
	@Override
	public Integer visitAssignId(robotParser.AssignIdContext ctx)
	{
		String s=ctx.IDENT().getText();
		Result=s;
		int value = visit(ctx.expression());
		if(variableTable.containsKey(s))
		{
			if (variableTable.get(s).charAt(variableTable.get(s).length()-1)=='u')
			{
				variableTable.put(s,String.valueOf(value)+'u');
			}
			else
			{
				variableTable.put(s,String.valueOf(value));
			}
		}
		else
			throw new RuntimeException("Error_9");
		return value;
	}
	/**IDENT '('expression','expression')' '<-' expression*/
	@Override
	public Integer visitAssignMatrix(robotParser.AssignMatrixContext ctx)
	{
		int x=visit(ctx.expression(0));
		int y=visit(ctx.expression(1));
		String id=ctx.IDENT().getText();
		Result=id;
		int value = visit(ctx.expression(2));
		if(umatrixTable.containsKey(id))
		{
			if(value>=0)
			{
				umatrixTable.get(id)[x][y]=String.valueOf(value)+'u';
			}
		}
		else
			if (smatrixTable.containsKey(id))
			{
				smatrixTable.get(id)[x][y]=String.valueOf(value);
			}
			else
			{
				throw new RuntimeException("Error_10");
			}
		return value;
	}
	/**bool ( op=('+' | '-')bool)* */
	@Override
	public Integer visitAddSub(robotParser.AddSubContext ctx)
	{
		int left=visit(ctx.expression(0));
		int right=visit(ctx.expression(1));
		if (ctx.op.getType()==robotParser.SUB) 
			return left-right;
		else
			return left+right;
	}
	/**mult ( op=('<' | '>' | '=')mult)* */
	@Override
	public Integer visitBool(robotParser.BoolContext ctx)
	{
		int left=visit(ctx.expression(0));
		int right=visit(ctx.expression(1));
		if (ctx.op.getType()==robotParser.MORE)
			if(left > right) 
				return 1;
			else 
				return 0;
		else
			if (ctx.op.getType()==robotParser.EQUALLY)
				if (left==right)
					return 1;
				else 
					return 0;
			else 
				if (left<right)
					return 1;
				else
					return 0;
	}
	/** atom ( op=('*'|'/'|'%') atom)* */
	@Override
	public Integer visitMult(robotParser.MultContext ctx)
	{
		int left=visit(ctx.expression(0));
		int right=visit(ctx.expression(1));
		if (ctx.op.getType()==robotParser.MUL) 
			return left*right;
		else
			if (ctx.op.getType()==robotParser.DIV)
				return left/right;
			else
				return left % right;
	}
	/** IDENT */
	@Override
	public Integer visitId(robotParser.IdContext ctx)
	{
		String id=ctx.IDENT().getText();
		if(variableTable.containsKey(id))
		{
			if (variableTable.get(id).charAt(variableTable.get(id).length()-1)=='u')
			{
				String n=variableTable.get(id);
				return Integer.parseInt(n.substring(0,n.length()-1));
			}
			else
			{
				String n=variableTable.get(id);
				return Integer.parseInt(n);
			}
		}
		else
		{
			if(constTable.containsKey(id))
			{
				if (constTable.get(id).charAt(constTable.get(id).length()-1)=='u')
				{
					String n=constTable.get(id);
					return Integer.parseInt(n.substring(0,n.length()-1));
				}
				else
				{
					String n=constTable.get(id);
					return Integer.parseInt(n);
				}
			}
			else
				throw new RuntimeException("Error_11");
		}
	}
	/** UNUMBER */
	@Override
	public Integer visitUnsignedNumber(robotParser.UnsignedNumberContext ctx)
	{
		String s=ctx.UNUMBER().getText();
		return Integer.parseInt(s.substring(0,s.length()-1));
	}
	/** SNUMBER */
	@Override
	public Integer visitSignedNumber(robotParser.SignedNumberContext ctx)
	{
		String s=ctx.SNUMBER().getText();
		return Integer.parseInt(s);
	}
	/** IDENT '('expression','expression')' */
	@Override
	public Integer visitIdMatrix(robotParser.IdMatrixContext ctx)
	{
		int left=visit(ctx.expression(0));
		int right=visit(ctx.expression(1));
		String id=ctx.IDENT().getText();
		if(umatrixTable.containsKey(id))
		{
			if(umatrixTable.get(id)[left][right]!=null)
			{
				String p=umatrixTable.get(id)[left][right];
				return Integer.parseInt(p.substring(0,p.length()-1));
			}
		}
		else
			if(smatrixTable.containsKey(id))
			{
				if(smatrixTable.get(id)[left][right]!=null)
				{
					String c=smatrixTable.get(id)[left][right];
					return Integer.parseInt(c);
				}
			}
			else
				throw new RuntimeException("Error_12");
			return 0;
	}
	/**'(' expression ')' */
	@Override
	public Integer visitParens(robotParser.ParensContext ctx)
	{
		return visit(ctx.expression());
	}
	/** TESTREP '('expression')' block */
	@Override
	public Integer visitCondition(robotParser.ConditionContext ctx)
	{
		if(visit(ctx.expression())!=0)
			visit(ctx.block());
		return 0;
	}
	/** TESTONCE '('expression')' block */
	@Override
	public Integer visitCycle(robotParser.CycleContext ctx)
	{
		while (visit(ctx.expression())!=0)
		{
			visit(ctx.block());
		}
		return 0;
	}
	
	/**MATRIX CELL IDENT '('expression','expression')'*/
	@Override
	public Integer visitWorld(robotParser.WorldContext ctx)
	{
		int left=visit(ctx.expression(0));
		int right=visit(ctx.expression(1));
		String s=ctx.IDENT().getText();
		Result=s;
		if (!cellTable.containsKey(s))
		{
			cellTable.put(s,new boolean[left][right][4]);
		}
		return 0;
	}
	/**IDENT '('expression','expression')''['expression']'*/
	@Override
	public Integer visitIdWorld(robotParser.IdWorldContext ctx)
	{
		int x=visit(ctx.expression(0));
		int y=visit(ctx.expression(1));
		int z=visit(ctx.expression(2));
		String id=ctx.IDENT().getText();
		if(cellTable.containsKey(id))
		{
			if(cellTable.get(id)[x][y][z])
				return 1;
			else 
				return 0;
		}
		else
			throw new RuntimeException("Error_14");
	}
}