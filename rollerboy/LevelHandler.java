package rollerboy;

import java.awt.Graphics;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;
import rollerboy.litecom.Logger;
import rollerboy.units.Rollerboy;
import rollerboy.units.Unit;

public final class LevelHandler
{

    public LevelHandler()
    {
        E4 = new Vector();
        E5 = false;
        DF = 10;
        E0 = 0;
        E1 = -1;
        E2 = 0;
        E3 = 0;
        DB = new byte[10][200];
        DC = new byte[10][200];
        DD = new byte[10][200];
        C2();
    }

    public void p()
    {
        rollerboy.litecom.Logger.DA(this, "reseting extra lifes vec");
        E4 = new Vector();
    }

    public void x()
    {
        rollerboy.litecom.Logger.DA(this, "clearing extra lifes.");
        for(int i1 = 0; i1 < E4.size(); i1++)
        {
            int j1 = ((Integer)E4.elementAt(i1)).intValue();
            int k1 = j1 / 200;
            int l1 = j1 % 200;
            rollerboy.litecom.Logger.DA(this, "\tvec[" + i1 + "]: " + l1 + ", " + k1);
            if(C5(l1, k1) == 13)
            {
                rollerboy.litecom.Logger.DA(this, "\tfound extra life. Taking it away!");
                n(l1, k1, (byte)-1);
            } else
            {
                rollerboy.litecom.Logger.DA(this, "\tShit! Should be an extra life here.");
            }
        }

    }

    public void s(Graphics g1)
    {
        E1 = E2;
        E2 = l((int)DA);
        if(E1 > E2)
            E3 -= 240;
        if(DA >= (float)(E0 * 24))
        {
            for(int i1 = 0; i1 < 10; i1++)
            {
                if(DC[i1][DF] != -1)
                {
                    Unit fb1 = Constants.W.I(DC[i1][DF], DF * 24, i1 * 24, -1F, 0.0F);
                    rollerboy.litecom.Logger.DA(this, "in: " + fb1.getClass().getName());
                    Constants.S._mth0103(fb1);
                }
                g1.drawImage(Constants.T.E4(C8(DF, i1)).D8(), l(E0 * 24) + 240, i1 * 24, Constants.U);
                g1.drawImage(Constants.T.E4(C8(DF - 1, i1)).D8(), l((E0 - 1) * 24), i1 * 24, Constants.U);
            }

            E0++;
            DF++;
        }
    }

    public void t()
    {
        DE = false;
        DA = 0.0F;
        C2();
        DF = 10;
        E0 = 0;
        E1 = -1;
        E2 = 0;
        E3 = 0;
    }

    public void C3(int i1, int j1)
    {
        Constants.Y.drawImage(Constants.T.E4(C8(i1, j1)).D8(), i1 * 24 + E3, j1 * 24, Constants.U);
        if((i1 * 24 + E3) - 240 >= 0)
            Constants.Y.drawImage(Constants.T.E4(C8(i1, j1)).D8(), (i1 * 24 + E3) - 240, j1 * 24, Constants.U);
    }

    private void C2()
    {
        for(int i1 = 0; i1 < 200; i1++)
        {
            for(int j1 = 0; j1 < 10; j1++)
            {
                if(i1 == 0 || i1 == 199 || j1 == 0 || j1 == 9)
                    DB[j1][i1] = 1;
                else
                    DB[j1][i1] = 0;
                DC[j1][i1] = -1;
                DD[j1][i1] = 0;
            }

        }

    }

    public byte C8(int i1, int j1)
    {
        if(i1 < 0 || j1 < 0 || i1 >= 200 || j1 >= 10)
            return 0;
        else
            return DB[j1][i1];
    }

    public byte v(int i1, int j1)
    {
        if(i1 < 0 || j1 < 0 || i1 >= 200 || j1 >= 10)
            return -1;
        else
            return DD[j1][i1];
    }

    public void C9(int i1, int j1, byte byte0)
    {
        if(i1 < 0 || j1 < 0 || i1 >= 200 || j1 >= 10)
        {
            return;
        } else
        {
            DD[j1][i1] = byte0;
            return;
        }
    }

    public void C0(int i1, int j1)
    {
        if(i1 < 0 || j1 < 0 || i1 >= 200 || j1 >= 10)
        {
            return;
        } else
        {
            DD[j1][i1]++;
            return;
        }
    }

    public void u(int i1, int j1)
    {
        if(i1 < 0 || j1 < 0 || i1 >= 200 || j1 >= 10)
        {
            return;
        } else
        {
            DD[j1][i1]--;
            return;
        }
    }

    public void j(int i1, int j1, byte byte0)
    {
        rollerboy.litecom.Logger.DA(this, "settig level value: (" + i1 + ", " + j1 + ") - " + byte0);
        DB[j1][i1] = byte0;
        rollerboy.litecom.Logger.DA(this, "level value is: " + DB[j1][i1]);
    }

    public byte C5(int i1, int j1)
    {
        if(i1 < 0 || j1 < 0 || i1 >= 200 || j1 >= 10)
            return -1;
        else
            return DC[j1][i1];
    }

    public void n(int i1, int j1, byte byte0)
    {
        if(i1 < 0 || j1 < 0 || i1 >= 200 || j1 >= 10)
        {
            return;
        } else
        {
            DC[j1][i1] = byte0;
            return;
        }
    }

    public void z(Graphics g1)
    {
        q(g1, 0, 0);
    }

    public void q(Graphics g1, int i1, int j1)
    {
        int k1 = (int)(DA / 24F);
        int l1 = (int)(DA % 24F);
        for(int i2 = 0; i2 < 11; i2++)
        {
            for(int j2 = 0; j2 < 10; j2++)
                g1.drawImage(Constants.T.E4(C8(k1 + i2, j2)).D8(), (i1 + i2 * 24) - l1, j1 + j2 * 24, Constants.U);

        }

    }

    public void w(Graphics g1, int i1, int j1)
    {
        int k1 = (int)(DA / 24F);
        int l1 = (int)(DA % 24F);
        for(int i2 = 0; i2 < 11; i2++)
        {
            for(int j2 = 0; j2 < 10; j2++)
            {
                byte byte0 = C5(k1 + i2, j2);
                if(byte0 != -1)
                    g1.drawImage(Constants.W.H(byte0), (i1 + i2 * 24) - l1, j1 + j2 * 24, Constants.U);
            }

        }

    }

    public void C7(int i1, int j1, Graphics g1)
    {
        if((float)i1 >= DA / 24F - 1.0F && j1 >= 0 && j1 < 10 && j1 < 200)
            g1.drawImage(Constants.T.E4(C8(i1, j1)).D8(), i1 * 24 + E3, j1 * 24, Constants.U);
    }

    public void y(int i1, int j1, int k1, int l1, Sprite o1, Graphics g1)
    {
        g1.drawImage(o1.D8(), i1 + k1 * 24 + E3, j1 + l1 * 24, Constants.U);
    }

    public void i(float f)
    {
        DA += f;
    }

    public void C1()
    {
        DA = 0.0F;
        E6 = 0.0F;
        E5 = true;
    }

    public void m()
    {
        DA = 0.0F;
        E6 = 0.0F;
        E5 = false;
    }

    public void k(Rollerboy cb)
    {
        if(E5)
            return;
        if(((Unit) (cb))._fld0151 - DA > 120F)
            E6 += 0.14999999999999999D;
        else
            E6 -= 0.10000000000000001D;
        if(E6 < 0.0F)
            E6 = 0.0F;
        if(E6 > 2.8F)
            E6 = 2.8F;
        i(E6);
    }

    public int l(int i1)
    {
        return i1 % 240;
    }

    public void r(String s1)
    {
        rollerboy.litecom.Logger.DA(this, "Saving level " + s1 + "...");
        try
        {
            DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(s1));
            for(int i1 = 0; i1 < 10; i1++)
            {
                dataoutputstream.write(DB[i1], 0, 200);
                dataoutputstream.write(DC[i1], 0, 200);
                dataoutputstream.write(DD[i1], 0, 200);
            }

            dataoutputstream.close();
        }
        catch(Exception _ex)
        {
            System.out.println("Could not save file..");
        }
        rollerboy.litecom.Logger.DA(this, "Done!");
    }

    public void C6(String s1)
    {
        rollerboy.litecom.Logger.DA(this, "Loading level " + s1 + "...");
        try
        {
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(s1));
            for(int i1 = 0; i1 < 10; i1++)
            {
                datainputstream.read(DB[i1]);
                datainputstream.read(DC[i1]);
                datainputstream.read(DD[i1]);
            }

            datainputstream.close();
        }
        catch(Exception _ex)
        {
            System.out.println("Could not load level..");
        }
        rollerboy.litecom.Logger.DA(this, "Done!");
    }

    private void o(DataInputStream datainputstream, byte abyte0[])
        throws IOException
    {
        for(int i1 = 0; i1 != abyte0.length;)
        {
            int j1 = datainputstream.read(abyte0, i1, abyte0.length - i1);
            if(j1 >= 0)
                i1 += j1;
            Thread.yield();
        }

    }

    public void C4(URL url, String s1)
    {
        rollerboy.litecom.Logger.DA(this, "Loading level " + s1 + "(URL)...");
        boolean flag = false;
        URL url1 = null;
        try
        {
            url1 = new URL(url, s1);
        }
        catch(Exception exception)
        {
            System.out.println("Error opening level: " + url1);
            System.out.println(exception);
            flag = true;
        }
        if(!flag)
        {
            try
            {
                URLConnection urlconnection = url1.openConnection();
                urlconnection.connect();
                DataInputStream datainputstream = new DataInputStream(urlconnection.getInputStream());
                for(int i1 = 0; i1 < 10; i1++)
                {
                    o(datainputstream, DB[i1]);
                    o(datainputstream, DC[i1]);
                    o(datainputstream, DD[i1]);
                }

                datainputstream.close();
            }
            catch(Exception exception1)
            {
                System.out.println("Error while reading level file: " + url1);
                System.out.println(exception1);
                System.exit(0);
            }
        } else
        {
            System.out.println("Level not loaded. Aborting.");
            System.exit(0);
        }
        rollerboy.litecom.Logger.DA(this, "Done!");
    }

    public float DA;
    public byte DB[][];
    public byte DC[][];
    public byte DD[][];
    public boolean DE;
    int DF;
    int E0;
    int E1;
    int E2;
    public int E3;
    public Vector E4;
    public boolean E5;
    public float E6;
}
