import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
//import java.util.HashMap;

class Result {
    /*
     * Complete the 'weightedUniformStrings' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY queries
     */

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        // Write your code here
        char[] aChars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        HashMap<Character, Integer> weights = new HashMap<>();

        for (int i = 0; i < aChars.length; i++) {
            weights.put(aChars[i], i + 1);
        }

        List<Integer> argWeights = new ArrayList<>();
        int currCount = 0;
        int currWeight = 0;

        for (int j = 0; j < s.length(); j++) {
            if (j == 0) {
                currCount = 1;
                currWeight = weights.get(s.charAt(j));
                argWeights.add(currWeight);
            } else {
                if (s.charAt(j) == s.charAt(j - 1)) {
                    currCount++;
                    argWeights.add(currWeight * currCount);
                } else {
                    currCount = 1;
                    currWeight = weights.get(s.charAt(j));
                    argWeights.add(currWeight);
                }
            }
        }

        List<String> ans = new ArrayList<String>();

        for (int k : queries) {
            if (argWeights.contains(k)) {
                ans.add("Yes");
            } else {
                ans.add("No");
            }
        }

        return ans;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<String> result = Result.weightedUniformStrings(s, queries);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
