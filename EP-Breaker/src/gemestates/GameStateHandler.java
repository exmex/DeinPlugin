package gemestates;

import java.util.ArrayList;

/**
 * Created by regnatrix on 10/23/16.
 */
public class GameStateHandler {


    private static GameState current;
    private static ArrayList<GameState> state = new ArrayList<>();

    public GameStateHandler() {


        state.add(new LobbyState());
        state.add(new IngameState());
        state.add(new EndState());


    }


    public  static  void setGameState(int id) {


        if(current != null)current.end();
        current = state.get(id);
        current.init();


    }



    public static GameState getCureGameState() {
        return  current;

    }


}
