package rollerboy.units;

import rollerboy.Constants;

public final class Bounce extends Enemy
{

    public Bounce(float f, float f1, float f2, float f3)
    {
        super(f, f1, f2, f3);
        super._fld015A = false;
    }

    public void _mth0110()
    {
        if(_fld0169 == 0)
            if(super.C > 0)
            {
                _mth010A("bounce1.gif", super._fld0151, super._fld0152 + (float)(super._fld0163 / 2), super._fld0162, super._fld0163 / 2);
                return;
            } else
            {
                _mth010C("bounce1.gif", super._fld0151, super._fld0152);
                return;
            }
        if(super.C > 0)
        {
            _mth010A("bounce2.gif", super._fld0151, super._fld0152 + (float)(super._fld0163 / 2), super._fld0162, super._fld0163 / 2);
            return;
        } else
        {
            _mth010C("bounce2.gif", super._fld0151, super._fld0152);
            return;
        }
    }

    public void _mth0111()
    {
        G();
        super._fld0154 += Constants.X;
        if(super._fld0154 < -10F)
            super._fld0154 = -10F;
        if(super._fld0154 > 10F)
            super._fld0154 = 10F;
        if(super._fld0153 < -5F)
            super._fld0153 = -5F;
        if(super._fld0153 > 5F)
            super._fld0153 = 5F;
        int i = F();
        if(i == 1)
            super._fld0153 = -1F;
        if(i == 2)
            super._fld0153 = 1.0F;
        if(i == 3 && super._fld0160)
            super._fld0154 = -10F;
        if(super.C == -1)
            super._fld0151 += super._fld0153;
        if(super.C == -1)
            super._fld0152 += super._fld0154;
        _mth010B();
        if(super._fld015C || super._fld015D)
            super._fld0153 = -super._fld0153;
        if(super._fld015F)
        {
            super._fld0154 = -6F;
            _fld0169 = 20;
        }
        if(_fld0169 > 0)
            _fld0169--;
        if(super._fld015E)
            super._fld0154 = 0.0F;
    }

    int _fld0169;
    int _fld016A;
}
