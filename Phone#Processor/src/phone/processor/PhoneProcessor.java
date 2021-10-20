/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phone.processor;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author mkreiner
 */
public class PhoneProcessor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String space = " ";
        String toPrint = "";
        Scanner sc = new Scanner(System.in);
        Matcher match;
        System.out.println("Please input a phone number to validate");
        String userIn = "419.123.4564";//sc.next();
        Pattern validPhoneNum = Pattern.compile("(\\([0-9]{3}\\)[0-9]{3}-[0-9]{4})|([0-9]{3}-[0-9]{3}-[0-9]{4})|([0-9]{3}\\.[0-9]{3}\\.[0-9]{4})|(\\([0-9]{3}\\)" + space + "[0-9]{3}-[0-9]{4})");
        match = validPhoneNum.matcher(userIn);
        //four or statements for the pattern. first, its sees if any pass. then it 
        //identifies which is not null because the one that is not null is the one that passed.
        //From there it makes any modifications using substring parts to modify accordingly.
        //it then saves to toPrint and prints it out.
        
        
        if(match.matches())
        {
            //System.out.println("1 passed");
            if(match.group(1) != null)
            {
                //System.out.println("num 1");
                toPrint = match.group(1).substring(0, 5) + " " + match.group(1).substring(5);
                System.out.println(toPrint);
                
            }
            else if(match.group(2) != null)
            {
                //System.out.println("num 2");
                toPrint = "(" + match.group(2).substring(0, 3) + ") "+ match.group(2).substring(4);
                System.out.println(toPrint);
            }
            else if(match.group(3) != null)
            {
                //System.out.println("num 3");
                toPrint = "(" + match.group(3).substring(0, 3) + ") "+ match.group(3).substring(4, 7) + "-" + match.group(3).substring(8);
                System.out.println(toPrint);
            }
            else if(match.group(4) != null)
            {
                System.out.println("num 4");
                toPrint = match.group(4);
                System.out.println(toPrint);
            }
            //has no else because there is no other option because first if rules it out.
            
            
        }
        else
        {
            System.out.println("Not a valid phone number");
        }
        //System.out.println(match.group(1));
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
            
    }
    
}
