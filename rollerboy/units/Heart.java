package rollerboy.units;

import rollerboy.Constants;

public final class Heart extends Unit
{

    public Heart(float f, float f1, float f2, float f3)
    {
        super(f, f1, f2, f3);
        super._fld015A = false;
    }

    public void _mth0110()
    {
        _mth010C("heart.gif", super._fld0151, super._fld0152);
    }

    public void _mth0111()
    {
        super._fld0154 += Constants.X;
        super._fld0152 += super._fld0154;
        super._fld0151 += super._fld0153;
        super._fld0153 = super._fld0153 * 0.99F;
        _mth010B();
        if(super._fld0160)
            super._fld0154 = -super._fld0154 * 0.8F;
        if(super._fld0152 > 240F)
            _mth010E();
    }
}
