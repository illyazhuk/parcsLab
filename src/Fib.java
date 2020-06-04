import parcs.*;

public class Fib implements AM{
    long counter=0;
    void sieveOfEratosthenes(int n) 
    { 
        // Create a boolean array "prime[0..n]" and initialize 
        // all entries it as true. A value in prime[i] will 
        // finally be false if i is Not a prime, else true. 
        
    } 
    
    public void run(AMInfo info){
        
        
        long n,r1,r2,r;
        n = info.parent.readLong();
        
             
        //System.out.println("n="+n);
        if (n<2) counter=1;
        else {
            point p1 = info.createPoint();
            channel c1 = p1.createChannel();

            p1.execute("Fib");
            c1.write(n-2);
            point p2 = info.createPoint();
            channel c2 = p2.createChannel();
            p2.execute("Fib");
            c2.write(n-1);

            r1=c1.readLong();
            r2=c2.readLong();
            //if ((r1==0)||(r2==0)) System.out.println("n="+n+" r1="+r1+" r2="+r2);
            r=r1+r2;
            
            boolean prime[] = new boolean[n+1]; 
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
            
        }
        info.parent.write(counter);
    }

    
    // Driver Program to test above function 
    
} 
  

