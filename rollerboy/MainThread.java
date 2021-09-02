package rollerboy;

class MainThread extends Thread
{

    public MainThread(MarioII marioii)
    {
        B = marioii;
    }

    public void run()
    {
        B.K();
    }

    MarioII B;
}
