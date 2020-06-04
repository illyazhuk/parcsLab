import parcs.*;

public class Fib implements AM
{
    public void run(AMInfo info){
    int counter=0;
        long n,r1,r2,r;
        n = info.parent.readLong();

        n=12;
             boolean prime[] = new boolean[12]; 
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
                counter++;
        } 
            
        info.parent.write(counter);
     
    }
}
