// Team Blue Pandas (Jacob Ng, PreGuac, Andrew Piatetsky, Burnt Peanut, Emily Ortiz, Applesauce)
// APCS pd6
// L05 -- pulling it together
// 2022-02-03r
// time spent: 


// Activity 5
public class CreateUsername{
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";
  
    public static String usermaker(String input){
      String output = "";
      int start = 0;
      int end = 1;
      input.toLowerCase();
    //   System.out.println(input);
      while (start < input.length()){
          //if (alphabet.indexOf( input.substring(start, end) ) < 0 ){
            if ( input.substring(start, end).equals(" ") ){
                output += "_";
                start++;
                end++;
            }else {
                output += input.substring(start, end);
                start++;
                end++;
            }
      }
      //return output;
      return output.toLowerCase();
      //return input.substring(start, end);
    }
  
    public static void main (String[] args){
        System.out.println(usermaker("I love Piazza!"));
    }
  // "I love piazza!"
  // "i_love_piazza!"
  }