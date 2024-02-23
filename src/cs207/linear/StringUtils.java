package cs207.linear;
import java.io.PrintWriter;

/**
 * Assorted utilities for working with strings.
 *
 * @author Samuel A. Rebelsky
 * @author Arsal Shaikh
 * @author Pranav Bhandari
 */
public class StringUtils {
  // +------------------+--------------------------------------------
  // | Provided methods |
  // +------------------+
    static char BRACKETS_OPEN[] = {'(', '{', '[', '<'}; 
    static char BRACKETS_CLOSED[] = {')', '}', ']', '>'}; 
   
   // Check if contained in array and returns index. -1 is not contained
   public static int indexOfContains(char[] arr, char val) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == val) {
            return i;
        }
    }
    return -1;
   }
   
   
    /*
   * Determine whether the parens match in string.
   */
  public static boolean checkMatching(String str) throws Exception {
    Stack<Character> parens = new LinkedStack<Character>();
    
    for (int i = 0; i < str.length(); i++) {
        char currentChar = str.charAt(i);
        // Check if open bracket
        if (indexOfContains(BRACKETS_OPEN, currentChar) != -1) {
            try {
                parens.put(currentChar);
            } catch (Exception e) {
                System.err.println("Could not put to stack");
            }
            continue;
        } // if()

        if (indexOfContains(BRACKETS_CLOSED, currentChar) != -1) {
            if (parens.isEmpty()) {
                System.err.println("Closed Bracket is mismatched - 1");
                return false;
            } // if()
            
            if (indexOfContains(BRACKETS_CLOSED, currentChar) == indexOfContains(BRACKETS_OPEN, parens.peek())) {
                parens.pop();
            } else {
                System.err.println("Closed Bracket is mismatched - 2");
                return false;
            }
        }
        // Check if closed bracket
            // if stack empty then error
            // check with peak 
                // if matches then pop from stack then continue
                // not match => throw error
    }

    // if array not empty then throw error
    if (parens.isEmpty()) {
        return true;
    }
    
    System.err.println("Open Bracket is mismatched");
    return false;
    // STUB
  } // checkMatching

  // +-------------+-------------------------------------------------
  // | Experiments |
  // +-------------+
  /**
   * A quick set of experiments with checkMatching.
   */
  static void checkMatchingExperiments(PrintWriter pen) {
    checkMatchingExperiment(pen, "");
    checkMatchingExperiment(pen, "()");
    checkMatchingExperiment(pen, "(");
    checkMatchingExperiment(pen, ")");
    checkMatchingExperiment(pen, "[]()");
    checkMatchingExperiment(pen, "[()([])]");
    checkMatchingExperiment(pen, "[a(b]c)");
    checkMatchingExperiment(pen, "Hello (there) (world (!!))");
    checkMatchingExperiment(pen, "alphabetical");
    checkMatchingExperiment(pen, "((((((((a))))))))");
    checkMatchingExperiment(pen, "((((((((a)))))]))");
    checkMatchingExperiment(pen, "(([((((((a)))))]))");
    checkMatchingExperiment(pen, "(([((((((a))))))])");
    checkMatchingExperiment(pen, "((((b)(((((a)(c)))(d))))))");
    // Feel free to add your own
  } // PrintWriter()

  /**
   * A single experiment with checkMatching.
   */
  static void checkMatchingExperiment(PrintWriter pen, String str) {
    pen.print("checkMatching(\"" + str + "\") = ");
    pen.flush();
    try {
      pen.println(checkMatching(str));
    } catch (Exception e) {
      pen.println("*** ERROR *** " + e.toString());
    }
  } // checkMatchingExperiment(PrintWriter, String)

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run a few experiments.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    checkMatchingExperiments(pen);
    pen.close();
  } // main(String[])
} // class StringUtils