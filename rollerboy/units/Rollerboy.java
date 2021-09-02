package rollerboy.units;

import java.util.Enumeration;
import java.util.Vector;

import rollerboy.MarioII;
import rollerboy.Constants;
import rollerboy.litecom.Logger;

public final class Rollerboy extends Unit
{

    public Rollerboy(float f, float f1, float f2, float f3)
    {
        super(f, f1, f2, f3);
        _fld0134 = false;
        _fld0135 = false;
        _fld0136 = false;
        _fld0137 = 1;
        _fld013A = true;
        _fld013B = false;
        _fld013C = false;
        _fld013E = 2;
        _fld0140 = false;
        _fld0141 = true;
        _fld0143 = -1;
        super._fld015A = true;
    }

    public void F6(int i)
    {
        if(_fld013C && i > 0)
        {
            Constants.S._mth0103(new Firepower((int)super._fld0151, (int)(super._fld0152 - 30F), (float)(Math.random() * 6D - 3D), -7F, true));
            _fld013C = false;
        }
        super._mth0112(i);
    }

    public void _mth0110()
    {
        if(_fld0138 > 0)
            _fld013A = !_fld013A;
        else
            _fld013A = true;
        if(!_fld013A)
            return;
        String s1 = null;
        if(!super._fld0160)
        {
            if(super._fld0154 < 0.0F)
                s1 = "p-jumpu.gif";
            else
                s1 = "p-jumpd.gif";
        } else
        if(_fld0137 == -1)
        {
            if(super._fld0153 > 0.0F)
                s1 = "p-breakr.gif";
            else
                s1 = "p-rolll.gif";
        } else
        if(super._fld0153 < 0.0F)
            s1 = "p-breakl.gif";
        else
            s1 = "p-rollr.gif";
        _mth010C(s1, super._fld0151, super._fld0152);
    }

    public void _mth010E()
    {
        _fld013E--;
        if(_fld013E < 0)
            super._fld015B = true;
        else
            _fld013B = true;
        _fld013C = false;
        Constants.S._mth0100(this);
        Logger.DA(this, "damn! Im dead. lifes: " + _fld013E + ", dead: " + super._fld015B);
    }

    public void _mth0111()
    {
        float f = super._fld0151;
        float f1 = super._fld0152;
        if(_fld0134)
            super._fld0153 -= 0.1F;
        else
        if(_fld0135)
            super._fld0153 += 0.1F;
        else
        if(super._fld0160)
            super._fld0153 *= 0.80000000000000004D;
        else
            super._fld0153 *= 0.94999999999999996D;
        if(super._fld0160 && _fld0136 && !_fld0140 && _fld0141)
        {
            _fld0140 = true;
            _fld0142 = 0;
            _fld0141 = false;
        }
        if(_fld0136 && _fld0140)
            super._fld0154 = -4F;
        if(_fld0142 > 16)
            _fld0140 = false;
        _fld0142++;
        if(_fld0138 > 0)
            _fld0138--;
        super._fld0154 += Constants.X;
        if(super._fld0154 < -6F)
            super._fld0154 = -6F;
        if(super._fld0154 > 6F)
            super._fld0154 = 6F;
        if(super._fld0153 < -2.8F)
            super._fld0153 = -2.8F;
        if(super._fld0153 > 2.8F)
            super._fld0153 = 2.8F;
        if(super._fld0151 < Constants.R.DA)
        {
            super._fld0151 = Constants.R.DA;
            super._fld0153 = 0.0F;
        }
        if(super._fld0152 > 240F)
            _mth010E();
        super._fld0151 += super._fld0153;
        super._fld0152 += super._fld0154;
        FB();
        _mth010B();
        if(super._fld015C || super._fld015D)
            super._fld0153 = 0.0F;
        if(super._fld015E || super._fld015F)
        {
            _fld0140 = false;
            super._fld0154 = 0.0F;
        }
    }

    private void FB()
    {
        for(Enumeration enumeration = Constants.S._mth0104(); enumeration.hasMoreElements();)
        {
            Unit fb1 = (Unit)enumeration.nextElement();
            if(!fb1._mth0109() && !fb1._fld015B)
            {
                boolean flag = false;
                if(fb1._fld0162 <= super._fld0162 && fb1._fld0151 + (float)(fb1._fld0162 / 2) > super._fld0151 && fb1._fld0152 + (float)(fb1._fld0163 / 2) > super._fld0152 && fb1._fld0151 + (float)(fb1._fld0162 / 2) < super._fld0151 + (float)super._fld0162 && fb1._fld0152 + (float)(fb1._fld0163 / 2) < super._fld0152 + (float)super._fld0163)
                    flag = true;
                if(fb1._fld0162 > super._fld0162 && super._fld0151 + (float)(super._fld0162 / 2) > fb1._fld0151 && super._fld0152 + (float)(super._fld0163 / 2) > fb1._fld0152 && super._fld0151 + (float)(super._fld0162 / 2) < fb1._fld0151 + (float)fb1._fld0162 && super._fld0152 + (float)(super._fld0163 / 2) < fb1._fld0152 + (float)fb1._fld0163)
                    flag = true;
                if(flag)
                    if(fb1 instanceof Dollar)
                    {
                        fb1._mth010E();
                        Logger.DA(this, "Dollar!");
                        Constants.R.E4.addElement(new Integer(((int)fb1._fld0152 / 24) * 200 + (int)fb1._fld0151 / 24));
                        Constants.S._mth0103(new Points(super._fld0151, super._fld0152, 0.0F, -1F, 0x493e0));
                    } else
                    if(fb1 instanceof Firepower)
                    {
                        if(!((Firepower)fb1)._fld017E)
                            Constants.S._mth0103(new Points(super._fld0151, super._fld0152, 0.0F, -1F, 2000));
                        fb1._mth010E();
                        Logger.DA(this, "FIRE!!!!!");
                        _fld013C = true;
                    } else
                    if(fb1 instanceof Gem)
                    {
                        fb1._mth010E();
                        Logger.DA(this, "End of level.");
                        Constants.R.DE = true;
                    } else
                    if(fb1 instanceof Ring)
                    {
                        fb1._mth010E();
                        Constants.S._mth0103(new Points(super._fld0151, super._fld0152, 0.0F, -1F, 500));
                        _fld013D++;
                        Logger.DA(this, "pling!");
                    } else
                    if(fb1 instanceof Heart)
                    {
                        Logger.DA(this, "Ahhh!");
                        F6(-10);
                        Logger.DA(this, "Hilfe: " + super._fld0159);
                        fb1._mth010E();
                        Constants.S._mth0103(new Points(super._fld0151, super._fld0152, 0.0F, -1F, 1000));
                    } else
                    if(fb1 instanceof Smiley)
                    {
                        Logger.DA(this, "1UP!!");
                        _fld013E++;
                        Constants.R.E4.addElement(new Integer(((int)fb1._fld0152 / 24) * 200 + (int)fb1._fld0151 / 24));
                        fb1._mth010E();
                        Constants.S._mth0103(new Points(super._fld0151, super._fld0152, 0.0F, -1F, 5000));
                    } else
                    if(super._fld0154 > 4F && (fb1 instanceof Enemy))
                    {
                        super._fld0154 = -10F;
                        if(((Enemy)fb1).C < 0)
                            ((Enemy)fb1).E();
                    } else
                    if(_fld0138 <= 0)
                    {
                        Logger.DA(this, "OUCH!");
                        F6(30);
                        super._fld0151 = super._fld0155;
                        super._fld0152 = super._fld0156;
                        super._fld0154 = -10F;
                        _fld0138 = 130;
                    }
            }
        }

    }

    public int F8()
    {
        return _fld0139 / 7;
    }

    public void F0(int i)
    {
        if(_fld0143 != -1 && _fld0143 != _fld0139 / 2)
            MarioII.Q().P(-1);
        _fld0139 += i * 7;
        _fld0143 = _fld0139 / 2;
    }

    public void FA()
    {
        if(_fld0143 != -1 && _fld0143 != _fld0139 / 2)
        {
            _fld0139 = 0;
            MarioII.Q().P(-1);
        }
    }

    public void F3()
    {
        _fld0134 = true;
        _fld0137 = -1;
    }

    public void F2()
    {
        _fld0135 = true;
        _fld0137 = 1;
    }

    public void F5()
    {
        _fld0134 = false;
    }

    public void EF()
    {
        _fld0135 = false;
    }

    public void F4()
    {
        _fld0136 = true;
    }

    public void F9()
    {
        _fld0136 = false;
        _fld0141 = true;
    }

    public void F1()
    {
        if(!_fld013C)
            return;
        float f = 4F;
        if(_fld0137 == -1)
            f = -f;
        Constants.S._mth0103(new Ball((int)(super._fld0151 + (float)(super._fld0162 / 2)), (int)super._fld0152 + 10, f, 0.0F));
    }

    private boolean _fld0134;
    private boolean _fld0135;
    private boolean _fld0136;
    private int _fld0137;
    private int _fld0138;
    private int _fld0139;
    private boolean _fld013A;
    public boolean _fld013B;
    public boolean _fld013C;
    public int _fld013D;
    public int _fld013E;
    private static final float _fld013F = 0.1F;
    private boolean _fld0140;
    private boolean _fld0141;
    private int _fld0142;
    private int _fld0143;
}
