package com.mihov.georgi.possiblegame.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mihov.georgi.possiblegame.PossibleGame;

public class Player extends GameObject {
    private int jumpCounter = 3;

    public Player(PossibleGame possibleGame, World physicsWorld, Texture appearance, float x, float y, float width, float height) {
        super(possibleGame, physicsWorld, appearance, x, y, width, height);
    }

    @Override
    protected void initbody() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(getX(),getY());
        bodyDef.type = BodyDef.BodyType.DynamicBody;

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
        body.setLinearVelocity(7f,0);

        bodyShape.dispose();
    }

    @Override
    public void act(float delta) {
        this.setPosition(body.getPosition().x - getWidth() / 2,body.getPosition().y - getHeight() / 2);
        this.setRotation(body.getAngle() * MathUtils.radiansToDegrees);

        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            body.applyAngularImpulse(5f,true);
        }
    }

    public void jump() {
        body.setLinearVelocity(body.getLinearVelocity().x,0);
        body.applyForceToCenter(0, 250f, true);
        jumpCounter--;
    }

    public void die() {
        getPossibleGame().gameState = PossibleGame.GAME_STATE.MENU;
    }

    public int getJumpCounter() {
        return jumpCounter;
    }

    public void resetJumpCounter() {
        this.jumpCounter = 3;
    }
}
