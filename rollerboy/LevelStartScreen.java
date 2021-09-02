package rollerboy;

import java.awt.Color;
import java.awt.Graphics;

class LevelStartScreen
{

    public LevelStartScreen(String as[], Graphics g)
    {
        _fld0111 = g;
        _fld010E = as;
        _fld010F = new float[as.length];
        _fld0110 = new float[as.length];
        int i = 0;
        do
        {
            _fld010F[i] = -100 - i * 20;
            _fld0110[i] = 0.0F;
        } while(++i < as.length);
    }

    public void E0(int i)
    {
        _fld0111.setColor(Color.black);
        _fld0111.fillRect(0, 0, 240, 240);
        _fld0111.setColor(Color.white);
        int j = 80;
        boolean flag = false;
        for(int k = 0; k < 5; k++)
        {
            _fld0111.drawString(_fld010E[k], (int)_fld010F[k], j);
            j += 20;
            if(_fld010F[k] > 60F && i < 900 + k * 30)
            {
                _fld010F[k] = 60F;
                _fld0110[k] = -_fld0110[k] * 0.7F;
            }
            _fld0110[k] += 0.10000000000000001D;
            _fld010F[k] += _fld0110[k];
        }

    }

    String _fld010E[];
    float _fld010F[];
    float _fld0110[];
    Graphics _fld0111;
}
