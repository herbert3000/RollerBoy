package rollerboy.units;

import rollerboy.Constants;

public final class Boob extends Unit
{

    public Boob(float f, float f1, float f2, float f3)
    {
        super(f, f1, f2, f3);
        super._fld0159 = 120F;
        super._fld015A = false;
    }

    public void _mth0110()
    {
        _mth010C("boob.gif", super._fld0151, super._fld0152);
    }

    public void _mth010E()
    {
        Constants.S._mth0103(new Ring(super._fld0151, super._fld0152, -1F, -8F));
        Constants.S._mth0103(new Ring(super._fld0151, super._fld0152, -0.5F, -10F));
        Constants.S._mth0103(new Ring(super._fld0151, super._fld0152, 0.5F, -7F));
        Constants.S._mth0103(new Ring(super._fld0151, super._fld0152, 1.0F, -11F));
        Constants.S._mth0103(new Points(super._fld0151, super._fld0152, 0.0F, -1F, 300));
        super._mth010E();
    }

    public void _mth0111()
    {
        _fld016D++;
        if(_fld016D > 90)
        {
            Constants.S._mth0103(new Bullet((int)(super._fld0151 + (float)(super._fld0162 / 2)), (int)(super._fld0152 + (float)(super._fld0163 / 2)), (((Unit) (Constants.Q))._fld0151 - super._fld0151) / 40F, (((Unit) (Constants.Q))._fld0152 - super._fld0152) / 40F));
            _fld016D = 0;
        }
    }

    int _fld016D;
}
