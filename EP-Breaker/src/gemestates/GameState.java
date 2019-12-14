package gemestates;

/**
 * Created by regnatrix on 10/23/16.
 */
public abstract class GameState {


    public  static  final int LOBBY_STATE = 0,
                              INGAME_STATE = 1,
                              END_STATE = 2;



    public abstract void init();
    public  abstract  void end();





}
