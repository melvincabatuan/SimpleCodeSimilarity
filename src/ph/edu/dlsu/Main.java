package ph.edu.dlsu;

/*
This is a sample naive code comparison software
Author: MKC
Date created: Aug 4, 2020
Last modified: Aug 4, 2020
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {

    public static void main(String[] args) throws IOException {

        // Load program files from assets
        String path1 = "assets/Hello1.java";
        String path2 = "assets/Hello2.java";
        String path3 = "assets/Hello3.java";
        String program1 = Files.readString(Paths.get(path1));
        String program2 = Files.readString(Paths.get(path2));
        String program3 = Files.readString(Paths.get(path3));

        // View the loaded files
        System.out.println("program1:"+ "\n" + program1);
        System.out.println("\nprogram2:"+ "\n" +program2);
        System.out.println("\nprogram3:"+ "\n" +program3);

        // Show the naive similarity between programs
        System.out.format("'Hello1.java' and 'Hello2.java' Similarity: %.2f %%",
                getNaiveSimilarity(program1, program2));

        System.out.format("\n'Hello1.java' and 'Hello3.java' Similarity: %.2f %%",
                getNaiveSimilarity(program1, program3));
    }

    static float getNaiveSimilarity(String programA, String programB){
        /**
         * Compute a simple similarity score by one-to-one
         * comparison between tokens / space separated words
         * between two programs
         */
        // Extract space separated tokens
        String[] words1 = programA.split(" +");
        //        printTokens(words1);
        String[] words2 = programB.split(" +");
        //        printTokens(words2);

        // Count value similarity
        int count = 0;
        for (int i=0; i<words1.length; i++) {
            if(words1[i].equals(words2[i])){
                count++;
            }
        }

        // Return the similarity in percentage
        return (100 * (float) count/words1.length);
    }

    static void printTokens(String[] wordList){
        /**
         * Prints the list of tokens or words
         */
        for (int i=0; i<wordList.length; i++) {
            System.out.println("Token["+i+"]: " + wordList[i]);
        }
    }
}
