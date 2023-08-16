

class Adventure {

  constructor (userWarrior) {
    var level = 0

    var Warrior = userWarrior
    var currentTurn = 1;
    var opponent = new Enemy(level, false)
  }


  fight() {
    var isOver = false
    while (!isOver()) {
      if (this.currentTurn === 1) {
        document.getElementById('usmesg').innerHTML = "What to you wish to do?"
        let command = this.myScanner.next();
        if (command.equals('attack')) {
          this.Warrior.attack(this.Opponent);
          this.currentTurn = 2;
        }
        if (command.equals('uselargepotion')) {
          this.Warrior.useLargePotion();
          this.currentTurn = 2;
        }
        if (command.equals('usesmallpotion')) {
          this.Warrior.useSmallPotion();
          this.currentTurn = 2;
        }
        if (command.equals('switchweapons')) {
          this.Warrior.switchWeapons();
          this.currentTurn = 2;
        }
        if (command.equals('checkdefeatedenemies')) {
          System.out.println(this.Warrior.getEnemiesDeafeted());
          System.out.println(this.Warrior.getBossesDefeated());
        }
      }
      if (this.currentTurn === 2) {
        if (this.Opponent.getEnHealth() > 0) {
          System.out.println('opponents turn');
          if (this.Opponent.getEnHealth() < this.Opponent.getTotalEnHealth() * 0.2 && this.Opponent.getEnPotions() > 0) {
            this.Opponent.usePotion();
            System.out.println(this.Opponent.getName() + ' just Healed');
            this.currentTurn = 1;
          } else {
            System.out.println('Opponent tries to attack');
            this.Opponent.attack(this.Warrior);
            this.currentTurn = 1;
          }
        } else {
          System.out.println('You won!');
          let dropChance = this.randomizer.nextInt(6);
          if (dropChance === 0) {
            let droppedWeapon = this.genWeapon();
            System.out.println('you found a ' + droppedWeapon.getName() + ' with ' + droppedWeapon.getAttackDamage() + ' damage and ' + droppedWeapon.getAccuracy() + 'accuracy. Equip?');
            let command = this.myScanner.next();
            if (command.equals('yes')) {
              System.out.print('What weapon do you want to drop?');
              let command2 = this.myScanner.next();
              if (command2.equals('stored')) {
                this.Warrior.equipStoredWeapon(droppedWeapon);
              }
              if (command2.equals('current')) {
                this.Warrior.equipCurrentWeapon(droppedWeapon);
              }
              this.currentTurn = 3;
            }
            if (command.equals('no')) {
              this.currentTurn = 3;
            }
          }
          if (dropChance === 1) {
            let droppedArmor = this.genArmor();
            System.out.println('you found a ' + droppedArmor.getType() + ' with ' + droppedArmor.getArmorRating() + ' armor. Equip?');
            let command = this.myScanner.next();
            if (command.equals('yes')) {
              this.Warrior.equipArmor(droppedArmor);
            }
            if (command.equals('no')) {
              this.currentTurn = 3;
            }
          }
          this.currentTurn = 3;
        }
      }
      if (this.currentTurn === 3) {
        System.out.print('What to you wish to do after your victory?');
        let command = this.myScanner.next();
        System.out.println(command);
        if (command.equals('switch')) {
          this.Warrior.switchWeapons();
          System.out.println('you switched to your ' + this.Warrior.getActiveWeaponName());
          this.currentTurn = 4;
        }
        if (command.equals('small')) {
          this.Warrior.useSmallPotion();
          this.currentTurn = 4;
        }
        if (command.equals('large')) {
          this.Warrior.useLargePotion();
          this.currentTurn = 4;
        }
        if (command.equals('checkarmor')) {
          System.out.println(this.Warrior.getArmor());
          this.currentTurn = 4;
        }
        if (command.equals('wepstats')) {
          System.out.println('Cuurent Weapon - ' + this.Warrior.getCurrentWeaponDamage());
          System.out.println('Stored Weapon - ' + this.Warrior.getStoredWeaponDamage());
          this.currentTurn = 4;
        }
        if (command.equals('level')) {
          System.out.println(this.proToLevel + ' ' + this.level);
          this.currentTurn = 4;
        }
        if (command.equals('moveon')) {
          System.out.println('finding new enemy');
          this.randomizer = new Random();
          this.typeRandomizer = this.randomizer.nextInt(3);
          if (this.typeRandomizer === 0) {
            this.Opponent = new Archer(this.isBoss);
            this.isBoss = false;
          }
          if (this.typeRandomizer === 1) {
            this.Opponent = new Bandit(this.isBoss);
            this.isBoss = false;
          }
          if (this.typeRandomizer === 2) {
            this.Opponent = new RogueKnight(this.isBoss);
            this.isBoss = false;
          }
          System.out.println(this.Opponent.getName() + ' ' + this.Opponent.getTotalEnHealth() + ' ' + this.Opponent.getEnArmor());
          this.currentTurn = 1;
        }
      }
      if (this.currentTurn === 4) {
        System.out.println('and?');
        this.currentTurn = 3;
      }
    }
    this.myScanner.close();
  }
  isOver() {
    return this.Warrior.checkIfAlive();
  }
  genWeapon() {
    return new weapon();
  }
  genArmor() {
    return new Armor();
  }
}
  Adventure.level = 0;
  Adventure.proToLevel = 0;
  Adventure.isBoss = false;
  Adventure.levelUp = () => {
    this.proToLevel++;
    if (this.proToLevel >= 10) {
      this.isBoss = true;
      this.level++;
      this.proToLevel = 0;
    }
  };
  Adventure.getLevel = () => {
    return this.level;
  };