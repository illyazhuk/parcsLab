import java.io.*;
import parcs.*;

public class Fibon implements AM {

    public static void main(String[] args) {
        task curtask = new task();
        curtask.addJarFile("Fibon.jar");
        (new Fibon()).run(new AMInfo(curtask, (channel)null));
        curtask.end();
    }

    public void run(AMInfo info) {
      long n;
      try {
          /*byte[] buf = new byte[200];
          System.out.print("Enter n: ");
          System.in.read(buf);
          n=new Long(new String(buf).trim()).longValue();*/

          BufferedReader in = new BufferedReader(new FileReader(info.curtask.findFile("Fibon.data")));
          n = new Long(in.readLine()).longValue();
      } catch (IOException e) {e.printStackTrace(); return;}

      point p1 = info.createPoint();
      channel c1 = p1.createChannel();
      p1.execute("Fib");
      c1.write(n);

      System.out.println("Waiting for result...");
      long r = c1.readLong();
      System.out.println("Result found.");
        int counter = 0;
         boolean prime[] = new boolean[(int)n+1]; 
        for(int i=0;i<n;i++) 
            prime[i] = true; 
          
        for(int p = 2; p*p <=n; p++) 
        { 
            // If prime[p] is not changed, then it is a prime 
            if(prime[p] == true) 
            { 
                // Update all multiples of p 
                for(int i = p*2; i <= n; i += p) 
                    prime[i] = false; 
            } 
        } 
          
        // Print all prime numbers 
        for(int i = 2; i <= n; i++) 
        { 
            if(prime[i] == true) 
                System.out.print(i);System.out.print(", ");System.out.println();
                counter++;
        } 
    System.out.println(counter);
        
      //System.out.println("F"+n+"="+r);
      //try{
        //  PrintWriter out = new PrintWriter(new FileWriter(info.curtask.addPath("Fibon.res")));
         // out.println(r);
         // out.close();
     // } catch (IOException e) {e.printStackTrace(); return;}
    }
}
