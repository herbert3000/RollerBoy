package rollerboy;

import rollerboy.litecom.ImageHandler;

public final class SpriteHandler
{

    public SpriteHandler()
    {
        _fld0128 = new Sprite[36];
        _fld0128[0] = new Sprite(Constants.V.EA("bgblock.gif"), false);
        _fld0128[1] = new Sprite(Constants.V.EA("fgblock.gif"), true);
        _fld0128[2] = new Sprite(Constants.V.EA("block-slime.gif"), true);
        _fld0128[3] = new Sprite(Constants.V.EA("block-bush1.gif"), false);
        _fld0128[4] = new Sprite(Constants.V.EA("block-bush2.gif"), false);
        _fld0128[5] = new Sprite(Constants.V.EA("block-bush3.gif"), false);
        _fld0128[6] = new Sprite(Constants.V.EA("block-bush4.gif"), false);
        _fld0128[7] = new Sprite(Constants.V.EA("block-chrome.gif"), true);
        _fld0128[8] = new Sprite(Constants.V.EA("block-grad.gif"), false);
        _fld0128[9] = new Sprite(Constants.V.EA("block-black.gif"), false);
        _fld0128[10] = new Sprite(Constants.V.EA("block-flower.gif"), false);
        _fld0128[11] = new Sprite(Constants.V.EA("block-purple.gif"), true);
        _fld0128[12] = new Sprite(Constants.V.EA("block-purple1.gif"), false);
        _fld0128[13] = new Sprite(Constants.V.EA("block-purple2.gif"), false);
        _fld0128[14] = new Sprite(Constants.V.EA("block-cloud1.gif"), false);
        _fld0128[15] = new Sprite(Constants.V.EA("block-cloud2.gif"), false);
        _fld0128[16] = new Sprite(Constants.V.EA("block-cloud3.gif"), false);
        _fld0128[17] = new Sprite(Constants.V.EA("block-cloud4.gif"), false);
        _fld0128[18] = new Sprite(Constants.V.EA("h-1.gif"), true);
        _fld0128[19] = new Sprite(Constants.V.EA("h-2.gif"), true);
        _fld0128[20] = new Sprite(Constants.V.EA("h-3.gif"), true);
        _fld0128[21] = new Sprite(Constants.V.EA("h-4.gif"), true);
        _fld0128[22] = new Sprite(Constants.V.EA("h-5.gif"), true);
        _fld0128[23] = new Sprite(Constants.V.EA("h-6.gif"), true);
        _fld0128[24] = new Sprite(Constants.V.EA("b-1.gif"), true);
        _fld0128[25] = new Sprite(Constants.V.EA("b-2.gif"), true);
        _fld0128[26] = new Sprite(Constants.V.EA("b-3.gif"), true);
        _fld0128[27] = new Sprite(Constants.V.EA("b-4.gif"), true);
        _fld0128[28] = new Sprite(Constants.V.EA("b-5.gif"), true);
        _fld0128[29] = new Sprite(Constants.V.EA("b-6.gif"), true);
        _fld0128[30] = new Sprite(Constants.V.EA("b-7.gif"), true);
        _fld0128[31] = new Sprite(Constants.V.EA("b-8.gif"), true);
        _fld0128[32] = new Sprite(Constants.V.EA("block-house.gif"), false);
        _fld0128[33] = new Sprite(Constants.V.EA("block-housefade.gif"), false);
        _fld0128[34] = new Sprite(Constants.V.EA("water.gif"), false);
        _fld0128[35] = new Sprite(Constants.V.EA("b-2.gif"), true);
        _fld0128[35].D9();
    }

    public Sprite E4(int i)
    {
        return _fld0128[i];
    }

    Sprite _fld0128[];
    public final int _fld0129 = 36;
}
