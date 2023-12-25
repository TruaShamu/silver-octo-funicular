import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/testcase.in"));
        PrintWriter pw = new PrintWriter("src/testcase.out");
        int N = Integer.parseInt(br.readLine());
        ExpressionRestructuring er = new ExpressionRestructuring();
        for (int i=0; i< N; i++) {
            pw.println(er.infixToPostfix(br.readLine()));
        }
        pw.close();
    }
}
