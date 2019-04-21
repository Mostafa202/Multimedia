
package multimedia_project;

import java.util.ArrayList;
import java.util.Objects;

public class Shannon_fano {

         static int sum_divide(Integer arr[]){
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
        }
        return (int)(Math.ceil(sum/2.0));
        
    }
     static void sort(ArrayList<Integer>fr,ArrayList<String> ch)
     {
         int swap_fr;
         String swap_ch;
         
         for(int i=0;i<fr.size();i++)
         {
             for(int j=i+1;j<fr.size();j++)
             {
                 if(fr.get(j)>fr.get(i))
                 {
                     swap_fr=fr.get(i);
                     fr.set(i, fr.get(j));
                     fr.set(j, swap_fr);
                     swap_ch=ch.get(i);
                     ch.set(i, ch.get(j));
                     ch.set(j, swap_ch);
                       
                 }
                 
             }
         }
         
 
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
        
           sort(fr, ch);
          
        return fr;
    }
     //set bits
 
   
     static String bits[]=new String[500];
     
     static int tmp=-1;
     static void bits(ArrayList<Integer> list1,ArrayList<Integer> list2,ArrayList<Integer>lst)
     {
       
           Integer arr_freq[]=new Integer[lst.size()];
           lst.toArray(arr_freq);
            int j=tmp+1;
        for(int i=0;i<list2.size();i++)
        {
        for (;j<arr_freq.length;j++) {
           if (Objects.equals(arr_freq[j], list2.get(i))) {
                        if(bits[j]==null)
                         bits[j]="";
                         bits[j]+="1";
                         tmp=j;
                         break;
                 }
             }
               j=tmp+1;
        }
         int temp=0,k=tmp+1;
         for(int i=0;i<list1.size();i++)
         {
             for (;k<arr_freq.length;k++) {
                 
                 if (arr_freq[k].equals(list1.get(i))) {
                     if(bits[k]==null)
                        bits[k]="";
                        bits[k]+="0";
                        temp=k;
                        break;
                     
                 }
                
             }
              k=temp+1;
         }
     
         
     }
   
     static void save(ArrayList<Integer>arr,ArrayList<Integer>lst)
     {
        
        Integer arr_freq[]=new Integer[arr.size()];
           arr.toArray(arr_freq);
           //create arraylist for collection of numbers//
           ArrayList<Integer>collect_arr=new ArrayList<>();
           
           //end creation
        
        while(arr.size()>1){
            int num_divide=sum_divide(arr_freq);

            int collection=0;
            int counter=0;
            while(collection<=num_divide)
            {
                collect_arr.add(arr.get(counter));
                collection+=arr.get(counter);
                counter++;
            }
         
           if(counter!=1)
           {
            collection-=arr.get(counter-1);
            collect_arr.remove(counter-1);
            for(int i=0;i<counter-1;i++)
                arr.remove(0);
           }
            
           else
             for(int i=0;i<=counter-1;i++)
                arr.remove(0);
    
             bits(arr, collect_arr,lst);
             save(arr,lst);
             tmp=-1;
             save(collect_arr,lst);
            
           
        }
          
     }
     
    //Shannon-Fano Algorithm 
     
   static String[][] compress(String str){
        
        ArrayList<Integer>arr;
        ArrayList<Integer>x=new ArrayList<>();
        arr=freq(str);
        
       
        
       for(int i=0;i<arr.size();i++)
         x.add(arr.get(i));
         save(arr,x);
          String two[][]=new String[x.size()][3];
             for(int i=0;i<x.size();i++)
             {
             
             two[i][0]=ch.get(i);
             two[i][1]=x.get(i)+"";
             two[i][2]=bits[i];
             //System.out.println(ch.get(i)+" --- "+x.get(i)+"---"+bits[i]);
             
             
             }
       
       
          
             
             return two;
             
    }
   static String characters="";
   static int num;
    static boolean find_in_bits(String str,String arr[])
   {

       int i=0;
       for(;i<arr.length;i++)
       {
           if(arr[i]==null)
               break;
          else if(arr[i].equals(str))
          {
          characters+=ch.get(i)+"";
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
       return characters;
       
   }
}