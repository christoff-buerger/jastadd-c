
package jastaddc.semantics.ast;


public class ASTNode$State extends java.lang.Object {
    // Declared in ASTNode at line 2

  public boolean IN_CIRCLE = false;

    // Declared in ASTNode at line 3

  public int CIRCLE_INDEX;

    // Declared in ASTNode at line 4

  public boolean CHANGE = false;

    // Declared in ASTNode at line 5

  public boolean LAST_CYCLE = false;

    // Declared in ASTNode at line 6

  public boolean RESET_CYCLE = false;

    // Declared in ASTNode at line 7

  public static final int REWRITE_CHANGE = 1;

    // Declared in ASTNode at line 8

  public static final int REWRITE_NOCHANGE = 2;

    // Declared in ASTNode at line 9

  public static final int REWRITE_INTERRUPT = 3;

    // Declared in ASTNode at line 10

  public int boundariesCrossed = 0;

    // Declared in ASTNode at line 12


   private int[] stack;

    // Declared in ASTNode at line 13

   private int pos;

    // Declared in ASTNode at line 14

   public ASTNode$State() {
     stack = new int[64];
     pos = 0;
   }

    // Declared in ASTNode at line 18

   private void ensureSize(int size) {
     if(size < stack.length)
       return;
     int[] newStack = new int[stack.length * 2];
     System.arraycopy(stack, 0, newStack, 0, stack.length);
     stack = newStack;
   }

    // Declared in ASTNode at line 25

   public void push(int i) {
     ensureSize(pos+1);
     stack[pos++] = i;
   }

    // Declared in ASTNode at line 29

   public int pop() {
     return stack[--pos];
   }

    // Declared in ASTNode at line 32

   public int peek() {
     return stack[pos-1];
   }

    // Declared in ASTNode.ast at line 128

    protected int duringEnumerations = 0;

    // Declared in ASTNode.ast at line 139

    protected int duringMapping = 0;

    // Declared in ASTNode.ast at line 150

    protected int duringErrorHandlingInitialization = 0;

    // Declared in ASTNode.ast at line 161

    public void reset() {
        IN_CIRCLE = false;
        CIRCLE_INDEX = 0;
        CHANGE = false;
        LAST_CYCLE = false;
        boundariesCrossed = 0;
        if(duringEnumerations != 0) {
            System.out.println("Warning: resetting duringEnumerations");
            duringEnumerations = 0;
        }
        if(duringMapping != 0) {
            System.out.println("Warning: resetting duringMapping");
            duringMapping = 0;
        }
        if(duringErrorHandlingInitialization != 0) {
            System.out.println("Warning: resetting duringErrorHandlingInitialization");
            duringErrorHandlingInitialization = 0;
        }
    }


}
