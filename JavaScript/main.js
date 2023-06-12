

var warrior = new User(0);
var enemy = new Enemy(0, false);

function showAlert() {
    alert("Alert from JS file");
}

function newEnemy() {
    enemy = new Enemy(0, false); 
    document.getElementById('enemyStatsTitle').innerHTML = enemy.enName; 
    document.getElementById('enHealth').innerHTML = enemy.enHealth; 
    document.getElementById('enDamage').innerHTML = enemy.damage;
    document.getElementById('enArmor').innerHTML = enemy.enArmor;
}

function createUser(){
    warrior = new User(1000);
    loadStats(warrior);
}

function useLargePotion(){
    warrior.useLargePotion();
    loadStats(warrior)
}

function useSmallPotion(){
    warrior.useSmallPotion();
    loadStats(warrior);
}

function switchWeapons(){
    warrior.switchWeapons();
    loadStats(warrior);
}

function takeDamage(){
    warrior.takeDamage(enemy.damage);
    loadStats(warrior);
}

function attack(){
    warrior.attack(enemy);
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

function loadStats(warrior){

    document.getElementById('userstats').innerHTML = warrior.health;
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

