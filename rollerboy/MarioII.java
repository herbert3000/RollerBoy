package rollerboy;

import java.applet.Applet;
import java.awt.*;
import java.io.PrintStream;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.Vector;
import rollerboy.litecom.*;
import rollerboy.litecom.trace.ScoreServerHandler;
import rollerboy.units.Rollerboy;
import rollerboy.units.Unit;

public final class MarioII extends Applet
    implements Runnable
{

    public MarioII()
    {
        f = 1;
        g = -1;
        h = new ThreadHandler();
        w = false;
        y = true;
        z = false;
        C1 = false;
        C2 = false;
        C8 = 240F;
        CA = false;
        C0 = this;
    }

    public static MarioII Q()
    {
        return C0;
    }

    public void init()
    {
        if(z)
        {
            return;
        } else
        {
        	resize(240, 260); // quick fix
        	rollerboy.litecom.Logger.DF(this); // check debug
        	
            z = true;
            setBackground(Color.black);
            i = getGraphics();
            l = createImage(480, 240);
            j = l.getGraphics();
            m = createImage(240, 20);
            k = m.getGraphics();
            j.setFont(r = new Font("Arial,helvetica", 0, 10));
            s = j.getFontMetrics();
            requestFocus();
            return;
        }
    }

    public void K()
    {
        g = 5;
        X();
        //Logger._fld0107 = false;
        String s1 = "MarioII engine v1.2.0 Build 110 - (c)1997 LiteCom Interactive Media";
        System.out.println(s1);
        rollerboy.litecom.Logger.DB(s1);
        X();
        Constants.U = this;
        X();
        Constants.V = new ImageHandler(this, "gfx/");
        Constants.V.E8("bgblock.gif, fgblock.gif, e0.gif, e1.gif, e2.gif, e3.gif, bajsmannen1.gif, bajsmannen2.gif, block-slime.gif, block-bush1.gif, block-bush2.gif, block-bush3.gif, block-bush4.gif, block-chrome.gif, block-black.gif, block-grad.gif, block-flower.gif, block-purple.gif, block-purple1.gif, block-purple2.gif, fire1.gif, fire2.gif, h0.gif, h1.gif, h2.gif, h3.gif, block-cloud1.gif, block-cloud2.gif, block-cloud3.gif, block-cloud4.gif, h-1.gif, h-2.gif, h-3.gif, h-4.gif, h-5.gif, h-6.gif, b-1.gif, b-2.gif, b-3.gif, b-4.gif, b-5.gif, b-6.gif, b-7.gif, b-8.gif, block-house.gif, block-housefade.gif, t0.gif, t1.gif, t2.gif, t3.gif, t4.gif, t5.gif, rollerboy.gif, arrow-right.gif, arrow-up.gif, arrow-down.gif, arrow-left.gif, ball.gif, brick-1.gif, brick-2.gif, fish.gif, bi1.gif, bi2.gif, pool.gif, heart.gif, p-rolll.gif, p-rollr.gif, p-breakl.gif, p-breakr.gif, p-jumpu.gif, p-jumpd.gif, eol.gif, bounce1.gif, bounce2.gif, water.gif, 1up.gif, nmiball.gif, boob.gif, gem0001.gif, gem0002.gif, gem0003.gif, gem0004.gif, gem0005.gif, gem0006.gif, gem0007.gif, gem0000.gif, spike0.gif, spike1.gif, spike2.gif, dollar.gif");
        Constants.V.EC();
        X();
        Constants.R = new LevelHandler();
        X();
        Constants.S = new UnitVector();
        X();
        Constants.T = new SpriteHandler();
        X();
        Constants.W = new UnitHandler();
        X();
        Constants.Y = j;
        X();
        try
        {
            String s2 = getParameter("scoreServerPath");
            if(s2 == null)
                s2 = "/cgi-bin/ss21/";
            if(!s2.endsWith("/"))
                s2 += "/";
            URL url = new URL(getDocumentBase(), s2);
            t = new ScoreServerHandler(url, "rollerboy.prop", 100);
            t.f();
        }
        catch(Exception exception)
        {
            // L(exception); // ignore exception
        }
        X();
        X();
        n = new MainThread2(this, 10);
        n.start();
        X();
        q = new Rollerboy(0.0F, 0.0F, 0.0F, 0.0F);
        Constants.Q = q;
        X();
        o = new StatusBar(q, k, 240, 20);
        X();
        W("1.level");
        X();
        w = true;
    }

    public void run()
    {
        if(C2)
            return;
        C2 = true;
        MainThread b1 = new MainThread(this);
        b1.start();
        Thread.currentThread().setPriority(4);
        while(b != null) 
        {
            if(g == 1)
            {
                u++;
                h.A();
            } else
            if(g == 5)
                try
                {
                    Thread.sleep(20L);
                }
                catch(InterruptedException _ex) { }
            else
                Thread.yield();
            if(g > 0)
            {
                C1 = false;
                repaint();
                while(!C1) 
                    Thread.yield();
                if(g == 1)
                {
                    if(Constants.R.DE)
                    {
                        Constants.R.p();
                        f++;
                        P(2);
                        n.CD();
                    }
                    if(((Unit) (q))._fld015B)
                    {
                        rollerboy.litecom.Logger.DA(this, "PLayer got the score: " + q.F8());
                        Constants.R.p();
                        try
                        {
                            if(t.D4 != null && q.F8() > t.e() && q.F8() != 0) // null check by herbert3000
                            {
                            	rollerboy.litecom.Logger.DB("OH YES! a highscore!");
                                for(HighScoreFrame db1 = new HighScoreFrame(this, q.F8(), t); !db1._fld014B;)
                                {
                                    Thread.currentThread();
                                    Thread.sleep(10L);
                                }

                            }
                        }
                        catch(Exception exception)
                        {
                            L(exception);
                        }
                        n.CD();
                        P(4);
                    }
                    if(q._fld013B)
                    {
                        n.CD();
                        q._fld0159 = 100F;
                        q._fld013B = false;
                        P(2);
                    }
                }
            }
            if(q != null)
                q.FA();
            Thread.yield();
        }
        b = null;
    }

    public void start()
    {
        if(b == null)
        {
            b = new Thread(this);
            b.start();
        }
    }

    public void stop()
    {
        b = null;
        n.stop();
        rollerboy.litecom.Logger.DE();
    }

    private void X()
    {
        v++;
        paint(i);
    }

    public void paint(Graphics g1)
    {
        int i1 = 0;
        if(w)
            i1 = -Constants.R.l((int)Constants.R.DA);
        g1.drawImage(l, i1, 0, this);
        g1.drawImage(m, 0, 240, this);
        C1 = true;
    }

    public void update(Graphics g1)
    {
        V(j);
        paint(i);
    }

    private void L(Exception exception)
    {
        g = -1;
        System.out.println("ERROR: " + exception.getMessage());
        exception.printStackTrace();
        C3 = exception;
    }

    private void Z(Graphics g1)
    {
        g1.setColor(Color.blue);
        g1.fillRect(0, 0, 240, 240);
        g1.setColor(Color.white);
        if(C3 == null)
        {
            g1.drawString("I think not.", 20, 25);
            return;
        } else
        {
            g1.drawString("Internal error: " + C3, 20, 25);
            return;
        }
    }

    private void b(Graphics g1)
    {
        if(x == 0)
        {
        	rollerboy.litecom.Logger.DA(this, "startLevel: first framew!");
            Constants.R.C1();
            String as[] = {
                "Prepare for level " + ((f - 1) / 4 + 1) + "-" + ((f - 1) % 4 + 1), "Lives left: " + q._fld013E, "Rings collected: " + q._fld013D, "Score: " + q.F8(), "Hearts: " + (int)(((Unit) (q))._fld0159 / 10F)
            };
            rollerboy.litecom.Logger.DA(this, "startLevel: did string");
            C4 = new LevelStartScreen(as, j);
            rollerboy.litecom.Logger.DA(this, "startLevel: did bounce");
        }
        rollerboy.litecom.Logger.DA(this, "startLevel: next frame");
        C4.E0(x);
        x++;
        if(x > 1200)
        {
            W(f + ".level");
            Constants.R.x();
            Constants.R.z(j);
            n.CC();
            P(1);
        }
    }

    private void O()
    {
        N(1);
    }

    private void N(int i1)
    {
    	rollerboy.litecom.Logger.DA(this, "Starting new game at level: " + i1);
        q = new Rollerboy(0.0F, 0.0F, 0.0F, 0.0F);
        f = i1;
        P(2);
    }

    private void J()
    {
        for(int i1 = 0; i1 < 200; i1++)
        {
            for(int j1 = 0; j1 < 10; j1++)
                if(Constants.R.C5(i1, j1) >= 4 && Constants.R.C5(i1, j1) <= 7)
                    Constants.S._mth0103(Constants.W.I(Constants.R.C5(i1, j1), i1 * 24, j1 * 24, 0.0F, 0.0F));

        }

    }

    private void U(Graphics g1)
    {
        Constants.S._mth0102();
        Constants.R.s(g1);
        Constants.S._mth0108();
        o.D6();
    }

    private void a(float f1, Graphics g1)
    {
        float f2 = 1.0F;
        for(int i1 = 65; i1 < 240; i1++)
        {
            g1.setColor(new Color((int)(23D / (double)f2), (int)(156D / (double)f2), (int)(238D / (double)f2)));
            g1.drawLine(0, i1, 240, i1);
            f2 += f1;
        }

    }

    private void T(Graphics g1)
    {
        if(x == 0)
        {
            C5 = -200F;
            C6 = 0.0F;
            C7 = 500F;
            Constants.R.C1();
        } else
        {
            g1.setColor(new Color(23, 156, 238));
            g1.fillRect(0, 0, 480, 240);
            a(0.04F, g1);
            g1.setColor(Color.white);
            R(j);
            g1.drawImage(Constants.V.EA("rollerboy.gif"), (int)C5, 0, Constants.U);
            C5 = (float)(Math.sin(C6) * (double)C7);
            C7 *= 0.98999999999999999D;
            C6 += 0.10000000000000001D;
        }
        x++;
    }

    private void R(Graphics g1)
    {
    	if (t.D4 == null) {
    		g1.drawString("Brought back to life by herbert3000", 30, 85);
    		g1.drawString("Press S to start a new game", 30, 105);
    		return;
    	}
    	
        if(t == null || t.D4 == null)
            return;
        Graphics g2 = g1.create(0, 65, 240, 175);
        int i1 = (int)C8 - 65;
        byte byte0 = 30;
        char c1 = '\252';
        String s1 = "Highscores:";
        g2.drawString(s1, byte0, i1);
        FontMetrics fontmetrics = g2.getFontMetrics();
        i1 += fontmetrics.getHeight() * 2;
        for(int j1 = 0; j1 < t.D4.size(); j1++)
        {
            if(i1 > -20 && i1 < 270)
            {
                StringTokenizer stringtokenizer = new StringTokenizer("" + t.D4.elementAt(j1), "\t");
                String s2 = stringtokenizer.nextToken();
                String s3;
                for(s3 = stringtokenizer.nextToken(); fontmetrics.stringWidth(s3) > c1 - byte0; s3 = s3.substring(0, s3.length() - 1));
                g2.drawString("" + (j1 + 1), byte0 - 20, i1);
                g2.drawString(s3, byte0, i1);
                g2.drawString(s2, c1, i1);
            }
            i1 += fontmetrics.getHeight();
        }

        C8 -= 0.5F;
        if(C8 < (float)(-t.D4.size() * fontmetrics.getHeight() - 30))
            C8 = 230F;
    }

    public void W(String s1)
    {
    	rollerboy.litecom.Logger.DA(this, "Threads:");
    	rollerboy.litecom.Logger.DA(this, "\tpainter: " + u);
    	rollerboy.litecom.Logger.DA(this, "\tupdater: " + n.EC);
        u = 0;
        n.EC = 0;
        n.CD();
        Constants.R.t();
        Constants.S._mth0106();
        q._fld0151 = 0.0F;
        q._fld0152 = 192F;
        q._fld0153 = 0.0F;
        q._fld0154 = 0.0F;
        Constants.S._mth0103(q);
        o.D5(q);
        Constants.Q = q;
        Constants.R.C4(getDocumentBase(), "levels/" + s1);
        J();
        n.CC();
    }

    private void S(Graphics g1)
    {
        if(x == 0 || y)
        {
            pp = new Transition(0, 0, 480, 240, 10, 15, j);
            y = false;
        }
        x++;
        if(pp._mth0115())
        {
            P(3);
            y = true;
        }
    }

    private void Y(int i1, int j1, int k1, int l1, int i2, int j2, Graphics g1)
    {
        g1.drawRect(i1, j1, k1, l1);
        g1.fillRect(i1, j1, (int)(((0.0D + (double)i2) / (double)j2) * (double)k1), l1);
    }

    private void M(Graphics g1)
    {
        g1.setColor(Color.black);
        g1.fillRect(0, 0, 240, 240);
        if(C9 >= 0.9F)
            C9 = 0.9F;
        g1.setColor(new Color(C9 / 2.0F, C9 / 3F, C9));
        if(C9 < 1.0F)
            C9 += 0.050000000000000003D;
        else
            C9 = 1.0F;
        g1.drawString("Loading RollerBoy...", 20, 25);
        Y(20, 70, 200, 20, v, 15, g1);
        if(Constants.V != null && Constants.V._fld0133)
        {
            Y(20, 120, 200, 20, Constants.V.E6(), Constants.V.ED(), g1);
            if(w && Constants.V.EE())
                P(4);
        }
    }

    public void P(int i1)
    {
        g = 0;
        rollerboy.litecom.Logger.DA(this, "Setting layer: " + i1);
        x = 0;
        if(i1 == 1)
            Constants.R.m();
        g = i1;
    }

    private void V(Graphics g1)
    {
        switch(g)
        {
        case 1: // '\001'
            U(g1);
            return;

        case 2: // '\002'
            S(g1);
            return;

        case 3: // '\003'
            b(g1);
            return;

        case 4: // '\004'
            T(g1);
            return;

        case 5: // '\005'
            M(g1);
            return;
        }
        Z(g1);
    }

    public boolean keyUp(Event event, int i1)
    {
        switch(i1)
        {
        case 1006: 
            q.F5();
            break;

        case 1007: 
            q.EF();
            break;

        case 1004: 
            q.F9();
            break;

        case 32: // ' '
            CA = false;
            break;
        }
        return true;
    }

    public boolean keyDown(Event event, int i1)
    {
        if(g == 3 && x < 1000)
            x = 1000;
        switch(i1)
        {
        default:
            break;

        case 1006: 
            q.F3();
            break;

        case 1007: 
            q.F2();
            break;

        case 1004: 
            q.F4();
            break;

        case 32: // ' '
            if(!CA)
                q.F1();
            CA = true;
            break;

        case 68: // 'D'
        case 100: // 'd'
            Logger._fld0107 = !Logger._fld0107;
            break;

        case 83: // 'S'
        case 115: // 's'
            if(g == 4)
                O();
            break;

        case 107: // 'k'
            q.F6(20000);
            break;
        }
        return true;
    }

    Thread b;
    private static final String c = "1.2.0 Build 110";
    private final int d = 2;
    private final int ee = 20;
    int f;
    int g;
    public ThreadHandler h;
    Graphics i;
    Graphics j;
    Graphics k;
    Image l;
    Image m;
    MainThread2 n;
    StatusBar o;
    Transition pp;
    Rollerboy q;
    Font r;
    FontMetrics s;
    ScoreServerHandler t;
    public int u;
    int v;
    public boolean w;
    private int x;
    private boolean y;
    private boolean z;
    private static MarioII C0;
    private boolean C1;
    private boolean C2;
    private Exception C3;
    private LevelStartScreen C4;
    float C5;
    float C6;
    float C7;
    private float C8;
    float C9;
    private boolean CA;
}
