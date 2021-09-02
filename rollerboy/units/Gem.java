package rollerboy.units;

public final class Gem extends Unit
{

    public Gem(float f, float f1, float f2, float f3)
    {
        super(f, f1, f2, f3);
        super._fld0159 = 10000F;
        super._fld015A = false;
    }

    public void _mth0110()
    {
        _mth010C("gem000" + (int)_fld016E + ".gif", super._fld0151, super._fld0152);
    }

    public void _mth0111()
    {
        _fld016E += 0.29999999999999999D;
        if(_fld016E >= 8F)
            _fld016E = 0.0F;
    }

    private float _fld016E;
}
