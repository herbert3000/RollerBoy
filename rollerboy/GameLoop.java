package rollerboy;

import rollerboy.litecom.ThreadHandler;

public final class GameLoop
    implements Runnable
{

    public GameLoop(ThreadHandler a1)
    {
        ED = a1;
    }

    public void run()
    {
        Thread.currentThread().setPriority(9);
        do
        {
            try
            {
                Thread.currentThread();
                Thread.sleep(10L);
            }
            catch(InterruptedException _ex) { }
            ED.D();
        } while(true);
    }

    private ThreadHandler ED;
}
