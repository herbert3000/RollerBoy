package rollerboy.units;

import java.awt.Color;
import java.awt.Graphics;

import rollerboy.Constants;

public final class Points extends Unit
{

    public Points(float f, float f1, float f2, float f3, int i)
    {
        super(f, f1, f2, f3);
        _fld017A = i;
        super._fld015A = true;
        Constants.Q.F0(i);
    }

    public void _mth0110()
    {
        Constants.Y.setColor(Color.white);
        int i = (int)super._fld0151 + Constants.R.E3;
        int k = (int)super._fld0152 + 10;
        Constants.Y.drawString("" + _fld017A, i, k);
    }

    public void _mth0111()
    {
        _fld017B++;
        if(_fld017B > 50)
        {
            _mth010E();
            return;
        } else
        {
            super._fld0152 += super._fld0154;
            return;
        }
    }

    int _fld017A;
    int _fld017B;
}
