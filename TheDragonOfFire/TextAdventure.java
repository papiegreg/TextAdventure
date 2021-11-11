import java.util.*;

public class TextAdventure 
{
  //Instance variables of a class can also be objects
  FancyConsole console;
  Scanner inScanner;
  Player hero; 
  boolean hasSword = false;

  public TextAdventure()
  {
    //This creates the UI console that the user
    //can type in
    console = new FancyConsole("Great Text Adventure!", 600, 600);
    inScanner = new Scanner(System.in);

    //feel free to change the player's starting values
    //depending on your story
    hero = new Player("", 100, 0);
  }

  public void play()
  {
    String input;
    console.setImage("Forest.png");

    // ask the user for their name.
    System.out.println("What is your name hero?\n");
    input = inScanner.nextLine();

    // Changes player name
    hero.name = input;
    
    // describe the starting situation. Feel free to change this as well
    System.out.println("Welcome to the world of SmeckLock " + hero.name +"! ");
    System.out.println("We are so glad to have you here, our world has been terrorized by the Great Fire dragon!");
    System.out.println("Will you help us "+ hero.name+"?\n");
    

    // get user input and go to the appropriate zone based on their input
    String answer = inScanner.nextLine();
    if(answer.equals("yes")){
    enterZone1();
    hero.gold = hero.gold+10;
    }
    else{ //wrong choice -> results in game end
        console.setImage("death.jpg");//changes image
        System.out.println("\n");
        System.out.println("\n");//adds space to make output cleaner
        System.out.println(hero.name + " has left the world to brun, everyone is dissapointed");
        gameEnd();
    }
  }

  private void enterZone1()//town were you can obtain an item to use to kill dragon
  {
    System.out.println("You have entered the town of Green Stock!");
    console.setImage("MainTown.png");//sets new console image
    System.out.println("\n");
    System.out.println("As you enter you get strange looks from the towns people.");
    System.out.println("You think to yourself these people have see some terrible things");
    System.out.println("As you walk deeper into the town you are greeted with an old man");
    System.out.println("\n");
    System.out.println("A) Speak to old man?");// choices A
    System.out.println("B) Ignore the old man");// choices B
    System.out.println("C) Puch and run away");// choices C
    System.out.println("\n");
    String input = inScanner.nextLine();//starts user input
    
    if(input.equals("A") || input.equals("a")){
     System.out.println("The old man gives you a warm smile and gives you a shiny sword");
     System.out.println("\n");
     hero.gold = hero.gold+10; //gives player gold for choosing best choice
     hasSword = true;//set boolean variable to true so the player can progress
     enterZone2();//enters zone two
    }
    else if(input.equals("B") || input.equals("b")){
        System.out.println("Before you have time to walk away the old man gives you a shiny sword saying nothing");
        System.out.println("\n");
        hasSword = true;//set boolean variable to true so the player can progress
        enterZone2();//enters zone two
    }
    else if(input.equals("C") || input.equals("c")){
    console.setImage("pig.png");
    System.out.println("You serious? the old man says");
    System.out.println("little do you know the old man is a magic wizzard who turns u into a pig the moment you swing your arm.");
    System.out.println("You idiot");
    hero.health = 0;//sets players health to 0
    System.out.println("Player Health: "+ hero.health);//displayes players health
    gameEnd();//ends game
    }
    
  }

  private void enterZone2()
  {
    console.setImage("mountains.png");//changes image
    System.out.println("As you look at the sword you notice something interesting");
    System.out.println("Upon looking at the sword you see coordinate to a mountain near by.");
    System.out.println("You decide to pay this place a visit");
    System.out.println("As you come to the base of the mountain");
    System.out.println("There you meet a gnome that offers you to play game.");
    System.out.println("\n");
    System.out.println("A) play game");// choices A
    System.out.println("B) ignore");// choices B
    System.out.println("\n");
    String input = inScanner.nextLine();// starts user input
    
    if(hasSword !=false && input.equals("A") || input.equals("a")){ //checks responses if they fit a certain condition
    enterZone3();//enter next zone
    hero.gold = hero.gold+10;// adds gold to player
    }
    
    if(input.equals("B") || input.equals("b")){//wrong hocie resulting is endGame() function to be called
     console.setImage("death.jpg");
      int number = (int)(Math.random()*3)+1;//generates a random number, this will choose a random print message to display
      if(number == 1){
        System.out.println("The gnome laughs at you and everyone is sad"); //random message 1
        gameEnd();
        }
        
      if(number == 2){
        System.out.println("The gnome turns into a suitcase and flys away"); //random message 2
        gameEnd();
        
        }
        
      if(number == 3){
        System.out.println("you made the little guy upset...look whta you have done"); //random message 3
        gameEnd();
        }   
    }
  }

  private void enterZone3()
  {
    System.out.println("After passing the gnome you enter a cave");
    System.out.println("This place looks very scary");
    System.out.println("Its not to late to back out...");
    System.out.println("A) Proceed");
    System.out.println("B) Leave");
    System.out.println("\n");
    String input = inScanner.nextLine();//starts user input
    
    if(input.equals("A")|| input.equals("a")){ //checks for specific condition
        enterZone4();// enters next zone
    }
    else{
    console.setImage("death.jpg");//changes iage
    System.out.println("You are a little coward...");
    hero.health = 0; //sets player health to 0
    System.out.println("Player Health: "+ hero.health);//prints players health
    gameEnd();//ends game
    }
    
  }

  private void enterZone4()
  {
    console.setImage("dragon.png");// changes console image
    System.out.println("You find the Fire Dragon sound asleep");
    System.out.println("As you walk closer the dragon awakes...");
    System.out.println("A) Use Slash attack");//choice A
    System.out.println("B) Use Throw Blade attack");//choice B
    System.out.println("C) RUN.....");//choice C
    String input = inScanner.nextLine();//begin user input
    System.out.println("\n");
    
    if(input.equals("A") || input.equals("a")){ //checks for specific condition to be met (bad answer)
        console.setImage("death.jpg");//changes image
        System.out.println("Attack ineffective...!!!");
        System.out.println("You get burnt to a crisp");
        hero.health = 0;//sets player health to 0
        System.out.println("Player Health: "+ hero.health);//prints player health
        gameEnd();// ends game
    }
    
    if(input.equals("B") || input.equals("b")){//checks for specific condition to be met (Good answer)
        console.setImage("treasure.png");//changes image
        System.out.println("Your attack kills the dragon instantly!!");
        System.out.println("You have saved the world");
        System.out.println("After killing the dragon you find the treasure it was guarding, hurray your rich!");
        hero.gold = hero.gold+100;//add gold to player
        System.out.println("You have collected " + hero.gold +" gold, nice.");//prints gold amount
        System.out.println("Thanks for playing");
        gameEnd();//ends game
    }
    
    if(input.equals("C") || input.equals("c")){//checks for specific condition to be met (bad answer)
        console.setImage("death.jpg");//changes image
        System.out.println("Really???");
        hero.health = 0;//sets player health to 0
        System.out.println("Player Health: "+ hero.health);//prints players health
        gameEnd();//ends game
    }
  }

  private void gameEnd()//function that ends the game on call.
  {
    System.out.println("The game is over.");//prints the game is over

    inScanner.close();//closes user input
  }
}