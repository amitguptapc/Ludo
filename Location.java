import java.awt.*;

public class Location {
    Point[] hb = new Point[4];
    Point[] hr = new Point[4];
    Point[] hy = new Point[4];
    Point[] hg = new Point[4];

    Point[] pt = new Point[52];

    Point[] db = new Point[5];
    Point[] dg = new Point[5];
    Point[] dr = new Point[5];
    Point[] dy = new Point[5];

    Location() {
        //home locations
        hb[0] = new Point(88, 86);
        hb[1] = new Point(180, 86);
        hb[2] = new Point(87, 172);
        hb[3] = new Point(179, 172);

        hr[0] = new Point(505, 88);
        hr[1] = new Point(597, 88);
        hr[2] = new Point(504, 174);
        hr[3] = new Point(596, 174);

        hy[0] = new Point(87, 500);
        hy[1] = new Point(179, 499);
        hy[2] = new Point(86, 586);
        hy[3] = new Point(178, 585);

        hg[0] = new Point(504, 502);
        hg[1] = new Point(596, 503);
        hg[2] = new Point(503, 588);
        hg[3] = new Point(595, 588);

        //path traversal
        //1
        pt[0] = new Point(70, 295);
        pt[1] = new Point(116, 295);
        pt[2] = new Point(160, 295);
        pt[3] = new Point(203, 295);
        pt[4] = new Point(246, 295);
        //2
        pt[5] = new Point(297, 242);
        pt[6] = new Point(297, 199);
        pt[7] = new Point(297, 155);
        pt[8] = new Point(297, 112);
        pt[9] = new Point(297, 66);
        //3
        pt[10] = new Point(297, 18);
        pt[11] = new Point(340, 18);
        pt[12] = new Point(383, 18);
        //4
        pt[13] = new Point(383, 66);
        pt[14] = new Point(383, 112);
        pt[15] = new Point(383, 155);
        pt[16] = new Point(383, 199);
        pt[17] = new Point(383, 242);
        //5
        pt[18] = new Point(438, 295);
        pt[19] = new Point(485, 295);
        pt[20] = new Point(532, 295);
        pt[21] = new Point(575, 295);
        pt[22] = new Point(618, 295);
        //6
        pt[23] = new Point(661, 295);
        pt[24] = new Point(661, 338);
        pt[25] = new Point(661, 381);
        //7
        pt[26] = new Point(618, 381);
        pt[27] = new Point(575, 381);
        pt[28] = new Point(532, 381);
        pt[29] = new Point(485, 381);
        pt[30] = new Point(438, 381);
        //8
        pt[31] = new Point(384, 432);
        pt[32] = new Point(384, 480);
        pt[33] = new Point(384, 527);
        pt[34] = new Point(384, 571);
        pt[35] = new Point(384, 614);
        //9
        pt[36] = new Point(384, 657);
        pt[37] = new Point(341, 657);
        pt[38] = new Point(298, 657);
        //10
        pt[39] = new Point(298, 614);
        pt[40] = new Point(298, 571);
        pt[41] = new Point(298, 527);
        pt[42] = new Point(298, 480);
        pt[43] = new Point(298, 432);
        //11
        pt[44] = new Point(246, 381);
        pt[45] = new Point(203, 381);
        pt[46] = new Point(160, 381);
        pt[47] = new Point(116, 381);
        pt[48] = new Point(70, 381);
        //12
        pt[49] = new Point(22, 381);
        pt[50] = new Point(22, 338);
        pt[51] = new Point(22, 295);


        ////destination sequence

        //blue destination
        db[0] = new Point(70, 338);
        db[1] = new Point(116, 338);
        db[2] = new Point(160, 338);
        db[3] = new Point(203, 338);
        db[4] = new Point(246, 338);

        //green destination
        dg[0] = new Point(618, 338);
        dg[1] = new Point(575, 338);
        dg[2] = new Point(532, 338);
        dg[3] = new Point(485, 338);
        dg[4] = new Point(438, 338);

        //red destination
        dr[0] = new Point(340, 66);
        dr[1] = new Point(340, 112);
        dr[2] = new Point(340, 155);
        dr[3] = new Point(340, 199);
        dr[4] = new Point(340, 242);

        //yellow destination
        dy[0] = new Point(341, 614);
        dy[1] = new Point(341, 571);
        dy[2] = new Point(341, 527);
        dy[3] = new Point(341, 480);
        dy[4] = new Point(341, 432);
    }
}