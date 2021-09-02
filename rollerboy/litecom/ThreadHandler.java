package rollerboy.litecom;

public class ThreadHandler
{

    public synchronized void B()
    {
        A = 1;
        notifyAll();
    }

    public synchronized void C()
    {
        while(A <= 0) 
            try
            {
                wait();
            }
            catch(InterruptedException _ex) { }
        A = 0;
    }

    public ThreadHandler()
    {
        A = 0;
    }

    public synchronized void A()
    {
        while(A <= 0) 
            try
            {
                wait();
            }
            catch(InterruptedException _ex) { }
        A--;
    }

    public synchronized void D()
    {
        A++;
        notifyAll();
    }

    private int A;
}
