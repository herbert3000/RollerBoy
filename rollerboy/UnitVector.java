package rollerboy;

import java.util.Enumeration;
import java.util.Vector;
import rollerboy.litecom.Logger;
import rollerboy.units.Unit;

public final class UnitVector
{

    public void _mth0108()
    {
        for(int i = 0; i < _fld0150.size(); i++)
        {
            Unit fb1 = (Unit)_fld0150.elementAt(i);
            if(!fb1._fld015B && fb1._fld0151 >= Constants.R.DA && fb1._fld0151 <= Constants.R.DA + 240F)
            {
                fb1._mth0110();
                fb1._fld0161 = true;
            }
        }

    }

    public void _mth0102()
    {
        for(int i = 0; i < _fld0150.size(); i++)
        {
            Unit fb1 = (Unit)_fld0150.elementAt(i);
            fb1._mth010D();
            if(fb1._fld015B)
            {
                _mth0101(i);
                i--;
            }
        }

    }

    public void _mth0105()
    {
        for(int i = 0; i < _fld0150.size(); i++)
        {
            Unit fb1 = (Unit)_fld0150.elementAt(i);
            if(!fb1._fld015B)
            {
                fb1._mth0111();
                if(fb1._fld0151 < Constants.R.DA - 240F)
                {
                    fb1._mth010E();
                    Logger.DA(this, "out: " + fb1.getClass().getName());
                }
            }
        }

    }

    public void _mth0106()
    {
        _fld0150 = new Vector();
    }

    public void _mth0103(Unit fb1)
    {
        _fld0150.addElement(fb1);
    }

    public void _mth0100(Unit fb1)
    {
        _fld0150.removeElement(fb1);
    }

    public void _mth0101(int i)
    {
        _fld0150.removeElementAt(i);
    }

    public Enumeration _mth0104()
    {
        return _fld0150.elements();
    }

    public Unit _mth0107(int i)
    {
        return (Unit)_fld0150.elementAt(i);
    }

    public UnitVector()
    {
        _fld0150 = new Vector();
    }

    Vector _fld0150;
}
