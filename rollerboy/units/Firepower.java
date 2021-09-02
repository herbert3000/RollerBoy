package rollerboy.units;

import rollerboy.Constants;

public final class Firepower extends Unit
{

    public Firepower(float f, float f1, float f2, float f3)
    {
        super(f, f1, f2, f3);
        _fld017E = false;
        super._fld015A = false;
    }

    public Firepower(float f, float f1, float f2, float f3, boolean flag)
    {
        super(f, f1, f2, f3);
        _fld017E = false;
        super._fld015A = false;
        _fld017E = flag;
    }

    public void _mth0110()
    {
        String s = "h" + (int)_fld017D + ".gif";
        _mth010C(s, super._fld0151, super._fld0152);
    }

    public void _mth0111()
    {
        _fld017C++;
        if(_fld017C > 10)
        {
            _fld017D = (float)Math.random() * 4F;
            if(_fld017D >= 4F)
                _fld017D--;
            _fld017C = 0;
        }
        if(_fld017E)
        {
            super._fld0154 += Constants.X;
            super._fld0153 = super._fld0153 * 0.99F;
        } else
        {
            super._fld0154 = (float)Math.sin(_fld017F) / 2.0F;
            _fld017F += 0.080000000000000002D;
        }
        super._fld0152 += super._fld0154;
        super._fld0151 += super._fld0153;
        _mth010B();
        if(super._fld0160)
            super._fld0154 = -super._fld0154 / 2.0F;
    }

    int _fld017C;
    float _fld017D;
    boolean _fld017E;
    float _fld017F;
}
