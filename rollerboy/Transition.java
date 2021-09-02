package rollerboy;

import java.awt.Color;
import java.awt.Graphics;

final class Transition
{

    public Transition(int i, int j, int k, int l, int i1, int j1, Graphics g)
    {
        _fld0170 = i;
        _fld0171 = j;
        _fld0172 = k;
        _fld0173 = l;
        _fld0174 = i1;
        _fld0176 = j1;
        _fld0178 = g;
        _fld0175 = l / i1;
        _fld016F = new int[_fld0175];
        for(int k1 = 0; k1 < _fld0175; k1++)
            _fld016F[k1] = -k1 / 2;

    }

    public boolean _mth0115()
    {
        _fld0177++;
        if(_fld0177 % _fld0176 != 0)
            return false;
        _fld0178.setColor(Color.black);
        for(int i = 0; i < _fld0175; i++)
        {
            if(_fld016F[i] >= 0 && _fld016F[i] < _fld0174)
            {
                int j = _fld0171 + i * _fld0174 + _fld016F[i];
                _fld0178.drawLine(_fld0170, j, (_fld0170 + _fld0172) - 1, j);
            }
            _fld016F[i]++;
        }

        return _fld016F[_fld0175 - 1] == _fld0174;
    }

    int _fld016F[];
    int _fld0170;
    int _fld0171;
    int _fld0172;
    int _fld0173;
    int _fld0174;
    int _fld0175;
    int _fld0176;
    int _fld0177;
    Graphics _fld0178;
    private boolean _fld0179;
}
