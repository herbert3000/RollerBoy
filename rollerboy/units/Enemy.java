package rollerboy.units;

import java.util.Enumeration;

import rollerboy.Constants;

public abstract class Enemy extends Unit
{

    public Enemy(float f, float f1, float f2, float f3)
    {
        super(f, f1, f2, f3);
        C = -1;
    }

    public void E()
    {
        C = 25;
    }

    public void _mth010E()
    {
        Constants.S._mth0103(new Points(super._fld0151, super._fld0152, 0.0F, -1F, 300));
        super._mth010E();
    }

    public void G()
    {
        if(C >= 0)
        {
            C--;
            if(C == 0)
                _mth010E();
        }
    }

    protected int F()
    {
        for(Enumeration enumeration = Constants.S._mth0104(); enumeration.hasMoreElements();)
        {
            Unit fb1 = (Unit)enumeration.nextElement();
            if((fb1 instanceof Arrow) && fb1._fld0151 + (float)(fb1._fld0162 / 2) > super._fld0151 && fb1._fld0152 + (float)(fb1._fld0163 / 2) > super._fld0152 && fb1._fld0151 + (float)(fb1._fld0162 / 2) < super._fld0151 + (float)super._fld0162 && fb1._fld0152 + (float)(fb1._fld0163 / 2) < super._fld0152 + (float)super._fld0163)
            {
                if(fb1._fld0153 < 0.0F)
                    return 1;
                if(fb1._fld0153 > 0.0F)
                    return 2;
                if(fb1._fld0154 < 0.0F)
                    return 3;
                if(fb1._fld0154 > 0.0F)
                    return 4;
            }
        }

        return 0;
    }

    int C;
    public static final int D = 1;
    public static final int E = 2;
    public static final int F = 3;
    public static final int G = 4;
}
