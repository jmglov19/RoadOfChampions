

var warrior = new User(0);
var enemy = new Enemy(0, false);

function showAlert() {
    alert("Alert from JS file");
}

function newEnemy() {
    enemy = new Enemy(3, false); 
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

function newWeapon(){
    var ranGen = Math.floor(Math.random() * 3);
    var genWeapon = new Weapon(ranGen, 0);
    warrior.CurrentWeapon = genWeapon;
    loadStats(warrior)
}

function loadEnStats(enemy){
    document.getElementById('enemyStatsTitle').innerHTML = enemy.enName; 
    document.getElementById('enHealth').innerHTML = enemy.enHealth; 
    document.getElementById('enDamage').innerHTML = enemy.damage;
    document.getElementById('enArmor').innerHTML = enemy.enArmor;
}

function runGame(warrior, enemy){
    takeDamage();

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

