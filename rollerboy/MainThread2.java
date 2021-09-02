package rollerboy;

import rollerboy.litecom.ThreadHandler;

public final class MainThread2 extends Thread
{

    public MainThread2(MarioII marioii, int i)
    {
        E7 = new ThreadHandler();
        E9 = false;
        EA = false;
        E8 = marioii;
        EB = i;
    }

    public void CC()
    {
        E9 = true;
    }

    public void CD()
    {
        E9 = false;
    }

    public void CB()
    {
        EA = true;
    }

    public void CA()
    {
        Constants.R.k(E8.q);
        Constants.S._mth0105();
    }

    public void run()
    {
        Thread.currentThread().setPriority(6);
        GameLoop l1 = new GameLoop(E7);
        (new Thread(l1)).start();
        while(!EA) 
        {
            if(E9 && E8.w)
                CA();
            E8.h.D();
            E7.A();
            if(E8.g == 1)
                EC++;
        }
    }

    public ThreadHandler E7;
    MarioII E8;
    boolean E9;
    boolean EA;
    int EB;
    public int EC;
}
