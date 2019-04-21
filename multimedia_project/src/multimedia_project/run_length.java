
package multimedia_project;
public class run_length {
    static String compress(String data,int len){
        String str="";
        
        int counter=0;
        for(int i=0;i<data.length();i++)
        {
          if(i!=data.length()-1){
            if(data.charAt(i)==data.charAt(i+1)&&counter<len-1)
            {
                counter++;

            }
           else
            {
                str+=("("+data.charAt(i)+","+(counter+1)+")");
                counter=0;
            }
           }
          else
          {
               str+=("("+data.charAt(i)+","+(counter+1)+")");
          }

        }
        return str;
    }
     static String decompress(String data){
        String str="";
        String dt="";
        for(int i=0;i<data.length();i++)
        {
            if(data.charAt(i)=='('||data.charAt(i)==')'||data.charAt(i)==',');
                
            else
                dt+=data.charAt(i);
                
        }
        data=dt;
        
        for(int i=1;i<data.length();i+=2){
            int num=Integer.parseInt(data.charAt(i)+"");
            for(int j=1;j<=num;j++)
                str+=data.charAt(i-1);
        }
        return str;
    }
    
    
    
}
