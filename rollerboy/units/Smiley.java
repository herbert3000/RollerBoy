package rollerboy.units;

public final class Smiley extends Unit
{

    public Smiley(float f, float f1, float f2, float f3)
    {
        super(f, f1, f2, f3);
        super._fld015A = false;
    }

    public void _mth0110()
    {
        _mth010C("1up.gif", super._fld0151, super._fld0152);
    }

    public void _mth0111()
    {
        super._fld0152 += super._fld0154;
        super._fld0151 += super._fld0153;
        _mth010B();
        if(super._fld0160)
            super._fld0154 = -super._fld0154 / 2.0F;
        if(super._fld015C || super._fld015D)
            super._fld0153 = -super._fld0153;
    }
}
