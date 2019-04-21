
package multimedia_project;

import java.util.ArrayList;
import java.util.PriorityQueue; 
import java.util.Scanner; 
import java.util.Comparator; 
  
class HuffmanNode { 
  
    int data; 
    char c; 
  
    HuffmanNode left; 
    HuffmanNode right; 
} 

class MyComparator implements Comparator<HuffmanNode> { 
    public int compare(HuffmanNode x, HuffmanNode y) 
    { 
  
        return x.data - y.data; 
    } 
} 

public class huffman {

    static ArrayList<String> bits=new ArrayList<>();
     static ArrayList<Character> characters=new ArrayList<>();
      static ArrayList<Integer> freq=new ArrayList<>();
    public static void printCode(HuffmanNode root, String s) 
    { 

        if (root.left 
                == null
            && root.right 
                   == null
            && Character.isLetter(root.c)) { 
  
            // c is the character in the node 
            System.out.println(root.c + ":" + s); 
            bits.add(s);
            characters.add(root.c);
            
            
            return; 
        } 
  
        printCode(root.left, s + "0"); 
        printCode(root.right, s + "1"); 
        
        
    } 
     static  ArrayList<Integer>fr=new ArrayList<>();
     static  ArrayList<String>ch=new ArrayList<>();
     
     static  ArrayList freq(String str){
            
             int counter=0;
        for(int i=0;i<str.length();i++)
        {
            for(int j=0;j<str.length();j++)
            {
             if(str.charAt(i)==str.charAt(j))
             counter++;
             
            }
            ch.add(str.charAt(i)+"");
            str=str.replace(str.charAt(i)+"","");
            i=0;
            fr.add(counter);
            counter=0;
                
        }
        return fr;
        
     }
     static String[][] compress(String st)
     {

          freq(st);
          char charArray[]=new char[ch.size()];
          int charfreq[]=new int[ch.size()];
          String str=ch.toString().replaceAll(",", "");
          charArray = str.substring(1, str.length()-1).replaceAll(" ", "").toCharArray();
         for(int i=0;i<ch.size();i++)
         {
         
             charfreq[i]=fr.get(i);
             System.out.println(charfreq[i]);
             System.out.println(charArray[i]);
             
         }
      
         
         int n=charfreq.length;
        
          PriorityQueue<HuffmanNode> q 
            = new PriorityQueue<HuffmanNode>(n, new MyComparator()); 
  
        for (int i = 0; i < n; i++) { 
  

            HuffmanNode hn = new HuffmanNode(); 
  
            hn.c = charArray[i]; 
            hn.data = charfreq[i]; 
  
            hn.left = null; 
            hn.right = null; 
 
            q.add(hn); 
            
        } 
  
        // create a root node 
        HuffmanNode root = null; 
  

        while (q.size() > 1) { 
  
            // first min extract. 
            HuffmanNode x = q.peek(); 
            q.poll(); 
  
            // second min extarct. 
            HuffmanNode y = q.peek(); 
            q.poll(); 
  
            // new node f which is equal 
            HuffmanNode f = new HuffmanNode(); 
  
            // to the sum of the frequency of the two nodes 
            // assigning values to the f node. 
            f.data = x.data + y.data; 
            f.c = '-'; 
  
            // first extracted node as left child. 
            f.left = x; 
  
            // second extracted node as the right child. 
            f.right = y; 
  
            // marking the f node as the root node. 
            root = f; 
  
            // add this node to the priority-queue. 
            q.add(f); 
        } 
  
        // print the codes by traversing the tree 
        
       
        printCode(root, ""); 
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(characters.get(i)==charArray[j])
                {
                    freq.add(charfreq[j]);
                    break;
                }
            }
        }
        
        String two[][]=new String[n][3];
        
         for(int i=0;i<n;i++){
             
             two[i][0]=characters.get(i)+"";
             two[i][1]=freq.get(i)+"";
             two[i][2]=bits.get(i);
             
            
  
         }
         return two;
     }
         
    static String character="";  
   static boolean find_in_bits(String str,ArrayList ar)
   {
       int i=0;
       
       ArrayList<String>arr=new ArrayList<>();
       for(int k=0;k<ar.size();k++)
       {
           arr.add(ar.get(k)+"");
           
       }
       
       for(;i<arr.size();i++)
       {
           if(arr.get(i)==null)
               break;
          else if(arr.get(i).equals(str))
          {
          character+=characters.get(i)+"";
          return true;
          
          }
          
       }
       return false;
          
   }
   static String decompress(String str)
   {
       boolean newstr=false;
       String test="";
       int counter=0;
       while(counter<str.length())
       {
        while(newstr==false)
        {

            test+=(str.charAt(counter)+"");
            counter++;
            newstr=find_in_bits(test, bits);
        }
        newstr=false;
        test="";
       }
       return character;
       
   }
}