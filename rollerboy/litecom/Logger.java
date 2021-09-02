package rollerboy.litecom;

import java.applet.Applet;
import java.awt.Component;
import java.awt.TextArea;
import java.io.OutputStream;
import java.io.PrintStream;

public class Logger extends OutputStream
{

    public static void DD(String s)
    {
        DB(s);
    }

    public Logger()
    {
        _fld010C = "";
        _fld010B = this;
        
        //DC(); // debug mode on
    }

    public static void DE()
    {
        if(_fld010A != null)
            _fld010A.hide();
        _fld0109 = false;
    }

    public static void DC()
    {
        if(_fld010A == null && !_fld0109)
            _fld010A = new DebugFrame();
        _fld0109 = true;
    }

    public static void DB(String s)
    {
        if(_fld0107)
        {
            if(_fld0109)
            {
                _fld010A._fld010D.appendText(s + "\n");
                return;
            }
            System.out.print("[DEBUG] " + s + "\r\n");
        }
    }

    public static void DA(Object obj, String s)
    {
        if(_fld0107)
            DB(obj.getClass().getName() + ": " + s);
    }

    public static void DF(Applet applet)
    {
        if(applet.getParameter("debug") != null && applet.getParameter("debug").equals("true"))
            _fld0107 = true;
        else
            _fld0107 = false;
        if(_fld0107 && ("" + applet.getDocumentBase()).startsWith("http") && System.getProperty("browser") != null && System.getProperty("browser").startsWith("ActiveX"))
            DC();
        
        if (_fld0107) DC(); // fix by herbert3000
    }

    public void write(int i)
    {
        if(_fld0107)
        {
            String s;
            if(i == 10 && !_fld0109)
                s = "\r\n";
            else
                s = "" + (char)i;
            _fld010C += s;
            if(i == 10)
            {
                if(_fld0109)
                    _fld010A._fld010D.appendText(_fld010C);
                else
                    System.out.print(_fld010C);
                _fld010C = "";
            }
        }
    }

    public static boolean _fld0107;
    public static boolean _fld0108;
    private static boolean _fld0109;
    public static DebugFrame _fld010A;
    public static Logger _fld010B;
    private String _fld010C;

    static 
    {
        new Logger();
    }
}
