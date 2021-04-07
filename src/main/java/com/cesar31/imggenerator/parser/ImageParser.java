
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.cesar31.imggenerator.parser;

import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.Symbol;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class ImageParser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return ImageParserSym.class;
}

  /** Default constructor. */
  @Deprecated
  public ImageParser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public ImageParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public ImageParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\024\000\002\002\003\000\002\002\004\000\002\002" +
    "\003\000\002\002\003\000\002\003\003\000\002\003\004" +
    "\000\002\004\006\000\002\005\003\000\002\005\004\000" +
    "\002\006\006\000\002\007\003\000\002\007\004\000\002" +
    "\010\006\000\002\014\003\000\002\014\002\000\002\013" +
    "\003\000\002\013\005\000\002\011\003\000\002\011\004" +
    "\000\002\012\006" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\045\000\006\011\005\013\004\001\002\000\004\010" +
    "\046\001\002\000\004\004\043\001\002\000\006\002\ufff7" +
    "\013\ufff7\001\002\000\006\002\ufff0\011\ufff0\001\002\000" +
    "\004\002\042\001\002\000\006\002\001\013\027\001\002" +
    "\000\006\002\ufffd\013\ufffd\001\002\000\006\002\ufffe\011" +
    "\005\001\002\000\006\002\uffff\013\015\001\002\000\004" +
    "\010\017\001\002\000\006\002\ufff6\013\ufff6\001\002\000" +
    "\006\007\ufff3\013\020\001\002\000\010\005\ufff2\006\ufff2" +
    "\007\ufff2\001\002\000\004\007\025\001\002\000\010\005" +
    "\023\006\ufff4\007\ufff4\001\002\000\004\013\024\001\002" +
    "\000\010\005\ufff1\006\ufff1\007\ufff1\001\002\000\006\002" +
    "\ufff5\013\ufff5\001\002\000\006\002\uffef\011\uffef\001\002" +
    "\000\004\010\031\001\002\000\006\002\ufffc\013\ufffc\001" +
    "\002\000\004\013\020\001\002\000\006\007\ufffa\013\ufffa" +
    "\001\002\000\006\007\041\013\020\001\002\000\004\005" +
    "\035\001\002\000\006\012\036\013\024\001\002\000\004" +
    "\006\037\001\002\000\006\007\ufff8\013\ufff8\001\002\000" +
    "\006\007\ufff9\013\ufff9\001\002\000\006\002\ufffb\013\ufffb" +
    "\001\002\000\004\002\000\001\002\000\006\006\ufff3\013" +
    "\020\001\002\000\004\006\045\001\002\000\006\002\uffee" +
    "\011\uffee\001\002\000\006\007\ufff3\013\020\001\002\000" +
    "\006\005\035\007\ufff4\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\045\000\020\002\007\003\010\004\011\007\013\010" +
    "\005\011\012\012\006\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\004\027\001\001\000\002\001\001\000\004" +
    "\012\025\001\001\000\004\010\015\001\001\000\002\001" +
    "\001\000\002\001\001\000\006\013\021\014\020\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\010\005" +
    "\032\006\031\013\033\001\001\000\002\001\001\000\006" +
    "\006\037\013\033\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\006\013\021\014" +
    "\043\001\001\000\002\001\001\000\002\001\001\000\012" +
    "\005\032\006\031\013\046\014\020\001\001\000\002\001" +
    "\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$ImageParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$ImageParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$ImageParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




	public ImageParser(ImageLex lex) {
		super(lex);
	}

	public void syntax_error(Symbol cur_token) {
        System.out.printf("syntax_error: Linea: %d, columna: %d, sym: %s, nombre: %s, value: \"%s\", parse_state: %d\n", cur_token.left, cur_token.right, cur_token.sym, symbl_name_from_id(cur_token.sym), cur_token.value, cur_token.parse_state);
        List<Integer> tokens = expected_token_ids();
        System.out.print("Se esperaba ->");
        for(Integer i : tokens) {
			System.out.printf("%s, ", symbl_name_from_id(i));
        }
        System.out.println("");
	}



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$ImageParser$actions {
  private final ImageParser parser;

  /** Constructor */
  CUP$ImageParser$actions(ImageParser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$ImageParser$do_action_part00000000(
    int                        CUP$ImageParser$act_num,
    java_cup.runtime.lr_parser CUP$ImageParser$parser,
    java.util.Stack            CUP$ImageParser$stack,
    int                        CUP$ImageParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$ImageParser$result;

      /* select the action based on the action number */
      switch (CUP$ImageParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // data ::= make_layers 
            {
              Object RESULT =null;
		 System.out.println("capas"); 
              CUP$ImageParser$result = parser.getSymbolFactory().newSymbol("data",0, ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), RESULT);
            }
          return CUP$ImageParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= data EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-1)).value;
		RESULT = start_val;
              CUP$ImageParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-1)), ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$ImageParser$parser.done_parsing();
          return CUP$ImageParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // data ::= make_images 
            {
              Object RESULT =null;
		 System.out.println("imagenes"); 
              CUP$ImageParser$result = parser.getSymbolFactory().newSymbol("data",0, ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), RESULT);
            }
          return CUP$ImageParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // data ::= make_users 
            {
              Object RESULT =null;
		 System.out.println("usuarios"); 
              CUP$ImageParser$result = parser.getSymbolFactory().newSymbol("data",0, ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), RESULT);
            }
          return CUP$ImageParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // make_layers ::= layer 
            {
              Object RESULT =null;

              CUP$ImageParser$result = parser.getSymbolFactory().newSymbol("make_layers",1, ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), RESULT);
            }
          return CUP$ImageParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // make_layers ::= make_layers layer 
            {
              Object RESULT =null;

              CUP$ImageParser$result = parser.getSymbolFactory().newSymbol("make_layers",1, ((java_cup.runtime.Symbol)CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-1)), ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), RESULT);
            }
          return CUP$ImageParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // layer ::= INTEGER LBRACE make_cells RBRACE 
            {
              Object RESULT =null;

              CUP$ImageParser$result = parser.getSymbolFactory().newSymbol("layer",2, ((java_cup.runtime.Symbol)CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-3)), ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), RESULT);
            }
          return CUP$ImageParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // make_cells ::= cell 
            {
              Object RESULT =null;

              CUP$ImageParser$result = parser.getSymbolFactory().newSymbol("make_cells",3, ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), RESULT);
            }
          return CUP$ImageParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // make_cells ::= make_cells cell 
            {
              Object RESULT =null;

              CUP$ImageParser$result = parser.getSymbolFactory().newSymbol("make_cells",3, ((java_cup.runtime.Symbol)CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-1)), ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), RESULT);
            }
          return CUP$ImageParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // cell ::= make_numbers COMMA COLOR SEMI_COLON 
            {
              Object RESULT =null;
		int listleft = ((java_cup.runtime.Symbol)CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-3)).left;
		int listright = ((java_cup.runtime.Symbol)CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-3)).right;
		List<Integer> list = (List<Integer>)((java_cup.runtime.Symbol) CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-3)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-1)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-1)).right;
		String s = (String)((java_cup.runtime.Symbol) CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-1)).value;
		
			System.out.printf("Fila: %d Columna: %d Color: %s\n", list.get(0), list.get(1), s);
		
              CUP$ImageParser$result = parser.getSymbolFactory().newSymbol("cell",4, ((java_cup.runtime.Symbol)CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-3)), ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), RESULT);
            }
          return CUP$ImageParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // make_images ::= image 
            {
              Object RESULT =null;

              CUP$ImageParser$result = parser.getSymbolFactory().newSymbol("make_images",5, ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), RESULT);
            }
          return CUP$ImageParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // make_images ::= make_images image 
            {
              Object RESULT =null;

              CUP$ImageParser$result = parser.getSymbolFactory().newSymbol("make_images",5, ((java_cup.runtime.Symbol)CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-1)), ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), RESULT);
            }
          return CUP$ImageParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // image ::= INTEGER LBRACE ids RBRACE 
            {
              Object RESULT =null;

              CUP$ImageParser$result = parser.getSymbolFactory().newSymbol("image",6, ((java_cup.runtime.Symbol)CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-3)), ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), RESULT);
            }
          return CUP$ImageParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // ids ::= make_numbers 
            {
              List<Integer> RESULT =null;
		int listleft = ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()).left;
		int listright = ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()).right;
		List<Integer> list = (List<Integer>)((java_cup.runtime.Symbol) CUP$ImageParser$stack.peek()).value;
		
			RESULT = list;
		
              CUP$ImageParser$result = parser.getSymbolFactory().newSymbol("ids",10, ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), RESULT);
            }
          return CUP$ImageParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // ids ::= 
            {
              List<Integer> RESULT =null;

              CUP$ImageParser$result = parser.getSymbolFactory().newSymbol("ids",10, ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), RESULT);
            }
          return CUP$ImageParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // make_numbers ::= INTEGER 
            {
              List<Integer> RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()).right;
		Integer n = (Integer)((java_cup.runtime.Symbol) CUP$ImageParser$stack.peek()).value;
		
			List<Integer> numbers = new ArrayList<>();
			numbers.add(n);
			RESULT = numbers;
		
              CUP$ImageParser$result = parser.getSymbolFactory().newSymbol("make_numbers",9, ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), RESULT);
            }
          return CUP$ImageParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // make_numbers ::= make_numbers COMMA INTEGER 
            {
              List<Integer> RESULT =null;
		int listleft = ((java_cup.runtime.Symbol)CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-2)).left;
		int listright = ((java_cup.runtime.Symbol)CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-2)).right;
		List<Integer> list = (List<Integer>)((java_cup.runtime.Symbol) CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-2)).value;
		int nleft = ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()).right;
		Integer n = (Integer)((java_cup.runtime.Symbol) CUP$ImageParser$stack.peek()).value;
		
			list.add(n);
			RESULT = list;
		
              CUP$ImageParser$result = parser.getSymbolFactory().newSymbol("make_numbers",9, ((java_cup.runtime.Symbol)CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-2)), ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), RESULT);
            }
          return CUP$ImageParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // make_users ::= user 
            {
              Object RESULT =null;

              CUP$ImageParser$result = parser.getSymbolFactory().newSymbol("make_users",7, ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), RESULT);
            }
          return CUP$ImageParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // make_users ::= make_users user 
            {
              Object RESULT =null;

              CUP$ImageParser$result = parser.getSymbolFactory().newSymbol("make_users",7, ((java_cup.runtime.Symbol)CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-1)), ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), RESULT);
            }
          return CUP$ImageParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // user ::= USER_NAME COLON ids SEMI_COLON 
            {
              Object RESULT =null;

              CUP$ImageParser$result = parser.getSymbolFactory().newSymbol("user",8, ((java_cup.runtime.Symbol)CUP$ImageParser$stack.elementAt(CUP$ImageParser$top-3)), ((java_cup.runtime.Symbol)CUP$ImageParser$stack.peek()), RESULT);
            }
          return CUP$ImageParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$ImageParser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$ImageParser$do_action(
    int                        CUP$ImageParser$act_num,
    java_cup.runtime.lr_parser CUP$ImageParser$parser,
    java.util.Stack            CUP$ImageParser$stack,
    int                        CUP$ImageParser$top)
    throws java.lang.Exception
    {
              return CUP$ImageParser$do_action_part00000000(
                               CUP$ImageParser$act_num,
                               CUP$ImageParser$parser,
                               CUP$ImageParser$stack,
                               CUP$ImageParser$top);
    }
}

}
