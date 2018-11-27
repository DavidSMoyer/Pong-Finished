/**
 * TODO (132): Fill out an appropriate assignment comment block
 * 
 * Name: David Scott Moyer
 * Teacher: Scott Hardman
 * Class: Software Development
 * Date: 26/11/2018
 */


import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayField extends World
{
    //TODO (1): Declare a boolean instance variable called startGame that is initialized to false
    private boolean startGame = false;
    
    //TODO (2): Declare a Ball instance variable called theBall
    private Ball theBall;
    
    //TODO (3): Declare a Score instance variable called player1Score
    private Score player1Score;
    
    //TODO (4): Declare a Score instance variable called player2Score
    private Score player2Score;
    
    /**
     * TODO (5): Declare a default constructor for PlayField
     *  
     * TODO (6): Use the superclass' constructor to create a world
     *           with 800 by 600 cells with a cell size of 1x1 pixels
     *           
     * TODO (15): Make a method call to the initializePlayingField method
     */
    
    /**
     * The constructor for the world. Sets the size of the world and initializes everything.
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    public PlayField()
    {
        super(800,600,1);
        initializePlayingField();
    }
    
    /**
     * TODO (7): Declare a method called initializePlayingField that
     *           does not return anything and has no parameters
     * 
     * TODO (8): Set the color of the background of the world to BLACK
     * 
     * TODO (9): Fill a rectangle on the background starting at (0,0) and having a width of the width of the world and a height of the height of the world
     * 
     * TODO (10): Set the color of the background to GRAY (You may change this later)
     * 
     * TODO (11): Fill a rectangle on the background starting at (halfway across the screen, 0) and having a width of 4 and a height of the height of the world
     * 
     * TODO (14): Make a method call to addPlayersAndObjects
     * 
     * TODO (12): Show text stating that the player should "press the space bar to begin play" at an x location of 200 and a y location of 550
     */
    
    /**
     * Initializes the background, filling it black and creating a grey line. Along with text telling the user to press space.
     * It then triggers a method to create the objects.
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    private void initializePlayingField()
    {
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        getBackground().setColor(Color.GRAY);
        getBackground().fillRect(getWidth()/2,0,4,getHeight());
        showText("Press the space bar to begin.",200,550);
        addPlayersAndObjects();
    }
    
    /**
     * TODO (13): Declare a method called addPlayersAndObjects that
     *           does not return anything and has no parameters
     *
     * TODO (54): Initialize the theBall variable to a new Ball object
     * 
     * TODO (40): Initialize the player1Score variable to a new Score object with an appropriate parameter value
     * 
     * TODO (41): Initialize the player2Score variable to a new Score object with an appropriate parameter value
     * 
     * TODO (55): Add the theBall object in the middle of the world
     * 
     * TODO (124): Add a new Paddle for player one using an appropriate parameter value at a x location of 10 and a y location of the middle of the height of the world
     * 
     * TODO (125): Add a new Paddle for player two using an appropriate parameter value at a x location of 10 pixels less than the width of the world and a y location of the middle of the height of the world
     * 
     * TODO (42): Add the player1Score object at an x location of 200 and a y location of 50
     * 
     * TODO (43): Add the player2Score object at an x location of 200 pixels less than the width of the world and a y location of 50
     */
    
    /**
     * Adds the players and the scores, as well as the ball.
     * 
     * @param None There are no parameters.
     * @Return Returns nothing.
     */
    private void addPlayersAndObjects()
    {
        theBall = new Ball();
        player1Score = new Score(true);
        player2Score = new Score(false);
        addObject(theBall,getWidth()/2,getHeight()/2);
        addObject(new Paddle(true),10,getHeight()/2);
        addObject(new Paddle(false),getWidth()-10,getHeight()/2);
        addObject(player1Score,200,50);
        addObject(player2Score,getWidth()-200,50);
    }
    
    /**
     * TODO (61): Declare the act method for the PlayField class
     * 
     * TODO (62): If the game has not started...
     * 
     *      TODO (63): Use a method to check if the space bar key has been pressed 
     * 
     * TODO (80): Otherwise...
     * 
     *      TODO (81): Use a method to check if a player has won
     */
    
    /**
     * Runs every time 'run' or 'act' is called.
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    public void act()
    {
        if (startGame == false)
        {
            checkKeyPress();
        }
        checkWin();
    }
    
    /**
     * TODO (56): Declare a method called checkKeyPress that does not
     *          return anything and has no parameters
     *          
     * TODO (57): Inside the method, you need to check if the space key has been pressed
     * 
     *      TODO (58): If the space bar has been pressed, the game has now started. Change the variable that stores that info
     *      
     *      TODO (59): Remove the text that tells the player to press the space bar to begin. You can do this by displaying an empty string, "", at the same location
     *      
     *      TODO (60): Set the velocity of theBall to be 5 pixels
     */
    
    /**
     * Checks to see if space is pressed to start the game.
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("space") == true)
        {
            startGame = true;
            showText("",200,550);
            theBall.setVelocity(5);
        }
    }
    /**
     * TODO (64): Declare a public method called reset that does not return
     *            anything and has no parameters
     *            
     * TODO (65): Set the theBall variable to a new Ball object
     * 
     * TODO (66): Add theBall in the middle of the world
     * 
     * TODO (67): Set the velocity of theBall to 0
     * 
     * TODO (68): Use the show text method to display that the user should Press the space bar to begin at an x location of 200 and a y location of 550
     * 
     * TODO (69): Set the startGame variable to false
     */
    
    /**
     * Resets the game, creating a new ball and waiting for the player to press space.
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    public void reset()
    {
        theBall = new Ball();
        addObject(theBall,getWidth()/2,getHeight()/2);
        theBall.setVelocity(0);
        showText("Press the space bar to begin.",200,550);
        startGame = false;
    }
    /**
     * TODO (70): Declare a method called checkWin that does not
     *            return anything and has no parameters
     *          
     * TODO (71): Declare a local GreenfootImage variable called player1Win that
     *            is initialized to a new GreenfootImage object with "Player 1 Wins!" as the text, 
     *            45 as the font size, player one's color as the text color, and BLACK as the background color
     *          
     * TODO (72): Declare a local GreenfootImage variable called player2Win that
     *            is initialized to a new GreenfootImage object with "Player 2 Wins!" as the text, 
     *            45 as the font size, player two's color as the text color, and BLACK as the background color
     *          
     * TODO (73): Declare a local integer variable called player1Total that is 
     *            initialized to the score of player one's scoreboard (use the getScore method)
     *          
     * TODO (74): Declare a local integer variable called player2Total that is
     *            initialized to the score of player two's scoreboard
     *          
     * TODO (75): The game is won if one of the players has a score of 7 or more. Write two conditional statements that will check this, one for each player
     * 
     *      TODO (76): In both conditional statements from the previous TODO, remove all objects (use null as the parameter for the removeObjects method) 
     *                 (This actually doesn't work and gives you a java.lang.NullPointerException error)
     *      
     *      TODO (77): In both conditional statements, set the color of the background to BLACK
     *      
     *      TODO (78): In both conditional statements, fill a rectangle on the background that starts at (0,0) and has a width of the width of the world and a height of the height of the world
     *      
     *      TODO (79): In both conditional statements, draw an image on the background that will show which player won in the exact center of the world (you should have GreenfootImage variables for this)
     */
    
    /**
     * Checks to see if the players have more than 7 points. If they do it says the player that wins and ends the game.
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    private void checkWin()
    {
        GreenfootImage player1Win = new GreenfootImage("Player 1 wins!",45,Color.RED,Color.BLACK);
        GreenfootImage player2Win = new GreenfootImage("Player 2 wins!",45,Color.GREEN,Color.BLACK);
        int player1Total = player1Score.getScore();
        int player2Total = player2Score.getScore();
        if (player1Total >= 7)
        {
            removeObjects(getObjects(null));
            showText("",200,550);
            drawPlayerWin(1);
        }
        if (player2Total >= 7)
        {
            removeObjects(getObjects(null));
            showText("",200,550);
            drawPlayerWin(2);
        }
    }
    
    
    /**
     * Draws the win screen that displays which player won, with the matching color.
     * 
     * @param player The player that won.
     * @return Returns nothing.
     */
    private void drawPlayerWin(int player)
    {
        if (player == 1)
        {
            getBackground().setColor(Color.BLACK);
            getBackground().fill();
            GreenfootImage img = new GreenfootImage(300,100);
            img.setColor(Color.RED);
            img.fill();
            img.setColor(Color.BLACK);
            img.fillRect(10,10,280,80);
            GreenfootImage img2 = new GreenfootImage("Player 1 wins!",45,Color.RED,Color.BLACK);
            img.drawImage(img2,30,25);
            getBackground().drawImage(img,getWidth()/2-img.getWidth()/2,getHeight()/2-img.getHeight()/2);
        }
        else if (player == 2)
        {
            getBackground().setColor(Color.BLACK);
            getBackground().fill();
            GreenfootImage img = new GreenfootImage(300,100);
            img.setColor(Color.GREEN);
            img.fill();
            img.setColor(Color.BLACK);
            img.fillRect(10,10,280,80);
            GreenfootImage img2 = new GreenfootImage("Player 2 wins!",45,Color.GREEN,Color.BLACK);
            img.drawImage(img2,30,25);
            getBackground().drawImage(img,getWidth()/2-img.getWidth()/2,getHeight()/2-img.getHeight()/2);
        }
    }
    
    /**
     * TODO (16): Declare a public method called getStarted that returns
     *            a boolean and has no parameters
     *          
     * TODO (17): Inside the method, return the variable that states whether the game has started or not
     */
    
    /**
     * Returns if the game has started or not.
     * 
     * @param None There are no parameters.
     * @return Returns if the game has started or not.
     */
    public boolean getStarted()
    {
        return startGame;
    }
}
