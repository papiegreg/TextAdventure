import java.util.*;

public class Player
{
  //instance variables
  String name;
  int health;
  double gold;

  public Player(String playerName, int startingHealth, double startingGold)//player constructor
  {
    name = playerName;
    health = startingHealth;
    gold = startingGold;
  }

  public String getName()//gets player name
  {
    return name;
  }
  
  public int getHealth()//gets player health
  {
    return health;
  }

  public double getGold()//get player gold
  {
    return gold;
  }


}