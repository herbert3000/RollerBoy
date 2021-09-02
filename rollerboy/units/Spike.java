package rollerboy.units;

import rollerboy.Constants;

public final class Spike extends Unit
{

    public Spike(float f, float f1, float f2, float f3)
    {
        super(f, f1, f2, f3);
        super._fld0159 = 80F;
        super._fld015A = false;
    }

    public void _mth0110()
    {
        _mth010C("spike" + _fld016B + ".gif", super._fld0151, super._fld0152);
    }

    public void _mth0111()
    {
        if(Math.abs(((Unit) (Constants.Q))._fld0151 - super._fld0151) < 60F)
        {
            if(_fld016B < 2)
            {
                _fld016B++;
                return;
            }
        } else
        if(_fld016B > 0)
            _fld016B--;
    }

    int _fld016B;
}
