package ex8_2;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class countword extends Thread
{
    //count  c;
    String str;
    int read,count = 0;
    countword(String c)
    {
        str=c;
    }
    @Override
    public void run()
    {
        FileReader file = null;  
        try {
            file = new FileReader(str);
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(countword.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br = new BufferedReader(file);  
        String line;
        try {
            while((read=file.read())!=-1)
            {
                if(read==' ')
                {
                    count++;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(countword.class.getName()).log(Level.SEVERE, null, ex);
        }
        count++;
        System.out.println(str+"-->:"+count);
    }
}

public class ex8_2 {
    public static void main(String args[]) {
        int n;
        n = args.length;
        countword t[]=new countword[n];
        for(int i=0;i<n;i++)
        {
            t[i]=new countword(args[i]);
            t[i].start();
        }
    }
}
