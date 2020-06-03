import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KnuthMorrisPratt {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    // Find all the occurrences of the pattern in the text and return
    // a list of all positions in the text (starting from 0) where
    // the pattern starts in the text.
    public List<Integer> findPattern(String pattern, String text) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int prefix[] = prefix(pattern.concat("$").concat(text));
        int patternLength = pattern.length();
        for(int i=0;i<text.length();i++){
            int j = i + patternLength + 1;
            if(prefix[j] == patternLength)
                result.add((j - (2 * patternLength)));
        }

        return result;
    }

    public int[] prefix(String str){
        int N = str.length();
        int border = 0;
        int prefix[] = new int[N];

        for(int i=1;i<N;i++){

            while(border != 0 && str.charAt(border) != str.charAt(i))
                border = prefix[border - 1];

            if(str.charAt(border) == str.charAt(i))
                prefix [i] = ++border;

        }

        return prefix;
    }

    static public void main(String[] args) throws IOException {
        new KnuthMorrisPratt().run();
    }

    public void print(List<Integer> x) {
        for (int a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String pattern = scanner.next();
        String text = scanner.next();
        List<Integer> positions = findPattern(pattern, text);
        print(positions);
    }
}
