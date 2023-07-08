package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Encryption {
    private final Scanner scanner;
    private final ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private char character;
    private char[] letters;

    public Encryption(){
        scanner = new Scanner(System.in);
        list = new ArrayList<>();
        shuffledList = new ArrayList<>();
        character = ' ';

        newKey();
        getUserInput();
    }
    private void getUserInput(){
        while(true) {
            System.out.println("*******************");
            System.out.println("Choose an option: ");
            System.out.println("[N]ewKey, [G]etKey, [E]ncrypt, [D]ecrypt, [Q]uit");
            char response = Character.toUpperCase(scanner.nextLine().charAt(0));
            switch (response){
                case 'N' -> newKey();
                case 'G' -> getKey();
                case 'E' -> encrypt();
                case 'D' -> decrypt();
                case 'Q' -> exit();
                default -> System.out.println("Wrong option");
            }
        }
    }

    private void newKey(){
        character = ' ';
        list.clear();
        shuffledList.clear();

        for (int i=32; i < 127; i++) {
            list.add(character);
            character++;
        }
        shuffledList = new ArrayList<>(list);
        Collections.shuffle(shuffledList);
        System.out.println("Key generated");

    }
    private void getKey(){
        System.out.println("Key: ");
        for(Character c : list){
            System.out.print(c);
        }
        System.out.println();
        for(Character c : shuffledList){
            System.out.print(c);
        }
        System.out.println();

    }

    private void encrypt(){
        System.out.println("Provide message to be encrypted");
        String message = scanner.nextLine();

        letters = message.toCharArray();

        for(int i = 0; i<letters.length; i++){

            for(int j = 0; j<list.size(); j++) {
                if (letters[i]==list.get(j)) {
                    letters[i]=shuffledList.get(j);
                    break;
                }
            }

            }
        System.out.println("Encrypted message: " );
        for(char c : letters){
            System.out.print(c);
        }System.out.println();


    }

    private void decrypt(){
        System.out.println("Provide message to be decrypted");
        String message = scanner.nextLine();

        letters = message.toCharArray();

        for(int i = 0; i<letters.length; i++){

            for(int j = 0; j<shuffledList.size(); j++) {
                if (letters[i]==shuffledList.get(j)) {
                    letters[i]=list.get(j);
                    break;
                }
            }

        }
        System.out.println("Decrypted message: " );
        for(char c : letters){
            System.out.print(c);
        }System.out.println();
    }

    private void exit(){
        System.out.println("Bye!");
        System.exit(0);
    }
}
