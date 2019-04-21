
package multimedia_project;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

class test extends draw{
    String pass;
    test(String pass)
    {
        this.pass=pass;
    
    }
    boolean compress_runlength(String r) throws FileNotFoundException, IOException{
        FileReader out=new FileReader(pass);
        int c;
        String str="";
        while((c=out.read())!=-1)
        {
            str+=(char)c;
            
        }
        int len=0;
       
        if(!"".equals(r))
        {
           len=(int)Math.pow((double)2,Double.parseDouble(r));
          
        }
        else
        {
            JOptionPane.showMessageDialog(null, "It is Error", "Enter the run length", 0);
            
            return false;  
        }
        FileWriter in=new FileWriter("runlength_compress.txt");
        
        in.write(run_length.compress(str,len));
        in.close();
     return true;
   }
    void decompress_runlength() throws FileNotFoundException, IOException{
        FileReader out=new FileReader(pass);
        int c;
        String str="";
        while((c=out.read())!=-1)
        {
            str+=(char)c;
            
        }
        FileWriter in=new FileWriter("runlength_decompress.txt");
        in.write(run_length.decompress(str));
        in.close();
        
    }
 
    String[][] compress_shannon_fano() throws IOException
    {
       
        FileReader out=new FileReader(pass);
        int c;
        String str="";
        while((c=out.read())!=-1)
        {
            str+=(char)c;
            
        }
        try (FileWriter in = new FileWriter("shannon_fano_compress.txt")) {
            String ret[][]=Shannon_fano.compress(str);
           String strt="";
           for(int i=0;i<str.length();i++)
           {
               for(int j=0;j<ret.length;j++)
               {
                   
                   if(ret[j][0] == null ? (str.charAt(i)+"") == null : ret[j][0].equals(str.charAt(i)+""))
                 
                   {
                       
                       strt+=ret[j][2];
                       break;
                   }
                 
               }
           }
           
            in.write(strt);
            in.close();
    return ret;
        }
            
    }
    void decompress_shannon_fano() throws IOException
    {
        FileReader out=new FileReader(pass);
        int c;
        String str="";
        while((c=out.read())!=-1)
        {
            str+=(char)c;
            
        }
        try (FileWriter in = new FileWriter("shannon_fano_decompress.txt")) {
            in.write(Shannon_fano.decompress(str));
            in.close();
        }
      
    }
    
     String[][] compress_huffman() throws FileNotFoundException, IOException{
        
        FileReader out=new FileReader(pass);
        int c;
        String str="";
        while((c=out.read())!=-1)
        {
            str+=(char)c;
            
        }
        try (FileWriter in = new FileWriter("huffman_compress.txt")) {
            String ret[][]=huffman.compress(str);
           String strt="";
           for(int i=0;i<str.length();i++)
           {
               for(int j=0;j<ret.length;j++)
               {
                   
                   if(ret[j][0] == null ? (str.charAt(i)+"") == null : ret[j][0].equals(str.charAt(i)+""))
                 
                   {
                       
                       strt+=ret[j][2];
                       break;
                   }
                 
               }
           }
           
            in.write(strt);
            in.close();
    return ret;
        }
           
    }
      void decompress_huffman() throws IOException
    {
        FileReader out=new FileReader(pass);
        int c;
        String str="";
        while((c=out.read())!=-1)
        {
            str+=(char)c;
            
        }
        try (FileWriter in = new FileWriter("huffman_decompress.txt")) {
            in.write(huffman.decompress(str));
            in.close();
        }
      
    }
  
    
    

}

public class Multimedia_project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        
        
        new draw().setVisible(true);
                
        
        
    }
    
}
