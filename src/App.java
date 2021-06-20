import java.io.IOException;
import java.util.Scanner;
/**
 * @author joao menezes
 */
public class App {
    private static Scanner sc;
    private static String word,invertWord,again;
    public static void main(String[] args) throws Exception {
        _init_();
    }

    public static void clear() throws InterruptedException, IOException {
        if (System.getProperty("os.name").contains("Windows")){
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        else{
            Runtime.getRuntime().exec("clear");
        }   
    }

    public static void option() throws InterruptedException, IOException {
        System.out.print("Try again? (y/n)");
        again = sc.next().substring(0,1).toLowerCase();
            if (again.equals("y")) {
                _init_();
            }else if(again.equals("n")){
                clear();
                System.exit(0);
            }else{
                option();
            }
    }

    public static void _init_() throws InterruptedException, IOException {
        sc = new Scanner(System.in);
        System.out.print("Input a word: ");
        word = sc.next();
        invertWord = new StringBuffer(word).reverse().toString();
        if (word.equals(invertWord)) {
            System.out.println(word+" is a palindrome");
            option();
        }else{
            System.out.println(word+" not is a palindrome -> "+invertWord.toUpperCase());
            option();
        }
    }
}