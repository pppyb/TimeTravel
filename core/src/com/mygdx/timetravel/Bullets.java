package com.mygdx.timetravel;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Null;

public class Bullets extends AbstractGameObject{
    //子弹的图像
    Texture img;
    TextureRegion[][] frames;
    TextureRegion curFrame;
    //子弹被销毁
    Boolean isDestructed = false;

    int damage;

    public Bullets(float x,float y)
    {
        super(x,y);
    }
    public void update(float deltaTime,Level level) {
        if (isDestructed)
            return;
        stateTime += deltaTime;
        //update velocity
        velocity.x += acceleration.x;
        velocity.y += acceleration.y;
        //update position
        float xOffset = velocity.x * deltaTime;
        float yOffset = velocity.y * deltaTime;

        if(this.onCollisionWithMap(level,xOffset,0))
            this.destructed();
        else
            position.x += xOffset;

        if(this.onCollisionWithMap(level,0,yOffset))
            this.destructed();
        else
            position.y += yOffset;

        collideEnemy(level);
    }
    public void draw(Batch batch)
    {
        batch.draw(curFrame,this.getX(),this.getY());
    }
    public void destructed()
    {
        this.setAcceleration(new Vector2(0,0));
        this.setVelocity(new Vector2(0,0));
        this.setPosition(new Vector2(-10000,-10000));
        isDestructed = true;
    }
    public void collideEnemy(Level level)
    {
        for(int i = 0;i < level.testMonsterCnt;i++)
        {
            Rectangle r1 = new Rectangle(getX(),getY(),width,height);
            Rectangle r2 = new Rectangle(level.testMonster[i].getX(),level.testMonster[i].getY(),level.testMonster[i].width,level.testMonster[i].height);
            if(Intersector.overlaps(r1,r2)) {
                level.testMonster[i].loseHP(damage);
                this.destructed();
            }
        }
    }
}