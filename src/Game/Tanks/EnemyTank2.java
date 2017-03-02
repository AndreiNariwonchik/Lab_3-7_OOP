package Game.Tanks;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by andrei on 03.03.17.
 */
public class EnemyTank2 extends Tank {
    Dictionary<String, String> ht = new Hashtable<>(4);

    public EnemyTank2(int x, int y, int life) {
        super(x, y, "Enemy2//Down//Tank1D.bmp", 2, life);

        ht.put("UP", "Enemy2//Up//Tank1U.bmp");
        ht.put("DOWN", "Enemy2//Down//Tank1D.bmp");
        ht.put("LEFT", "Enemy2//Left//Tank1L.bmp");
        ht.put("RIGHT", "Enemy2//Right//Tank1R.bmp");
        ht.put("BURNING", "FireTank//FireTank1.bmp");
        super.images = ht;
    }

    @Override
    public void move(int widthX, int widthY, int ke) {
        while (super.getState() != state.BURNING) {

        }

    }

    @Override
    public void stateCheck() {

    }
}
