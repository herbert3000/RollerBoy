package rollerboy.units;

import java.util.Enumeration;

import rollerboy.Constants;
import rollerboy.litecom.Logger;

public final class Ball extends Unit
{

    public Ball(float f, float f1, float f2, float f3)
    {
        _fld012C = (float)Math.random() * 3F;
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
        _mth010C("ball.gif", super._fld0151, super._fld0152);
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
            E5();
            return;
        }
    }

    private void E5()
    {
        for(Enumeration enumeration = Constants.S._mth0104(); enumeration.hasMoreElements();)
        {
            Unit fb1 = (Unit)enumeration.nextElement();
            if(!fb1._mth0109())
            {
                boolean flag = false;
                if(fb1._fld0162 <= super._fld0162 && fb1._fld0151 + (float)(fb1._fld0162 / 2) > super._fld0151 && fb1._fld0152 + (float)(fb1._fld0163 / 2) > super._fld0152 && fb1._fld0151 + (float)(fb1._fld0162 / 2) < super._fld0151 + (float)super._fld0162 && fb1._fld0152 + (float)(fb1._fld0163 / 2) < super._fld0152 + (float)super._fld0163)
                    flag = true;
                if(fb1._fld0162 > super._fld0162 && super._fld0151 + (float)(super._fld0162 / 2) > fb1._fld0151 && super._fld0152 + (float)(super._fld0163 / 2) > fb1._fld0152 && super._fld0151 + (float)(super._fld0162 / 2) < fb1._fld0151 + (float)fb1._fld0162 && super._fld0152 + (float)(super._fld0163 / 2) < fb1._fld0152 + (float)fb1._fld0163)
                    flag = true;
                if(flag)
                    if((fb1 instanceof Ring) || (fb1 instanceof Spike))
                    {
                        return;
                    } else
                    {
                        fb1._mth0112(40F);
                        Logger.DA(this, "spanking: " + fb1.getClass().getName());
                        Constants.S._mth0103(new Fireball(super._fld0151, super._fld0152));
                        _mth010E();
                        return;
                    }
            }
        }

    }

    float _fld012C;
}
