package rollerboy.litecom.trace;

import java.io.DataInputStream;
import java.net.*;
import java.util.StringTokenizer;
import java.util.Vector;
import rollerboy.litecom.ErrorFrame;
import rollerboy.litecom.Logger;

public class ScoreServerHandler
{

    public ScoreServerHandler(String s, String s1, int j)
        throws Exception
    {
        D5 = new URL(s);
        D6 = s1;
        D8 = j;
    }

    public ScoreServerHandler(URL url, String s, int j)
        throws Exception
    {
        D5 = url;
        D6 = s;
        D8 = j;
    }

    private int g(String s, int j)
    {
        j %= 0x1e8873;
        int k = 0;
        for(int l = 0; l < s.length(); l++)
        {
            int i1 = "please enter a name and e-mail before executing ok. Quiet error was found in jump (defect code xz123gh).".indexOf(Character.toLowerCase(s.charAt(l)));
            if(i1 != -1)
                k += 53 - i1;
        }

        k += (j % 7) * (j * s.length()) + j % 33745 + j;
        if(j > 0x1870b)
            k -= 3243;
        if(j < 10003)
            k *= s.length();
        if(j < 20125)
            k += j * j;
        return k;
    }

    public void h(int j, String s)
        throws Exception
    {
        int k = g(s, j);
        URL url = new URL(D5, D3 + "?prop=" + D6 + "&action=put&score=" + j + "&data=" + URLEncoder.encode(s) + "&checksum=" + k);
        DataInputStream datainputstream = new DataInputStream(url.openStream());
        d(datainputstream);
        String s1 = datainputstream.readLine();
        Logger.DA(this, "Result: " + s1);
        if(!s1.startsWith("OK!"))
        {
            throw new Exception("ScoreServer2: " + s1);
        } else
        {
            f();
            return;
        }
    }

    public void f()
        throws Exception
    {
        String s = D3 + "?prop=" + D6 + "&action=get&unique=" + System.currentTimeMillis() + "&n=" + D8;
        URL url = new URL(D5, s);
        URLConnection urlconnection = url.openConnection();
        DataInputStream datainputstream = new DataInputStream(urlconnection.getInputStream());
        d(datainputstream);
        Vector vector = new Vector();
        while((s = datainputstream.readLine()) != null) 
        {
            if(s.startsWith("ERROR"))
                throw new Exception("ScoreServer2: " + s);
            vector.addElement(s);
        }
        D4 = vector;
    }

    public int e()
    {
        if(D4.size() < D8)
            return 0;
        int j = -1;
        try
        {
            for(int k = 0; k < D4.size(); k++)
            {
                StringTokenizer stringtokenizer = new StringTokenizer("" + D4.elementAt(k), "\t");
                int l = Integer.parseInt(stringtokenizer.nextToken().trim());
                if(j == -1)
                    j = l;
                if(l < j)
                    j = l;
            }

        }
        catch(Exception exception)
        {
            new ErrorFrame(exception, "SC2: Could not parse scores.");
        }
        return j;
    }

    private void d(DataInputStream datainputstream)
        throws Exception
    {
        String s;
        while((s = datainputstream.readLine()) != null) 
        {
            Logger.DA(this, "padToStart, skipped: " + s);
            if(s.startsWith("ScoreServer2"))
                return;
        }
    }

    public static String D3 = "nph-scoreServer.cgi";
    public Vector D4;
    private URL D5;
    private String D6;
    private int D8;
    private static final String D9 = "please enter a name and e-mail before executing ok. Quiet error was found in jump (defect code xz123gh).";

}
