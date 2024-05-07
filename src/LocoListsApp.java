/*
Phillip Yohner
COP 3330C - CRN 24680
February 16, 2024

Description:
The purpose of this program - Loco Lists App - is to accept eight, unique words from a user. The words are added
into a list. The list will be sorted, then custom sorted by word length, and then shuffled.
Next, the user will provide a search word.  The location of the word in the list will be returned, or else they
will be told the word does not exist in the list.
Using two more Collections methods, the list will be rotated and then reversed.
Lastly, the list will be converted to an array and then converted back to a list.
At the bottom of this program is a comment on the difference between Collections and Collection.
*/

import java.util.*;

public class LocoListsApp {
    public static void main (String[] args) {
    // Project Steps:
    // 1. Create a List
        List<String> words = new ArrayList<>(); //create list
        Scanner scanner = new Scanner(System.in); //new scanner

        //Gather user's words
        System.out.println("Please enter 8 unique words, one at a time.");
        for (int i = 0; i < 8; i++){
            System.out.println("Word " + (i + 1) + ": ");
            String userInput = scanner.nextLine().toLowerCase();

            //Check whether word has already been entered
            if (!words.contains(userInput)){
                words.add(userInput);
            } else {
                System.out.println("This word already exists in the list. Please enter a different word.");
                i--;
            }
        }

        //Find the shortest word
        String shortestWord = words.get(0);
        for (String s : words){
            if (s.length() < shortestWord.length()){
                shortestWord = s;
            }
        }
        //Find the longest word
        String longestWord = words.get(0);
        for (String s : words){
            if (s.length() > longestWord.length()){
                longestWord = s;
            }
        }

    // 2. Print the List
        System.out.println("Here are the words you entered: ");
        //Print list of words using enhanced for loop
        for (String s : words) {
            System.out.println(s);
        }
        System.out.println("Total number of words: " + words.size()); //Print total # of words
        System.out.println("The longest word: " + longestWord); //Print longest word
        System.out.println("The shortest word: " + shortestWord); //Print shortest word

    // 3. Sort the List
        Collections.sort(words); //Sort list in ascending order
        System.out.println("Here's a sorted list of the words: ");
        //Print list of words using enhanced for loop
        for (String s : words) {
            System.out.println(s);
        }

    // 4. Custom Sort the List
        Collections.sort(words, new Comparator<String>() {
            @Override
            //Custom sort comparing string length
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println("Here's the list sorted by number of letters: ");
        //Print list of words using enhanced for loop
        for (String s : words) {
            System.out.println(s);
        }

    // 5. Shuffle the List
        System.out.println("Here's the shuffled list: ");
        Collections.shuffle(words); //Shuffle list
        //Print list of words using enhanced for loop
        for (String s : words) {
            System.out.println(s);
        }

    // 6. Search the List
        System.out.println("Please enter a word to search for: ");
        String userSearch = scanner.nextLine().toLowerCase(); //Gather user's search word
        //Locate user's search word
        int listIndex = words.indexOf(userSearch);
        if (listIndex != -1) {
            System.out.println("The word \"" + userSearch + "\" is at index " + listIndex + " in the list.");
        } else {
            System.out.println("The word \"" + userSearch + "\" is not in the list.");
        }

    // 7. Implement at least 2 other static methods from the Collections class
        System.out.println("Here's the list rotated 5 positions (Collections.rotate): ");
        Collections.rotate(words,5); //Rotate list 5 positions
        //Print list of words using enhanced for loop
        for (String s : words) {
            System.out.println(s);
        }

        System.out.println("Here's the list reversed (Collections.reverse): ");
        Collections.reverse(words); //Reverse order the list
        //Print list of words using enhanced for loop
        for (String s : words) {
            System.out.println(s);
        }

    // 8. Convert the List to an Array
        String[] wordArray = words.toArray(new String[0]); //List to Array
        System.out.println("The list has been converted to an array. Here are the array's elements: ");
        //Print list of words using enhanced for loop
        for (String s : wordArray) {
            System.out.println(s);
        }

    // 9. Convert the array back into a list
        List<String> wordList = Arrays.asList(wordArray); //Array to List
        System.out.println("The array has been converted back to a list. Here are the list's elements: ");
        //Print list of words using enhanced for loop
        for (String s : wordList) {
            System.out.println(s);
        }

    // 10. Comment on Collections vs. Collection
        /*
        A "collection" is an interface in Java for a group of objects, or elements, like a List, Set, Map, Queue, etc.
        The interface includes methods like add, contains, remove, and size.

        "Collections" is a utility class in Java that consists of static methods that can operate on a
        collection (List, Set, or Queue) or return a collection. Just a few examples of the static methods are
        sort, copy, binarySearch, and shuffle.
         */
    }
}