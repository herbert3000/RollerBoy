package rollerboy.units;

import java.awt.Graphics;

import rollerboy.Constants;
import rollerboy.litecom.ImageHandler;
import rollerboy.litecom.Logger;

public abstract class Unit
{

    public Unit()
    {
        _fld0159 = 100F;
        _fld015B = false;
        _fld0161 = true;
        _fld0162 = 24;
        _fld0163 = 24;
    }

    public Unit(float f, float f1, float f2, float f3)
    {
        _fld0159 = 100F;
        _fld015B = false;
        _fld0161 = true;
        _fld0162 = 24;
        _fld0163 = 24;
        _fld0151 = f;
        _fld0152 = f1;
        _fld0153 = f2;
        _fld0154 = f3;
        _fld0155 = f;
        _fld0156 = f1;
    }

    public abstract void _mth0110();

    public abstract void _mth0111();

    public void _mth010D()
    {
        if(!_fld0161)
        {
            return;
        } else
        {
            _fld0161 = false;
            int i = (int)(_fld0155 / 24F);
            int k = (int)(_fld0156 / 24F);
            Constants.R.C7(i, k, Constants.Y);
            Constants.R.C7(i + 1, k, Constants.Y);
            Constants.R.C7(i, k + 1, Constants.Y);
            Constants.R.C7(i + 1, k + 1, Constants.Y);
            _fld0155 = _fld0151;
            _fld0156 = _fld0152;
            return;
        }
    }

    protected void _mth010C(String s1, float f, float f1)
    {
        int i = (int)f + Constants.R.E3;
        int k = (int)f1;
        Constants.Y.drawImage(Constants.V.EA(s1), i, k, Constants.U);
    }

    protected void _mth010A(String s1, float f, float f1, int i, int k)
    {
        int l = (int)f + Constants.R.E3;
        int i1 = (int)f1;
        Constants.Y.drawImage(Constants.V.EA(s1), l, i1, i, k, Constants.U);
    }

    protected void _mth010B()
    {
        if(_fld0162 == 24 && _fld0163 == 24)
        {
            _mth010F();
            return;
        } else
        {
            _mth0113();
            return;
        }
    }

    protected void _mth0113()
    {
        if(Constants.T.E4(Constants.R.C8((int)((_fld0151 + (float)(_fld0162 / 2)) / 24F), (int)((_fld0152 + (float)(_fld0163 / 2)) / 24F)))._fld0103)
        {
            _fld015C = true;
            _fld015D = true;
            _fld015E = true;
            _fld015F = true;
        }
    }

    protected void _mth010F()
    {
        _fld015C = false;
        _fld015D = false;
        _fld015E = false;
        _fld015F = false;
        _fld0152 += 4800F;
        int i = (int)(_fld0151 / 24F);
        int i1 = (int)(_fld0152 / 24F);
        _fld0152 -= 4800F;
        i1 -= 200;
        boolean flag = Constants.T.E4(Constants.R.C8(i, i1))._fld0103;
        boolean flag1 = Constants.T.E4(Constants.R.C8(i + 1, i1))._fld0103;
        boolean flag2 = Constants.T.E4(Constants.R.C8(i + 1, i1 + 1))._fld0103;
        boolean flag3 = Constants.T.E4(Constants.R.C8(i, i1 + 1))._fld0103;
        if(flag || flag1 || flag2 || flag3)
        {
            if(flag && flag1)
            {
                _fld0152 = (i1 + 1) * 24;
                _fld015E = true;
            }
            if(flag1 && flag2)
            {
                _fld0151 = i * 24;
                _fld015D = true;
            }
            if(flag2 && flag3)
            {
                _fld0152 = i1 * 24;
                _fld015F = true;
            }
            if(flag3 && flag)
            {
                _fld0151 = (i + 1) * 24;
                _fld015C = true;
            }
            if(!_fld015E && !_fld015F && !_fld015C && !_fld015D)
            {
                float f = 13F;
                float f1 = _fld0157;
                float f2 = _fld0158;
                for(int k2 = 0; (float)k2 < f; k2++)
                {
                    int k = (int)(f1 / 24F);
                    int j1 = (int)(f2 / 24F);
                    if((int)(f2 % 24F) == 0 && !_fld015E && !_fld015F)
                    {
                        if(_fld0154 > 0.0F)
                        {
                            boolean flag4 = Constants.T.E4(Constants.R.C8(k, j1 + 1))._fld0103;
                            if((int)(f1 % 24F) != 0)
                                flag4 = flag4 || Constants.T.E4(Constants.R.C8(k + 1, j1 + 1))._fld0103;
                            if(flag4)
                            {
                                _fld015F = true;
                                _fld0152 = (int)(f2 / 24F) * 24;
                            }
                        }
                        if(_fld0154 < 0.0F)
                        {
                            boolean flag5 = Constants.T.E4(Constants.R.C8(k, j1 - 1))._fld0103;
                            if((int)(f1 % 24F) != 0)
                                flag5 = flag5 || Constants.T.E4(Constants.R.C8(k + 1, j1 - 1))._fld0103;
                            if(flag5)
                            {
                                _fld015E = true;
                                _fld0152 = (int)(f2 / 24F) * 24;
                            }
                        }
                    }
                    if((int)(f1 % 24F) == 0 && !_fld015C && !_fld015D)
                    {
                        if(_fld0153 > 0.0F)
                        {
                            boolean flag6 = Constants.T.E4(Constants.R.C8(k + 1, j1))._fld0103;
                            if((int)(f2 % 24F) != 0)
                                flag6 = flag6 || Constants.T.E4(Constants.R.C8(k + 1, j1 + 1))._fld0103;
                            if(flag6)
                            {
                                _fld015D = true;
                                _fld0151 = (int)(f1 / 24F) * 24;
                            }
                        }
                        if(_fld0153 < 0.0F)
                        {
                            boolean flag7 = Constants.T.E4(Constants.R.C8(k - 1, j1))._fld0103;
                            if((int)(f2 % 24F) != 0)
                                flag7 = flag7 || Constants.T.E4(Constants.R.C8(k - 1, j1 + 1))._fld0103;
                            if(flag7)
                            {
                                _fld015C = true;
                                _fld0151 = (int)(f1 / 24F) * 24;
                            }
                        }
                    }
                    f1 += _fld0153 / f;
                    f2 += _fld0154 / f;
                }

            }
        }
        if(_fld015E && _fld0154 < 0.0F && (this instanceof Rollerboy))
        {
            int l = (int)((_fld0151 + (float)(_fld0162 / 2)) / 24F);
            int k1 = (int)(_fld0152 / 24F) - 1;
            int l1 = -1;
            int i2 = -1;
            if(Constants.R.C8(l, k1) >= 24)
            {
                l1 = l;
                i2 = k1;
            } else
            if(Constants.R.C8(l + 1, k1) >= 24)
            {
                l1 = l + 1;
                i2 = k1;
            }
            if(l1 != -1)
            {
                if(Constants.R.v(l1, i2) > 0)
                {
                    Constants.S._mth0103(new Ring((float)l1 * 24F, (float)i2 * 24F, 0.0F, -6F));
                    Constants.R.C9(l1, i2, (byte)(Constants.R.v(l1, i2) - 1));
                }
                if(Constants.R.v(l1, i2) < 0)
                {
                    for(int j2 = 0; j2 < -Constants.R.v(l1, i2); j2++)
                        Constants.S._mth0103(new Heart((float)l1 * 24F, (float)i2 * 24F, (float)((Math.random() - 0.5D) * 3D), (float)(-8D + Math.random() * 2D)));

                    Constants.R.C9(l1, i2, (byte)0);
                }
                if(Constants.R.v(l1, i2) == 0)
                {
                    Constants.S._mth0103(new Brick((float)l1 * 24F, (float)i2 * 24F, -1F, -8F));
                    Constants.S._mth0103(new Brick((float)l1 * 24F, (float)i2 * 24F, 1.0F, -8F));
                    byte byte0 = 0;
                    Constants.R.j(l1, i2, byte0);
                    Constants.R.C3(l1, i2);
                }
            }
        }
        _fld0160 = _fld015F;
        _fld0157 = _fld0151;
        _fld0158 = _fld0152;
    }

    public void _mth010E()
    {
        _fld015B = true;
    }

    public void _mth0112(float f)
    {
        _fld0159 -= f;
        Logger.DA(this, "Ouch! hilfe:" + _fld0159);
        if(_fld0159 <= 0.0F)
            _mth010E();
    }

    public boolean _mth0109()
    {
        return _fld015A;
    }

    public float _fld0151;
    public float _fld0152;
    public float _fld0153;
    public float _fld0154;
    public float _fld0155;
    public float _fld0156;
    public float _fld0157;
    public float _fld0158;
    public float _fld0159;
    protected boolean _fld015A;
    public boolean _fld015B;
    protected boolean _fld015C;
    protected boolean _fld015D;
    protected boolean _fld015E;
    protected boolean _fld015F;
    protected boolean _fld0160;
    public boolean _fld0161;
    public int _fld0162;
    public int _fld0163;
}
