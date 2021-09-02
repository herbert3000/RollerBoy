package rollerboy.litecom;

import java.awt.*;

class DebugFrame extends Frame
{

    public DebugFrame()
    {
        super("Debug");
        setLayout(new BorderLayout());
        _fld010D = new TextArea();
        _fld010D.setEditable(false);
        add("Center", _fld010D);
        resize(500, 300);
        show();
    }

    public boolean handleEvent(Event event)
    {
        switch(event.id)
        {
        case 201: // Event.WINDOW_DESTROY
            Logger.DE();
            break;

        default:
            return false;
        }
        return true;
    }

    public TextArea _fld010D;
}
