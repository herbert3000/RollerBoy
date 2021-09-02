package rollerboy;

import java.awt.Image;

public final class Sprite
{

    public Sprite(Image image, boolean flag)
    {
        _fld0106 = false;
        _fld0105 = image;
        _fld0103 = flag;
    }

    public Image D8()
    {
        return _fld0105;
    }

    public void D9()
    {
        _fld0106 = true;
    }

    public boolean _fld0103;
    public int _fld0104;
    private Image _fld0105;
    public boolean _fld0106;
}
