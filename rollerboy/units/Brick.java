package rollerboy.units;

import rollerboy.Constants;

public final class Brick extends Unit
{

    public Brick(float f, float f1, float f2, float f3)
    {
        super(f, f1, f2, f3);
        super._fld015A = true;
    }

    public void _mth0110()
    {
        String s = null;
        if(super._fld0153 < 0.0F)
            s = "brick-1.gif";
        else
            s = "brick-2.gif";
        _mth010C(s, super._fld0151, super._fld0152);
    }

    public void _mth0111()
    {
        super._fld0154 += Constants.X;
        super._fld0152 += super._fld0154;
        super._fld0151 += super._fld0153;
        if(super._fld0152 > 240F)
            _mth010E();
    }
}
