package be.kdg;

import java.util.*;

public class Word implements Comparable<Word> {

    private String value;

    public Word(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Word{" +
                "value='" + value + '\'' +
                '}';
    }


    // to sort a instance of a class that is not integer you have to provide logic
    // by implementing comparable interface
    // when sorting my classes you
    @Override
    public int compareTo(Word o) {
        return (this.value.compareTo(o.value));

    }


    // if you are asked to check if something is unique use equals and hashCode
    // important
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        //return value.equals(word.value); // to compare without lowercase
        return value.equalsIgnoreCase(word.value); // to compare with lowercase words that are the same


    }

    // important to have or equals won't work
    @Override
    public int hashCode() {
        //return value.hashCode(); // without lowercase
        return value.toLowerCase().hashCode(); // with lowercase
    }



    public static void main(String[] args) {

        List<Word> words = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            words.add(new Word("WORD-" + i));
        }
        System.out.println(words);

        Collections.shuffle(words);

        System.out.println(words);

        // because we are adding a word a tree map doesn't know how to sort

        Map<Word, Integer> wordsMap = new TreeMap<>();
        for (Word word : words) {
            wordsMap.put(word, new Random().nextInt());
        }

        System.out.println(wordsMap);


//        for (int i = 0; i < 10; i++) {
//            words.add(new Word("WORD-" + i));
//        }

        // will be asked to check for case sensitivity for different words
        // need to make everything lowercase first then make them uppercase\
        // solve it using gpt in the break

        for (int i = 0; i < 10; i++) {
            words.add(new Word("WORD-".toLowerCase() + i));
        }

        System.out.println(words.size());

        Set<Object> uniqueWords = new HashSet<>(words);
        System.out.println(uniqueWords.size());

        test();


    }


    static void test() {
        List<String> someList = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            someList.add("word-"+ i);

        }
        long end = System.currentTimeMillis();

        long duration = (end - start);

        System.out.println("Duration: " +duration);

        //LinkedList<String> =
    }



}
