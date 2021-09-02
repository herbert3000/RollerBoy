package rollerboy;

import java.awt.*;
import java.io.PrintStream;
import rollerboy.litecom.ErrorFrame;
import rollerboy.litecom.Logger;
import rollerboy.litecom.trace.ScoreServerHandler;

public class HighScoreFrame extends Frame
{

    public HighScoreFrame(Object obj, int j, ScoreServerHandler k)
    {
        super("Congratulations! A highscore!");
        _fld0149 = false;
        _fld014B = false;
        _fld0147 = obj;
        _fld0148 = j;
        _fld014A = k;
        FF();
        resize(300, 150);
        show();
    }

    private void FE(Component component)
    {
        _fld014D.setConstraints(component, _fld014E);
        add(component);
    }

    private void FF()
    {
        _fld014D = new GridBagLayout();
        setLayout(_fld014D);
        _fld014E = new GridBagConstraints();
        _fld014E.insets = new Insets(2, 0, 2, 0);
        _fld014E.weightx = 1.0D;
        _fld014E.gridwidth = 1;
        _fld014E.weightx = 1.0D;
        _fld014E.gridwidth = 1;
        _fld014E.anchor = 13;
        FE(new Label("Name: "));
        _fld014E.gridwidth = 0;
        _fld014E.anchor = 17;
        FE(_fld0146 = new TextField(30));
        _fld014E.insets = new Insets(25, 3, 2, 3);
        _fld014E.anchor = 13;
        _fld014E.gridwidth = 1;
        FE(_fld0144 = new Button("OK"));
        _fld014E.anchor = 17;
        _fld014E.gridwidth = 0;
        FE(_fld0145 = new Button("CANCEL"));
    }

    public boolean handleEvent(Event event)
    {
        switch(event.id)
        {
        case 201: // Event.WINDOW_DESTROY
            FD();
            return true;

        case 1001: // Event.ACTION_EVENT
            if(event.target == _fld0144 && !_fld0149)
            {
                _fld0149 = true;
                if(_fld0146.getText().trim().equals(""))
                {
                    FD();
                } else
                {
                    if(!FC(_fld0146.getText()))
                    {
                        Logger.DB("Pressed ok, updating highscore.");
                        try
                        {
                            _fld014A.h(_fld0148, _fld0146.getText());
                        }
                        catch(Exception exception)
                        {
                            new ErrorFrame(exception, "Could not save score.");
                        }
                    } else
                    {
                        System.out.println("skipping");
                    }
                    FD();
                }
            }
            if(event.target == _fld0145)
            {
                Logger.DB("Pressed cancel, closing.");
                FD();
            }
            return true;
        }
        return false;
    }

    private boolean FC(String s)
    {
        s = s.toUpperCase();
        for(int j = 0; j < _fld014F.length; j++)
            s = s.replace(_fld014F[j], ' ');

        for(int k = 0; k < _fld014C.length; k++)
        {
            String s1 = _fld014C[k];
            for(int l = 0; l < s1.length(); l++)
                if(s.indexOf(" " + s1 + " ") != -1)
                    return true;

            if(s.indexOf(s1 + " ") == 0)
                return true;
            if(s.length() == s1.length() && s.equals(s1))
                return true;
            if(s.length() != s1.length() && s.indexOf(" " + s1) == s.length() - (s1.length() + 1))
                return true;
        }

        return false;
    }

    private void FD()
    {
        hide();
        _fld014B = true;
    }

    private Button _fld0144;
    private Button _fld0145;
    private TextField _fld0146;
    private Object _fld0147;
    private int _fld0148;
    private boolean _fld0149;
    private ScoreServerHandler _fld014A;
    public boolean _fld014B;
    private String _fld014C[] = {
        "COCK", "COCKS", "IN ASS", "YOUR ASS", "NIGGA", "NIGGER", "HOE", "SUCKS DICK", "SUCK DICK", "SUCK MY DICK", 
        "SUCKS MY DICK", "WHORE", "SLUT", "FUCK", "FUCKS", "FUCKER", "FUCKERS", "FUCKING", "FUCKINGS", "BITCH", 
        "PUSSY", "CUNT", "PENIS", "PENISES"
    };
    GridBagLayout _fld014D;
    GridBagConstraints _fld014E;
    private char _fld014F[] = {
        '!', '?', '.', '-', ',', '_', '@', '\243', '\244', '%', 
        '&', '/', '(', ')', '=', '?', '+', '$', '"'
    };
}
