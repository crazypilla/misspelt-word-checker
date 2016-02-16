/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spelluser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Harshita V
 */
public class SpellUser {

    /**
     * @param args the command line arguments
     */
     public static int minDistance(String word1, String word2) {
	int len1 = word1.length();
	int len2 = word2.length();
 
	// len1+1, len2+1, because finally return dp[len1][len2]
	int[][] dp = new int[len1 + 1][len2 + 1];
 
	for (int i = 0; i <= len1; i++) {
		dp[i][0] = i;
	}
 
	for (int j = 0; j <= len2; j++) {
		dp[0][j] = j;
	}
 
	//iterate though, and check last char
	for (int i = 0; i < len1; i++) {
		char c1 = word1.charAt(i);
		for (int j = 0; j < len2; j++) {
			char c2 = word2.charAt(j);
 
			//if last two chars equal
			if (c1 == c2) {
				//update dp value for +1 length
				dp[i + 1][j + 1] = dp[i][j];
			} else {
				int replace = dp[i][j] + 1;
				int insert = dp[i][j + 1] + 1;
				int delete = dp[i + 1][j] + 1;
 
				int min = replace > insert ? insert : replace;
				min = delete > min ? min : delete;
				dp[i + 1][j + 1] = min;
			}
		}
	}
 
	return dp[len1][len2];
}
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
         FileReader file=new FileReader("F:/input.txt");
          BufferedReader bufRead = new BufferedReader(file);
          String myLine = null;
          ArrayList dict=new ArrayList();
          while((myLine=bufRead.readLine()) != null)
          {
          
             String[] strarr=myLine.split(" ");
             for(int i=0;i<strarr.length;i++){
             dict.add(strarr[i]);
             }
         
          
          }
          FileReader file2=new FileReader("F:/req.txt");
          BufferedReader bufRead2 = new BufferedReader(file2);
          String myLine2 = null;
          ArrayList misspelt=new ArrayList();
          
          while((myLine2=bufRead2.readLine()) != null)
          {
            
             String[] strarr2=myLine2.split(" ");
             for(int i=0;i<strarr2.length;i++)
             {
                 if(!dict.contains(strarr2[i]))
                     
                    misspelt.add(strarr2[i]);
             }
         
          
          }
          
          //PrintWriter writer = new PrintWriter("F:/result.txt");
          
         // Misspelt mispell=new Misspelt(dict,doc,writer);
          System.out.println(dict);
          System.out.println(misspelt);
          ArrayList possible=new ArrayList();
          
          for(int i=0;i<misspelt.size();i++)
          {
              for(int j=0;j<dict.size();j++)
              {
               if(minDistance((String)misspelt.get(i),(String)dict.get(j))<2)
               {
                        System.out.println((String)misspelt.get(i));
                        System.out.println("yo");
                        possible.add((String)misspelt.get(i));
                }
        
            String x=(String)misspelt.get(i);
            char[] charArr=x.toCharArray();
            Arrays.sort(charArr);

        
        
            char[] charArr2=((String)dict.get(j)).toCharArray();
            Arrays.sort(charArr2);
        
            if(charArr.toString().equals(charArr2.toString()))
              { possible.add((String)misspelt.get(i));}
        
        }
        
      }
        System.out.println(possible);      
    }
          
}
          
          
    

