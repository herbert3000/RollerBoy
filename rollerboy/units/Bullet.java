package rollerboy.units;

import rollerboy.Constants;
import rollerboy.litecom.Logger;

public final class Bullet extends Unit
{

    public Bullet(float f, float f1, float f2, float f3)
    {
        _fld016C = (float)Math.random() * 3F;
        super._fld0162 = 10;
        super._fld0163 = 10;
        super._fld0151 = f;
        super._fld0152 = f1;
        super._fld0153 = f2;
        super._fld0154 = f3;
        super._fld015A = true;
    }

    public void _mth0110()
    {
        _mth010C("nmiball.gif", super._fld0151, super._fld0152);
    }

    public void _mth0111()
    {
        if(super._fld0154 < -10F)
            super._fld0154 = -10F;
        if(super._fld0154 > 10F)
            super._fld0154 = 10F;
        if(super._fld0153 < -10F)
            super._fld0153 = -10F;
        if(super._fld0153 > 10F)
            super._fld0153 = 10F;
        super._fld0151 += super._fld0153;
        super._fld0152 += super._fld0154;
        if(super._fld0151 < Constants.R.DA || super._fld0152 < 0.0F || super._fld0151 > Constants.R.DA + 240F || super._fld0152 > 240F)
        {
            _mth010E();
            return;
        }
        _mth010B();
        if(super._fld015C || super._fld015D || super._fld015E || super._fld015F)
        {
            Constants.S._mth0103(new Fireball(super._fld0151, super._fld0152));
            _mth010E();
            return;
        } else
        {
            _mth0114();
            return;
        }
    }

    private void _mth0114()
    {
        Rollerboy cb1 = Constants.Q;
        if(super._fld0151 + (float)(super._fld0162 / 2) > ((Unit) (cb1))._fld0151 && super._fld0152 + (float)(super._fld0163 / 2) > ((Unit) (cb1))._fld0152 && super._fld0151 + (float)(super._fld0162 / 2) < ((Unit) (cb1))._fld0151 + (float)((Unit) (cb1))._fld0162 && super._fld0152 + (float)(super._fld0163 / 2) < ((Unit) (cb1))._fld0152 + (float)((Unit) (cb1))._fld0163)
        {
            Logger.DA(this, "MOTHERFUCKING!");
            Constants.Q.F6(20);
            Constants.S._mth0103(new Fireball(super._fld0151, super._fld0152));
            _mth010E();
        }
    }

    float _fld016C;
}
