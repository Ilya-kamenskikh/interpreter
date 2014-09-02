import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;

public class EvalVisitor extends robotBaseVisitor<Integer> {
	Map<String, String> variableTable = new HashMap<String, String>();
	Map<String, String> constTable=new HashMap<String, String>();
	Map<String, String[][]> umatrixTable=new HashMap<String, String[][]>();
	Map<String, String[][]> smatrixTable=new HashMap<String, String[][]>();
	Map<String, boolean[][][]> cellTable=new HashMap<String, boolean[][][]>();
	Map<String, robotParser.FunctionContext> FuncTable=new HashMap<String, robotParser.FunctionContext>();
	FuncVisitor Res=new FuncVisitor();

	/** CONST UNSIGNED IDENT '<-' expression  */
	@Override
	public Integer visitConstAssignUnsigned(robotParser.ConstAssignUnsignedContext ctx)
	{
		String s=ctx.IDENT().getText();
		int value = visit(ctx.expression());
		if ((!variableTable.containsKey(s))&&(!constTable.containsKey(s))&&(!umatrixTable.containsKey(s))&&(!smatrixTable.containsKey(s)))
		{
			constTable.put(s,String.valueOf(value)+'u');
			Res.constTable.put(s,String.valueOf(value)+'u');
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
		int value = visit(ctx.expression());
		if ((!variableTable.containsKey(s))&&(!constTable.containsKey(s))&&(!umatrixTable.containsKey(s))&&(!smatrixTable.containsKey(s)))
		{
			constTable.put(s,String.valueOf(value));
			Res.constTable.put(s,String.valueOf(value));
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
		if ((!variableTable.containsKey(s))&&(!constTable.containsKey(s))&&(!umatrixTable.containsKey(s))&&(!smatrixTable.containsKey(s)))
		{
			variableTable.put(s,String.valueOf(0)+'u');
			Res.variableTable.put(s,String.valueOf(0)+'u');
		}
		else
			throw new RuntimeException("Error_3");
		return 0;
	}
	/**UNSIGNED IDENT'<-' expression*/
	@Override
	public Integer visitAssignUnsigned(robotParser.AssignUnsignedContext ctx)
	{
		String s=ctx.IDENT().getText();
		int value = visit(ctx.expression());
		if ((!variableTable.containsKey(s))&&(!constTable.containsKey(s))&&(!umatrixTable.containsKey(s))&&(!smatrixTable.containsKey(s))&&(value>=0))
		{
			variableTable.put(s,String.valueOf(value)+'u');
			Res.variableTable.put(s,String.valueOf(value)+'u');
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
		if ((!variableTable.containsKey(s))&&(!constTable.containsKey(s))&&(!umatrixTable.containsKey(s))&&(!smatrixTable.containsKey(s)))
		{
			variableTable.put(s,String.valueOf(0));
			Res.variableTable.put(s,String.valueOf(0));
		}
		else
			throw new RuntimeException("Error_5");
		return 0;
	}
	/**SIGNED IDENT'<-' expression	*/
	@Override
	public Integer visitAssignSigned(robotParser.AssignSignedContext ctx)
	{
		String s=ctx.IDENT().getText();
		int value = visit(ctx.expression());
		if ((!variableTable.containsKey(s))&&(!constTable.containsKey(s))&&(!umatrixTable.containsKey(s))&&(!smatrixTable.containsKey(s)))
		{
			variableTable.put(s,String.valueOf(value));
			Res.variableTable.put(s,String.valueOf(value));
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
		if ((!variableTable.containsKey(k))&&(!constTable.containsKey(k))&&(!umatrixTable.containsKey(k))&&(!smatrixTable.containsKey(k)))
		{
			umatrixTable.put(k,new String[left][right]);
			Res.umatrixTable.put(k,new String[left][right]);
		}
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
		if ((!variableTable.containsKey(k))&&(!constTable.containsKey(k))&&(!umatrixTable.containsKey(k))&&(!smatrixTable.containsKey(k)))
		{
			smatrixTable.put(k,new String[left][right]);
			Res.smatrixTable.put(k,new String[left][right]);
		}
		else
			throw new RuntimeException("Error_8");
		return 0;
	}
	/**IDENT '<-' expression*/
	@Override
	public Integer visitAssignId(robotParser.AssignIdContext ctx)
	{
		String s=ctx.IDENT().getText();
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
		int value = visit(ctx.expression(2));
		if(umatrixTable.containsKey(id))
		{
			if(value>=0)
			{
				umatrixTable.get(id)[x][y]=String.valueOf(value)+'u';
				Res.umatrixTable.get(id)[x][y]=String.valueOf(value)+'u';
			}
		}
		else
			if (smatrixTable.containsKey(id))
			{
				smatrixTable.get(id)[x][y]=String.valueOf(value);
				Res.smatrixTable.get(id)[x][y]=String.valueOf(value);
			}
			else
			{
				throw new RuntimeException("Error_10");
			}
		return value;
	}
	/**expression op=('+' | '-') expression */
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
	/**expression op=('<' | '>' | '=')expression */
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
	/** expression op=('*'|'/'|'%') expression */
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
			visit(ctx.block());
		return 0;
	}
	/** FUNC IDENT arg block */
	@Override
	public Integer visitFunction(robotParser.FunctionContext ctx)
	{
		String s=ctx.IDENT().getText();
		if(!FuncTable.containsKey(s))
		{
			FuncTable.put(s,ctx);
			visit(ctx.args());
		}
		return 0;
	}
	/** CALL IDENT '('(exprs)* ')' */
	@Override
	public Integer visitAccess(robotParser.AccessContext ctx)
	{
		String s=ctx.IDENT().getText();
		if(FuncTable.containsKey(s))
		{
			for (int i=0; i<Res.args.size();++i)
			{
				if(Res.variableTable.get(Res.args.get(i)).charAt(Res.variableTable.get(Res.args.get(i)).length()-1)=='u')
				{
					Res.variableTable.put(Res.args.get(i),String.valueOf(visit(ctx.expression(i)))+'u');
				}
				else
					Res.variableTable.put(Res.args.get(i),String.valueOf(visit(ctx.expression(i))));
			}
			Res.visit(FuncTable.get(s));
			if (Res.variableTable.containsKey(Res.Result))
				variableTable.put(s,Res.variableTable.get(Res.Result));
			else
				if (Res.constTable.containsKey(Res.Result))
					constTable.put(s,Res.constTable.get(Res.Result));
				else
					if (Res.umatrixTable.containsKey(Res.Result))
						umatrixTable.put(s,Res.umatrixTable.get(Res.Result));
					else
						if (Res.smatrixTable.containsKey(Res.Result))
							smatrixTable.put(s,Res.smatrixTable.get(Res.Result));
						else 
							if(Res.cellTable.containsKey(Res.Result))
								cellTable.put(s,Res.cellTable.get(Res.Result));


		}
		return 0;
	}
	/**'('(type=(UNSIGNED|SIGNED)IDENT)* ')';*/
	@Override
	public Integer visitArg(robotParser.ArgContext ctx)
	{
		String s=ctx.IDENT().getText();
		if (s!=null)
			if (ctx.type.getType()==robotParser.UNSIGNED)
			{
				Res.variableTable.put(s,"0u");
				Res.args.add(s);
			}
			else
			{
				Res.variableTable.put(s,"0");
				Res.args.add(s);
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
		if (!cellTable.containsKey(s))
		{
			cellTable.put(s,new boolean[left][right][4]);
			Res.cellTable.put(s,new boolean[left][right][4]);
		}
		else
			throw new RuntimeException("Error_00");
		return 0;
	}
	/** IDENT '('expression','expression')' '<-' '('u=(TOP|NTOP)','r=(RIGHT|NRIGHT)','d=(DOWN|NDOWN)','l=(LEFT|NLEFT)')'*/
	@Override
	public Integer visitAssignWorld(robotParser.AssignWorldContext ctx)
	{
		int left=visit(ctx.expression(0));
		int right=visit(ctx.expression(1));
		String id=ctx.IDENT().getText();
		if (cellTable.containsKey(id))
		{
			if (ctx.u.getType()==robotParser.TOP)
			{
				cellTable.get(id)[left][right][0]=true;
				Res.cellTable.get(id)[left][right][0]=true;
			}
			else
				if(ctx.u.getType()==robotParser.NTOP)
				{
					cellTable.get(id)[left][right][0]=false;
					Res.cellTable.get(id)[left][right][0]=false;
				}
			if (ctx.r.getType()==robotParser.RIGHT)
			{
				cellTable.get(id)[left][right][1]=true;
				Res.cellTable.get(id)[left][right][1]=true;
			}
			else
				if(ctx.r.getType()==robotParser.NRIGHT)
				{
					cellTable.get(id)[left][right][1]=false;
					Res.cellTable.get(id)[left][right][1]=false;
				}
			if (ctx.d.getType()==robotParser.DOWN)
			{
				cellTable.get(id)[left][right][2]=true;
				Res.cellTable.get(id)[left][right][2]=true;
			}
			else
				if(ctx.d.getType()==robotParser.NDOWN)
				{
					cellTable.get(id)[left][right][2]=false;
					Res.cellTable.get(id)[left][right][2]=false;
				}
			if (ctx.l.getType()==robotParser.LEFT)
			{
				cellTable.get(id)[left][right][3]=true;
				Res.cellTable.get(id)[left][right][3]=true;
			}
			else
				if(ctx.l.getType()==robotParser.NLEFT)
				{
					cellTable.get(id)[left][right][3]=false;
					Res.cellTable.get(id)[left][right][3]=false;
				}
		}
		return 0;
	}
	/**'mapping' IDENT '('expression','expression')'*/
	@Override
	public Integer visitPrint(robotParser.PrintContext ctx){
		int z=visit(ctx.expression(0));
		int w=visit(ctx.expression(1));
		int i=z,j=w;
		String s=ctx.IDENT().getText();
		if (smatrixTable.containsKey(s))
		{
			while(Integer.parseInt(smatrixTable.get(s)[i][j])!=0)
			{
				if(i<5)
				{
					if((Integer.parseInt(smatrixTable.get(s)[i+1][j])==(Integer.parseInt(smatrixTable.get(s)[i][j])-1))&&(cellTable.get("world")[i][j][2]==false))
					{
						
							System.out.println("Ход вверх "+"("+i+","+j+")");
							i=i+1;
							continue;
						
					}
				}
				if(i>0)
				{
					if((Integer.parseInt(smatrixTable.get(s)[i-1][j])==(Integer.parseInt(smatrixTable.get(s)[i][j])-1))&&(cellTable.get("world")[i][j][0]==false))
					{
						
							System.out.println("Ход вниз "+"("+i+","+j+")");
							i=i-1;
							continue;
						
					}
				}
				if(j<5)
				{
					if((Integer.parseInt(smatrixTable.get(s)[i][j+1])==(Integer.parseInt(smatrixTable.get(s)[i][j])-1))&&(cellTable.get("world")[i][j][1]==false))
					{
							System.out.println("Ход налево "+"("+i+","+j+")");
							j=j+1;
							continue;
					}
				}
				if(j>0)
				{
					if((Integer.parseInt(smatrixTable.get(s)[i][j-1])==(Integer.parseInt(smatrixTable.get(s)[i][j])-1))&&(cellTable.get("world")[i][j][3]==false))
					{
							System.out.println("Ход направо "+"("+i+","+j+")");
							j=j-1;
							continue;
					}
				}
			}
			System.out.println("Начало "+"("+i+","+j+")");
		}
		else 
			System.out.print("error");
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
	/** 'mapping' IDENT '('expression','expression')'*/
	@Override
	public Integer visitDrawing(robotParser.DrawingContext ctx)
	{
		int left=visit(ctx.expression(0));
		int right=visit(ctx.expression(1));
		String id=ctx.IDENT().getText();
		if (cellTable.containsKey(id))
		{
			for(int i=0;i<right;++i)
				if (cellTable.get(id)[0][i][0])
					System.out.print("_ ");
				else 
					System.out.print("  ");
			System.out.print("\n");
			for(int i=0;i<left;++i)
			{
				for (int j=0;j<right;++j)
				{
					if (cellTable.get(id)[i][j][2])
						System.out.print("_");
					else
						System.out.print(" ");
					if (cellTable.get(id)[i][j][1])
						System.out.print("|");
					else
						System.out.print(" ");
				}
				System.out.print("\n");
			}
		}
		return 0;
	}

}