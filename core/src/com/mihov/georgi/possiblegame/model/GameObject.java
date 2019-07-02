package com.mihov.georgi.possiblegame.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mihov.georgi.possiblegame.PossibleGame;

public abstract class GameObject extends Image {
    private PossibleGame possibleGame;
    private World physicsWorld;
    protected Body body;


    public GameObject(PossibleGame possibleGame, World physicsWorld, Texture appearance, float x, float y, float width, float height) {
        super(appearance);
        this.possibleGame = possibleGame;
        this.physicsWorld = physicsWorld;
        this.setX(x);
        this.setY(y);
        this.setOrigin(x,y);
        this.setWidth(width);
        this.setHeight(height);
        this.initbody();
    }

    protected abstract void initbody();

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public PossibleGame getPossibleGame() {
        return possibleGame;
    }

    public void setPossibleGame(PossibleGame possibleGame) {
        this.possibleGame = possibleGame;
    }

    public World getPhysicsWorld() {
        return physicsWorld;
    }

    public void setPhysicsWorld(World physicsWorld) {
        this.physicsWorld = physicsWorld;
    }
}
