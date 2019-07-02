package com.mihov.georgi.possiblegame.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mihov.georgi.possiblegame.PossibleGame;

public class Enemy extends GameObject {

    public Enemy(PossibleGame possibleGame, World physicsWorld, Texture appearance, float x, float y, float width, float height) {
        super(possibleGame, physicsWorld, appearance, x, y, width, height);
    }

    @Override
    protected void initbody() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(getX(),getY());
        bodyDef.type = BodyDef.BodyType.StaticBody;

        body = getPhysicsWorld().createBody(bodyDef);

        PolygonShape bodyShape = new PolygonShape();
        bodyShape.setAsBox(getWidth() / 2,getHeight() / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = bodyShape;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0f;
        fixtureDef.restitution = 0f;

        body.createFixture(fixtureDef);
        body.setUserData(this);

        bodyShape.dispose();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
