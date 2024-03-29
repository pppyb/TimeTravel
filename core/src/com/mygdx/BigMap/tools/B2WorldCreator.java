package com.mygdx.BigMap.tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.BigMap.otherActor.*;
import com.mygdx.BigMap.Door.*;
import com.mygdx.BigMap.MyGdxGame;

public class B2WorldCreator {
    public B2WorldCreator(World world, TiledMap map){
        BodyDef bedef=new BodyDef();
        PolygonShape shape=new PolygonShape();
        FixtureDef fdef=new FixtureDef();
        Body body;
        //边界碰撞检测
        for(MapObject object :map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect=((RectangleMapObject) object ).getRectangle();
            bedef.type=BodyDef.BodyType.StaticBody;
            bedef.position.set((rect.getX()+rect.getWidth()/2)/ MyGdxGame.PPM,(rect.getY()+rect.getHeight()/2)/MyGdxGame.PPM);
            body=world.createBody(bedef);
            shape.setAsBox(rect.getWidth()/2/MyGdxGame.PPM,rect.getHeight()/2/MyGdxGame.PPM);
            fdef.shape=shape;
            body.createFixture(fdef);
        }
        //房子碰撞检测
        for(MapObject object :map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect=((RectangleMapObject) object ).getRectangle();
            bedef.type=BodyDef.BodyType.StaticBody;
            bedef.position.set((rect.getX()+rect.getWidth()/2)/ MyGdxGame.PPM,(rect.getY()+rect.getHeight()/2)/MyGdxGame.PPM);
            body=world.createBody(bedef);
            shape.setAsBox(rect.getWidth()/2/MyGdxGame.PPM,rect.getHeight()/2/MyGdxGame.PPM);
            fdef.shape=shape;
            body.createFixture(fdef);
        }
        //修理工碰撞检测
        for(MapObject object :map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect=((RectangleMapObject) object ).getRectangle();
            new RepairmanObject(world,map,rect);
        }
        //武器室门
        for(MapObject object :map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect=((RectangleMapObject) object ).getRectangle();
            new weaponRoomDoor(world,map,rect);
        }
        //能源室门
        for(MapObject object :map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect=((RectangleMapObject) object ).getRectangle();
            new powerRoomDoor(world,map,rect);
        }
        //民居门
        for(MapObject object :map.getLayers().get(7).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect=((RectangleMapObject) object ).getRectangle();
            new repairmanHomeDoor(world,map,rect);
        }
        //赌场门
        for(MapObject object :map.getLayers().get(8).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect=((RectangleMapObject) object ).getRectangle();
            new gambleRoomDoor(world,map,rect);
        }
        //障碍消失碰撞检测
        for(MapObject object :map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect=((RectangleMapObject) object ).getRectangle();
            new Brick(world,map,rect);
        }
        //火焰地图门
            for (MapObject object : map.getLayers().get(9).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                new Portal(world, map, rect);
            }
        //火焰小地图门
            for (MapObject object : map.getLayers().get(10).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                new FireBossDoor(world, map, rect);
        }
        //雪小地图门
        for (MapObject object : map.getLayers().get(11).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new SnowBossDoor(world, map, rect);
        }
        //雪房间门
        for (MapObject object : map.getLayers().get(12).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new SnowRoomDoor(world, map, rect);
        }
        //草地小地图门
        for (MapObject object : map.getLayers().get(13).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new GrassMapDoor(world, map, rect);
        }
        //火房间门
        for (MapObject object : map.getLayers().get(14).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new FireMapRoomDoor(world, map, rect);
        }
        //草房间门
        for (MapObject object : map.getLayers().get(15).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new GrassRoomDoor(world, map, rect);
        }
    }

}
