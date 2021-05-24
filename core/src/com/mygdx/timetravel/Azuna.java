package com.mygdx.timetravel;

import com.badlogic.gdx.math.Vector2;

/*
-------------------------------------------------------------------------------------------------
测试用主角，工具人，用完就删。
 */
public class Azuna extends Player{


    public Azuna(float x,float y,Level level)
    {
        super(x,y,level);
        name = "Asuna";
        //属性
        strength = 5;
        agility = 20;
        intelligence = 20;
        init();
    }


    @Override
    public void eventLEFT(int relativeX, int relativeY, int absoluteX, int absoluteY) {
        float relativeXY = (float) Math.sqrt(relativeX*relativeX+relativeY*relativeY);
        float sin = relativeX/relativeXY;
        float cos = relativeY/relativeXY;
        float velX = BulletTest.speed * sin;
        float velY = BulletTest.speed * cos;
        shoot(velX,velY);
    }

    public void shoot(float x, float y)
    {
        if(curMP- BulletTest.MPConsume>0) {
            level.bulletTest[level.bulletTestCnt] = new BulletTest(getX()+width/2, getY()+height,level);
            level.bulletTest[level.bulletTestCnt].setVelocity(new Vector2(x, y));
            level.bulletTest[level.bulletTestCnt].setAcceleration(Constants.myGravatiy);
            level.bulletTestCnt++;
            loseMP(BulletTest.MPConsume);
        }

    }

    @Override
    public void eventQ() {
        Constants.myGravatiy = new Vector2(0,10);
    }

    @Override
    public void eventRight(int relativeX, int relativeY, int absoluteX, int absoluteY) {
        if(curMP- BulletTest.MPConsume*5>0) {
        level.bulletTest[level.bulletTestCnt] = new BulletTest((float)absoluteX, (float)absoluteY,this.level);
        level.bulletTest[level.bulletTestCnt].setAcceleration(Constants.myGravatiy);
        level.bulletTestCnt++;
            loseMP(BulletTest.MPConsume*5);
        }
    }
}
