// Programer: Sarai Ayon
// Class: CS&141 F2P
// Date: 10/3/2022
// Assignment: Lab 3: Letter Inventory
// Reference Materials: Deitel JAVA how to program ch.9 + comission base employee sample code, Chat GBT, Tsaquif in the tutoring center,
// https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
// Udemy: Java for beginners , Nick H
// Purpose: "LetterInventory` class that keeps track of an inventory of letters in a given string while ignoring case and non-alphabetic characters:


// takes a string 'data' as input and constructs an inventory (count) of the alphabetic letters in the given string while ignoring the case of the letters.ex.  a=0 b=1 c=2
public class LetterInventory {
   private static final int ALPHABET_SIZE = 26;
   private int[] inventory;

// initializes two LetterInventory objects with names, adds them together to create a new LetterInventory, and then prints the resulting combined inventory.
   public static void main(String[] args) {
      LetterInventory inventory1 = new LetterInventory("George W. Bush");
      LetterInventory inventory2 = new LetterInventory("Hillary Clinton");
      LetterInventory sum = inventory1.add(inventory2);
      System.out.println(sum);
   }// end of Main 

// initializes a LetterInventory object by counting the occurrences of alphabetic letters in the input string while ignoring letter case.
   public LetterInventory(String data) {
      inventory = new int[ALPHABET_SIZE];
      data = data.toLowerCase();
      for (char letter : data.toCharArray()) {
         if (Character.isLetter(letter)) {
            int index = letter - 'a';
            inventory[index]++;
         }// end of if loop
      }// end of for loop
   }// end of LetterInventory method

// retrieves the count of a specified character (letter) from the LetterInventory object, while treating the character as case-insensitive. 
// If the character is not a letter, it throws an exception with an error message.
   public int get(char letter) {
      letter = Character.toLowerCase(letter);
      if (!Character.isLetter(letter)) {
         throw new IllegalArgumentException("Invalid character: " + letter);
      }// end of if loop
      return inventory[letter - 'a'];
   }// end of get method

   public void set(char letter, int value) {
      letter = Character.toLowerCase(letter);
      if (!Character.isLetter(letter) || value < 0) {
         throw new IllegalArgumentException("Invalid character or negative value.");
      }// end of if loop
      inventory[letter - 'a'] = value;
   }// end of set method

//calculates and returns the total count of all letters in the LetterInventory object, summing up the counts stored in the inventory array.
   public int size() {
      int sum = 0;
      for (int count : inventory) {
         sum += count;
      }// end of for loop
      return sum;
   }// end of size method

// checks if the LetterInventory object is empty by iterating through its inventory and returning `true` if all letter counts are zero; otherwise, it returns `false`.
   public boolean isEmpty() {
      for (int count : inventory) {
         if (count > 0) {
            return false;
         }// end of if loop
      }// end of for loop
      return true;
   }// end of isEmpty loop

// overrides the `toString()` method to create and return a string representation of the LetterInventory object. 
   @Override
// It builds a string enclosed in square brackets that contains letters from 'a' to 'z' repeated based on their respective counts in the inventory.
   public String toString() {
      StringBuilder result = new StringBuilder("[");
      for (char letter = 'a'; letter <= 'z'; letter++) {
         int count = inventory[letter - 'a'];
         for (int i = 0; i < count; i++) {
            result.append(letter);
         }// end of for int loop
      }// end of for char loop
      result.append("]");
      return result.toString();
   }// end of toString method

//computes the sum of two LetterInventory objects (`this` and `other`) and returns a new LetterInventory object (`sum`) containing the combined counts of letters from 'a' to 'z'.
   public LetterInventory add(LetterInventory other) {
      LetterInventory sum = new LetterInventory("");
      for (char letter = 'a'; letter <= 'z'; letter++) {
         int count = inventory[letter - 'a'] + other.inventory[letter - 'a'];
         sum.set(letter, count);
      }// end of for loop
      return sum;
   }// end of add method

// calculates the difference between two LetterInventory objects (`this` and `other`) and returns a new LetterInventory object (`result`) containing the subtracted counts of letters 
//from 'a' to 'z'. If any count would become negative during subtraction, it returns `null` as an indicator of an invalid operation.
   public LetterInventory subtract(LetterInventory other) {
      LetterInventory result = new LetterInventory("");
      for (char letter = 'a'; letter <= 'z'; letter++) {
         int count = inventory[letter - 'a'] - other.inventory[letter - 'a'];
         if (count < 0) {
            return null;
         }// end of if loop
         result.set(letter, count);
      }// end of for loop
      return result;
   }// end of Subtract method
   
   
}// end of Class 
