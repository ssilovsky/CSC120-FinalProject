import java.util.ArrayList;

public class PlayableChar {
    private final String name;
    private int maxHP;
    private int HP;

    private int EXP;
    private int level;

    private int attack;
    private int defense;

    private ArrayList<String> inventory;
    private int locationX;
    private int locationY;
    
   //Combat battleAction;

    /**
     * 
     * @param name
     * @param maxHP
     * @param attack
     * @param defense
     */
    public PlayableChar(String name, int maxHP, int attack, int defense){
        this.name = name;
        this.maxHP = 100;
        this.HP = maxHP;
        this.attack = attack;
        this.defense = defense;
        this.level = 1;
        this.EXP = 0;
        this.inventory = new ArrayList<String>();
        this.locationX = 0;
        this.locationY = 0;
        
    }

    public void goNorth(){
        this.locationY += 1;
    }

    public void goSouth(){
        this.locationY -= 1;
    }

    public void goEast(){
        this.locationX += 1;
    }

    public void goWest(){
        this.locationX -= 1;
    }


    public ArrayList<String> getInventory(){
        return this.inventory;
    }

    /**
     * 
     * @param dmg
     */
    private void decreaseHealth(int dmg){
        if(this.HP - dmg/this.defense < 0){
            this.HP = 0;
        }
        else{
            this.HP -= dmg/this.defense;
        }
    }

    /**
     * 
     * @param amount
     */
    private void increaseHealth(int amount){
        if(this.HP + amount > this.maxHP){
            this.HP = this.maxHP;
        }
        else{
            this.HP += amount;
        }
    }  

    private void increaseEXP(int amtEXP){
        this.EXP += amtEXP;
        if(this.EXP >= 10) {
            this.level += 1;
        }
    }

    //public void examineItem(String){

    //}

    /**
     * pick up method
     * @param item
     */
    public void addToInventory(String item){
        this.inventory.add(item);
    }

    /**
     * drop item method
     * @param item
     */
    public void removeFromInventory(String item){
        this.inventory.remove(item);
    }
    
    /***
     * 10 EXP -> LVL 1
     *  exp level*2
     * 
     * @return
     */

    /**
     * accessor + mutators
     */

    public String getName(){
        return this.name;
    }

    public int getHealth(){
        return this.HP;
    }   

    public int getAttack(){
        return this.attack;
    }

    public int getDefense(){
        return this.defense;
    }

    public int getLevel(){
        return this.level;
    }

    //inventory infinite

    //public void setCombat(BattleAction chosenAction){
    //    battleAction = chosenAction;
    //}
    
}


/**
 * Once merged, make new branch to work on
 */

 