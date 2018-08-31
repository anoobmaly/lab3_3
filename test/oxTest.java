import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class oxTest {
    @Test
     void getTableString(){
        ox Ox = new ox();
        // " 012\n0---\n1---\n2---\n"
        assertEquals(" 012\n" +
                "0---\n" +
                "1---\n" +
                "2---\n",Ox.getTableString());
        assertEquals("x",Ox.getCurrentPlayer());
    }

    @Test
    public void switchPlayer(){
        ox Ox = new ox();
        Ox.switchPlayer();
        assertEquals("o", Ox.getCurrentPlayer());
        Ox.switchPlayer();
        assertEquals("x", Ox.getCurrentPlayer());
    }

    @Test
    void getCurrentPlayer(){
        ox Ox = new ox();
        assertEquals("x", Ox.getCurrentPlayer());
    }

    @Test
     void put(){
        ox Ox = new ox();

        Ox.put(0,0);
        assertEquals(" 012\n" +
                "0x--\n" +
                "1---\n" +
                "2---\n",Ox.getTableString());

    }

    @Test
    void get(){
        ox Ox = new ox();

        Ox.put(0,0);
        assertEquals(" 012\n" +
                "0x--\n" +
                "1---\n" +
                "2---\n",Ox.getTableString());
        assertEquals("x",Ox.get(0,0));

    }

    @Test
     void putTwice(){
        ox Ox = new ox();
        assertTrue(Ox.put(0, 0));
        assertFalse(Ox.put(0, 0));
    }

    @Test
    void putOverTable(){
        ox Ox = new ox();
        assertFalse(Ox.put(0, -1));
        assertFalse(Ox.put(0, -3));
        assertFalse(Ox.put(3, -1));
        assertFalse(Ox.put(-1, 3));
    }

    @Test
    void getOverTable(){
        ox Ox = new ox();
        assertNull(Ox.get(0, -1));
        assertNull(Ox.get(0, -3));
        assertNull(Ox.get(3, -1));
        assertNull(Ox.get(-1, 3));
    }

    @Test
    void checkWinCol0(){
        ox Ox = new ox();
        Ox.put(0,0);
        Ox.put(0,1);
        Ox.put(0,2);
        assertTrue(Ox.checkWin(0,0));
        assertTrue(Ox.checkWin(0,1));
        assertTrue(Ox.checkWin(0,2));
        assertFalse(Ox.checkWin(1,0));
        assertFalse(Ox.checkWin(1,1));
        assertFalse(Ox.checkWin(1,2));
    }

    @Test
    void checkWinCol2(){
        ox Ox = new ox();
        Ox.put(2,0);
        Ox.put(2,1);
        Ox.put(2,2);
        assertTrue(Ox.checkWin(2,0));
        assertTrue(Ox.checkWin(2,1));
        assertTrue(Ox.checkWin(2,2));
        assertFalse(Ox.checkWin(1,0));
        assertFalse(Ox.checkWin(1,1));
        assertFalse(Ox.checkWin(1,2));
    }

    @Test
    void checkWinRow2(){
        ox Ox = new ox();
        Ox.put(0,2);
        Ox.put(1,2);
        Ox.put(2,2);
        assertTrue(Ox.checkWin(0,2));
        assertTrue(Ox.checkWin(1,2));
        assertTrue(Ox.checkWin(2,2));
        assertFalse(Ox.checkWin(1,0));
        assertFalse(Ox.checkWin(1,1));
        assertFalse(Ox.checkWin(2,1));
    }

    @Test
    void checkWinES(){
        ox Ox = new ox();
        Ox.put(0,0);
        Ox.put(1,1);
        Ox.put(2,2);
        assertTrue(Ox.checkWin(0,0));
        assertTrue(Ox.checkWin(1,1));
        assertTrue(Ox.checkWin(2,2));

    }

    @Test
    void checkWinSS(){
        ox Ox = new ox();
        Ox.put(2,0);
        Ox.put(1,1);
        Ox.put(0,2);
        assertTrue(Ox.checkWin(2,0));
        assertTrue(Ox.checkWin(1,1));
        assertTrue(Ox.checkWin(0,2));

    }

    @Test
    void reset(){
        ox Ox = new ox();
        Ox.put(2,0);
        Ox.put(1,1);
        Ox.put(0,2);
        Ox.reset();
        assertEquals(" 012\n" +
                "0---\n" +
                "1---\n" +
                "2---\n",Ox.getTableString());
        assertEquals("x", Ox.getCurrentPlayer());
        assertEquals(0, Ox.getTurnCount());
    }

    @Test
    void getTurnCount(){
        ox Ox = new ox();
        assertEquals(0 , Ox.getTurnCount());
        Ox.put(0,0);
        assertEquals(1 ,Ox.getTurnCount());
    }

    @Test
    void isDraw(){
        ox Ox = new ox();
        Ox.put(0,0);
        Ox.put(0,1);
        Ox.put(0,2);
        assertFalse(Ox.isDraw());
        Ox.put(1,0);
        Ox.put(1,1);
        Ox.put(1,2);
        assertFalse(Ox.isDraw());
        Ox.put(2,0);
        Ox.put(2,1);
        Ox.put(2,2);
        assertTrue(Ox.isDraw());
    }

    @Test
    void getScoreX(){
        ox Ox = new ox();
        assertEquals(0 ,Ox.getScoreX());
        Ox.put(0,0);
        Ox.put(0,1);
        Ox.put(0,2);
        assertEquals(1,Ox.getScoreX());

    }

    @Test
    void getScoreO(){
        ox Ox = new ox();
        Ox.switchPlayer();
        assertEquals(0 ,Ox.getScoreO());
        Ox.put(0,0);
        Ox.put(1,1);
        Ox.put(2,2);
        assertEquals(1,Ox.getScoreO());

    }

    @Test
    void getScoreDraw(){
        ox Ox = new ox();
        assertEquals(0 ,Ox.getScoreDraw());
        Ox.put(0,0);
        Ox.put(0,1);
        Ox.put(0,2);
        assertFalse(Ox.isDraw());
        Ox.put(1,0);
        Ox.put(1,1);
        Ox.put(1,2);
        assertFalse(Ox.isDraw());
        Ox.put(2,0);
        Ox.put(2,1);
        Ox.put(2,2);
        assertTrue(Ox.isDraw());
        assertEquals(1,Ox.getScoreDraw());

    }
}