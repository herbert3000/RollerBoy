package rollerboy;

import java.awt.Image;
import rollerboy.litecom.ImageHandler;
import rollerboy.units.Fish;
import rollerboy.units.Rollerboy;
import rollerboy.units.Arrow;
import rollerboy.units.Unit;
import rollerboy.units.Heart;
import rollerboy.units.Bee;
import rollerboy.units.Bounce;
import rollerboy.units.Spike;
import rollerboy.units.Boob;
import rollerboy.units.Gem;
import rollerboy.units.Firepower;
import rollerboy.units.Ring;
import rollerboy.units.Bajsmannen;
import rollerboy.units.Dollar;
import rollerboy.units.Smiley;

public final class UnitHandler
{

    public UnitHandler()
    {
    }

    public Unit I(int i, float f, float f1, float f2, float f3)
    {
        switch(i)
        {
        case 0:
            return new Rollerboy(f, f1, f2, f3);

        case 1:
            return new Bajsmannen(f, f1, f2, f3);

        case 2:
            return new Firepower(f, f1, 0.0F, 0.0F);

        case 3:
            return new Ring(f, f1, 0.0F, f3);

        case 4:
            return new Arrow(f, f1, -1F, 0.0F);

        case 5:
            return new Arrow(f, f1, 1.0F, 0.0F);

        case 6:
            return new Arrow(f, f1, 0.0F, -1F);

        case 7:
            return new Arrow(f, f1, 0.0F, 1.0F);

        case 8:
            return new Fish(f, f1, 0.0F, -7.5F);

        case 9:
            return new Bee(f, f1, -1F, 0.0F);

        case 10:
            return new Heart(f, f1, 0.0F, f3);

        case 11:
            return new Gem(f, f1, f2, f3);

        case 12:
            return new Bounce(f, f1, f2, f3);

        case 13:
            return new Smiley(f, f1, 0.0F, 0.0F);

        case 14:
            return new Boob(f, f1, 0.0F, 0.0F);

        case 15:
            return new Spike(f, f1, 0.0F, 0.0F);

        case 16:
            return new Dollar(f, f1, 0.0F, 0.0F);
        }
        return null;
    }

    public Image H(int i)
    {
        switch(i)
        {
        case 0:
            return Constants.V.EA("p-rollr.gif");

        case 1:
            return Constants.V.EA("bajsmannen1.gif");

        case 2:
            return Constants.V.EA("h0.gif");

        case 3:
            return Constants.V.EA("t0.gif");

        case 4:
            return Constants.V.EA("arrow-left.gif");

        case 5:
            return Constants.V.EA("arrow-right.gif");

        case 6:
            return Constants.V.EA("arrow-up.gif");

        case 7:
            return Constants.V.EA("arrow-down.gif");

        case 8:
            return Constants.V.EA("fish.gif");

        case 9:
            return Constants.V.EA("bi1.gif");

        case 10:
            return Constants.V.EA("heart.gif");

        case 11:
            return Constants.V.EA("gem0000.gif");

        case 12:
            return Constants.V.EA("bounce1.gif");

        case 13:
            return Constants.V.EA("1up.gif");

        case 14:
            return Constants.V.EA("boob.gif");

        case 15:
            return Constants.V.EA("spike2.gif");

        case 16:
            return Constants.V.EA("dollar.gif");
        }
        return null;
    }

    public final int a = 17;
}
