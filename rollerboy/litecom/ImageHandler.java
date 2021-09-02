package rollerboy.litecom;

import java.applet.Applet;
import java.awt.*;
import java.util.*;

public class ImageHandler
{

    public ImageHandler(Applet applet)
    {
        _fld012F = new Hashtable();
        _fld0133 = false;
        _fld0132 = applet;
        _fld0130 = new MediaTracker(applet);
        _fld0131 = "";
    }

    public ImageHandler(Applet applet, String s)
    {
        this(applet);
        Logger.DB("ImageBase: Base path for images: " + s);
        _fld0131 = s;
    }

    public ImageHandler(Component component, String s)
    {
        _fld012F = new Hashtable();
        _fld0133 = false;
        Logger.DB("ImageBase: Base path for images: " + s);
        Logger.DB("ImageBase: Aplication mode.");
        _fld0130 = new MediaTracker(component);
        _fld0131 = s;
    }

    public void E9(String s)
    {
        s = s.trim();
        if(_fld0132 == null)
            _fld012F.put(s, Toolkit.getDefaultToolkit().getImage(_fld0131 + s));
        else
            _fld012F.put(s, _fld0132.getImage(_fld0132.getDocumentBase(), _fld0131 + s));
        Logger.DB("ImageBase: Adding image: " + s + "\r");
    }

    public void E8(String s)
    {
        String s1;
        for(StringTokenizer stringtokenizer = new StringTokenizer(s, ", "); stringtokenizer.hasMoreTokens(); E9(s1))
            s1 = stringtokenizer.nextToken();

    }

    public void E7()
    {
        int i = 0;
        for(Enumeration enumeration = _fld012F.keys(); enumeration.hasMoreElements();)
        {
            String s = (String)enumeration.nextElement();
            _fld0130.addImage((Image)_fld012F.get(s), i);
            i++;
        }

    }

    public void EC()
    {
        E7();
        _fld0130.checkAll(true);
        _fld0133 = true;
    }

    public boolean EE()
    {
        return _fld0130.checkAll(true);
    }

    public int E6()
    {
        int i = 0;
        for(int j = 0; j < _fld012F.size(); j++)
            if(_fld0130.checkID(j, true))
                i++;

        return i;
    }

    public int ED()
    {
        return _fld012F.size();
    }

    public void EB()
    {
        Logger.DB("ImageBase: Waiting for all images to load...");
        EC();
        while(!EE()) 
            try
            {
                Thread.currentThread();
                Thread.sleep(100L);
            }
            catch(Exception _ex) { }
        Logger.DB("ImageBase: Done");
    }

    public Image EA(String s)
    {
        return (Image)_fld012F.get(s);
    }

    private Hashtable _fld012F;
    private MediaTracker _fld0130;
    private String _fld0131;
    private Applet _fld0132;
    public boolean _fld0133;
}
