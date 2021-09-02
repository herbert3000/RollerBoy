package rollerboy.units;

public final class Fireball extends Unit
{

    public Fireball(float f, float f1)
    {
        _fld0164 = 19;
        super._fld0151 = f;
        super._fld0152 = f1;
        super._fld015A = true;
    }

    public void _mth0110()
    {
        String s = "e" + _fld0164 / 5 + ".gif";
        _mth010C(s, super._fld0151, super._fld0152);
    }

    public void _mth0111()
    {
        _fld0164--;
        if(_fld0164 <= 0)
            _mth010E();
    }

    int _fld0164;
}
