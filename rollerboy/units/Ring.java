package rollerboy.units;

import rollerboy.Constants;

public final class Ring extends Unit
{

    public Ring(float f, float f1, float f2, float f3)
    {
        super(f, f1, f2, f3);
        super._fld015A = false;
    }

    public void _mth0110()
    {
        String s1 = "t" + (int)_fld0112 + ".gif";
        _mth010C(s1, super._fld0151, super._fld0152);
    }

    public void _mth0111()
    {
        _fld0112 += 0.10000000000000001D;
        if(_fld0112 >= 6F)
            _fld0112 = 0.0F;
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

    float _fld0112;
}
