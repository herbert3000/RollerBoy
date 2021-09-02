package rollerboy;

import java.awt.*;
import rollerboy.litecom.ImageHandler;
import rollerboy.litecom.Logger;
import rollerboy.units.Rollerboy;
import rollerboy.units.Unit;

public final class StatusBar
{

    public StatusBar(Rollerboy cb1, Graphics g, int i, int j)
    {
        _fld0101 = -1F;
        _fld0102 = -1F;
        FB = cb1;
        FC = g;
        FD = new Font("Arial, Helvetica", 1, 10);
        g.setFont(FD);
        FE = g.getFontMetrics();
        FF = i;
        _fld0100 = j;
        Logger.DA(this, "x: " + i + ", y: " + j);
    }

    public void D6()
    {
        if(_fld0101 != ((Unit) (FB))._fld0159 || _fld0102 != (float)FB.F8())
        {
            _fld0101 = ((Unit) (FB))._fld0159;
            _fld0102 = FB.F8();
            FC.setColor(new Color(27, 156, 238));
            FC.fillRect(0, 0, FF, _fld0100);
            FC.setColor(Color.white);
            FC.drawString("Score: " + FB.F8(), 10, 10);
            for(int i = 0; (float)i < ((Unit) (FB))._fld0159 / 10F; i++)
                FC.drawImage(Constants.V.EA("heart.gif"), 240 - (i + 1) * 10, 5, 10, 7, Constants.U);

        }
    }

    public void D5(Rollerboy cb1)
    {
        FB = cb1;
    }

    public Rollerboy FB;
    private Graphics FC;
    private Font FD;
    private FontMetrics FE;
    private int FF;
    private int _fld0100;
    private float _fld0101;
    private float _fld0102;
}
