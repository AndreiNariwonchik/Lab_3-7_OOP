package Game.GameStruct.game.Levels;


import Game.OtherObjects.Background;
import Game.OtherObjects.GameEnd;
import Game.OtherObjects.OtherObject;

import java.util.ArrayList;

/**
 * Created by andrei on 10.03.17.
 */
public class Game_completed extends Level
{
    private int others = 1;

    //String map = "Кнопочка//Play.bmp";
    public Game_completed()
    {
        super(new Background("Background//GameOver.bmp",0,0));
        super.setOthers(createOthers());
    }

    private ArrayList<OtherObject> createOthers(){
        ArrayList<OtherObject> othOb = new ArrayList<>();
        for(int i = 0; i< others; i++){
            othOb.add(new GameEnd());
        }
        //oth.add(new Background("Background//background1.bmp", 0,0));
        return othOb;
    }
}
