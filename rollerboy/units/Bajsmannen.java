package rollerboy.units;

import rollerboy.Constants;

public final class Bajsmannen extends Enemy
{

    public Bajsmannen(float f, float f1, float f2, float f3)
    {
        super(f, f1, f2, f3);
        super._fld015A = false;
    }

    public void _mth0110()
    {
        if(_fld012A == 0)
            if(super.C > 0)
            {
                _mth010A("bajsmannen1.gif", super._fld0151, super._fld0152 + (float)(super._fld0163 / 2), super._fld0162, super._fld0163 / 2);
                return;
            } else
            {
                _mth010C("bajsmannen1.gif", super._fld0151, super._fld0152);
                return;
            }
        if(super.C > 0)
        {
            _mth010A("bajsmannen1.gif", super._fld0151, super._fld0152 + (float)(super._fld0163 / 2), super._fld0162, super._fld0163 / 2);
            return;
        } else
        {
            _mth010C("bajsmannen1.gif", super._fld0151, super._fld0152);
            return;
        }
    }

    public void _mth0111()
    {
        _fld012B++;
        if(_fld012B < 20)
            _fld012A = 0;
        else
            _fld012A = 1;
        if(_fld012B > 40)
            _fld012B = 0;
        G();
        super._fld0154 += Constants.X;
        if((double)Math.abs(super._fld0153) < 0.01D)
            super._fld0153 = 0.0F;
        if((double)Math.abs(super._fld0154) < 0.01D)
            super._fld0154 = 0.0F;
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
        if(i == 3)
            super._fld0154 = -10F;
        if(super.C == -1)
            super._fld0151 += super._fld0153;
        super._fld0152 += super._fld0154;
        if(super._fld0151 < 0.0F)
            super._fld0151 = 0.0F;
        if(super._fld0152 < 0.0F)
            super._fld0152 = 0.0F;
        _mth010B();
        if(super._fld015C || super._fld015D)
            super._fld0153 = -super._fld0153;
        if(super._fld015E || super._fld015F)
            super._fld0154 = -super._fld0154 / 3F;
    }

    int _fld012A;
    int _fld012B;
}
