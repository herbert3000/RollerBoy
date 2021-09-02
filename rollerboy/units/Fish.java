package rollerboy.units;

import rollerboy.Constants;
import rollerboy.litecom.Logger;

public final class Fish extends Enemy
{

    public Fish(float f, float f1, float f2, float f3)
    {
        super(f, f1, f2, f3);
        _fld012D = -1;
        _fld012E = f3;
        super._fld0159 = 30F;
        super._fld015A = false;
    }

    public void _mth0110()
    {
        _mth010C("fish.gif", super._fld0151, super._fld0152);
    }

    public void _mth010E()
    {
        Constants.S._mth0103(new Ring(super._fld0151, super._fld0152, 0.0F, -10F));
        super._mth010E();
    }

    public void _mth0111()
    {
        if(_fld012D >= 0)
            _fld012D++;
        super._fld0154 += Constants.X / 2.0F;
        if((double)Math.abs(super._fld0153) < 0.01D)
            super._fld0153 = 0.0F;
        if((double)Math.abs(super._fld0154) < 0.01D)
            super._fld0154 = 0.0F;
        if(super._fld0154 < -10F)
            super._fld0154 = -10F;
        if(super._fld0154 > 10F)
            super._fld0154 = 10F;
        super._fld0151 += super._fld0153;
        super._fld0152 += super._fld0154;
        if(super._fld0151 < 0.0F)
            super._fld0151 = 0.0F;
        if(super._fld0152 > 240F && _fld012D == -1)
        {
            Logger.DA(this, "out of bounds");
            super._fld0154 = 0.0F;
            _fld012D = 0;
        }
        if(_fld012D > 90)
        {
            Logger.DA(this, "hit it!");
            _fld012D = -1;
            super._fld0154 = _fld012E;
            super._fld0152 = 230F;
        }
        _mth010B();
        if(super._fld015C || super._fld015D)
            super._fld0153 = -super._fld0153;
        if(super._fld015E || super._fld015F)
            super._fld0154 = -super._fld0154 / 3F;
    }

    int _fld012D;
    float _fld012E;
}
