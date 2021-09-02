package rollerboy.litecom;

import java.awt.*;
import java.io.PrintStream;

public class ErrorFrame extends Frame
{

    public ErrorFrame(Throwable throwable, String s)
    {
        super("Error - " + s);
        while(Z) 
            return;
        setLayout(new GridLayout(5, 1));
        add(new Label("An error has occured!"));
        add(new Label("Error message: " + s));
        add(new Label("Exception: " + throwable));
        add(new Label("Exception message: " + throwable.getMessage()));
        add(new Label("Please report this to maciek@litecom.se."));
        throwable.printStackTrace(new PrintStream(Logger._fld010B, true));
        resize(300, 115);
        show();
        Z = true;
    }

    public boolean handleEvent(Event event)
    {
        switch(event.id)
        {
        case 201: // Event.WINDOW_DESTROY
            hide();
            Z = false;
            break;

        default:
            return false;
        }
        return true;
    }

    public static boolean Z;
}
