package rollerboy.units;

public final class Bee extends Enemy
{

    public Bee(float f, float f1, float f2, float f3)
    {
        super(f, f1, f2, f3);
        super._fld015A = false;
    }

    public void _mth0110()
    {
        if(_fld0165 == 0)
            if(super.C > 0)
            {
                _mth010A("bi1.gif", super._fld0151, super._fld0152 + (float)(super._fld0163 / 2), super._fld0162, super._fld0163 / 2);
                return;
            } else
            {
                _mth010C("bi1.gif", super._fld0151, super._fld0152);
                return;
            }
        if(super.C > 0)
        {
            _mth010A("bi2.gif", super._fld0151, super._fld0152 + (float)(super._fld0163 / 2), super._fld0162, super._fld0163 / 2);
            return;
        } else
        {
            _mth010C("bi2.gif", super._fld0151, super._fld0152);
            return;
        }
    }

    public void _mth0111()
    {
        _fld0166++;
        if(_fld0166 < 5)
            _fld0165 = 0;
        else
            _fld0165 = 1;
        if(_fld0166 > 10)
            _fld0166 = 0;
        G();
        if(super._fld0154 < -5F)
            super._fld0154 = -5F;
        if(super._fld0154 > 5F)
            super._fld0154 = 5F;
        if(super._fld0153 < -5F)
            super._fld0153 = -5F;
        if(super._fld0153 > 5F)
            super._fld0153 = 5F;
        int i = F();
        if(i == 1)
        {
            super._fld0153 = -1F;
            super._fld0154 = 0.0F;
        }
        if(i == 2)
        {
            super._fld0153 = 1.0F;
            super._fld0154 = 0.0F;
        }
        if(i == 3)
        {
            super._fld0154 = -1F;
            super._fld0153 = 0.0F;
        }
        if(i == 4)
        {
            super._fld0154 = 1.0F;
            super._fld0153 = 0.0F;
        }
        if(super.C == -1)
            super._fld0151 += super._fld0153;
        super._fld0152 += super._fld0154;
        if(super._fld0151 < 0.0F)
            super._fld0151 = 0.0F;
        _mth010B();
        if(super._fld015C || super._fld015D)
            super._fld0153 = -super._fld0153;
        if(super._fld015E || super._fld015F)
            super._fld0154 = -super._fld0154 / 3F;
    }

    int _fld0165;
    int _fld0166;
    float _fld0167;
    float _fld0168;
}
