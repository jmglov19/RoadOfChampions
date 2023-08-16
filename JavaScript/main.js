

var warrior = new User(0);
var enemy = new Enemy(0, false);
var response = null
var level = 0
var victories = 0
var boss =  false

function showAlert() {
    alert("Alert from JS file");
}

function yes(){
    response = yes
}

function no(){
    response = no
}

function newEnemy(level, boss) {
    if (victories % 10 == 0 && victories > 0){
        boss = true
    }
    enemy = new Enemy(level, boss); 

    document.getElementById('enemyStatsTitle').innerHTML = enemy.enName; 
    document.getElementById('enHealth').innerHTML = enemy.enHealth; 
    document.getElementById('enDamage').innerHTML = enemy.damage;
    document.getElementById('enArmor').innerHTML = enemy.enArmor;
    document.getElementById('enmesg').innerHTML = "New " + enemy.enName + " found!"
}

function createUser(){
    warrior = new User(1000);
    var health = document.getElementById("health");
    document.getElementById('usmesg').innerHTML = "New warrior has enterned the path"
    level = 0
    victories = 0
    health.value = warrior.health;
    loadStats(warrior);
}

function useLargePotion(){
    var potLargeUse = warrior.useLargePotion();
    if (potLargeUse){
    health.value += 450
    if(health.value > 1000){
        health.value = 1000
    }
    document.getElementById('usmesg').innerHTML = "Large potion used"
    runGame(warrior, enemy)
    loadStats(warrior)
    }
    else{
        document.getElementById('usmesg').innerHTML = "You don't have any large potions left"
    }
}

function useSmallPotion(){
    var potSmallUse = warrior.useSmallPotion();
    if (potSmallUse){

    health.value += 150
    if(health.value > 1000){
        health.value = 1000
    }
    document.getElementById('usmesg').innerHTML = "Small potion used"
    runGame(warrior, enemy)
    loadStats(warrior);
    }
    else{
    document.getElementById('usmesg').innerHTML = "You don't have any small potions left"
    }
}

function switchWeapons(){
    warrior.switchWeapons();
    document.getElementById('usmesg').innerHTML = "weapons were swapped"
    runGame(warrior, enemy)
    loadStats(warrior);
}

function takeDamage(){
    
    var dmg = warrior.takeDamage(enemy.damage);   
    health.value -= dmg 
    if (dmg > 0){
        document.getElementById('enmesg').innerHTML = enemy.enName + " hit you for " + dmg
    }
    else{
        document.getElementById('enmesg').innerHTML = enemy.enName + " had no effect"

    }
    loadStats(warrior);
}

function attack(){
    var attdmg = warrior.attack(enemy);
    document.getElementById('usmesg').innerHTML = "You hit for " + attdmg
    runGame(warrior, enemy)
    loadEnStats(enemy)
}

/*function newWeapon(){
    var ranGen = Math.floor(Math.random() * 3);
    var genWeapon = new Weapon(ranGen, 0);
    warrior.CurrentWeapon = genWeapon;
    loadStats(warrior)
}
*/
function newWeapon(){
    var ranGen = Math.floor(Math.random() * 3);
    var genWeapon = new Weapon(ranGen, level);
    return genWeapon
}

function newArmor(){
    var ranGen = Math.floor(Math.random() * 4)
    var genArmor = new Armor(ranGen, level)
    return genArmor
}

function loadEnStats(enemy){
    document.getElementById('enemyStatsTitle').innerHTML = enemy.enName; 
    document.getElementById('enHealth').innerHTML = enemy.enHealth; 
    document.getElementById('enDamage').innerHTML = enemy.damage;
    document.getElementById('enArmor').innerHTML = enemy.enArmor;
}

function runGame(warrior, enemy){
    console.log("attack1")
    if (enemy.enHealth <= 0){
        victories += 1
        console.log("Dead")
        document.getElementById('usmesg').innerHTML = "You defeated " + enemy.enName
        var ranGen = Math.floor(Math.random() * 2)
        console.log(ranGen)
        if (ranGen == 0){
            droppedWeapon = newWeapon()
            document.getElementById('usmesg').innerHTML = "You found a " + droppedWeapon.type + " with " + droppedWeapon.attackDamage
            //if (response == yes){
                warrior.CurrentWeapon = droppedWeapon
            //
            
            

        }
        if (ranGen == 1){
            foundArmor = newArmor()
            document.getElementById('usmesg').innerHTML = "You found a " + foundArmor.type + " with " + foundArmor.armorRating
            
            //warrior.equiptedArmor[0] = foundArmor
                if(foundArmor.type == "Helmet") {
                    warrior.equiptedArmor[0] = foundArmor;
                }
                if(foundArmor.type == "Chestplate") {
                    warrior.equiptedArmor[1] = foundArmor;
                }
                if(foundArmor.type == "Leggings") {
                    warrior.equiptedArmor[2] = foundArmor;
                }
                if(foundArmor.type == "Boots") {
                    warrior.equiptedArmor[3] = foundArmor;
                }
            //console.log("equiped Armor" + droppedArmor.type + droppedArmor.armorRating + " : " + warrior.equiptedArmor[droppedArmor.type].armorRating)   
            
        }
        console.log(warrior.getArmor())
        checklevel()
        loadStats(warrior)
        newEnemy(level)
        
    }
    else{
    takeDamage();
    }

}

function equipArmor(foundArmor) {
    if(foundArmor.getType().equals("Helmet")) {
        this.equiptedArmor[0] = foundArmor;
    }
    if(foundArmor.getType().equals("Chestplate")) {
        this.equiptedArmor[1] = foundArmor;
    }
    if(foundArmor.getType().equals("Leggings")) {
        this.equiptedArmor[2] = foundArmor;
    }
    if(foundArmor.getType().equals("Boots")) {
        this.equiptedArmor[3] = foundArmor;
    }
}


function loadStats(warrior){

    document.getElementById('health').innerHTML = warrior.health;
    document.getElementById('helArm').innerHTML = warrior.getHelmetArmor();
    document.getElementById('chestArm').innerHTML = warrior.getChestArmor();
    document.getElementById('legArm').innerHTML = warrior.getLeggingArmor();
    document.getElementById('bootArm').innerHTML = warrior.getBootsArmor();
    document.getElementById('total').innerHTML = warrior.getArmor();
    
    document.getElementById('large').innerHTML = warrior.largePotions;
    document.getElementById('small').innerHTML = warrior.smallPotions;

    document.getElementById('current').innerHTML = warrior.CurrentWeapon.type;
    document.getElementById('curDam').innerHTML = warrior.CurrentWeapon.attackDamage;

    document.getElementById('stored').innerHTML = warrior.StoredWeapon.type;
    document.getElementById('storDam').innerHTML = warrior.StoredWeapon.attackDamage; 
    

}

function checklevel(){
    level = Math.floor(victories / 5)
    
    console.log("Level" + level + boss)
}
